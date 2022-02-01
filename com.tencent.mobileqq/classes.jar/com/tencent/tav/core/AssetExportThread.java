package com.tencent.tav.core;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AssetExportThread
  extends HandlerThread
  implements Handler.Callback
{
  private static final String TAG = "AssetExportThread";
  private static final int msg_done_a = 2;
  private static final int msg_done_v = 1;
  private AssetReader assetReader;
  private AssetWriter assetWriter;
  private HandlerThread audioExportThread;
  private AudioInfo audioInfo;
  private AudioMix audioMix;
  private boolean audioReadFinish = false;
  private AssetReaderOutput audioReader;
  private long audioTime = 0L;
  private AssetWriterInput audioWriter;
  private volatile boolean audioWriterDone = false;
  @Nullable
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private volatile boolean cancel = false;
  private MediaSyncClock clock;
  private final ExportConfig encodeOption;
  private Handler exportHandler;
  private AssetExportSession exportSession;
  private boolean isFinishing;
  private RenderContextParams renderContextParams;
  @Nullable
  private ExportReportSession reportSession = new ExportReportSession();
  private HandlerThread videoExportThread;
  private boolean videoReadFinish = false;
  private AssetReaderOutput videoReader;
  private long videoTime = 0L;
  private AssetWriterInput videoWriter;
  private volatile boolean videoWriterDone = false;
  
  AssetExportThread(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix paramAudioMix, ExportConfig paramExportConfig)
  {
    super(localStringBuilder.toString());
    this.exportSession = paramAssetExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.audioInfo = new AudioInfo(paramExportConfig.getAudioSampleRateHz(), paramExportConfig.getAudioChannelCount(), 2);
    this.encodeOption = paramExportConfig;
    this.clock = new MediaSyncClock(paramExportConfig.enableAVSync);
  }
  
  private void appendErrorMsg(ExportErrorStatus paramExportErrorStatus)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel:");
    localStringBuilder.append(isCancel());
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("exportSession.status:");
    localStringBuilder.append(this.exportSession.status);
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoWriterDone:");
    localStringBuilder.append(this.videoWriterDone);
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioWriterDone:");
    localStringBuilder.append(this.audioWriterDone);
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoReadFinish:");
    localStringBuilder.append(this.videoReadFinish);
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("audioReadFinish:");
    localStringBuilder.append(this.audioReadFinish);
    paramExportErrorStatus.appendMsg(localStringBuilder.toString());
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if (localObject != null)
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null, this.exportSession.isAudioRevertMode());
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      return localObject;
    }
    return new EmptyReaderOutput();
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    return new AssetWriterInput(2, this.encodeOption);
  }
  
  private AssetReaderOutput createVideoTrackOutput()
  {
    Object localObject = this.exportSession.asset.tracksWithMediaType(1);
    if (localObject != null)
    {
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("frame-rate", Integer.valueOf(this.encodeOption.getVideoFrameRate()));
      localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.videoCompositing);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
      return localObject;
    }
    return new EmptyReaderOutput();
  }
  
  private AssetWriterInput createVideoWriterInput()
  {
    ExportReportSession localExportReportSession = this.reportSession;
    if (localExportReportSession != null) {
      localExportReportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
    }
    return new AssetWriterInput(1, this.encodeOption);
  }
  
  private void exportError(int paramInt, Throwable paramThrowable)
  {
    try
    {
      exportError(new ExportErrorStatus(paramInt, paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private void exportError(ExportErrorStatus paramExportErrorStatus)
  {
    try
    {
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus1 = getStatus();
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus2 = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
      if (localAssetExportSessionStatus1 == localAssetExportSessionStatus2) {
        return;
      }
      if (getStatus() != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
      {
        appendErrorMsg(paramExportErrorStatus);
        setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed);
        setCancel(true);
        this.clock.close();
        this.exportSession.exportErrorStatus = paramExportErrorStatus;
        if (this.reportSession != null) {
          this.reportSession.onExportError();
        }
        handlerCallback();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void exportSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 363	com/tencent/tav/core/AssetExportThread:getStatus	()Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   8: getstatic 396	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   11: if_acmpne +8 -> 19
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 106	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   23: fconst_1
    //   24: putfield 400	com/tencent/tav/core/AssetExportSession:progress	F
    //   27: aload_0
    //   28: getstatic 396	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   31: invokespecial 377	com/tencent/tav/core/AssetExportThread:setStatus	(Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 104	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   40: ifnull +10 -> 50
    //   43: aload_0
    //   44: getfield 104	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   47: invokevirtual 403	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   50: aload_0
    //   51: invokespecial 393	com/tencent/tav/core/AssetExportThread:handlerCallback	()V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	AssetExportThread
    //   57	4	1	localObject1	Object
    //   62	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	57	finally
    //   19	36	57	finally
    //   58	60	57	finally
    //   2	4	62	finally
    //   36	50	62	finally
    //   50	54	62	finally
    //   60	62	62	finally
  }
  
  @RequiresApi(api=18)
  private void exporting()
  {
    if (isCancel()) {
      return;
    }
    initReaderAndWriter();
    if (isCancel()) {
      return;
    }
    setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting);
    this.videoExportThread = new HandlerThread("VideoWriter");
    this.videoWriter.setWriterProgressListener(new AssetExportThread.VideoWriterProgressListener(this, null));
    this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new AssetExportThread.VideoRequestMediaDataCallback(this, null));
    if (this.audioWriter != null)
    {
      this.audioExportThread = new HandlerThread("AudioWriter");
      this.audioWriter.setWriterProgressListener(new AssetExportThread.AudioWriterProgressListener(this, null));
      this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AssetExportThread.AudioRequestMediaDataCallback(this, null));
      return;
    }
    this.audioReadFinish = true;
    this.audioWriterDone = true;
  }
  
  private void finish()
  {
    new Handler(this.videoExportThread.getLooper()).post(new AssetExportThread.1(this));
  }
  
  private long getDuration()
  {
    Object localObject = this.exportSession;
    if ((localObject != null) && (((AssetExportSession)localObject).timeRange != null)) {
      return this.exportSession.timeRange.getDuration().getTimeUs() * 2L;
    }
    localObject = this.audioReader;
    long l2 = 0L;
    long l1;
    if (localObject != null) {
      l1 = ((AssetReaderOutput)localObject).duration();
    } else {
      l1 = 0L;
    }
    localObject = this.videoReader;
    if (localObject != null) {
      l2 = ((AssetReaderOutput)localObject).duration();
    }
    return l1 + l2;
  }
  
  private AssetExportSession.AssetExportSessionStatus getStatus()
  {
    try
    {
      AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = this.exportSession.status;
      return localAssetExportSessionStatus;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void handlerCallback()
  {
    try
    {
      if (this.callbackHandler != null) {
        this.callbackHandler.handlerCallback(this.exportSession);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @RequiresApi(api=18)
  private void initReaderAndWriter()
  {
    this.assetReader = new AssetReader(this.exportSession.asset);
    this.assetReader.setTimeRange(this.exportSession.timeRange);
    this.videoReader = createVideoTrackOutput();
    this.audioReader = createAudioTrackOutput();
    if (this.assetReader.canAddOutput(this.videoReader)) {
      this.assetReader.addOutput(this.videoReader);
    }
    if (this.assetReader.canAddOutput(this.audioReader)) {
      this.assetReader.addOutput(this.audioReader);
    }
    this.assetWriter = new AssetWriter(this.exportSession.outputFilePath, this.exportSession.outputFileType);
    this.assetWriter.setRenderContextParams(this.renderContextParams);
    if (this.exportSession.timeRange != null)
    {
      this.assetWriter.startSessionAtSourceTime(this.exportSession.timeRange.getStart());
      this.assetWriter.endSessionAtSourceTime(this.exportSession.timeRange.getEnd());
      ExportReportSession localExportReportSession = this.reportSession;
      if (localExportReportSession != null) {
        localExportReportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
      }
    }
    this.assetWriter.setEncodeOption(this.encodeOption);
    this.videoWriter = createVideoWriterInput();
    this.audioWriter = createAudioWriterInput();
    if (this.assetWriter.canAddInput(this.videoWriter)) {
      this.assetWriter.addInput(this.videoWriter);
    }
    if (this.assetWriter.canAddInput(this.audioWriter)) {
      this.assetWriter.addInput(this.audioWriter);
    }
    this.assetWriter.startWriting(this.exportSession.videoEncoder, this.exportSession.muxerCreator);
    this.assetReader.startReading(this.assetWriter);
  }
  
  private boolean isCancel()
  {
    try
    {
      boolean bool = this.cancel;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void notifyProgress()
  {
    long l = getDuration();
    if (l != 0L) {
      this.exportSession.progress = ((float)(this.videoTime + this.audioTime) * 1.0F / (float)l);
    }
    if (getStatus() != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
    {
      if (getStatus() == AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled) {
        return;
      }
      handlerCallback();
    }
  }
  
  private void setCancel(boolean paramBoolean)
  {
    try
    {
      this.cancel = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void setStatus(AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus)
  {
    try
    {
      this.exportSession.status = paramAssetExportSessionStatus;
      return;
    }
    finally
    {
      paramAssetExportSessionStatus = finally;
      throw paramAssetExportSessionStatus;
    }
  }
  
  void cancel()
  {
    try
    {
      setStatus(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled);
      setCancel(true);
      this.clock.close();
      handlerCallback();
      this.callbackHandler = null;
      if (this.reportSession != null)
      {
        this.reportSession.reset();
        this.reportSession = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2)) {
      return true;
    }
    if (this.isFinishing) {
      return true;
    }
    if (isCancel())
    {
      this.isFinishing = true;
      finish();
    }
    if ((this.videoWriterDone) && (this.audioWriterDone) && (this.audioReadFinish) && (this.videoReadFinish))
    {
      this.isFinishing = true;
      finish();
    }
    return true;
  }
  
  void removeCallback()
  {
    try
    {
      this.callbackHandler = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    AssetWriter localAssetWriter = this.assetWriter;
    if (localAssetWriter != null) {
      localAssetWriter.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  void startExport()
  {
    try
    {
      start();
      setCancel(false);
      if (this.reportSession != null) {
        this.reportSession.onExportStart(System.nanoTime());
      }
      this.exportHandler = new Handler(getLooper(), this);
      this.exportHandler.post(new AssetExportThread.2(this));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread
 * JD-Core Version:    0.7.0.1
 */
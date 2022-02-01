package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
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
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private volatile boolean cancel = false;
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
    super("ExportThread");
    this.exportSession = paramAssetExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.audioInfo = new AudioInfo(paramExportConfig.getAudioSampleRateHz(), paramExportConfig.getAudioChannelCount(), 2);
    this.encodeOption = paramExportConfig;
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if (localObject != null)
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null);
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      return localObject;
    }
    return new EmptyReaderOutput();
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    return new AssetWriterInput(2);
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
    if (this.reportSession != null) {
      this.reportSession.setFramePerSecond(this.encodeOption.getVideoFrameRate());
    }
    return new AssetWriterInput(1);
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
    if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
    {
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
      this.exportSession.exportErrorStatus = paramExportErrorStatus;
      if (this.reportSession != null) {
        this.reportSession.onExportError();
      }
      if (this.callbackHandler != null) {
        this.callbackHandler.handlerCallback(this.exportSession);
      }
    }
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
    //   5: getfield 85	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   8: getfield 297	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   11: getstatic 318	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   14: if_acmpne +8 -> 22
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 85	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   26: fconst_1
    //   27: putfield 322	com/tencent/tav/core/AssetExportSession:progress	F
    //   30: aload_0
    //   31: getfield 85	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   34: getstatic 318	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   37: putfield 297	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 83	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 83	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   53: invokevirtual 325	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   56: aload_0
    //   57: getfield 87	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   60: ifnull -41 -> 19
    //   63: aload_0
    //   64: getfield 87	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   67: aload_0
    //   68: getfield 85	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   71: invokeinterface 315 2 0
    //   76: goto -57 -> 19
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	AssetExportThread
    //   79	4	1	localObject1	Object
    //   84	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	4	79	finally
    //   42	56	79	finally
    //   56	76	79	finally
    //   87	89	79	finally
    //   4	19	84	finally
    //   22	42	84	finally
    //   85	87	84	finally
  }
  
  @RequiresApi(api=18)
  private void exporting()
  {
    initReaderAndWriter();
    this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting;
    this.videoExportThread = new HandlerThread("VideoWriter");
    this.videoWriter.setWriterProgressListener(new AssetExportThread.VideoWriterProgressListener(this, null));
    this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new AssetExportThread.VideoRequestMediaDataCallback(this, null));
    this.audioExportThread = new HandlerThread("VideoWriter");
    this.audioWriter.setWriterProgressListener(new AssetExportThread.AudioWriterProgressListener(this, null));
    this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AssetExportThread.AudioRequestMediaDataCallback(this, null));
  }
  
  private void finish()
  {
    new Handler(this.videoExportThread.getLooper()).post(new AssetExportThread.1(this));
  }
  
  private long getDuration()
  {
    long l2 = 0L;
    if ((this.exportSession != null) && (this.exportSession.timeRange != null)) {
      return this.exportSession.timeRange.getDuration().getTimeUs() * 2L;
    }
    if (this.audioReader != null) {}
    for (long l1 = this.audioReader.duration();; l1 = 0L)
    {
      if (this.videoReader != null) {
        l2 = this.videoReader.duration();
      }
      return l1 + l2;
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
      if (this.reportSession != null) {
        this.reportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
      }
    }
    this.assetWriter.setEncodeOption(this.encodeOption);
    this.videoWriter = createVideoWriterInput();
    this.audioWriter = createAudioWriterInput();
    if (this.assetWriter.canAddInput(this.videoWriter))
    {
      Matrix localMatrix = null;
      if (this.exportSession.appliesPreferredTrackTransform) {
        localMatrix = DecoderUtils.getPreferMatrix(new CGSize(this.encodeOption.getOutputWidth(), this.encodeOption.getOutputHeight()), this.exportSession.asset.getNaturalSize(), this.exportSession.asset.getPreferRotation());
      }
      this.videoWriter.setTransform(localMatrix);
      this.assetWriter.addInput(this.videoWriter);
    }
    if (this.assetWriter.canAddInput(this.audioWriter)) {
      this.assetWriter.addInput(this.audioWriter);
    }
    this.assetWriter.startWriting();
    this.assetReader.startReading(this.assetWriter);
  }
  
  void cancel()
  {
    try
    {
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
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
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.isFinishing);
      if (this.cancel)
      {
        this.isFinishing = true;
        finish();
      }
    } while ((!this.videoWriterDone) || (!this.audioWriterDone) || (!this.audioReadFinish) || (!this.videoReadFinish));
    this.isFinishing = true;
    finish();
    return true;
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    if (this.assetWriter != null) {
      this.assetWriter.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  void startExport()
  {
    start();
    this.cancel = false;
    if (this.reportSession != null) {
      this.reportSession.onExportStart(System.nanoTime());
    }
    this.exportHandler = new Handler(getLooper(), this);
    this.exportHandler.post(new AssetExportThread.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread
 * JD-Core Version:    0.7.0.1
 */
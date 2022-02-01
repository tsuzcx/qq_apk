package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetWriterInput
{
  private static final String TAG = "AssetWriterInput";
  private AssetWriter assetWriter;
  private Handler handler;
  private HandlerThread handlerThread;
  Filter matrixFilter;
  private int mediaType;
  private List<MetadataItem> metadata;
  private Map<String, Object> outputSettings = new HashMap();
  private AssetWriterInput.WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private boolean started = false;
  private AssetWriterInput.StatusListener statusListener;
  private boolean stop = false;
  private Matrix transform;
  private EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt, @NonNull Map<String, Object> paramMap)
  {
    this.mediaType = paramInt;
    this.outputSettings.putAll(paramMap);
  }
  
  private ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    boolean bool = paramCMSampleBuffer.getTime().smallThan(CMTime.CMTimeZero);
    Object localObject = paramCMSampleBuffer;
    if (!bool)
    {
      localObject = ByteBuffer.allocate(paramCMSampleBuffer.getSampleByteBuffer().limit());
      ((ByteBuffer)localObject).order(paramCMSampleBuffer.getSampleByteBuffer().order());
      ((ByteBuffer)localObject).put(paramCMSampleBuffer.getSampleByteBuffer());
      ((ByteBuffer)localObject).flip();
      localObject = new CMSampleBuffer(paramCMSampleBuffer.getTime(), (ByteBuffer)localObject);
    }
    this.writerHandler.post(new AssetWriterInput.WriterAudioRunnable(this, (CMSampleBuffer)localObject, bool, null));
    return null;
  }
  
  /* Error */
  private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 147	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   4: invokevirtual 153	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   7: invokevirtual 158	com/tencent/tav/decoder/RenderContext:makeCurrent	()V
    //   10: fconst_0
    //   11: fconst_0
    //   12: fconst_0
    //   13: fconst_1
    //   14: invokestatic 164	android/opengl/GLES20:glClearColor	(FFFF)V
    //   17: sipush 16640
    //   20: invokestatic 168	android/opengl/GLES20:glClear	(I)V
    //   23: aload_1
    //   24: ifnull +166 -> 190
    //   27: aload_1
    //   28: invokevirtual 87	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   31: invokevirtual 172	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   34: lconst_0
    //   35: lcmp
    //   36: iflt +154 -> 190
    //   39: ldc 8
    //   41: new 174	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   48: ldc 177
    //   50: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 87	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   57: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 194	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokespecial 198	com/tencent/tav/core/AssetWriterInput:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 147	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   77: invokevirtual 153	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   80: aload_1
    //   81: invokevirtual 87	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   84: invokevirtual 172	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   87: invokevirtual 202	com/tencent/tav/decoder/RenderContext:setPresentationTime	(J)V
    //   90: aload_0
    //   91: getfield 147	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   94: invokevirtual 153	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   97: invokevirtual 206	com/tencent/tav/decoder/RenderContext:swapBuffers	()Z
    //   100: pop
    //   101: ldc 8
    //   103: new 174	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   110: ldc 208
    //   112: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 87	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   119: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 194	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 131	com/tencent/tav/core/AssetWriterInput:writerHandler	Landroid/os/Handler;
    //   132: new 210	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable
    //   135: dup
    //   136: aload_0
    //   137: aload_1
    //   138: aconst_null
    //   139: invokespecial 213	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable:<init>	(Lcom/tencent/tav/core/AssetWriterInput;Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/core/AssetWriterInput$1;)V
    //   142: invokevirtual 142	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   145: pop
    //   146: aload_2
    //   147: areturn
    //   148: astore_1
    //   149: new 215	com/tencent/tav/core/ExportErrorStatus
    //   152: dup
    //   153: bipush 145
    //   155: aload_1
    //   156: invokespecial 218	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   159: areturn
    //   160: astore_2
    //   161: new 215	com/tencent/tav/core/ExportErrorStatus
    //   164: dup
    //   165: bipush 144
    //   167: aload_2
    //   168: invokespecial 218	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   171: astore_2
    //   172: goto -99 -> 73
    //   175: astore_2
    //   176: new 215	com/tencent/tav/core/ExportErrorStatus
    //   179: dup
    //   180: bipush 143
    //   182: aload_2
    //   183: invokespecial 218	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   186: astore_2
    //   187: goto -86 -> 101
    //   190: aconst_null
    //   191: astore_2
    //   192: goto -64 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	AssetWriterInput
    //   0	195	1	paramCMSampleBuffer	CMSampleBuffer
    //   72	75	2	localExportErrorStatus1	ExportErrorStatus
    //   160	8	2	localException1	Exception
    //   171	1	2	localExportErrorStatus2	ExportErrorStatus
    //   175	8	2	localException2	Exception
    //   186	6	2	localExportErrorStatus3	ExportErrorStatus
    // Exception table:
    //   from	to	target	type
    //   0	10	148	java/lang/Exception
    //   66	71	160	java/lang/Exception
    //   73	101	175	java/lang/Exception
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    if (paramCMSampleBuffer != null)
    {
      if (this.matrixFilter == null)
      {
        this.matrixFilter = new Filter();
        this.matrixFilter.setRendererWidth(this.assetWriter.renderContext().width());
        this.matrixFilter.setRendererHeight(this.assetWriter.renderContext().height());
      }
      this.matrixFilter.applyFilter(paramCMSampleBuffer, this.transform, paramCMSampleBuffer.getTextureMatrix());
    }
  }
  
  void addStatusListener(AssetWriterInput.StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  public ExportErrorStatus appendSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    if (!this.stop) {
      try
      {
        if ((this.mediaType == 1) && (this.assetWriter.renderContext() != null)) {
          return appendVideoSampleBuffer(paramCMSampleBuffer);
        }
        if (this.mediaType == 2)
        {
          paramCMSampleBuffer = appendAudioSampleBuffer(paramCMSampleBuffer);
          return paramCMSampleBuffer;
        }
      }
      catch (Throwable paramCMSampleBuffer)
      {
        Logger.e("AssetWriterInput", "appendSampleBuffer: error", paramCMSampleBuffer);
        if (this.statusListener != null) {
          this.statusListener.statusChanged(this, AssetWriter.AssetWriterStatus.AssetWriterStatusFailed);
        }
        return new ExportErrorStatus(-110, paramCMSampleBuffer);
      }
    }
    return new ExportErrorStatus(-11);
  }
  
  public void close()
  {
    try
    {
      if (this.handlerThread != null)
      {
        this.readyForMoreMediaData = false;
        this.handlerThread.quit();
        this.handlerThread = null;
        this.handler = null;
      }
      if (this.writerThread != null)
      {
        this.writerHandler.removeCallbacks(null);
        this.writerThread.quit();
        this.writerThread = null;
        this.writerHandler = null;
      }
      return;
    }
    finally {}
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public List<MetadataItem> getMetadata()
  {
    return this.metadata;
  }
  
  void initConfig(AssetWriter paramAssetWriter)
  {
    this.assetWriter = paramAssetWriter;
    this.writer = paramAssetWriter.encoderWriter();
    if (this.mediaType == 1)
    {
      localOutputConfig = new EncoderWriter.OutputConfig();
      if ((!this.outputSettings.containsKey("width")) || (!this.outputSettings.containsKey("height"))) {
        throw new IllegalArgumentException("width and height must > 0");
      }
      localOutputConfig.VIDEO_TARGET_WIDTH = ((Integer)this.outputSettings.get("width")).intValue();
      localOutputConfig.VIDEO_TARGET_HEIGHT = ((Integer)this.outputSettings.get("height")).intValue();
      if (this.outputSettings.containsKey("frame-rate"))
      {
        paramAssetWriter = this.outputSettings.get("frame-rate");
        localOutputConfig.VIDEO_FRAME_RATE = ((Integer)paramAssetWriter).intValue();
        if (!this.outputSettings.containsKey("bitrate")) {
          break label271;
        }
        paramAssetWriter = this.outputSettings.get("bitrate");
        label181:
        localOutputConfig.VIDEO_BIT_RATE = ((Integer)paramAssetWriter).intValue();
        if (!this.outputSettings.containsKey("i-frame-interval")) {
          break label281;
        }
      }
      label271:
      label281:
      for (paramAssetWriter = this.outputSettings.get("i-frame-interval");; paramAssetWriter = Integer.valueOf(1))
      {
        localOutputConfig.VIDEO_IFRAME_INTERVAL = ((Integer)paramAssetWriter).intValue();
        localOutputConfig.HIGH_PROFILE = ((Boolean)this.outputSettings.get("HIGH_PROFILE")).booleanValue();
        this.writer.outputVideoEncoderConfig(localOutputConfig);
        return;
        paramAssetWriter = Integer.valueOf(30);
        break;
        paramAssetWriter = Integer.valueOf(8000000);
        break label181;
      }
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    if (this.outputSettings.containsKey("aac-profile"))
    {
      paramAssetWriter = this.outputSettings.get("aac-profile");
      localOutputConfig.AUDIO_AAC_PROFILE = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("bitrate")) {
        break label506;
      }
      paramAssetWriter = this.outputSettings.get("bitrate");
      label364:
      localOutputConfig.AUDIO_BIT_RATE = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("channel-count")) {
        break label516;
      }
      paramAssetWriter = this.outputSettings.get("channel-count");
      label403:
      localOutputConfig.AUDIO_CHANNEL_COUNT = ((Integer)paramAssetWriter).intValue();
      if (!this.outputSettings.containsKey("mime")) {
        break label524;
      }
      paramAssetWriter = (String)this.outputSettings.get("mime");
      label445:
      localOutputConfig.AUDIO_MIME_TYPE = paramAssetWriter;
      if (!this.outputSettings.containsKey("sample-rate")) {
        break label531;
      }
    }
    label516:
    label524:
    label531:
    for (paramAssetWriter = this.outputSettings.get("sample-rate");; paramAssetWriter = Integer.valueOf(44100))
    {
      localOutputConfig.AUDIO_SAMPLE_RATE_HZ = ((Integer)paramAssetWriter).intValue();
      this.writer.outputAudioEncoderConfig(localOutputConfig);
      return;
      paramAssetWriter = Integer.valueOf(2);
      break;
      label506:
      paramAssetWriter = Integer.valueOf(128000);
      break label364;
      paramAssetWriter = Integer.valueOf(1);
      break label403;
      paramAssetWriter = "audio/mp4a-latm";
      break label445;
    }
  }
  
  public boolean isReadyForMoreMediaData()
  {
    if (this.readyForMoreMediaData) {
      if (this.mediaType == 1)
      {
        if (!this.writer.videoTrackWritable()) {}
      }
      else {
        while (this.writer.audioTrackWritable()) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void markAsFinished()
  {
    this.writerHandler.post(new AssetWriterInput.2(this));
  }
  
  public void requestMediaDataWhenReadyOnQueue(HandlerThread paramHandlerThread, Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        if (this.handler != null)
        {
          Log.e("AssetWriterInput", "正在处理上一次的request请求，无法重复发起");
          return;
        }
        if (this.assetWriter == null)
        {
          Log.e("AssetWriterInput", "还没有与AssetWriter关联，无法发起request请求");
          continue;
        }
        this.handlerThread = paramHandlerThread;
      }
      finally {}
      paramHandlerThread.start();
      this.handler = new Handler(paramHandlerThread.getLooper());
      this.handler.post(new AssetWriterInput.1(this, paramRunnable));
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
    }
  }
  
  public void setMetadata(List<MetadataItem> paramList)
  {
    this.metadata = paramList;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
  
  void setWriterProgressListener(AssetWriterInput.WriterProgressListener paramWriterProgressListener)
  {
    this.progressListener = paramWriterProgressListener;
  }
  
  @RequiresApi(api=18)
  boolean start()
  {
    if (this.started) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (this.mediaType != 1) {
          continue;
        }
        this.writer.startVideoEncoder();
        this.readyForMoreMediaData = true;
        this.started = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      return this.started;
      this.writer.startAudioEncoder();
    }
  }
  
  void stop()
  {
    this.stop = true;
    this.readyForMoreMediaData = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tav.core;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.List;

public class AssetWriterInput
{
  private static final String TAG = "AssetWriterInput";
  private AssetWriter assetWriter;
  private Handler handler;
  private HandlerThread handlerThread;
  Filter matrixFilter;
  private int mediaType;
  private List<MetadataItem> metadata;
  private AssetWriterInput.WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private boolean started = false;
  private AssetWriterInput.StatusListener statusListener;
  private boolean stop = false;
  private Matrix transform;
  private EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt)
  {
    this.mediaType = paramInt;
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
    //   1: getfield 129	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   4: invokevirtual 135	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   7: invokevirtual 140	com/tencent/tav/decoder/RenderContext:makeCurrent	()V
    //   10: fconst_0
    //   11: fconst_0
    //   12: fconst_0
    //   13: fconst_1
    //   14: invokestatic 146	android/opengl/GLES20:glClearColor	(FFFF)V
    //   17: sipush 16640
    //   20: invokestatic 149	android/opengl/GLES20:glClear	(I)V
    //   23: aload_1
    //   24: ifnull +166 -> 190
    //   27: aload_1
    //   28: invokevirtual 69	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   31: invokevirtual 153	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   34: lconst_0
    //   35: lcmp
    //   36: iflt +154 -> 190
    //   39: ldc 8
    //   41: new 155	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   48: ldc 158
    //   50: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 69	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   57: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 175	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokespecial 179	com/tencent/tav/core/AssetWriterInput:renderSampleBuffer	(Lcom/tencent/tav/coremedia/CMSampleBuffer;)V
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 129	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   77: invokevirtual 135	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   80: aload_1
    //   81: invokevirtual 69	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   84: invokevirtual 153	com/tencent/tav/coremedia/CMTime:getTimeUs	()J
    //   87: invokevirtual 183	com/tencent/tav/decoder/RenderContext:setPresentationTime	(J)V
    //   90: aload_0
    //   91: getfield 129	com/tencent/tav/core/AssetWriterInput:assetWriter	Lcom/tencent/tav/core/AssetWriter;
    //   94: invokevirtual 135	com/tencent/tav/core/AssetWriter:renderContext	()Lcom/tencent/tav/decoder/RenderContext;
    //   97: invokevirtual 187	com/tencent/tav/decoder/RenderContext:swapBuffers	()Z
    //   100: pop
    //   101: ldc 8
    //   103: new 155	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   110: ldc 189
    //   112: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 69	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   119: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 175	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 113	com/tencent/tav/core/AssetWriterInput:writerHandler	Landroid/os/Handler;
    //   132: new 191	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable
    //   135: dup
    //   136: aload_0
    //   137: aload_1
    //   138: aconst_null
    //   139: invokespecial 194	com/tencent/tav/core/AssetWriterInput$WriterVideoRunnable:<init>	(Lcom/tencent/tav/core/AssetWriterInput;Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/core/AssetWriterInput$1;)V
    //   142: invokevirtual 124	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   145: pop
    //   146: aload_2
    //   147: areturn
    //   148: astore_1
    //   149: new 196	com/tencent/tav/core/ExportErrorStatus
    //   152: dup
    //   153: bipush 145
    //   155: aload_1
    //   156: invokespecial 199	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   159: areturn
    //   160: astore_2
    //   161: new 196	com/tencent/tav/core/ExportErrorStatus
    //   164: dup
    //   165: bipush 144
    //   167: aload_2
    //   168: invokespecial 199	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
    //   171: astore_2
    //   172: goto -99 -> 73
    //   175: astore_2
    //   176: new 196	com/tencent/tav/core/ExportErrorStatus
    //   179: dup
    //   180: bipush 143
    //   182: aload_2
    //   183: invokespecial 199	com/tencent/tav/core/ExportErrorStatus:<init>	(ILjava/lang/Throwable;)V
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
  
  private void onStartError(Exception paramException, int paramInt)
  {
    if ((paramException instanceof ExportRuntimeException))
    {
      paramException = ((ExportRuntimeException)paramException).getErrorStatus();
      if (this.progressListener != null) {
        this.progressListener.onError(paramException);
      }
      return;
    }
    if (paramInt == 1) {}
    for (paramInt = -101;; paramInt = -102)
    {
      paramException = new ExportErrorStatus(paramInt, paramException);
      break;
    }
  }
  
  private void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    if (paramCMSampleBuffer != null)
    {
      RenderContext localRenderContext = this.assetWriter.renderContext();
      if (this.matrixFilter == null)
      {
        this.matrixFilter = new Filter();
        this.matrixFilter.setRendererWidth(localRenderContext.width());
        this.matrixFilter.setRendererHeight(localRenderContext.height());
      }
      localRenderContext.updateViewport(0, 0, localRenderContext.width(), localRenderContext.height());
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
          Logger.e("AssetWriterInput", "还没有与AssetWriter关联，无法发起request请求");
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
        Logger.e("AssetWriterInput", "start: ", localException);
        onStartError(localException, this.mediaType);
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
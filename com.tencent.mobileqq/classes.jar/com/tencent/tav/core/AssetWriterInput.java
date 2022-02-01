package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
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
      localObject = new CMSampleBuffer(paramCMSampleBuffer.getTime().sub(this.assetWriter.startTime), (ByteBuffer)localObject);
    }
    this.writerHandler.post(new AssetWriterInput.WriterAudioRunnable(this, (CMSampleBuffer)localObject, bool, null));
    return null;
  }
  
  private ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    try
    {
      this.assetWriter.renderContext().makeCurrent();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      ExportErrorStatus localExportErrorStatus2;
      if ((paramCMSampleBuffer != null) && (paramCMSampleBuffer.getTime().getTimeUs() >= 0L))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("appendSampleBuffer: start ");
        localStringBuilder1.append(paramCMSampleBuffer.getTime());
        Logger.v("AssetWriterInput", localStringBuilder1.toString());
        try
        {
          renderSampleBuffer(paramCMSampleBuffer);
          localStringBuilder1 = null;
        }
        catch (Exception localException1)
        {
          ExportErrorStatus localExportErrorStatus1 = new ExportErrorStatus(-112, localException1);
        }
        try
        {
          long l = paramCMSampleBuffer.getTime().sub(this.assetWriter.startTime).getTimeUs();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("setPresentationTime: ");
          localStringBuilder2.append(l);
          Logger.d("AssetWriterInput", localStringBuilder2.toString());
          this.assetWriter.renderContext().setPresentationTime(l);
          this.assetWriter.renderContext().swapBuffers();
        }
        catch (Exception localException2)
        {
          localExportErrorStatus2 = new ExportErrorStatus(-113, localException2);
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("appendSampleBuffer: end ");
        localStringBuilder2.append(paramCMSampleBuffer.getTime());
        Logger.v("AssetWriterInput", localStringBuilder2.toString());
      }
      else
      {
        localExportErrorStatus2 = null;
      }
      this.writerHandler.post(new AssetWriterInput.WriterVideoRunnable(this, paramCMSampleBuffer, null));
      return localExportErrorStatus2;
    }
    catch (Exception paramCMSampleBuffer) {}
    return new ExportErrorStatus(-111, paramCMSampleBuffer);
  }
  
  private void onStartError(Exception paramException, int paramInt)
  {
    if ((paramException instanceof ExportRuntimeException))
    {
      paramException = ((ExportRuntimeException)paramException).getErrorStatus();
    }
    else
    {
      if (paramInt == 1) {
        paramInt = -101;
      } else {
        paramInt = -102;
      }
      paramException = new ExportErrorStatus(paramInt, paramException);
    }
    AssetWriterInput.WriterProgressListener localWriterProgressListener = this.progressListener;
    if (localWriterProgressListener != null) {
      localWriterProgressListener.onError(paramException);
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
        AssetWriterInput.StatusListener localStatusListener = this.statusListener;
        if (localStatusListener != null) {
          localStatusListener.statusChanged(this, AssetWriter.AssetWriterStatus.AssetWriterStatusFailed);
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
        if (this.writer.videoTrackWritable()) {
          return true;
        }
      }
      else if (this.writer.audioTrackWritable()) {
        return true;
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
        return;
      }
      this.handlerThread = paramHandlerThread;
      paramHandlerThread.start();
      this.handler = new Handler(paramHandlerThread.getLooper());
      this.handler.post(new AssetWriterInput.1(this, paramRunnable));
      this.writerThread = new HandlerThread("writerThread");
      this.writerThread.start();
      this.writerHandler = new Handler(this.writerThread.getLooper());
      return;
    }
    finally {}
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
    try
    {
      if (this.mediaType == 1) {
        this.writer.startVideoEncoder();
      } else {
        this.writer.startAudioEncoder();
      }
      this.readyForMoreMediaData = true;
      this.started = true;
    }
    catch (Exception localException)
    {
      Logger.e("AssetWriterInput", "start: ", localException);
      onStartError(localException, this.mediaType);
    }
    return this.started;
  }
  
  void stop()
  {
    this.stop = true;
    this.readyForMoreMediaData = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */
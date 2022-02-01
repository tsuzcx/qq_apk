package com.tencent.tav.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RequiresApi;
import android.util.Log;
import com.tencent.tav.asset.MetadataItem;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class AssetWriterInput
{
  private static final String TAG = "AssetWriterInput";
  private AssetWriter assetWriter;
  private final ExportConfig exportConfig;
  private Handler handler;
  private HandlerThread handlerThread;
  final Filter matrixFilter = new Filter();
  private int mediaType;
  private List<MetadataItem> metadata;
  private AssetWriterInput.WriterProgressListener progressListener;
  private boolean readyForMoreMediaData;
  private boolean started = false;
  private AssetWriterInput.StatusListener statusListener;
  private boolean stop = false;
  private Matrix transform;
  EncoderWriter writer;
  private Handler writerHandler;
  private HandlerThread writerThread;
  
  public AssetWriterInput(int paramInt, ExportConfig paramExportConfig)
  {
    this.mediaType = paramInt;
    this.exportConfig = paramExportConfig;
  }
  
  @RequiresApi(api=18)
  private void doWriteAudio(CMSampleBuffer paramCMSampleBuffer, boolean paramBoolean)
  {
    if (this.handler == null) {
      return;
    }
    long l1 = -1L;
    if (paramBoolean) {}
    try
    {
      this.writer.endWriteAudioSample();
    }
    catch (Throwable paramCMSampleBuffer)
    {
      long l2;
      if (!(paramCMSampleBuffer instanceof ExportRuntimeException)) {
        break label78;
      }
      paramCMSampleBuffer = ((ExportRuntimeException)paramCMSampleBuffer).getErrorStatus();
      break label89;
      paramCMSampleBuffer = new ExportErrorStatus(-122, paramCMSampleBuffer);
      AssetWriterInput.WriterProgressListener localWriterProgressListener = this.progressListener;
      if (localWriterProgressListener == null) {
        break label109;
      }
      localWriterProgressListener.onError(paramCMSampleBuffer);
      return;
    }
    this.writer.writeAudioSample(paramCMSampleBuffer.getTime().getTimeUs(), paramCMSampleBuffer.getSampleByteBuffer());
    l2 = this.writer.getAudioPresentationTimeUs();
    l1 = l2;
    label78:
    label89:
    label109:
    paramCMSampleBuffer = this.progressListener;
    if (paramCMSampleBuffer != null) {
      paramCMSampleBuffer.onProgressChanged(this, l1);
    }
  }
  
  @RequiresApi(api=18)
  private void doWriteVideo(CMSampleBuffer paramCMSampleBuffer, TextureInfo paramTextureInfo)
  {
    if (this.handler == null) {
      return;
    }
    try
    {
      this.writer.writeVideoSample(paramCMSampleBuffer, paramTextureInfo);
      if (paramCMSampleBuffer != null) {
        if (paramCMSampleBuffer.getState().stateMatchingTo(new long[] { -1L })) {
          this.writer.endWriteVideoSample(paramCMSampleBuffer, paramTextureInfo);
        }
      }
    }
    catch (Throwable paramCMSampleBuffer)
    {
      if ((paramCMSampleBuffer instanceof ExportRuntimeException)) {
        paramCMSampleBuffer = ((ExportRuntimeException)paramCMSampleBuffer).getErrorStatus();
      } else {
        paramCMSampleBuffer = new ExportErrorStatus(-121, paramCMSampleBuffer);
      }
      paramTextureInfo = this.progressListener;
      if (paramTextureInfo != null)
      {
        paramTextureInfo.onError(paramCMSampleBuffer);
        return;
      }
    }
    paramCMSampleBuffer = this.progressListener;
    if (paramCMSampleBuffer != null) {
      paramCMSampleBuffer.onProgressChanged(this, this.writer.getVideoPresentationTimeUs());
    }
  }
  
  @Nullable
  private Matrix getStMatrix(TextureInfo paramTextureInfo)
  {
    paramTextureInfo = paramTextureInfo.getTextureMatrix();
    Matrix localMatrix = this.writer.getVideoEncoder().getFrameMatrix();
    if ((localMatrix != null) && (paramTextureInfo != null)) {
      paramTextureInfo.postConcat(localMatrix);
    }
    if (paramTextureInfo != null) {
      return paramTextureInfo;
    }
    return localMatrix;
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
  
  @RequiresApi(api=18)
  private TextureInfo renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    if (paramCMSampleBuffer != null)
    {
      Object localObject = this.assetWriter.renderContext();
      if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture())
      {
        this.matrixFilter.setRendererWidth(((RenderContext)localObject).width());
        this.matrixFilter.setRendererHeight(((RenderContext)localObject).height());
        this.matrixFilter.setRenderForScreen(false);
        ((RenderContext)localObject).updateViewport(0, 0, ((RenderContext)localObject).width(), ((RenderContext)localObject).height());
      }
      else
      {
        int i;
        int j;
        if (this.exportConfig.getOutputRotate() % 2 != 0)
        {
          i = ((RenderContext)localObject).height();
          j = ((RenderContext)localObject).width();
        }
        else
        {
          i = ((RenderContext)localObject).width();
          j = ((RenderContext)localObject).height();
        }
        this.matrixFilter.setRendererWidth(i);
        this.matrixFilter.setRendererHeight(j);
        this.matrixFilter.setRenderForScreen(true);
        ((RenderContext)localObject).updateViewport(0, 0, i, j);
        localObject = DecoderUtils.getRotationMatrix(this.exportConfig.getOutputRotate(), paramCMSampleBuffer.width, paramCMSampleBuffer.height);
        if (this.transform == null) {
          this.transform = new Matrix();
        }
        this.transform.postConcat((Matrix)localObject);
      }
      localObject = getStMatrix(paramCMSampleBuffer);
      return this.matrixFilter.applyFilter(paramCMSampleBuffer, this.transform, (Matrix)localObject);
    }
    return null;
  }
  
  void addStatusListener(AssetWriterInput.StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  ExportErrorStatus appendAudioSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
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
  
  @RequiresApi(api=18)
  ExportErrorStatus appendVideoSampleBuffer(CMSampleBuffer paramCMSampleBuffer)
  {
    try
    {
      this.assetWriter.renderContext().makeCurrent();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      Object localObject1;
      Object localObject3;
      if ((paramCMSampleBuffer != null) && (paramCMSampleBuffer.getTime().getTimeUs() >= 0L))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("appendSampleBuffer: start ");
        ((StringBuilder)localObject1).append(paramCMSampleBuffer.getTime());
        Logger.v("AssetWriterInput", ((StringBuilder)localObject1).toString());
        try
        {
          localObject1 = renderSampleBuffer(paramCMSampleBuffer);
          try
          {
            if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
              GLES20.glFinish();
            }
            Object localObject2 = null;
          }
          catch (Exception localException1) {}
          localExportErrorStatus = new ExportErrorStatus(-112, localException2);
        }
        catch (Exception localException2)
        {
          localObject1 = null;
        }
        try
        {
          ExportErrorStatus localExportErrorStatus;
          long l = paramCMSampleBuffer.getTime().sub(this.assetWriter.startTime).getTimeUs();
          if (this.writer.isVideoEncodeNeedVideoRenderOutputTexture()) {
            this.assetWriter.encoderWriter().getVideoEncoder().onOutputTextureUpdate((TextureInfo)localObject1, l);
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setPresentationTime: ");
          localStringBuilder.append(l);
          Logger.d("AssetWriterInput", localStringBuilder.toString());
          this.assetWriter.renderContext().setPresentationTime(l);
          this.assetWriter.renderContext().swapBuffers();
        }
        catch (Exception localException3)
        {
          localObject3 = new ExportErrorStatus(-113, localException3);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("appendSampleBuffer: end ");
        localStringBuilder.append(paramCMSampleBuffer.getTime());
        Logger.v("AssetWriterInput", localStringBuilder.toString());
      }
      else
      {
        localObject1 = null;
        localObject3 = localObject1;
      }
      this.writerHandler.post(new AssetWriterInput.WriterVideoRunnable(this, paramCMSampleBuffer, (TextureInfo)localObject1, null));
      return localObject3;
    }
    catch (Exception paramCMSampleBuffer) {}
    return new ExportErrorStatus(-111, paramCMSampleBuffer);
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
      paramHandlerThread = new StringBuilder();
      paramHandlerThread.append("writerThread-");
      paramHandlerThread.append(this.mediaType);
      paramHandlerThread.append("@");
      paramHandlerThread.append(Integer.toHexString(hashCode()));
      this.writerThread = new HandlerThread(paramHandlerThread.toString());
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
      if (this.mediaType == 1)
      {
        this.writer.startVideoEncoder();
        this.writer.setVideoSampleRenderContext(this.assetWriter.renderContext());
      }
      else
      {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.AssetWriterInput
 * JD-Core Version:    0.7.0.1
 */
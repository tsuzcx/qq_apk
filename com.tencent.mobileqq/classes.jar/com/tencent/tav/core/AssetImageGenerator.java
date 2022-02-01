package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class AssetImageGenerator
{
  private final String TAG = "AssetImageGenerator@" + Integer.toHexString(hashCode());
  private AssetImageGenerator.ApertureMode apertureMode;
  private boolean appliesPreferredTrackTransform;
  protected Asset asset;
  protected AssetExtension assetExtension;
  private boolean forceUseFbo = false;
  @NonNull
  private final AssetImageGenerator.ImageGeneratorThread generatorThread;
  private long generatorThreadId = -1L;
  @Nullable
  private CGSize maximumSize;
  private ByteBuffer outBitmapReaderBuffer;
  private String outSavePath;
  private AssetImageGenerator.OutputBitmapFactory outputBitmapFactory;
  private RenderContext renderContext;
  @Nullable
  private RenderContextParams renderContextParams;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private VideoCompositionDecoderTrack videoCompositionDecoderTrack;
  
  public AssetImageGenerator(Asset paramAsset)
  {
    this(paramAsset, new AssetExtension("thumbnail"));
  }
  
  public AssetImageGenerator(Asset paramAsset, AssetExtension paramAssetExtension)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.apertureMode = AssetImageGenerator.ApertureMode.aspectFit;
    this.generatorThread = new AssetImageGenerator.ImageGeneratorThread(this, "image_generator");
    this.generatorThread.start();
    AssetImageGenerator.ImageGeneratorThread.access$000(this.generatorThread);
  }
  
  @Nullable
  private Bitmap bitmapFromFBO(@NonNull RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (localTextureInfo == null) {
      return null;
    }
    Bitmap localBitmap = readBitmapFromTexture(paramRenderContext, localTextureInfo);
    paramRenderContext = getMatrix(this.maximumSize, new CGSize(localTextureInfo.width, localTextureInfo.height));
    paramCMSampleBuffer = new Matrix();
    paramCMSampleBuffer.postScale(1.0F, -1.0F);
    paramCMSampleBuffer.postTranslate(0.0F, localBitmap.getHeight());
    if (paramRenderContext != null)
    {
      paramRenderContext.postConcat(paramCMSampleBuffer);
      if (this.maximumSize == null) {
        break label122;
      }
    }
    label122:
    for (paramCMSampleBuffer = this.maximumSize;; paramCMSampleBuffer = new CGSize(localTextureInfo.width, localTextureInfo.height))
    {
      return Bitmap.createBitmap(localBitmap, 0, 0, (int)paramCMSampleBuffer.width, (int)paramCMSampleBuffer.height, paramRenderContext, true);
      paramRenderContext = paramCMSampleBuffer;
      break;
    }
  }
  
  @Nullable
  private Bitmap doGenerator(CMTime paramCMTime)
  {
    RenderContext localRenderContext = initRenderContext();
    paramCMTime = getCmSampleBuffer(paramCMTime, localRenderContext);
    if ((this.forceUseFbo) || (!localRenderContext.isPBufferEnable())) {
      return bitmapFromFBO(localRenderContext, paramCMTime);
    }
    return readBitmap(renderToMaximumSizeBox(localRenderContext, paramCMTime));
  }
  
  private void doRelease()
  {
    Logger.d(this.TAG, "doRelease: start, thread = " + Thread.currentThread().getName());
    if (this.videoCompositionDecoderTrack != null)
    {
      this.videoCompositionDecoderTrack.release();
      this.videoCompositionDecoderTrack = null;
    }
    if (this.videoCompositing != null)
    {
      this.videoCompositing.release();
      this.videoCompositing = null;
    }
    if (this.renderContext != null)
    {
      this.renderContext.release();
      this.renderContext = null;
    }
    this.videoComposition = null;
    Logger.d(this.TAG, "doRelease: end, thread = " + Thread.currentThread().getName());
  }
  
  private CMSampleBuffer getCmSampleBuffer(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    if (this.videoCompositionDecoderTrack == null)
    {
      this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
      localObject = this.asset.getTracks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if (localAssetTrack.getMediaType() == 1) {
          this.videoCompositionDecoderTrack.addTrack(localAssetTrack);
        }
      }
      this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
      if (this.videoComposition != null) {
        break label145;
      }
    }
    label145:
    for (Object localObject = null;; localObject = this.videoComposition.getCustomVideoCompositor())
    {
      this.videoCompositing = ((VideoCompositing)localObject);
      this.videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
      this.videoCompositionDecoderTrack.start(paramRenderContext);
      this.videoCompositionDecoderTrack.seekTo(paramCMTime, false, true);
      return this.videoCompositionDecoderTrack.readSample(paramCMTime);
    }
  }
  
  @Nullable
  private Matrix getMatrix(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    if ((paramCGSize1 == null) || (paramCGSize2 == null) || (this.apertureMode == null)) {
      return null;
    }
    paramCGSize2 = new CGRect(new PointF(), paramCGSize2);
    paramCGSize1 = new CGRect(new PointF(), paramCGSize1);
    switch (AssetImageGenerator.1.$SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode[this.apertureMode.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return CGMathFunctions.transformBySourceRectFit(paramCGSize2, paramCGSize1);
    case 2: 
      return CGMathFunctions.transformBySourceRectFill(paramCGSize2, paramCGSize1);
    }
    return CGMathFunctions.transformByScaleFitRect(paramCGSize2, paramCGSize1);
  }
  
  @NonNull
  private RenderContext initRenderContext()
  {
    this.generatorThreadId = Thread.currentThread().getId();
    if (this.renderContext == null) {
      if (this.maximumSize == null) {
        break label73;
      }
    }
    label73:
    for (CGSize localCGSize = this.maximumSize;; localCGSize = this.asset.getNaturalSize())
    {
      this.renderContext = new RenderContext((int)localCGSize.width, (int)localCGSize.height);
      this.renderContext.setParams(this.renderContextParams);
      this.renderContext.makeCurrent();
      return this.renderContext;
    }
  }
  
  @NonNull
  private Bitmap readBitmap(CGSize paramCGSize)
  {
    if (this.outputBitmapFactory == null) {
      this.outputBitmapFactory = new AssetImageGenerator.DefaultBitmapFactory(null);
    }
    paramCGSize = this.outputBitmapFactory.getOutputBitmap((int)paramCGSize.width, (int)paramCGSize.height);
    if ((paramCGSize.getConfig() != Bitmap.Config.ARGB_8888) && (paramCGSize.getConfig() != Bitmap.Config.ARGB_4444))
    {
      Log.e(this.TAG, "readBitmap: bitmap 格式错误：暂时只支持ARGB_8888、ARGB_4444格式");
      return paramCGSize;
    }
    int i = paramCGSize.getWidth() * paramCGSize.getHeight() * 4;
    if ((this.outBitmapReaderBuffer == null) || (this.outBitmapReaderBuffer.capacity() < i))
    {
      this.outBitmapReaderBuffer = ByteBuffer.allocateDirect(i);
      this.outBitmapReaderBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.outBitmapReaderBuffer.rewind();
      this.outBitmapReaderBuffer.clear();
    }
    GLES20.glReadPixels(0, 0, paramCGSize.getWidth(), paramCGSize.getHeight(), 6408, 5121, this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.rewind();
    paramCGSize.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.clear();
    return paramCGSize;
  }
  
  @NotNull
  private Bitmap readBitmapFromTexture(@NonNull RenderContext paramRenderContext, TextureInfo paramTextureInfo)
  {
    paramRenderContext.makeCurrent();
    paramRenderContext = new int[1];
    GLES20.glGenFramebuffers(1, paramRenderContext, 0);
    GLES20.glBindFramebuffer(36160, paramRenderContext[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramTextureInfo.width * paramTextureInfo.height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, paramTextureInfo.width, paramTextureInfo.height, 6408, 5121, localByteBuffer);
    paramTextureInfo = Bitmap.createBitmap(paramTextureInfo.width, paramTextureInfo.height, Bitmap.Config.ARGB_8888);
    localByteBuffer.rewind();
    paramTextureInfo.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, paramRenderContext, 0);
    return paramTextureInfo;
  }
  
  @NonNull
  private CGSize renderToMaximumSizeBox(RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (this.maximumSize != null) {}
    for (CGSize localCGSize = this.maximumSize;; localCGSize = new CGSize(localTextureInfo.width, localTextureInfo.height))
    {
      if (localTextureInfo != null)
      {
        Filter localFilter = new Filter();
        localFilter.setRendererWidth((int)localCGSize.width);
        localFilter.setRendererHeight((int)localCGSize.height);
        Matrix localMatrix1 = getMatrix(this.maximumSize, new CGSize(localTextureInfo.width, localTextureInfo.height));
        paramRenderContext.makeCurrent();
        Matrix localMatrix2 = new Matrix();
        localMatrix2.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
        localFilter.applyFilter(localTextureInfo, localMatrix1, localMatrix2);
        paramRenderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
        paramRenderContext.swapBuffers();
      }
      return localCGSize;
    }
  }
  
  public Bitmap copyCGImageAtTimeAndActualTime(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new Exception("cannot process in the main thread");
    }
    return doGenerator(paramCMTime1);
  }
  
  public void generateCGImagesAsynchronouslyForTimes(List<CMTime> paramList, AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
  {
    this.generatorThread.setRequestedTimes(paramList);
    this.generatorThread.setGeneratorListener(paramImageGeneratorListener);
    AssetImageGenerator.ImageGeneratorThread.access$100(this.generatorThread);
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  @Nullable
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public void release()
  {
    release(false);
  }
  
  public void release(boolean paramBoolean)
  {
    if (Thread.currentThread().getId() != this.generatorThreadId)
    {
      AssetImageGenerator.ImageGeneratorThread.access$200(this.generatorThread, paramBoolean);
      this.videoComposition = null;
      return;
    }
    doRelease();
    this.generatorThread.quit();
  }
  
  public void setApertureMode(AssetImageGenerator.ApertureMode paramApertureMode)
  {
    this.apertureMode = paramApertureMode;
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setForceUseFbo(boolean paramBoolean)
  {
    this.forceUseFbo = paramBoolean;
  }
  
  public void setMaximumSize(CGSize paramCGSize)
  {
    this.maximumSize = paramCGSize;
  }
  
  public void setOutSavePath(String paramString)
  {
    this.outSavePath = paramString;
  }
  
  public void setOutputBitmapFactory(AssetImageGenerator.OutputBitmapFactory paramOutputBitmapFactory)
  {
    this.outputBitmapFactory = paramOutputBitmapFactory;
  }
  
  public void setRenderContextParams(@Nullable RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator
 * JD-Core Version:    0.7.0.1
 */
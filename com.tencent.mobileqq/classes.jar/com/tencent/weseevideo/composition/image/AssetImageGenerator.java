package com.tencent.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
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
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.weseevideo.composition.TAVAutomaticTransRenderContext;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class AssetImageGenerator
{
  private final String TAG;
  private AssetImageGenerator.ApertureMode apertureMode;
  private boolean appliesPreferredTrackTransform;
  protected Asset asset;
  protected AssetExtension assetExtension;
  private EGLContext eglContext;
  private AssetImageGenerator.ImageGeneratorThread generatorThread;
  private long generatorThreadId;
  @Nullable
  private CGSize maximumSize;
  private Bitmap outBitmap;
  private ByteBuffer outBitmapReaderBuffer;
  private String outSavePath;
  private RenderContext renderContext;
  @Nullable
  private RenderContextParams renderContextParams;
  private Runnable runnable;
  private TAVAutomaticTransRenderContext transRenderContext;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private VideoCompositionDecoderTrack videoCompositionDecoderTrack;
  
  public AssetImageGenerator(Asset paramAsset)
  {
    this(paramAsset, new AssetExtension("thumbnail"));
  }
  
  public AssetImageGenerator(Asset paramAsset, AssetExtension paramAssetExtension)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssetImageGenerator@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.generatorThreadId = -1L;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.apertureMode = AssetImageGenerator.ApertureMode.aspectFit;
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
    if (paramRenderContext != null) {
      paramRenderContext.postConcat(paramCMSampleBuffer);
    } else {
      paramRenderContext = paramCMSampleBuffer;
    }
    paramCMSampleBuffer = this.maximumSize;
    if (paramCMSampleBuffer == null) {
      paramCMSampleBuffer = new CGSize(localTextureInfo.width, localTextureInfo.height);
    }
    return Bitmap.createBitmap(localBitmap, 0, 0, (int)paramCMSampleBuffer.width, (int)paramCMSampleBuffer.height, paramRenderContext, true);
  }
  
  @Nullable
  private Bitmap doGenerator(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    this.renderContext = initRenderContext(paramRenderContext);
    paramCMTime = getCmSampleBuffer(paramCMTime, this.renderContext);
    return bitmapFromFBO(this.renderContext, paramCMTime);
  }
  
  private void doRelease()
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRelease: start, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.videoCompositionDecoderTrack;
    if (localObject != null)
    {
      ((VideoCompositionDecoderTrack)localObject).release();
      this.videoCompositionDecoderTrack = null;
    }
    localObject = this.videoCompositing;
    if (localObject != null)
    {
      ((VideoCompositing)localObject).release();
      this.videoCompositing = null;
    }
    localObject = this.outBitmapReaderBuffer;
    if (localObject != null)
    {
      ((ByteBuffer)localObject).clear();
      this.outBitmapReaderBuffer = null;
    }
    BitmapUtils.recycle(this.outBitmap);
    this.videoComposition = null;
    localObject = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRelease: end, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
  }
  
  private CMSampleBuffer getCmSampleBuffer(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    if (this.videoCompositionDecoderTrack == null)
    {
      this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.asset, this.assetExtension, 1);
      Object localObject = this.asset.getTracks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if (localAssetTrack.getMediaType() == 1) {
          this.videoCompositionDecoderTrack.addTrack(localAssetTrack);
        }
      }
      this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
      localObject = this.videoComposition;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((VideoComposition)localObject).getCustomVideoCompositor();
      }
      this.videoCompositing = ((VideoCompositing)localObject);
      this.videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
      this.videoCompositionDecoderTrack.start(paramRenderContext);
    }
    this.videoCompositionDecoderTrack.seekTo(paramCMTime, false, true);
    return this.videoCompositionDecoderTrack.readSample(paramCMTime);
  }
  
  @Nullable
  private Matrix getMatrix(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    if ((paramCGSize1 != null) && (paramCGSize2 != null))
    {
      if (this.apertureMode == null) {
        return null;
      }
      paramCGSize2 = new CGRect(new PointF(), paramCGSize2);
      paramCGSize1 = new CGRect(new PointF(), paramCGSize1);
      int i = AssetImageGenerator.2.a[this.apertureMode.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return CGMathFunctions.transformByScaleFitRect(paramCGSize2, paramCGSize1);
        }
        return CGMathFunctions.transformBySourceRectFill(paramCGSize2, paramCGSize1);
      }
      return CGMathFunctions.transformBySourceRectFit(paramCGSize2, paramCGSize1);
    }
    return null;
  }
  
  @NonNull
  private RenderContext initRenderContext(RenderContext paramRenderContext)
  {
    CGSize localCGSize = this.maximumSize;
    if (localCGSize == null) {
      localCGSize = this.asset.getNaturalSize();
    }
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext == null)
    {
      if (paramRenderContext == null)
      {
        this.renderContext = new RenderContext((int)localCGSize.width, (int)localCGSize.height, null, this.eglContext);
      }
      else
      {
        this.renderContext = paramRenderContext;
        this.renderContext.setWidth((int)localCGSize.width);
        this.renderContext.setHeight((int)localCGSize.height);
      }
      this.renderContext.setParams(this.renderContextParams);
    }
    else
    {
      localRenderContext.setWidth((int)localCGSize.width);
      this.renderContext.setHeight((int)localCGSize.height);
    }
    this.renderContext.makeCurrent();
    return this.renderContext;
  }
  
  @NonNull
  private Bitmap readBitmap(CGSize paramCGSize)
  {
    int i = (int)paramCGSize.width * (int)paramCGSize.height * 4;
    Bitmap localBitmap = this.outBitmap;
    if ((localBitmap == null) || (localBitmap.getByteCount() != i))
    {
      BitmapUtils.recycle(this.outBitmap);
      this.outBitmap = Bitmap.createBitmap((int)paramCGSize.width, (int)paramCGSize.height, Bitmap.Config.ARGB_8888);
    }
    paramCGSize = this.outBitmapReaderBuffer;
    if ((paramCGSize == null) || (paramCGSize.capacity() < i))
    {
      this.outBitmapReaderBuffer = ByteBuffer.allocateDirect(i);
      this.outBitmapReaderBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.outBitmapReaderBuffer.rewind();
      this.outBitmapReaderBuffer.clear();
    }
    GLES20.glReadPixels(0, 0, this.outBitmap.getWidth(), this.outBitmap.getHeight(), 6408, 5121, this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.rewind();
    this.outBitmap.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.clear();
    return this.outBitmap;
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
  
  private void removeGenerateMessage()
  {
    AssetImageGenerator.ImageGeneratorThread localImageGeneratorThread = this.generatorThread;
    if ((localImageGeneratorThread != null) && (localImageGeneratorThread.getHandler() != null)) {
      this.generatorThread.getHandler().removeCallbacks(this.runnable);
    }
  }
  
  @NonNull
  private CGSize renderToMaximumSizeBox(RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    CGSize localCGSize = this.maximumSize;
    if (localCGSize == null) {
      localCGSize = new CGSize(localTextureInfo.width, localTextureInfo.height);
    }
    paramRenderContext.updateViewport(new CGRect(new PointF(0.0F, 0.0F), localCGSize));
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
      if (Build.VERSION.SDK_INT >= 18) {
        paramRenderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
      }
      paramRenderContext.swapBuffers();
    }
    return localCGSize;
  }
  
  public Bitmap copyCGImageAtTimeAndActualTime(CMTime paramCMTime1, CMTime paramCMTime2, RenderContext paramRenderContext)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return doGenerator(paramCMTime1, paramRenderContext);
    }
    throw new Exception("cannot process in the main thread");
  }
  
  public void generateCGImagesAsynchronouslyForTimes(List<CMTime> paramList, AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener, EGLContext paramEGLContext, AssetImageGenerator.ImageGeneratorThread paramImageGeneratorThread, RenderContext paramRenderContext)
  {
    this.generatorThread = paramImageGeneratorThread;
    this.eglContext = paramEGLContext;
    this.runnable = new AssetImageGenerator.1(this, paramList, paramRenderContext, paramImageGeneratorListener);
    removeGenerateMessage();
    paramList = this.generatorThread;
    if ((paramList != null) && (paramList.getHandler() != null)) {
      this.generatorThread.getHandler().post(this.runnable);
    }
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
    removeGenerateMessage();
    doRelease();
    this.videoComposition = null;
    this.generatorThread = null;
    this.eglContext = null;
  }
  
  public void setApertureMode(AssetImageGenerator.ApertureMode paramApertureMode)
  {
    this.apertureMode = paramApertureMode;
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setMaximumSize(CGSize paramCGSize)
  {
    this.maximumSize = paramCGSize;
  }
  
  public void setOutSavePath(String paramString)
  {
    this.outSavePath = paramString;
  }
  
  public void setRenderContextParams(@Nullable RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext != null) {
      localRenderContext.setParams(paramRenderContextParams);
    }
  }
  
  public void setTansRenderContext(TAVAutomaticTransRenderContext paramTAVAutomaticTransRenderContext)
  {
    this.transRenderContext = paramTAVAutomaticTransRenderContext;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public void updateAsset(Asset paramAsset, CGSize paramCGSize)
  {
    this.maximumSize = paramCGSize;
    paramCGSize = null;
    initRenderContext(null);
    this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(paramAsset, this.assetExtension, 1);
    paramAsset = paramAsset.getTracks().iterator();
    while (paramAsset.hasNext())
    {
      AssetTrack localAssetTrack = (AssetTrack)paramAsset.next();
      if (localAssetTrack.getMediaType() == 1) {
        this.videoCompositionDecoderTrack.addTrack(localAssetTrack);
      }
    }
    this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
    paramAsset = this.videoComposition;
    if (paramAsset == null) {
      paramAsset = paramCGSize;
    } else {
      paramAsset = paramAsset.getCustomVideoCompositor();
    }
    this.videoCompositing = paramAsset;
    this.videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
    this.videoCompositionDecoderTrack.start(this.renderContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.AssetImageGenerator
 * JD-Core Version:    0.7.0.1
 */
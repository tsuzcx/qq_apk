package com.tencent.qcircle.weseevideo.composition.image;

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
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
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
  
  /* Error */
  @Nullable
  private Bitmap bitmapFromFBO(@NonNull RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 115	com/tencent/tav/coremedia/CMSampleBuffer:getTextureInfo	()Lcom/tencent/tav/coremedia/TextureInfo;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload 5
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: aload_1
    //   17: aload 5
    //   19: invokespecial 119	com/tencent/qcircle/weseevideo/composition/image/AssetImageGenerator:readBitmapFromTexture	(Lcom/tencent/tav/decoder/RenderContext;Lcom/tencent/tav/coremedia/TextureInfo;)Landroid/graphics/Bitmap;
    //   22: astore 4
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 121	com/tencent/qcircle/weseevideo/composition/image/AssetImageGenerator:maximumSize	Lcom/tencent/tav/coremedia/CGSize;
    //   29: new 123	com/tencent/tav/coremedia/CGSize
    //   32: dup
    //   33: aload 5
    //   35: getfield 129	com/tencent/tav/coremedia/TextureInfo:width	I
    //   38: i2f
    //   39: aload 5
    //   41: getfield 132	com/tencent/tav/coremedia/TextureInfo:height	I
    //   44: i2f
    //   45: invokespecial 135	com/tencent/tav/coremedia/CGSize:<init>	(FF)V
    //   48: invokespecial 139	com/tencent/qcircle/weseevideo/composition/image/AssetImageGenerator:getMatrix	(Lcom/tencent/tav/coremedia/CGSize;Lcom/tencent/tav/coremedia/CGSize;)Landroid/graphics/Matrix;
    //   51: astore_1
    //   52: new 141	android/graphics/Matrix
    //   55: dup
    //   56: invokespecial 142	android/graphics/Matrix:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: fconst_1
    //   62: ldc 143
    //   64: invokevirtual 147	android/graphics/Matrix:postScale	(FF)Z
    //   67: pop
    //   68: aload_2
    //   69: fconst_0
    //   70: aload 4
    //   72: invokevirtual 152	android/graphics/Bitmap:getHeight	()I
    //   75: i2f
    //   76: invokevirtual 155	android/graphics/Matrix:postTranslate	(FF)Z
    //   79: pop
    //   80: aload_1
    //   81: ifnull +12 -> 93
    //   84: aload_1
    //   85: aload_2
    //   86: invokevirtual 159	android/graphics/Matrix:postConcat	(Landroid/graphics/Matrix;)Z
    //   89: pop
    //   90: goto +5 -> 95
    //   93: aload_2
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 121	com/tencent/qcircle/weseevideo/composition/image/AssetImageGenerator:maximumSize	Lcom/tencent/tav/coremedia/CGSize;
    //   99: astore_2
    //   100: aload_2
    //   101: ifnull +6 -> 107
    //   104: goto +23 -> 127
    //   107: new 123	com/tencent/tav/coremedia/CGSize
    //   110: dup
    //   111: aload 5
    //   113: getfield 129	com/tencent/tav/coremedia/TextureInfo:width	I
    //   116: i2f
    //   117: aload 5
    //   119: getfield 132	com/tencent/tav/coremedia/TextureInfo:height	I
    //   122: i2f
    //   123: invokespecial 135	com/tencent/tav/coremedia/CGSize:<init>	(FF)V
    //   126: astore_2
    //   127: aload 4
    //   129: iconst_0
    //   130: iconst_0
    //   131: aload_2
    //   132: getfield 162	com/tencent/tav/coremedia/CGSize:width	F
    //   135: f2i
    //   136: aload_2
    //   137: getfield 164	com/tencent/tav/coremedia/CGSize:height	F
    //   140: f2i
    //   141: aload_1
    //   142: iconst_1
    //   143: invokestatic 168	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   146: astore_1
    //   147: aload 4
    //   149: invokevirtual 171	android/graphics/Bitmap:recycle	()V
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: goto +20 -> 175
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 83	com/tencent/qcircle/weseevideo/composition/image/AssetImageGenerator:TAG	Ljava/lang/String;
    //   163: aload_1
    //   164: invokevirtual 174	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   167: invokestatic 180	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_3
    //   171: astore_1
    //   172: goto -25 -> 147
    //   175: aload 4
    //   177: invokevirtual 171	android/graphics/Bitmap:recycle	()V
    //   180: goto +5 -> 185
    //   183: aload_1
    //   184: athrow
    //   185: goto -2 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	AssetImageGenerator
    //   0	188	1	paramRenderContext	RenderContext
    //   0	188	2	paramCMSampleBuffer	CMSampleBuffer
    //   7	164	3	localObject	Object
    //   22	154	4	localBitmap	Bitmap
    //   4	114	5	localTextureInfo	TextureInfo
    // Exception table:
    //   from	to	target	type
    //   127	147	154	finally
    //   159	170	154	finally
    //   127	147	158	java/lang/OutOfMemoryError
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
      int i = AssetImageGenerator.2.$SwitchMap$com$tencent$qcircle$weseevideo$composition$image$AssetImageGenerator$ApertureMode[this.apertureMode.ordinal()];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator
 * JD-Core Version:    0.7.0.1
 */
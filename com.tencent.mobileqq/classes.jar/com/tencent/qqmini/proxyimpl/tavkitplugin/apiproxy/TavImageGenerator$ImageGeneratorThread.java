package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class TavImageGenerator$ImageGeneratorThread
  extends HandlerThread
  implements Handler.Callback
{
  private VideoCompositionDecoderTrack jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack;
  private VideoCompositing jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing;
  
  TavImageGenerator$ImageGeneratorThread(TavImageGenerator paramTavImageGenerator, String paramString)
  {
    super(paramString);
  }
  
  private Bitmap a(CMTime paramCMTime)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new Exception("cannot process in the main thread");
    }
    return b(paramCMTime);
  }
  
  @Nullable
  private Bitmap a(@NonNull RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (localTextureInfo == null) {
      return null;
    }
    Bitmap localBitmap = a(paramRenderContext, localTextureInfo);
    paramRenderContext = a(TavImageGenerator.a(this.this$0), new CGSize(localTextureInfo.width, localTextureInfo.height));
    paramCMSampleBuffer = new Matrix();
    paramCMSampleBuffer.postScale(1.0F, -1.0F);
    paramCMSampleBuffer.postTranslate(0.0F, localBitmap.getHeight());
    if (paramRenderContext != null)
    {
      paramRenderContext.postConcat(paramCMSampleBuffer);
      if (TavImageGenerator.a(this.this$0) == null) {
        break label131;
      }
    }
    label131:
    for (paramCMSampleBuffer = TavImageGenerator.a(this.this$0);; paramCMSampleBuffer = new CGSize(localTextureInfo.width, localTextureInfo.height))
    {
      return Bitmap.createBitmap(localBitmap, 0, 0, (int)paramCMSampleBuffer.width, (int)paramCMSampleBuffer.height, paramRenderContext, true);
      paramRenderContext = paramCMSampleBuffer;
      break;
    }
  }
  
  @NotNull
  private Bitmap a(@NonNull RenderContext paramRenderContext, TextureInfo paramTextureInfo)
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
  
  @Nullable
  private Matrix a(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    if ((paramCGSize1 == null) || (paramCGSize2 == null) || (TavImageGenerator.a(this.this$0) == -1)) {
      return null;
    }
    paramCGSize2 = new CGRect(new PointF(), paramCGSize2);
    paramCGSize1 = new CGRect(new PointF(), paramCGSize1);
    switch (TavImageGenerator.a(this.this$0))
    {
    default: 
      return null;
    case 101: 
      return CGMathFunctions.transformBySourceRectFit(paramCGSize2, paramCGSize1);
    case 102: 
      return CGMathFunctions.transformBySourceRectFill(paramCGSize2, paramCGSize1);
    }
    return CGMathFunctions.transformByScaleFitRect(paramCGSize2, paramCGSize1);
  }
  
  private Handler a()
  {
    return new Handler(getLooper(), this);
  }
  
  private CMSampleBuffer a(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    if (this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack == null)
    {
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.this$0.a, null, 1);
      localObject = this.this$0.a.getTracks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if (localAssetTrack.getMediaType() == 1) {
          this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.addTrack(localAssetTrack);
        }
      }
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.setVideoComposition(TavImageGenerator.a(this.this$0));
      if (TavImageGenerator.a(this.this$0) != null) {
        break label154;
      }
    }
    label154:
    for (Object localObject = null;; localObject = TavImageGenerator.a(this.this$0).getCustomVideoCompositor())
    {
      this.jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing = ((VideoCompositing)localObject);
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.setVideoCompositing(this.jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing);
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.start(paramRenderContext);
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.seekTo(paramCMTime, false, true);
      return this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.readSample(paramCMTime);
    }
  }
  
  @NonNull
  private RenderContext a()
  {
    if (TavImageGenerator.a(this.this$0) == null) {
      if (TavImageGenerator.a(this.this$0) == null) {
        break label88;
      }
    }
    label88:
    for (CGSize localCGSize = TavImageGenerator.a(this.this$0);; localCGSize = this.this$0.a.getNaturalSize())
    {
      TavImageGenerator.a(this.this$0, new RenderContext((int)localCGSize.width, (int)localCGSize.height));
      TavImageGenerator.a(this.this$0).setParams(TavImageGenerator.a(this.this$0));
      TavImageGenerator.a(this.this$0).makeCurrent();
      return TavImageGenerator.a(this.this$0);
    }
  }
  
  private void a()
  {
    Logger.d(TavImageGenerator.a(this.this$0), "doRelease: start, thread = " + Thread.currentThread().getName());
    if (this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack != null)
    {
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack.release();
      this.jdField_a_of_type_ComTencentTavCoreVideoCompositionDecoderTrack = null;
    }
    if (this.jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing != null)
    {
      this.jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing.release();
      this.jdField_a_of_type_ComTencentTavCoreCompositingVideoCompositing = null;
    }
    if (TavImageGenerator.a(this.this$0) != null)
    {
      TavImageGenerator.a(this.this$0).release();
      TavImageGenerator.a(this.this$0, null);
    }
    TavImageGenerator.a(this.this$0, null);
    Logger.d(TavImageGenerator.a(this.this$0), "doRelease: end, thread = " + Thread.currentThread().getName());
  }
  
  private void a(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof TavImageGenerator.CoverMsg)) {}
    do
    {
      return;
      TavImageGenerator.CoverMsg localCoverMsg = (TavImageGenerator.CoverMsg)paramMessage.obj;
      paramMessage = null;
      try
      {
        Bitmap localBitmap = a(TavImageGenerator.CoverMsg.a(localCoverMsg));
        paramMessage = localBitmap;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e(TavImageGenerator.a(this.this$0), "doGeneratorCover: ", localException);
        }
      }
    } while (TavImageGenerator.CoverMsg.a(localCoverMsg) == null);
    TavImageGenerator.CoverMsg.a(localCoverMsg).a(TavImageGenerator.CoverMsg.a(localCoverMsg), paramMessage);
  }
  
  @Nullable
  private Bitmap b(CMTime paramCMTime)
  {
    RenderContext localRenderContext = a();
    return a(localRenderContext, a(paramCMTime, localRenderContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a(paramMessage);
      continue;
      TavImageGenerator.a(this.this$0).removeCallbacksAndMessages(null);
      a();
      quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGenerator.ImageGeneratorThread
 * JD-Core Version:    0.7.0.1
 */
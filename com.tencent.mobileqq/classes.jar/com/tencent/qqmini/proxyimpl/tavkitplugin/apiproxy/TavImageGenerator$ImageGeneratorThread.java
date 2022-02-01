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
  private VideoCompositionDecoderTrack a;
  private VideoCompositing b;
  
  TavImageGenerator$ImageGeneratorThread(TavImageGenerator paramTavImageGenerator, String paramString)
  {
    super(paramString);
  }
  
  private Bitmap a(CMTime paramCMTime)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return b(paramCMTime);
    }
    throw new Exception("cannot process in the main thread");
  }
  
  @Nullable
  private Bitmap a(@NonNull RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (localTextureInfo == null) {
      return null;
    }
    Bitmap localBitmap = a(paramRenderContext, localTextureInfo);
    paramRenderContext = a(TavImageGenerator.d(this.this$0), new CGSize(localTextureInfo.width, localTextureInfo.height));
    paramCMSampleBuffer = new Matrix();
    paramCMSampleBuffer.postScale(1.0F, -1.0F);
    paramCMSampleBuffer.postTranslate(0.0F, localBitmap.getHeight());
    if (paramRenderContext != null) {
      paramRenderContext.postConcat(paramCMSampleBuffer);
    } else {
      paramRenderContext = paramCMSampleBuffer;
    }
    if (TavImageGenerator.d(this.this$0) != null) {
      paramCMSampleBuffer = TavImageGenerator.d(this.this$0);
    } else {
      paramCMSampleBuffer = new CGSize(localTextureInfo.width, localTextureInfo.height);
    }
    return Bitmap.createBitmap(localBitmap, 0, 0, (int)paramCMSampleBuffer.width, (int)paramCMSampleBuffer.height, paramRenderContext, true);
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
    if ((paramCGSize1 != null) && (paramCGSize2 != null))
    {
      if (TavImageGenerator.g(this.this$0) == -1) {
        return null;
      }
      paramCGSize2 = new CGRect(new PointF(), paramCGSize2);
      paramCGSize1 = new CGRect(new PointF(), paramCGSize1);
      switch (TavImageGenerator.g(this.this$0))
      {
      default: 
        return null;
      case 103: 
        return CGMathFunctions.transformByScaleFitRect(paramCGSize2, paramCGSize1);
      case 102: 
        return CGMathFunctions.transformBySourceRectFill(paramCGSize2, paramCGSize1);
      }
      return CGMathFunctions.transformBySourceRectFit(paramCGSize2, paramCGSize1);
    }
    return null;
  }
  
  private Handler a()
  {
    return new Handler(getLooper(), this);
  }
  
  private CMSampleBuffer a(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    if (this.a == null)
    {
      Object localObject = this.this$0.a;
      VideoCompositing localVideoCompositing = null;
      this.a = new VideoCompositionDecoderTrack((Asset)localObject, null, 1);
      localObject = this.this$0.a.getTracks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if (localAssetTrack.getMediaType() == 1) {
          this.a.addTrack(localAssetTrack);
        }
      }
      this.a.setVideoComposition(TavImageGenerator.f(this.this$0));
      if (TavImageGenerator.f(this.this$0) != null) {
        localVideoCompositing = TavImageGenerator.f(this.this$0).getCustomVideoCompositor();
      }
      this.b = localVideoCompositing;
      this.a.setVideoCompositing(this.b);
      this.a.start(paramRenderContext);
    }
    this.a.seekTo(paramCMTime, false, true);
    return this.a.readSample(paramCMTime);
  }
  
  private void a(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof TavImageGenerator.CoverMsg)) {
      return;
    }
    TavImageGenerator.CoverMsg localCoverMsg = (TavImageGenerator.CoverMsg)paramMessage.obj;
    paramMessage = null;
    try
    {
      Bitmap localBitmap = a(TavImageGenerator.CoverMsg.a(localCoverMsg));
      paramMessage = localBitmap;
    }
    catch (Exception localException)
    {
      Logger.e(TavImageGenerator.b(this.this$0), "doGeneratorCover: ", localException);
    }
    if (TavImageGenerator.CoverMsg.b(localCoverMsg) != null) {
      TavImageGenerator.CoverMsg.b(localCoverMsg).a(TavImageGenerator.CoverMsg.a(localCoverMsg), paramMessage);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      TavImageGenerator.a(this.this$0).removeCallbacksAndMessages(null);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    TavImageGenerator.a(this.this$0).sendMessage(localMessage);
  }
  
  @Nullable
  private Bitmap b(CMTime paramCMTime)
  {
    RenderContext localRenderContext = b();
    return a(localRenderContext, a(paramCMTime, localRenderContext));
  }
  
  @NonNull
  private RenderContext b()
  {
    if (TavImageGenerator.c(this.this$0) == null)
    {
      CGSize localCGSize;
      if (TavImageGenerator.d(this.this$0) != null) {
        localCGSize = TavImageGenerator.d(this.this$0);
      } else {
        localCGSize = this.this$0.a.getNaturalSize();
      }
      TavImageGenerator.a(this.this$0, new RenderContext((int)localCGSize.width, (int)localCGSize.height));
      TavImageGenerator.c(this.this$0).setParams(TavImageGenerator.e(this.this$0));
    }
    TavImageGenerator.c(this.this$0).makeCurrent();
    return TavImageGenerator.c(this.this$0);
  }
  
  private void c()
  {
    Object localObject = TavImageGenerator.b(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRelease: start, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.a;
    if (localObject != null)
    {
      ((VideoCompositionDecoderTrack)localObject).release();
      this.a = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((VideoCompositing)localObject).release();
      this.b = null;
    }
    if (TavImageGenerator.c(this.this$0) != null)
    {
      TavImageGenerator.c(this.this$0).release();
      TavImageGenerator.a(this.this$0, null);
    }
    TavImageGenerator.a(this.this$0, null);
    localObject = TavImageGenerator.b(this.this$0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("doRelease: end, thread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        TavImageGenerator.a(this.this$0).removeCallbacksAndMessages(null);
        c();
        quit();
      }
    }
    else {
      a(paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGenerator.ImageGeneratorThread
 * JD-Core Version:    0.7.0.1
 */
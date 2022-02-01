package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tav.Utils;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class PlayerRenderer
{
  private static final String TAG = "PlayerRenderer";
  private Filter filter;
  @Nullable
  private CGRect glViewportRect;
  private VideoComposition.RenderLayoutMode layoutMode;
  @Nullable
  private Surface mDisplayTarget;
  @Nullable
  private OnReadSnapShootListener onReadSnapShootListener;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  @Nullable
  private CGSize renderSize;
  private CGSize surfaceSize;
  
  private void applyViewport()
  {
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext != null)
    {
      CGRect localCGRect = this.glViewportRect;
      if (localCGRect == null) {
        return;
      }
      localRenderContext.updateViewport(localCGRect);
    }
  }
  
  private void checkCopyPixelBuffer(CMTime paramCMTime)
  {
    if (this.onReadSnapShootListener != null)
    {
      Object localObject = ByteBuffer.allocateDirect(this.renderContext.width() * this.renderContext.height() * 4);
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
      ((ByteBuffer)localObject).rewind();
      GLES20.glReadPixels(0, 0, this.renderContext.width(), this.renderContext.height(), 6408, 5121, (Buffer)localObject);
      Bitmap localBitmap = Bitmap.createBitmap(this.renderContext.width(), this.renderContext.height(), Bitmap.Config.ARGB_4444);
      ((ByteBuffer)localObject).rewind();
      localBitmap.copyPixelsFromBuffer((Buffer)localObject);
      localObject = Utils.flipYBitmap(localBitmap);
      this.onReadSnapShootListener.onSuccess((Bitmap)localObject, paramCMTime);
      this.onReadSnapShootListener = null;
    }
  }
  
  private void initViewportByLayoutMode(CGSize paramCGSize)
  {
    int i = PlayerRenderer.1.$SwitchMap$com$tencent$tav$core$composition$VideoComposition$RenderLayoutMode[this.layoutMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, paramCGSize);
        return;
      }
      this.glViewportRect = CGMathFunctions.initGLViewportFill(this.surfaceSize, paramCGSize);
      return;
    }
    this.glViewportRect = CGMathFunctions.initGLViewportFit(this.surfaceSize, paramCGSize);
  }
  
  void bindSurface(PlayerLayer paramPlayerLayer)
  {
    this.mDisplayTarget = paramPlayerLayer.surface;
    setSurfaceSize(new CGSize(paramPlayerLayer.surfaceWidth, paramPlayerLayer.surfaceHeight));
  }
  
  @Nullable
  CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  void initRenderContext()
  {
    if (this.renderContext == null)
    {
      if (this.mDisplayTarget == null) {
        return;
      }
      Object localObject2 = null;
      RenderContextParams localRenderContextParams = this.renderContextParams;
      Object localObject1 = localObject2;
      if (localRenderContextParams != null)
      {
        localObject1 = localObject2;
        if ((localRenderContextParams.getParam("share_context") instanceof EGLContext)) {
          localObject1 = (EGLContext)this.renderContextParams.getParam("share_context");
        }
      }
      this.renderContext = new RenderContext((int)this.surfaceSize.width, (int)this.surfaceSize.height, this.mDisplayTarget, (EGLContext)localObject1);
      this.renderContext.setParams(this.renderContextParams);
    }
  }
  
  void initRenderSize(VideoComposition paramVideoComposition)
  {
    if (paramVideoComposition != null)
    {
      this.renderSize = paramVideoComposition.getRenderSize();
      this.layoutMode = paramVideoComposition.getRenderLayoutMode();
    }
    paramVideoComposition = this.renderContext;
    if (paramVideoComposition != null)
    {
      CGSize localCGSize = this.renderSize;
      if (localCGSize != null)
      {
        paramVideoComposition.setHeight((int)localCGSize.height);
        this.renderContext.setWidth((int)this.renderSize.width);
      }
    }
  }
  
  void initViewport(Handler paramHandler)
  {
    CGSize localCGSize = this.renderSize;
    if (localCGSize == null) {
      localCGSize = this.surfaceSize;
    }
    if (this.layoutMode == null) {
      this.glViewportRect = CGMathFunctions.initGLViewportDefault(this.surfaceSize, localCGSize);
    } else {
      initViewportByLayoutMode(localCGSize);
    }
    applyViewport();
    paramHandler.obtainMessage(3, this.glViewportRect).sendToTarget();
  }
  
  void makeCurrent()
  {
    this.renderContext.makeCurrent();
  }
  
  void releaseFilter()
  {
    Filter localFilter = this.filter;
    if (localFilter != null)
    {
      localFilter.release();
      this.filter = null;
    }
  }
  
  void releaseRenderContext()
  {
    this.renderContext.release();
    this.renderContext = null;
  }
  
  void renderSampleBuffer(CMSampleBuffer paramCMSampleBuffer, int paramInt, OnGetTavExtraListener paramOnGetTavExtraListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("renderSampleBuffer() called with: sampleBuffer = [");
    ((StringBuilder)localObject).append(paramCMSampleBuffer);
    ((StringBuilder)localObject).append("]");
    Logger.v("PlayerRenderer", ((StringBuilder)localObject).toString());
    if (paramCMSampleBuffer.getTextureInfo() != null)
    {
      if (this.filter == null)
      {
        this.filter = new Filter();
        this.filter.setRendererWidth(this.renderContext.width());
        this.filter.setRendererHeight(this.renderContext.height());
      }
      this.renderContext.makeCurrent();
      localObject = paramCMSampleBuffer.getTextureInfo();
      if (paramOnGetTavExtraListener != null)
      {
        paramOnGetTavExtraListener.getTextureInfo((TextureInfo)localObject);
        return;
      }
      applyViewport();
      this.filter.setBgColor(paramInt);
      this.filter.applyFilter((TextureInfo)localObject, null, ((TextureInfo)localObject).getTextureMatrix());
      checkCopyPixelBuffer(paramCMSampleBuffer.getTime());
      this.renderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
      this.renderContext.swapBuffers();
    }
  }
  
  void setOnReadSnapShootListener(@Nullable OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    this.onReadSnapShootListener = paramOnReadSnapShootListener;
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    RenderContext localRenderContext = this.renderContext;
    if (localRenderContext != null) {
      localRenderContext.setParams(paramRenderContextParams);
    }
  }
  
  void setSurfaceSize(CGSize paramCGSize)
  {
    this.surfaceSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerRenderer
 * JD-Core Version:    0.7.0.1
 */
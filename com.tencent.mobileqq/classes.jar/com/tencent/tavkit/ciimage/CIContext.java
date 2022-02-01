package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.video.Releasable;

public class CIContext
  implements Releasable
{
  private RendererWrapper canvasRenderer;
  private TextureInfo canvasTexture;
  private RendererWrapper imageRenderer;
  private final String mTAG;
  private final RenderContext renderContext;
  
  public CIContext(@NonNull RenderContext paramRenderContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIContext@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mTAG = localStringBuilder.toString();
    this.renderContext = paramRenderContext;
  }
  
  private void createCanvasTexture(RenderContext paramRenderContext)
  {
    if (isRenderInfoChanged(paramRenderContext))
    {
      this.canvasTexture.release();
      this.canvasTexture = null;
    }
    if (this.canvasTexture == null) {
      this.canvasTexture = newTextureInfo(paramRenderContext.width(), paramRenderContext.height());
    }
  }
  
  private void createFilter()
  {
    if (this.canvasRenderer == null)
    {
      this.canvasRenderer = new RendererWrapper();
      this.canvasRenderer.setOutputTextureInfo(this.canvasTexture);
    }
  }
  
  private boolean isRenderInfoChanged(RenderContext paramRenderContext)
  {
    TextureInfo localTextureInfo = this.canvasTexture;
    boolean bool = false;
    if (localTextureInfo == null) {
      return false;
    }
    if ((localTextureInfo.width != paramRenderContext.width()) || (this.canvasTexture.height != paramRenderContext.height())) {
      bool = true;
    }
    return bool;
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(float paramFloat1, float paramFloat2)
  {
    return newTextureInfo((int)paramFloat1, (int)paramFloat2);
  }
  
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2)
  {
    return newTextureInfo(paramInt1, paramInt2, false);
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramInt1, paramInt2, null, 0);
    localTextureInfo.setFormat(6408);
    if (paramBoolean)
    {
      GLES20.glBindTexture(3553, localTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, localTextureInfo.getFormat(), localTextureInfo.width, localTextureInfo.height, 0, localTextureInfo.getFormat(), 5121, null);
    }
    return localTextureInfo;
  }
  
  public static TextureInfo newTextureInfo(CGSize paramCGSize)
  {
    return newTextureInfo(paramCGSize.width, paramCGSize.height);
  }
  
  @Nullable
  public TextureInfo convertImageToTexture(CIImage paramCIImage, TextureInfo paramTextureInfo)
  {
    if ((paramCIImage != null) && (paramTextureInfo != null))
    {
      if (this.imageRenderer == null) {
        this.imageRenderer = new RendererWrapper();
      }
      this.imageRenderer.setOutputTextureInfo(paramTextureInfo);
      this.imageRenderer.clearBufferBuffer(-16777216);
      paramCIImage.drawTo(this.imageRenderer);
      return paramTextureInfo;
    }
    return null;
  }
  
  @NonNull
  public CMSampleBuffer convertToSampleBuffer(@NonNull CIImage paramCIImage, @NonNull CMTime paramCMTime, @NonNull RenderContext paramRenderContext)
  {
    paramRenderContext.makeCurrent();
    createCanvasTexture(paramRenderContext);
    createFilter();
    this.canvasRenderer.clearBufferBuffer(-16777216);
    paramCIImage.drawTo(this.canvasRenderer);
    return new CMSampleBuffer(paramCMTime, this.canvasTexture, false);
  }
  
  @NonNull
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public void release()
  {
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: begin, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.canvasRenderer;
    if (localObject != null) {
      ((RendererWrapper)localObject).release();
    }
    localObject = this.canvasTexture;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    localObject = this.imageRenderer;
    if (localObject != null) {
      ((RendererWrapper)localObject).release();
    }
    localObject = this.mTAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: end, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIContext
 * JD-Core Version:    0.7.0.1
 */
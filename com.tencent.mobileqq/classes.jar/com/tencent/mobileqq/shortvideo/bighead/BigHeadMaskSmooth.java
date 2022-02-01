package com.tencent.mobileqq.shortvideo.bighead;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class BigHeadMaskSmooth
{
  private FeatherBlurFilter blurFeather;
  private GpuGaussianBlurFilter blurFilter = new GpuGaussianBlurFilter();
  private int mOrgTextureId = 0;
  private RenderBuffer mRenderFBO;
  private final float[] weights = { 0.1106328F, 0.1113495F, 0.1106328F, 0.1113495F, 0.1120707F, 0.1113495F, 0.1106328F, 0.1113495F, 0.1106328F };
  
  public BigHeadMaskSmooth()
  {
    this.blurFilter.setStepRatio(3.0F, 2.0F);
    this.mRenderFBO = new RenderBuffer(false, 0, 0);
    this.blurFeather = new FeatherBlurFilter();
    this.blurFeather.setStepRatio(1.0F, 1.0F);
  }
  
  private void allocateTexture(int paramInt1, int paramInt2)
  {
    this.mRenderFBO.setUserTextureId(this.mOrgTextureId);
    if (this.mRenderFBO.getTexId() == 0)
    {
      int i = GlUtil.createTextureAllocate(paramInt1, paramInt2, false);
      this.mOrgTextureId = i;
      this.mRenderFBO.setUserTextureId(i);
      this.mRenderFBO.setSize(paramInt1, paramInt2);
    }
  }
  
  public void destroy()
  {
    this.blurFilter.destroy();
    this.blurFeather.destroy();
    this.mRenderFBO.destroy();
    BigHeadInitFilter.releaseRenderFBOTexture(this.mRenderFBO);
  }
  
  public void drawTexture(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, Rect paramRect)
  {
    allocateTexture(paramInt2, paramInt3);
    this.mRenderFBO.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glViewport(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    this.blurFilter.init(paramInt2, paramInt3, this.weights);
    this.blurFilter.drawTexture(paramInt1, paramArrayOfFloat, null);
    this.mRenderFBO.unbind();
    this.mRenderFBO.setUserTextureId(paramInt1);
    this.mRenderFBO.bind();
    GLES20.glClear(16384);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glViewport(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    this.blurFeather.init(paramInt2, paramInt3);
    if (this.blurFeather.getProgram() != 0)
    {
      this.blurFeather.drawTexture(this.mOrgTextureId, paramArrayOfFloat, null);
    }
    else
    {
      GLES20.glGetError();
      this.mRenderFBO.setUserTextureId(this.mOrgTextureId);
    }
    this.mRenderFBO.unbind();
  }
  
  public int getOutputTexture()
  {
    return this.mRenderFBO.getTexId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadMaskSmooth
 * JD-Core Version:    0.7.0.1
 */
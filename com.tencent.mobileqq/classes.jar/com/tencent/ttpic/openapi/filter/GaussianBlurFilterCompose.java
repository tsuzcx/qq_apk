package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.util.GlUtil;

public class GaussianBlurFilterCompose
{
  private static final int GAUSSIAN_WEIGHT_SAMPLES = 11;
  private GaussianBlurFilter filter;
  private RenderBuffer mRenderScale;
  private int mScaleHeight;
  private int mScaleTextureFirst;
  private int mScaleWidth;
  private float radius = 9.8F;
  private TextureRender renderDraw;
  
  private float[] getWeight(float paramFloat)
  {
    int i = 0;
    if (paramFloat >= 1.0F)
    {
      double d = Math.pow(paramFloat, 2.0D);
      i = (int)Math.floor(Math.sqrt(Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D))) * (-2.0D * d)));
      i += i % 2;
    }
    float[] arrayOfFloat1 = new float[i + 1];
    float f = 0.0F;
    int j = 0;
    if (j < i + 1)
    {
      arrayOfFloat1[j] = ((float)(1.0D / Math.sqrt(6.283185307179586D * Math.pow(paramFloat, 2.0D)) * Math.exp(-Math.pow(j, 2.0D) / (2.0D * Math.pow(paramFloat, 2.0D)))));
      if (j == 0) {}
      for (f = arrayOfFloat1[j] + f;; f = (float)(f + 2.0D * arrayOfFloat1[j]))
      {
        j += 1;
        break;
      }
    }
    j = 0;
    while (j < i + 1)
    {
      arrayOfFloat1[j] /= f;
      j += 1;
    }
    int k = Math.min(i / 2 + i % 2, 7);
    float[] arrayOfFloat2 = new float[k];
    j = 0;
    while (j < k)
    {
      paramFloat = arrayOfFloat1[(j * 2 + 1)];
      f = arrayOfFloat1[(j * 2 + 2)];
      arrayOfFloat2[j] = ((paramFloat * (j * 2 + 1) + f * (j * 2 + 2)) / (paramFloat + f));
      j += 1;
    }
    j = i / 2 + i % 2;
    arrayOfFloat2 = new float[11];
    i = 0;
    while (i < 11)
    {
      arrayOfFloat2[i] = 0.0F;
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      arrayOfFloat2[i] = (arrayOfFloat1[(i * 2 + 1)] + arrayOfFloat1[(i * 2 + 2)]);
      i += 1;
    }
    if (j > k)
    {
      i = k;
      while (i < j)
      {
        arrayOfFloat2[i] = (arrayOfFloat1[(i * 2 + 1)] + arrayOfFloat1[(i * 2 + 2)]);
        i += 1;
      }
    }
    paramFloat = -arrayOfFloat2[0];
    i = 0;
    while (i < arrayOfFloat2.length)
    {
      paramFloat += arrayOfFloat2[i] * 2.0F;
      i += 1;
    }
    i = 0;
    while (i < arrayOfFloat2.length)
    {
      arrayOfFloat2[i] /= paramFloat;
      i += 1;
    }
    return arrayOfFloat2;
  }
  
  public void destroy()
  {
    if (this.filter != null)
    {
      this.filter.destroy();
      this.filter = null;
    }
    if (this.mRenderScale != null)
    {
      GlUtil.deleteTexture(this.mRenderScale.getTexId());
      this.mRenderScale.destroy();
      this.mRenderScale = null;
    }
    if (this.renderDraw != null)
    {
      this.renderDraw.release();
      this.renderDraw = null;
    }
    if (this.mScaleTextureFirst > 0) {
      GlUtil.deleteTexture(this.mScaleTextureFirst);
    }
  }
  
  public void drawTexture(int paramInt)
  {
    if (this.filter == null) {}
    while (!this.filter.isInitSucc()) {
      return;
    }
    this.mRenderScale.bind();
    this.renderDraw.drawTexture(3553, paramInt, null, null);
    this.mRenderScale.unbind();
    paramInt = this.mRenderScale.getTexId();
    this.mRenderScale.setUserTextureId(this.mScaleTextureFirst);
    this.mRenderScale.bind();
    this.filter.setStepRatio(null, 1.0F, 0.0F);
    this.filter.drawTexture(paramInt);
    this.mRenderScale.unbind();
    this.mRenderScale.setUserTextureId(paramInt);
    this.mRenderScale.bind();
    this.filter.setStepRatio(null, 0.0F, 1.0F);
    this.filter.drawTexture(this.mScaleTextureFirst);
    this.mRenderScale.unbind();
  }
  
  public GaussianBlurFilter getFilter()
  {
    return this.filter;
  }
  
  public int getOutputHeight()
  {
    return this.mScaleHeight;
  }
  
  public int getOutputWidth()
  {
    return this.mScaleWidth;
  }
  
  public int getTextureId()
  {
    return this.mRenderScale.getTexId();
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    this.mScaleWidth = ((int)(paramInt1 * 0.25F));
    this.mScaleHeight = ((int)(0.25F * paramInt2));
    this.mRenderScale = new RenderBuffer(this.mScaleWidth, this.mScaleHeight, 33986);
    this.mScaleTextureFirst = GlUtil.createTextureAllocate(this.mScaleWidth, this.mScaleHeight, false);
    this.renderDraw = new TextureRender();
    this.filter = new GaussianBlurFilter();
    this.filter.init(this.mScaleWidth, this.mScaleHeight);
    float[] arrayOfFloat = getWeight(this.radius);
    this.filter.setStepRatio(arrayOfFloat, 0.0F, 0.0F);
  }
  
  public void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose
 * JD-Core Version:    0.7.0.1
 */
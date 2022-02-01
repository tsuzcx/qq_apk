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
    int k = 0;
    double d1;
    double d2;
    if (paramFloat >= 1.0F)
    {
      double d3 = paramFloat;
      d1 = Math.pow(d3, 2.0D);
      d2 = 0.0039063F;
      d3 = Math.sqrt(Math.pow(d3, 2.0D) * 6.283185307179586D);
      Double.isNaN(d2);
      i = (int)Math.floor(Math.sqrt(d1 * -2.0D * Math.log(d2 * d3)));
      i += i % 2;
    }
    else
    {
      i = 0;
    }
    int m = i + 1;
    float[] arrayOfFloat1 = new float[m];
    int j = 0;
    float f = 0.0F;
    while (j < m)
    {
      d1 = paramFloat;
      arrayOfFloat1[j] = ((float)(1.0D / Math.sqrt(Math.pow(d1, 2.0D) * 6.283185307179586D) * Math.exp(-Math.pow(j, 2.0D) / (Math.pow(d1, 2.0D) * 2.0D))));
      if (j == 0)
      {
        f += arrayOfFloat1[j];
      }
      else
      {
        d1 = f;
        d2 = arrayOfFloat1[j];
        Double.isNaN(d2);
        Double.isNaN(d1);
        f = (float)(d1 + d2 * 2.0D);
      }
      j += 1;
    }
    j = 0;
    while (j < m)
    {
      arrayOfFloat1[j] /= f;
      j += 1;
    }
    m = i / 2 + i % 2;
    j = Math.min(m, 7);
    float[] arrayOfFloat2 = new float[j];
    int i = 0;
    int n;
    while (i < j)
    {
      int i1 = i * 2;
      n = i1 + 1;
      paramFloat = arrayOfFloat1[n];
      i1 += 2;
      f = arrayOfFloat1[i1];
      arrayOfFloat2[i] = ((paramFloat * n + f * i1) / (paramFloat + f));
      i += 1;
    }
    arrayOfFloat2 = new float[11];
    i = 0;
    while (i < 11)
    {
      arrayOfFloat2[i] = 0.0F;
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = i * 2;
      arrayOfFloat2[i] = (arrayOfFloat1[(n + 1)] + arrayOfFloat1[(n + 2)]);
      i += 1;
    }
    if (m > j)
    {
      i = j;
      while (i < m)
      {
        j = i * 2;
        arrayOfFloat2[i] = (arrayOfFloat1[(j + 1)] + arrayOfFloat1[(j + 2)]);
        i += 1;
      }
    }
    paramFloat = -arrayOfFloat2[0];
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= arrayOfFloat2.length) {
        break;
      }
      paramFloat += arrayOfFloat2[i] * 2.0F;
      i += 1;
    }
    while (j < arrayOfFloat2.length)
    {
      arrayOfFloat2[j] /= paramFloat;
      j += 1;
    }
    return arrayOfFloat2;
  }
  
  public void destroy()
  {
    Object localObject = this.filter;
    if (localObject != null)
    {
      ((GaussianBlurFilter)localObject).destroy();
      this.filter = null;
    }
    localObject = this.mRenderScale;
    if (localObject != null)
    {
      GlUtil.deleteTexture(((RenderBuffer)localObject).getTexId());
      this.mRenderScale.destroy();
      this.mRenderScale = null;
    }
    localObject = this.renderDraw;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.renderDraw = null;
    }
    int i = this.mScaleTextureFirst;
    if (i > 0) {
      GlUtil.deleteTexture(i);
    }
  }
  
  public void drawTexture(int paramInt)
  {
    GaussianBlurFilter localGaussianBlurFilter = this.filter;
    if (localGaussianBlurFilter == null) {
      return;
    }
    if (!localGaussianBlurFilter.isInitSucc()) {
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
    this.mScaleHeight = ((int)(paramInt2 * 0.25F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose
 * JD-Core Version:    0.7.0.1
 */
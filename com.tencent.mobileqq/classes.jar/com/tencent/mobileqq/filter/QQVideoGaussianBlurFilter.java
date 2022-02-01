package com.tencent.mobileqq.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQVideoGaussianBlurFilter
{
  GaussianBlurFilterCompose a;
  GaussianBlurFilter b;
  TextureRender c;
  RenderBuffer d;
  RenderBuffer e;
  float[] f;
  float[] g;
  float[] h;
  int i;
  int j;
  int k;
  int l;
  int m;
  
  public QQVideoGaussianBlurFilter(int paramInt)
  {
    this.k = paramInt;
    this.f = a(this.k);
  }
  
  private float[] a(float paramFloat)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.rotateM(arrayOfFloat, 0, paramFloat, 0.0F, 0.0F, 1.0F);
    return arrayOfFloat;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = new TextureRender();
    this.a = new GaussianBlurFilterCompose();
    if (this.k % 180 != 0)
    {
      this.a.init(paramInt2, paramInt1);
      this.d = new RenderBuffer(paramInt2, paramInt1, 33984);
      this.g = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);
      this.h = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);
    }
    else
    {
      this.a.init(paramInt1, paramInt2);
      this.d = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.g = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
      this.h = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.b = this.a.getFilter();
    this.e = new RenderBuffer(paramInt3, paramInt4, 33984);
  }
  
  public int a(int paramInt)
  {
    int n = paramInt;
    if (this.k != 0)
    {
      this.d.bind();
      this.c.drawTexture(3553, paramInt, null, this.f);
      this.d.unbind();
      n = this.d.getTexId();
    }
    GaussianBlurFilter localGaussianBlurFilter = this.b;
    if ((localGaussianBlurFilter != null) && (localGaussianBlurFilter.isInitSucc())) {
      this.a.drawTexture(n);
    }
    this.e.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    localGaussianBlurFilter = this.b;
    if ((localGaussianBlurFilter != null) && (localGaussianBlurFilter.isInitSucc()))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.c.drawTexture(3553, this.a.getTextureId(), null, this.g);
      GLES20.glDisable(3042);
    }
    else
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.1F);
      this.c.drawTexture(3553, n, null, this.g);
      GLES20.glDisable(3042);
    }
    this.c.drawTexture(3553, n, null, this.h);
    this.e.unbind();
    return this.e.getTexId();
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((GaussianBlurFilter)localObject).destroy();
    }
    localObject = this.a;
    if (localObject != null) {
      ((GaussianBlurFilterCompose)localObject).destroy();
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    localObject = this.d;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.e;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.l != paramInt1) || (this.m != paramInt2))
    {
      this.l = paramInt1;
      this.m = paramInt2;
      b(this.i, this.j, this.l, this.m);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b(this.i, this.j, this.l, this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQVideoGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */
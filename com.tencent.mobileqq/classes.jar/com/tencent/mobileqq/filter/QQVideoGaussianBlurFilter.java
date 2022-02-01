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
  int jdField_a_of_type_Int;
  GaussianBlurFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
  GaussianBlurFilterCompose jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose;
  RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  float[] jdField_a_of_type_ArrayOfFloat;
  int jdField_b_of_type_Int;
  RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  float[] jdField_b_of_type_ArrayOfFloat;
  int jdField_c_of_type_Int;
  float[] jdField_c_of_type_ArrayOfFloat;
  int d;
  int e;
  
  public QQVideoGaussianBlurFilter(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfFloat = a(this.jdField_c_of_type_Int);
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
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
    if (this.jdField_c_of_type_Int % 180 != 0)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.init(paramInt2, paramInt1);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt2, paramInt1, 33984);
      this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);
      this.jdField_c_of_type_ArrayOfFloat = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt2, paramInt1, paramInt3, paramInt4);
    }
    else
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.init(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
      this.jdField_c_of_type_ArrayOfFloat = GPUBaseFilter.caculateFitCenterMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getFilter();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt3, paramInt4, 33984);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_c_of_type_Int != 0)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      i = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    }
    GaussianBlurFilter localGaussianBlurFilter = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
    if ((localGaussianBlurFilter != null) && (localGaussianBlurFilter.isInitSucc())) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.drawTexture(i);
    }
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    localGaussianBlurFilter = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
    if ((localGaussianBlurFilter != null) && (localGaussianBlurFilter.isInitSucc()))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose.getTextureId(), null, this.jdField_b_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
    }
    else
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.1F);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i, null, this.jdField_b_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i, null, this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    return this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
    if (localObject != null) {
      ((GaussianBlurFilter)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilterCompose;
    if (localObject != null) {
      ((GaussianBlurFilterCompose)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.d != paramInt1) || (this.e != paramInt2))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.e);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.QQVideoGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */
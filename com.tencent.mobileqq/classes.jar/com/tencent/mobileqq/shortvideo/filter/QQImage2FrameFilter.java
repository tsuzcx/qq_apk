package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.ptvfilter.GaussianBlurFilterCompose;

public class QQImage2FrameFilter
  extends QQBaseFilter
{
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private GaussianBlurFilterCompose jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose;
  private boolean jdField_a_of_type_Boolean = true;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private RenderBuffer b;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public QQImage2FrameFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(170, paramQQFilterRenderManager);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = new GPUBaseFilter();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    c(paramInt1, paramInt2);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
    {
      GlUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
    }
    this.jdField_a_of_type_ArrayOfFloat = null;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
    {
      GlUtil.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a());
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
    }
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    GLES20.glClear(16384);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    float f1 = this.g * 1.0F / this.h;
    float f2 = this.e * 1.0F / this.f;
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    if (f2 > f1)
    {
      f1 = this.g * 1.0F / this.e * this.f / this.h;
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, f1, 1.0F);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_b_of_type_Int, null, null);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_Int, null, this.jdField_a_of_type_ArrayOfFloat);
      GLES20.glDisable(3042);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, null);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      return;
      f1 = this.h * 1.0F / this.f * this.e / this.g;
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, f1, 1.0F, 1.0F);
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter
 * JD-Core Version:    0.7.0.1
 */
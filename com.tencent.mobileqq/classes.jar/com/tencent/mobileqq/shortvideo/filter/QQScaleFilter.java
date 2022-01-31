package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.ptvfilter.GaussianBlurFilterCompose;
import java.nio.FloatBuffer;
import java.util.List;

public class QQScaleFilter
  extends QQBaseFilter
{
  private GPUAlphaFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private GLImage jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  private GaussianBlurFilterCompose jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private List jdField_a_of_type_JavaUtilList;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private GLImage jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  private float[] jdField_b_of_type_ArrayOfFloat = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  private int e = 640;
  private int f = 1280;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  
  public QQScaleFilter(int paramInt1, QQFilterRenderManager paramQQFilterRenderManager, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramQQFilterRenderManager);
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter = new GPUAlphaFilter();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(this.jdField_b_of_type_ArrayOfFloat);
  }
  
  private void a(float paramFloat)
  {
    this.jdField_b_of_type_ArrayOfFloat[3] = paramFloat;
    this.jdField_b_of_type_ArrayOfFloat[7] = paramFloat;
    this.jdField_b_of_type_ArrayOfFloat[11] = paramFloat;
    this.jdField_b_of_type_ArrayOfFloat[15] = paramFloat;
  }
  
  private void a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null)
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(paramArrayOfFloat);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
    this.j = (paramInt * 2);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.k = paramList.size();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void d()
  {
    super.d();
    a();
  }
  
  public void h()
  {
    super.h();
    if (this.g % this.j == 0)
    {
      this.h = (this.g / this.j);
      if (this.h < this.k)
      {
        Log.d("rejectliu", "scale Filter OnDrawFrame frameIndex : " + this.g + "  picRate : " + this.j + " imgSize : " + this.k + "  picIndex : " + this.h);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a((String)this.jdField_a_of_type_JavaUtilList.get(this.h));
        if (this.h + 1 < this.k) {
          this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a((String)this.jdField_a_of_type_JavaUtilList.get(this.h + 1));
        }
      }
    }
    int m = this.h * this.j;
    float f2;
    if (this.g >= m) {
      f2 = (this.g - m) / this.j;
    }
    for (float f1 = f2 * 0.1F + 1.0F;; f1 = 1.0F)
    {
      Log.d("rejectliu", "frameIndex : " + this.g + " animRatio : " + f1 + " startIndex : " + m + " picRate : " + this.j + " animRatio : " + f1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
      GLES20.glClear(16384);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      float f3 = f2 * 0.9F + 0.1F;
      f2 = (1.0F - f2) * 0.9F + 0.1F;
      if (this.h + 1 < this.k)
      {
        float f4 = this.e / this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.b() * this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.c() / this.f;
        m = this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
        a(f3);
        a(this.jdField_b_of_type_ArrayOfFloat);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(m);
        int n = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter.a(n, null, null, this.jdField_a_of_type_JavaNioFloatBuffer);
        a(f3);
        a(this.jdField_b_of_type_ArrayOfFloat);
        Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
        Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, f4, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter.a(m, null, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_JavaNioFloatBuffer);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      a(f2);
      a(this.jdField_b_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter.a(this.jdField_a_of_type_Int, null, null, this.jdField_a_of_type_JavaNioFloatBuffer);
      f3 = this.e / this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.b() * this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.c() / this.f;
      m = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
      Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
      Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, f1, f1, 1.0F);
      a(f2);
      a(this.jdField_b_of_type_ArrayOfFloat);
      GLES20.glViewport(0, (int)(this.f * (1.0F - f3)) / 2, this.e, (int)(f3 * this.f));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaFilter.a(m, null, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glViewport(0, 0, this.e, this.f);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      return;
      f2 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQScaleFilter
 * JD-Core Version:    0.7.0.1
 */
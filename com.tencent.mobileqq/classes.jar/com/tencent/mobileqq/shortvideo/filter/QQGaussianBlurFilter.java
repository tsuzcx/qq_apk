package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.ptvfilter.GaussianBlurFilterCompose;
import java.util.List;

public class QQGaussianBlurFilter
  extends QQBaseFilter
{
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private GLImage jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage;
  private GaussianBlurFilterCompose jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose;
  private List jdField_a_of_type_JavaUtilList;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage = new GLImage();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose = new GaussianBlurFilterCompose();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.e, this.f, 33984);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
  }
  
  public void d()
  {
    super.d();
    a();
  }
  
  public void h()
  {
    if (this.g % this.i == 0)
    {
      this.h = (this.g / this.i);
      if (this.h < this.j)
      {
        Log.d("rejectliu", "scale Filter OnDrawFrame frameIndex : " + this.g + "  picRate : " + this.i + " imgSize : " + this.j + "  picIndex : " + this.h);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a((String)this.jdField_a_of_type_JavaUtilList.get(this.h));
      }
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImage.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a(k);
    k = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterGaussianBlurFilterCompose.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, k, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    this.b = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */
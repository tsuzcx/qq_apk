package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;

public class QQDrawScreenFilter
  extends QQBaseFilter
{
  public TextureRender a;
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = null;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender == null) {
      a();
    }
    boolean bool = a().a("key_draw_screen");
    int i = a().a("key_width");
    int j = a().a("key_height");
    if (bool)
    {
      QQFilterLogManager.a();
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, i, j);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_Int, null, null);
      }
      QQFilterLogManager.a("绘制到屏幕");
    }
    this.b = this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDrawScreenFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.richmedia.mediacodec.renderer;

public class TextureRender
{
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = new GPUBaseFilter();
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter = new GPUOESBaseFilter();
  
  public TextureRender()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.c();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender
 * JD-Core Version:    0.7.0.1
 */
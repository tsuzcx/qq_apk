package com.tencent.qqcamerakit.preview;

public class TextureRender
{
  private GPUBaseFilter jdField_a_of_type_ComTencentQqcamerakitPreviewGPUBaseFilter = new GPUBaseFilter();
  private GPUOESBaseFilter jdField_a_of_type_ComTencentQqcamerakitPreviewGPUOESBaseFilter = new GPUOESBaseFilter();
  
  public TextureRender()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewGPUBaseFilter.a();
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewGPUOESBaseFilter.a();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewGPUOESBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewGPUBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.TextureRender
 * JD-Core Version:    0.7.0.1
 */
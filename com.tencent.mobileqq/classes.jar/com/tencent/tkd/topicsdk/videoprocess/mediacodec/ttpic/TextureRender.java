package com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic;

public class TextureRender
{
  private GPUBaseFilter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter = new GPUBaseFilter();
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter = new GPUOESBaseFilter();
  
  public TextureRender()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.d();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.d();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.e();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.e();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUOESBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.TextureRender
 * JD-Core Version:    0.7.0.1
 */
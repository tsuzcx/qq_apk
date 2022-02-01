package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class EncodeInputSurface
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private EglCore jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a();
  }
  
  public void a(EncodeConfig paramEncodeConfig, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = new EglCore(paramEncodeConfig.a(), 1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a(paramSurface);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface
 * JD-Core Version:    0.7.0.1
 */
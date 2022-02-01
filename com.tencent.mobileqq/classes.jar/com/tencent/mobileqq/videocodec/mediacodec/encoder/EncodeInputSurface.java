package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(14)
public class EncodeInputSurface
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private EglCore jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(paramLong);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a();
  }
  
  public void a(EncodeConfig paramEncodeConfig, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore = new EglCore(paramEncodeConfig.a(), 1);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.a(paramSurface);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglSurfaceBase.b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeInputSurface
 * JD-Core Version:    0.7.0.1
 */
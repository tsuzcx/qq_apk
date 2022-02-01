package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.annotation.TargetApi;
import android.view.Surface;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.TextureRender;

@TargetApi(14)
public class EncodeInputSurface
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private EglCore jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase;
  private TextureRender jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicTextureRender;
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase;
    if (localObject != null)
    {
      ((EglSurfaceBase)localObject).a();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore;
    if (localObject != null)
    {
      ((EglCore)localObject).a();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).a();
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicTextureRender = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicTextureRender.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase.a(paramLong);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase.a();
  }
  
  public void a(EncodeConfig paramEncodeConfig, Surface paramSurface)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore = new EglCore(paramEncodeConfig.a(), 1);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase.a(paramSurface);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderEglSurfaceBase.b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicTextureRender = new TextureRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeInputSurface
 * JD-Core Version:    0.7.0.1
 */
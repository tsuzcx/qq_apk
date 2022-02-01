package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceSuperBigDecoder
  extends MagicfaceFFMepgDecoder
{
  private Runnable a;
  
  public MagicFaceSuperBigDecoder()
  {
    this.jdField_a_of_type_JavaLangRunnable = new MagicFaceSuperBigDecoder.1(this);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    int i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder();
    int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:");
      localStringBuilder.append(i);
      localStringBuilder.append(",alphaRet:");
      localStringBuilder.append(j);
      QLog.d("MagicFaceSuperBigDecoder", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder begins");
    }
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return;
    }
    this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
    if (this.d == null) {
      return;
    }
    b();
    this.jdField_a_of_type_JavaLangRunnable.run();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder ends");
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig begins");
    }
    try
    {
      this.c = new byte[817920];
      this.f = new byte[817920];
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig ends");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release begins.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label40:
      break label40;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release ends.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder
 * JD-Core Version:    0.7.0.1
 */
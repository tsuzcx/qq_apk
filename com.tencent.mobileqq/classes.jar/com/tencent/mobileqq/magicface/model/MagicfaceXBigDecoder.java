package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.qphone.base.util.QLog;

public class MagicfaceXBigDecoder
  extends MagicfaceFFMepgDecoder
{
  Object jdField_a_of_type_JavaLangObject = new Object();
  Runnable jdField_a_of_type_JavaLangRunnable = new MagicfaceXBigDecoder.1(this);
  Object jdField_b_of_type_JavaLangObject = new Object();
  Runnable jdField_b_of_type_JavaLangRunnable = new MagicfaceXBigDecoder.2(this);
  volatile boolean jdField_b_of_type_Boolean = false;
  
  public MagicfaceXBigDecoder()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder init=");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.b;
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        return;
      }
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceData.jdField_a_of_type_ArrayOfByte;
      if (this.d == null) {
        return;
      }
      b();
      if (this.c != null)
      {
        if (this.f == null) {
          return;
        }
        new Thread(this.jdField_b_of_type_JavaLangRunnable).start();
        this.jdField_a_of_type_JavaLangRunnable.run();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception=");
        localStringBuilder.append(localException.toString());
        QLog.i("MagicfaceXBigDecoder", 2, localStringBuilder.toString());
      }
    }
  }
  
  void b()
  {
    try
    {
      this.c = new byte[921600];
      this.f = new byte[921600];
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MagicfaceXBigDecoder", 2, "==MagicfaceXBigDecoder release=");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      label37:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
      super.c();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder
 * JD-Core Version:    0.7.0.1
 */
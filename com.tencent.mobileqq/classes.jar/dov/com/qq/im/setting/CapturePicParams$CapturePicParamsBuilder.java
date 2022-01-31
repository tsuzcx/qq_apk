package dov.com.qq.im.setting;

import dov.com.qq.im.QIMAIOEffectCameraCaptureUnit.Session;

public class CapturePicParams$CapturePicParamsBuilder
{
  private int jdField_a_of_type_Int;
  private QIMAIOEffectCameraCaptureUnit.Session jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public CapturePicParams$CapturePicParamsBuilder(int paramInt)
  {
    this.jdField_c_of_type_Int = 11;
    if (paramInt == 2) {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  public CapturePicParamsBuilder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder a(QIMAIOEffectCameraCaptureUnit.Session paramSession)
  {
    this.jdField_a_of_type_DovComQqImQIMAIOEffectCameraCaptureUnit$Session = paramSession;
    if (paramSession != null) {}
    switch (paramSession.curType)
    {
    default: 
      this.jdField_c_of_type_Int = 11;
      return this;
    case 0: 
      this.jdField_c_of_type_Int = 11;
      return this;
    case 1: 
      this.jdField_c_of_type_Int = 9;
      return this;
    }
    this.jdField_c_of_type_Int = 10;
    return this;
  }
  
  public CapturePicParamsBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public CapturePicParamsBuilder a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public CapturePicParams a()
  {
    return new CapturePicParams(this, null);
  }
  
  public CapturePicParamsBuilder b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public CapturePicParamsBuilder c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public CapturePicParamsBuilder d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public CapturePicParamsBuilder e(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder
 * JD-Core Version:    0.7.0.1
 */
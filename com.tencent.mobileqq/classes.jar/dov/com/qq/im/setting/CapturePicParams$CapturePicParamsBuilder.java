package dov.com.qq.im.setting;

import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import dov.com.qq.im.ae.SessionWrap;

public class CapturePicParams$CapturePicParamsBuilder
{
  public int a;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 1;
  private int d = 11;
  private int e;
  private int f = 0;
  
  public CapturePicParams$CapturePicParamsBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public CapturePicParamsBuilder a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder a(SessionWrap paramSessionWrap)
  {
    this.jdField_a_of_type_DovComQqImAeSessionWrap = paramSessionWrap;
    if (paramSessionWrap != null) {
      this.d = AIOShortVideoUtil.a(paramSessionWrap.jdField_a_of_type_Int);
    }
    return this;
  }
  
  public CapturePicParamsBuilder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public CapturePicParams a()
  {
    return new CapturePicParams(this, null);
  }
  
  public CapturePicParamsBuilder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public CapturePicParamsBuilder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.setting.CapturePicParams.CapturePicParamsBuilder
 * JD-Core Version:    0.7.0.1
 */
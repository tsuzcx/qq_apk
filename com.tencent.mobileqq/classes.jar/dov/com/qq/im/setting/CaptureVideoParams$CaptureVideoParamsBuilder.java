package dov.com.qq.im.setting;

public class CaptureVideoParams$CaptureVideoParamsBuilder
{
  public int a;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  
  public CaptureVideoParams$CaptureVideoParamsBuilder()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public CaptureVideoParamsBuilder a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public CaptureVideoParams a()
  {
    return new CaptureVideoParams(this, null);
  }
  
  public CaptureVideoParamsBuilder b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public CaptureVideoParamsBuilder c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public CaptureVideoParamsBuilder c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public CaptureVideoParamsBuilder d(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder
 * JD-Core Version:    0.7.0.1
 */
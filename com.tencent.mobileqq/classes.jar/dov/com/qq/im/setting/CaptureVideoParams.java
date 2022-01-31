package dov.com.qq.im.setting;

import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;

public class CaptureVideoParams
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = 1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  private CaptureVideoParams(CaptureVideoParams.CaptureVideoParamsBuilder paramCaptureVideoParamsBuilder)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = FlowCameraConstant.jdField_d_of_type_Int;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.a(paramCaptureVideoParamsBuilder);
    this.jdField_d_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.b(paramCaptureVideoParamsBuilder);
    this.jdField_e_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.c(paramCaptureVideoParamsBuilder);
    this.jdField_f_of_type_Boolean = CaptureVideoParams.CaptureVideoParamsBuilder.d(paramCaptureVideoParamsBuilder);
    this.jdField_a_of_type_Boolean = paramCaptureVideoParamsBuilder.jdField_a_of_type_Boolean;
    this.g = paramCaptureVideoParamsBuilder.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramCaptureVideoParamsBuilder.jdField_c_of_type_Boolean;
    this.jdField_c_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.a(paramCaptureVideoParamsBuilder);
    this.jdField_d_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.b(paramCaptureVideoParamsBuilder);
    this.h = CaptureVideoParams.CaptureVideoParamsBuilder.e(paramCaptureVideoParamsBuilder);
    this.jdField_e_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.c(paramCaptureVideoParamsBuilder);
    this.jdField_f_of_type_Int = CaptureVideoParams.CaptureVideoParamsBuilder.d(paramCaptureVideoParamsBuilder);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.setting.CaptureVideoParams
 * JD-Core Version:    0.7.0.1
 */
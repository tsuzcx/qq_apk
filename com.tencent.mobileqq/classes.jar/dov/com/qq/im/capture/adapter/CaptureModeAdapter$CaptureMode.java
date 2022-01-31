package dov.com.qq.im.capture.adapter;

public class CaptureModeAdapter$CaptureMode
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  
  public CaptureModeAdapter$CaptureMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_JavaLangString = "分段";
      return;
    case 1: 
      this.jdField_a_of_type_JavaLangString = "默认";
      return;
    case 2: 
      this.jdField_a_of_type_JavaLangString = "影集";
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_JavaLangString = "魔法";
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.CaptureModeAdapter.CaptureMode
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vashealth;

public class VSHealthConfigBean
{
  private String jdField_a_of_type_JavaLangString = "main_page_jump_url";
  private boolean jdField_a_of_type_Boolean = false;
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String toString()
  {
    return "VSHealthConfigBean{mIsRedirectAIOToMainPage=" + this.jdField_a_of_type_Boolean + ", mMainPageJumpUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.VSHealthConfigBean
 * JD-Core Version:    0.7.0.1
 */
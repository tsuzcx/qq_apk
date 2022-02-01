package com.tencent.mobileqq.loginwelcome;

public class LoginWelcomeManager$ContactsGuideInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  
  public LoginWelcomeManager$ContactsGuideInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ContactsGuideInfo|showWelcomepage=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",showConvGuideEntrance=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",friends_recomm_flag=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",groups_recomm_flag=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",url=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.ContactsGuideInfo
 * JD-Core Version:    0.7.0.1
 */
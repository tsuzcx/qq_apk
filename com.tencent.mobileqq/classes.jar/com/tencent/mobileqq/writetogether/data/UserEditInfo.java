package com.tencent.mobileqq.writetogether.data;

import androidx.annotation.NonNull;

public class UserEditInfo
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c = -1;
  public boolean c;
  public int d;
  
  public UserEditInfo() {}
  
  public UserEditInfo(UserEditInfo paramUserEditInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramUserEditInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramUserEditInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramUserEditInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramUserEditInfo.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = paramUserEditInfo.jdField_a_of_type_Boolean;
    this.c = paramUserEditInfo.c;
    this.d = paramUserEditInfo.d;
    this.jdField_b_of_type_Boolean = paramUserEditInfo.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Float = paramUserEditInfo.jdField_a_of_type_Float;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_a_of_type_Boolean).append(",").append(this.c).append(",").append(this.jdField_b_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.UserEditInfo
 * JD-Core Version:    0.7.0.1
 */
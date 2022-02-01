package com.tencent.open.agent.entity;

public class Permission
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[flag=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", isNew=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", api=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", isChecked=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.entity.Permission
 * JD-Core Version:    0.7.0.1
 */
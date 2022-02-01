package com.tencent.mobileqq.troop.navigatebar;

class BaseTroopAioMsgNavigateBarDelegate$Entity
{
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString;
  
  public BaseTroopAioMsgNavigateBarDelegate$Entity(boolean paramBoolean, String paramString1, Object paramObject, String paramString2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangObject = null;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Object b()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entity{show=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", senderUin='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseTroopAioMsgNavigateBarDelegate.Entity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.config;

public final class QConfItem
{
  @Deprecated
  public int a;
  public String a;
  
  public QConfItem(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QConfItem{taskId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfItem
 * JD-Core Version:    0.7.0.1
 */
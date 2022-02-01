package com.tencent.mobileqq.listentogether;

public class MusicExtendedReqParam
{
  public String a;
  public boolean a;
  public boolean b;
  
  public MusicExtendedReqParam(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicExtendedReqParam{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needUrl=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", needLyric=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.MusicExtendedReqParam
 * JD-Core Version:    0.7.0.1
 */
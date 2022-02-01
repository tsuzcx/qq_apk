package com.tencent.mobileqq.danmaku.tool;

public class DrawableParams
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DrawableParams{mUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDefaultUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShape=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCornerRadius=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.DrawableParams
 * JD-Core Version:    0.7.0.1
 */
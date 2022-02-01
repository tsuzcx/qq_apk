package com.tencent.mobileqq.qwallet.widget;

public class NumAnim$SpannableValue
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  int c;
  
  public NumAnim$SpannableValue(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    if ((paramString != null) && (paramInt1 <= paramString.length()) && (paramInt2 <= paramString.length())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("params invalid! valueStr:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", preffixLen:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", suffixIndex:");
    localStringBuilder.append(paramInt2);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.NumAnim.SpannableValue
 * JD-Core Version:    0.7.0.1
 */
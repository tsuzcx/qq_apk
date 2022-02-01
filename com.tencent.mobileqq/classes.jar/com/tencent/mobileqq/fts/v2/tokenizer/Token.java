package com.tencent.mobileqq.fts.v2.tokenizer;

public final class Token
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString = "word";
  private int c = 1;
  
  public Token(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(localStringBuilder.toString());
    if (!this.jdField_b_of_type_JavaLangString.equals("word"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(",type=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.c != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(",posIncr=");
      localStringBuilder.append(this.c);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.Token
 * JD-Core Version:    0.7.0.1
 */
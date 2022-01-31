package com.tencent.mobileqq.persistence.fts;

public class FTSQueryArgs
{
  public int a;
  public String a;
  public boolean a;
  public String[] a;
  public int b = -1;
  public String b;
  public boolean b;
  public int c;
  public String c;
  
  public FTSQueryArgs(String paramString, Class paramClass, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramClass.getName().replace('.', '/');
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSQueryArgs
 * JD-Core Version:    0.7.0.1
 */
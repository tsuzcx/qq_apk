package com.tencent.mobileqq.persistence.fts;

public class FTSQueryArgs
{
  public int a;
  public String a;
  public boolean a;
  public String[] a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  
  public FTSQueryArgs(String paramString, Class<? extends FTSEntity> paramClass, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_JavaLangString = paramClass.getName().replace('.', '/');
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.fts.FTSQueryArgs
 * JD-Core Version:    0.7.0.1
 */
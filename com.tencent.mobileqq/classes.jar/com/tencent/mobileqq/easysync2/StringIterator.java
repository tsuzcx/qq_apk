package com.tencent.mobileqq.easysync2;

public class StringIterator
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  
  public StringIterator(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b(int paramInt)
  {
    if (paramInt <= a()) {}
    for (boolean bool = true;; bool = false)
    {
      Changeset.a(bool, new Object[] { "!(", Integer.valueOf(paramInt), " <= ", Integer.valueOf(a()), ")" });
      return;
    }
  }
  
  int a()
  {
    return this.jdField_a_of_type_JavaLangString.length() - this.jdField_a_of_type_Int;
  }
  
  String a(int paramInt)
  {
    b(paramInt);
    String str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + paramInt);
    this.jdField_a_of_type_Int += paramInt;
    return str;
  }
  
  void a(int paramInt)
  {
    b(paramInt);
    this.jdField_a_of_type_Int += paramInt;
  }
  
  String b(int paramInt)
  {
    b(paramInt);
    return this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.StringIterator
 * JD-Core Version:    0.7.0.1
 */
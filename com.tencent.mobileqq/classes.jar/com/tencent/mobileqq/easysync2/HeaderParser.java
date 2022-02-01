package com.tencent.mobileqq.easysync2;

public class HeaderParser
{
  int jdField_a_of_type_Int;
  private char[] jdField_a_of_type_ArrayOfChar;
  int b;
  int c;
  
  private int a()
  {
    int i = 0;
    for (;;)
    {
      int j = this.jdField_a_of_type_Int;
      char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
      if (j + i >= arrayOfChar.length) {
        break;
      }
      j = arrayOfChar[(j + i)];
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfChar = null;
    this.b = 0;
    this.c = 0;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ArrayOfChar = paramString.toCharArray();
    Object localObject = this.jdField_a_of_type_ArrayOfChar;
    int j = localObject[0];
    int i = 1;
    if ((j != 90) && (localObject[1] != ':'))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Not a exports: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int += 2;
    j = a();
    if (j > 0)
    {
      int k = this.jdField_a_of_type_Int;
      this.b = Changeset.a(paramString.substring(k, k + j));
      this.jdField_a_of_type_Int += j;
      localObject = this.jdField_a_of_type_ArrayOfChar;
      j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (j + 1);
      j = localObject[j];
      if ((j != 60) && (j != 62))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Not a exports: ");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      if (62 != j) {
        i = -1;
      }
      j = a();
      if (j > 0)
      {
        k = this.jdField_a_of_type_Int;
        k = Changeset.a(paramString.substring(k, k + j));
        this.jdField_a_of_type_Int += j;
        this.c = (this.b + i * k);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Not a exports: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Not a exports: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.HeaderParser
 * JD-Core Version:    0.7.0.1
 */
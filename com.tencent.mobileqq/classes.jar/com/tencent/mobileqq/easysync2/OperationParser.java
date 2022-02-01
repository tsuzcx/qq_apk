package com.tencent.mobileqq.easysync2;

import java.util.ArrayList;
import java.util.List;

public class OperationParser
{
  int jdField_a_of_type_Int = 0;
  char[] jdField_a_of_type_ArrayOfChar;
  
  private int a()
  {
    int i = 0;
    while (this.jdField_a_of_type_Int + i < this.jdField_a_of_type_ArrayOfChar.length)
    {
      int j = this.jdField_a_of_type_ArrayOfChar[(this.jdField_a_of_type_Int + i)];
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  List<Operation> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfChar = paramString.toCharArray();
    Operation localOperation = new Operation();
    StringBuilder localStringBuilder = new StringBuilder();
    while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfChar.length)
    {
      int i;
      switch (this.jdField_a_of_type_ArrayOfChar[this.jdField_a_of_type_Int])
      {
      default: 
        this.jdField_a_of_type_Int += 1;
        localOperation.a();
        break;
      case '*': 
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localOperation.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localStringBuilder.append(paramString.substring(this.jdField_a_of_type_Int - 1, this.jdField_a_of_type_Int + i));
        }
      case '|': 
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localOperation.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localOperation.b = Changeset.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + i));
        }
      case '+': 
      case '-': 
      case '=': 
        localOperation.jdField_a_of_type_Char = this.jdField_a_of_type_ArrayOfChar[this.jdField_a_of_type_Int];
        this.jdField_a_of_type_Int += 1;
        i = a();
        if (i == 0) {
          localOperation.a();
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = (i + this.jdField_a_of_type_Int);
          break;
          localOperation.jdField_a_of_type_Int = Changeset.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + i));
          localOperation.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          localArrayList.add(localOperation);
          localStringBuilder.delete(0, localStringBuilder.length());
          localOperation = new Operation();
        }
      case '?': 
        throw new IllegalArgumentException("Hit error opcode in op stream: " + paramString);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationParser
 * JD-Core Version:    0.7.0.1
 */
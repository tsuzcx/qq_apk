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
  
  List<Operation> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfChar = paramString.toCharArray();
    Object localObject = new Operation();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = this.jdField_a_of_type_Int;
      char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
      if (i >= arrayOfChar.length) {
        break;
      }
      int j = arrayOfChar[i];
      if (j != 42)
      {
        if ((j != 43) && (j != 45) && (j != 61))
        {
          if (j != 63)
          {
            if (j != 124)
            {
              this.jdField_a_of_type_Int = (i + 1);
              ((Operation)localObject).a();
            }
            else
            {
              this.jdField_a_of_type_Int = (i + 1);
              i = a();
              if (i == 0)
              {
                ((Operation)localObject).a();
              }
              else
              {
                j = this.jdField_a_of_type_Int;
                ((Operation)localObject).b = Changeset.a(paramString.substring(j, j + i));
              }
              this.jdField_a_of_type_Int += i;
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Hit error opcode in op stream: ");
            ((StringBuilder)localObject).append(paramString);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
          i = this.jdField_a_of_type_Int;
          ((Operation)localObject).jdField_a_of_type_Char = arrayOfChar[i];
          this.jdField_a_of_type_Int = (i + 1);
          i = a();
          if (i == 0)
          {
            ((Operation)localObject).a();
          }
          else
          {
            j = this.jdField_a_of_type_Int;
            ((Operation)localObject).jdField_a_of_type_Int = Changeset.a(paramString.substring(j, j + i));
            ((Operation)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
            localArrayList.add(localObject);
            localStringBuilder.delete(0, localStringBuilder.length());
            localObject = new Operation();
          }
          this.jdField_a_of_type_Int += i;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = (i + 1);
        i = a();
        if (i == 0)
        {
          ((Operation)localObject).a();
        }
        else
        {
          j = this.jdField_a_of_type_Int;
          localStringBuilder.append(paramString.substring(j - 1, j + i));
        }
        this.jdField_a_of_type_Int += i;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationParser
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.easysync2;

import java.util.ArrayList;
import java.util.List;

public class OperationParser
{
  int a = 0;
  char[] b;
  
  private int a()
  {
    int i = 0;
    for (;;)
    {
      int j = this.a;
      char[] arrayOfChar = this.b;
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
    this.b = paramString.toCharArray();
    Object localObject = new Operation();
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = this.a;
      char[] arrayOfChar = this.b;
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
              this.a = (i + 1);
              ((Operation)localObject).a();
            }
            else
            {
              this.a = (i + 1);
              i = a();
              if (i == 0)
              {
                ((Operation)localObject).a();
              }
              else
              {
                j = this.a;
                ((Operation)localObject).c = Changeset.b(paramString.substring(j, j + i));
              }
              this.a += i;
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
          arrayOfChar = this.b;
          i = this.a;
          ((Operation)localObject).a = arrayOfChar[i];
          this.a = (i + 1);
          i = a();
          if (i == 0)
          {
            ((Operation)localObject).a();
          }
          else
          {
            j = this.a;
            ((Operation)localObject).b = Changeset.b(paramString.substring(j, j + i));
            ((Operation)localObject).d = localStringBuilder.toString();
            localArrayList.add(localObject);
            localStringBuilder.delete(0, localStringBuilder.length());
            localObject = new Operation();
          }
          this.a += i;
        }
      }
      else
      {
        this.a = (i + 1);
        i = a();
        if (i == 0)
        {
          ((Operation)localObject).a();
        }
        else
        {
          j = this.a;
          localStringBuilder.append(paramString.substring(j - 1, j + i));
        }
        this.a += i;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.OperationParser
 * JD-Core Version:    0.7.0.1
 */
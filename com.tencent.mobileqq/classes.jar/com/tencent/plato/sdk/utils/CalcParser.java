package com.tencent.plato.sdk.utils;

import java.util.ArrayList;
import java.util.Stack;

public class CalcParser
{
  static float calc(String paramString)
  {
    Object localObject = new StringBuffer(paramString);
    paramString = new ArrayList();
    int j = 0;
    int i = 0;
    if (i < ((StringBuffer)localObject).length())
    {
      int k = j;
      switch (((StringBuffer)localObject).charAt(i))
      {
      }
      for (k = j;; k = i + 1)
      {
        i += 1;
        j = k;
        break;
        if (i > j)
        {
          String str = ((StringBuffer)localObject).substring(j, i).trim();
          if (str.length() > 0) {
            paramString.add(str);
          }
        }
        paramString.add(((StringBuffer)localObject).substring(i, i + 1));
      }
    }
    if (((StringBuffer)localObject).length() > j) {
      paramString.add(((StringBuffer)localObject).substring(j, ((StringBuffer)localObject).length()).trim());
    }
    localObject = new String[paramString.size()];
    paramString.toArray((Object[])localObject);
    return calculate(parse((String[])localObject));
  }
  
  private static float calculate(String[] paramArrayOfString)
  {
    Stack localStack = new Stack();
    localStack.clear();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      if (isOperand(str)) {
        localStack.push(Float.valueOf(Dimension.parse(str).px));
      }
      for (;;)
      {
        i += 1;
        break;
        localStack.push(Float.valueOf(getValue(str, ((Float)localStack.pop()).floatValue(), ((Float)localStack.pop()).floatValue())));
      }
    }
    return ((Float)localStack.pop()).floatValue();
  }
  
  private static float getValue(String paramString, float paramFloat1, float paramFloat2)
  {
    if (paramString.equals("+")) {
      return paramFloat2 + paramFloat1;
    }
    if (paramString.equals("-")) {
      return paramFloat2 - paramFloat1;
    }
    if (paramString.equals("*")) {
      return paramFloat2 * paramFloat1;
    }
    if (paramString.equals("/")) {
      return paramFloat2 / paramFloat1;
    }
    return 0.0F;
  }
  
  private static boolean isEmpty(Stack paramStack)
  {
    return paramStack.empty();
  }
  
  private static boolean isOperand(String paramString)
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "+";
    arrayOfString[1] = "-";
    arrayOfString[2] = "*";
    arrayOfString[3] = "/";
    arrayOfString[4] = "(";
    arrayOfString[5] = ")";
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (paramString.equals(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String[] parse(String[] paramArrayOfString)
  {
    Stack localStack = new Stack();
    String[] arrayOfString = new String[paramArrayOfString.length];
    int m = paramArrayOfString.length;
    int k = 0;
    int i = 0;
    if (k < m)
    {
      String str1 = paramArrayOfString[k];
      int j;
      if (isOperand(str1))
      {
        j = i + 1;
        arrayOfString[i] = str1;
        i = j;
      }
      for (;;)
      {
        k += 1;
        break;
        if (str1.equals("("))
        {
          localStack.push(str1);
        }
        else
        {
          if (str1.equals(")"))
          {
            j = i;
            for (;;)
            {
              i = j;
              if (isEmpty(localStack)) {
                break;
              }
              str1 = (String)localStack.pop();
              i = j;
              if (str1.equals("(")) {
                break;
              }
              arrayOfString[j] = str1;
              j += 1;
            }
          }
          if (!isEmpty(localStack))
          {
            j = i;
            do
            {
              String str2 = (String)localStack.pop();
              if (priority(str1) > priority(str2))
              {
                localStack.push(str2);
                localStack.push(str1);
                i = j;
                break;
              }
              i = j + 1;
              arrayOfString[j] = str2;
              if (isEmpty(localStack))
              {
                localStack.push(str1);
                break;
              }
              j = i;
            } while (!isEmpty(localStack));
          }
          else
          {
            localStack.push(str1);
          }
        }
      }
    }
    for (;;)
    {
      if (!isEmpty(localStack))
      {
        arrayOfString[i] = ((String)localStack.pop());
        i += 1;
      }
      else
      {
        paramArrayOfString = new ArrayList();
        i = 0;
        while (i < arrayOfString.length)
        {
          if (arrayOfString[i] != null) {
            paramArrayOfString.add(arrayOfString[i]);
          }
          i += 1;
        }
        arrayOfString = new String[paramArrayOfString.size()];
        paramArrayOfString.toArray(arrayOfString);
        return arrayOfString;
      }
    }
  }
  
  private static int priority(String paramString)
  {
    int i = 0;
    if ((paramString.equals("+")) || (paramString.equals("-"))) {
      i = 1;
    }
    while ((!paramString.equals("*")) && (!paramString.equals("/"))) {
      return i;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.CalcParser
 * JD-Core Version:    0.7.0.1
 */
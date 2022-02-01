package com.tencent.qa.apphook.util;

import com.tencent.HookLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class SignatureUtil
{
  public static String queryMethodShorty(Member paramMember)
  {
    Class[] arrayOfClass = null;
    int i;
    label25:
    String str;
    if ((paramMember instanceof Method))
    {
      arrayOfClass = ((Method)paramMember).getParameterTypes();
      int j = arrayOfClass.length;
      paramMember = "";
      i = 0;
      if (i >= j) {
        return paramMember;
      }
      str = arrayOfClass[i].toString();
      if (!str.equals(Integer.TYPE.getName())) {
        break label97;
      }
      paramMember = paramMember + "I";
    }
    for (;;)
    {
      i += 1;
      break label25;
      if (!(paramMember instanceof Constructor)) {
        break;
      }
      arrayOfClass = ((Constructor)paramMember).getParameterTypes();
      break;
      label97:
      if (str.equals(Byte.TYPE.getName())) {
        paramMember = paramMember + "B";
      } else if (str.equals(Character.TYPE.getName())) {
        paramMember = paramMember + "C";
      } else if (str.equals(Short.TYPE.getName())) {
        paramMember = paramMember + "S";
      } else if (str.equals(Float.TYPE.getName())) {
        paramMember = paramMember + "F";
      } else if (str.equals(Boolean.TYPE.getName())) {
        paramMember = paramMember + "Z";
      } else if (str.equals(Long.TYPE.getName())) {
        paramMember = paramMember + "J";
      } else if (str.equals(Double.TYPE.getName())) {
        paramMember = paramMember + "D";
      } else if (str.startsWith("[")) {
        paramMember = paramMember + "L";
      } else {
        paramMember = paramMember + "L";
      }
    }
    return paramMember;
  }
  
  public static String queryReturnType(Member paramMember)
  {
    if ((paramMember instanceof Method))
    {
      paramMember = ((Method)paramMember).getReturnType().toString();
      if (paramMember.equals(Integer.TYPE.getName())) {
        return "" + "I";
      }
      if (paramMember.equals(Byte.TYPE.getName())) {
        return "" + "B";
      }
      if (paramMember.equals(Character.TYPE.getName())) {
        return "" + "C";
      }
      if (paramMember.equals(Short.TYPE.getName())) {
        return "" + "S";
      }
      if (paramMember.equals(Float.TYPE.getName())) {
        return "" + "F";
      }
      if (paramMember.equals(Boolean.TYPE.getName())) {
        return "" + "Z";
      }
      if (paramMember.equals(Long.TYPE.getName())) {
        return "" + "J";
      }
      if (paramMember.equals(Double.TYPE.getName())) {
        return "" + "D";
      }
      return "" + "L";
    }
    if ((paramMember instanceof Constructor)) {
      return "L";
    }
    return "L";
  }
  
  public static String sign(Member paramMember)
  {
    String str1 = queryMethodShorty(paramMember);
    HookLog.d("Method name is " + paramMember.getName() + " SignatureUtil sign shorty is " + str1);
    String str2 = queryReturnType(paramMember);
    HookLog.d("Method name is " + paramMember.getName() + " SignatureUtil sign ret is " + str2);
    if ((paramMember instanceof Method)) {
      return paramMember.getName() + str1 + str2;
    }
    return str1 + str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.util.SignatureUtil
 * JD-Core Version:    0.7.0.1
 */
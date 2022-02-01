package com.tencent.mobileqq.phonecontact.util;

import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import java.nio.ByteBuffer;

public class PhoneContactHelper
{
  public static String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      localObject = new StringBuffer(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((c != ' ') && (c != '-') && (c != ')') && (c != '(') && (c != '_')) {
          ((StringBuffer)localObject).append(c);
        }
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = paramString1.getBytes();
    paramString2 = paramString2.getBytes();
    paramString1 = arrayOfByte;
    if (arrayOfByte.length > 10)
    {
      paramString1 = new byte[10];
      System.arraycopy(arrayOfByte, 0, paramString1, 0, 10);
    }
    return MD5.toMD5(ByteBuffer.allocate(paramString1.length + paramString2.length).put(paramString1).put(paramString2).array());
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      paramString = String.valueOf(paramString.charAt(0)).toUpperCase();
    } else {
      paramString = "#";
    }
    String str = paramString;
    if (!StringUtil.b(paramString.charAt(0))) {
      str = "#";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.PhoneContactHelper
 * JD-Core Version:    0.7.0.1
 */
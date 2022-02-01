package com.tencent.mobileqq.msf.core.b;

import android.util.Base64;
import com.tencent.qphone.base.util.QLog;

public class a
{
  private static final String a = "JCPTZXEZ";
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.encodeToString(a(paramString.getBytes(), "JCPTZXEZ"), 3);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null) {}
    try
    {
      paramString = paramString.toCharArray();
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramString[(i % paramString.length)]));
        i += 1;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        arrayOfByte = paramArrayOfByte;
      } while (!QLog.isColorLevel());
      QLog.e("LogUtils", 2, "xor Exception! ", paramString);
    }
    return arrayOfByte;
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.a
 * JD-Core Version:    0.7.0.1
 */
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
    if (paramArrayOfByte != null) {
      try
      {
        paramString = paramString.toCharArray();
        int j = paramArrayOfByte.length;
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j)
        {
          arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramString[(i % paramString.length)]));
          i += 1;
        }
        return arrayOfByte;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LogUtils", 2, "xor Exception! ", paramString);
        }
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.a
 * JD-Core Version:    0.7.0.1
 */
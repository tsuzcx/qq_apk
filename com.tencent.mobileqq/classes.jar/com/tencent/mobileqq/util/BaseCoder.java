package com.tencent.mobileqq.util;

public class BaseCoder
{
  public static BaseCoder a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[256];
  private static char[] jdField_a_of_type_ArrayOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  protected BaseCoder()
  {
    a();
  }
  
  public static BaseCoder a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilBaseCoder == null) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqUtilBaseCoder = new BaseCoder();
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqUtilBaseCoder;
  }
  
  public String a(String paramString)
  {
    return a(paramString.getBytes()).toString();
  }
  
  public StringBuffer a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    char c;
    for (;;)
    {
      int m = paramArrayOfByte.length;
      localObject = "ic";
      if (k >= m) {
        break;
      }
      i = i << 8 | paramArrayOfByte[k] & 0xFF;
      j += 8;
      while (j > 5)
      {
        localObject = jdField_a_of_type_ArrayOfChar;
        j -= 6;
        c = localObject[(i >> j)];
        if (c == 'i') {
          localObject = "ia";
        } else if (c == '+') {
          localObject = "ib";
        } else if (c == '/') {
          localObject = "ic";
        } else {
          localObject = Character.valueOf(c);
        }
        localStringBuffer.append(localObject);
        i &= (1 << j) - 1;
      }
      k += 1;
    }
    if (j > 0)
    {
      c = jdField_a_of_type_ArrayOfChar[(i << 6 - j)];
      if (c == 'i') {
        paramArrayOfByte = "ia";
      } else if (c == '+') {
        paramArrayOfByte = "ib";
      } else if (c == '/') {
        paramArrayOfByte = (byte[])localObject;
      } else {
        paramArrayOfByte = Character.valueOf(c);
      }
      localStringBuffer.append(paramArrayOfByte);
    }
    return localStringBuffer;
  }
  
  protected void a()
  {
    int i = 0;
    for (;;)
    {
      char[] arrayOfChar = jdField_a_of_type_ArrayOfChar;
      if (i >= arrayOfChar.length) {
        break;
      }
      jdField_a_of_type_ArrayOfByte[arrayOfChar[i]] = ((byte)i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.BaseCoder
 * JD-Core Version:    0.7.0.1
 */
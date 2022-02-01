package common.qzone.component.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static long[] jdField_a_of_type_ArrayOfLong = new long[256];
  
  static
  {
    int i = 0;
    while (i < 256)
    {
      long l1 = i;
      int j = 0;
      while (j < 8)
      {
        long l2;
        if (((int)l1 & 0x1) != 0) {
          l2 = -7661587058870466123L;
        } else {
          l2 = 0L;
        }
        l1 = l1 >> 1 ^ l2;
        j += 1;
      }
      jdField_a_of_type_ArrayOfLong[i] = l1;
      i += 1;
    }
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    long l = -1L;
    int i = 0;
    while (i < j)
    {
      l = l >> 8 ^ jdField_a_of_type_ArrayOfLong[(((int)l ^ paramArrayOfByte[i]) & 0xFF)];
      i += 1;
    }
    return l;
  }
  
  public static String a(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1.getBytes());
      paramString1 = a(paramString2.digest());
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        int k = i * 2;
        char[] arrayOfChar2 = jdField_a_of_type_ArrayOfChar;
        arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
        arrayOfChar1[k] = arrayOfChar2[((byte)(j >>> 4) & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar1);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() * 2];
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.qzone.component.util.SecurityUtil
 * JD-Core Version:    0.7.0.1
 */
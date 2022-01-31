package kcsdkext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      return a(paramFile);
    }
    catch (FileNotFoundException paramFile) {}
    return null;
  }
  
  public static String a(InputStream paramInputStream)
  {
    MessageDigest localMessageDigest = null;
    String str2 = null;
    if (paramInputStream == null) {}
    for (;;)
    {
      return str2;
      if (paramInputStream != null) {}
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, i);
        }
      }
      catch (Exception localException)
      {
        if (paramInputStream != null)
        {
          try
          {
            paramInputStream.close();
            return null;
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            return null;
          }
          String str1 = b(localException.digest());
          str2 = str1;
          if (paramInputStream != null) {
            try
            {
              paramInputStream.close();
              return str1;
            }
            catch (IOException paramInputStream)
            {
              paramInputStream.printStackTrace();
              return str1;
            }
          }
        }
      }
      finally
      {
        if (paramInputStream == null) {}
      }
    }
    try
    {
      paramInputStream.close();
      throw localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 3);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append(a[(k >> 4)]);
      localStringBuilder.append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    return b(a(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kcsdkext.a
 * JD-Core Version:    0.7.0.1
 */
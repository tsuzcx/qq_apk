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
    catch (FileNotFoundException paramFile)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  public static String a(InputStream paramInputStream)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    if (paramInputStream == null) {
      return null;
    }
    if (paramInputStream != null) {}
    try
    {
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          ((MessageDigest)localObject1).update(arrayOfByte, 0, i);
        }
        localObject1 = b(((MessageDigest)localObject1).digest());
      }
      finally
      {
        if (paramInputStream != null) {
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
    }
    catch (Exception localException)
    {
      label82:
      break label82;
    }
    if (paramInputStream != null)
    {
      localObject3 = localObject4;
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return localObject3;
      }
      localObject3 = localObject2;
      if (paramInputStream != null)
      {
        localObject3 = localObject2;
        paramInputStream.close();
        localObject3 = localObject2;
      }
    }
    return localObject3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kcsdkext.a
 * JD-Core Version:    0.7.0.1
 */
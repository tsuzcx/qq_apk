package com.tencent.ttpic.baseutils.encrypt;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util
{
  private static final String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  public static String GetMD5Code(String paramString)
  {
    try
    {
      String str = new String(paramString);
      LogUtils.e(localNoSuchAlgorithmException1);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        paramString = byteToString(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
        return paramString;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        for (;;)
        {
          paramString = localNoSuchAlgorithmException1;
          Object localObject = localNoSuchAlgorithmException2;
        }
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = null;
    }
    return paramString;
  }
  
  private static String byteToArrayString(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    return strDigits[paramByte] + strDigits[(i % 16)];
  }
  
  private static String byteToNum(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    return String.valueOf(i);
  }
  
  private static String byteToString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(byteToArrayString(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getFileMD5(File paramFile)
  {
    if (!paramFile.isFile()) {
      return null;
    }
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return bytesToHexString(localMessageDigest.digest());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.encrypt.MD5Util
 * JD-Core Version:    0.7.0.1
 */
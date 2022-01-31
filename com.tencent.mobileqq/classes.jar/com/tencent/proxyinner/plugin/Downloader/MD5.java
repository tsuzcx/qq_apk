package com.tencent.proxyinner.plugin.Downloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  protected static char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static MessageDigest messagedigest = null;
  
  static
  {
    try
    {
      messagedigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  private static void appendHexPair(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = hexDigits[((paramByte & 0xF0) >> 4)];
    char c2 = hexDigits[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte)
  {
    return bufferToHex(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String bufferToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      appendHexPair(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String getFileMD5String(File paramFile)
    throws IOException
  {
    paramFile = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramFile.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      messagedigest.update(arrayOfByte, 0, i);
    }
    paramFile.close();
    return bufferToHex(messagedigest.digest());
  }
  
  public static String getMD5String(String paramString)
  {
    return getMD5String(paramString.getBytes());
  }
  
  public static String getMD5String(byte[] paramArrayOfByte)
  {
    messagedigest.update(paramArrayOfByte);
    return bufferToHex(messagedigest.digest());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.Downloader.MD5
 * JD-Core Version:    0.7.0.1
 */
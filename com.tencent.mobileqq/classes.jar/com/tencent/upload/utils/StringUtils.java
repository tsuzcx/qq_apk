package com.tencent.upload.utils;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final Pattern IPV4_REGEX = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  private static final Pattern IPV6_COMPRESS_REGEX = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4})*)?)::((?:([0-9A-Fa-f]{1,4}:)*[0-9A-Fa-f]{1,4})?)$");
  private static final Pattern IPV6_COMPRESS_REGEX_BORDER = Pattern.compile("^(::(?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5})|((?:[0-9A-Fa-f]{1,4})(?::[0-9A-Fa-f]{1,4}){5}::)$");
  private static final Pattern IPV6_STD_REGEX = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  public static final String sfEmptyString = "";
  
  public static String bytesToAscii(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        localStringBuilder.append((char)((paramArrayOfByte[i] + 256) % 256));
        i += 1;
      }
      catch (Exception paramArrayOfByte)
      {
        label53:
        break label53;
      }
    }
    paramArrayOfByte = localStringBuilder.toString();
    return paramArrayOfByte;
    return null;
  }
  
  public static byte char2Byte(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      paramChar -= '0';
      return (byte)paramChar;
    }
    char c = 'a';
    if ((paramChar >= 'a') && (paramChar <= 'f')) {}
    do
    {
      paramChar = paramChar - c + 10;
      break;
      c = 'A';
    } while ((paramChar >= 'A') && (paramChar <= 'F'));
    return 0;
  }
  
  public static String getEmptyString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      int j = i * 2;
      char c1 = paramString.charAt(j);
      char c2 = paramString.charAt(j + 1);
      arrayOfByte[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static boolean isIpv4String(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.split("\\.");
    if (paramString != null) {
      if (paramString.length != 4) {
        return false;
      }
    }
    try
    {
      int i = Integer.parseInt(paramString[0]);
      if (i > 0)
      {
        if (i > 255) {
          return false;
        }
        i = Integer.parseInt(paramString[1]);
        if (i >= 0)
        {
          if (i > 255) {
            return false;
          }
          i = Integer.parseInt(paramString[2]);
          if (i >= 0)
          {
            if (i > 255) {
              return false;
            }
            i = Integer.parseInt(paramString[3]);
            if (i >= 0) {
              return i <= 255;
            }
          }
        }
      }
      return false;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public static boolean isIpv6String(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (paramString.charAt(i) == ':') {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 7) {
      return false;
    }
    if (IPV6_STD_REGEX.matcher(paramString).matches()) {
      return true;
    }
    if (j == 7) {
      return IPV6_COMPRESS_REGEX_BORDER.matcher(paramString).matches();
    }
    return IPV6_COMPRESS_REGEX.matcher(paramString).matches();
  }
  
  public static String md5String(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      if (localObject == null) {
        return "";
      }
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i = 0;
      while (i < paramString.length)
      {
        int j = paramString[i] & 0xFF;
        if (j < 16) {
          ((StringBuffer)localObject).append(0);
        }
        ((StringBuffer)localObject).append(Integer.toHexString(j));
        i += 1;
      }
      return ((StringBuffer)localObject).toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.StringUtils
 * JD-Core Version:    0.7.0.1
 */
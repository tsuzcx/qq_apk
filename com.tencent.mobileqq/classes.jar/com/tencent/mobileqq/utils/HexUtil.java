package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

public class HexUtil
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final byte[] emptybytes = new byte[0];
  
  public static String String2HexString(String paramString)
  {
    return bytes2HexStr(paramString.getBytes());
  }
  
  public static String byte2HexStr(byte paramByte)
  {
    char[] arrayOfChar = digits;
    int i = arrayOfChar[(paramByte & 0xF)];
    return new String(new char[] { arrayOfChar[((byte)(paramByte >>> 4) & 0xF)], i });
  }
  
  public static String bytes2HexStr(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      Object localObject = new char[paramArrayOfByte.length * 2];
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.length)
        {
          int k = paramArrayOfByte[i];
          int j = i * 2;
          localObject[(j + 1)] = digits[(k & 0xF)];
          k = (byte)(k >>> 4);
          localObject[(j + 0)] = digits[(k & 0xF)];
          i += 1;
        }
        return new String((char[])localObject);
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" === bytes2HexStr error === ");
          ((StringBuilder)localObject).append(paramArrayOfByte.toString());
          QLog.d("HexUtil", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
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
  
  public static byte hexStr2Byte(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 1)) {
      return char2Byte(paramString.charAt(0));
    }
    return 0;
  }
  
  public static byte[] hexStr2Bytes(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      Object localObject = new byte[paramString.length() / 2];
      int i = 0;
      try
      {
        while (i < localObject.length)
        {
          int j = i * 2;
          char c1 = paramString.charAt(j);
          char c2 = paramString.charAt(j + 1);
          localObject[i] = ((byte)(char2Byte(c1) * 16 + char2Byte(c2)));
          i += 1;
        }
        return localObject;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" === hexStr2Bytes error === ");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("HexUtil", 2, ((StringBuilder)localObject).toString());
        }
        return emptybytes;
      }
    }
    return emptybytes;
  }
  
  public static String hexString2String(String paramString)
  {
    return new String(hexStr2Bytes(paramString));
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.currentTimeMillis();
    int i = 0;
    while (i < 1000000)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("234");
      paramArrayOfString.append(i);
      paramArrayOfString = paramArrayOfString.toString();
      new String(hexStr2Bytes(bytes2HexStr(paramArrayOfString.getBytes()))).equals(paramArrayOfString);
      i += 1;
    }
  }
  
  public static void printHexString(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      printHexStringEx(paramString, paramArrayOfByte);
    }
  }
  
  public static void printHexStringEx(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder((paramArrayOfByte.length + 15) / 16 * 73 + 85);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("buf size: ");
      localStringBuilder2.append(paramArrayOfByte.length);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("\r\n");
      localStringBuilder1.append("______00_01_02_03_04_05_06_07_08_09_0A_0B_0C_0D_0E_0F\r\n");
      localStringBuilder2 = new StringBuilder(32);
      localStringBuilder2.append(" ");
      int j = 0;
      int i = 0;
      int k = 0;
      for (;;)
      {
        if (j < paramArrayOfByte.length)
        {
          if (i == 0) {
            localStringBuilder1.append(String.format("%04x: ", new Object[] { Integer.valueOf(j) }));
          }
          localStringBuilder1.append(String.format("%02x ", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
          if ((paramArrayOfByte[j] >= 32) && (paramArrayOfByte[j] <= 127)) {
            localStringBuilder2.append(String.format("%c", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
          } else {
            localStringBuilder2.append(".");
          }
        }
        else
        {
          if (i == 0) {
            break label294;
          }
          localStringBuilder1.append("   ");
          localStringBuilder2.append(" ");
          k = 1;
        }
        int m = i + 1;
        i = m;
        if (m >= 16)
        {
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
          localStringBuilder2.setLength(1);
          if (k != 0)
          {
            label294:
            QLog.i(paramString, 2, localStringBuilder1.toString());
            return;
          }
          i = 0;
        }
        j += 1;
      }
    }
    QLog.i(paramString, 2, "bytes = null or bytes.length = 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HexUtil
 * JD-Core Version:    0.7.0.1
 */
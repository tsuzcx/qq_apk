package com.tencent.smtt.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ByteUtils
{
  public static final byte CHARACTER_ENCODING_ASCII = 0;
  public static final byte CHARACTER_ENCODING_GB18030 = 2;
  public static final byte CHARACTER_ENCODING_UTF8 = 1;
  
  public static void DWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static boolean EqualBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {}
    while (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte2.length) {
        break label41;
      }
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label41:
    return true;
  }
  
  public static void Word2Byte(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
  }
  
  public static String byteToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if ((paramArrayOfByte[i] & 0xFF) < 16) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(Long.toString(paramArrayOfByte[i] & 0xFF, 16));
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static boolean checkUtf8Char(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while ((i < paramInt2) && (paramInt1 + i < paramArrayOfByte.length))
    {
      if ((paramArrayOfByte[(paramInt1 + i)] & 0xC0) != 128) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static byte[] comByte(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = 0;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
      arrayOfByte = paramArrayOfByte2;
    }
    do
    {
      do
      {
        return arrayOfByte;
        arrayOfByte = paramArrayOfByte1;
      } while (paramArrayOfByte2 == null);
      arrayOfByte = paramArrayOfByte1;
    } while (paramArrayOfByte2.length == 0);
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfByte1.length) {
        break;
      }
      arrayOfByte[i] = paramArrayOfByte1[i];
      i += 1;
    }
    while (j < paramArrayOfByte2.length)
    {
      arrayOfByte[(paramArrayOfByte1.length + j)] = paramArrayOfByte2[j];
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static int getHashUUID(String paramString)
  {
    return hashRawString(paramString);
  }
  
  public static byte guessCharacterEncoding(byte[] paramArrayOfByte)
  {
    byte b = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i < paramArrayOfByte.length)
      {
        k = paramArrayOfByte[i];
        if ((k & 0x80) == 0)
        {
          j = (byte)(j + 1);
          i += 1;
        }
        else if ((k & 0xE0) == 192)
        {
          if (!checkUtf8Char(paramArrayOfByte, i + 1, 1)) {
            b = 2;
          }
        }
      }
    }
    while (j == paramArrayOfByte.length)
    {
      int k;
      return b;
      i += 2;
      break;
      if ((k & 0xF0) == 224)
      {
        if (!checkUtf8Char(paramArrayOfByte, i + 1, 2)) {
          return 2;
        }
        i += 3;
        break;
      }
      if ((k & 0xF8) == 240)
      {
        if (!checkUtf8Char(paramArrayOfByte, i + 1, 3)) {
          return 2;
        }
        i += 4;
        break;
      }
      if ((k & 0xFC) == 248)
      {
        if (!checkUtf8Char(paramArrayOfByte, i + 1, 4)) {
          return 2;
        }
        i += 5;
        break;
      }
      if ((k & 0xC0) == 128)
      {
        i += 1;
        break;
      }
      return 2;
    }
    return 1;
  }
  
  public static int hashRawString(String paramString)
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      int j;
      for (;;)
      {
        int k;
        paramString = paramString.getBytes();
      }
      i = (j << 3) + j;
      i ^= i >>> 11;
      i += (i << 15);
      if (i != 0) {
        break label86;
      }
      return 1;
    }
    k = paramString.length;
    j = 0;
    while (i < k)
    {
      j += paramString[i];
      j += (j << 10);
      j ^= j >>> 6;
      i += 1;
    }
    label86:
    return Math.abs(i);
  }
  
  public static byte[] hexStringToByte(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals("")) || (paramString.length() % 2 != 0)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      byte[] arrayOfByte = new byte[paramString.length() / 2];
      int i = 0;
      localObject = arrayOfByte;
      try
      {
        if (i < paramString.length())
        {
          arrayOfByte[(i / 2)] = ((byte)(Integer.parseInt(paramString.substring(i, i + 2), 16) & 0xFF));
          i += 2;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return null;
  }
  
  public static boolean isAllZeroBytes(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      bool1 = true;
      return bool1;
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label42;
      }
      bool1 = bool2;
      if (paramArrayOfByte[i] != 0) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  public static boolean isEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramArrayOfByte1 != null) {
            break;
          }
          bool1 = bool2;
        } while (paramArrayOfByte2 != null);
        if (paramArrayOfByte1 == null) {
          break;
        }
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label74;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label74:
    return true;
  }
  
  public static byte[] mergeByteData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length < 0)) {
      arrayOfByte = paramArrayOfByte2;
    }
    do
    {
      do
      {
        return arrayOfByte;
        arrayOfByte = paramArrayOfByte1;
      } while (paramArrayOfByte2 == null);
      arrayOfByte = paramArrayOfByte1;
    } while (paramArrayOfByte2.length < 0);
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static byte[] mergeListByteData(ArrayList<byte[]> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int j = paramArrayList.size();
    int i = 0;
    byte[] arrayOfByte1 = null;
    if (i < j)
    {
      if (i + 1 == j) {}
      for (byte[] arrayOfByte2 = (byte[])paramArrayList.get(i);; arrayOfByte2 = mergeByteData((byte[])paramArrayList.get(i), (byte[])paramArrayList.get(i + 1)))
      {
        arrayOfByte1 = mergeByteData(arrayOfByte2, arrayOfByte1);
        i += 2;
        break;
      }
    }
    return arrayOfByte1;
  }
  
  public static byte[] subByte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > i))
    {
      localObject = null;
      return localObject;
    }
    i = paramInt2;
    if (paramInt2 < 0) {
      i = paramArrayOfByte.length - paramInt1;
    }
    byte[] arrayOfByte = new byte[i];
    paramInt2 = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (paramInt2 >= i) {
        break;
      }
      arrayOfByte[paramInt2] = paramArrayOfByte[(paramInt2 + paramInt1)];
      paramInt2 += 1;
    }
  }
  
  public static String toHexStr(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    i -= paramByte * 16;
    char c1;
    if (paramByte > 9)
    {
      c1 = (char)(paramByte - 10 + 65);
      if (i <= 9) {
        break label132;
      }
    }
    label132:
    for (char c2 = (char)(i - 10 + 65);; c2 = (char)(i + 48))
    {
      Object localObject = new Character(c1);
      localObject = "" + ((Character)localObject).toString();
      Character localCharacter = new Character(c2);
      return (String)localObject + localCharacter.toString();
      c1 = (char)(paramByte + 48);
      break;
    }
  }
  
  public static String toHexStr(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(toHexStr(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.ByteUtils
 * JD-Core Version:    0.7.0.1
 */
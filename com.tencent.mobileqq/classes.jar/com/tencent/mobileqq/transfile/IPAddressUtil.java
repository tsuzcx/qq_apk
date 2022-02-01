package com.tencent.mobileqq.transfile;

public class IPAddressUtil
{
  private static final int INADDR16SZ = 16;
  private static final int INADDR4SZ = 4;
  private static final int INT16SZ = 2;
  
  public static byte[] convertFromIPv4MappedAddress(byte[] paramArrayOfByte)
  {
    if (isIPv4MappedAddress(paramArrayOfByte))
    {
      byte[] arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, 4);
      return arrayOfByte;
    }
    return null;
  }
  
  public static boolean isIPv4LiteralAddress(String paramString)
  {
    return textToNumericFormatV4(paramString) != null;
  }
  
  private static boolean isIPv4MappedAddress(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 16) {
      return false;
    }
    return (paramArrayOfByte[0] == 0) && (paramArrayOfByte[1] == 0) && (paramArrayOfByte[2] == 0) && (paramArrayOfByte[3] == 0) && (paramArrayOfByte[4] == 0) && (paramArrayOfByte[5] == 0) && (paramArrayOfByte[6] == 0) && (paramArrayOfByte[7] == 0) && (paramArrayOfByte[8] == 0) && (paramArrayOfByte[9] == 0) && (paramArrayOfByte[10] == -1) && (paramArrayOfByte[11] == -1);
  }
  
  public static boolean isIPv6LiteralAddress(String paramString)
  {
    return textToNumericFormatV6(paramString) != null;
  }
  
  public static byte[] textToNumericFormatV4(String paramString)
  {
    byte[] arrayOfByte = new byte[4];
    int k = paramString.length();
    if (k != 0)
    {
      if (k > 15) {
        return null;
      }
      long l = 0L;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        char c = paramString.charAt(i);
        if (c == '.')
        {
          if ((l >= 0L) && (l <= 255L))
          {
            if (j == 3) {
              return null;
            }
            arrayOfByte[j] = ((byte)(int)(l & 0xFF));
            j += 1;
            l = 0L;
          }
          else
          {
            return null;
          }
        }
        else
        {
          int m = Character.digit(c, 10);
          if (m < 0) {
            return null;
          }
          l = l * 10L + m;
        }
        i += 1;
      }
      if (l >= 0L)
      {
        if (l >= 1L << (4 - j) * 8) {
          return null;
        }
        if (j != 0)
        {
          if (j == 1) {
            break label194;
          }
          if (j == 2) {
            break label209;
          }
          if (j != 3) {
            return arrayOfByte;
          }
        }
        for (;;)
        {
          break;
          arrayOfByte[0] = ((byte)(int)(l >> 24 & 0xFF));
          label194:
          arrayOfByte[1] = ((byte)(int)(l >> 16 & 0xFF));
          label209:
          arrayOfByte[2] = ((byte)(int)(l >> 8 & 0xFF));
        }
        arrayOfByte[3] = ((byte)(int)(l >> 0 & 0xFF));
        return arrayOfByte;
      }
    }
    return null;
  }
  
  public static byte[] textToNumericFormatV6(String paramString)
  {
    if (paramString.length() < 2) {
      return null;
    }
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[16];
    int i3 = arrayOfChar.length;
    int i = paramString.indexOf("%");
    if (i == i3 - 1) {
      return null;
    }
    if (i != -1) {
      i3 = i;
    }
    if (arrayOfChar[0] == ':')
    {
      if (arrayOfChar[1] != ':') {
        return null;
      }
      j = 1;
    }
    else
    {
      j = 0;
    }
    int n = j;
    int m = 0;
    int k = 0;
    i = 0;
    int i2 = -1;
    int i4;
    int i1;
    char c;
    for (;;)
    {
      i4 = k;
      i1 = i;
      if (j >= i3) {
        break label363;
      }
      i1 = j + 1;
      c = arrayOfChar[j];
      j = Character.digit(c, 16);
      if (j != -1)
      {
        m = m << 4 | j;
        if (m > 65535) {
          return null;
        }
        j = i1;
        k = 1;
      }
      else
      {
        if (c != ':') {
          break;
        }
        if (k == 0)
        {
          if (i2 != -1) {
            return null;
          }
          j = i1;
          n = j;
          i2 = i;
        }
        else
        {
          if (i1 == i3) {
            return null;
          }
          if (i + 2 > 16) {
            return null;
          }
          j = i + 1;
          arrayOfByte[i] = ((byte)(m >> 8 & 0xFF));
          i = j + 1;
          arrayOfByte[j] = ((byte)(m & 0xFF));
          j = i1;
          n = j;
          m = 0;
          k = 0;
        }
      }
    }
    if ((c == '.') && (i + 4 <= 16))
    {
      paramString = paramString.substring(n, i3);
      k = 0;
      j = 0;
      for (;;)
      {
        k = paramString.indexOf('.', k);
        if (k == -1) {
          break;
        }
        j += 1;
        k += 1;
      }
      if (j != 3) {
        return null;
      }
      paramString = textToNumericFormatV4(paramString);
      if (paramString == null) {
        return null;
      }
      j = 0;
      while (j < 4)
      {
        arrayOfByte[i] = paramString[j];
        j += 1;
        i += 1;
      }
      i4 = 0;
      i1 = i;
    }
    else
    {
      return null;
    }
    label363:
    if (i4 != 0)
    {
      if (i1 + 2 > 16) {
        return null;
      }
      j = i1 + 1;
      arrayOfByte[i1] = ((byte)(m >> 8 & 0xFF));
      i = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
    }
    else
    {
      i = i1;
    }
    int j = i;
    if (i2 != -1)
    {
      j = i - i2;
      if (i == 16) {
        return null;
      }
      i = 1;
      while (i <= j)
      {
        k = i2 + j - i;
        arrayOfByte[(16 - i)] = arrayOfByte[k];
        arrayOfByte[k] = 0;
        i += 1;
      }
      j = 16;
    }
    if (j != 16) {
      return null;
    }
    paramString = convertFromIPv4MappedAddress(arrayOfByte);
    if (paramString != null) {
      return paramString;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.IPAddressUtil
 * JD-Core Version:    0.7.0.1
 */
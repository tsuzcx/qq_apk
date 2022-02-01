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
    if (paramArrayOfByte.length < 16) {}
    while ((paramArrayOfByte[0] != 0) || (paramArrayOfByte[1] != 0) || (paramArrayOfByte[2] != 0) || (paramArrayOfByte[3] != 0) || (paramArrayOfByte[4] != 0) || (paramArrayOfByte[5] != 0) || (paramArrayOfByte[6] != 0) || (paramArrayOfByte[7] != 0) || (paramArrayOfByte[8] != 0) || (paramArrayOfByte[9] != 0) || (paramArrayOfByte[10] != -1) || (paramArrayOfByte[11] != -1)) {
      return false;
    }
    return true;
  }
  
  public static boolean isIPv6LiteralAddress(String paramString)
  {
    return textToNumericFormatV6(paramString) != null;
  }
  
  public static byte[] textToNumericFormatV4(String paramString)
  {
    byte[] arrayOfByte = new byte[4];
    long l = 0L;
    int i = 0;
    int m = paramString.length();
    if ((m == 0) || (m > 15)) {
      return null;
    }
    int j = 0;
    if (j < m)
    {
      char c = paramString.charAt(j);
      int k;
      if (c == '.')
      {
        if ((l < 0L) || (l > 255L) || (i == 3)) {
          return null;
        }
        k = i + 1;
        arrayOfByte[i] = ((byte)(int)(l & 0xFF));
        l = 0L;
        i = k;
      }
      for (;;)
      {
        j += 1;
        break;
        k = Character.digit(c, 10);
        if (k < 0) {
          return null;
        }
        l = l * 10L + k;
      }
    }
    if ((l < 0L) || (l >= 1L << (4 - i) * 8)) {
      return null;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return arrayOfByte;
      arrayOfByte[0] = ((byte)(int)(l >> 24 & 0xFF));
      arrayOfByte[1] = ((byte)(int)(l >> 16 & 0xFF));
      arrayOfByte[2] = ((byte)(int)(l >> 8 & 0xFF));
      arrayOfByte[3] = ((byte)(int)(l >> 0 & 0xFF));
    }
  }
  
  public static byte[] textToNumericFormatV6(String paramString)
  {
    if (paramString.length() < 2)
    {
      paramString = null;
      return paramString;
    }
    Object localObject = paramString.toCharArray();
    byte[] arrayOfByte = new byte[16];
    int i3 = localObject.length;
    int i = paramString.indexOf("%");
    if (i == i3 - 1) {
      return null;
    }
    if (i != -1) {
      i3 = i;
    }
    for (;;)
    {
      i = 0;
      int j = 0;
      if (localObject[0] == ':')
      {
        i = 1;
        if (localObject[1] != ':') {
          return null;
        }
      }
      int n = 0;
      int i2 = -1;
      int i1 = i;
      int k = 0;
      int m = i;
      i = j;
      for (;;)
      {
        if (m < i3)
        {
          j = m + 1;
          char c = localObject[m];
          m = Character.digit(c, 16);
          if (m != -1)
          {
            n = n << 4 | m;
            if (n > 65535) {
              return null;
            }
            k = 1;
            m = j;
          }
          else if (c == ':')
          {
            if (k == 0)
            {
              if (i2 != -1) {
                return null;
              }
              i1 = j;
              i2 = i;
              m = j;
            }
            else
            {
              if (j == i3) {
                return null;
              }
              if (i + 2 > 16) {
                return null;
              }
              k = i + 1;
              arrayOfByte[i] = ((byte)(n >> 8 & 0xFF));
              i = k + 1;
              arrayOfByte[k] = ((byte)(n & 0xFF));
              m = j;
              n = 0;
              k = 0;
              i1 = j;
            }
          }
          else if ((c == '.') && (i + 4 <= 16))
          {
            paramString = paramString.substring(i1, i3);
            j = 0;
            k = 0;
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
            k = 0;
          }
        }
      }
      for (;;)
      {
        j = i;
        if (k != 0)
        {
          if (i + 2 > 16)
          {
            return null;
            return null;
          }
          k = i + 1;
          arrayOfByte[i] = ((byte)(n >> 8 & 0xFF));
          j = k + 1;
          arrayOfByte[k] = ((byte)(n & 0xFF));
        }
        i = j;
        if (i2 != -1)
        {
          k = j - i2;
          if (j == 16) {
            return null;
          }
          i = 1;
          while (i <= k)
          {
            arrayOfByte[(16 - i)] = arrayOfByte[(i2 + k - i)];
            arrayOfByte[(i2 + k - i)] = 0;
            i += 1;
          }
          i = 16;
        }
        if (i != 16) {
          return null;
        }
        localObject = convertFromIPv4MappedAddress(arrayOfByte);
        paramString = (String)localObject;
        if (localObject != null) {
          break;
        }
        return arrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.IPAddressUtil
 * JD-Core Version:    0.7.0.1
 */
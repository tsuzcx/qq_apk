package com.tencent.mobileqq.utils.httputils;

public class URI
{
  public static final int NAME = 0;
  public static final short URI_EXT = 7;
  public static final short URI_HTTP = 1;
  public static final short URI_HTTPS = 5;
  public static final short URI_JAVASCRIPT = 4;
  public static final short URI_MAIL = 3;
  public static final short URI_SMS = 6;
  public static final short URI_TEL = 2;
  public static final short URI_UNKNOWN = 0;
  public static final int VALUE = 1;
  private static String homePage = "3g.qq.com";
  
  public static int convertChar2Utf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (paramInt1 < 128)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)paramInt1);
      return 1;
    }
    if (paramInt1 < 2048)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 6 & 0x1F | 0xC0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 2;
    }
    if (paramInt1 < 65536)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 12 & 0xF | 0xE0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 3;
    }
    if (paramInt1 < 2097152)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 18 & 0x7 | 0xF0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 4;
    }
    return 0;
  }
  
  public static String escapePathString(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      byte[] arrayOfByte;
      if (paramBoolean) {
        arrayOfByte = PkgTools.convertUnicode2UTF8Byte(paramString);
      } else {
        arrayOfByte = paramString.getBytes();
      }
      if (arrayOfByte == null) {
        return paramString;
      }
      paramString = new byte[arrayOfByte.length * 3 + 1];
      int j = 0;
      int i = 0;
      while (j < arrayOfByte.length)
      {
        int k;
        int m;
        if (arrayOfByte[j] == 32)
        {
          k = i + 1;
          paramString[i] = 37;
          m = k + 1;
          paramString[k] = 50;
          i = m + 1;
          paramString[m] = 48;
        }
        for (;;)
        {
          break;
          if (!isUnreservedWordforPath((char)arrayOfByte[j]))
          {
            k = i + 1;
            paramString[i] = 37;
            m = arrayOfByte[j] >> 4 & 0xF;
            if (m < 10)
            {
              i = k + 1;
              paramString[k] = ((byte)(m + 48));
            }
            else
            {
              i = k + 1;
              paramString[k] = ((byte)(m + 65 - 10));
            }
            m = arrayOfByte[j] & 0xF;
            if (m < 10)
            {
              k = i + 1;
              paramString[i] = ((byte)(m + 48));
              i = k;
            }
            else
            {
              k = i + 1;
              paramString[i] = ((byte)(m + 65 - 10));
              i = k;
            }
          }
          else
          {
            k = i + 1;
            paramString[i] = arrayOfByte[j];
            i = k;
          }
        }
        j += 1;
      }
      return new String(paramString, 0, i);
    }
    return "";
  }
  
  public static String escapeString(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (paramBoolean) {
        paramString = PkgTools.convertUnicode2UTF8Byte(paramString);
      } else {
        paramString = paramString.getBytes();
      }
      byte[] arrayOfByte = new byte[paramString.length * 3 + 1];
      int j = 0;
      int i = 0;
      while (j < paramString.length)
      {
        int k;
        if (((paramString[j] < 97) || (paramString[j] > 122)) && ((paramString[j] < 65) || (paramString[j] > 90)) && ((paramString[j] < 48) || (paramString[j] > 57)) && (paramString[j] != 46) && (paramString[j] != 45) && (paramString[j] != 42) && (paramString[j] != 95))
        {
          int m;
          if (paramString[j] == 32)
          {
            k = i + 1;
            arrayOfByte[i] = 37;
            m = k + 1;
            arrayOfByte[k] = 50;
            i = m + 1;
            arrayOfByte[m] = 48;
          }
          else
          {
            k = i + 1;
            arrayOfByte[i] = 37;
            m = paramString[j] >> 4 & 0xF;
            if (m < 10)
            {
              i = k + 1;
              arrayOfByte[k] = ((byte)(m + 48));
            }
            else
            {
              i = k + 1;
              arrayOfByte[k] = ((byte)(m + 65 - 10));
            }
            m = paramString[j] & 0xF;
            if (m < 10)
            {
              k = i + 1;
              arrayOfByte[i] = ((byte)(m + 48));
              i = k;
            }
            else
            {
              k = i + 1;
              arrayOfByte[i] = ((byte)(m + 65 - 10));
              i = k;
            }
          }
        }
        else
        {
          k = i + 1;
          arrayOfByte[i] = paramString[j];
          i = k;
        }
        j += 1;
      }
      return new String(arrayOfByte, 0, i);
    }
    return "";
  }
  
  private static String fixUrl(String paramString)
  {
    try
    {
      int j = paramString.indexOf('?');
      Object localObject = paramString;
      if (paramString.indexOf("/?") <= 0)
      {
        if (j < 0) {
          return paramString;
        }
        localObject = getHost(paramString);
        int i = paramString.indexOf((String)localObject);
        if (i < 0) {
          i = 0;
        } else {
          i = ((String)localObject).length() + i;
        }
        localObject = paramString;
        if (paramString.indexOf('/', i) < 0)
        {
          localObject = new StringBuffer(paramString);
          ((StringBuffer)localObject).insert(j, '/');
          localObject = ((StringBuffer)localObject).toString();
        }
      }
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String getEscapeString(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.indexOf("?");
    Object localObject = paramString;
    if (i > 0)
    {
      if (i == paramString.length() - 1) {
        return paramString;
      }
      i += 1;
      char[] arrayOfChar = paramString.substring(i, paramString.length()).toCharArray();
      localObject = new StringBuffer();
      StringBuffer localStringBuffer1 = new StringBuffer();
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(paramString.substring(0, i));
      i = 0;
      int j = 0;
      paramString = localStringBuffer1;
      while (i < arrayOfChar.length)
      {
        if (j != 0)
        {
          if (j == 1) {
            if (arrayOfChar[i] != '&')
            {
              char c = arrayOfChar[i];
              if (!isQueryWord(c))
              {
                if ((c == '%') && (i < arrayOfChar.length - 2))
                {
                  int k = i + 1;
                  if (isHexDigit(arrayOfChar[k]))
                  {
                    int m = i + 2;
                    if (isHexDigit(arrayOfChar[m]))
                    {
                      paramString.append(arrayOfChar[i]);
                      paramString.append(arrayOfChar[k]);
                      paramString.append(arrayOfChar[m]);
                      i += 3;
                      continue;
                    }
                  }
                }
                paramString.append(escapeString(String.valueOf(arrayOfChar[i]), true));
              }
              else
              {
                paramString.append(arrayOfChar[i]);
              }
            }
            else
            {
              localStringBuffer2.append((StringBuffer)localObject);
              localStringBuffer2.append("=");
              localStringBuffer2.append(paramString.toString());
              localStringBuffer2.append("&");
              localObject = new StringBuffer();
              paramString = new StringBuffer();
              j = 0;
            }
          }
        }
        else if (arrayOfChar[i] != '=')
        {
          ((StringBuffer)localObject).append(arrayOfChar[i]);
        }
        else
        {
          paramString = new StringBuffer();
          j = 1;
        }
        i += 1;
      }
      if (j == 1)
      {
        localStringBuffer2.append((StringBuffer)localObject);
        localStringBuffer2.append("=");
        localStringBuffer2.append(paramString.toString());
      }
      else if (arrayOfChar[(arrayOfChar.length - 1)] != '&')
      {
        localStringBuffer2.append((StringBuffer)localObject);
      }
      localObject = localStringBuffer2.toString();
    }
    return localObject;
  }
  
  public static String getHost(String paramString)
  {
    int i = paramString.indexOf("://");
    if (i > 0) {
      i += 3;
    } else {
      i = 0;
    }
    int m = paramString.length();
    int j = i;
    for (;;)
    {
      k = m;
      if (j >= paramString.length()) {
        break label75;
      }
      k = paramString.charAt(j);
      if ((k == 58) || (k == 47) || (k == 63)) {
        break;
      }
      j += 1;
    }
    int k = j;
    label75:
    return paramString.substring(i, k);
  }
  
  public static short getRequestType(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() < 3) {
        return 0;
      }
      paramString = PkgTools.trim(paramString);
      if ((paramString.length() > 5) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 5), "http:"))) {
        return 1;
      }
      if ((paramString.length() > 6) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 6), "https:"))) {
        return 5;
      }
      if ((paramString.length() > 5) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 5), "wtai:"))) {
        return 2;
      }
      if ((paramString.length() > 7) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 7), "mailto:"))) {
        return 3;
      }
      if ((paramString.length() > 4) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 4), "sms:"))) {
        return 6;
      }
      if ((paramString.length() > 11) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 11), "javascript:"))) {
        return 6;
      }
      if ((paramString.length() > 4) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 4), "ext:"))) {
        return 7;
      }
    }
    return 0;
  }
  
  public static String hotFixUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = getHost(paramString);
    int i = paramString.indexOf(str) + str.length();
    paramString = paramString.replace('\\', '/');
    while ((i < paramString.length()) && (paramString.charAt(i) != '/')) {
      i += 1;
    }
    int k = paramString.indexOf('?', i);
    int j = k;
    if (k < 0) {
      j = paramString.length();
    }
    try
    {
      str = escapePathString(paramString.substring(i, j), false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, i));
      localStringBuilder.append(str);
      localStringBuilder.append(paramString.substring(j));
      str = localStringBuilder.toString();
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static boolean isHexDigit(char paramChar)
  {
    return (Character.isDigit(paramChar)) || ((paramChar >= 'A') && (paramChar <= 'F')) || ((paramChar >= 'a') && (paramChar <= 'f'));
  }
  
  public static boolean isIpAddress(String paramString)
  {
    paramString = PkgTools.split(getHost(paramString), ".");
    if (paramString.length != 4) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        int j = Integer.parseInt(paramString[i]);
        if (j >= 0)
        {
          if (j >= 255) {
            return false;
          }
          if ((j == 0) && ((i == 0) || (i == 3))) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramString) {}
    }
    return true;
    return false;
  }
  
  public static final boolean isQueryWord(char paramChar)
  {
    return (isUnreservedWord(paramChar)) || (paramChar == '$') || (paramChar == '\'') || (paramChar == '(') || (paramChar == ')') || (paramChar == '*') || (paramChar == ',') || (paramChar == ';') || (paramChar == '=') || (paramChar == ':') || (paramChar == '@') || (paramChar == '/') || (paramChar == '?');
  }
  
  public static final boolean isUnreservedWord(char paramChar)
  {
    return (Character.isDigit(paramChar)) || (Character.isLowerCase(paramChar)) || (Character.isUpperCase(paramChar)) || (paramChar == '-') || (paramChar == '_') || (paramChar == '.') || (paramChar == '!') || (paramChar == '~') || (paramChar == '+');
  }
  
  public static final boolean isUnreservedWordforPath(char paramChar)
  {
    return (Character.isDigit(paramChar)) || (Character.isLowerCase(paramChar)) || (Character.isUpperCase(paramChar)) || (paramChar == '-') || (paramChar == '_') || (paramChar == '.') || (paramChar == '!') || (paramChar == '~') || (paramChar == '+') || (paramChar == '/');
  }
  
  public static void setHomePage(String paramString)
  {
    homePage = paramString;
  }
  
  public static String unescapeString(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramString.length * 4];
    int j = 0;
    int i;
    for (int k = 0; j < paramString.length; k = i)
    {
      int m;
      if (paramString[j] == '%')
      {
        int i2 = j + 2;
        if (i2 < paramString.length)
        {
          m = 1;
          int n;
          for (i = 0; m < 3; i = n)
          {
            int i3 = j + m;
            if ((paramString[i3] <= '9') && (paramString[i3] >= '0'))
            {
              i *= 16;
              n = paramString[i3] - '0';
              n = i + n;
            }
            else
            {
              int i1;
              if (paramString[i3] <= 'F')
              {
                n = paramString[i3];
                i1 = 65;
                if (n >= 65) {
                  i *= 16;
                }
              }
              for (n = paramString[i3];; n = paramString[i3])
              {
                n = n - i1 + 10;
                break;
                n = i;
                if (paramString[i3] > 'f') {
                  break label198;
                }
                int i4 = paramString[i3];
                i1 = 97;
                n = i;
                if (i4 < 97) {
                  break label198;
                }
                i *= 16;
              }
            }
            label198:
            m += 1;
          }
          arrayOfByte[k] = ((byte)i);
          i = k + 1;
          j = i2;
          break label281;
        }
      }
      if (paramBoolean)
      {
        i = k + convertChar2Utf8(paramString[j], arrayOfByte, k);
      }
      else
      {
        m = k + 1;
        arrayOfByte[k] = ((byte)(paramString[j] >> '\b'));
        i = m + 1;
        arrayOfByte[m] = ((byte)paramString[j]);
      }
      label281:
      j += 1;
    }
    if (paramBoolean) {}
    try
    {
      paramString = PkgTools.utf8Byte2String(arrayOfByte, 0, k);
      return paramString;
    }
    catch (Exception paramString) {}
    return new String(arrayOfByte, 0, k);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.URI
 * JD-Core Version:    0.7.0.1
 */
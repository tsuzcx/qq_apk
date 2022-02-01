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
      paramArrayOfByte[(0 + paramInt2)] = ((byte)paramInt1);
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
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = "";
    }
    byte[] arrayOfByte;
    int j;
    int k;
    int m;
    for (;;)
    {
      return paramString;
      if (paramBoolean) {}
      for (arrayOfByte = PkgTools.convertUnicode2UTF8Byte(paramString); arrayOfByte != null; arrayOfByte = paramString.getBytes())
      {
        paramString = new byte[arrayOfByte.length * 3 + 1];
        j = 0;
        i = 0;
        for (;;)
        {
          if (j >= arrayOfByte.length) {
            break label258;
          }
          if (arrayOfByte[j] != 32) {
            break;
          }
          k = i + 1;
          paramString[i] = 37;
          m = k + 1;
          paramString[k] = 50;
          i = m + 1;
          paramString[m] = 48;
          j += 1;
        }
      }
    }
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
      for (;;)
      {
        m = arrayOfByte[j] & 0xF;
        if (m >= 10) {
          break label217;
        }
        paramString[i] = ((byte)(m + 48));
        i += 1;
        break;
        i = k + 1;
        paramString[k] = ((byte)(m + 65 - 10));
      }
      label217:
      k = i + 1;
      paramString[i] = ((byte)(m + 65 - 10));
    }
    for (int i = k;; i = k)
    {
      break;
      k = i + 1;
      paramString[i] = arrayOfByte[j];
    }
    label258:
    return new String(paramString, 0, i);
  }
  
  public static String escapeString(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    byte[] arrayOfByte;
    int j;
    int i;
    if (paramBoolean)
    {
      paramString = PkgTools.convertUnicode2UTF8Byte(paramString);
      arrayOfByte = new byte[paramString.length * 3 + 1];
      j = 0;
      i = 0;
      label37:
      if (j >= paramString.length) {
        break label314;
      }
      if (((paramString[j] < 97) || (paramString[j] > 122)) && ((paramString[j] < 65) || (paramString[j] > 90)) && ((paramString[j] < 48) || (paramString[j] > 57)) && (paramString[j] != 46) && (paramString[j] != 45) && (paramString[j] != 42) && (paramString[j] != 95)) {
        break label149;
      }
      arrayOfByte[i] = paramString[j];
      i += 1;
    }
    for (;;)
    {
      j += 1;
      break label37;
      paramString = paramString.getBytes();
      break;
      label149:
      int k;
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
        for (;;)
        {
          k = paramString[j] & 0xF;
          if (k >= 10) {
            break label294;
          }
          arrayOfByte[i] = ((byte)(k + 48));
          i += 1;
          break;
          i = k + 1;
          arrayOfByte[k] = ((byte)(m + 65 - 10));
        }
        label294:
        arrayOfByte[i] = ((byte)(k + 65 - 10));
        i += 1;
      }
    }
    label314:
    return new String(arrayOfByte, 0, i);
  }
  
  private static String fixUrl(String paramString)
  {
    try
    {
      int j = paramString.indexOf('?');
      if (paramString.indexOf("/?") <= 0)
      {
        if (j < 0) {
          return paramString;
        }
        Object localObject = getHost(paramString);
        int i = paramString.indexOf((String)localObject);
        if (i < 0) {}
        int k;
        for (i = 0; paramString.indexOf('/', i) < 0; i = k + i)
        {
          localObject = new StringBuffer(paramString);
          ((StringBuffer)localObject).insert(j, '/');
          return ((StringBuffer)localObject).toString();
          k = ((String)localObject).length();
        }
      }
      return paramString;
    }
    catch (Exception localException) {}
  }
  
  public static String getEscapeString(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      localObject = "";
    }
    do
    {
      do
      {
        return localObject;
        i = paramString.indexOf("?");
        localObject = paramString;
      } while (i <= 0);
      localObject = paramString;
    } while (i == paramString.length() - 1);
    char[] arrayOfChar = paramString.substring(i + 1, paramString.length()).toCharArray();
    Object localObject = new StringBuffer();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    localStringBuffer2.append(paramString.substring(0, i + 1));
    int j = 0;
    paramString = localStringBuffer1;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      switch (j)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfChar[i] != '=')
        {
          ((StringBuffer)localObject).append(arrayOfChar[i]);
        }
        else
        {
          paramString = new StringBuffer();
          j = 1;
          continue;
          if (arrayOfChar[i] != '&')
          {
            char c = arrayOfChar[i];
            if (!isQueryWord(c))
            {
              if ((c == '%') && (i < arrayOfChar.length - 2) && (isHexDigit(arrayOfChar[(i + 1)])) && (isHexDigit(arrayOfChar[(i + 2)])))
              {
                paramString.append(arrayOfChar[i]);
                paramString.append(arrayOfChar[(i + 1)]);
                paramString.append(arrayOfChar[(i + 2)]);
                i += 3;
                break;
              }
              paramString.append(escapeString(String.valueOf(arrayOfChar[i]), true));
              continue;
            }
            paramString.append(arrayOfChar[i]);
            continue;
          }
          localStringBuffer2.append((StringBuffer)localObject).append("=").append(paramString.toString()).append("&");
          localObject = new StringBuffer();
          paramString = new StringBuffer();
          j = 0;
        }
      }
    }
    if (j == 1) {
      localStringBuffer2.append((StringBuffer)localObject).append("=").append(paramString.toString());
    }
    for (;;)
    {
      return localStringBuffer2.toString();
      if (arrayOfChar[(arrayOfChar.length - 1)] != '&') {
        localStringBuffer2.append((StringBuffer)localObject);
      }
    }
  }
  
  public static String getHost(String paramString)
  {
    int i = paramString.indexOf("://");
    int m;
    int j;
    if (i > 0)
    {
      i += 3;
      m = paramString.length();
      j = i;
      label23:
      if (j >= paramString.length()) {
        break label84;
      }
      int n = paramString.charAt(j);
      k = j;
      if (n != 58)
      {
        k = j;
        if (n != 47) {
          if (n != 63) {
            break label77;
          }
        }
      }
    }
    label77:
    label84:
    for (int k = j;; k = m)
    {
      return paramString.substring(i, k);
      i = 0;
      break;
      j += 1;
      break label23;
    }
  }
  
  public static short getRequestType(String paramString)
  {
    short s = 5;
    if ((paramString == null) || (paramString.length() < 3)) {
      s = 0;
    }
    do
    {
      return s;
      paramString = PkgTools.trim(paramString);
      if ((paramString.length() > 5) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 5), "http:"))) {
        return 1;
      }
    } while ((paramString.length() > 6) && (PkgTools.equalsIgnoreCase(paramString.substring(0, 6), "https:")));
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
    return 0;
  }
  
  public static String hotFixUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = getHost(paramString);
    int i = paramString.indexOf(str);
    i = str.length() + i;
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
      str = paramString.substring(0, i) + str + paramString.substring(j);
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
    if (paramString.length != 4) {}
    for (;;)
    {
      return false;
      int i = 0;
      if (i < 4) {}
      try
      {
        int j = Integer.parseInt(paramString[i]);
        if ((j >= 0) && (j < 255) && ((j != 0) || ((i != 0) && (i != 3)))) {
          i += 1;
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
    int k = 0;
    if (j < paramString.length)
    {
      int m;
      int i;
      if ((paramString[j] == '%') && (j + 2 < paramString.length))
      {
        m = 1;
        int n = 0;
        if (m < 3)
        {
          if ((paramString[(j + m)] <= '9') && (paramString[(j + m)] >= '0')) {
            i = n * 16 + (paramString[(j + m)] - '0');
          }
          for (;;)
          {
            m += 1;
            n = i;
            break;
            if ((paramString[(j + m)] <= 'F') && (paramString[(j + m)] >= 'A'))
            {
              i = n * 16 + (paramString[(j + m)] - 'A' + 10);
            }
            else
            {
              i = n;
              if (paramString[(j + m)] <= 'f')
              {
                i = n;
                if (paramString[(j + m)] >= 'a') {
                  i = n * 16 + (paramString[(j + m)] - 'a' + 10);
                }
              }
            }
          }
        }
        arrayOfByte[k] = ((byte)n);
        j += 2;
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
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
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.URI
 * JD-Core Version:    0.7.0.1
 */
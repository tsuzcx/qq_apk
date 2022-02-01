package org.apache.commons.lang;

public class WordUtils
{
  public static String abbreviate(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString1.length() == 0) {
      return "";
    }
    int i = paramInt1;
    if (paramInt1 > paramString1.length()) {
      i = paramString1.length();
    }
    if (paramInt2 != -1)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= paramString1.length()) {}
    }
    else
    {
      paramInt1 = paramString1.length();
    }
    paramInt2 = paramInt1;
    if (paramInt1 < i) {
      paramInt2 = i;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramInt1 = StringUtils.indexOf(paramString1, " ", i);
    if (paramInt1 == -1)
    {
      localStringBuffer.append(paramString1.substring(0, paramInt2));
      if (paramInt2 != paramString1.length()) {
        localStringBuffer.append(StringUtils.defaultString(paramString2));
      }
    }
    else if (paramInt1 > paramInt2)
    {
      localStringBuffer.append(paramString1.substring(0, paramInt2));
      localStringBuffer.append(StringUtils.defaultString(paramString2));
    }
    else
    {
      localStringBuffer.append(paramString1.substring(0, paramInt1));
      localStringBuffer.append(StringUtils.defaultString(paramString2));
    }
    return localStringBuffer.toString();
  }
  
  public static String capitalize(String paramString)
  {
    return capitalize(paramString, null);
  }
  
  public static String capitalize(String paramString, char[] paramArrayOfChar)
  {
    int i;
    if (paramArrayOfChar == null) {
      i = -1;
    } else {
      i = paramArrayOfChar.length;
    }
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0)
      {
        if (i == 0) {
          return paramString;
        }
        int k = paramString.length();
        localObject = new StringBuffer(k);
        int j = 0;
        i = 1;
        while (j < k)
        {
          char c = paramString.charAt(j);
          if (isDelimiter(c, paramArrayOfChar))
          {
            ((StringBuffer)localObject).append(c);
            i = 1;
          }
          else if (i != 0)
          {
            ((StringBuffer)localObject).append(Character.toTitleCase(c));
            i = 0;
          }
          else
          {
            ((StringBuffer)localObject).append(c);
          }
          j += 1;
        }
        localObject = ((StringBuffer)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String capitalizeFully(String paramString)
  {
    return capitalizeFully(paramString, null);
  }
  
  public static String capitalizeFully(String paramString, char[] paramArrayOfChar)
  {
    int i;
    if (paramArrayOfChar == null) {
      i = -1;
    } else {
      i = paramArrayOfChar.length;
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0)
      {
        if (i == 0) {
          return paramString;
        }
        str = capitalize(paramString.toLowerCase(), paramArrayOfChar);
      }
    }
    return str;
  }
  
  public static String initials(String paramString)
  {
    return initials(paramString, null);
  }
  
  public static String initials(String paramString, char[] paramArrayOfChar)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0)) {
        return "";
      }
      int i1 = paramString.length();
      localObject = new char[i1 / 2 + 1];
      int j = 0;
      int k = 0;
      int i;
      for (int m = 1; j < i1; m = i)
      {
        char c = paramString.charAt(j);
        int n;
        if (isDelimiter(c, paramArrayOfChar))
        {
          i = 1;
          n = k;
        }
        else
        {
          n = k;
          i = m;
          if (m != 0)
          {
            localObject[k] = c;
            n = k + 1;
            i = 0;
          }
        }
        j += 1;
        k = n;
      }
      localObject = new String((char[])localObject, 0, k);
    }
    return localObject;
  }
  
  private static boolean isDelimiter(char paramChar, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return Character.isWhitespace(paramChar);
    }
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      if (paramChar == paramArrayOfChar[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String swapCase(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      int j = paramString.length();
      if (j == 0) {
        return paramString;
      }
      localObject = new StringBuffer(j);
      int i = 0;
      boolean bool = true;
      while (i < j)
      {
        char c2 = paramString.charAt(i);
        char c1;
        if (Character.isUpperCase(c2)) {
          c1 = Character.toLowerCase(c2);
        } else if (Character.isTitleCase(c2)) {
          c1 = Character.toLowerCase(c2);
        } else if (Character.isLowerCase(c2))
        {
          if (bool) {
            c1 = Character.toTitleCase(c2);
          } else {
            c1 = Character.toUpperCase(c2);
          }
        }
        else {
          c1 = c2;
        }
        ((StringBuffer)localObject).append(c1);
        bool = Character.isWhitespace(c2);
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public static String uncapitalize(String paramString)
  {
    return uncapitalize(paramString, null);
  }
  
  public static String uncapitalize(String paramString, char[] paramArrayOfChar)
  {
    int i;
    if (paramArrayOfChar == null) {
      i = -1;
    } else {
      i = paramArrayOfChar.length;
    }
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0)
      {
        if (i == 0) {
          return paramString;
        }
        int k = paramString.length();
        localObject = new StringBuffer(k);
        int j = 0;
        i = 1;
        while (j < k)
        {
          char c = paramString.charAt(j);
          if (isDelimiter(c, paramArrayOfChar))
          {
            ((StringBuffer)localObject).append(c);
            i = 1;
          }
          else if (i != 0)
          {
            ((StringBuffer)localObject).append(Character.toLowerCase(c));
            i = 0;
          }
          else
          {
            ((StringBuffer)localObject).append(c);
          }
          j += 1;
        }
        localObject = ((StringBuffer)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String wrap(String paramString, int paramInt)
  {
    return wrap(paramString, paramInt, null, false);
  }
  
  public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return null;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = SystemUtils.LINE_SEPARATOR;
    }
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    int j = paramString1.length();
    paramInt = 0;
    paramString2 = new StringBuffer(j + 32);
    while (j - paramInt > i) {
      if (paramString1.charAt(paramInt) == ' ')
      {
        paramInt += 1;
      }
      else
      {
        int k = i + paramInt;
        int m = paramString1.lastIndexOf(' ', k);
        if (m >= paramInt)
        {
          paramString2.append(paramString1.substring(paramInt, m));
          paramString2.append(str);
          paramInt = m + 1;
        }
        else if (paramBoolean)
        {
          paramString2.append(paramString1.substring(paramInt, k));
          paramString2.append(str);
          paramInt = k;
        }
        else
        {
          k = paramString1.indexOf(' ', k);
          if (k >= 0)
          {
            paramString2.append(paramString1.substring(paramInt, k));
            paramString2.append(str);
            paramInt = k + 1;
          }
          else
          {
            paramString2.append(paramString1.substring(paramInt));
            paramInt = j;
          }
        }
      }
    }
    paramString2.append(paramString1.substring(paramInt));
    return paramString2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.WordUtils
 * JD-Core Version:    0.7.0.1
 */
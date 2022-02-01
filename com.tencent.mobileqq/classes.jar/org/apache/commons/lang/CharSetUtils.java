package org.apache.commons.lang;

import org.apache.commons.lang.text.StrBuilder;

public class CharSetUtils
{
  public static int count(String paramString1, String paramString2)
  {
    if (!StringUtils.isEmpty(paramString1))
    {
      if (StringUtils.isEmpty(paramString2)) {
        return 0;
      }
      return count(paramString1, new String[] { paramString2 });
    }
    return 0;
  }
  
  public static int count(String paramString, String[] paramArrayOfString)
  {
    boolean bool = StringUtils.isEmpty(paramString);
    int i = 0;
    if (!bool)
    {
      if (ArrayUtils.isEmpty(paramArrayOfString)) {
        return 0;
      }
      paramArrayOfString = CharSet.getInstance(paramArrayOfString);
      paramString = paramString.toCharArray();
      int m = paramString.length;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (paramArrayOfString.contains(paramString[i])) {
          k = j + 1;
        }
        i += 1;
      }
      return j;
    }
    return 0;
  }
  
  public static String delete(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!StringUtils.isEmpty(paramString1))
    {
      if (StringUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      str = delete(paramString1, new String[] { paramString2 });
    }
    return str;
  }
  
  public static String delete(String paramString, String[] paramArrayOfString)
  {
    String str = paramString;
    if (!StringUtils.isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfString)) {
        return paramString;
      }
      str = modify(paramString, paramArrayOfString, false);
    }
    return str;
  }
  
  public static CharSet evaluateSet(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    return new CharSet(paramArrayOfString);
  }
  
  public static String keep(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    if ((paramString1.length() != 0) && (!StringUtils.isEmpty(paramString2))) {
      return keep(paramString1, new String[] { paramString2 });
    }
    return "";
  }
  
  public static String keep(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null) {
      return null;
    }
    if ((paramString.length() != 0) && (!ArrayUtils.isEmpty(paramArrayOfString))) {
      return modify(paramString, paramArrayOfString, true);
    }
    return "";
  }
  
  private static String modify(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramArrayOfString = CharSet.getInstance(paramArrayOfString);
    StrBuilder localStrBuilder = new StrBuilder(paramString.length());
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString.contains(paramString[i]) == paramBoolean) {
        localStrBuilder.append(paramString[i]);
      }
      i += 1;
    }
    return localStrBuilder.toString();
  }
  
  public static String squeeze(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!StringUtils.isEmpty(paramString1))
    {
      if (StringUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      str = squeeze(paramString1, new String[] { paramString2 });
    }
    return str;
  }
  
  public static String squeeze(String paramString, String[] paramArrayOfString)
  {
    Object localObject = paramString;
    if (!StringUtils.isEmpty(paramString))
    {
      if (ArrayUtils.isEmpty(paramArrayOfString)) {
        return paramString;
      }
      paramArrayOfString = CharSet.getInstance(paramArrayOfString);
      localObject = new StrBuilder(paramString.length());
      paramString = paramString.toCharArray();
      int j = paramString.length;
      char c2 = ' ';
      int i = 0;
      while (i < j)
      {
        char c1 = paramString[i];
        if ((!paramArrayOfString.contains(c1)) || (c1 != c2) || (i == 0))
        {
          ((StrBuilder)localObject).append(c1);
          c2 = c1;
        }
        i += 1;
      }
      localObject = ((StrBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String translate(String paramString1, String paramString2, String paramString3)
  {
    if (StringUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramString1.length());
    paramString1 = paramString1.toCharArray();
    char[] arrayOfChar = paramString3.toCharArray();
    int n = paramString1.length;
    int k = paramString3.length() - 1;
    int i = 0;
    while (i < n)
    {
      int m = paramString2.indexOf(paramString1[i]);
      if (m != -1)
      {
        int j = m;
        if (m > k) {
          j = k;
        }
        localStrBuilder.append(arrayOfChar[j]);
      }
      else
      {
        localStrBuilder.append(paramString1[i]);
      }
      i += 1;
    }
    return localStrBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.CharSetUtils
 * JD-Core Version:    0.7.0.1
 */
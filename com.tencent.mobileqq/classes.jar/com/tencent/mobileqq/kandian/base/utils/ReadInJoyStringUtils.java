package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;

public class ReadInJoyStringUtils
{
  private static String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "&lt;", "<" };
    String[] arrayOfString2 = { "&aring;", "å" };
    String[] arrayOfString3 = { "&ccedil;", "ç" };
    String[] arrayOfString4 = { "&ocirc;", "ô" };
    String[] arrayOfString5 = { "&Oslash;", "Ø" };
    String[] arrayOfString6 = { "&szlig;", "ß" };
    String[] arrayOfString7 = { "&Uuml;", "Ü" };
    a = new String[][] { arrayOfString1, { "&gt;", ">" }, { "&amp;", "&" }, { "&quot;", "\"" }, { "&agrave;", "à" }, { "&Agrave;", "À" }, { "&acirc;", "â" }, { "&auml;", "ä" }, { "&Auml;", "Ä" }, { "&Acirc;", "Â" }, arrayOfString2, { "&Aring;", "Å" }, { "&aelig;", "æ" }, { "&AElig;", "Æ" }, arrayOfString3, { "&Ccedil;", "Ç" }, { "&eacute;", "é" }, { "&Eacute;", "É" }, { "&egrave;", "è" }, { "&Egrave;", "È" }, { "&ecirc;", "ê" }, { "&Ecirc;", "Ê" }, { "&euml;", "ë" }, { "&Euml;", "Ë" }, { "&iuml;", "ï" }, { "&Iuml;", "Ï" }, arrayOfString4, { "&Ocirc;", "Ô" }, { "&ouml;", "ö" }, { "&Ouml;", "Ö" }, { "&oslash;", "ø" }, arrayOfString5, arrayOfString6, { "&ugrave;", "ù" }, { "&Ugrave;", "Ù" }, { "&ucirc;", "û" }, { "&Ucirc;", "Û" }, { "&uuml;", "ü" }, arrayOfString7, { "&nbsp;", " " }, { "&copy;", "©" }, { "&reg;", "®" }, { "&euro;", "₠" } };
  }
  
  public static String a(String paramString)
  {
    int i = paramString.length();
    while ((i > 0) && (paramString.charAt(i - 1) <= ' ')) {
      i -= 1;
    }
    String str = paramString;
    if (i < paramString.length()) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.indexOf("&", paramInt);
    Object localObject = paramString;
    if (i > -1)
    {
      paramInt = paramString.indexOf(";", i);
      localObject = paramString;
      if (paramInt > i)
      {
        int j = paramInt + 1;
        localObject = paramString.substring(i, j);
        paramInt = 0;
        for (;;)
        {
          String[][] arrayOfString = a;
          if ((paramInt >= arrayOfString.length) || (arrayOfString[paramInt][0].equals(localObject))) {
            break;
          }
          paramInt += 1;
        }
        localObject = paramString;
        if (paramInt < a.length)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.substring(0, i));
          ((StringBuilder)localObject).append(a[paramInt][1]);
          ((StringBuilder)localObject).append(paramString.substring(j));
          localObject = a(((StringBuilder)localObject).toString(), i);
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2, char paramChar)
  {
    Object localObject = paramString1;
    if (paramString1 != null)
    {
      localObject = paramString1;
      if (paramString2 != null)
      {
        if (paramString2.isEmpty()) {
          return paramString1;
        }
        localObject = new StringBuilder();
        int k = paramString1.length();
        paramString1 = paramString1.toCharArray();
        int i = 0;
        while (i < k)
        {
          if (k - i >= paramString2.length())
          {
            int j = 0;
            while (j < paramString2.length())
            {
              if (paramString1[(i + j)] != paramString2.charAt(j))
              {
                j = 0;
                break label107;
              }
              j += 1;
            }
            j = 1;
            label107:
            if (j != 0)
            {
              ((StringBuilder)localObject).append(paramChar);
              i += paramString2.length() - 1;
            }
            else
            {
              ((StringBuilder)localObject).append(paramString1[i]);
            }
          }
          else
          {
            ((StringBuilder)localObject).append(paramString1[i]);
          }
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() < 8)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(paramString.length());
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 8));
    localStringBuilder.append("|");
    localStringBuilder.append(paramString.length());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils
 * JD-Core Version:    0.7.0.1
 */
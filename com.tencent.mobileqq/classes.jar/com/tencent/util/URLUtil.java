package com.tencent.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class URLUtil
{
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get(paramString));
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    int n = -1;
    int k = 0;
    int j;
    for (int i = -1;; i = j)
    {
      j = n;
      if (k >= localStringBuilder.length()) {
        break;
      }
      if (localStringBuilder.charAt(k) != '?')
      {
        j = i;
        if (localStringBuilder.charAt(k) != '&') {}
      }
      else
      {
        m = k + 1;
        if (paramString2.equals(localStringBuilder.substring(m, paramString2.length() + m)))
        {
          j = m;
        }
        else
        {
          j = i;
          if (i > 0)
          {
            j = m;
            break;
          }
        }
      }
      k += 1;
    }
    if (i < 0) {
      return paramString1;
    }
    int m = j;
    k = i;
    if (j < 0)
    {
      k = i - 1;
      m = localStringBuilder.length();
    }
    paramString1 = new StringBuilder();
    paramString1.append(localStringBuilder.substring(0, k));
    paramString1.append(localStringBuilder.substring(m, localStringBuilder.length()));
    return paramString1.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    char c = '?';
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    if (i != -1) {
      c = '&';
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(a(paramString2));
    localStringBuilder.append('=');
    localStringBuilder.append(a(paramString3));
    paramString3 = localStringBuilder.toString();
    if (j == -1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString1 = paramString2;
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1.substring(0, j));
      paramString2.append(paramString3);
      paramString2.append(paramString1.substring(j));
      paramString1 = paramString2;
    }
    return paramString1.toString();
  }
  
  public static String a(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static Map<String, String> a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      if (-1 != i)
      {
        paramString = b(paramString.substring(i + 1));
        break label32;
      }
    }
    paramString = null;
    label32:
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new HashMap();
    }
    return localObject;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return false;
      }
      try
      {
        paramString = new URI(paramString);
        if (paramString.getHost() == null) {
          return false;
        }
        return (paramString.getScheme().equalsIgnoreCase("http")) || (paramString.getScheme().equalsIgnoreCase("https"));
      }
      catch (URISyntaxException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    char c = '?';
    int i = paramString1.indexOf('?');
    int j = paramString1.indexOf('#');
    if (i != -1) {
      c = '&';
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append(paramString2);
    localStringBuilder.append('=');
    localStringBuilder.append(paramString3);
    paramString3 = localStringBuilder.toString();
    if (j == -1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString1 = paramString2;
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1.substring(0, j));
      paramString2.append(paramString3);
      paramString2.append(paramString1.substring(j));
      paramString1 = paramString2;
    }
    return paramString1.toString();
  }
  
  public static Map<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString) {}
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.URLUtil
 * JD-Core Version:    0.7.0.1
 */
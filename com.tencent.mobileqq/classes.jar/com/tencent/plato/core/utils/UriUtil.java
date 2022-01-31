package com.tencent.plato.core.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.net.URLDecoder;

public class UriUtil
{
  public static Uri addLongParam(Uri paramUri, String paramString, long paramLong)
  {
    return paramUri.buildUpon().appendQueryParameter(paramString, String.valueOf(paramLong)).build();
  }
  
  public static Uri addParam(Uri paramUri, String paramString1, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
  }
  
  public static boolean getFragmentBooleanParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = getFragmentParam(paramString1, paramString2, null);
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      bool = Boolean.parseBoolean(paramString1);
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramBoolean;
  }
  
  public static long getFragmentLongParam(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = getFragmentParam(paramString1, paramString2, null);
    long l = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l = Long.parseLong(paramString1);
      return l;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramLong;
  }
  
  public static String getFragmentParam(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return paramString3;
      paramString1 = paramString1.split("&");
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        int k = localObject.indexOf('=');
        if ((k != -1) && (TextUtils.equals(paramString2, localObject.substring(0, k)))) {
          return URLDecoder.decode(localObject.substring(k + 1));
        }
        i += 1;
      }
    }
  }
  
  public static long getLongParam(Uri paramUri, String paramString, long paramLong)
  {
    paramUri = getQueryParameter(paramUri, paramString);
    long l = paramLong;
    if (!TextUtils.isEmpty(paramUri)) {}
    try
    {
      l = Long.parseLong(paramUri);
      return l;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return paramLong;
  }
  
  public static String getParam(Uri paramUri, String paramString1, String paramString2)
  {
    paramUri = getQueryParameter(paramUri, paramString1);
    if (paramUri != null) {
      return paramUri;
    }
    return paramString2;
  }
  
  public static String getQueryParameter(Uri paramUri, String paramString)
  {
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return null;
    }
    int k = paramUri.length();
    int m = paramString.length();
    int i = 0;
    label69:
    do
    {
      for (;;)
      {
        i = paramUri.indexOf(paramString, i);
        if (i == -1) {
          break;
        }
        if (i <= 0) {
          break label69;
        }
        j = paramUri.charAt(i - 1);
        if ((j == 63) || (j == 38)) {
          break label69;
        }
        i += m;
      }
      j = i + m;
      if (k == j) {
        break;
      }
      i = j;
    } while (paramUri.charAt(j) != '=');
    i = j + 1;
    int j = paramUri.indexOf('&', i);
    if (j == -1) {}
    for (paramUri = paramUri.substring(i);; paramUri = paramUri.substring(i, j)) {
      return Uri.decode(paramUri);
    }
  }
  
  private static boolean matchQueryParameter(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    int i = paramString2.length();
    boolean bool1 = bool2;
    if (paramString1.regionMatches(paramBoolean, paramInt, paramString2, 0, i)) {
      if (paramString1.length() != paramInt + i)
      {
        bool1 = bool2;
        if (paramString1.charAt(paramInt + i) != '&') {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean readBooleanQueryParameter(Uri paramUri, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {}
    int i;
    do
    {
      return paramBoolean;
      i = paramUri.indexOf(paramString);
    } while (i == -1);
    i += paramString.length();
    if ((!matchQueryParameter(paramUri, i, "=0", false)) && (!matchQueryParameter(paramUri, i, "=false", true))) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */
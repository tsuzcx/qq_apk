package com.tencent.mobileqq.litelivesdk.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UriUtil
{
  public static String a(String paramString)
  {
    return a(paramString, 2).toLowerCase();
  }
  
  public static String a(String paramString, int paramInt)
  {
    str = "";
    localObject = str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = str;
      if (paramInt <= 0) {}
    }
    try
    {
      paramString = Uri.parse(paramString);
      localObject = str;
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        localObject = str;
        if (paramString != null)
        {
          paramString = paramString.split("\\.");
          localObject = str;
          if (paramString.length > 0)
          {
            int i = Math.max(0, paramString.length - (paramInt + 1));
            localObject = new StringBuilder(256);
            ((StringBuilder)localObject).append(paramString[i]);
            i += 1;
            while (i < paramString.length)
            {
              ((StringBuilder)localObject).append('.').append(paramString[i]);
              i += 1;
            }
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        localObject = str;
      }
    }
    Log.i("BasicUtils", "domain=" + (String)localObject + ",level=" + paramInt);
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, true);
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    String str1 = paramString3;
    if (paramBoolean) {}
    try
    {
      str1 = URLEncoder.encode(paramString3, "UTF-8");
      if (paramString1.contains(paramString2)) {
        return paramString1.replace(paramString2, str1);
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2;
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        str2 = paramString3;
      }
      return paramString1.replace(paramString2.toUpperCase(), str2);
    }
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label188;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label188:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */
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
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    Object localObject = str;
    if (!bool)
    {
      localObject = str;
      if (paramInt <= 0) {}
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = Uri.parse(paramString);
        localObject = str;
        if (!paramString.isHierarchical()) {
          break label150;
        }
        paramString = paramString.getHost();
        localObject = str;
        if (paramString == null) {
          break label150;
        }
        paramString = paramString.split("\\.");
        localObject = str;
        if (paramString.length <= 0) {
          break label150;
        }
        i = Math.max(0, paramString.length - (paramInt + 1));
        localObject = new StringBuilder(256);
        ((StringBuilder)localObject).append(paramString[i]);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localObject = str;
      }
      if (i < paramString.length)
      {
        ((StringBuilder)localObject).append('.');
        ((StringBuilder)localObject).append(paramString[i]);
      }
      else
      {
        localObject = ((StringBuilder)localObject).toString();
        label150:
        paramString = new StringBuilder();
        paramString.append("domain=");
        paramString.append((String)localObject);
        paramString.append(",level=");
        paramString.append(paramInt);
        Log.i("BasicUtils", paramString.toString());
        return localObject;
      }
      i += 1;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, true);
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str1 = paramString1;
    String str2;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return paramString1;
      }
      str1 = paramString3;
      if (paramBoolean) {
        try
        {
          str1 = URLEncoder.encode(paramString3, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          str2 = paramString3;
        }
      }
      if (paramString1.contains(paramString2)) {
        return paramString1.replace(paramString2, str2);
      }
      str2 = paramString1.replace(paramString2.toUpperCase(), str2);
    }
    return str2;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append('=');
    localObject = ((StringBuilder)localObject).toString();
    int j;
    for (int i = paramString1.indexOf((String)localObject); i != -1; i = paramString1.indexOf((String)localObject, i + ((String)localObject).length())) {
      if (i != 0)
      {
        j = paramString1.charAt(i - 1);
        if ((j == 63) || (j == 35) || (j == 38)) {
          break;
        }
      }
    }
    if (i > -1)
    {
      int k = ((String)localObject).length() + i;
      j = k;
      while (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m == 38) || (m == 35)) {
          break;
        }
        j += 1;
      }
      if ((paramString2.equals("_wv")) && (i > paramString1.indexOf('#'))) {
        return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
      paramString2 = new StringBuilder(paramString1.substring(0, k));
      paramString2.append(paramString3);
      paramString2.append(paramString1.substring(j));
      return paramString2.toString();
    }
    return Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */
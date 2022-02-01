package com.tencent.mobileqq.util;

import android.text.TextUtils;

public class UrlUtils
{
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject = paramString1.split("\\?");
    if (localObject.length != 2) {
      return paramString1;
    }
    paramString1 = new StringBuilder("");
    String[] arrayOfString = localObject[1].split("&");
    int i = 0;
    while (i < arrayOfString.length)
    {
      String str = arrayOfString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=.*");
      if (!str.matches(localStringBuilder.toString()))
      {
        if (paramString1.length() != 0) {
          paramString1.append("&");
        }
        paramString1.append(arrayOfString[i]);
      }
      i += 1;
    }
    paramString2 = localObject[0];
    localObject = paramString1.toString();
    paramString1 = paramString2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("?");
      paramString1.append((String)localObject);
      paramString1 = paramString1.toString();
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.UrlUtils
 * JD-Core Version:    0.7.0.1
 */
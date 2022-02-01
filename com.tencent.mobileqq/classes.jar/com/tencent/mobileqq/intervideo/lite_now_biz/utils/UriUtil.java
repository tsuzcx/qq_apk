package com.tencent.mobileqq.intervideo.lite_now_biz.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

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
        QLog.e("UriUtils", 1, "getSpecifiedLevelDomain error: " + paramString);
        localObject = str;
      }
    }
    QLog.i("UriUtils", 1, "domain=" + (String)localObject + ",level=" + paramInt);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */
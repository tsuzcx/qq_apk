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
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    Object localObject = str;
    if (!bool)
    {
      localObject = str;
      if (paramInt > 0) {
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
                  ((StringBuilder)localObject).append('.');
                  ((StringBuilder)localObject).append(paramString[i]);
                  i += 1;
                }
                localObject = ((StringBuilder)localObject).toString();
              }
            }
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getSpecifiedLevelDomain error: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.e("UriUtils", 1, ((StringBuilder)localObject).toString());
          localObject = str;
        }
      }
    }
    paramString = new StringBuilder();
    paramString.append("domain=");
    paramString.append((String)localObject);
    paramString.append(",level=");
    paramString.append(paramInt);
    QLog.i("UriUtils", 1, paramString.toString());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.utils.UriUtil
 * JD-Core Version:    0.7.0.1
 */
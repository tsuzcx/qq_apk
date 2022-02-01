package com.tencent.mobileqq.kandian.repo.common;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class RIJConvertString2URL
{
  public static String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.getFile();
    }
    return null;
  }
  
  public static URL a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramBoolean) {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        QLog.e("RIJConvertString2URL", 1, new Object[] { "convertString2URL", QLog.getStackTraceString(paramString) });
        return null;
      }
    }
    return ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramString, 3);
  }
  
  public static URL b(String paramString)
  {
    return a(paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL
 * JD-Core Version:    0.7.0.1
 */
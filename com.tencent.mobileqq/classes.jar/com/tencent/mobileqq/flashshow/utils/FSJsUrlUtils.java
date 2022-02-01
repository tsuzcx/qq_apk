package com.tencent.mobileqq.flashshow.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

public class FSJsUrlUtils
{
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString)
  {
    return a(paramList, paramString, "");
  }
  
  public static String a(List<FeedCloudCommon.Entry> paramList, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudCommon.Entry localEntry = (FeedCloudCommon.Entry)paramList.next();
        if (localEntry.key.get().equals(paramString1)) {
          return localEntry.value.get();
        }
      }
    }
    return paramString2;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      URI localURI = new URI(paramString);
      String str = localURI.getHost();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" domain:");
      localStringBuilder.append(str);
      QLog.d("FSJsUrlUtils", 1, localStringBuilder.toString());
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.endsWith(".qq.com"))
        {
          boolean bool3 = localURI.getScheme().equals("https");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSJsUrlUtils
 * JD-Core Version:    0.7.0.1
 */
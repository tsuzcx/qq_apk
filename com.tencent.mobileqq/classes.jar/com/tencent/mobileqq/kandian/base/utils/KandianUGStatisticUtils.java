package com.tencent.mobileqq.kandian.base.utils;

import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KandianUGStatisticUtils
{
  private static ExecutorService a;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&acttype=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("&itemid=");
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?acttype=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("&itemid=");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (a == null) {
      a = Executors.newFixedThreadPool(1);
    }
    a.execute(new KandianUGStatisticUtils.1(paramString));
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&acttype=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("&subpos=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?acttype=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&subpos=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.KandianUGStatisticUtils
 * JD-Core Version:    0.7.0.1
 */
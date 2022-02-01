package com.tencent.mobileqq.shortvideo;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class ShortVideoErrorReport
{
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localHashMap.put("SDK_INT", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    localHashMap.put("waite", localStringBuilder.toString());
    StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, "sv_waite_record_count", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    a("sv_resource_download_base", paramInt1, paramInt2);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localHashMap.put("SDK_INT", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localHashMap.put("type", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    localHashMap.put("error", localStringBuilder.toString());
    StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, paramString, true, 0L, 0L, localHashMap, "");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    a("sv_resource_download_qzone", paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoErrorReport
 * JD-Core Version:    0.7.0.1
 */
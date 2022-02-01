package com.tencent.mobileqq.kandian.glue.video.report;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VideoPreloadReportData
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 0;
  public static int g = 1;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n;
  public int o;
  
  public VideoPreloadReportData(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_hitCount", String.valueOf(this.h));
    localHashMap.put("param_notHitCount", String.valueOf(this.i));
    localHashMap.put("param_triggerCount", String.valueOf(this.j));
    localHashMap.put("param_triggerHitCount", String.valueOf(this.k));
    localHashMap.put("param_distinctTriggerHitCount", String.valueOf(this.l));
    localHashMap.put("param_realTriggerHitCount", String.valueOf(this.m));
    localHashMap.put("param_sceneType", String.valueOf(this.n));
    localHashMap.put("param_strategy", String.valueOf(this.o));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoPreloadReportData getReportMap ");
      localStringBuilder.append(localHashMap.toString());
      QLog.i("wgs", 2, localStringBuilder.toString());
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData
 * JD-Core Version:    0.7.0.1
 */
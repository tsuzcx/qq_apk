package com.tencent.mobileqq.extendfriend.utils;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ExtendFriendReport$1
  implements Runnable
{
  ExtendFriendReport$1(ExtendFriendReport paramExtendFriendReport, String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3) {}
  
  public void run()
  {
    try
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport.1
 * JD-Core Version:    0.7.0.1
 */
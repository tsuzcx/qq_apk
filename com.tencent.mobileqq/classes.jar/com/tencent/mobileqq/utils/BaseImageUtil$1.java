package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

final class BaseImageUtil$1
  implements Runnable
{
  BaseImageUtil$1(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getAccount(), this.b, this.c, 0L, 0L, new HashMap(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BaseImageUtil.1
 * JD-Core Version:    0.7.0.1
 */
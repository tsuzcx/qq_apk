package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import java.util.Map;

final class MonitorConfig$1
  implements Runnable
{
  MonitorConfig$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    MonitorConfig.a(this.a, this.b);
    if (MonitorConfig.a.get(this.b) != null)
    {
      Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.a.get(this.b)).b));
      return;
    }
    Monitor.b("3235983");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1
 * JD-Core Version:    0.7.0.1
 */
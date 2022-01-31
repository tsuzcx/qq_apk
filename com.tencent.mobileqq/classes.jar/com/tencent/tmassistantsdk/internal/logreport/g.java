package com.tencent.tmassistantsdk.internal.logreport;

import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;

class g
  implements Runnable
{
  g(f paramf) {}
  
  public void run()
  {
    ab.c("LogReportManager", "run");
    if ((GlobalUtil.isNetworkConncted()) && (GlobalUtil.getNetStatus().equalsIgnoreCase("wifi")))
    {
      ab.c("LogReportManager", "<reportLog>");
      this.a.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.logreport.g
 * JD-Core Version:    0.7.0.1
 */
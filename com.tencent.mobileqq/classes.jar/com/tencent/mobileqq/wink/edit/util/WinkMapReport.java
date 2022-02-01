package com.tencent.mobileqq.wink.edit.util;

import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.util.HashMap;

public class WinkMapReport
{
  private static final WinkMapReport b = new WinkMapReport();
  private HashMap<String, Long> a = new HashMap();
  
  public static WinkMapReport a()
  {
    return b;
  }
  
  public void a(String paramString)
  {
    this.a.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    long l = b(paramString1);
    if (l > 0L)
    {
      ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).report(((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).ACTION_QCIRCLE_PICKER_COST_REPORT(), paramString1, paramString2, l, paramString3);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("reportEnd... cost < 0 id:");
    paramString2.append(paramString1);
    WinkQLog.b("WinkMapReport", paramString2.toString());
  }
  
  public long b(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      long l = ((Long)this.a.get(paramString)).longValue();
      l = System.currentTimeMillis() - l;
      if (l < 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("endKey... cost < 0 id:");
        localStringBuilder.append(paramString);
        WinkQLog.b("WinkMapReport", localStringBuilder.toString());
        return -1L;
      }
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endKey... clickTimesMap not contain id:");
    localStringBuilder.append(paramString);
    WinkQLog.b("WinkMapReport", localStringBuilder.toString());
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.util.WinkMapReport
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.together.clockin;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ClockReportUtil
{
  static
  {
    UserAction.registerTunnel(new TunnelInfo("0AND07OPTZ3OVEUJ"));
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      UserAction.onUserActionToTunnel("0AND07OPTZ3OVEUJ", paramString, true, -1L, -1L, paramHashMap, true, true);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ClockReportUtil", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.ClockReportUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager;
import mqq.app.AppCallback;

class BroadcastReportRegister$1
  implements AppCallback
{
  BroadcastReportRegister$1(BroadcastReportRegister paramBroadcastReportRegister) {}
  
  public void onSendBroadcast(Context paramContext, Intent paramIntent)
  {
    try
    {
      BackgroundProbeManager.a(paramIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.BroadcastReportRegister.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qav.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qav.log.AVLog;

class CallingStateMonitor$2
  extends BroadcastReceiver
{
  CallingStateMonitor$2(CallingStateMonitor paramCallingStateMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    AVLog.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (CallingStateMonitor.a(this.a) != null) {
      CallingStateMonitor.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor.2
 * JD-Core Version:    0.7.0.1
 */
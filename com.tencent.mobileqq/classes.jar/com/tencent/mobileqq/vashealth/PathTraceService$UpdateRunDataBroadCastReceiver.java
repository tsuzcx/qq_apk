package com.tencent.mobileqq.vashealth;

import alud;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;

public class PathTraceService$UpdateRunDataBroadCastReceiver
  extends BroadcastReceiver
{
  public PathTraceService$UpdateRunDataBroadCastReceiver(PathTraceService paramPathTraceService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.i("PathTraceManager.Service", 1, "onReceive");
    int i = paramIntent.getIntExtra(PathTraceService.b, 0);
    long l = paramIntent.getLongExtra(PathTraceService.c, 0L);
    double d = paramIntent.getDoubleExtra(PathTraceService.d, 0.0D);
    if (i == 1) {
      PathTraceService.a(this.a).setTextViewText(2131371284, alud.a(2131708296));
    }
    PathTraceService.a(this.a).setChronometer(2131371285, SystemClock.elapsedRealtime() - l * 1000L, null, false);
    paramContext = new DecimalFormat("######0.00");
    PathTraceService.a(this.a).setTextViewText(2131371283, paramContext.format(d / 1000.0D) + "km");
    try
    {
      PathTraceService.a(this.a, PathTraceService.a(this.a).build());
      PathTraceService.a(this.a).notify("PathTraceManager.Service", 237, PathTraceService.a(this.a));
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("PathTraceManager.Service", 1, "[update] err in notify");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService.UpdateRunDataBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */
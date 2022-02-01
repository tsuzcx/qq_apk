package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;

public class PathTraceService$UpdateRunDataBroadCastReceiver
  extends BroadcastReceiver
{
  public PathTraceService$UpdateRunDataBroadCastReceiver(PathTraceService paramPathTraceService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.i("PathTraceManager.Service", 1, "onReceive");
    int i = paramIntent.getIntExtra(PathTraceService.c, 0);
    long l = paramIntent.getLongExtra(PathTraceService.d, 0L);
    double d = paramIntent.getDoubleExtra(PathTraceService.e, 0.0D);
    if (i == 1) {
      PathTraceService.a(this.a).setTextViewText(2131439456, HardCodeUtil.a(2131905725));
    }
    PathTraceService.a(this.a).setChronometer(2131439457, SystemClock.elapsedRealtime() - l * 1000L, null, false);
    paramContext = new DecimalFormat("######0.00");
    paramIntent = PathTraceService.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.format(d / 1000.0D));
    localStringBuilder.append("km");
    paramIntent.setTextViewText(2131439455, localStringBuilder.toString());
    try
    {
      PathTraceService.a(this.a, PathTraceService.b(this.a).build());
      PathTraceService.d(this.a).notify("PathTraceManager.Service", 237, PathTraceService.c(this.a));
      return;
    }
    catch (Throwable paramContext)
    {
      label186:
      break label186;
    }
    QLog.e("PathTraceManager.Service", 1, "[update] err in notify");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceService.UpdateRunDataBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class TroopUsageTimeReport
  extends BroadcastReceiver
{
  public boolean a = false;
  public boolean b = false;
  private String c;
  private long d;
  private long e;
  private long f;
  private long g;
  private QQAppInterface h;
  private IntentFilter i = new IntentFilter();
  private SessionInfo j;
  private volatile boolean k = false;
  
  private TroopUsageTimeReport()
  {
    this.i.addAction("android.intent.action.SCREEN_OFF");
    this.i.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.i.addAction("android.intent.action.ACTION_SHUTDOWN");
    this.i.addAction("android.intent.action.QUICKBOOT_POWEROFF");
  }
  
  public void a()
  {
    if (this.a)
    {
      this.e = System.currentTimeMillis();
      long l = (this.e - this.d) / 1000L;
      int m = (int)l;
      if (m <= 0) {
        m = 1;
      }
      SessionInfo localSessionInfo = this.j;
      if (localSessionInfo != null)
      {
        ReportController.b(this.h, "P_CliOper", "Grp_AIO", "", "time", "aio_time", 0, m, 0, localSessionInfo.b, "", "", "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uin=");
          localStringBuilder.append(this.c);
          localStringBuilder.append(",mTroopUin=");
          localStringBuilder.append(localSessionInfo.b);
          localStringBuilder.append(",time=");
          localStringBuilder.append(l);
          localStringBuilder.append("s");
          QLog.d("TroopUsageTimeReport-->AioUseTime", 2, localStringBuilder.toString());
        }
      }
      this.a = false;
    }
  }
  
  public void b()
  {
    if (this.b)
    {
      this.g = System.currentTimeMillis();
      long l = (this.g - this.f) / 1000L;
      int m = (int)l;
      if (m <= 0) {
        m = 1;
      }
      SessionInfo localSessionInfo = this.j;
      if (localSessionInfo != null)
      {
        ReportController.b(this.h, "P_CliOper", "Grp_AIO", "", "time", "grp_time", 0, m, 0, localSessionInfo.b, "", "", "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uin=");
          localStringBuilder.append(this.c);
          localStringBuilder.append(",mTroopUin=");
          localStringBuilder.append(localSessionInfo.b);
          localStringBuilder.append(",time=");
          localStringBuilder.append(l);
          localStringBuilder.append("s");
          QLog.d("TroopUsageTimeReport-->TroopUseTime", 2, localStringBuilder.toString());
        }
      }
      this.b = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((!"android.intent.action.SCREEN_OFF".equals(paramContext)) && (!"android.intent.action.ACTION_SHUTDOWN".equals(paramContext)) && (!"android.intent.action.QUICKBOOT_POWEROFF".equals(paramContext)))
    {
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if ((paramContext != null) && (paramContext.equals("homekey"))) {
          b();
        }
      }
    }
    else
    {
      a();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopUsageTimeReport
 * JD-Core Version:    0.7.0.1
 */
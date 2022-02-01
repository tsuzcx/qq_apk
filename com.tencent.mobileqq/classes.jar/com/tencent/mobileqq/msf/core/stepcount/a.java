package com.tencent.mobileqq.msf.core.stepcount;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class a
  implements b
{
  private static final String a = "HealthStepCounter";
  private final c b;
  private final d c;
  
  public a(Context paramContext)
  {
    this.b = new com.tencent.mobileqq.msf.core.stepcount.a.a(paramContext);
    this.c = new com.tencent.mobileqq.msf.core.stepcount.a.b(paramContext, this.b);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HealthStepCounter", 2, "msf service onServiceDestroyed");
    }
    this.b.a();
    this.c.b();
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounter", 2, "toServiceMsg is null");
      }
      return;
    }
    String str = paramToServiceMsg.getServiceCmd();
    if (str.equals("cmd_health_switch"))
    {
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isOpen", Boolean.valueOf(false))).booleanValue();
      g.a().a(bool);
      if (bool)
      {
        this.c.a();
        return;
      }
      this.b.a();
      this.c.b();
      return;
    }
    if (str.equals("cmd_reset_step"))
    {
      paramString = paramToServiceMsg.getAttribute("server_step");
      if ((paramString instanceof Integer))
      {
        int i = ((Integer)paramString).intValue();
        this.b.c(i, NetConnInfoCenter.getServerTime());
      }
    }
    else
    {
      if (str.equals("cmd_refresh_steps"))
      {
        this.b.a();
        this.c.a(paramString, paramToServiceMsg);
        return;
      }
      if (str.equals("cmd_update_lastreport_time")) {
        this.c.c();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msf service onServiceCreated, autoBoot:");
      localStringBuilder.append(paramBoolean);
      QLog.d("HealthStepCounter", 1, localStringBuilder.toString());
    }
    this.b.a(paramBoolean);
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.a
 * JD-Core Version:    0.7.0.1
 */
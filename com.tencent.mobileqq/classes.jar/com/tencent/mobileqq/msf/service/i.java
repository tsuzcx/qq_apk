package com.tencent.mobileqq.msf.service;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.c.k.c;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class i
  implements Handler.Callback
{
  i(MSFAliveJobService paramMSFAliveJobService) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!j.g())
    {
      QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage not enable");
      try
      {
        JobScheduler localJobScheduler = (JobScheduler)BaseApplication.getContext().getSystemService("jobscheduler");
        if (localJobScheduler != null)
        {
          localJobScheduler.cancel(1);
          QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage job cancelled");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage e ", localException);
        }
      }
      this.a.jobFinished((JobParameters)paramMessage.obj, false);
      return true;
    }
    QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage start service");
    if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null) && (MsfCore.sCore.statReporter.X != null))
    {
      boolean bool = MsfCore.sCore.statReporter.X.a;
      long l1 = MsfCore.sCore.statReporter.X.g;
      long l2 = MsfCore.sCore.statReporter.X.b;
      long l3 = MsfCore.sCore.statReporter.X.c;
      long l4 = Math.abs(System.currentTimeMillis() - l1);
      QLog.d("MSFAliveJobService", 1, new Object[] { "MSF_Alive_Log : isDeviceIdleMode=", Boolean.valueOf(bool), ", netWorkFailTime=", Long.valueOf(l1), ", enterIdle=", Long.valueOf(l2), " levelIdle=", Long.valueOf(l3), ",netFailInterval=", Long.valueOf(l4) });
      if ((l1 != 0L) && (l4 > 270000.0D))
      {
        QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage send push query");
        if (MsfCore.sCore.pushManager != null)
        {
          QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage send push query real");
          MsfCore.sCore.pushManager.c();
        }
      }
    }
    if (!MsfService.inited)
    {
      j.a(false);
      QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService handleMessage init MSF Service");
      Intent localIntent = new Intent(BaseApplication.getContext(), MsfService.class);
      localIntent.putExtra("key_from_job", true);
      NetConnInfoCenter.startOrBindService(localIntent);
    }
    this.a.jobFinished((JobParameters)paramMessage.obj, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.i
 * JD-Core Version:    0.7.0.1
 */
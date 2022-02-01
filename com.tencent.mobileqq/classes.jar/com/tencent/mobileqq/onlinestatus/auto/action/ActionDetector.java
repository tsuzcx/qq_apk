package com.tencent.mobileqq.onlinestatus.auto.action;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Foreground;

public class ActionDetector
{
  private AppRuntime a;
  
  public ActionDetector(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  private boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
    int j = b();
    int i;
    if (Foreground.getResumeActivityCount() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][action] isStayingUpLate countResume:");
      localStringBuilder.append(Foreground.getResumeActivityCount());
      localStringBuilder.append(" curHour: ");
      localStringBuilder.append(j);
      localStringBuilder.append(" begin: ");
      localStringBuilder.append(Constant.D);
      localStringBuilder.append(" end: ");
      localStringBuilder.append(Constant.E);
      QLog.d("ActionDetector", 2, localStringBuilder.toString());
    }
    if (Constant.E > Constant.D)
    {
      if ((j >= Constant.D) && (j < Constant.E))
      {
        paramAppRuntime = paramAppRuntime.getOnlineStatus();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][action] isStayingUpLate closeZone curHour: ");
          localStringBuilder.append(j);
          localStringBuilder.append(" status: ");
          localStringBuilder.append(paramAppRuntime);
          QLog.d("ActionDetector", 2, localStringBuilder.toString());
        }
        return (paramAppRuntime == AppRuntime.Status.online) && (i != 0);
      }
    }
    else {
      if ((j > Constant.D) || (j < Constant.E)) {
        break label242;
      }
    }
    return false;
    label242:
    paramAppRuntime = paramAppRuntime.getOnlineStatus();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][action] isStayingUpLate openZone curHour: ");
      localStringBuilder.append(j);
      localStringBuilder.append(" status: ");
      localStringBuilder.append(paramAppRuntime);
      QLog.d("ActionDetector", 2, localStringBuilder.toString());
    }
    return (paramAppRuntime == AppRuntime.Status.online) && (i != 0);
  }
  
  public int a()
  {
    int i;
    if (a(this.a)) {
      i = 41032;
    } else {
      i = 40001;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][action] getStatus return status: ");
      localStringBuilder.append(i);
      QLog.d("ActionDetector", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  int b()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    return localCalendar.get(11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.action.ActionDetector
 * JD-Core Version:    0.7.0.1
 */
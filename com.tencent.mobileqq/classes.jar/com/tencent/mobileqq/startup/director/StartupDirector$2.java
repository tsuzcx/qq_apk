package com.tencent.mobileqq.startup.director;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

class StartupDirector$2
  implements Runnable
{
  StartupDirector$2(StartupDirector paramStartupDirector, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void run()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.a > 0L) {
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginA", true, this.a, 0L, null, null);
      }
      long l = this.b;
      Object localObject3 = "1";
      Object localObject1;
      if (l > 0L)
      {
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          localObject2 = (QQAppInterface)localObject1;
          l = this.b;
          if (l == 2201L) {
            localObject1 = "1";
          } else if (l == 2200L) {
            localObject1 = "3";
          } else {
            localObject1 = "2";
          }
          ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X80064F6", "0X80064F6", 0, 0, (String)localObject1, "", "", "");
        }
      }
      if (this.c > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginM, cost=");
        ((StringBuilder)localObject1).append(this.d);
        QLog.d("AutoMonitor", 1, ((StringBuilder)localObject1).toString());
        localObject1 = new HashMap();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.d);
        ((StringBuilder)localObject2).append("");
        ((HashMap)localObject1).put("cost", ((StringBuilder)localObject2).toString());
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginM", true, this.d, 0L, (HashMap)localObject1, null);
      }
      l = this.e;
      Object localObject2 = "0";
      if ((l > 0L) && (this.f < 30000L))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginS, cost=");
        ((StringBuilder)localObject1).append(this.f);
        QLog.d("AutoMonitor", 1, ((StringBuilder)localObject1).toString());
        localObject4 = new HashMap();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.f);
        ((StringBuilder)localObject1).append("");
        ((HashMap)localObject4).put("cost", ((StringBuilder)localObject1).toString());
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          if (RecentParcelUtil.a((QQAppInterface)localObject1)) {
            localObject1 = "1";
          } else {
            localObject1 = "0";
          }
          ((HashMap)localObject4).put("bootOpt", localObject1);
        }
        else
        {
          ((HashMap)localObject4).put("bootOpt", "-1");
        }
        localObject1 = RecentParcelUtil.a(BaseApplicationImpl.context);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((HashMap)localObject4).put("bootOptCrashMessage", localObject1);
        }
        if (RecentParcelUtil.a(BaseApplicationImpl.context)) {
          localObject1 = localObject3;
        } else {
          localObject1 = "0";
        }
        ((HashMap)localObject4).put("bootOptHasCrash", localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RecentParcelUtil.a());
        ((StringBuilder)localObject1).append("");
        ((HashMap)localObject4).put("bootOptTotalSize", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(RecentParcelUtil.b());
        ((StringBuilder)localObject1).append("");
        ((HashMap)localObject4).put("bootOptFailSize", ((StringBuilder)localObject1).toString());
        if ((StartupDirector.a(this.this$0) != null) && (StartupDirector.a(this.this$0).size() == 6))
        {
          localObject1 = StartupDirector.a(this.this$0).keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject1).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("state");
            localStringBuilder.append(localObject3);
            ((HashMap)localObject4).put(localStringBuilder.toString(), String.valueOf(StartupDirector.a(this.this$0).get(localObject3)));
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = ((HashMap)localObject4).keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            QLog.d("AutoMonitor", 2, new Object[] { "Report param: key=", localObject3, " value=", ((HashMap)localObject4).get(localObject3) });
          }
        }
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginS", true, this.f, 0L, (HashMap)localObject4, null);
      }
      Object localObject4 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject3 = ((QQAppInterface)localObject4).getAccount();
        localObject1 = localObject2;
        if (localObject3 != null) {
          if (((String)localObject3).length() == 0) {
            localObject1 = localObject2;
          } else {
            localObject1 = localObject3;
          }
        }
      }
      ReportController.a((AppRuntime)localObject4, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.sApplication, (String)localObject1), "", "", "");
      if ("Success".equals(BaseApplicationImpl.sInjectResult))
      {
        Step.AmStepFactory.b(16, this.this$0, null).step();
        UnifiedMonitor.a().b();
      }
      Step.AmStepFactory.b(42, this.this$0, null).step();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */
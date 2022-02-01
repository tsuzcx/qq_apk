package com.tencent.mobileqq.startup.director;

import akmb;
import android.text.TextUtils;
import bcad;
import bccs;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StartupDirector$2
  implements Runnable
{
  public StartupDirector$2(bcad parambcad, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.a > 0L) {
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginA", true, this.a, 0L, null, null);
      }
      if (this.b > 0L)
      {
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          localObject2 = (QQAppInterface)localObject1;
          if (this.b != 2201L) {
            break label522;
          }
          localObject1 = "1";
          bcef.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80064F6", "0X80064F6", 0, 0, (String)localObject1, "", "", "");
        }
      }
      if (this.c > 0L)
      {
        QLog.d("AutoMonitor", 1, "ActionLoginM, cost=" + this.d);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("cost", this.d + "");
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginM", true, this.d, 0L, (HashMap)localObject1, null);
      }
      if ((this.e > 0L) && (this.f < 30000L))
      {
        QLog.d("AutoMonitor", 1, "ActionLoginS, cost=" + this.f);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("cost", this.f + "");
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface))) {
          if (akmb.a((QQAppInterface)localObject1))
          {
            localObject1 = "1";
            label315:
            ((HashMap)localObject2).put("bootOpt", localObject1);
            label323:
            localObject1 = akmb.a(BaseApplicationImpl.context);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((HashMap)localObject2).put("bootOptCrashMessage", localObject1);
            }
            if (!akmb.a(BaseApplicationImpl.context)) {
              break label563;
            }
          }
        }
        Object localObject3;
        label522:
        label563:
        for (localObject1 = "1";; localObject1 = "0")
        {
          ((HashMap)localObject2).put("bootOptHasCrash", localObject1);
          ((HashMap)localObject2).put("bootOptTotalSize", akmb.a() + "");
          ((HashMap)localObject2).put("bootOptFailSize", akmb.b() + "");
          if ((bcad.a(this.this$0) == null) || (bcad.a(this.this$0).size() != 6)) {
            break label569;
          }
          localObject1 = bcad.a(this.this$0).keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject1).next();
            ((HashMap)localObject2).put("state" + localObject3, String.valueOf(bcad.a(this.this$0).get(localObject3)));
          }
          if (this.b == 2200L)
          {
            localObject1 = "3";
            break;
          }
          localObject1 = "2";
          break;
          localObject1 = "0";
          break label315;
          ((HashMap)localObject2).put("bootOpt", "-1");
          break label323;
        }
        label569:
        if (QLog.isColorLevel())
        {
          localObject1 = ((HashMap)localObject2).keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            QLog.d("AutoMonitor", 2, new Object[] { "Report param: key=", localObject3, " value=", ((HashMap)localObject2).get(localObject3) });
          }
        }
        StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginS", true, this.f, 0L, (HashMap)localObject2, null);
      }
      localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject2 != null) {
        break label751;
      }
      localObject1 = "0";
    }
    for (;;)
    {
      bcef.a((QQAppInterface)localObject2, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.sApplication, (String)localObject1), "", "", "");
      if ("Success".equals(BaseApplicationImpl.sInjectResult))
      {
        bccs.b(16, this.this$0, null).step();
        UnifiedMonitor.a().b();
      }
      bccs.b(43, this.this$0, null).step();
      return;
      label751:
      localObject1 = ((QQAppInterface)localObject2).getAccount();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        localObject1 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.2
 * JD-Core Version:    0.7.0.1
 */
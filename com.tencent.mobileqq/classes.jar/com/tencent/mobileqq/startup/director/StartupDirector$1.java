package com.tencent.mobileqq.startup.director;

import ahon;
import android.text.TextUtils;
import axnx;
import axpl;
import axqy;
import axrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class StartupDirector$1
  implements Runnable
{
  public StartupDirector$1(axnx paramaxnx, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.a > 0L) {
        axrn.a(BaseApplicationImpl.sApplication).a(null, "actLoginA", true, this.a, 0L, null, null);
      }
      if (this.b > 0L)
      {
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
        {
          localObject2 = (QQAppInterface)localObject1;
          if (this.b != 2201L) {
            break label519;
          }
          localObject1 = "1";
          axqy.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80064F6", "0X80064F6", 0, 0, (String)localObject1, "", "", "");
        }
      }
      if (this.c > 0L)
      {
        QLog.d("AutoMonitor", 1, "ActionLoginM, cost=" + this.d);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("cost", this.d + "");
        axrn.a(BaseApplicationImpl.sApplication).a(null, "actLoginM", true, this.d, 0L, (HashMap)localObject1, null);
      }
      if ((this.e > 0L) && (this.f < 30000L))
      {
        QLog.d("AutoMonitor", 1, "ActionLoginS, cost=" + this.f);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("cost", this.f + "");
        localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
          break label548;
        }
        if (!ahon.a((QQAppInterface)localObject1)) {
          break label542;
        }
        localObject1 = "1";
        label315:
        ((HashMap)localObject2).put("bootOpt", localObject1);
        label323:
        localObject1 = ahon.a(BaseApplicationImpl.context);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((HashMap)localObject2).put("bootOptCrashMessage", localObject1);
        }
        if (!ahon.a(BaseApplicationImpl.context)) {
          break label560;
        }
        localObject1 = "1";
        label357:
        ((HashMap)localObject2).put("bootOptHasCrash", localObject1);
        ((HashMap)localObject2).put("bootOptTotalSize", ahon.a() + "");
        ((HashMap)localObject2).put("bootOptFailSize", ahon.b() + "");
        axrn.a(BaseApplicationImpl.sApplication).a(null, "actLoginS", true, this.f, 0L, (HashMap)localObject2, null);
      }
      localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject2 != null) {
        break label566;
      }
      localObject1 = "0";
    }
    for (;;)
    {
      axqy.a((QQAppInterface)localObject2, "P_CliOper", "Vip_login_upload", "", "upload", "report", 0, 0, AppSetting.a(BaseApplicationImpl.sApplication, (String)localObject1), "", "", "");
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        UnifiedMonitor.a().b();
      }
      axpl.b(42, this.this$0, null).step();
      return;
      label519:
      if (this.b == 2200L)
      {
        localObject1 = "3";
        break;
      }
      localObject1 = "2";
      break;
      label542:
      localObject1 = "0";
      break label315;
      label548:
      ((HashMap)localObject2).put("bootOpt", "-1");
      break label323;
      label560:
      localObject1 = "0";
      break label357;
      label566:
      localObject1 = ((QQAppInterface)localObject2).getAccount();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        localObject1 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.director.StartupDirector.1
 * JD-Core Version:    0.7.0.1
 */
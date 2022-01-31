package com.tencent.mobileqq.utils;

import acte;
import akde;
import akhn;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import axnv;
import axrl;
import bbct;
import bbfh;
import bbio;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

public final class PerformanceReportUtils$1
  implements Runnable
{
  public PerformanceReportUtils$1(int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject1 = bbio.a(ServerConfigManager.ConfigType.common, bbfh.b());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportUISwitch openStr ：" + (String)localObject1);
    }
    if ((localObject1 == null) || (!"1".equals(localObject1))) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        Object localObject2;
        String str1;
        long l1;
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_Int == 10))
        {
          if (!QQAppInterface.b) {
            break label983;
          }
          i = 0;
          localHashMap.put("actloginTypt", String.valueOf(i));
          localHashMap.put("param_threadOpId", String.valueOf(akhn.a().a()));
          if ((!QQAppInterface.b) && (this.jdField_a_of_type_Int != 10))
          {
            QQAppInterface.b = true;
            localHashMap.put("aio_preloaded", String.valueOf(acte.jdField_a_of_type_Int));
          }
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
          {
            if (((QQAppInterface)localObject1).a.jdField_a_of_type_Long == 0L) {
              break label988;
            }
            bool = true;
            localHashMap.put("param_is_logining", String.valueOf(bool));
            if (((QQAppInterface)localObject1).a.c()) {
              break label993;
            }
            bool = true;
            localHashMap.put("param_syncing_msg", String.valueOf(bool));
            localHashMap.put("inActionLoginB", String.valueOf(((QQAppInterface)localObject1).a.a()));
          }
          localHashMap.put("param_cpu_core_num", String.valueOf(akde.a()));
          localHashMap.put("param_ram", String.valueOf(bbct.d()));
          if (axnv.j)
          {
            localObject2 = "-1";
            str1 = "-1";
            String str2 = "-1";
            String str3 = "-1";
            l1 = System.currentTimeMillis();
            if (AutomatorFinish.jdField_a_of_type_Long != -1L) {
              continue;
            }
            localObject1 = "-1";
            if (axnv.e != 0L) {
              localObject2 = String.valueOf(l1 - axnv.e);
            }
            if (axnv.d != 0L) {
              str1 = String.valueOf(l1 - axnv.d);
            }
            if (axnv.g != 0L) {
              str2 = String.valueOf(l1 - axnv.g);
            }
            if (axnv.f != 0L) {
              str3 = String.valueOf(l1 - axnv.f);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(axnv.c));
            localHashMap.put("automatorFinishtime", localObject1);
            localHashMap.put("qZoneInterval", localObject2);
            localHashMap.put("miniInterval", str1);
            localHashMap.put("troopListInterval", str2);
            localHashMap.put("preDownloadInterval", str3);
          }
        }
        localObject1 = null;
        long l2;
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
          localObject2 = bbfh.a();
          if ((localObject1 == null) || (this.jdField_a_of_type_Long <= 0L)) {
            break;
          }
          l2 = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
          l1 = bbfh.a();
          str1 = bbio.a(ServerConfigManager.ConfigType.common, bbfh.n());
          if (str1 != null) {
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch  server time：" + str1);
            }
          }
        case 1: 
        case 3000: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          try
          {
            l1 = Long.valueOf(str1).longValue();
            l1 *= 1000L;
          }
          catch (Exception localException2)
          {
            l1 = bbfh.a();
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time ：" + l1 + ",lastRp" + l2 + ",aioBusiness=" + bbfh.a());
          }
          if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2) && (SystemClock.uptimeMillis() - l2 < l1)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed ：" + this.jdField_a_of_type_Long + ",aioBusiness=" + bbfh.a());
          }
          localHashMap.put("aioBusiness", bbfh.a());
          axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, (String)localObject1, true, this.jdField_a_of_type_Long, 0L, localHashMap, bbfh.o());
          ((SharedPreferences)localObject2).edit().putLong((String)localObject1, SystemClock.uptimeMillis()).commit();
          return;
          localObject1 = String.valueOf(l1 - AutomatorFinish.jdField_a_of_type_Long);
          continue;
          localObject1 = bbfh.c();
          continue;
          localObject1 = bbfh.d();
          continue;
          localObject1 = bbfh.e();
          continue;
          localObject1 = bbfh.f();
          continue;
          localObject1 = bbfh.g();
          continue;
          localObject1 = bbfh.h();
          continue;
          localObject1 = bbfh.i();
          continue;
          localObject1 = bbfh.j();
          continue;
          localObject1 = bbfh.k();
          continue;
          localObject1 = bbfh.l();
          continue;
          localObject1 = bbfh.m();
          break;
        }
        int i = 1;
      }
      catch (Exception localException1)
      {
        return;
      }
      label983:
      continue;
      label988:
      boolean bool = false;
      continue;
      label993:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */
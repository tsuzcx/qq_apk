package com.tencent.qqperf.repoter;

import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.config.Config;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import mqq.os.MqqHandler;

class ReporterMachine$ReportRunnable
  implements Runnable
{
  private List<ResultObject> a;
  private int b = 0;
  
  private ReporterMachine$ReportRunnable(ReporterMachine paramReporterMachine) {}
  
  public void run()
  {
    Object localObject1;
    if (ReportedStatus.a > Config.MAX_REPORT_NUM)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[YunYingReport]:End, reported ");
        ((StringBuilder)localObject1).append(ReportedStatus.a);
        ((StringBuilder)localObject1).append(" max_report_num ");
        ((StringBuilder)localObject1).append(Config.MAX_REPORT_NUM);
        QLog.i("Magnifier_ReporterMachine", 2, ((StringBuilder)localObject1).toString());
      }
      if (MagnifierSDK.e != null) {
        MagnifierSDK.e.a();
      }
      if (MagnifierSDK.d != null) {
        MagnifierSDK.d.putInt("count_today_reported", ReportedStatus.a).apply();
      }
      return;
    }
    Object localObject5;
    Object localObject4;
    if ((MagnifierSDK.e != null) && (1 == NetworkCenter.getInstance().getNetType()))
    {
      localObject1 = this.a;
      int i = 0;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        try
        {
          ReporterMachine.b((ResultObject)this.a.get(this.b));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Magnifier_ReporterMachine", 2, localException1, new Object[0]);
          }
        }
        this.b += 1;
        if (this.b < this.a.size())
        {
          ReporterMachine.d().postDelayed(this, 500L);
          return;
        }
        MagnifierSDK.e.a("result_objects", true);
        Object localObject2 = this.a;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Magnifier_ReporterMachine", 2, "clear all data from roList");
          }
          this.a.clear();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "clear and set listIndex's value to 0");
        }
        this.b = 0;
        ReporterMachine.d().postDelayed(this, 1800000L);
        int j = ReportedStatus.b.size();
        if (MagnifierSDK.d == null) {
          break label671;
        }
        while (i < j)
        {
          int k = ReportedStatus.b.keyAt(i);
          if (k > 100)
          {
            localObject2 = (ReportedStatus.CurrentRecord)ReportedStatus.b.get(k);
            if (localObject2 != null)
            {
              localObject5 = MagnifierSDK.d;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("count_plugin_");
              localStringBuilder.append(String.valueOf(k));
              ((SharedPreferences.Editor)localObject5).putInt(localStringBuilder.toString(), ((ReportedStatus.CurrentRecord)localObject2).b);
            }
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "MagnifierSDKApply 22 ");
        }
        MagnifierSDK.d.apply();
        return;
      }
      this.a = MagnifierSDK.e.a(true);
      if ((ReporterMachine.e() != null) && (!ReporterMachine.e().isEmpty())) {
        try
        {
          this.a.addAll(ReporterMachine.e());
          ReporterMachine.e().clear();
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_ReporterMachine", 2, "getAllResultObjects and set listIndex = 0");
      }
      this.b = 0;
      localObject4 = this.a;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        ReporterMachine.d().postDelayed(this, 500L);
        return;
      }
      localObject4 = ReporterMachine.f().iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject4).hasNext()) {
        localObject5 = (String)((Iterator)localObject4).next();
      }
      try
      {
        localObject5 = new File((String)localObject5);
        if (!((File)localObject5).isFile()) {
          continue;
        }
        ((File)localObject5).delete();
      }
      catch (Exception localException2) {}
      ReporterMachine.f().clear();
      ReporterMachine.d().postDelayed(this, 1800000L);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:Next try, because MagnifierSDK.dbHandler == null || NetType.WIFI != NetworkCenter.getInstance().getNetType()");
      }
      ReporterMachine.d().postDelayed(this, 1800000L);
      label671:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */
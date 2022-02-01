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
  private int jdField_a_of_type_Int = 0;
  private List<ResultObject> jdField_a_of_type_JavaUtilList;
  
  private ReporterMachine$ReportRunnable(ReporterMachine paramReporterMachine) {}
  
  public void run()
  {
    Object localObject1;
    if (ReportedStatus.jdField_a_of_type_Int > Config.MAX_REPORT_NUM)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[YunYingReport]:End, reported ");
        ((StringBuilder)localObject1).append(ReportedStatus.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(" max_report_num ");
        ((StringBuilder)localObject1).append(Config.MAX_REPORT_NUM);
        QLog.i("Magnifier_ReporterMachine", 2, ((StringBuilder)localObject1).toString());
      }
      if (MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler != null) {
        MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler.a();
      }
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", ReportedStatus.jdField_a_of_type_Int).apply();
      }
      return;
    }
    Object localObject5;
    Object localObject4;
    if ((MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler != null) && (1 == NetworkCenter.getInstance().getNetType()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      int i = 0;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        try
        {
          ReporterMachine.b((ResultObject)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Magnifier_ReporterMachine", 2, localException1, new Object[0]);
          }
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
        {
          ReporterMachine.a().postDelayed(this, 500L);
          return;
        }
        MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler.a("result_objects", true);
        Object localObject2 = this.jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Magnifier_ReporterMachine", 2, "clear all data from roList");
          }
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "clear and set listIndex's value to 0");
        }
        this.jdField_a_of_type_Int = 0;
        ReporterMachine.a().postDelayed(this, 1800000L);
        int j = ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.size();
        if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
          break label671;
        }
        while (i < j)
        {
          int k = ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
          if (k > 100)
          {
            localObject2 = (ReportedStatus.CurrentRecord)ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.get(k);
            if (localObject2 != null)
            {
              localObject5 = MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("count_plugin_");
              localStringBuilder.append(String.valueOf(k));
              ((SharedPreferences.Editor)localObject5).putInt(localStringBuilder.toString(), ((ReportedStatus.CurrentRecord)localObject2).jdField_a_of_type_Int);
            }
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_ReporterMachine", 2, "MagnifierSDKApply 22 ");
        }
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
      }
      this.jdField_a_of_type_JavaUtilList = MagnifierSDK.jdField_a_of_type_ComTencentQqperfRepoterDBHandler.a(true);
      if ((ReporterMachine.a() != null) && (!ReporterMachine.a().isEmpty())) {
        try
        {
          this.jdField_a_of_type_JavaUtilList.addAll(ReporterMachine.a());
          ReporterMachine.a().clear();
        }
        finally {}
      }
      if (QLog.isColorLevel()) {
        QLog.d("Magnifier_ReporterMachine", 2, "getAllResultObjects and set listIndex = 0");
      }
      this.jdField_a_of_type_Int = 0;
      localObject4 = this.jdField_a_of_type_JavaUtilList;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
      {
        ReporterMachine.a().postDelayed(this, 500L);
        return;
      }
      localObject4 = ReporterMachine.a().iterator();
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
      ReporterMachine.a().clear();
      ReporterMachine.a().postDelayed(this, 1800000L);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:Next try, because MagnifierSDK.dbHandler == null || NetType.WIFI != NetworkCenter.getInstance().getNetType()");
      }
      ReporterMachine.a().postDelayed(this, 1800000L);
      label671:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.ReporterMachine.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.mfsdk.Config;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.ReportedStatus;
import com.tencent.mfsdk.ReportedStatus.CurrentRecord;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.persist.DBHandler;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import mqq.os.MqqHandler;

public class riq
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList;
  
  private riq(ReporterMachine paramReporterMachine) {}
  
  public void run()
  {
    int i = 0;
    if (ReportedStatus.jdField_a_of_type_Int > Config.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:End, reported " + ReportedStatus.jdField_a_of_type_Int + " max_report_num " + Config.jdField_a_of_type_Int);
      }
      if (MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler != null) {
        MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler.a();
      }
      if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null) {
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_today_reported", ReportedStatus.jdField_a_of_type_Int).apply();
      }
    }
    for (;;)
    {
      return;
      if ((MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler == null) || (1 != NetworkCenter.a().a()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Magnifier_ReporterMachine", 2, "[YunYingReport]:Next try, because MagnifierSDK.dbHandler == null || NetType.WIFI != NetworkCenter.getInstance().getNetType()");
        }
        ReporterMachine.a().postDelayed(this, 1800000L);
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
      try
      {
        ReporterMachine.b((ResultObject)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
        label173:
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size())
        {
          ReporterMachine.a().postDelayed(this, 500L);
          return;
        }
        MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler.a("result_objects", true);
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        this.jdField_a_of_type_Int = 0;
        ReporterMachine.a().postDelayed(this, 1800000L);
        int j = ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.size();
        if (MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor == null) {
          continue;
        }
        Object localObject1;
        if (i < j)
        {
          int k = ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
          if (k > 100)
          {
            localObject1 = (ReportedStatus.CurrentRecord)ReportedStatus.jdField_a_of_type_AndroidUtilSparseArray.get(k);
            if (localObject1 != null) {
              break label321;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            label321:
            MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("count_plugin_" + String.valueOf(k), ((ReportedStatus.CurrentRecord)localObject1).jdField_a_of_type_Int);
          }
        }
        MagnifierSDK.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        return;
        this.jdField_a_of_type_JavaUtilList = MagnifierSDK.jdField_a_of_type_ComTencentMfsdkPersistDBHandler.a(true);
        if ((ReporterMachine.a() != null) && (!ReporterMachine.a().isEmpty())) {}
        try
        {
          this.jdField_a_of_type_JavaUtilList.addAll(ReporterMachine.a());
          ReporterMachine.a().clear();
          this.jdField_a_of_type_Int = 0;
          if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label546;
          }
          localObject1 = ReporterMachine.a().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (String)((Iterator)localObject1).next();
            try
            {
              localObject3 = new File((String)localObject3);
              if ((localObject3 != null) && (((File)localObject3).isFile())) {
                ((File)localObject3).delete();
              }
            }
            catch (Exception localException2) {}
          }
          ReporterMachine.a().clear();
        }
        finally {}
        ReporterMachine.a().postDelayed(this, 1800000L);
        return;
        label546:
        ReporterMachine.a().postDelayed(this, 500L);
        return;
      }
      catch (Exception localException1)
      {
        break label173;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     riq
 * JD-Core Version:    0.7.0.1
 */
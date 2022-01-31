package dov.com.tencent.biz.qqstory.takevideo;

import android.util.Log;
import axqs;
import axtu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DataReporter$1
  implements Runnable
{
  DataReporter$1(DataReporter paramDataReporter, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        axtu localaxtu = (axtu)localIterator.next();
        axqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaxtu);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMReportController.DataReporter", 2, Log.getStackTraceString(localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter.1
 * JD-Core Version:    0.7.0.1
 */
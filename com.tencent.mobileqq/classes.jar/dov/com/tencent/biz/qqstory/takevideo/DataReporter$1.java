package dov.com.tencent.biz.qqstory.takevideo;

import android.util.Log;
import bcsp;
import bcuy;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class DataReporter$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bcuy localbcuy = (bcuy)localIterator.next();
        bcsp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localbcuy);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.DataReporter.1
 * JD-Core Version:    0.7.0.1
 */
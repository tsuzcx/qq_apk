import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class jhb
  implements Runnable
{
  public jhb(VideoNodeReporter paramVideoNodeReporter, String paramString) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "updateCrashType ,crashType = " + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a.iterator();
      while (localIterator.hasNext()) {
        ((jhd)localIterator.next()).d = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhb
 * JD-Core Version:    0.7.0.1
 */
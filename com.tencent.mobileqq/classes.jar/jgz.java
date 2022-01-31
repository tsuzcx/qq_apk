import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class jgz
  implements Runnable
{
  public jgz(VideoNodeReporter paramVideoNodeReporter, int paramInt, long paramLong) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "in runnabe report ,node = " + this.jdField_a_of_type_Int + ",value = " + this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a.iterator();
      while (localIterator.hasNext())
      {
        jhd localjhd = (jhd)localIterator.next();
        this.jdField_a_of_type_ComTencentAvBusinessManagerReportVideoNodeReporter.a(localjhd.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      }
    }
    QLog.d("VideoNodeReporter", 1, " report ,node = " + this.jdField_a_of_type_Int + ",value = " + this.jdField_a_of_type_Long + ",seesionRecordList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgz
 * JD-Core Version:    0.7.0.1
 */
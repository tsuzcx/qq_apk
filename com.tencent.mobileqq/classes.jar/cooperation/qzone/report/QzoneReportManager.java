package cooperation.qzone.report;

import bjrc;
import bjsl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QzoneReportManager
{
  private static final bjsl<QzoneReportManager, Void> jdField_a_of_type_Bjsl = new bjrc();
  public static String a;
  public static boolean a;
  volatile int jdField_a_of_type_Int = 0;
  ConcurrentLinkedQueue<QzoneReportManager.ProcessRunner> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private void a()
  {
    if (this.jdField_a_of_type_Int < 3)
    {
      QzoneReportManager.ProcessRunner localProcessRunner = (QzoneReportManager.ProcessRunner)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localProcessRunner != null)
      {
        this.jdField_a_of_type_Int += 1;
        ThreadManager.excute(localProcessRunner, 32, null, true);
      }
    }
  }
  
  static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  static boolean a(int paramInt)
  {
    return false;
  }
  
  static boolean b(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager
 * JD-Core Version:    0.7.0.1
 */
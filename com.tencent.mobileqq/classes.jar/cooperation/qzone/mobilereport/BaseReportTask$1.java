package cooperation.qzone.mobilereport;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseReportTask$1
  implements Runnable
{
  BaseReportTask$1(BaseReportTask paramBaseReportTask) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(3000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    HashMap localHashMap2 = new HashMap();
    synchronized (BaseReportTask.access$000(this.this$0))
    {
      localHashMap2.putAll(BaseReportTask.access$000(this.this$0));
      BaseReportTask.access$000(this.this$0).clear();
      BaseReportTask.access$100(this.this$0).set(false);
      this.this$0.doMobileReport(localHashMap2);
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseReportTask", 4, "report finish!!!");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.BaseReportTask.1
 * JD-Core Version:    0.7.0.1
 */
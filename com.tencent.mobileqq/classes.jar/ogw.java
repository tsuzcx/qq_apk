import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ogw
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.e("MonitorTimeExecutor", 1, "[rejectedExecution] r: " + paramRunnable + " executor: " + paramThreadPoolExecutor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */
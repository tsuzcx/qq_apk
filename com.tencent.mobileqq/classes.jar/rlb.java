import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class rlb
  implements rkt, rkx
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rlc(this);
  private Queue<rku> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private rky jdField_a_of_type_Rky;
  private boolean jdField_a_of_type_Boolean;
  private Queue<rku> b = new ArrayDeque();
  
  public rlb(rky paramrky)
  {
    this.jdField_a_of_type_Rky = paramrky;
    this.jdField_a_of_type_Rky.a(this);
  }
  
  private boolean a()
  {
    return this.b.size() < 3;
  }
  
  private void b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilQueue.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("PreviewCaptureManager", 2, "fetchTaskToExe return for capturePrepared is false or waittingTaskQueue is Empty");
      }
    }
    for (;;)
    {
      return;
      while (a())
      {
        rku localrku = (rku)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localrku != null) {
          e(localrku);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(rku paramrku)
  {
    paramrku.a(this.jdField_a_of_type_Rky);
    paramrku.a(this);
  }
  
  private void e(rku paramrku)
  {
    this.b.add(paramrku);
    d(paramrku);
    paramrku.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilQueue);
    localArrayList.addAll(this.b);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.b.clear();
    int i = 0;
    while (i < localArrayList.size())
    {
      rku localrku = (rku)localArrayList.get(i);
      if (localrku != null) {
        localrku.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Rky != null) {
      this.jdField_a_of_type_Rky.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(rku paramrku) {}
  
  public void b(rku paramrku)
  {
    this.b.remove(paramrku);
    c();
  }
  
  public void c(rku paramrku)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramrku)) || (this.b.contains(paramrku))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramrku);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramrku);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlb
 * JD-Core Version:    0.7.0.1
 */
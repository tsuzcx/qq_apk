import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class reb
  implements rdt, rdx
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rec(this);
  private Queue<rdu> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = aoik.a(64);
  private rdy jdField_a_of_type_Rdy;
  private boolean jdField_a_of_type_Boolean;
  private Queue<rdu> b = new ArrayDeque();
  
  public reb(rdy paramrdy)
  {
    this.jdField_a_of_type_Rdy = paramrdy;
    this.jdField_a_of_type_Rdy.a(this);
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
        rdu localrdu = (rdu)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localrdu != null) {
          e(localrdu);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(rdu paramrdu)
  {
    paramrdu.a(this.jdField_a_of_type_Rdy);
    paramrdu.a(this);
  }
  
  private void e(rdu paramrdu)
  {
    this.b.add(paramrdu);
    d(paramrdu);
    paramrdu.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
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
      rdu localrdu = (rdu)localArrayList.get(i);
      if (localrdu != null) {
        localrdu.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Rdy != null) {
      this.jdField_a_of_type_Rdy.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(rdu paramrdu) {}
  
  public void b(rdu paramrdu)
  {
    this.b.remove(paramrdu);
    c();
  }
  
  public void c(rdu paramrdu)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramrdu)) || (this.b.contains(paramrdu))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramrdu);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramrdu);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     reb
 * JD-Core Version:    0.7.0.1
 */
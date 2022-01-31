import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class qsd
  implements qrv, qrz
{
  private Handler jdField_a_of_type_AndroidOsHandler = new qse(this);
  private Queue<qrw> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = amdp.a(64);
  private qsa jdField_a_of_type_Qsa;
  private boolean jdField_a_of_type_Boolean;
  private Queue<qrw> b = new ArrayDeque();
  
  public qsd(qsa paramqsa)
  {
    this.jdField_a_of_type_Qsa = paramqsa;
    this.jdField_a_of_type_Qsa.a(this);
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
        qrw localqrw = (qrw)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localqrw != null) {
          e(localqrw);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(qrw paramqrw)
  {
    paramqrw.a(this.jdField_a_of_type_Qsa);
    paramqrw.a(this);
  }
  
  private void e(qrw paramqrw)
  {
    this.b.add(paramqrw);
    d(paramqrw);
    paramqrw.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
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
      qrw localqrw = (qrw)localArrayList.get(i);
      if (localqrw != null) {
        localqrw.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Qsa != null) {
      this.jdField_a_of_type_Qsa.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(qrw paramqrw) {}
  
  public void b(qrw paramqrw)
  {
    this.b.remove(paramqrw);
    c();
  }
  
  public void c(qrw paramqrw)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramqrw)) || (this.b.contains(paramqrw))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramqrw);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramqrw);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsd
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class rng
  implements rmy, rnc
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rnh(this);
  private Queue<rmz> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = anvy.a(64);
  private rnd jdField_a_of_type_Rnd;
  private boolean jdField_a_of_type_Boolean;
  private Queue<rmz> b = new ArrayDeque();
  
  public rng(rnd paramrnd)
  {
    this.jdField_a_of_type_Rnd = paramrnd;
    this.jdField_a_of_type_Rnd.a(this);
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
        rmz localrmz = (rmz)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localrmz != null) {
          e(localrmz);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(rmz paramrmz)
  {
    paramrmz.a(this.jdField_a_of_type_Rnd);
    paramrmz.a(this);
  }
  
  private void e(rmz paramrmz)
  {
    this.b.add(paramrmz);
    d(paramrmz);
    paramrmz.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
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
      rmz localrmz = (rmz)localArrayList.get(i);
      if (localrmz != null) {
        localrmz.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Rnd != null) {
      this.jdField_a_of_type_Rnd.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(rmz paramrmz) {}
  
  public void b(rmz paramrmz)
  {
    this.b.remove(paramrmz);
    c();
  }
  
  public void c(rmz paramrmz)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramrmz)) || (this.b.contains(paramrmz))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramrmz);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramrmz);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rng
 * JD-Core Version:    0.7.0.1
 */
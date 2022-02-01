import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class rxo
  implements rxg, rxk
{
  private Handler jdField_a_of_type_AndroidOsHandler = new rxp(this);
  private Queue<rxh> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManagerExecutor.getExecutorService(64);
  private rxl jdField_a_of_type_Rxl;
  private boolean jdField_a_of_type_Boolean;
  private Queue<rxh> b = new ArrayDeque();
  
  public rxo(rxl paramrxl)
  {
    this.jdField_a_of_type_Rxl = paramrxl;
    this.jdField_a_of_type_Rxl.a(this);
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
        rxh localrxh = (rxh)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (localrxh != null) {
          e(localrxh);
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
  }
  
  private void d(rxh paramrxh)
  {
    paramrxh.a(this.jdField_a_of_type_Rxl);
    paramrxh.a(this);
  }
  
  private void e(rxh paramrxh)
  {
    this.b.add(paramrxh);
    d(paramrxh);
    paramrxh.executeOnExecutor(this.jdField_a_of_type_JavaUtilConcurrentExecutor, null);
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
      rxh localrxh = (rxh)localArrayList.get(i);
      if (localrxh != null) {
        localrxh.cancel(true);
      }
      i += 1;
    }
    if (this.jdField_a_of_type_Rxl != null) {
      this.jdField_a_of_type_Rxl.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(rxh paramrxh) {}
  
  public void b(rxh paramrxh)
  {
    this.b.remove(paramrxh);
    c();
  }
  
  public void c(rxh paramrxh)
  {
    if ((this.jdField_a_of_type_JavaUtilQueue.contains(paramrxh)) || (this.b.contains(paramrxh))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + paramrxh);
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramrxh);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxo
 * JD-Core Version:    0.7.0.1
 */
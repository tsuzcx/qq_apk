import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.component.network.utils.thread.internel.ArrayDeque;
import java.util.concurrent.Executor;

public class pjx
  implements Executor
{
  final ArrayDeque jdField_a_of_type_ComTencentComponentNetworkUtilsThreadInternelArrayDeque = new ArrayDeque();
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadInternelArrayDeque.poll();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null) {
        AsyncTask.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadInternelArrayDeque.offer(new pjy(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjx
 * JD-Core Version:    0.7.0.1
 */
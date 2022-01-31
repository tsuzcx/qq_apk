import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class stc
  implements Executor
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final Queue<Runnable> jdField_a_of_type_JavaUtilQueue;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int b;
  
  private stc(@NonNull String paramString, int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
    int i = this.jdField_a_of_type_JavaUtilQueue.size();
    if (i > Runtime.getRuntime().availableProcessors()) {
      veg.b(this.jdField_a_of_type_JavaLangString, "too many runnable remained in the queue, size " + i);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= this.jdField_a_of_type_Int)
    {
      veg.b(this.jdField_a_of_type_JavaLangString, "current number of task threshold is " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      while (!this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        paramRunnable = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
        if (paramRunnable != null) {
          ThreadManager.excute(paramRunnable, this.b, new std(this, paramRunnable), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stc
 * JD-Core Version:    0.7.0.1
 */
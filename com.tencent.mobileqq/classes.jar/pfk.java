import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class pfk
  implements ThreadFactory
{
  private final String jdField_a_of_type_JavaLangString;
  private final ThreadGroup jdField_a_of_type_JavaLangThreadGroup;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  public pfk()
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {}
    for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
    {
      this.jdField_a_of_type_JavaLangThreadGroup = ((ThreadGroup)localObject);
      this.jdField_a_of_type_JavaLangString = "readinjoy-common-";
      return;
    }
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(this.jdField_a_of_type_JavaLangThreadGroup, paramRunnable, this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfk
 * JD-Core Version:    0.7.0.1
 */
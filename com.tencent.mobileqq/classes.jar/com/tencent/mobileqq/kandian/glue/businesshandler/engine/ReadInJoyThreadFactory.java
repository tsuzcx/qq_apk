package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadInJoyThreadFactory
  implements ThreadFactory
{
  private final String jdField_a_of_type_JavaLangString;
  private final ThreadGroup jdField_a_of_type_JavaLangThreadGroup;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  
  ReadInJoyThreadFactory()
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    this.jdField_a_of_type_JavaLangThreadGroup = ((ThreadGroup)localObject);
    this.jdField_a_of_type_JavaLangString = "readinjoy-common-";
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = this.jdField_a_of_type_JavaLangThreadGroup;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    if (paramRunnable.isDaemon()) {
      paramRunnable.setDaemon(false);
    }
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyThreadFactory
 * JD-Core Version:    0.7.0.1
 */
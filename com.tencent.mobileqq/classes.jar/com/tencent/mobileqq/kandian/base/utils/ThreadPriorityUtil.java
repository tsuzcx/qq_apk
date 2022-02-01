package com.tencent.mobileqq.kandian.base.utils;

import android.os.Looper;

public class ThreadPriorityUtil
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangThread.getPriority();
  private Thread jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
  private int jdField_b_of_type_Int;
  private Thread jdField_b_of_type_JavaLangThread;
  
  public ThreadPriorityUtil()
  {
    for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    int i = 0;
    while (i < arrayOfThread.length)
    {
      if ((arrayOfThread[i] != null) && (arrayOfThread[i].isAlive()) && (arrayOfThread[i].getName().equalsIgnoreCase("RenderThread")))
      {
        this.jdField_b_of_type_JavaLangThread = arrayOfThread[i];
        this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangThread.getPriority();
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    Thread localThread = this.jdField_b_of_type_JavaLangThread;
    if (localThread != null) {
      localThread.setPriority(10);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangThread.setPriority(this.jdField_a_of_type_Int);
    Thread localThread = this.jdField_b_of_type_JavaLangThread;
    if (localThread != null) {
      localThread.setPriority(this.jdField_b_of_type_Int);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("main:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangThread.getPriority());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.jdField_b_of_type_JavaLangThread != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" render:");
      localStringBuilder2.append(this.jdField_b_of_type_JavaLangThread.getPriority());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ThreadPriorityUtil
 * JD-Core Version:    0.7.0.1
 */
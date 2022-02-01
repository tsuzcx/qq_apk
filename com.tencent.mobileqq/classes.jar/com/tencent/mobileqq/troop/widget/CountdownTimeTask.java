package com.tencent.mobileqq.troop.widget;

import com.tencent.qphone.base.util.QLog;

public class CountdownTimeTask
  implements Runnable
{
  protected long a;
  protected Object a;
  protected Runnable a;
  
  public CountdownTimeTask(Runnable paramRunnable, int paramInt)
  {
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    a(paramInt);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Long);
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resetTimer: ");
        localStringBuilder.append(paramLong);
        QLog.d("CountDownTimeTask", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
  }
  
  public void b()
  {
    a(-1L);
  }
  
  public void run()
  {
    long l;
    for (;;)
    {
      l = this.jdField_a_of_type_Long;
      if (l <= 0L) {
        break;
      }
      try
      {
        Thread.sleep(100L);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_Long -= 100L;
          if (!QLog.isColorLevel()) {
            continue;
          }
          ??? = new StringBuilder();
          ((StringBuilder)???).append("run: ");
          ((StringBuilder)???).append(this.jdField_a_of_type_Long);
          QLog.d("CountDownTimeTask", 2, ((StringBuilder)???).toString());
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      QLog.d("CountDownTimeTask", 2, QLog.getStackTraceString(localInterruptedException));
    }
    if (l != -1L)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.CountdownTimeTask
 * JD-Core Version:    0.7.0.1
 */
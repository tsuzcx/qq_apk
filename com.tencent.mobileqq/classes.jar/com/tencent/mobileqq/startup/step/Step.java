package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;

public class Step
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public StartupDirector a;
  protected String a;
  private int[] jdField_a_of_type_ArrayOfInt;
  protected int c;
  
  public void a(Handler paramHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected boolean a()
  {
    if (this.c == 0)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (!Step.AmStepFactory.b(arrayOfInt[i], this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector, null).c()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public final boolean c()
  {
    long l = 0L;
    int i = 5;
    Thread localThread = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      localThread = Thread.currentThread();
      i = localThread.getPriority();
      localThread.setPriority(10);
    }
    if (StartupDirector.a)
    {
      l = SystemClock.uptimeMillis();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label170;
      }
      TraceUtils.a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      boolean bool1 = false;
      try
      {
        boolean bool2 = a();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", localThrowable);
          continue;
          TraceUtils.b(4096L, this.jdField_a_of_type_JavaLangString, Process.myTid());
        }
      }
      if (StartupDirector.a)
      {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        TraceUtils.a();
        Log.i("AutoMonitor", this.jdField_a_of_type_JavaLangString + ", cost=" + (SystemClock.uptimeMillis() - l) + " results: " + bool1);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(this.jdField_a_of_type_Int, Boolean.valueOf(bool1)).sendToTarget();
        localThread.setPriority(i);
      }
      return bool1;
      label170:
      TraceUtils.a(4096L, this.jdField_a_of_type_JavaLangString, Process.myTid());
    }
  }
  
  public void run()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step
 * JD-Core Version:    0.7.0.1
 */
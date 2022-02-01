package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class FPSCalculator
{
  private static volatile FPSCalculator jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = new FPSCalculator.2(this);
  private Vector<FPSCalculator.GetFPSListener> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable b = new FPSCalculator.3(this);
  
  private static long a(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public static FPSCalculator a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator == null) {
          jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator = new FPSCalculator();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("FPSCalculator", 2, "FPSCalculator is enable");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    QLog.d("FPSCalculator", 2, "FPSCalculator set enable = true");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback == null) {
        this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new FPSCalculator.1(this);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FPSCalculator", 2, "build version is not support ");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.b, 500L);
  }
  
  private void a(long paramLong)
  {
    paramLong = a(paramLong);
    long l = this.jdField_a_of_type_Long;
    if (l <= 0L)
    {
      this.jdField_a_of_type_Long = paramLong;
    }
    else
    {
      l = paramLong - l;
      this.jdField_a_of_type_Int += 1;
      if (l > 500L)
      {
        double d1 = this.jdField_a_of_type_Int * 1000;
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        this.jdField_a_of_type_Long = paramLong;
        int i = 0;
        this.jdField_a_of_type_Int = 0;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          while (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            ((FPSCalculator.GetFPSListener)this.jdField_a_of_type_JavaUtilVector.get(i)).onInfo(this.jdField_a_of_type_Long, d1);
            i += 1;
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        Choreographer localChoreographer = this.jdField_a_of_type_AndroidViewChoreographer;
        if (localChoreographer != null)
        {
          localChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
          if (QLog.isColorLevel()) {
            QLog.d("FPSCalculator", 2, "removeFrameCallback ");
          }
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      else
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
      }
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      QLog.d("FPSCalculator", 2, "FPSCalculator set enable = false");
    }
  }
  
  public void a(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilVector.contains(paramGetFPSListener)) {
        this.jdField_a_of_type_JavaUtilVector.add(paramGetFPSListener);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() > 0) {
        a();
      }
      return;
    }
  }
  
  public void b(FPSCalculator.GetFPSListener paramGetFPSListener)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilVector.contains(paramGetFPSListener)) {
        this.jdField_a_of_type_JavaUtilVector.remove(paramGetFPSListener);
      }
      if (this.jdField_a_of_type_JavaUtilVector.size() <= 0) {
        b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.FPSCalculator
 * JD-Core Version:    0.7.0.1
 */
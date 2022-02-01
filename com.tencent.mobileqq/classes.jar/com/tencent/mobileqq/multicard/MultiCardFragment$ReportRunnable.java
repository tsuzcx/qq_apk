package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MultiCardFragment$ReportRunnable
  implements Runnable
{
  private int a;
  public boolean a;
  private int b;
  private int c;
  
  public MultiCardFragment$ReportRunnable()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
    this.c = paramInt;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt > this.b) {
        this.b = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    int i;
    try
    {
      if (this.jdField_a_of_type_Int == this.b) {
        return;
      }
      i = this.b - this.jdField_a_of_type_Int;
      int j = this.c - this.b - 1;
      if (j >= 5) {
        i += 5;
      }
      for (;;)
      {
        this.jdField_a_of_type_Int += i;
        this.b = this.jdField_a_of_type_Int;
        j = 0;
        while (j < i)
        {
          MultiCardFragment.a("0X800A215", 0);
          j += 1;
        }
        i += j;
      }
      if (!QLog.isColorLevel()) {
        return;
      }
    }
    finally {}
    QLog.d("MultiCardFragment", 2, "0X800A215_report:" + i + " pos:" + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */
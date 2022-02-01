package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MultiCardFragment$ReportRunnable
  implements Runnable
{
  public boolean a = true;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    this.b = -1;
    this.c = -1;
    this.d = paramInt;
  }
  
  public void b()
  {
    ThreadManager.getSubThreadHandler().post(this);
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (paramInt > this.c) {
        this.c = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    try
    {
      if (this.b == this.c) {
        return;
      }
      i = this.c - this.b;
      j = this.d - this.c - 1;
      if (j < 5) {
        break label155;
      }
      i += 5;
    }
    finally
    {
      for (;;)
      {
        int i;
        int j;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw localObject;
        }
        label155:
        i += j;
      }
    }
    this.b += i;
    this.c = this.b;
    j = 0;
    while (j < i)
    {
      MultiCardFragment.a("0X800A215", 0);
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0X800A215_report:");
      localStringBuilder.append(i);
      localStringBuilder.append(" pos:");
      localStringBuilder.append(this.b);
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */
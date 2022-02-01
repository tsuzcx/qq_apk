package com.tencent.mobileqq.troop.widget;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class BaseUsingTimeReport
  implements UsingTimeReportManager.IStateChangeCallBack
{
  private long a = 0L;
  public String b;
  public String c;
  public String d;
  private long e = 0L;
  private boolean f = false;
  private boolean g = false;
  private UsingTimeReportManager h;
  
  public BaseUsingTimeReport(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  private void g()
  {
    this.h = a();
    UsingTimeReportManager localUsingTimeReportManager = this.h;
    if ((localUsingTimeReportManager != null) && (!this.g))
    {
      localUsingTimeReportManager.a(this);
      this.g = true;
    }
  }
  
  private void h()
  {
    UsingTimeReportManager localUsingTimeReportManager = this.h;
    if ((localUsingTimeReportManager != null) && (this.g))
    {
      localUsingTimeReportManager.b(this);
      this.g = false;
    }
  }
  
  private void i()
  {
    if (!this.g) {
      return;
    }
    if (this.f)
    {
      this.e = SystemClock.uptimeMillis();
      long l = this.e - this.a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop,usingTime=");
        localStringBuilder.append(l);
        QLog.i("BaseUsingTimeReport", 2, localStringBuilder.toString());
      }
      if ((l > 0L) && (this.g)) {
        a(l);
      }
      this.f = false;
    }
  }
  
  public UsingTimeReportManager a()
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void b()
  {
    g();
    if (!this.g) {
      return;
    }
    if (!this.f)
    {
      this.a = SystemClock.uptimeMillis();
      this.f = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start(), mStartTime=");
        localStringBuilder.append(this.a);
        QLog.i("BaseUsingTimeReport", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void c()
  {
    i();
    h();
  }
  
  public void d()
  {
    i();
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BaseUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */
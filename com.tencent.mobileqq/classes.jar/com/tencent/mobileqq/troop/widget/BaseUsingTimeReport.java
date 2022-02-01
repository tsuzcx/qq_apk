package com.tencent.mobileqq.troop.widget;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class BaseUsingTimeReport
  implements UsingTimeReportManager.IStateChangeCallBack
{
  private long jdField_a_of_type_Long = 0L;
  private UsingTimeReportManager jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  public String c;
  
  public BaseUsingTimeReport(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager = a();
    UsingTimeReportManager localUsingTimeReportManager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager;
    if ((localUsingTimeReportManager != null) && (!this.jdField_b_of_type_Boolean))
    {
      localUsingTimeReportManager.a(this);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void g()
  {
    UsingTimeReportManager localUsingTimeReportManager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetUsingTimeReportManager;
    if ((localUsingTimeReportManager != null) && (this.jdField_b_of_type_Boolean))
    {
      localUsingTimeReportManager.b(this);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void h()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stop,usingTime=");
        localStringBuilder.append(l);
        QLog.i("BaseUsingTimeReport", 2, localStringBuilder.toString());
      }
      if ((l > 0L) && (this.jdField_b_of_type_Boolean)) {
        a(l);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public UsingTimeReportManager a()
  {
    return null;
  }
  
  public void a()
  {
    f();
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start(), mStartTime=");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        QLog.i("BaseUsingTimeReport", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void b()
  {
    h();
    g();
  }
  
  public void c()
  {
    h();
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BaseUsingTimeReport
 * JD-Core Version:    0.7.0.1
 */
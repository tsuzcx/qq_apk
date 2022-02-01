package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import com.tencent.qphone.base.util.QLog;

public class RefreshProgressRunnable
  implements Runnable
{
  public int a;
  private volatile long jdField_a_of_type_Long = -1L;
  public MessageProgressView a;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile long b = -1L;
  
  public RefreshProgressRunnable(MessageProgressView paramMessageProgressView, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramMessageProgressView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
  }
  
  public void a(MessageProgressView paramMessageProgressView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramMessageProgressView;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageProgressView", 2, " stopAnim in isStopped key=" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      while ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null))
      {
        ViewCompat.postOnAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, this);
        return;
        long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
        if (l >= 0L)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) && (this.jdField_a_of_type_Int < 100))
          {
            if (l / this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.e % 2L == 0L) {}
            for (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_Long = (l % this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.e);; this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.e - l % this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.e))
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
              break;
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) && (this.jdField_a_of_type_Int == 100) && (this.b == -1L)) {
            this.b = SystemClock.uptimeMillis();
          }
          l = SystemClock.uptimeMillis() - this.b;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) && (l >= this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.d))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.d;
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
            if (QLog.isColorLevel()) {
              QLog.e("MessageProgressView", 2, " stopAnim in run key=" + this.jdField_a_of_type_JavaLangString + " , mProgress = " + this.jdField_a_of_type_Int);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(this.jdField_a_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView$AnimRunnableListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView$AnimRunnableListener.a(this.jdField_a_of_type_JavaLangString);
            }
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_Long = (l % this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.d);
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */
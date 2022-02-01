package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.View;
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
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" stopAnim in isStopped key=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.e("MessageProgressView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = null;
      return;
    }
    if (this.jdField_a_of_type_Long == -1L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    else
    {
      long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      if (l >= 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
        if ((localObject != null) && (this.jdField_a_of_type_Int < 100))
        {
          if (l / ((MessageProgressView)localObject).e % 2L == 0L)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
            ((MessageProgressView)localObject).jdField_a_of_type_Long = (l % ((MessageProgressView)localObject).e);
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
            ((MessageProgressView)localObject).jdField_a_of_type_Long = (((MessageProgressView)localObject).e - l % this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.e);
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) && (this.jdField_a_of_type_Int == 100) && (this.b == -1L)) {
            this.b = SystemClock.uptimeMillis();
          }
          l = SystemClock.uptimeMillis() - this.b;
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
          if ((localObject != null) && (l >= ((MessageProgressView)localObject).d))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
            ((MessageProgressView)localObject).jdField_a_of_type_Long = ((MessageProgressView)localObject).d;
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" stopAnim in run key=");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" , mProgress = ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
              QLog.e("MessageProgressView", 2, ((StringBuilder)localObject).toString());
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(this.jdField_a_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView$AnimRunnableListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView$AnimRunnableListener.a(this.jdField_a_of_type_JavaLangString);
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
            if (localObject != null)
            {
              ((MessageProgressView)localObject).jdField_a_of_type_Long = (l % ((MessageProgressView)localObject).d);
              this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.invalidate();
            }
          }
        }
      }
      else
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      if (localObject != null) {
        ViewCompat.postOnAnimation((View)localObject, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */
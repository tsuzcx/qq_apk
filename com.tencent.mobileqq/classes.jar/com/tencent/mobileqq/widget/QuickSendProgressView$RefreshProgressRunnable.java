package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QuickSendProgressView$RefreshProgressRunnable
  implements Runnable
{
  private volatile long jdField_a_of_type_Long = -1L;
  private WeakReference<QuickSendProgressView> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private long b = 800L;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(QuickSendProgressView paramQuickSendProgressView)
  {
    if (!a())
    {
      if (paramQuickSendProgressView == null) {
        return;
      }
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQuickSendProgressView);
      ViewCompat.postOnAnimation(paramQuickSendProgressView, this);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean ^ true;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuickSendProgressView", 2, " stopAnim in isStopped");
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (QuickSendProgressView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Long == -1L) {
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
        long l1 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
        long l2 = this.b;
        if (l1 >= l2)
        {
          QuickSendProgressView.a((QuickSendProgressView)localObject, 1.0F);
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
        else
        {
          QuickSendProgressView.a((QuickSendProgressView)localObject, (float)l1 * 1.0F / (float)l2);
        }
        if (!this.jdField_a_of_type_Boolean) {
          ViewCompat.postOnAnimation((View)localObject, this);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QuickSendProgressView", 2, "mView is null, stopAnim in isStopped");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */
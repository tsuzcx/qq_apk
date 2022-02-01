package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QuickSendProgressView$RefreshProgressRunnable
  implements Runnable
{
  private WeakReference<QuickSendProgressView> a;
  private volatile long b = -1L;
  private long c = 800L;
  private volatile boolean d = true;
  
  public void a(QuickSendProgressView paramQuickSendProgressView)
  {
    if (!a())
    {
      if (paramQuickSendProgressView == null) {
        return;
      }
      this.b = -1L;
      this.d = false;
      this.a = new WeakReference(paramQuickSendProgressView);
      ViewCompat.postOnAnimation(paramQuickSendProgressView, this);
    }
  }
  
  public boolean a()
  {
    return this.d ^ true;
  }
  
  public void b()
  {
    this.d = true;
  }
  
  public void run()
  {
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuickSendProgressView", 2, " stopAnim in isStopped");
      }
      this.a = null;
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QuickSendProgressView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (this.b == -1L) {
          this.b = SystemClock.uptimeMillis();
        }
        long l1 = SystemClock.uptimeMillis() - this.b;
        long l2 = this.c;
        if (l1 >= l2)
        {
          QuickSendProgressView.a((QuickSendProgressView)localObject, 1.0F);
          this.b = SystemClock.uptimeMillis();
        }
        else
        {
          QuickSendProgressView.a((QuickSendProgressView)localObject, (float)l1 * 1.0F / (float)l2);
        }
        if (!this.d) {
          ViewCompat.postOnAnimation((View)localObject, this);
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QuickSendProgressView", 2, "mView is null, stopAnim in isStopped");
    }
    this.d = true;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QuickSendProgressView.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */
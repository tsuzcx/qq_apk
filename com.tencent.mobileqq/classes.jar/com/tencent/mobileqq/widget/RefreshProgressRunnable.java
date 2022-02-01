package com.tencent.mobileqq.widget;

import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class RefreshProgressRunnable
  implements Runnable
{
  public String a = "";
  public MessageProgressView b;
  public int c;
  private volatile long d = -1L;
  private volatile long e = -1L;
  private volatile boolean f = false;
  
  public RefreshProgressRunnable(MessageProgressView paramMessageProgressView, String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramMessageProgressView;
    this.c = paramInt;
  }
  
  public void a()
  {
    this.f = true;
    this.d = -1L;
    this.e = -1L;
  }
  
  public void a(MessageProgressView paramMessageProgressView, int paramInt)
  {
    this.b = paramMessageProgressView;
    this.c = paramInt;
  }
  
  public void run()
  {
    Object localObject;
    if (this.f)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" stopAnim in isStopped key=");
        ((StringBuilder)localObject).append(this.a);
        QLog.e("MessageProgressView", 2, ((StringBuilder)localObject).toString());
      }
      this.b.b(this.a);
      this.b = null;
      return;
    }
    if (this.d == -1L)
    {
      this.d = SystemClock.uptimeMillis();
    }
    else
    {
      long l = SystemClock.uptimeMillis() - this.d;
      if (l >= 0L)
      {
        localObject = this.b;
        if ((localObject != null) && (this.c < 100))
        {
          if (l / ((MessageProgressView)localObject).w % 2L == 0L)
          {
            localObject = this.b;
            ((MessageProgressView)localObject).j = (l % ((MessageProgressView)localObject).w);
          }
          else
          {
            localObject = this.b;
            ((MessageProgressView)localObject).j = (((MessageProgressView)localObject).w - l % this.b.w);
          }
          this.b.invalidate();
        }
        else
        {
          if ((this.b != null) && (this.c == 100) && (this.e == -1L)) {
            this.e = SystemClock.uptimeMillis();
          }
          l = SystemClock.uptimeMillis() - this.e;
          localObject = this.b;
          if ((localObject != null) && (l >= ((MessageProgressView)localObject).s))
          {
            localObject = this.b;
            ((MessageProgressView)localObject).j = ((MessageProgressView)localObject).s;
            this.b.invalidate();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" stopAnim in run key=");
              ((StringBuilder)localObject).append(this.a);
              ((StringBuilder)localObject).append(" , mProgress = ");
              ((StringBuilder)localObject).append(this.c);
              QLog.e("MessageProgressView", 2, ((StringBuilder)localObject).toString());
            }
            this.b.b(this.a);
            if (this.b.n != null) {
              this.b.n.a(this.a);
            }
          }
          else
          {
            localObject = this.b;
            if (localObject != null)
            {
              ((MessageProgressView)localObject).j = (l % ((MessageProgressView)localObject).s);
              this.b.invalidate();
            }
          }
        }
      }
      else
      {
        this.d = SystemClock.uptimeMillis();
      }
    }
    if (!this.f)
    {
      localObject = this.b;
      if (localObject != null) {
        ViewCompat.postOnAnimation((View)localObject, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshProgressRunnable
 * JD-Core Version:    0.7.0.1
 */
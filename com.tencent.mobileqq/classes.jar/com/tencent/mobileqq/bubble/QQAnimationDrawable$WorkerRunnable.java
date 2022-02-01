package com.tencent.mobileqq.bubble;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class QQAnimationDrawable$WorkerRunnable
  implements Runnable
{
  private int a;
  private long b;
  
  public QQAnimationDrawable$WorkerRunnable(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WorkerRunnable run | drawtime:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("QQAnimationDrawable", 2, ((StringBuilder)localObject).toString());
    Process.setThreadPriority(10);
    long l = SystemClock.uptimeMillis();
    localObject = this.this$0;
    ((QQAnimationDrawable)localObject).c = ((QQAnimationDrawable)localObject).a(false, this.a);
    QQAnimationDrawable.a(this.this$0, this.a);
    if ((this.this$0.b == null) && (this.a == 0))
    {
      localObject = this.this$0;
      ((QQAnimationDrawable)localObject).b = ((QQAnimationDrawable)localObject).c;
    }
    if (QQAnimationDrawable.a(this.this$0) != null) {
      QQAnimationDrawable.a(this.this$0).a(this.a);
    }
    localObject = this.this$0;
    ((QQAnimationDrawable)localObject).scheduleSelf((Runnable)localObject, SystemClock.uptimeMillis() + Math.max(this.b - l, 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.WorkerRunnable
 * JD-Core Version:    0.7.0.1
 */
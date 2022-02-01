package com.tencent.mobileqq.bubble;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import apyj;
import com.tencent.qphone.base.util.QLog;

class QQAnimationDrawable$WorkerRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public QQAnimationDrawable$WorkerRunnable(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder().append("WorkerRunnable run | drawtime:").append(this.jdField_a_of_type_Long).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 2, bool);
      Process.setThreadPriority(10);
      long l1 = SystemClock.uptimeMillis();
      this.this$0.b = this.this$0.a(false, this.jdField_a_of_type_Int);
      QQAnimationDrawable.a(this.this$0, this.jdField_a_of_type_Int);
      if ((this.this$0.a == null) && (this.jdField_a_of_type_Int == 0)) {
        this.this$0.a = this.this$0.b;
      }
      if (QQAnimationDrawable.a(this.this$0) != null) {
        QQAnimationDrawable.a(this.this$0).a(this.jdField_a_of_type_Int);
      }
      localObject = this.this$0;
      QQAnimationDrawable localQQAnimationDrawable = this.this$0;
      long l2 = SystemClock.uptimeMillis();
      ((QQAnimationDrawable)localObject).scheduleSelf(localQQAnimationDrawable, Math.max(this.jdField_a_of_type_Long - l1, 0L) + l2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.WorkerRunnable
 * JD-Core Version:    0.7.0.1
 */
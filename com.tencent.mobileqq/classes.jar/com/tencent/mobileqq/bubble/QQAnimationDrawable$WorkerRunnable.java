package com.tencent.mobileqq.bubble;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WorkerRunnable run | drawtime:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
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
    ((QQAnimationDrawable)localObject).b = ((QQAnimationDrawable)localObject).a(false, this.jdField_a_of_type_Int);
    QQAnimationDrawable.a(this.this$0, this.jdField_a_of_type_Int);
    if ((this.this$0.a == null) && (this.jdField_a_of_type_Int == 0))
    {
      localObject = this.this$0;
      ((QQAnimationDrawable)localObject).a = ((QQAnimationDrawable)localObject).b;
    }
    if (QQAnimationDrawable.a(this.this$0) != null) {
      QQAnimationDrawable.a(this.this$0).a(this.jdField_a_of_type_Int);
    }
    localObject = this.this$0;
    ((QQAnimationDrawable)localObject).scheduleSelf((Runnable)localObject, SystemClock.uptimeMillis() + Math.max(this.jdField_a_of_type_Long - l, 0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.WorkerRunnable
 * JD-Core Version:    0.7.0.1
 */
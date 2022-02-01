package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

class QQAnimationDrawable$InternalHandler
  extends Handler
{
  private QQAnimationDrawable b;
  
  public QQAnimationDrawable$InternalHandler(QQAnimationDrawable paramQQAnimationDrawable1, QQAnimationDrawable paramQQAnimationDrawable2)
  {
    this.b = paramQQAnimationDrawable2;
  }
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InternalHandler handleMessage msg.what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(" main:");
    boolean bool;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("QQAnimationDrawable", 2, localStringBuilder.toString());
    if ((paramMessage.obj instanceof Long))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("InternalHandler handleMessage msg.obj:");
      localStringBuilder.append(paramMessage.obj);
      localStringBuilder.append(" android.os.SystemClock.uptimeMillis():");
      localStringBuilder.append(SystemClock.uptimeMillis());
      QLog.d("QQAnimationDrawable", 2, localStringBuilder.toString());
      paramMessage = (Long)paramMessage.obj;
      if (paramMessage.longValue() < SystemClock.uptimeMillis())
      {
        QLog.d("QQAnimationDrawable", 2, "time < android.os.SystemClock.uptimeMillis()");
        this.a.scheduleSelf(this.b, SystemClock.uptimeMillis());
        return;
      }
      QLog.d("QQAnimationDrawable", 2, "time > android.os.SystemClock.uptimeMillis()");
      this.a.scheduleSelf(this.b, paramMessage.longValue());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("InternalHandler handleMessage msg.obj:");
    localStringBuilder.append(paramMessage.obj);
    QLog.d("QQAnimationDrawable", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.QQAnimationDrawable.InternalHandler
 * JD-Core Version:    0.7.0.1
 */
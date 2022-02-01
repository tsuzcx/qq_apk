package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

class QQBlur$1
  implements Runnable
{
  private int b = -1;
  
  QQBlur$1(QQBlur paramQQBlur, StackBlurManager paramStackBlurManager) {}
  
  private void a()
  {
    if (QQBlur.a(this.this$0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    int i = this.b;
    if ((i != -1) && (i != QQBlur.a)) {
      QQBlur.a(this.this$0, this.b, QQBlur.a);
    }
    this.b = QQBlur.a;
    i = QQBlur.a;
    try
    {
      localObject = this.a.process(QQBlur.b(this.this$0));
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label76:
      long l2;
      break label76;
    }
    localObject = null;
    QLog.e("QQBlur", 1, "run: process blur OOM ?");
    if (localObject != null) {
      QQBlur.a(this.this$0, (Bitmap)localObject);
    } else {
      QLog.e("QQBlur", 1, "run: outBitmap is null. OOM ?");
    }
    l2 = SystemClock.elapsedRealtime();
    QQBlur.c(this.this$0);
    localObject = this.this$0;
    QQBlur.a((QQBlur)localObject, QQBlur.d((QQBlur)localObject) + (l2 - l1));
    localObject = QQBlur.e(this.this$0);
    if ((localObject != null) && (QQBlur.f(this.this$0))) {
      ((View)localObject).postInvalidate();
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */
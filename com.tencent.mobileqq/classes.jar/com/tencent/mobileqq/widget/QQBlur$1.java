package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

class QQBlur$1
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  
  QQBlur$1(QQBlur paramQQBlur, StackBlurManager paramStackBlurManager) {}
  
  private void a()
  {
    if (QQBlur.a(this.this$0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    int i = this.jdField_a_of_type_Int;
    if ((i != -1) && (i != QQBlur.jdField_a_of_type_Int)) {
      QQBlur.a(this.this$0, this.jdField_a_of_type_Int, QQBlur.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = QQBlur.jdField_a_of_type_Int;
    i = QQBlur.jdField_a_of_type_Int;
    try
    {
      localObject = this.jdField_a_of_type_ComEnriqueStackblurStackBlurManager.process(QQBlur.a(this.this$0));
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
    QQBlur.a(this.this$0);
    localObject = this.this$0;
    QQBlur.a((QQBlur)localObject, QQBlur.b((QQBlur)localObject) + (l2 - l1));
    localObject = QQBlur.a(this.this$0);
    if ((localObject != null) && (QQBlur.b(this.this$0))) {
      ((View)localObject).postInvalidate();
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */
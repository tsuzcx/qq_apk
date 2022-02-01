package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import bian;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

public class QQBlur$1
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  
  public QQBlur$1(bian parambian, StackBlurManager paramStackBlurManager) {}
  
  public void run()
  {
    if (bian.a(this.this$0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != bian.jdField_a_of_type_Int)) {
      bian.a(this.this$0, this.jdField_a_of_type_Int, bian.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = bian.jdField_a_of_type_Int;
    int i = bian.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ComEnriqueStackblurStackBlurManager.process(bian.a(this.this$0));
    if (localObject != null) {
      bian.a(this.this$0, (Bitmap)localObject);
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      bian.a(this.this$0);
      bian.a(this.this$0, l2 - l1 + bian.b(this.this$0));
      localObject = bian.a(this.this$0);
      if ((localObject == null) || (!bian.b(this.this$0))) {
        break;
      }
      ((View)localObject).postInvalidate();
      return;
      QLog.e("QQBlur", 1, "run: outBitmap is null. OOM ?");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */
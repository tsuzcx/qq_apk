package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import bbml;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

public class QQBlur$1
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  
  public QQBlur$1(bbml parambbml, StackBlurManager paramStackBlurManager) {}
  
  public void run()
  {
    if (bbml.a(this.this$0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != bbml.jdField_a_of_type_Int)) {
      bbml.a(this.this$0, this.jdField_a_of_type_Int, bbml.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = bbml.jdField_a_of_type_Int;
    int i = bbml.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ComEnriqueStackblurStackBlurManager.process(bbml.a(this.this$0));
    if (localObject != null) {
      bbml.a(this.this$0, (Bitmap)localObject);
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      bbml.a(this.this$0);
      bbml.a(this.this$0, l2 - l1 + bbml.b(this.this$0));
      localObject = bbml.a(this.this$0);
      if ((localObject == null) || (!bbml.b(this.this$0))) {
        break;
      }
      ((View)localObject).postInvalidate();
      return;
      QLog.e("QQBlur", 1, "run: outBitmap is null. OOM ?");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */
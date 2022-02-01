package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import bhhm;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

public class QQBlur$1
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  
  public QQBlur$1(bhhm parambhhm, StackBlurManager paramStackBlurManager) {}
  
  private void a()
  {
    if (bhhm.a(this.this$0)) {}
    for (;;)
    {
      return;
      long l1 = SystemClock.elapsedRealtime();
      if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_Int != bhhm.jdField_a_of_type_Int)) {
        bhhm.a(this.this$0, this.jdField_a_of_type_Int, bhhm.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = bhhm.jdField_a_of_type_Int;
      int i = bhhm.jdField_a_of_type_Int;
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComEnriqueStackblurStackBlurManager.process(bhhm.a(this.this$0));
        if (localObject1 != null)
        {
          bhhm.a(this.this$0, (Bitmap)localObject1);
          long l2 = SystemClock.elapsedRealtime();
          bhhm.a(this.this$0);
          bhhm.a(this.this$0, l2 - l1 + bhhm.b(this.this$0));
          localObject1 = bhhm.a(this.this$0);
          if ((localObject1 == null) || (!bhhm.b(this.this$0))) {
            continue;
          }
          ((View)localObject1).postInvalidate();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2 = null;
          QLog.e("QQBlur", 1, "run: process blur OOM ?");
          continue;
          QLog.e("QQBlur", 1, "run: outBitmap is null. OOM ?");
        }
      }
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */
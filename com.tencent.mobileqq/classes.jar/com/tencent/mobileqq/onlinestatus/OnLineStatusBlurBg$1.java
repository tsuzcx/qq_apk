package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import axkr;
import axle;
import azhl;
import azhm;
import azhn;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class OnLineStatusBlurBg$1
  implements Runnable
{
  public OnLineStatusBlurBg$1(azhl paramazhl, azhm paramazhm, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Azhm.a == null) {
        return;
      }
      if (this.jdField_a_of_type_Azhm.a.isFinishing()) {
        return;
      }
      if ((azhl.a(this.this$0) == null) || (azhl.a(this.this$0).get() == null)) {
        return;
      }
      azhn localazhn = (azhn)azhl.a(this.this$0).get();
      localBitmap1 = axkr.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_a_of_type_Azhm.a);
      if (localBitmap1 == null)
      {
        QLog.e("OnLineStatusBlurBg", 1, "run: decorViewBitmap == null");
        localazhn.a(false, null, this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: ", localThrowable);
      axle.a();
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Azhm.a.app;
    if (localQQAppInterface == null)
    {
      localThrowable.a(false, null, this.b);
      return;
    }
    Bitmap localBitmap1 = Bitmap.createScaledBitmap(localBitmap1, (int)(localBitmap1.getWidth() * 0.0625F), (int)(localBitmap1.getHeight() * 0.0625F), false);
    if (localBitmap1 == null)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: scaledBitmap == null");
      localThrowable.a(false, null, this.b);
      axle.a();
      return;
    }
    Bitmap localBitmap2 = new StackBlurManager(localBitmap1).process(16);
    if (localBitmap2 == null)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: blured bitmap is null");
      localThrowable.a(false, null, this.b);
      axle.a();
      return;
    }
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.setDensity(localBitmap2.getDensity());
    localCanvas.drawColor(0);
    localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      localCanvas.drawColor(this.jdField_a_of_type_Azhm.c);
    }
    for (;;)
    {
      localCanvas.setBitmap(null);
      azhl.a(this.this$0, localBitmap1);
      azhl.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      localQQAppInterface.runOnUiThread(new OnLineStatusBlurBg.1.1(this, localThrowable));
      return;
      localCanvas.drawColor(this.jdField_a_of_type_Azhm.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1
 * JD-Core Version:    0.7.0.1
 */
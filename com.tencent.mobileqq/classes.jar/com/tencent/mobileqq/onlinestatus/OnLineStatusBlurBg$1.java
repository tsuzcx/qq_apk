package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import avxy;
import avyl;
import axut;
import axuu;
import axuv;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class OnLineStatusBlurBg$1
  implements Runnable
{
  public OnLineStatusBlurBg$1(axut paramaxut, axuu paramaxuu, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Axuu.a == null) {
        return;
      }
      if (this.jdField_a_of_type_Axuu.a.isFinishing()) {
        return;
      }
      if ((axut.a(this.this$0) == null) || (axut.a(this.this$0).get() == null)) {
        return;
      }
      axuv localaxuv = (axuv)axut.a(this.this$0).get();
      localBitmap1 = avxy.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_a_of_type_Axuu.a);
      if (localBitmap1 == null)
      {
        QLog.e("OnLineStatusBlurBg", 1, "run: decorViewBitmap == null");
        localaxuv.a(false, null, this.b);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: ", localThrowable);
      avyl.a();
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Axuu.a.app;
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
      avyl.a();
      return;
    }
    Bitmap localBitmap2 = new StackBlurManager(localBitmap1).process(16);
    if (localBitmap2 == null)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: blured bitmap is null");
      localThrowable.a(false, null, this.b);
      avyl.a();
      return;
    }
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.setDensity(localBitmap2.getDensity());
    localCanvas.drawColor(0);
    localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      localCanvas.drawColor(this.jdField_a_of_type_Axuu.c);
    }
    for (;;)
    {
      localCanvas.setBitmap(null);
      axut.a(this.this$0, localBitmap1);
      axut.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      localQQAppInterface.runOnUiThread(new OnLineStatusBlurBg.1.1(this, localThrowable));
      return;
      localCanvas.drawColor(this.jdField_a_of_type_Axuu.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1
 * JD-Core Version:    0.7.0.1
 */
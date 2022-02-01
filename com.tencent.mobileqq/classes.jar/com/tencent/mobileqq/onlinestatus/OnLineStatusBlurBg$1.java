package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multiaio.MultiAIOHelper;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class OnLineStatusBlurBg$1
  implements Runnable
{
  OnLineStatusBlurBg$1(OnLineStatusBlurBg paramOnLineStatusBlurBg, OnLineStatusBlurBg.BlurBgItem paramBlurBgItem, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.isFinishing()) {
        return;
      }
      if ((OnLineStatusBlurBg.a(this.this$0) == null) || (OnLineStatusBlurBg.a(this.this$0).get() == null)) {
        return;
      }
      OnLineStatusBlurBg.OnLineStatusBlurBgListener localOnLineStatusBlurBgListener = (OnLineStatusBlurBg.OnLineStatusBlurBgListener)OnLineStatusBlurBg.a(this.this$0).get();
      localBitmap1 = MultiAIOHelper.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a);
      if (localBitmap1 == null)
      {
        QLog.e("OnLineStatusBlurBg", 1, "run: decorViewBitmap == null");
        this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.runOnUiThread(new OnLineStatusBlurBg.1.1(this, localOnLineStatusBlurBgListener));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: ", localThrowable);
      GC.a();
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.app;
    if (localQQAppInterface == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.runOnUiThread(new OnLineStatusBlurBg.1.2(this, localThrowable));
      return;
    }
    Bitmap localBitmap1 = Bitmap.createScaledBitmap(localBitmap1, (int)(localBitmap1.getWidth() * 0.0625F), (int)(localBitmap1.getHeight() * 0.0625F), false);
    if (localBitmap1 == null)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: scaledBitmap == null");
      localQQAppInterface.runOnUiThread(new OnLineStatusBlurBg.1.3(this, localThrowable));
      GC.a();
      return;
    }
    Bitmap localBitmap2 = new StackBlurManager(localBitmap1).process(16);
    if (localBitmap2 == null)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: blured bitmap is null");
      localQQAppInterface.runOnUiThread(new OnLineStatusBlurBg.1.4(this, localThrowable));
      GC.a();
      return;
    }
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.setDensity(localBitmap2.getDensity());
    localCanvas.drawColor(0);
    localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
      localCanvas.drawColor(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.c);
    }
    for (;;)
    {
      localCanvas.setBitmap(null);
      OnLineStatusBlurBg.a(this.this$0, localBitmap1);
      OnLineStatusBlurBg.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      localQQAppInterface.runOnUiThread(new OnLineStatusBlurBg.1.5(this, localThrowable));
      return;
      localCanvas.drawColor(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1
 * JD-Core Version:    0.7.0.1
 */
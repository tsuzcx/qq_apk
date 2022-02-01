package com.tencent.mobileqq.onlinestatus;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.utils.DecorViewHelper;
import com.tencent.mobileqq.onlinestatus.utils.GC;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

class OnLineStatusBlurBg$1
  implements Runnable
{
  OnLineStatusBlurBg$1(OnLineStatusBlurBg paramOnLineStatusBlurBg, OnLineStatusBlurBg.BlurBgItem paramBlurBgItem, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.isFinishing()) {
          return;
        }
        if (OnLineStatusBlurBg.a(this.this$0) != null)
        {
          if (OnLineStatusBlurBg.a(this.this$0).get() == null) {
            return;
          }
          OnLineStatusBlurBg.OnLineStatusBlurBgListener localOnLineStatusBlurBgListener = (OnLineStatusBlurBg.OnLineStatusBlurBgListener)OnLineStatusBlurBg.a(this.this$0).get();
          Bitmap localBitmap1 = DecorViewHelper.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a);
          if (localBitmap1 == null)
          {
            QLog.e("OnLineStatusBlurBg", 1, "run: decorViewBitmap == null");
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.runOnUiThread(new OnLineStatusBlurBg.1.1(this, localOnLineStatusBlurBgListener));
            return;
          }
          AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localAppRuntime == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.a.runOnUiThread(new OnLineStatusBlurBg.1.2(this, localOnLineStatusBlurBgListener));
            return;
          }
          localBitmap1 = Bitmap.createScaledBitmap(localBitmap1, (int)(localBitmap1.getWidth() * 0.0625F), (int)(localBitmap1.getHeight() * 0.0625F), false);
          if (localBitmap1 == null)
          {
            QLog.e("OnLineStatusBlurBg", 1, "run: scaledBitmap == null");
            localAppRuntime.runOnUiThread(new OnLineStatusBlurBg.1.3(this, localOnLineStatusBlurBgListener));
            GC.a();
            return;
          }
          Bitmap localBitmap2 = new StackBlurManager(localBitmap1).process(16);
          if (localBitmap2 == null)
          {
            QLog.e("OnLineStatusBlurBg", 1, "run: blured bitmap is null");
            localAppRuntime.runOnUiThread(new OnLineStatusBlurBg.1.4(this, localOnLineStatusBlurBgListener));
            GC.a();
            return;
          }
          Canvas localCanvas = new Canvas(localBitmap1);
          localCanvas.setDensity(localBitmap2.getDensity());
          localCanvas.drawColor(0);
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
          if ((!"1103".equals(QQTheme.a())) && (!"2920".equals(QQTheme.a()))) {
            localCanvas.drawColor(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.b);
          } else {
            localCanvas.drawColor(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnLineStatusBlurBg$BlurBgItem.c);
          }
          localCanvas.setBitmap(null);
          OnLineStatusBlurBg.a(this.this$0, localBitmap1);
          OnLineStatusBlurBg.a(this.this$0, this.jdField_a_of_type_JavaLangString);
          localAppRuntime.runOnUiThread(new OnLineStatusBlurBg.1.5(this, localOnLineStatusBlurBgListener));
          return;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnLineStatusBlurBg", 1, "run: ", localThrowable);
      GC.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.1
 * JD-Core Version:    0.7.0.1
 */
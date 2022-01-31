package com.tencent.mobileqq.multiaio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import artg;
import arts;
import artt;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public final class MultiAIOStarter$2
  implements Runnable
{
  public MultiAIOStarter$2(BaseActivity paramBaseActivity, arts paramarts) {}
  
  public void run()
  {
    Bitmap localBitmap2;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        return;
      }
      Bitmap localBitmap1 = this.jdField_a_of_type_Arts.a();
      this.jdField_a_of_type_Arts.a(null);
      localBitmap2 = artg.a(localBitmap1, this.jdField_a_of_type_Arts.b(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      if (localBitmap2 == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: decorViewBitmap == null");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MultiAIOStarter", 1, "run: ", localThrowable);
      artt.a();
      return;
    }
    this.jdField_a_of_type_Arts.b(localBitmap2);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
    if (localQQAppInterface != null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("KEY_AIO_BITMAP", localBitmap2);
      localQQAppInterface.notifyObservers(MultiAIOFragment.class, 0, true, (Bundle)localObject);
      localBitmap2 = Bitmap.createScaledBitmap(localBitmap2, (int)(localBitmap2.getWidth() * 0.0625F), (int)(localBitmap2.getHeight() * 0.0625F), false);
      if (localBitmap2 == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: scaledBitmap == null");
        artt.a();
        return;
      }
      localObject = new StackBlurManager(localBitmap2).process(4);
      if (localObject == null)
      {
        QLog.e("MultiAIOStarter", 1, "run: blured bitmap is null");
        artt.a();
        return;
      }
      Canvas localCanvas = new Canvas(localBitmap2);
      localCanvas.drawColor(0);
      localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
      }
      for (;;)
      {
        localCanvas.setBitmap(null);
        this.jdField_a_of_type_Arts.c(localBitmap2);
        localObject = new Bundle();
        ((Bundle)localObject).putParcelable("KEY_AIO_BITMAP_BLURED", localBitmap2);
        localQQAppInterface.notifyObservers(MultiAIOFragment.class, 1, true, (Bundle)localObject);
        return;
        localCanvas.drawColor(Color.parseColor("#7F03081A"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter.2
 * JD-Core Version:    0.7.0.1
 */
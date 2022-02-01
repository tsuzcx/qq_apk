package com.tencent.mobileqq.multiaio;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.multiaio.utils.GC;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

final class MultiAIOStarter$2
  implements Runnable
{
  MultiAIOStarter$2(BaseActivity paramBaseActivity, MultiAioContext paramMultiAioContext) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        if (this.a.isFinishing()) {
          return;
        }
        Object localObject1 = this.b.d();
        this.b.a(null);
        Bitmap localBitmap = MultiAIOHelper.a((Bitmap)localObject1, this.b.e(), this.a);
        if (localBitmap == null)
        {
          QLog.e("MultiAIOStarter", 1, "run: decorViewBitmap == null");
          return;
        }
        this.b.b(localBitmap);
        localObject1 = this.a.app;
        if (localObject1 == null) {
          return;
        }
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("KEY_AIO_BITMAP", localBitmap);
        ((QQAppInterface)localObject1).notifyObservers(MultiAIOFragment.class, 0, true, (Bundle)localObject2);
        localBitmap = Bitmap.createScaledBitmap(localBitmap, (int)(localBitmap.getWidth() * 0.0625F), (int)(localBitmap.getHeight() * 0.0625F), false);
        if (localBitmap == null)
        {
          QLog.e("MultiAIOStarter", 1, "run: scaledBitmap == null");
          GC.a();
          return;
        }
        localObject2 = new StackBlurManager(localBitmap).process(4);
        if (localObject2 == null)
        {
          QLog.e("MultiAIOStarter", 1, "run: blured bitmap is null");
          GC.a();
          return;
        }
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.setDensity(((Bitmap)localObject2).getDensity());
        localCanvas.drawColor(0);
        localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
        if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
          localCanvas.drawColor(Color.parseColor("#7F03081A"));
        } else {
          localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
        }
        localCanvas.setBitmap(null);
        this.b.c(localBitmap);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("KEY_AIO_BITMAP_BLURED", localBitmap);
        ((QQAppInterface)localObject1).notifyObservers(MultiAIOFragment.class, 1, true, (Bundle)localObject2);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MultiAIOStarter", 1, "run: ", localThrowable);
      GC.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOStarter.2
 * JD-Core Version:    0.7.0.1
 */
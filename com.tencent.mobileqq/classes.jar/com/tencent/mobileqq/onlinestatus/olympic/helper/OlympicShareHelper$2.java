package com.tencent.mobileqq.onlinestatus.olympic.helper;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

final class OlympicShareHelper$2
  implements URLDrawable.URLDrawableListener
{
  OlympicShareHelper$2(CountDownLatch paramCountDownLatch) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.countDown();
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("getBackgroundBitmap onLoadSuccess and count: ");
      paramURLDrawable.append(this.a.getCount());
      QLog.i("OlympicShareHelper", 2, paramURLDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareHelper.2
 * JD-Core Version:    0.7.0.1
 */
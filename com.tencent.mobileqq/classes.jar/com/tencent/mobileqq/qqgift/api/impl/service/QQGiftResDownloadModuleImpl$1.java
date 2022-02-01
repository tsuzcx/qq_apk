package com.tencent.mobileqq.qqgift.api.impl.service;

import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class QQGiftResDownloadModuleImpl$1
  implements Runnable
{
  QQGiftResDownloadModuleImpl$1(QQGiftResDownloadModuleImpl paramQQGiftResDownloadModuleImpl, int[] paramArrayOfInt, boolean paramBoolean, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback) {}
  
  public void run()
  {
    Object localObject = new CountDownLatch(this.a.length);
    int i = 0;
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    int[] arrayOfInt = this.a;
    int j = arrayOfInt.length;
    while (i < j)
    {
      int k = arrayOfInt[i];
      QQGiftResUpdateManager.a().a(k, this.b, new QQGiftResDownloadModuleImpl.1.1(this, (CountDownLatch)localObject, localAtomicInteger));
      i += 1;
    }
    try
    {
      ((CountDownLatch)localObject).await(5L, TimeUnit.MINUTES);
    }
    catch (InterruptedException localInterruptedException)
    {
      label91:
      break label91;
    }
    QLog.e("QQGiftResDownloadModuleImpl", 1, "[downloadAnimationResources] ");
    localObject = this.c;
    if (localObject != null) {
      ((IQQGiftResourceDownloadCallback)localObject).a(this.a.length, localAtomicInteger.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftResDownloadModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */
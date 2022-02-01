package com.tencent.mobileqq.qqgift.api.impl.service;

import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class QQGiftResDownloadModuleImpl$2$1
  implements IQQGiftPanelResDownloadCallback
{
  QQGiftResDownloadModuleImpl$2$1(QQGiftResDownloadModuleImpl.2 param2, CountDownLatch paramCountDownLatch, AtomicInteger paramAtomicInteger) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.c.b != null)
    {
      IQQGiftResourceDownloadCallback localIQQGiftResourceDownloadCallback = this.c.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errCode:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", httpCode:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", errMsg:");
      localStringBuilder.append(paramString);
      localIQQGiftResourceDownloadCallback.a(false, paramInt1, localStringBuilder.toString());
    }
    this.a.countDown();
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, QQGiftPanelResource paramQQGiftPanelResource)
  {
    if (this.c.b != null) {
      this.c.b.a(true, paramInt, paramQQGiftPanelResource.toString());
    }
    this.a.countDown();
    this.b.incrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftResDownloadModuleImpl.2.1
 * JD-Core Version:    0.7.0.1
 */
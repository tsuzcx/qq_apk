package com.tencent.mobileqq.qqgift.api.impl.service;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager;

public class QQGiftResDownloadModuleImpl
  implements IQQGiftResDownloadModule
{
  private void a(int[] paramArrayOfInt, boolean paramBoolean, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback)
  {
    ThreadManager.excute(new QQGiftResDownloadModuleImpl.1(this, paramArrayOfInt, paramBoolean, paramIQQGiftResourceDownloadCallback), 128, null, false);
  }
  
  public void a() {}
  
  public void a(int paramInt, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback)
  {
    QQGiftResUpdateManager.a().a(paramInt, false, paramIQQGiftAnimationResDownloadCallback);
  }
  
  public void a(int paramInt, IQQGiftPanelResDownloadCallback paramIQQGiftPanelResDownloadCallback)
  {
    QQGiftResUpdateManager.a().a(paramInt, paramIQQGiftPanelResDownloadCallback);
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK) {}
  
  public void a(int[] paramArrayOfInt, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback)
  {
    a(paramArrayOfInt, true, paramIQQGiftResourceDownloadCallback);
  }
  
  public void b() {}
  
  public void b(int paramInt, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback)
  {
    QQGiftResUpdateManager.a().a(paramInt, true, paramIQQGiftAnimationResDownloadCallback);
  }
  
  public void b(int[] paramArrayOfInt, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback)
  {
    ThreadManager.excute(new QQGiftResDownloadModuleImpl.2(this, paramArrayOfInt, paramIQQGiftResourceDownloadCallback), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftResDownloadModuleImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqgift.api.service;

import com.tencent.mobileqq.qqgift.api.IQQGiftModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;

public abstract interface IQQGiftResDownloadModule
  extends IQQGiftModule
{
  @Deprecated
  public abstract void a(int paramInt, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback);
  
  public abstract void a(int paramInt, IQQGiftPanelResDownloadCallback paramIQQGiftPanelResDownloadCallback);
  
  public abstract void a(int[] paramArrayOfInt, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback);
  
  public abstract void b(int paramInt, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback);
  
  public abstract void b(int[] paramArrayOfInt, IQQGiftResourceDownloadCallback paramIQQGiftResourceDownloadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule
 * JD-Core Version:    0.7.0.1
 */
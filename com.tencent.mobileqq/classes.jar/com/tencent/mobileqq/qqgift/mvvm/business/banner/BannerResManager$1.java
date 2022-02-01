package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class BannerResManager$1
  implements IQQGiftAnimationResDownloadCallback
{
  BannerResManager$1(BannerResManager paramBannerResManager) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BannerResManager.a(this.a, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load banner res failed ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(paramString);
    QLog.e("BannerResManager", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    BannerResManager.a(this.a, 2);
    QLog.i("BannerResManager", 1, "load banner res success");
    BannerResManager.a(this.a, paramString, 1);
    BannerResManager.a(this.a, paramString, 3);
    BannerResManager.a(this.a, paramString, 4);
    BannerResManager.a(this.a, paramString);
    QLog.i("BannerResManager", 1, "load banner bitmap res complete");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager.1
 * JD-Core Version:    0.7.0.1
 */
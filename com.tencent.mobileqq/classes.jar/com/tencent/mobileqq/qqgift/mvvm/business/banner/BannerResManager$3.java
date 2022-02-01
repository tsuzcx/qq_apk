package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class BannerResManager$3
  implements IQQGiftAnimationResDownloadCallback
{
  BannerResManager$3(BannerResManager paramBannerResManager, int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("load failed:");
    paramString.append(this.a);
    QLog.e("BannerResManager", 1, paramString.toString());
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("load success::");
    paramString.append(this.a);
    QLog.i("BannerResManager", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager.3
 * JD-Core Version:    0.7.0.1
 */
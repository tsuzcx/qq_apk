package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import com.tencent.qphone.base.util.QLog;

class BaseBannerView$1
  implements Runnable
{
  BaseBannerView$1(BaseBannerView paramBaseBannerView) {}
  
  public void run()
  {
    if (this.this$0.j)
    {
      QLog.e("Gift_Banner_BBanner", 1, "delayEndRunnable run but isPlaying");
      return;
    }
    if (this.this$0.g != null)
    {
      this.this$0.a.a();
      this.this$0.g.b(this.this$0.f, this.this$0.a.getNum());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BaseBannerView.1
 * JD-Core Version:    0.7.0.1
 */
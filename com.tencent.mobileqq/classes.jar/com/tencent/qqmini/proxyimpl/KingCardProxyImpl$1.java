package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;

class KingCardProxyImpl$1
  implements Runnable
{
  KingCardProxyImpl$1(KingCardProxyImpl paramKingCardProxyImpl, Activity paramActivity, DiniFlyAnimationView paramDiniFlyAnimationView, IMiniAppContext paramIMiniAppContext) {}
  
  public void run()
  {
    if (!KingCardProxyImpl.a(this.this$0))
    {
      QzoneGuideBubbleHelper.getInstance().showGuideBubble(this.a, this.b, KingCardProxyImpl.b(this.this$0), 1, 14.0F, 5.0D, 10.0D, 3000L, -16578534, false, true, 0, null, 0);
      KingCardProxyImpl.c(this.this$0);
    }
    else
    {
      QLog.i("KingCardProxyImpl", 1, "showKingCardTips, guide had been showed, not show this time");
    }
    this.b.addAnimatorListener(new KingCardProxyImpl.1.1(this));
    if (this.c.isMiniGame())
    {
      localDIYLottieLoader = KingCardProxyImpl.d(this.this$0);
      localDiniFlyAnimationView = this.b;
      str = MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_MINIAPP_WANGKA_PATH);
      localStringBuilder.append(MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE.hashCode());
      localStringBuilder.append(".zip");
      localDIYLottieLoader.fromNetworkWithCacheBitmap(localDiniFlyAnimationView, str, localStringBuilder.toString(), true);
      return;
    }
    DIYLottieLoader localDIYLottieLoader = KingCardProxyImpl.d(this.this$0);
    DiniFlyAnimationView localDiniFlyAnimationView = this.b;
    String str = MiniAppGlobal.KINGCARD_GUIDE_LOTTIE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_MINIAPP_WANGKA_PATH);
    localStringBuilder.append(MiniAppGlobal.KINGCARD_GUIDE_LOTTIE.hashCode());
    localStringBuilder.append(".zip");
    localDIYLottieLoader.fromNetworkWithCacheBitmap(localDiniFlyAnimationView, str, localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
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
      QzoneGuideBubbleHelper.getInstance().showGuideBubble(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, KingCardProxyImpl.a(this.this$0), 1, 14.0F, 5.0D, 10.0D, 3000L, -16578534, false, true, 0, null, 0);
      KingCardProxyImpl.a(this.this$0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new KingCardProxyImpl.1.1(this));
      if (!this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.isMiniGame()) {
        break;
      }
      KingCardProxyImpl.a(this.this$0).fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE, AppConstants.SDCARD_MINIAPP_WANGKA_PATH + MiniAppGlobal.KINGCARD_GUIDE_DARK_LOTTIE.hashCode() + ".zip", true);
      return;
      QLog.i("KingCardProxyImpl", 1, "showKingCardTips, guide had been showed, not show this time");
    }
    KingCardProxyImpl.a(this.this$0).fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, MiniAppGlobal.KINGCARD_GUIDE_LOTTIE, AppConstants.SDCARD_MINIAPP_WANGKA_PATH + MiniAppGlobal.KINGCARD_GUIDE_LOTTIE.hashCode() + ".zip", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */
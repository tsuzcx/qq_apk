package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import java.lang.ref.WeakReference;

class AdProxyImpl$SDKBannerAdView$1
  implements GdtAdListener
{
  AdProxyImpl$SDKBannerAdView$1(AdProxyImpl.SDKBannerAdView paramSDKBannerAdView, Activity paramActivity) {}
  
  public void a(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdLoaded");
  }
  
  public void a(GdtAd paramGdtAd, GdtAdError paramGdtAdError)
  {
    int i;
    if (paramGdtAdError != null)
    {
      i = paramGdtAdError.a();
      if (paramGdtAdError == null) {
        break label58;
      }
    }
    label58:
    for (paramGdtAd = paramGdtAdError.a();; paramGdtAd = "")
    {
      QLog.i("AdProxyImpl", 1, "bannerad onAdFailedToLoad code=" + i + ", msg=" + paramGdtAd);
      return;
      i = -1;
      break;
    }
  }
  
  public void b(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdImpression");
  }
  
  public void c(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClicked");
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null) && (AdUtils.isHitReport50ViewAndOneSecond(paramGdtAd.getAd()))) {
      AdExposureChecker.onClick(this.jdField_a_of_type_AndroidAppActivity, paramGdtAd.getAd(), new WeakReference(this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
        this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADClicked();
      }
      return;
      QLog.i("AdProxyImpl", 1, "ad null");
    }
  }
  
  public void d(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClosed");
    if (this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplAdProxyImpl$SDKBannerAdView.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADClosed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.1
 * JD-Core Version:    0.7.0.1
 */
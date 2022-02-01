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
    if (paramGdtAdError != null) {
      i = paramGdtAdError.a();
    } else {
      i = -1;
    }
    if (paramGdtAdError != null) {
      paramGdtAd = paramGdtAdError.b();
    } else {
      paramGdtAd = "";
    }
    paramGdtAdError = new StringBuilder();
    paramGdtAdError.append("bannerad onAdFailedToLoad code=");
    paramGdtAdError.append(i);
    paramGdtAdError.append(", msg=");
    paramGdtAdError.append(paramGdtAd);
    QLog.i("AdProxyImpl", 1, paramGdtAdError.toString());
  }
  
  public void b(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdImpression");
  }
  
  public void c(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClicked");
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null) && (AdUtils.isHitReport50ViewAndOneSecond(paramGdtAd.getAd()))) {
      AdExposureChecker.onClick(this.a, paramGdtAd.getAd(), new WeakReference(this.b.y));
    } else {
      QLog.i("AdProxyImpl", 1, "ad null");
    }
    if (this.b.b != null) {
      this.b.b.onADClicked();
    }
  }
  
  public void d(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClosed");
    if (this.b.b != null) {
      this.b.b.onADClosed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.1
 * JD-Core Version:    0.7.0.1
 */
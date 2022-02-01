package com.tencent.qqmini.proxyimpl;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

class AdProxyImpl$SDKBannerAdView$3
  implements AdExposureChecker.ExposureCallback
{
  AdProxyImpl$SDKBannerAdView$3(AdProxyImpl.SDKBannerAdView paramSDKBannerAdView) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onExposure");
    if ((this.a.f != null) && (this.a.f.report_info != null) && (this.a.f.report_info.exposure_url != null))
    {
      paramWeakReference = this.a;
      AdProxyImpl.SDKBannerAdView.a(paramWeakReference, paramWeakReference.f.report_info.exposure_url.get());
    }
    MiniAdAntiSpamReportUtil.a(this.a.v, this.a.t, System.currentTimeMillis(), this.a.i, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.3
 * JD-Core Version:    0.7.0.1
 */
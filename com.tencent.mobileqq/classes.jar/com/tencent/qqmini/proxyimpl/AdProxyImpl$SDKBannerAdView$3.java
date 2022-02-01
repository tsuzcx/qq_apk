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
    if ((this.a.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo != null) && (this.a.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info != null) && (this.a.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.exposure_url != null)) {
      AdProxyImpl.SDKBannerAdView.a(this.a, this.a.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.exposure_url.get());
    }
    MiniAdAntiSpamReportUtil.a(this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext, this.a.i, System.currentTimeMillis(), this.a.b, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.3
 * JD-Core Version:    0.7.0.1
 */
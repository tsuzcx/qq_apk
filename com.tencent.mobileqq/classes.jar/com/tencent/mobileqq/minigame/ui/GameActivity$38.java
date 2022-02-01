package com.tencent.mobileqq.minigame.ui;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

class GameActivity$38
  implements AdExposureChecker.ExposureCallback
{
  GameActivity$38(GameActivity paramGameActivity) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QLog.i("[minigame] GameActivity", 1, "bannerad onExposure");
    if ((this.this$0.mBannerAdOpInfo != null) && (this.this$0.mBannerAdOpInfo.report_info != null) && (this.this$0.mBannerAdOpInfo.report_info.exposure_url != null)) {
      GameActivity.access$5400(this.this$0, this.this$0.mBannerAdOpInfo.report_info.exposure_url.get(), System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.38
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class AdVideoViewController$1$1
  implements AdExposureChecker.ExposureCallback
{
  AdVideoViewController$1$1(AdVideoViewController.1 param1) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.i("AdExposureChecker", "onExposure");
    if (!TextUtils.isEmpty(AdVideoViewController.a(this.a.a).qqbexposureInfor)) {
      this.a.a.a(AdVideoViewController.a(this.a.a).qqbexposureInfor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.1.1
 * JD-Core Version:    0.7.0.1
 */
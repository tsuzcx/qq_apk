package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class AdVideoViewController$2
  implements AdExposureChecker.ExposureCallback
{
  AdVideoViewController$2(AdVideoViewController paramAdVideoViewController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.i("AdExposureChecker", "onExposure");
    if (!TextUtils.isEmpty(AdVideoViewController.a(this.a).qqbexposureInfor))
    {
      paramWeakReference = this.a;
      paramWeakReference.a(AdVideoViewController.a(paramWeakReference).qqbexposureInfor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class AlbumRecommendAdvController$1$1
  implements AdExposureChecker.ExposureCallback
{
  AlbumRecommendAdvController$1$1(AlbumRecommendAdvController.1 param1) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.i("AdExposureChecker", "onExposure");
    this.a.a.a(AlbumRecommendAdvController.a(this.a.a).qqbexposureInfor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.1.1
 * JD-Core Version:    0.7.0.1
 */
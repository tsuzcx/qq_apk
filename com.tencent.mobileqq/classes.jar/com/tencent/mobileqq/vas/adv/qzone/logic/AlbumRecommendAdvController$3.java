package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;

class AlbumRecommendAdvController$3
  implements AdExposureChecker.ExposureCallback
{
  AlbumRecommendAdvController$3(AlbumRecommendAdvController paramAlbumRecommendAdvController, AlumBasicData paramAlumBasicData) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QZLog.i("AdExposureChecker", "onExposure");
    this.jdField_a_of_type_ComTencentMobileqqVasAdvQzoneLogicAlbumRecommendAdvController.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvCommonDataAlumBasicData.qqbexposureInfor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AlbumRecommendAdvController.3
 * JD-Core Version:    0.7.0.1
 */
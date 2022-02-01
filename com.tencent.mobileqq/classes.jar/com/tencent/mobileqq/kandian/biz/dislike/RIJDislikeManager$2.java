package com.tencent.mobileqq.kandian.biz.dislike;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindowForAd.OnComplainListener;

class RIJDislikeManager$2
  implements KandianNegativeWindowForAd.OnComplainListener
{
  RIJDislikeManager$2(RIJDislikeManager paramRIJDislikeManager, RIJDataManager paramRIJDataManager, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJDislikeManager", 2, "onAdComplain");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 1);
      localIntent.putExtra("key_ad_info", (AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult((Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.2
 * JD-Core Version:    0.7.0.1
 */
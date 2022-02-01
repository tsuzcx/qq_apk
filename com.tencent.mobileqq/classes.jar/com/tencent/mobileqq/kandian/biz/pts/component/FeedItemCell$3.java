package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.KandianNegativeWindowForAd.OnComplainListener;

class FeedItemCell$3
  implements KandianNegativeWindowForAd.OnComplainListener
{
  FeedItemCell$3(FeedItemCell paramFeedItemCell) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "onAdComplain");
    }
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_from_type", 1);
      localIntent.putExtra("key_ad_info", ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a());
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchReadInJoyUninterestComplainFragmentForResult((Activity)this.a.jdField_a_of_type_AndroidContentContext, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.3
 * JD-Core Version:    0.7.0.1
 */
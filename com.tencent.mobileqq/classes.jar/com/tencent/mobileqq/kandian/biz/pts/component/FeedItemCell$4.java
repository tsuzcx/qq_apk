package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.widget.KandianNegativeWindowForAd;

class FeedItemCell$4
  implements PopupWindow.OnDismissListener
{
  FeedItemCell$4(FeedItemCell paramFeedItemCell, KandianNegativeWindowForAd paramKandianNegativeWindowForAd) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindowForAd.a(1.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell.a.c())
    {
      VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell.a.a();
      if (localVideoPlayManager != null)
      {
        localVideoPlayManager.c();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell.a.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.KandianNegativeWindowForAd;

class FeedItemCell$5
  implements PopupWindow.OnDismissListener
{
  FeedItemCell$5(FeedItemCell paramFeedItemCell, KandianNegativeWindowForAd paramKandianNegativeWindowForAd) {}
  
  public void onDismiss()
  {
    ((IRIJSurpriseVideoService)QRoute.api(IRIJSurpriseVideoService.class)).handleDislikeWindowDissMiss();
    this.a.a(1.0F);
    if (this.b.g.A())
    {
      VideoPlayManager localVideoPlayManager = this.b.g.R();
      if (localVideoPlayManager != null)
      {
        localVideoPlayManager.v();
        this.b.g.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.5
 * JD-Core Version:    0.7.0.1
 */
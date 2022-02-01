package com.tencent.mobileqq.kandian.biz.video;

import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.qroute.QRoute;

class VideoUIManager$5
  implements OnPatchPlayListener
{
  VideoUIManager$5(VideoUIManager paramVideoUIManager) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.h(this.a).a(2);
    VideoUIManager.i(this.a).a = paramAdvertisementInfo;
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this.a);
    VideoUIManager.j(this.a).setVisibility(0);
    VideoUIManager.k(this.a).setVisibility(0);
    VideoUIManager.i(this.a).setVisibility(0);
    VideoUIManager.i(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 1);
  }
  
  public void b(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.i(this.a).a = paramAdvertisementInfo;
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this.a);
    VideoUIManager.j(this.a).setVisibility(0);
    VideoUIManager.i(this.a).setVisibility(0);
    VideoUIManager.i(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.5
 * JD-Core Version:    0.7.0.1
 */
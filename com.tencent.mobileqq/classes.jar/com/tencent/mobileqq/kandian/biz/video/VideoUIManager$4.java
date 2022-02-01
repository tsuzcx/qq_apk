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

class VideoUIManager$4
  implements OnPatchPlayListener
{
  VideoUIManager$4(VideoUIManager paramVideoUIManager) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.a(this.a).a(2);
    VideoUIManager.a(this.a).a = paramAdvertisementInfo;
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this.a);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 1);
  }
  
  public void b(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo)
  {
    VideoUIManager.a(this.a).a = paramAdvertisementInfo;
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this.a);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).setVisibility(0);
    VideoUIManager.a(this.a).a(paramVideoPlayParam, paramAdvertisementInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.4
 * JD-Core Version:    0.7.0.1
 */
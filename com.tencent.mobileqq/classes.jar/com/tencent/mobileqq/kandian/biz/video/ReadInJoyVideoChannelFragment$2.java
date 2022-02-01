package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.OnHomePressedListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;

class ReadInJoyVideoChannelFragment$2
  implements OnHomePressedListener
{
  ReadInJoyVideoChannelFragment$2(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void a()
  {
    VideoPlayManager localVideoPlayManager = this.a.a();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
    {
      if (localVideoPlayManager.a().a()) {
        localVideoPlayManager.a().j();
      }
      localVideoPlayManager.a().d();
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment.2
 * JD-Core Version:    0.7.0.1
 */
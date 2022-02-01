package com.tencent.mobileqq.flashshow.preload;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.player.FSExchangeHelper.VideoUrlAdapterCallBack;
import com.tencent.mobileqq.flashshow.player.FSVideoUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StVideo;

class FSVideoPreloadHelper$1
  implements FSExchangeHelper.VideoUrlAdapterCallBack
{
  FSVideoPreloadHelper$1(FSVideoPreloadHelper paramFSVideoPreloadHelper, FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    if (!VSNetworkHelper.isTimeOutRetCode((int)paramLong)) {
      this.c.a(this.a.fileId.get(), FSVideoUtils.a(this.a), this.a.duration.get(), this.b);
    }
  }
  
  public void a(FeedCloudMeta.StVideo paramStVideo, boolean paramBoolean)
  {
    this.c.a(paramStVideo.fileId.get(), FSVideoUtils.a(this.a), paramStVideo.duration.get(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.FSVideoPreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */
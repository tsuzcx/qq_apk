package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoFeedsDiversionHandler$handleDiversionPriority$3
  extends Lambda
  implements Function0<Unit>
{
  VideoFeedsDiversionHandler$handleDiversionPriority$3(Ref.ObjectRef paramObjectRef, VideoInfo paramVideoInfo)
  {
    super(0);
  }
  
  public final void invoke()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)this.$advertisementInfo.element;
    Object localObject = (AdvertisementInfo)this.$advertisementInfo.element;
    if (localObject != null) {
      localObject = ((AdvertisementInfo)localObject).gameAdComData;
    } else {
      localObject = null;
    }
    VideoFeedsDiversionHandler.a(VideoFeedsDiversionHandler.a, this.$videoInfo);
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.gameAdComData = ((GameAdComData)localObject);
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).setAdvertisementInfo(this.$videoInfo, localAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsDiversionHandler.handleDiversionPriority.3
 * JD-Core Version:    0.7.0.1
 */
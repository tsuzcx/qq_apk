package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.WeishiRedDotInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class VideoPlayRecommendHandler$2
  implements Runnable
{
  VideoPlayRecommendHandler$2(VideoPlayRecommendHandler paramVideoPlayRecommendHandler, ArrayList paramArrayList1, VideoPlayRecommendObserver paramVideoPlayRecommendObserver, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList paramArrayList2, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, ArrayList paramArrayList3, int paramInt7) {}
  
  public void run()
  {
    ArrayList localArrayList = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).convertAdTagInfos(this.a);
    VideoPlayRecommendHandler.a(this.this$0, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, localArrayList, this.q, this.r, this.s, 0, this.t, null, this.u);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendHandler.2
 * JD-Core Version:    0.7.0.1
 */
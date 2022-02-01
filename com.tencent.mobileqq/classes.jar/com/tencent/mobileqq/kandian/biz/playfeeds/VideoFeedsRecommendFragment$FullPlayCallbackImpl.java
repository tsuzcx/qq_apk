package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlay;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.RecommendDataAdapter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoFeedsRecommendFragment$FullPlayCallbackImpl
  implements IVideoPlay, VideoFullPlayController.OnFullPlayListener, VideoFullPlayController.RecommendDataAdapter
{
  private VideoFeedsRecommendFragment$FullPlayCallbackImpl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public VideoFeedsRecommendFragment.FullPlayParams a(VideoInfo paramVideoInfo)
  {
    VideoFeedsRecommendFragment.FullPlayParams localFullPlayParams = new VideoFeedsRecommendFragment.FullPlayParams(null);
    VideoFeedsRecommendFragment.FullPlayParams.a(localFullPlayParams, paramVideoInfo);
    localFullPlayParams.f = 409409L;
    localFullPlayParams.e = 0;
    localFullPlayParams.a = paramVideoInfo.g;
    localFullPlayParams.b = paramVideoInfo.f;
    localFullPlayParams.d = paramVideoInfo.b;
    localFullPlayParams.c = paramVideoInfo.n;
    return localFullPlayParams;
  }
  
  public List<BaseVideoPlayParam> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.g(this.a).aA.k(false);
    VideoFeedsRecommendFragment.g(this.a).aB.a(6);
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    VideoItemHolder localVideoItemHolder = VideoFeedsRecommendFragment.g(this.a);
    if (((paramBaseVideoPlayParam instanceof VideoFeedsRecommendFragment.FullPlayParams)) && (localVideoItemHolder != null))
    {
      paramBaseVideoPlayParam = VideoFeedsRecommendFragment.FullPlayParams.a((VideoFeedsRecommendFragment.FullPlayParams)paramBaseVideoPlayParam);
      if (paramBaseVideoPlayParam == localVideoItemHolder.az.c)
      {
        localVideoItemHolder.az.j = 0L;
        VideoFeedsRecommendFragment.O(this.a).a(localVideoItemHolder.az, false);
      }
      else
      {
        int i = localVideoItemHolder.Z;
        VideoFeedsRecommendFragment.e(this.a).remove(i);
        VideoFeedsRecommendFragment.e(this.a).add(i, paramBaseVideoPlayParam);
        VideoFeedsRecommendFragment.d(this.a).notifyItemChanged(i);
      }
      VideoFeedsRecommendFragment.V(this.a).j();
    }
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam1, BaseVideoPlayParam paramBaseVideoPlayParam2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = VideoFeedsRecommendFragment.FullPlayParams.a((VideoFeedsRecommendFragment.FullPlayParams)VideoFeedsRecommendFragment.z(this.a).b());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.g(this.a).az.c;
    if (VideoFeedsRecommendFragment.g(this.a).az.c != localObject)
    {
      VideoFeedsRecommendFragment.e(this.a).add(VideoFeedsRecommendFragment.g(this.a).Z, localObject);
      VideoFeedsRecommendFragment.d(this.a).notifyItemInserted(VideoFeedsRecommendFragment.g(this.a).Z);
      localObject = VideoFeedsRecommendFragment.g(this.a);
      ((VideoItemHolder)localObject).Y += 1;
      localObject = VideoFeedsRecommendFragment.g(this.a);
      ((VideoItemHolder)localObject).Z += 1;
      VideoFeedsRecommendFragment.t(this.a).b(VideoFeedsRecommendFragment.g(this.a).Z);
      VideoFeedsRecommendFragment.c(this.a).scrollToPosition(VideoFeedsRecommendFragment.g(this.a).Z);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.O(this.a).a(VideoFeedsRecommendFragment.g(this.a).az, false);
    }
    PublicAccountReportUtils.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new VideoR5.Builder(null, null, localVideoInfo.b, localVideoInfo.l).a(409409).b().a(), false);
  }
  
  public void cV_()
  {
    VideoFeedsRecommendFragment.c(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.FullPlayCallbackImpl
 * JD-Core Version:    0.7.0.1
 */
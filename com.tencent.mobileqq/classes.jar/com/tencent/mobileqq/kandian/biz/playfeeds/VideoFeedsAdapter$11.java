package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.video.DefaultVideoPreDownloadController;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.VideoPreDownloadParam;
import java.util.ArrayList;
import java.util.List;

class VideoFeedsAdapter$11
  extends DefaultVideoPreDownloadController<VideoInfo>
{
  VideoFeedsAdapter$11(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  protected VideoPreDownloadMgr.VideoPreDownloadParam a(VideoInfo paramVideoInfo)
  {
    return new VideoPreDownloadMgr.VideoPreDownloadParam(paramVideoInfo.b, paramVideoInfo.l, paramVideoInfo.a, paramVideoInfo.e);
  }
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = VideoFeedsAdapter.p(this.a);
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - 1, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected VideoPlayerWrapper b()
  {
    if ((this.a.h != null) && (this.a.h.az != null)) {
      return (VideoPlayerWrapper)this.a.h.az.h;
    }
    return null;
  }
  
  protected String c()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> d()
  {
    return VideoFeedsAdapter.p(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.11
 * JD-Core Version:    0.7.0.1
 */
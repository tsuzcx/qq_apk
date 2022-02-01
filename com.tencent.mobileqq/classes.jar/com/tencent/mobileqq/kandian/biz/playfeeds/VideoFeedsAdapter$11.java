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
  
  protected VideoPlayerWrapper a()
  {
    if ((this.a.a != null) && (this.a.a.a != null)) {
      return (VideoPlayerWrapper)this.a.a.a.a;
    }
    return null;
  }
  
  protected VideoPreDownloadMgr.VideoPreDownloadParam a(VideoInfo paramVideoInfo)
  {
    return new VideoPreDownloadMgr.VideoPreDownloadParam(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return VideoFeedsAdapter.a(this.a);
  }
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = VideoFeedsAdapter.a(this.a);
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - 1, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.11
 * JD-Core Version:    0.7.0.1
 */
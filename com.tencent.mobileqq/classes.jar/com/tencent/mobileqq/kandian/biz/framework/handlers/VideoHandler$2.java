package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.VideoStatusListener;

class VideoHandler$2
  implements VideoPlayManager.VideoStatusListener
{
  VideoHandler$2(VideoHandler paramVideoHandler) {}
  
  public void a(VideoPlayParam paramVideoPlayParam) {}
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if ((this.a.a() != 0) && (this.a.a() != 56) && (!VideoAutoPlayController.sPauseScrollToNextVideo)) {
      this.a.a().a(paramVideoPlayParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.2
 * JD-Core Version:    0.7.0.1
 */
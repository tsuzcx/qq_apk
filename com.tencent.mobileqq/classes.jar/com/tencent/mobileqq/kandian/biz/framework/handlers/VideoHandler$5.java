package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ListView;

class VideoHandler$5
  implements Runnable
{
  VideoHandler$5(VideoHandler paramVideoHandler, VideoPlayParam paramVideoPlayParam) {}
  
  public void run()
  {
    if (!VideoHandler.a(this.this$0)) {
      return;
    }
    if ((this.this$0.a != null) && (this.this$0.a.a() != null))
    {
      VideoPlayParam localVideoPlayParam = this.a;
      if (localVideoPlayParam == null) {
        return;
      }
      localVideoPlayParam.d = 0L;
      if ((VideoHandler.a(this.this$0) != null) && (VideoHandler.a(this.this$0).canAutoPlayVideo()))
      {
        int i = this.a.a;
        int j = VideoHandler.a(this.this$0).getHeaderViewsCount();
        VideoHandler.a(this.this$0).post(new VideoHandler.5.1(this, i + j));
        if (ReadInJoyHelper.a(ReadInJoyUtils.a())) {
          QQToast.a(VideoHandler.a(this.this$0).getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.5
 * JD-Core Version:    0.7.0.1
 */
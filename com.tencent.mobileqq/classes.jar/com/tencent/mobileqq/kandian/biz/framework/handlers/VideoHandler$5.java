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
    if (!VideoHandler.d(this.this$0)) {
      return;
    }
    if ((this.this$0.f != null) && (this.this$0.f.a() != null))
    {
      VideoPlayParam localVideoPlayParam = this.a;
      if (localVideoPlayParam == null) {
        return;
      }
      localVideoPlayParam.k = 0L;
      if ((VideoHandler.b(this.this$0) != null) && (VideoHandler.e(this.this$0).canAutoPlayVideo()))
      {
        int i = this.a.e;
        int j = VideoHandler.b(this.this$0).getHeaderViewsCount();
        VideoHandler.b(this.this$0).post(new VideoHandler.5.1(this, i + j));
        if (ReadInJoyHelper.a(ReadInJoyUtils.b())) {
          QQToast.makeText(VideoHandler.c(this.this$0).getApplicationContext(), "为你开启wifi下连续播放功能", 1).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.5
 * JD-Core Version:    0.7.0.1
 */
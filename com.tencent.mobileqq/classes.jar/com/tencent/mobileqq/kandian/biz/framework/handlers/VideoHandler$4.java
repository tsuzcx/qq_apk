package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$4
  implements Runnable
{
  VideoHandler$4(VideoHandler paramVideoHandler, VideoPlayParam paramVideoPlayParam1, VideoPlayManager paramVideoPlayManager, VideoPlayParam paramVideoPlayParam2) {}
  
  public void run()
  {
    int i = VideoHandler.b(this.this$0).getHeaderViewsCount() + this.a.e + 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSelectionFromTop selectIndex:");
      ((StringBuilder)localObject).append(i);
      QLog.i("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    VideoHandler.b(this.this$0).setSelectionFromTop(i, AIOUtils.b(175.0F, VideoHandler.c(this.this$0).getResources()));
    if (this.b.j() == 7)
    {
      this.this$0.a(this.c);
      return;
    }
    Object localObject = this.this$0;
    ((VideoHandler)localObject).f = null;
    ((VideoHandler)localObject).a(this.c, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.4
 * JD-Core Version:    0.7.0.1
 */
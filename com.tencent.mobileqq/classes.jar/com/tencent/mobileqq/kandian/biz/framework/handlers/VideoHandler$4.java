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
    int i = VideoHandler.a(this.this$0).getHeaderViewsCount() + this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.a + 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSelectionFromTop selectIndex:");
      ((StringBuilder)localObject).append(i);
      QLog.i("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    VideoHandler.a(this.this$0).setSelectionFromTop(i, AIOUtils.b(175.0F, VideoHandler.a(this.this$0).getResources()));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    Object localObject = this.this$0;
    ((VideoHandler)localObject).a = null;
    ((VideoHandler)localObject).a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.4
 * JD-Core Version:    0.7.0.1
 */
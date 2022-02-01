package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$5$1
  implements Runnable
{
  VideoHandler$5$1(VideoHandler.5 param5, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scroll ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" to top");
      QLog.d("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = VideoHandler.b(this.b.this$0).getChildAt(this.a - VideoHandler.b(this.b.this$0).getFirstVisiblePosition());
    if (localObject != null)
    {
      VideoHandler.f(this.b.this$0).removeMessages(1001);
      VideoHandler.b(this.b.this$0).smoothScrollBy(((View)localObject).getBottom() - AIOUtils.b(175.0F, VideoHandler.c(this.b.this$0).getResources()), 800);
      this.b.this$0.g().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.5.1
 * JD-Core Version:    0.7.0.1
 */
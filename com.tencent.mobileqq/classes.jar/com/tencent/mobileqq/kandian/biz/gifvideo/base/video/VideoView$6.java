package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class VideoView$6
  implements Runnable
{
  VideoView$6(VideoView paramVideoView) {}
  
  public void run()
  {
    if ((VideoView.access$800(this.this$0) != null) && (VideoView.access$900(this.this$0) != null))
    {
      Object localObject = this.this$0.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("displaycover: ");
      localStringBuilder.append(VideoView.access$1000(this.this$0));
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      localObject = VideoView.access$800(this.this$0);
      int i = 0;
      ((NativeReadInjoyImageView)localObject).setVisibility(0);
      VideoView.access$800(this.this$0).setAlpha(1.0F);
      VideoView.access$1100(this.this$0);
      localObject = VideoView.access$900(this.this$0);
      if (!VideoView.access$1200(this.this$0)) {
        i = 4;
      }
      ((NativeReadInjoyImageView)localObject).setVisibility(i);
      VideoView.access$900(this.this$0).clearAnimation();
      VideoView.access$900(this.this$0).setAlpha(1.0F);
      VideoView.access$1300(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.6
 * JD-Core Version:    0.7.0.1
 */
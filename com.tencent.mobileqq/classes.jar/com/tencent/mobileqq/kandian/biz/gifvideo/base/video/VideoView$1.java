package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class VideoView$1
  implements Runnable
{
  VideoView$1(VideoView paramVideoView, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 3) {
          if (i != 4)
          {
            if (i != 5)
            {
              if (i != 7)
              {
                if (i != 8)
                {
                  if (i != 9)
                  {
                    if (i != 11) {
                      break label133;
                    }
                    this.this$0.onDestroy();
                    break label133;
                  }
                  this.this$0.onStop();
                  break label133;
                }
                this.this$0.onPause();
                break label133;
              }
              this.this$0.onPlay();
              break label133;
            }
          }
          else
          {
            this.this$0.onInit();
            break label133;
          }
        }
        this.this$0.showLoading();
      }
      else
      {
        VideoView.access$000(this.this$0);
      }
    }
    else {
      this.this$0.onError();
    }
    label133:
    VideoView.access$100(this.this$0, this.a);
    if (VideoView.access$200(this.this$0) != null)
    {
      String str = VideoView.access$200(this.this$0).innerUniqueID;
      boolean bool;
      if (this.a == 7) {
        bool = true;
      } else {
        bool = false;
      }
      ReadInJoyHelper.a(str, bool, "PtsVideoPlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.1
 * JD-Core Version:    0.7.0.1
 */
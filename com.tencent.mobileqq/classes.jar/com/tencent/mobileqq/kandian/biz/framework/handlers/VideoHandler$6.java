package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;

class VideoHandler$6
  implements Runnable
{
  public void run()
  {
    VideoHandler.e(this.this$0).setIsRefreshingList(false);
    VideoHandler localVideoHandler = this.this$0;
    localVideoHandler.b(VideoHandler.b(localVideoHandler), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.6
 * JD-Core Version:    0.7.0.1
 */
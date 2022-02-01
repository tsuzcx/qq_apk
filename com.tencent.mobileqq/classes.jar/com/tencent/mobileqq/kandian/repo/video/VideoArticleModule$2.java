package com.tencent.mobileqq.kandian.repo.video;

import android.os.Handler;
import java.util.List;

class VideoArticleModule$2
  implements Runnable
{
  public void run()
  {
    List localList2 = this.a;
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = VideoArticleModule.a(this.this$0, this.b, this.c, this.d, this.e);
    }
    if (VideoArticleModule.c(this.this$0) == null) {
      return;
    }
    VideoArticleModule.d(this.this$0).post(new VideoArticleModule.2.1(this, localList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;

class VideoFeedsUGView$8
  implements Runnable
{
  VideoFeedsUGView$8(VideoFeedsUGView paramVideoFeedsUGView, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!TextUtils.isEmpty(this.this$0.a.j)))
    {
      if (!this.this$0.a.j.equals(this.a)) {
        return;
      }
      this.this$0.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.8
 * JD-Core Version:    0.7.0.1
 */
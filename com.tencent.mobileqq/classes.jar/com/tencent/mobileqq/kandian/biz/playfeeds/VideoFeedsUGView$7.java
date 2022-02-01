package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;

class VideoFeedsUGView$7
  implements Runnable
{
  VideoFeedsUGView$7(VideoFeedsUGView paramVideoFeedsUGView, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (!TextUtils.isEmpty(this.this$0.a.f)) && (this.this$0.a.f.equals(this.a.d)))
    {
      this.this$0.g.setVisibility(0);
      this.this$0.e.setVisibility(8);
      this.this$0.g.setText(this.this$0.a.l);
      this.this$0.c = this.a.t;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.7
 * JD-Core Version:    0.7.0.1
 */
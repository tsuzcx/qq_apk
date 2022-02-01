package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.UGDownloadInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class VideoFeedsUGView$6
  implements Runnable
{
  VideoFeedsUGView$6(VideoFeedsUGView paramVideoFeedsUGView, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((this.this$0.a != null) && (!TextUtils.isEmpty(this.this$0.a.f)) && (this.this$0.a.f.equals(localDownloadInfo.d)))
      {
        this.this$0.g.setVisibility(0);
        this.this$0.e.setVisibility(8);
        if ((localDownloadInfo.t >= 0) && (localDownloadInfo.t <= 100))
        {
          TextView localTextView = this.this$0.g;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.this$0.a.k);
          localStringBuilder.append(localDownloadInfo.t);
          localStringBuilder.append("%");
          localTextView.setText(localStringBuilder.toString());
          this.this$0.c = localDownloadInfo.t;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsUGView.6
 * JD-Core Version:    0.7.0.1
 */
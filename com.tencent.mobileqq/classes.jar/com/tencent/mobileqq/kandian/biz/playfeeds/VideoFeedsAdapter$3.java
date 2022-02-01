package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsAdapter$3
  extends Handler
{
  VideoFeedsAdapter$3(VideoFeedsAdapter paramVideoFeedsAdapter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mUIHandler handleMessage() msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsAdapter", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 7)
          {
            if (i != 8)
            {
              super.handleMessage(paramMessage);
              return;
            }
            VideoFeedsAdapter.f(this.a);
            return;
          }
          VideoFeedsAdapter.e(this.a);
          return;
        }
        VideoFeedsAdapter.d(this.a);
        return;
      }
      VideoFeedsAdapter.c(this.a);
      return;
    }
    VideoFeedsAdapter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAdapter.3
 * JD-Core Version:    0.7.0.1
 */
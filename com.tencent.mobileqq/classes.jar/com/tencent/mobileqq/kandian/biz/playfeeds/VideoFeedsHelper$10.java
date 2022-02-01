package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class VideoFeedsHelper$10
  implements Runnable
{
  VideoFeedsHelper$10(int paramInt, String paramString, TextView paramTextView) {}
  
  public void run()
  {
    String str = VideoFeedsHelper.a(this.a, this.b);
    ThreadManager.getUIHandler().post(new VideoFeedsHelper.10.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.10
 * JD-Core Version:    0.7.0.1
 */
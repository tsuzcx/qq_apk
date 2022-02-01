package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Dialog;

final class VideoFeedsHelper$11
  implements Runnable
{
  public void run()
  {
    try
    {
      if (VideoFeedsHelper.a != null)
      {
        VideoFeedsHelper.a.dismiss();
        VideoFeedsHelper.a = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.11
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import java.lang.ref.WeakReference;

class VideoFeedsResourceLoader$1
  implements Runnable
{
  VideoFeedsResourceLoader$1(VideoFeedsResourceLoader paramVideoFeedsResourceLoader, WeakReference paramWeakReference) {}
  
  public void run()
  {
    Context localContext = (Context)this.a.get();
    if (localContext != null)
    {
      VideoFeedsResourceLoader.a(localContext, 2130843270);
      VideoFeedsResourceLoader.a(localContext, 2130843107);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader.1
 * JD-Core Version:    0.7.0.1
 */
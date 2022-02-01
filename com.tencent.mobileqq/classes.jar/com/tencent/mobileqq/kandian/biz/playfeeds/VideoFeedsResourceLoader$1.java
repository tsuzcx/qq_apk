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
      VideoFeedsResourceLoader.a(localContext, 2130844224);
      VideoFeedsResourceLoader.a(localContext, 2130844062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsResourceLoader.1
 * JD-Core Version:    0.7.0.1
 */
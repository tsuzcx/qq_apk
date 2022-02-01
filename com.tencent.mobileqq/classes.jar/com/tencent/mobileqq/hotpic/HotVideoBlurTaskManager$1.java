package com.tencent.mobileqq.hotpic;

import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;

class HotVideoBlurTaskManager$1
  implements Runnable
{
  HotVideoBlurTaskManager$1(HotVideoBlurTaskManager paramHotVideoBlurTaskManager) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = (HotVideoData)this.this$0.a.keyAt(0);
    HotPicPageView.MyVideoViewHolder localMyVideoViewHolder = (HotPicPageView.MyVideoViewHolder)this.this$0.a.get(localHotVideoData);
    if (localMyVideoViewHolder.b(localHotVideoData))
    {
      Drawable localDrawable = HotVideoPreviewDownloader.a(this.this$0.b, localHotVideoData);
      if ((localDrawable != null) && (localMyVideoViewHolder.b(localHotVideoData))) {
        localMyVideoViewHolder.b(localDrawable);
      }
      this.this$0.a(localHotVideoData);
    }
    else
    {
      this.this$0.a(localHotVideoData);
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1
 * JD-Core Version:    0.7.0.1
 */
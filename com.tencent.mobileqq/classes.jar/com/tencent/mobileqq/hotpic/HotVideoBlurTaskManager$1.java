package com.tencent.mobileqq.hotpic;

import android.graphics.drawable.Drawable;
import android.support.v4.util.ArrayMap;

class HotVideoBlurTaskManager$1
  implements Runnable
{
  HotVideoBlurTaskManager$1(HotVideoBlurTaskManager paramHotVideoBlurTaskManager) {}
  
  public void run()
  {
    HotVideoData localHotVideoData = (HotVideoData)this.this$0.jdField_a_of_type_AndroidSupportV4UtilArrayMap.keyAt(0);
    HotPicPageView.MyVideoViewHolder localMyVideoViewHolder = (HotPicPageView.MyVideoViewHolder)this.this$0.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(localHotVideoData);
    if (localMyVideoViewHolder.a(localHotVideoData))
    {
      Drawable localDrawable = HotVideoPreviewDownloader.a(this.this$0.jdField_a_of_type_AndroidContentContext, localHotVideoData);
      if ((localDrawable != null) && (localMyVideoViewHolder.a(localHotVideoData))) {
        localMyVideoViewHolder.b(localDrawable);
      }
      this.this$0.a(localHotVideoData);
    }
    for (;;)
    {
      this.this$0.a();
      return;
      this.this$0.a(localHotVideoData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1
 * JD-Core Version:    0.7.0.1
 */
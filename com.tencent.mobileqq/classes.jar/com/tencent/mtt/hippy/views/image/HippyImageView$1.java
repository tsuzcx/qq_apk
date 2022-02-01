package com.tencent.mtt.hippy.views.image;

import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;

class HippyImageView$1
  implements HippyImageLoader.Callback
{
  HippyImageView$1(HippyImageView paramHippyImageView, int paramInt, String paramString) {}
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    if (this.val$sourceType == 1)
    {
      if (!TextUtils.equals(this.val$url, HippyImageView.access$400(this.this$0))) {
        return;
      }
      HippyImageView.access$502(this.this$0, 0);
    }
    if ((this.val$sourceType == 2) && (!TextUtils.equals(this.val$url, HippyImageView.access$600(this.this$0)))) {
      return;
    }
    this.this$0.handleImageRequest(null, this.val$sourceType, paramThrowable);
  }
  
  public void onRequestStart(HippyDrawable paramHippyDrawable)
  {
    HippyImageView.access$002(this.this$0, paramHippyDrawable);
  }
  
  public void onRequestSuccess(HippyDrawable paramHippyDrawable)
  {
    if (this.val$sourceType == 1)
    {
      if (!TextUtils.equals(this.val$url, HippyImageView.access$100(this.this$0))) {
        return;
      }
      HippyImageView.access$202(this.this$0, 2);
    }
    if ((this.val$sourceType == 2) && (!TextUtils.equals(this.val$url, HippyImageView.access$300(this.this$0)))) {
      return;
    }
    this.this$0.handleImageRequest(paramHippyDrawable, this.val$sourceType, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageView.1
 * JD-Core Version:    0.7.0.1
 */
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
    if (this.val$sourceType == HippyImageView.access$600())
    {
      if (!TextUtils.equals(this.val$url, HippyImageView.access$700(this.this$0))) {
        return;
      }
      HippyImageView.access$802(this.this$0, 0);
    }
    if ((this.val$sourceType == HippyImageView.access$900()) && (!TextUtils.equals(this.val$url, HippyImageView.access$1000(this.this$0)))) {
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
    if (this.val$sourceType == HippyImageView.access$100())
    {
      if (!TextUtils.equals(this.val$url, HippyImageView.access$200(this.this$0))) {
        return;
      }
      HippyImageView.access$302(this.this$0, 2);
    }
    if ((this.val$sourceType == HippyImageView.access$400()) && (!TextUtils.equals(this.val$url, HippyImageView.access$500(this.this$0)))) {
      return;
    }
    this.this$0.handleImageRequest(paramHippyDrawable, this.val$sourceType, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageView.1
 * JD-Core Version:    0.7.0.1
 */
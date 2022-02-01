package com.tencent.mtt.hippy.views.image;

import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;

class HippyImageView$1
  implements HippyImageLoader.Callback
{
  String mFetchUrl = HippyImageView.access$000(this.this$0);
  
  HippyImageView$1(HippyImageView paramHippyImageView, int paramInt) {}
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    if (TextUtils.equals(this.mFetchUrl, HippyImageView.access$400(this.this$0)))
    {
      HippyImageView.access$502(this.this$0, 0);
      if ((this.val$sourceType == HippyImageView.access$600()) && (!TextUtils.isEmpty(this.this$0.mHippyImageViewDefalutImgeUrl)))
      {
        HippyImageView.access$702(this.this$0, null);
        this.this$0.setDefaultSource(this.this$0.mHippyImageViewDefalutImgeUrl);
      }
    }
    else
    {
      return;
    }
    this.this$0.handleImageRequest(null, this.val$sourceType, paramThrowable);
  }
  
  public void onRequestStart(HippyDrawable paramHippyDrawable)
  {
    HippyImageView.access$102(this.this$0, paramHippyDrawable);
  }
  
  public void onRequestSuccess(HippyDrawable paramHippyDrawable)
  {
    if (TextUtils.equals(this.mFetchUrl, HippyImageView.access$200(this.this$0)))
    {
      HippyImageView.access$302(this.this$0, 2);
      this.this$0.handleImageRequest(paramHippyDrawable, this.val$sourceType, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.image.HippyImageView.1
 * JD-Core Version:    0.7.0.1
 */
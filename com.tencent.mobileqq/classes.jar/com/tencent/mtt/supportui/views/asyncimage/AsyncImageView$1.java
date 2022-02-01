package com.tencent.mtt.supportui.views.asyncimage;

import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.adapters.image.IImageRequestListener;

class AsyncImageView$1
  implements IImageRequestListener<IDrawableTarget>
{
  AsyncImageView$1(AsyncImageView paramAsyncImageView, int paramInt) {}
  
  public void onRequestFail(Throwable paramThrowable, String paramString)
  {
    this.this$0.handleImageRequest(null, this.val$sourceType, paramThrowable);
  }
  
  public void onRequestStart(IDrawableTarget paramIDrawableTarget)
  {
    this.this$0.mSourceDrawable = paramIDrawableTarget;
  }
  
  public void onRequestSuccess(IDrawableTarget paramIDrawableTarget)
  {
    this.this$0.handleImageRequest(paramIDrawableTarget, this.val$sourceType, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.AsyncImageView.1
 * JD-Core Version:    0.7.0.1
 */
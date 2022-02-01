package com.tencent.mobileqq.kandian.biz.comment.emotion.span;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

final class RIJEmotionImageSpan$MyDownloadListener
  implements URLDrawable.URLDrawableListener
{
  private final WeakReference<RIJEmotionImageSpan> a;
  
  RIJEmotionImageSpan$MyDownloadListener(RIJEmotionImageSpan paramRIJEmotionImageSpan)
  {
    this.a = new WeakReference(paramRIJEmotionImageSpan);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    RIJEmotionImageSpan localRIJEmotionImageSpan = (RIJEmotionImageSpan)this.a.get();
    if (localRIJEmotionImageSpan != null)
    {
      if (localRIJEmotionImageSpan.a == null) {
        return;
      }
      localRIJEmotionImageSpan.a(paramURLDrawable);
      localRIJEmotionImageSpan.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionImageSpan.MyDownloadListener
 * JD-Core Version:    0.7.0.1
 */
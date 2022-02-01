package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class PhotoPreviewAdapter$1
  implements URLDrawableDownListener
{
  PhotoPreviewAdapter$1(PhotoPreviewAdapter paramPhotoPreviewAdapter) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */
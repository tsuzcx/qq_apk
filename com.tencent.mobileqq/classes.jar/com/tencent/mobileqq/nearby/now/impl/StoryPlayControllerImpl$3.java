package com.tencent.mobileqq.nearby.now.impl;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;

class StoryPlayControllerImpl$3
  implements URLDrawable.URLDrawableListener
{
  StoryPlayControllerImpl$3(StoryPlayControllerImpl paramStoryPlayControllerImpl, ImageView paramImageView, IVideoInfoListener paramIVideoInfoListener) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
    IVideoInfoListener localIVideoInfoListener = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewLogicIVideoInfoListener;
    if (localIVideoInfoListener != null) {
      ((IVideoPlayerView.VideoInfoListener)localIVideoInfoListener).onCoverComplete(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.3
 * JD-Core Version:    0.7.0.1
 */
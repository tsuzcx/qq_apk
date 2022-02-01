package com.tencent.mobileqq.nearby.now.impl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;

class StoryPlayControllerImpl$4
  implements URLDrawable.URLDrawableListener
{
  StoryPlayControllerImpl$4(StoryPlayControllerImpl paramStoryPlayControllerImpl, IVideoInfoListener paramIVideoInfoListener) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    IVideoInfoListener localIVideoInfoListener = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewLogicIVideoInfoListener;
    if (localIVideoInfoListener != null) {
      ((IVideoPlayerView.VideoInfoListener)localIVideoInfoListener).onCoverComplete(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby.now.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import java.util.HashMap;

class StoryPlayControllerImpl$8
  implements DialogInterface.OnDismissListener
{
  StoryPlayControllerImpl$8(StoryPlayControllerImpl paramStoryPlayControllerImpl, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, HashMap paramHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      ((IVideoPlayerView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowImplStoryPlayControllerImpl.mVideoPlayer).resume();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Int)) != null) {
        ((IVideoInfoListener)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Int))).scrollToTop();
      }
    }
    StoryPlayControllerImpl.access$402(this.jdField_a_of_type_ComTencentMobileqqNearbyNowImplStoryPlayControllerImpl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */
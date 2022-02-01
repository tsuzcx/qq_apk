package com.tencent.mobileqq.nearby.now;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;
import java.util.HashMap;

class StoryPlayController$8
  implements DialogInterface.OnDismissListener
{
  StoryPlayController$8(StoryPlayController paramStoryPlayController, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, HashMap paramHashMap) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.b();
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Int)) != null) {
        ((VideoInfoListenerImpl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_Int))).i();
      }
    }
    StoryPlayController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController.8
 * JD-Core Version:    0.7.0.1
 */
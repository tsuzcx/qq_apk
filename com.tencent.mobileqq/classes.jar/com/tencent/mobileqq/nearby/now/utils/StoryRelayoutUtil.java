package com.tencent.mobileqq.nearby.now.utils;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

public class StoryRelayoutUtil
{
  public static float a = 600.0F;
  public static float b = 1334.0F;
  public static float c = -1.0F;
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2)
  {
    if ((paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null)) {}
    while ((!(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) || (paramFloat2 >= paramFloat1)) {
      return false;
    }
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
    ImageView localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366378);
    paramVideoViewHolder = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370642);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramVideoViewHolder.setScaleType(ImageView.ScaleType.FIT_CENTER);
    return true;
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, float paramFloat1, float paramFloat2, VideoData paramVideoData, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    if ((paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView == null) || (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView == null) || (paramShortVideoCommentsView == null)) {}
    while ((!(paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext() instanceof Activity)) || (paramFloat1 >= paramFloat2)) {
      return false;
    }
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil
 * JD-Core Version:    0.7.0.1
 */
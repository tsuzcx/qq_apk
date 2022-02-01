package com.tencent.mobileqq.nearby.now.view.logic.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;

class VideoInfoListenerImpl$2
  implements View.OnClickListener
{
  VideoInfoListenerImpl$2(VideoInfoListenerImpl paramVideoInfoListenerImpl) {}
  
  public void onClick(View paramView)
  {
    VideoInfoListenerImpl.access$100(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    ((IVideoPlayerView)VideoInfoListenerImpl.access$000(this.a).getVideoPlayer()).stopPlayback(false);
    VideoInfoListenerImpl.access$000(this.a).startPlayVideo(VideoInfoListenerImpl.access$000(this.a).getCurrentIndex());
    if (VideoInfoListenerImpl.access$100(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      VideoInfoListenerImpl.access$100(this.a).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.impl.VideoInfoListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby.now.view.logic.impl;

import android.app.Activity;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VideoInfoListenerImpl$1
  implements Runnable
{
  VideoInfoListenerImpl$1(VideoInfoListenerImpl paramVideoInfoListenerImpl) {}
  
  public void run()
  {
    if (((VideoInfoListenerImpl.access$000(this.this$0).getContext() instanceof Activity)) && (((Activity)VideoInfoListenerImpl.access$000(this.this$0).getContext()).isFinishing())) {
      return;
    }
    if (VideoInfoListenerImpl.access$100(this.this$0).a >= 0)
    {
      if (VideoInfoListenerImpl.access$100(this.this$0).a >= ((VideoPlayerPagerAdapter)VideoInfoListenerImpl.access$000(this.this$0).getAdapter()).d.size()) {
        return;
      }
      if (((StuffContainerView)VideoInfoListenerImpl.access$000(this.this$0).getStuffContainerView()).c != null)
      {
        if (VideoInfoListenerImpl.access$000(this.this$0).isNeedRepeat())
        {
          ((IVideoPlayerView)VideoInfoListenerImpl.access$000(this.this$0).getVideoPlayer()).restart();
          if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "discovery page repeat mode and repeat the Vidoe!");
          }
          return;
        }
        if (!VideoInfoListenerImpl.access$200(this.this$0).canPlayNext())
        {
          ((IVideoPlayerView)VideoInfoListenerImpl.access$000(this.this$0).getVideoPlayer()).restart();
          if (QLog.isColorLevel()) {
            QLog.i("VideoInfoListener", 2, "repeat in Video Page!");
          }
          return;
        }
        if (VideoInfoListenerImpl.access$100(this.this$0).a == ((VideoPlayerPagerAdapter)VideoInfoListenerImpl.access$000(this.this$0).getAdapter()).d.size() - 1)
        {
          if ((VideoInfoListenerImpl.access$000(this.this$0).getContext() instanceof Activity)) {
            ((Activity)VideoInfoListenerImpl.access$000(this.this$0).getContext()).finish();
          }
          return;
        }
      }
      VideoData localVideoData = (VideoData)((VideoPlayerPagerAdapter)VideoInfoListenerImpl.access$000(this.this$0).getAdapter()).d.get(VideoInfoListenerImpl.access$100(this.this$0).a);
      localVideoData.F = 0;
      localVideoData.K = false;
      VideoInfoListenerImpl.access$000(this.this$0).setCurrentIndex(VideoInfoListenerImpl.access$000(this.this$0).getCurrentIndex() + 1);
      if (VideoInfoListenerImpl.access$000(this.this$0).getCurrentIndex() < ((VideoPlayerPagerAdapter)VideoInfoListenerImpl.access$000(this.this$0).getAdapter()).d.size())
      {
        ((StuffContainerView)VideoInfoListenerImpl.access$000(this.this$0).getStuffContainerView()).setCurrentItem(VideoInfoListenerImpl.access$000(this.this$0).getCurrentIndex(), true);
        return;
      }
      if (((BasePlayListDataModel)VideoInfoListenerImpl.access$000(this.this$0).getBasePlayListDataModel()).e()) {
        ((StuffContainerView)VideoInfoListenerImpl.access$000(this.this$0).getStuffContainerView()).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.impl.VideoInfoListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */
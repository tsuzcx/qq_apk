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
    if (this.a.c != null)
    {
      ((IVideoPlayerView)this.c.mVideoPlayer).resume();
      if (this.b.get(Integer.valueOf(this.a.a)) != null) {
        ((IVideoInfoListener)this.b.get(Integer.valueOf(this.a.a))).scrollToTop();
      }
    }
    StoryPlayControllerImpl.access$402(this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */
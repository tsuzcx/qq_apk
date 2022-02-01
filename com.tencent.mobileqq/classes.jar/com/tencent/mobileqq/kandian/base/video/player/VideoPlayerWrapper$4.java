package com.tencent.mobileqq.kandian.base.video.player;

import android.view.View;
import android.view.ViewGroup;

class VideoPlayerWrapper$4
  implements Runnable
{
  VideoPlayerWrapper$4(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, View paramView) {}
  
  public void run()
  {
    if (this.a)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.4
 * JD-Core Version:    0.7.0.1
 */
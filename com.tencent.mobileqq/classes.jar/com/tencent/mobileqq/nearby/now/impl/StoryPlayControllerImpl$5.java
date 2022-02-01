package com.tencent.mobileqq.nearby.now.impl;

import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.PlayResultListener;

class StoryPlayControllerImpl$5
  implements PlayResultListener
{
  StoryPlayControllerImpl$5(StoryPlayControllerImpl paramStoryPlayControllerImpl) {}
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 1;
    int i = 1;
    if (paramInt1 != 100)
    {
      paramString1 = this.a.mVideoPlayer.getVideoData().a;
      if (!((IVideoPlayerView)this.a.mVideoPlayer).isVideoCached()) {
        i = 2;
      }
      QualityReporter.a(paramString1, i, String.valueOf(paramInt1), String.valueOf(paramInt2));
      return;
    }
    QualityReporter.e();
    paramString1 = StoryPlayControllerImpl.access$200(this.a);
    if (((IVideoPlayerView)this.a.mVideoPlayer).isVideoCached()) {
      paramInt1 = j;
    } else {
      paramInt1 = 2;
    }
    QualityReporter.a(paramString1, paramInt1, this.a.isUrlProvided);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl.5
 * JD-Core Version:    0.7.0.1
 */
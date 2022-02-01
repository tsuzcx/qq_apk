package com.tencent.mobileqq.nearby.now.view;

class MagazinePlayerView$1
  implements Runnable
{
  MagazinePlayerView$1(MagazinePlayerView paramMagazinePlayerView) {}
  
  public void run()
  {
    ((IVideoPlayerView.VideoInfoListener)this.this$0.mVideoInfoListener).onStartPrepareVideo();
    MagazinePlayerView localMagazinePlayerView = this.this$0;
    localMagazinePlayerView.isPlaying = true;
    ((IVideoPlayerView.VideoInfoListener)localMagazinePlayerView.mVideoInfoListener).onStartPlaying();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.MagazinePlayerView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby.now.view.player.impl;

import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnInfoListener;

class VideoViewTVKImpl$3$1
  implements Runnable
{
  VideoViewTVKImpl$3$1(VideoViewTVKImpl.3 param3, int paramInt, Object paramObject) {}
  
  public void run()
  {
    if (this.c.a.l != null)
    {
      int j = this.a;
      int i;
      if (j == 21)
      {
        i = 2;
      }
      else
      {
        i = j;
        if (j == 22) {
          i = 3;
        }
      }
      this.c.a.l.a(this.c.a, i, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby.now.view.player.impl;

import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class VideoViewTVKImpl$6$2
  implements Runnable
{
  VideoViewTVKImpl$6$2(VideoViewTVKImpl.6 param6) {}
  
  public void run()
  {
    if ((this.a.c.b != null) && (!TextUtils.isEmpty(this.a.c.f)))
    {
      this.a.c.b.openMediaPlayerByUrl(this.a.c.c, this.a.c.f, 0L, 0L, null, this.a.b);
      this.a.c.h = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.6.2
 * JD-Core Version:    0.7.0.1
 */
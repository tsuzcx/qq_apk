package com.tencent.mobileqq.hotpic;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

class VideoBaseItem$5
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  VideoBaseItem$5(VideoBaseItem paramVideoBaseItem) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.a.start();
    this.a.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.5
 * JD-Core Version:    0.7.0.1
 */
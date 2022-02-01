package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class VideoBaseItem$2
  implements TVK_IMediaPlayer.OnCompletionListener
{
  VideoBaseItem$2(VideoBaseItem paramVideoBaseItem) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    VideoBaseItem.a(this.a).post(new VideoBaseItem.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.2
 * JD-Core Version:    0.7.0.1
 */
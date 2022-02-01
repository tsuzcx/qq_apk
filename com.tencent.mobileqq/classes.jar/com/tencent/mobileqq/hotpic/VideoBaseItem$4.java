package com.tencent.mobileqq.hotpic;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class VideoBaseItem$4
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoBaseItem$4(VideoBaseItem paramVideoBaseItem) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.jdField_a_of_type_Boolean = false;
    VideoBaseItem.a(this.a, true);
    if (this.a.c == 3) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.c = 2;
    } while (VideoBaseItem.a(this.a) == null);
    VideoBaseItem.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.4
 * JD-Core Version:    0.7.0.1
 */
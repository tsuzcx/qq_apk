package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class VideoBaseItem$6
  implements TVK_IMediaPlayer.OnInfoListener
{
  VideoBaseItem$6(VideoBaseItem paramVideoBaseItem) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 21)
    {
      if (paramInt != 22) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video end buffering !");
      }
      if (VideoBaseItem.a(this.a) != null)
      {
        VideoBaseItem.a(this.a).a(this.a.c, 1);
        return false;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video start buffering !");
      }
      if (VideoBaseItem.a(this.a) != null) {
        VideoBaseItem.a(this.a).a(this.a.c, 0);
      }
      this.a.g = 6;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.6
 * JD-Core Version:    0.7.0.1
 */
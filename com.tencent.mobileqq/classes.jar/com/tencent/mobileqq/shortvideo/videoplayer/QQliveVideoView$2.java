package com.tencent.mobileqq.shortvideo.videoplayer;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class QQliveVideoView$2
  implements Runnable
{
  QQliveVideoView$2(QQliveVideoView paramQQliveVideoView) {}
  
  public void run()
  {
    try
    {
      if ((QQliveVideoView.a(this.this$0) != null) && (QQliveVideoView.a(this.this$0).isPlaying()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.a(), 2, "mMediaPlayer.pause()");
        }
        QQliveVideoView.a(this.this$0).pause();
        QQliveVideoView.a(this.this$0);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videoplayer.QQliveVideoView.2
 * JD-Core Version:    0.7.0.1
 */
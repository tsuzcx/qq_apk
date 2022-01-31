package com.tencent.mobileqq.shortvideo.videoplayer;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class QQliveVideoView$1
  implements Runnable
{
  QQliveVideoView$1(QQliveVideoView paramQQliveVideoView, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QQliveVideoView.a(this.this$0) != null)
      {
        if (this.a)
        {
          QQliveVideoView.a(this.this$0, (int)QQliveVideoView.a(this.this$0).getCurrentPostion());
          if (QLog.isColorLevel()) {
            QLog.d(this.this$0.a(), 2, "releasePlayer,record play pos = " + QQliveVideoView.a(this.this$0));
          }
        }
        QQliveVideoView.a(this.this$0).stop();
        QQliveVideoView.a(this.this$0).release();
        QQliveVideoView.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videoplayer.QQliveVideoView.1
 * JD-Core Version:    0.7.0.1
 */
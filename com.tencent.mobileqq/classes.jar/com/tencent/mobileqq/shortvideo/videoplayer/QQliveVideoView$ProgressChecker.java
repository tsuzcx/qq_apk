package com.tencent.mobileqq.shortvideo.videoplayer;

import android.os.Handler;
import awnh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

class QQliveVideoView$ProgressChecker
  implements Runnable
{
  WeakReference<QQliveVideoView> a;
  
  public QQliveVideoView$ProgressChecker(QQliveVideoView paramQQliveVideoView)
  {
    this.a = new WeakReference(paramQQliveVideoView);
  }
  
  public void run()
  {
    if ((this.a.get() != null) && (QQliveVideoView.a((QQliveVideoView)this.a.get()) != null) && (QQliveVideoView.a((QQliveVideoView)this.a.get()).isPlaying()))
    {
      long l = QQliveVideoView.a((QQliveVideoView)this.a.get()).getCurrentPostion();
      if (l > 0L)
      {
        QQliveVideoView.a((QQliveVideoView)this.a.get(), l);
        if (QQliveVideoView.a((QQliveVideoView)this.a.get()) != null) {
          QQliveVideoView.a((QQliveVideoView)this.a.get()).a(QQliveVideoView.a((QQliveVideoView)this.a.get()));
        }
      }
      if ((QQliveVideoView.a((QQliveVideoView)this.a.get())) && (QQliveVideoView.b((QQliveVideoView)this.a.get()) > 0L) && (QQliveVideoView.b((QQliveVideoView)this.a.get()) < QQliveVideoView.c((QQliveVideoView)this.a.get())) && (QQliveVideoView.a((QQliveVideoView)this.a.get()) > QQliveVideoView.b((QQliveVideoView)this.a.get())))
      {
        if (QLog.isColorLevel()) {
          QLog.d(((QQliveVideoView)this.a.get()).a(), 2, " ProgressChecker,seek to 0 , mCurPlayPosition = " + QQliveVideoView.a((QQliveVideoView)this.a.get()) + ", mMaxPlayTimeMs = " + QQliveVideoView.b((QQliveVideoView)this.a.get()));
        }
        QQliveVideoView.a((QQliveVideoView)this.a.get());
        QQliveVideoView.a((QQliveVideoView)this.a.get()).seekTo(0);
        QQliveVideoView.a((QQliveVideoView)this.a.get(), 0L);
        if (QQliveVideoView.a((QQliveVideoView)this.a.get()) != null) {
          QQliveVideoView.a((QQliveVideoView)this.a.get()).a(QQliveVideoView.d((QQliveVideoView)this.a.get()), QQliveVideoView.a((QQliveVideoView)this.a.get()));
        }
      }
    }
    while ((this.a.get() == null) || (QQliveVideoView.a((QQliveVideoView)this.a.get()).get() != 3)) {
      return;
    }
    QQliveVideoView.a((QQliveVideoView)this.a.get()).postDelayed(QQliveVideoView.a((QQliveVideoView)this.a.get()), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videoplayer.QQliveVideoView.ProgressChecker
 * JD-Core Version:    0.7.0.1
 */
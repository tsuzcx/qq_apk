package com.tencent.mobileqq.listentogether.player;

import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;

class QQMusicPlayService$1
  implements AudioManager.OnAudioFocusChangeListener
{
  QQMusicPlayService$1(QQMusicPlayService paramQQMusicPlayService) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onAudioFocusChange,focusChange:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = this.a;
      if ((paramInt == -3) || ((paramInt == -2) || ((paramInt == -1) || (paramInt == 1)))) {}
      try
      {
        if ((QQMusicPlayService.e() == 3) && (QQMusicPlayService.a() != null) && (!QQMusicPlayService.a().isPlaying()) && (!QQMusicPlayService.a(this.a))) {
          QQMusicPlayService.a().setVolume(1.0F, 1.0F);
        }
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,gain focus");
        QQMusicPlayService.a(this.a, true, false);
        break label302;
        if ((QQMusicPlayService.a() != null) && (QQMusicPlayService.a().isPlaying()))
        {
          QQMusicPlayService.a().stop();
          QQMusicPlayService.a(this.a, QQMusicPlayService.b(), 4);
          QQMusicPlayReport.b(QQMusicPlayService.b(), QQMusicPlayService.d());
        }
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,loss focus permanent");
        QQMusicPlayService.a(this.a, false, false);
        if (QQMusicPlayService.a(this.a) != null)
        {
          QQMusicPlayService.a(this.a).sendEmptyMessage(11);
          break label302;
          if ((QQMusicPlayService.a() != null) && (QQMusicPlayService.a().isPlaying()))
          {
            QQMusicPlayService.a().pause();
            QQMusicPlayService.a(this.a, QQMusicPlayService.b(), 3);
          }
          QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,loss focus transient");
          QQMusicPlayService.a(this.a, false, true);
          break label302;
          if ((QQMusicPlayService.a() != null) && (QQMusicPlayService.a().isPlaying()) && (!QQMusicPlayService.a(this.a))) {
            QQMusicPlayService.a().setVolume(0.5F, 0.5F);
          }
          QLog.d("QQMusicPlay.QQMusicPlayService", 1, "onAudioFocusChange,temporarily lost audio focus");
        }
        label302:
        return;
      }
      finally {}
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAudioFocusChange:");
      localStringBuilder.append(localException.getMessage());
      QLog.d("QQMusicPlay.QQMusicPlayService", 1, localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.music;

import android.media.AudioManager.OnAudioFocusChangeListener;

class QQPlayerService$1
  implements AudioManager.OnAudioFocusChangeListener
{
  QQPlayerService$1(QQPlayerService paramQQPlayerService) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    QQPlayerService.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.1
 * JD-Core Version:    0.7.0.1
 */
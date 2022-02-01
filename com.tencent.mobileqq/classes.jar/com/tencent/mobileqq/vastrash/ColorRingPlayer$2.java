package com.tencent.mobileqq.vastrash;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class ColorRingPlayer$2
  implements AudioManager.OnAudioFocusChangeListener
{
  ColorRingPlayer$2(ColorRingPlayer paramColorRingPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "transient focus loss.");
      }
      synchronized (this.a.a)
      {
        if (this.a.a.a == 4) {
          this.a.a();
        }
        return;
      }
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "gained focus");
      }
      if (this.a.h)
      {
        this.a.c();
        this.a.h = false;
      }
    }
    else if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "Audio focus Loss");
      }
      this.a.b();
      synchronized (this.a.a)
      {
        this.a.a.a = 6;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.2
 * JD-Core Version:    0.7.0.1
 */
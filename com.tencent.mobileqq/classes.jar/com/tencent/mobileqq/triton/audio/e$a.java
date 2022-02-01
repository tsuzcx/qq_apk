package com.tencent.mobileqq.triton.audio;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.triton.engine.TTLog;

class e$a
  implements AudioManager.OnAudioFocusChangeListener
{
  e$a(e parame) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    TTLog.c("[audio] TTAudioPlayerManager", "onAudioFocusChange focusChange=" + paramInt);
    if (paramInt == -2) {
      this.a.b();
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.a.a();
        return;
      }
    } while (paramInt != -1);
    e.b(this.a).abandonAudioFocus(e.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.e.a
 * JD-Core Version:    0.7.0.1
 */
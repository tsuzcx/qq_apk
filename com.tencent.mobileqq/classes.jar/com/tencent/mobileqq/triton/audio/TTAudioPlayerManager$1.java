package com.tencent.mobileqq.triton.audio;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.triton.engine.TTLog;

class TTAudioPlayerManager$1
  implements AudioManager.OnAudioFocusChangeListener
{
  TTAudioPlayerManager$1(TTAudioPlayerManager paramTTAudioPlayerManager) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    TTLog.i("[audio] TTAudioPlayerManager", "onAudioFocusChange focusChange=" + paramInt);
    if (paramInt == -2) {
      this.this$0.handleFocusLoss();
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.this$0.handleFocusGain();
        return;
      }
    } while (paramInt != -1);
    TTAudioPlayerManager.access$100(this.this$0).abandonAudioFocus(TTAudioPlayerManager.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.TTAudioPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */
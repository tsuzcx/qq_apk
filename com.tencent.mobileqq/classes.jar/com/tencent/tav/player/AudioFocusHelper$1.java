package com.tencent.tav.player;

import android.media.AudioManager.OnAudioFocusChangeListener;

class AudioFocusHelper$1
  implements AudioManager.OnAudioFocusChangeListener
{
  AudioFocusHelper$1(AudioFocusHelper paramAudioFocusHelper) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (AudioFocusHelper.access$000(this.this$0) == null) {
      return;
    }
    if (paramInt != -3) {
      if (paramInt != -2) {
        if (paramInt != -1) {
          if (paramInt != 1) {
            return;
          }
        }
      }
    }
    try
    {
      AudioFocusHelper.access$102(this.this$0, true);
      return;
    }
    catch (Exception localException) {}
    AudioFocusHelper.access$200(this.this$0, false);
    return;
    AudioFocusHelper.access$200(this.this$0, true);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.player.AudioFocusHelper.1
 * JD-Core Version:    0.7.0.1
 */
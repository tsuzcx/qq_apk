package com.tencent.mobileqq.qqexpand.widget.voice;

import android.media.AudioManager.OnAudioFocusChangeListener;

class ExpandVoicePlayer$1
  implements AudioManager.OnAudioFocusChangeListener
{
  ExpandVoicePlayer$1(ExpandVoicePlayer paramExpandVoicePlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((ExpandVoicePlayer.a(this.a) != null) && (paramInt == -1) && (ExpandVoicePlayer.a(this.a) != null)) {
      ExpandVoicePlayer.a(this.a).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */
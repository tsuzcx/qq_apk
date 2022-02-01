package com.tencent.mobileqq.extendfriend.utils;

import android.media.AudioManager.OnAudioFocusChangeListener;

class ExtendFriendVoicePlayer$1
  implements AudioManager.OnAudioFocusChangeListener
{
  ExtendFriendVoicePlayer$1(ExtendFriendVoicePlayer paramExtendFriendVoicePlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((ExtendFriendVoicePlayer.a(this.a) != null) && (paramInt == -1) && (ExtendFriendVoicePlayer.a(this.a) != null)) {
      ExtendFriendVoicePlayer.a(this.a).c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.1
 * JD-Core Version:    0.7.0.1
 */
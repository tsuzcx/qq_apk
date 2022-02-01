package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class TraeAudioManager$TraeAudioManagerLooper$3
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$TraeAudioManagerLooper$3(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.c + " currMode:" + TraeAudioManager.a(this.a.this$0).getMode() + " _activeMode:" + this.a.this$0.a);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.3
 * JD-Core Version:    0.7.0.1
 */
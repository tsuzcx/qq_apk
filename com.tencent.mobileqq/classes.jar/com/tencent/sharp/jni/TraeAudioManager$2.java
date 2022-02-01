package com.tencent.sharp.jni;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.qphone.base.util.QLog;

class TraeAudioManager$2
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$2(TraeAudioManager paramTraeAudioManager) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("focusChange[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], focusSteamType[");
      localStringBuilder.append(this.a.m);
      localStringBuilder.append("], mAudioManager.getMode()[");
      localStringBuilder.append(TraeAudioManager.c(this.a).getMode());
      localStringBuilder.append("], mActiveMode[");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append("]");
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.2
 * JD-Core Version:    0.7.0.1
 */
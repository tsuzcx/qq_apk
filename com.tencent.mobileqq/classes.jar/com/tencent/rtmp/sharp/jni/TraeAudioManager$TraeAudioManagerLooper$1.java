package com.tencent.rtmp.sharp.jni;

import java.util.HashMap;

class TraeAudioManager$TraeAudioManagerLooper$1
  implements TraeMediaPlayer.OnCompletionListener
{
  TraeAudioManager$TraeAudioManagerLooper$1(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  public void onCompletion()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_ringPlayer onCompletion _activeMode:");
      ((StringBuilder)localObject).append(this.this$1.this$0._activeMode);
      ((StringBuilder)localObject).append(" _preRingMode:");
      ((StringBuilder)localObject).append(this.this$1._preRingMode);
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
    this.this$1.sendMessage(32783, (HashMap)localObject);
    this.this$1.notifyRingCompletion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.1
 * JD-Core Version:    0.7.0.1
 */
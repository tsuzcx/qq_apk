package com.tencent.mtt.hippy.views.audioview;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import java.lang.ref.WeakReference;

final class AudioPlayManager$6
  implements AudioManager.OnAudioFocusChangeListener
{
  AudioPlayManager$6(WeakReference paramWeakReference) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2) {}
    while ((paramInt != 1) && (paramInt == -1))
    {
      AudioPlayManager.access$800().abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)AudioPlayManager.access$700());
      break;
    }
    Object localObject = this.val$reference;
    if (localObject != null)
    {
      localObject = (AudioPlayManager.OnAudioStateChange)((WeakReference)localObject).get();
      if (localObject != null) {
        ((AudioPlayManager.OnAudioStateChange)localObject).onChange(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
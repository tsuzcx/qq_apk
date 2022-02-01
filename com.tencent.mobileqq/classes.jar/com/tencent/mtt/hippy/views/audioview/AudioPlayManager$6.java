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
    if (paramInt == AudioPlayManager.access$700()) {
      AudioPlayManager.access$900().abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)AudioPlayManager.access$800());
    }
    for (;;)
    {
      if (this.val$reference != null)
      {
        AudioPlayManager.OnAudioStateChange localOnAudioStateChange = (AudioPlayManager.OnAudioStateChange)this.val$reference.get();
        if (localOnAudioStateChange != null) {
          localOnAudioStateChange.onChange(paramInt);
        }
      }
      return;
      if ((paramInt != 1) && (paramInt == -1)) {
        AudioPlayManager.access$900().abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)AudioPlayManager.access$800());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
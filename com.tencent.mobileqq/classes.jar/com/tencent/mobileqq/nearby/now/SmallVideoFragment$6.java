package com.tencent.mobileqq.nearby.now;

import android.media.AudioManager.OnAudioFocusChangeListener;

class SmallVideoFragment$6
  implements AudioManager.OnAudioFocusChangeListener
{
  SmallVideoFragment$6(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (SmallVideoFragment.b(this.a))) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.SmallVideoFragment.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavkit.component;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class TAVPlayer$1
  implements AudioManager.OnAudioFocusChangeListener
{
  TAVPlayer$1(TAVPlayer paramTAVPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 1) {
        return;
      }
      if (TAVPlayer.access$100(this.this$0) != null) {
        TAVPlayer.access$100(this.this$0).play();
      }
    }
    else
    {
      if (!TAVPlayer.access$000(this.this$0)) {
        return;
      }
      if (TAVPlayer.access$100(this.this$0) != null) {
        TAVPlayer.access$100(this.this$0).pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.1
 * JD-Core Version:    0.7.0.1
 */
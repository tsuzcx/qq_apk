package com.tencent.tavkit.component;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class TAVPlayer$4
  implements AudioManager.OnAudioFocusChangeListener
{
  TAVPlayer$4(TAVPlayer paramTAVPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!TAVPlayer.access$200(this.this$0)) || (TAVPlayer.access$000(this.this$0) == null));
      TAVPlayer.access$000(this.this$0).pause();
      return;
    } while (TAVPlayer.access$000(this.this$0) == null);
    TAVPlayer.access$000(this.this$0).play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.4
 * JD-Core Version:    0.7.0.1
 */
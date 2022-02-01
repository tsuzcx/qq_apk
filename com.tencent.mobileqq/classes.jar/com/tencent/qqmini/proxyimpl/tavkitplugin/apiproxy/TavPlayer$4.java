package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class TavPlayer$4
  implements AudioManager.OnAudioFocusChangeListener
{
  TavPlayer$4(TavPlayer paramTavPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((paramInt != -2) && (paramInt != -1))
    {
      if (paramInt != 1) {
        return;
      }
      if (TavPlayer.a(this.a) != null) {
        TavPlayer.a(this.a).play();
      }
    }
    else
    {
      if (!TavPlayer.b(this.a)) {
        return;
      }
      if (TavPlayer.a(this.a) != null) {
        TavPlayer.a(this.a).pause();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.tav.player.Player;

class TavPlayer$4
  implements AudioManager.OnAudioFocusChangeListener
{
  TavPlayer$4(TavPlayer paramTavPlayer) {}
  
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
      } while ((!TavPlayer.b(this.a)) || (TavPlayer.a(this.a) == null));
      TavPlayer.a(this.a).pause();
      return;
    } while (TavPlayer.a(this.a) == null);
    TavPlayer.a(this.a).play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.4
 * JD-Core Version:    0.7.0.1
 */
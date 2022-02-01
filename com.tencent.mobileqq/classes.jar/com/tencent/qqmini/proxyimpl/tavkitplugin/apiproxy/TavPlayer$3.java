package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;

class TavPlayer$3
  implements OnCompositionUpdateListener
{
  TavPlayer$3(TavPlayer paramTavPlayer, CMTime paramCMTime) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    this.b.a(this.a);
    if ((TavPlayer.b(this.b)) && (paramBoolean)) {
      this.b.d();
    }
    TavPlayer.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.3
 * JD-Core Version:    0.7.0.1
 */
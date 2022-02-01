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
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.a(this.jdField_a_of_type_ComTencentTavCoremediaCMTime);
    if ((TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer)) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer.c();
    }
    TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;

class TavPlayer$2
  implements IPlayer.PlayerListener
{
  TavPlayer$2(TavPlayer paramTavPlayer, TavPlayer.PlayerListener paramPlayerListener) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer$PlayerListener != null) && (TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer) != null)) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer$PlayerListener.a(paramCMTime, TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer).duration());
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer$PlayerListener != null) && (TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer) != null)) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer$PlayerListener.a(paramPlayerStatus, TavPlayer.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.2
 * JD-Core Version:    0.7.0.1
 */
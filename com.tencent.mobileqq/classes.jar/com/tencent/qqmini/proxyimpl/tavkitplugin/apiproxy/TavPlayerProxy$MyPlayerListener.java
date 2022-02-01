package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;
import org.json.JSONException;

class TavPlayerProxy$MyPlayerListener
  implements TavPlayer.PlayerListener
{
  private final TavPlayer jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer;
  
  public TavPlayerProxy$MyPlayerListener(TavPlayerProxy paramTavPlayerProxy, TavPlayer paramTavPlayer)
  {
    this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer = paramTavPlayer;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      paramString1 = ObjConvector.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayer, paramString1, paramString2, paramObject);
      this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayerProxy.a("tav_play", paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.e(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavPlayerProxy.a, "trySubscribe: ", paramString1);
    }
  }
  
  public void a(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    paramCMTime2 = null;
    try
    {
      paramCMTime1 = ObjConvector.a(paramCMTime1);
      a("timeChange", "time", paramCMTime1);
      return;
    }
    catch (JSONException paramCMTime1)
    {
      for (;;)
      {
        paramCMTime1.printStackTrace();
        paramCMTime1 = paramCMTime2;
      }
    }
  }
  
  public void a(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer)
  {
    switch (TavPlayerProxy.1.a[paramPlayerStatus.ordinal()])
    {
    default: 
      paramPlayerStatus = paramPlayerStatus.name();
    }
    for (;;)
    {
      a("stateChange", "state", paramPlayerStatus);
      return;
      paramPlayerStatus = "play";
      continue;
      paramPlayerStatus = "pause";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayerProxy.MyPlayerListener
 * JD-Core Version:    0.7.0.1
 */
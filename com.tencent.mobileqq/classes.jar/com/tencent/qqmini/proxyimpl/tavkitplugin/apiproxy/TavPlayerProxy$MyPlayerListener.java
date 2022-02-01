package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;
import org.json.JSONException;

class TavPlayerProxy$MyPlayerListener
  implements TavPlayer.PlayerListener
{
  private final TavPlayer b;
  
  public TavPlayerProxy$MyPlayerListener(TavPlayerProxy paramTavPlayerProxy, TavPlayer paramTavPlayer)
  {
    this.b = paramTavPlayer;
  }
  
  private void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      paramString1 = ObjConvector.a(this.b, paramString1, paramString2, paramObject);
      this.a.a("tav_play", paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      Logger.e(this.a.a, "trySubscribe: ", paramString1);
    }
  }
  
  public void a(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    try
    {
      paramCMTime1 = ObjConvector.a(paramCMTime1);
    }
    catch (JSONException paramCMTime1)
    {
      paramCMTime1.printStackTrace();
      paramCMTime1 = null;
    }
    a("timeChange", "time", paramCMTime1);
  }
  
  public void a(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer)
  {
    int i = TavPlayerProxy.1.a[paramPlayerStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        paramPlayerStatus = paramPlayerStatus.name();
      } else {
        paramPlayerStatus = "pause";
      }
    }
    else {
      paramPlayerStatus = "play";
    }
    a("stateChange", "state", paramPlayerStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayerProxy.MyPlayerListener
 * JD-Core Version:    0.7.0.1
 */
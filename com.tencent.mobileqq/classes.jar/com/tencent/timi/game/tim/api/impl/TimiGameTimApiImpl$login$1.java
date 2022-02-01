package com.tencent.timi.game.tim.api.impl;

import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$login$1", "Lcom/tencent/imsdk/v2/V2TIMSDKListener;", "onConnectFailed", "", "code", "", "error", "", "onConnectSuccess", "onKickedOffline", "onSelfInfoUpdated", "info", "Lcom/tencent/imsdk/v2/V2TIMUserFullInfo;", "onUserSigExpired", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$login$1
  extends V2TIMSDKListener
{
  TimiGameTimApiImpl$login$1(ILoginCallback paramILoginCallback) {}
  
  public void onConnectFailed(int paramInt, @Nullable String paramString)
  {
    super.onConnectFailed(paramInt, paramString);
    Logger.b("TimManager", "onConnectFailed");
    ILoginCallback localILoginCallback = this.b;
    if (localILoginCallback != null) {
      localILoginCallback.a(paramInt, paramString);
    }
  }
  
  public void onConnectSuccess()
  {
    super.onConnectSuccess();
    Logger.b("TimManager", "onConnectSuccess");
    TimiGameTimApiImpl.a(this.a, this.b);
  }
  
  public void onKickedOffline()
  {
    super.onKickedOffline();
    Logger.b("TimManager", "onKickedOffline");
  }
  
  public void onSelfInfoUpdated(@Nullable V2TIMUserFullInfo paramV2TIMUserFullInfo)
  {
    super.onSelfInfoUpdated(paramV2TIMUserFullInfo);
    Logger.b("TimManager", "onSelfInfoUpdated");
  }
  
  public void onUserSigExpired()
  {
    Logger.b("TimManager", "onUserSigExpired");
    this.a.a((IResultListener)new TimiGameTimApiImpl.login.1.onUserSigExpired.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.login.1
 * JD-Core Version:    0.7.0.1
 */
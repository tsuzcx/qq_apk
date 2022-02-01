package com.tencent.timi.game.liveroom.impl.floating;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/floating/TGLiveAudienceFloatingView$5", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "onNetMobile2None", "", "onNetMobile2Wifi", "p0", "", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGLiveAudienceFloatingView$5
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(@Nullable String paramString)
  {
    ThreadPool.c((Runnable)new TGLiveAudienceFloatingView.5.onNetMobile2Wifi.1(this));
  }
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    TGLiveAudienceFloatingView.c(this.a);
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    ThreadPool.c((Runnable)new TGLiveAudienceFloatingView.5.onNetNone2Wifi.1(this));
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString)
  {
    TGLiveAudienceFloatingView.c(this.a);
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.5
 * JD-Core Version:    0.7.0.1
 */
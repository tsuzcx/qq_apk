package com.tencent.timi.game.live.impl.video;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.timi.game.live.api.IGameLiveStatusListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/video/GameLiveView$2", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "onNetMobile2None", "", "onNetMobile2Wifi", "p0", "", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GameLiveView$2
  implements INetInfoHandler
{
  public void onNetMobile2None()
  {
    Logger.a("GameLiveView", "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetMobile2Wifi: ");
    localStringBuilder.append(paramString);
    Logger.a("GameLiveView", localStringBuilder.toString());
    paramString = this.a.getGameLiveStatusListener();
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Mobile: ");
    localStringBuilder.append(paramString);
    Logger.a("GameLiveView", localStringBuilder.toString());
    GameLiveView.h(this.a);
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetNone2Wifi: ");
    localStringBuilder.append(paramString);
    Logger.a("GameLiveView", localStringBuilder.toString());
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetWifi2Mobile: ");
    localStringBuilder.append(paramString);
    Logger.a("GameLiveView", localStringBuilder.toString());
    GameLiveView.h(this.a);
  }
  
  public void onNetWifi2None()
  {
    Logger.a("GameLiveView", "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView.2
 * JD-Core Version:    0.7.0.1
 */
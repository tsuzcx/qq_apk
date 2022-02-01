package com.tencent.timi.game.app.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/app/event/AnchorAtEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "liveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "quickTip", "", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;Ljava/lang/String;)V", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "getQuickTip", "()Ljava/lang/String;", "setQuickTip", "(Ljava/lang/String;)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorAtEvent
  extends SimpleBaseEvent
{
  @NotNull
  private LiveUserInfo liveUserInfo;
  @NotNull
  private String quickTip;
  
  public AnchorAtEvent(@NotNull LiveUserInfo paramLiveUserInfo, @NotNull String paramString)
  {
    this.liveUserInfo = paramLiveUserInfo;
    this.quickTip = paramString;
  }
  
  @NotNull
  public final LiveUserInfo getLiveUserInfo()
  {
    return this.liveUserInfo;
  }
  
  @NotNull
  public final String getQuickTip()
  {
    return this.quickTip;
  }
  
  public final void setLiveUserInfo(@NotNull LiveUserInfo paramLiveUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveUserInfo, "<set-?>");
    this.liveUserInfo = paramLiveUserInfo;
  }
  
  public final void setQuickTip(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.quickTip = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.app.event.AnchorAtEvent
 * JD-Core Version:    0.7.0.1
 */
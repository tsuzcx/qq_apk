package com.tencent.timi.game.live.impl.danmuku.selector;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.TextShowInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuSelectDataBean;", "", "select", "", "data", "Ltrpc/yes/common/GameDataServerOuterClass$TextShowInfo;", "(ZLtrpc/yes/common/GameDataServerOuterClass$TextShowInfo;)V", "getData", "()Ltrpc/yes/common/GameDataServerOuterClass$TextShowInfo;", "getSelect", "()Z", "setSelect", "(Z)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class DanmakuSelectorView$DanmakuSelectDataBean
{
  private boolean a;
  @NotNull
  private final GameDataServerOuterClass.TextShowInfo b;
  
  public DanmakuSelectorView$DanmakuSelectDataBean(boolean paramBoolean, @NotNull GameDataServerOuterClass.TextShowInfo paramTextShowInfo)
  {
    this.a = paramBoolean;
    this.b = paramTextShowInfo;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final GameDataServerOuterClass.TextShowInfo b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView.DanmakuSelectDataBean
 * JD-Core Version:    0.7.0.1
 */
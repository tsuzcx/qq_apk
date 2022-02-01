package com.tencent.timi.game.live.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/IDanmaku;", "", "onDanmakuStart", "", "onDanmakuStop", "onDanmukuDestroy", "pushBigDanmaku", "txt", "", "pushDanmaku", "pushKtvDanmaku", "pushSelfDanmaku", "showDanmaku", "show", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDanmaku
{
  public abstract void a();
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.IDanmaku
 * JD-Core Version:    0.7.0.1
 */
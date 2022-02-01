package com.tencent.timi.game.live.impl.danmuku;

import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/danmuku/EsportsDanmakuView$reloadConfig$1", "Lcom/tencent/common/danmaku/inject/VideoDanmakuConfig$ILogger;", "d", "", "p0", "", "p1", "e", "p2", "", "i", "v", "w", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class EsportsDanmakuView$reloadConfig$1
  implements VideoDanmakuConfig.ILogger
{
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Logger.b(paramString1, paramString2);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "p2");
    Logger.a(paramString1, paramString2, paramThrowable);
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Logger.b(paramString1, paramString2);
  }
  
  public void c(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Logger.a(paramString1, paramString2);
  }
  
  public void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Logger.d(paramString1, paramString2);
  }
  
  public void e(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "p0");
    Intrinsics.checkParameterIsNotNull(paramString2, "p1");
    Logger.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.EsportsDanmakuView.reloadConfig.1
 * JD-Core Version:    0.7.0.1
 */
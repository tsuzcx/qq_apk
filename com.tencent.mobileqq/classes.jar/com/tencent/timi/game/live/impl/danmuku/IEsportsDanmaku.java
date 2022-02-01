package com.tencent.timi.game.live.impl.danmuku;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/IEsportsDanmaku;", "", "clear", "", "getView", "Landroid/view/View;", "onDestroy", "onStart", "onStop", "prepare", "sendKtv", "txt", "", "sendLargeCharacterTextDanmaku", "ctx", "Landroid/content/Context;", "txtColor", "", "priority", "sendTextDanmaku", "sendTextDanmakuWithBg", "start", "stop", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IEsportsDanmaku
{
  public abstract void a(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(@NotNull Context paramContext, @NotNull String paramString, int paramInt1, int paramInt2);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  @Nullable
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.IEsportsDanmaku
 * JD-Core Version:    0.7.0.1
 */
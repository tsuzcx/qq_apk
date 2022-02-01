package com.tencent.timi.game.live.impl;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/WifiOr4GStateHolder;", "", "()V", "TAG", "", "autoPlayIn4G", "", "use4GThisTime", "canPlayIn4G", "context", "Landroid/content/Context;", "setAutoPlayIn4G", "", "setUse4GThisTime", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WifiOr4GStateHolder
{
  public static final WifiOr4GStateHolder a = new WifiOr4GStateHolder();
  private static boolean b = TGSharedPreferenceUtil.b("live_auto_play_when_4g", false);
  private static boolean c;
  
  public final void a()
  {
    c = true;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    boolean bool;
    if ((NetworkUtil.isMobileNetWork(paramContext)) && (!b) && (!c)) {
      bool = false;
    } else {
      bool = true;
    }
    paramContext = new StringBuilder();
    paramContext.append("canPlayIn4G: ");
    paramContext.append(bool);
    paramContext.append(' ');
    paramContext.append(b);
    paramContext.append(' ');
    paramContext.append(c);
    Logger.a("WifiOr4GStateHolder", paramContext.toString());
    return bool;
  }
  
  public final void b()
  {
    b = true;
    TGSharedPreferenceUtil.a("live_auto_play_when_4g", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.WifiOr4GStateHolder
 * JD-Core Version:    0.7.0.1
 */
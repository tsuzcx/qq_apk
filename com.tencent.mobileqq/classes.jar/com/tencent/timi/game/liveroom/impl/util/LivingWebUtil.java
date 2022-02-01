package com.tencent.timi.game.liveroom.impl.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/util/LivingWebUtil;", "", "()V", "jumpToWeb", "", "context", "Landroid/content/Context;", "url", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingWebUtil
{
  public static final LivingWebUtil a = new LivingWebUtil();
  
  public final void a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("ishiderefresh", true);
    localIntent.putExtra("ishidebackforward", true);
    paramContext.startActivity(localIntent.putExtra("url", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.util.LivingWebUtil
 * JD-Core Version:    0.7.0.1
 */
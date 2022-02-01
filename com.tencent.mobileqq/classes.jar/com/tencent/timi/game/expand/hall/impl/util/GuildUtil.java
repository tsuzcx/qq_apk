package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/util/GuildUtil;", "", "()V", "isGuildOwnerOrAdm", "", "appRuntime", "Lmqq/app/AppRuntime;", "guildId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildUtil
{
  public static final GuildUtil a = new GuildUtil();
  
  public final boolean a(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    Intrinsics.checkParameterIsNotNull(paramString, "guildId");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    paramAppRuntime = ((IGPSService)paramAppRuntime).getGuildInfo(paramString);
    boolean bool = true;
    if ((paramAppRuntime == null) || (paramAppRuntime.getUserType() != 1))
    {
      if ((paramAppRuntime != null) && (paramAppRuntime.getUserType() == 2)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.GuildUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.Logger;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/impl/TimiGameJumpAction;", "Lcom/tencent/mobileqq/utils/JumpAction;", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "ctx", "Landroid/content/Context;", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "doAction", "", "parseGuildParams", "", "openParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "parseParams", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameJumpAction
  extends JumpAction
{
  public static final TimiGameJumpAction.Companion H = new TimiGameJumpAction.Companion(null);
  
  public TimiGameJumpAction(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
    this.d = "esports";
    this.e = "open";
  }
  
  private final void b(ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Object localObject1 = (String)this.f.get("guildid");
    Long localLong = null;
    if (localObject1 != null) {
      localObject1 = StringsKt.toLongOrNull((String)localObject1);
    } else {
      localObject1 = null;
    }
    String str1 = (String)this.f.get("channelname");
    String str2 = (String)this.f.get("channelicon");
    String str3 = (String)this.f.get("channelid");
    Object localObject2 = (String)this.f.get("teamid");
    if (localObject2 != null) {
      localObject2 = StringsKt.toLongOrNull((String)localObject2);
    } else {
      localObject2 = null;
    }
    Object localObject3 = (String)this.f.get("roomid");
    if (localObject3 != null) {
      localLong = StringsKt.toLongOrNull((String)localObject3);
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("parseGuildParams guildId:");
    ((StringBuilder)localObject3).append(localObject1);
    ((StringBuilder)localObject3).append(", channelName:");
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append(',');
    ((StringBuilder)localObject3).append(" channelIcon:");
    ((StringBuilder)localObject3).append(str2);
    ((StringBuilder)localObject3).append(", channelId:");
    ((StringBuilder)localObject3).append(str3);
    ((StringBuilder)localObject3).append(',');
    ((StringBuilder)localObject3).append(" teamId:");
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append(" roomId:");
    ((StringBuilder)localObject3).append(localLong);
    Logger.a("TimiGameJumpAction_", ((StringBuilder)localObject3).toString());
    if (localObject1 != null) {
      paramExpandHallLaunchParam.c = ((Number)localObject1).longValue();
    }
    if (str1 != null) {
      paramExpandHallLaunchParam.d = URLDecoder.decode(str1);
    }
    if (str2 != null) {
      paramExpandHallLaunchParam.e = URLDecoder.decode(str2);
    }
    paramExpandHallLaunchParam.f = str3;
    if (localObject2 != null) {
      paramExpandHallLaunchParam.g = ((Number)localObject2).longValue();
    }
    if (localLong != null) {
      paramExpandHallLaunchParam.i = ((Number)localLong).longValue();
    }
  }
  
  public final void a(@NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "openParam");
    Object localObject1 = (String)this.f.get("roomtype");
    Integer localInteger = null;
    if (localObject1 != null) {
      localObject1 = StringsKt.toIntOrNull((String)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = (String)this.f.get("entryscene");
    if (localObject2 != null) {
      localInteger = StringsKt.toIntOrNull((String)localObject2);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doAction roomType:");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", entryScene:");
    ((StringBuilder)localObject2).append(localInteger);
    Logger.a("TimiGameJumpAction_", ((StringBuilder)localObject2).toString());
    if (((localObject1 != null) && (((Integer)localObject1).intValue() == 1)) || ((localObject1 != null) && (((Integer)localObject1).intValue() == 2))) {
      paramExpandHallLaunchParam.b = ((Integer)localObject1).intValue();
    }
    if (((localInteger != null) && (localInteger.intValue() == 1)) || ((localInteger != null) && (localInteger.intValue() == 2))) {
      paramExpandHallLaunchParam.a = localInteger.intValue();
    }
    if (paramExpandHallLaunchParam.a == 2) {
      b(paramExpandHallLaunchParam);
    }
  }
  
  public boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAction attrs:");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(", source:");
    ((StringBuilder)localObject).append(this.c);
    Logger.a("TimiGameJumpAction_", ((StringBuilder)localObject).toString());
    localObject = new ExpandHallLaunchParam();
    a((ExpandHallLaunchParam)localObject);
    ITimiGameApi localITimiGameApi = (ITimiGameApi)QRoute.api(ITimiGameApi.class);
    Context localContext = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localITimiGameApi.openExpandHall(localContext, (ExpandHallLaunchParam)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameJumpAction
 * JD-Core Version:    0.7.0.1
 */
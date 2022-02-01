package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/impl/TimiGameTeamJoinAction;", "Lcom/tencent/mobileqq/utils/JumpAction;", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "ctx", "Landroid/content/Context;", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "doAction", "", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTeamJoinAction
  extends JumpAction
{
  public static final TimiGameTeamJoinAction.Companion H = new TimiGameTeamJoinAction.Companion(null);
  
  public TimiGameTeamJoinAction(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
    this.d = "esports";
    this.e = "team/join";
  }
  
  public boolean a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doAction attrs:");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append(", source:");
    ((StringBuilder)localObject1).append(this.c);
    Logger.a("TimiGameTeamJoinAction_", ((StringBuilder)localObject1).toString());
    localObject1 = (String)this.f.get("guildid");
    long l4 = 0L;
    if (localObject1 != null)
    {
      localObject1 = StringsKt.toLongOrNull((String)localObject1);
      if (localObject1 != null)
      {
        l1 = ((Long)localObject1).longValue();
        break label100;
      }
    }
    long l1 = 0L;
    label100:
    localObject1 = (String)this.f.get("channelname");
    Object localObject2 = (String)this.f.get("channelid");
    if (localObject2 != null)
    {
      localObject2 = StringsKt.toLongOrNull((String)localObject2);
      if (localObject2 != null)
      {
        l2 = ((Long)localObject2).longValue();
        break label156;
      }
    }
    long l2 = 0L;
    label156:
    localObject2 = (String)this.f.get("teamid");
    long l3 = l4;
    if (localObject2 != null)
    {
      localObject2 = StringsKt.toLongOrNull((String)localObject2);
      l3 = l4;
      if (localObject2 != null) {
        l3 = ((Long)localObject2).longValue();
      }
    }
    localObject1 = new GuildShequnParams(l1, l2, (String)localObject1);
    ((IniterService)ServiceCenter.a(IniterService.class)).a((InitCallback)new TimiGameTeamJoinAction.doAction.1(l3, (GuildShequnParams)localObject1, 0L));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamJoinAction
 * JD-Core Version:    0.7.0.1
 */
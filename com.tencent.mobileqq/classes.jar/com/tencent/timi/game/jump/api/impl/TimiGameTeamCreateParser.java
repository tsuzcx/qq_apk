package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/impl/TimiGameTeamCreateParser;", "Lcom/tencent/timi/game/jump/api/impl/TimiGameParserBase;", "()V", "getJumpAction", "Lcom/tencent/mobileqq/utils/JumpAction;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTeamCreateParser
  extends TimiGameParserBase
{
  public static final TimiGameTeamCreateParser.Companion a = new TimiGameTeamCreateParser.Companion(null);
  
  @NotNull
  public JumpAction a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext)
  {
    return (JumpAction)new TimiGameTeamCreateAction(paramBaseQQAppInterface, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamCreateParser
 * JD-Core Version:    0.7.0.1
 */
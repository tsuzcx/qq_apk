package com.tencent.timi.game.jump.api;

import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/ITimiGameParserFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getJumpParserClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/JumpParserBase;", "getTeamCreateParserClass", "getTeamJoinParserClass", "timi-game-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ITimiGameParserFactory
  extends QRouteApi
{
  @NotNull
  public abstract Class<? extends JumpParserBase> getJumpParserClass();
  
  @NotNull
  public abstract Class<? extends JumpParserBase> getTeamCreateParserClass();
  
  @NotNull
  public abstract Class<? extends JumpParserBase> getTeamJoinParserClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.ITimiGameParserFactory
 * JD-Core Version:    0.7.0.1
 */
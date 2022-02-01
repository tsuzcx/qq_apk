package com.tencent.timi.game.jump.api.impl;

import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.timi.game.jump.api.ITimiGameParserFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/impl/TimiGameParserFactoryImpl;", "Lcom/tencent/timi/game/jump/api/ITimiGameParserFactory;", "()V", "getJumpParserClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/JumpParserBase;", "getTeamCreateParserClass", "getTeamJoinParserClass", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameParserFactoryImpl
  implements ITimiGameParserFactory
{
  @NotNull
  public Class<? extends JumpParserBase> getJumpParserClass()
  {
    return TimiGameJumpParser.class;
  }
  
  @NotNull
  public Class<? extends JumpParserBase> getTeamCreateParserClass()
  {
    return TimiGameTeamCreateParser.class;
  }
  
  @NotNull
  public Class<? extends JumpParserBase> getTeamJoinParserClass()
  {
    return TimiGameTeamJoinParser.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameParserFactoryImpl
 * JD-Core Version:    0.7.0.1
 */
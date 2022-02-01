package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/triton/game/GameLauncher$onSubpackageLoaded$1$1"}, k=3, mv={1, 1, 16})
final class GameLauncher$onSubpackageLoaded$$inlined$let$lambda$1
  implements Runnable
{
  GameLauncher$onSubpackageLoaded$$inlined$let$lambda$1(SubpackageLoadStatisticsCallback paramSubpackageLoadStatisticsCallback, GameLauncher paramGameLauncher, String paramString, ScriptLoadStatistic paramScriptLoadStatistic) {}
  
  public final void run()
  {
    this.$it.onSubpackageLoaded(this.$name$inlined, this.$statistics$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.onSubpackageLoaded..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/game/GameLauncher$Companion;", "", "()V", "ENV_VERSION_PREFIX", "", "GAME_JSON_PREFIX", "INIT_JSLIB", "INIT_WXCONFIG", "TAG", "WINDOW_UNDEFINED", "isAllSuccess", "", "statics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Triton_release"}, k=1, mv={1, 1, 16})
public final class GameLauncher$Companion
{
  private final boolean isAllSuccess(List<ScriptLoadStatistic> paramList)
  {
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      paramList = (Iterable)paramList;
      if (((paramList instanceof Collection)) && (((Collection)paramList).isEmpty())) {}
      do
      {
        while (!paramList.hasNext())
        {
          i = 1;
          break;
          paramList = paramList.iterator();
        }
      } while (((ScriptLoadStatistic)paramList.next()).getLoadResult().isSuccess());
      int i = 0;
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.Companion
 * JD-Core Version:    0.7.0.1
 */
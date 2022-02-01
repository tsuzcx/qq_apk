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
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      paramList = (Iterable)paramList;
      if ((!(paramList instanceof Collection)) || (!((Collection)paramList).isEmpty())) {
        break label55;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label99;
      }
      return true;
      i = 0;
      break;
      label55:
      paramList = paramList.iterator();
      for (;;)
      {
        if (paramList.hasNext()) {
          if (!((ScriptLoadStatistic)paramList.next()).getLoadResult().isSuccess())
          {
            i = 0;
            break;
          }
        }
      }
      i = 1;
    }
    label99:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.Companion
 * JD-Core Version:    0.7.0.1
 */
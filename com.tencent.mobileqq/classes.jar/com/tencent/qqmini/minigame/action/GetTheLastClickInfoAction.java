package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class GetTheLastClickInfoAction
  implements Action<String>
{
  public String perform(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime instanceof GameRuntime)) {
      return ((GameRuntime)paramBaseRuntime).getTheLastClickInfo();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.action.GetTheLastClickInfoAction
 * JD-Core Version:    0.7.0.1
 */
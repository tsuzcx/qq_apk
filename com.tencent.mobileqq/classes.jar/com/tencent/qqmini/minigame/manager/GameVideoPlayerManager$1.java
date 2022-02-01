package com.tencent.qqmini.minigame.manager;

import android.view.ViewGroup;
import com.tencent.qqmini.minigame.GamePage;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

final class GameVideoPlayerManager$1
  implements Action<ViewGroup>
{
  public ViewGroup perform(BaseRuntime paramBaseRuntime)
  {
    return ((GamePage)paramBaseRuntime.getPage()).getGameContainerView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameVideoPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.minigame.manager;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class GameVideoPlayerManager
{
  private static final String TAG = "GameVideoPlayerManager";
  private static final Action<ViewGroup> getAdViewContainerAction = new GameVideoPlayerManager.1();
  
  public static void addPlayerView(IMiniAppContext paramIMiniAppContext, ViewGroup paramViewGroup)
  {
    paramIMiniAppContext = (ViewGroup)paramIMiniAppContext.performAction(getAdViewContainerAction);
    if (paramIMiniAppContext == null)
    {
      QMLog.e("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    paramIMiniAppContext.addView(paramViewGroup);
  }
  
  public static void removeView(IMiniAppContext paramIMiniAppContext, View paramView)
  {
    paramIMiniAppContext = (ViewGroup)paramIMiniAppContext.performAction(getAdViewContainerAction);
    if (paramIMiniAppContext == null)
    {
      QMLog.e("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    paramIMiniAppContext.removeView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameVideoPlayerManager
 * JD-Core Version:    0.7.0.1
 */
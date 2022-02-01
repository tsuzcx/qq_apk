package com.tencent.mobileqq.triton.sdk.game;

import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;

public class GameLaunchParam
{
  public final MiniGameInfo gameInfo;
  public final GameLaunchCallback gameLaunchCallback;
  public final InspectorAgent inspectorAgent;
  
  GameLaunchParam(MiniGameInfo paramMiniGameInfo, GameLaunchCallback paramGameLaunchCallback, InspectorAgent paramInspectorAgent)
  {
    this.gameInfo = paramMiniGameInfo;
    this.gameLaunchCallback = paramGameLaunchCallback;
    this.inspectorAgent = paramInspectorAgent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.GameLaunchParam
 * JD-Core Version:    0.7.0.1
 */
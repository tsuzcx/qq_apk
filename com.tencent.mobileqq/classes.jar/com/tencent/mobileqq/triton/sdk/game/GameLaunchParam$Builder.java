package com.tencent.mobileqq.triton.sdk.game;

import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;

public class GameLaunchParam$Builder
{
  private MiniGameInfo mGameInfo;
  private GameLaunchCallback mGameLaunchCallback;
  private InspectorAgent mInspectorAgent;
  
  public GameLaunchParam build()
  {
    MiniGameInfo localMiniGameInfo = this.mGameInfo;
    if (localMiniGameInfo != null)
    {
      GameLaunchCallback localGameLaunchCallback = this.mGameLaunchCallback;
      if (localGameLaunchCallback != null) {
        return new GameLaunchParam(localMiniGameInfo, localGameLaunchCallback, this.mInspectorAgent);
      }
      throw new IllegalArgumentException("mGameLaunchCallback == null");
    }
    throw new IllegalArgumentException("mGameInfo == null");
  }
  
  public Builder setGameInfo(MiniGameInfo paramMiniGameInfo)
  {
    this.mGameInfo = paramMiniGameInfo;
    return this;
  }
  
  public Builder setGameLaunchCallback(GameLaunchCallback paramGameLaunchCallback)
  {
    this.mGameLaunchCallback = paramGameLaunchCallback;
    return this;
  }
  
  public Builder setInspectorAgent(InspectorAgent paramInspectorAgent)
  {
    this.mInspectorAgent = paramInspectorAgent;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.GameLaunchParam.Builder
 * JD-Core Version:    0.7.0.1
 */
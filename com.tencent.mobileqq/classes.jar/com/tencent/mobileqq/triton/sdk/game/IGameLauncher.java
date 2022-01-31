package com.tencent.mobileqq.triton.sdk.game;

import android.support.annotation.NonNull;

public abstract interface IGameLauncher
{
  public abstract MiniGameInfo getCurrentGame();
  
  public abstract GamePluginInfo getGamePluginInfo(@NonNull String paramString);
  
  public abstract int launchGame();
  
  public abstract boolean launchSubpackage(@NonNull String paramString);
  
  public abstract void setCurrentGame(MiniGameInfo paramMiniGameInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.IGameLauncher
 * JD-Core Version:    0.7.0.1
 */
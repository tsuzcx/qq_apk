package com.tencent.qqmini.minigame;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator;

final class GameRuntimeLoader$1
  implements BaseRuntimeLoader.Creator<GameRuntimeLoader>
{
  public GameRuntimeLoader create(Context paramContext, Bundle paramBundle)
  {
    return new GameRuntimeLoader(paramContext, null);
  }
  
  public void doPrepareEngine(Bundle paramBundle) {}
  
  public boolean isEnginePrepared(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean support(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.isEngineTypeMiniGame());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntimeLoader.1
 * JD-Core Version:    0.7.0.1
 */
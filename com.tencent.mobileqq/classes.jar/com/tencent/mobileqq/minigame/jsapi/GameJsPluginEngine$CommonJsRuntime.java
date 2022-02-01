package com.tencent.mobileqq.minigame.jsapi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.PluginLogger;
import com.tencent.mobileqq.triton.script.Argument;

class GameJsPluginEngine$CommonJsRuntime
  extends GameJsRuntime
{
  public GameJsPluginEngine$CommonJsRuntime(GameJsPluginEngine paramGameJsPluginEngine, @NonNull Argument paramArgument, @NonNull PluginLogger paramPluginLogger)
  {
    super(paramArgument, paramPluginLogger);
  }
  
  private void onInvokeForbiddenMethod(String paramString)
  {
    GameLog.getInstance().e("GameJsPluginEngine", "can not invoke " + paramString + " on minigame common JsRuntime");
  }
  
  public void evaluateCallbackJs(int paramInt, @Nullable String paramString)
  {
    onInvokeForbiddenMethod("evaluateCallbackJs");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine.CommonJsRuntime
 * JD-Core Version:    0.7.0.1
 */
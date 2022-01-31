package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.Context;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;

class LifeCyclePlugin$1
  implements GameLifecycle
{
  LifeCyclePlugin$1(LifeCyclePlugin paramLifeCyclePlugin) {}
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
  
  public void onGameLaunched()
  {
    GameLog.getInstance().i("LifeCyclePlugin", "--onGameLaunched--");
    this.this$0.onForeground();
  }
  
  public void onPause()
  {
    this.this$0.onBackground();
  }
  
  public void onResume()
  {
    this.this$0.onForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.LifeCyclePlugin.1
 * JD-Core Version:    0.7.0.1
 */
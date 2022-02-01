package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;

public class GameJsPluginEngineTask
  extends AsyncTask
{
  private final String TAG = toString();
  private GameJsPluginEngine mGameJsPluginEngine;
  
  public GameJsPluginEngineTask(Context paramContext, GameJsPluginEngine paramGameJsPluginEngine)
  {
    super(paramContext);
    this.mGameJsPluginEngine = paramGameJsPluginEngine;
  }
  
  public void executeAsync()
  {
    if (this.mGameJsPluginEngine != null)
    {
      this.mGameJsPluginEngine.initJsPluginList();
      onTaskSucceed();
      return;
    }
    onTaskFailed(-1, "null GameJsPluginEngine configured");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask
 * JD-Core Version:    0.7.0.1
 */
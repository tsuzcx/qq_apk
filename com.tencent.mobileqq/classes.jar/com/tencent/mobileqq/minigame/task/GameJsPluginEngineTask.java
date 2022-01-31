package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;

public class GameJsPluginEngineTask
  extends AsyncTask
{
  private static final String TAG = "GameJsPluginEngineTask";
  private static volatile GameJsPluginEngineTask instance;
  private GameJsPluginEngine mGameJsPluginEngine;
  
  private GameJsPluginEngineTask(Context paramContext)
  {
    super(paramContext);
    GameLog.getInstance().i("GameJsPluginEngineTask", "constructor");
  }
  
  public static GameJsPluginEngineTask g(Context paramContext)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameJsPluginEngineTask(paramContext);
      }
      return instance;
    }
    finally {}
  }
  
  public void executeAsync()
  {
    if (this.mGameJsPluginEngine != null)
    {
      this.mGameJsPluginEngine.initJsPluginList();
      onTaskSucceed();
      return;
    }
    onTaskFailed();
  }
  
  public GameJsPluginEngine getJsPluginEngine()
  {
    return this.mGameJsPluginEngine;
  }
  
  public void setJsPluginEngine(GameJsPluginEngine paramGameJsPluginEngine)
  {
    if (this.mGameJsPluginEngine == null) {
      this.mGameJsPluginEngine = paramGameJsPluginEngine;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameJsPluginEngineTask
 * JD-Core Version:    0.7.0.1
 */
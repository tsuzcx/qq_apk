package com.tencent.mobileqq.minigame.manager;

import android.content.Context;
import bgln;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import mqq.os.MqqHandler;

public class GameRuntimeLoaderManager
{
  private static final int LEVEL_HIGH = 1;
  private static final int LEVEL_LOW = 3;
  private static final int LEVEL_MEDIUM = 2;
  private static final int LEVEL_UNKNOWN = 0;
  private static final String TAG = "GameRuntimeLoaderManager";
  private static volatile GameRuntimeLoaderManager sInstance;
  private volatile boolean mHasRuntimeLoaderObtained;
  private int mPerfLevel = bgln.f();
  private ConcurrentMap<Context, GameRuntimeLoader> mRuntimeLoaderMap;
  private ConcurrentLinkedQueue<GameRuntimeLoader> mRuntimeLoaders;
  
  private GameRuntimeLoaderManager()
  {
    if (this.mPerfLevel == 0) {
      this.mPerfLevel = 2;
    }
    this.mRuntimeLoaders = new ConcurrentLinkedQueue();
    this.mRuntimeLoaderMap = new ConcurrentHashMap();
    this.mHasRuntimeLoaderObtained = false;
  }
  
  public static GameRuntimeLoaderManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new GameRuntimeLoaderManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public GameRuntimeLoader getBindRuntimeLoader(Context paramContext)
  {
    return (GameRuntimeLoader)this.mRuntimeLoaderMap.get(paramContext);
  }
  
  public GameRuntimeLoader obtain(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("can't obtain GameRuntimeLoader for null Activity");
      }
      finally {}
    }
    if (this.mRuntimeLoaderMap.containsKey(paramContext)) {
      paramContext = (GameRuntimeLoader)this.mRuntimeLoaderMap.get(paramContext);
    }
    for (;;)
    {
      return paramContext;
      if (this.mRuntimeLoaders.isEmpty()) {
        prepare(BaseApplicationImpl.getApplication(), GameRuntimeLoaderManager.PREPARE_FROM.AUTO_PREPARE);
      }
      GameRuntimeLoader localGameRuntimeLoader = (GameRuntimeLoader)this.mRuntimeLoaders.poll();
      this.mRuntimeLoaderMap.put(paramContext, localGameRuntimeLoader);
      this.mHasRuntimeLoaderObtained = true;
      paramContext = localGameRuntimeLoader;
      if (GameWnsUtils.enableGameruntimePreload())
      {
        paramContext = localGameRuntimeLoader;
        if (this.mRuntimeLoaders.isEmpty())
        {
          int i = this.mPerfLevel * 500;
          ThreadManager.getSubThreadHandler().postDelayed(new GameRuntimeLoaderManager.1(this), i);
          GameLog.getInstance().i("GameRuntimeLoaderManager", "prepare next GameRuntimeLoader after:" + i + "ms");
          paramContext = localGameRuntimeLoader;
        }
      }
    }
  }
  
  public void prepare(Context paramContext, GameRuntimeLoaderManager.PREPARE_FROM paramPREPARE_FROM)
  {
    if (paramContext == null) {
      try
      {
        throw new IllegalArgumentException("can't prepare GameRuntimeLoader with null context");
      }
      finally {}
    }
    if (!this.mRuntimeLoaders.isEmpty()) {
      GameLog.getInstance().i("GameRuntimeLoaderManager", "already preloaded GameRuntimeLoader, skip!!");
    }
    for (;;)
    {
      return;
      if ((paramPREPARE_FROM.equals(GameRuntimeLoaderManager.PREPARE_FROM.MAIN_PROCESS)) && (this.mHasRuntimeLoaderObtained))
      {
        GameLog.getInstance().i("GameRuntimeLoaderManager", "call prepare after hasRuntimeLoaderObtained, skip!!");
      }
      else
      {
        paramContext = new GameRuntimeLoader(paramContext, paramPREPARE_FROM);
        GameLog.getInstance().i("GameRuntimeLoaderManager", "prepare " + paramContext);
        paramContext.prepare();
        this.mRuntimeLoaders.add(paramContext);
      }
    }
  }
  
  public void reBindRuntimeLoader(GameRuntimeLoader paramGameRuntimeLoader, Context paramContext)
  {
    if ((paramContext != null) && (paramGameRuntimeLoader != null) && (this.mRuntimeLoaderMap.containsValue(paramGameRuntimeLoader)))
    {
      Iterator localIterator = this.mRuntimeLoaderMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getValue() != null) && (localEntry.getValue() == paramGameRuntimeLoader)) {
          localIterator.remove();
        }
      }
      this.mRuntimeLoaderMap.put(paramContext, paramGameRuntimeLoader);
    }
  }
  
  public void unbindAndRemove(Context paramContext)
  {
    if (paramContext != null) {
      this.mRuntimeLoaderMap.remove(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager
 * JD-Core Version:    0.7.0.1
 */
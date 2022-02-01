package com.tencent.mtt.hippy.common;

import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreadExecutorManager
  implements ThreadExecutor.UncaughtExceptionHandler
{
  private static ThreadExecutorManager sInstance;
  private final HashMap<Integer, ArrayList<Integer>> mEngineMap = new HashMap();
  private final HashMap<Integer, ThreadExecutor> mThreadExecutorMap = new HashMap();
  
  private void destroyThreadExecutor(Integer paramInteger)
  {
    if (this.mThreadExecutorMap.containsKey(paramInteger))
    {
      ThreadExecutor localThreadExecutor = (ThreadExecutor)this.mThreadExecutorMap.get(paramInteger);
      if (localThreadExecutor != null) {
        localThreadExecutor.destroy();
      }
      this.mThreadExecutorMap.remove(paramInteger);
    }
  }
  
  public static ThreadExecutorManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ThreadExecutorManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void handleExceptionImpl(Thread paramThread, Throwable paramThrowable, Integer paramInteger)
  {
    try
    {
      int i = paramInteger.intValue();
      if (i < 0) {
        return;
      }
      destroyThreadExecutor(paramInteger);
      this.mEngineMap.remove(paramInteger);
      return;
    }
    finally {}
  }
  
  public void add(HippyEngine paramHippyEngine)
  {
    try
    {
      Object localObject1 = Integer.valueOf(paramHippyEngine.getGroupId());
      int i = ((Integer)localObject1).intValue();
      if (i < 0) {
        return;
      }
      try
      {
        if ((ThreadExecutor)this.mThreadExecutorMap.get(localObject1) == null)
        {
          localObject2 = new ThreadExecutor(((Integer)localObject1).intValue());
          ((ThreadExecutor)localObject2).setUncaughtExceptionHandler(this);
          this.mThreadExecutorMap.put(localObject1, localObject2);
        }
        paramHippyEngine = Integer.valueOf(paramHippyEngine.getId());
        Object localObject2 = (ArrayList)this.mEngineMap.get(localObject1);
        if (localObject2 == null)
        {
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(paramHippyEngine);
          this.mEngineMap.put(localObject1, localObject2);
        }
        else if (!((ArrayList)localObject2).contains(paramHippyEngine))
        {
          ((ArrayList)localObject2).add(paramHippyEngine);
        }
        else
        {
          LogUtils.e("Hippy", "add same engine twice");
        }
      }
      catch (Exception paramHippyEngine)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("add: ");
        ((StringBuilder)localObject1).append(paramHippyEngine.getMessage());
        LogUtils.d("ThreadExecutorManager", ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
  }
  
  public ThreadExecutor getThreadExecutor(int paramInt)
  {
    try
    {
      ThreadExecutor localThreadExecutor = (ThreadExecutor)this.mThreadExecutorMap.get(Integer.valueOf(paramInt));
      return localThreadExecutor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void handleThreadUncaughtException(Thread paramThread, Throwable paramThrowable, Integer paramInteger)
  {
    handleExceptionImpl(paramThread, paramThrowable, paramInteger);
  }
  
  public void remove(HippyEngine paramHippyEngine)
  {
    try
    {
      Object localObject = Integer.valueOf(paramHippyEngine.getGroupId());
      int i = ((Integer)localObject).intValue();
      if (i < 0) {
        return;
      }
      try
      {
        ArrayList localArrayList = (ArrayList)this.mEngineMap.get(localObject);
        if (localArrayList == null)
        {
          destroyThreadExecutor((Integer)localObject);
          return;
        }
        localArrayList.remove(Integer.valueOf(paramHippyEngine.getId()));
        if (localArrayList.size() <= 0)
        {
          this.mEngineMap.remove(localObject);
          destroyThreadExecutor((Integer)localObject);
        }
      }
      catch (Exception paramHippyEngine)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove: ");
        ((StringBuilder)localObject).append(paramHippyEngine.getMessage());
        LogUtils.d("ThreadExecutorManager", ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.ThreadExecutorManager
 * JD-Core Version:    0.7.0.1
 */
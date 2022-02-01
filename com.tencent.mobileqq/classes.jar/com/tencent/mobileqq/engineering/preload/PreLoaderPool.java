package com.tencent.mobileqq.engineering.preload;

import com.tencent.mobileqq.engineering.preload.inter.IWorker;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PreLoaderPool
{
  private static PreLoaderPool sInstance;
  private final AtomicInteger mAtomicInteger = new AtomicInteger(100);
  private final ConcurrentHashMap<String, IWorker> workerMap = new ConcurrentHashMap();
  
  public static PreLoaderPool getInstance()
  {
    if (sInstance == null) {
      sInstance = new PreLoaderPool();
    }
    return sInstance;
  }
  
  private <T> String preLoadWorker(String paramString, Worker<T> paramWorker)
  {
    if (exists(paramString))
    {
      PreLoader.log("preLoader ID is used, please note that remove!");
      remove(paramString);
    }
    this.workerMap.put(paramString, paramWorker);
    paramWorker.doPreLoad();
    return paramString;
  }
  
  public boolean exists(String paramString)
  {
    return this.workerMap.containsKey(paramString);
  }
  
  public <T> String preLoad(String paramString, BasePreLoadTask<T> paramBasePreLoadTask)
  {
    int i = this.mAtomicInteger.getAndIncrement();
    return preLoadWorker(paramString, new Worker(paramString, paramBasePreLoadTask, (OnTaskListener)null, i));
  }
  
  public void remove(String paramString)
  {
    Object localObject = this.workerMap;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramString)))
    {
      try
      {
        localObject = (IWorker)this.workerMap.get(paramString);
        if (localObject != null) {
          ((IWorker)localObject).onRemove();
        }
      }
      catch (Exception localException)
      {
        PreLoader.log(localException);
      }
      this.workerMap.remove(paramString);
    }
  }
  
  public <T> void removeListener(String paramString, OnTaskListener<T> paramOnTaskListener)
  {
    try
    {
      paramString = (IWorker)this.workerMap.get(paramString);
      if (paramString != null)
      {
        paramString.removeListener(paramOnTaskListener);
        return;
      }
    }
    catch (Exception paramString)
    {
      PreLoader.log(paramString);
    }
  }
  
  public <T> void setListener(String paramString, OnTaskListener<T> paramOnTaskListener)
  {
    try
    {
      paramString = (IWorker)this.workerMap.get(paramString);
      if (paramString != null)
      {
        paramString.setListener(paramOnTaskListener);
        return;
      }
    }
    catch (Exception paramString)
    {
      PreLoader.log(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.PreLoaderPool
 * JD-Core Version:    0.7.0.1
 */
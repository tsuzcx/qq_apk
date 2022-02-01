package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

class SpCache
  implements ISpOperation
{
  private static final String TAG = "SpCache";
  private static volatile SpCache sInstance;
  private AnnotationProcessor mAnnotationProcessor = AnnotationProcessor.getInstance();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> mCache = new ConcurrentHashMap();
  private SpService mService;
  
  private SpCache(Context paramContext)
  {
    this.mService = new SpService(paramContext);
  }
  
  static SpCache getInstance(Context paramContext)
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new SpCache(paramContext);
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private <T> T operateSp(Callable<T> paramCallable)
  {
    if (!ThreadUtils.isMainThread()) {
      try
      {
        paramCallable = paramCallable.call();
        return paramCallable;
      }
      catch (Exception paramCallable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("operate sharedPreference exception: ");
        localStringBuilder.append(paramCallable.getLocalizedMessage());
        Log.e("SpCache", localStringBuilder.toString());
        return null;
      }
    }
    throw new RuntimeException("Cannot be called on the main thread!");
  }
  
  private void operateSp(Runnable paramRunnable)
  {
    operateSp(new SpCache.8(this, paramRunnable));
  }
  
  private <T> void sync(Class<T> paramClass)
  {
    String str = this.mAnnotationProcessor.getClassId(paramClass);
    if (!this.mCache.containsKey(str))
    {
      Object localObject = (List)operateSp(new SpCache.7(this, paramClass));
      paramClass = new ConcurrentHashMap();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        paramClass.put(localPair.first, localPair.second);
      }
      this.mCache.putIfAbsent(str, paramClass);
    }
  }
  
  public void clearCache()
  {
    synchronized (this.mCache)
    {
      this.mCache.clear();
      return;
    }
  }
  
  public void clearSp()
  {
    synchronized (this.mCache)
    {
      Iterator localIterator = this.mCache.values().iterator();
      while (localIterator.hasNext()) {
        ((ConcurrentHashMap)localIterator.next()).clear();
      }
      operateSp(new SpCache.6(this));
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public <T> boolean containsObject(Class<T> paramClass, String paramString)
  {
    sync(paramClass);
    return ((Map)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass))).containsKey(paramString);
  }
  
  public <T> void deleteAllObjects(Class<T> paramClass)
  {
    sync(paramClass);
    synchronized (this.mCache)
    {
      ((ConcurrentHashMap)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass))).clear();
      operateSp(new SpCache.4(this, paramClass));
      return;
    }
  }
  
  public <T> void deleteObject(Class<T> paramClass, String paramString)
  {
    sync(paramClass);
    synchronized (this.mCache)
    {
      ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass));
      if (localConcurrentHashMap2.containsKey(paramString))
      {
        localConcurrentHashMap2.remove(paramString);
        operateSp(new SpCache.3(this, paramClass, paramString));
      }
      return;
    }
  }
  
  public <T> void deleteObjects(Class<T> paramClass, Condition<T> paramCondition)
  {
    sync(paramClass);
    synchronized (this.mCache)
    {
      Object localObject = ((Map)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass))).entrySet();
      ArrayList localArrayList = new ArrayList();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((localEntry != null) && (localEntry.getKey() != null) && (localEntry.getValue() != null) && ((paramCondition == null) || (paramCondition.satisfy(paramClass.cast(localEntry.getValue()))))) {
          localArrayList.add(localEntry.getKey());
        }
      }
      if (!localArrayList.isEmpty()) {
        deleteObjects(paramClass, localArrayList);
      }
      return;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <T> void deleteObjects(Class<T> paramClass, List<String> paramList)
  {
    sync(paramClass);
    synchronized (this.mCache)
    {
      Map localMap = (Map)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str != null) {
          localMap.remove(str);
        }
      }
      operateSp(new SpCache.5(this, paramClass, paramList));
      return;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public <T> List<Pair<String, T>> getAllObjects(Class<T> paramClass)
  {
    sync(paramClass);
    Object localObject1 = this.mAnnotationProcessor.getClassId(paramClass);
    Object localObject2 = (ConcurrentHashMap)this.mCache.get(localObject1);
    localObject1 = new LinkedList();
    localObject2 = ((ConcurrentHashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((List)localObject1).add(new Pair(localEntry.getKey(), paramClass.cast(localEntry.getValue())));
    }
    return localObject1;
  }
  
  public <T> T getObject(Class<T> paramClass, String paramString)
  {
    sync(paramClass);
    String str = this.mAnnotationProcessor.getClassId(paramClass);
    return paramClass.cast(((ConcurrentHashMap)this.mCache.get(str)).get(paramString));
  }
  
  public <T> List<Pair<String, T>> getObjects(Class<T> paramClass, Condition<T> paramCondition)
  {
    sync(paramClass);
    Object localObject1 = (ConcurrentHashMap)this.mCache.get(this.mAnnotationProcessor.getClassId(paramClass));
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((ConcurrentHashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      if (localEntry != null)
      {
        Object localObject2 = paramClass.cast(localEntry.getValue());
        if ((localObject2 != null) && ((paramCondition == null) || (paramCondition.satisfy(localObject2)))) {
          localLinkedList.add(new Pair(localEntry.getKey(), localObject2));
        }
      }
    }
    return localLinkedList;
  }
  
  public <T> void insertObject(T paramT, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      sync(paramT.getClass());
      synchronized (this.mCache)
      {
        ((ConcurrentHashMap)this.mCache.get(this.mAnnotationProcessor.getClassId(paramT.getClass()))).put(paramString, paramT);
        operateSp(new SpCache.1(this, paramT, paramString));
        return;
      }
    }
    throw new IllegalArgumentException("Illegal object id!");
  }
  
  public <T> void insertObjects(List<T> paramList, List<String> paramList1)
  {
    if (paramList.size() == paramList1.size())
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = 0;
      Class localClass = paramList.get(0).getClass();
      sync(localClass);
      synchronized (this.mCache)
      {
        Object localObject1 = this.mAnnotationProcessor.getClassId(localClass);
        localObject1 = (Map)this.mCache.get(localObject1);
        int j = paramList.size();
        while (i < j)
        {
          String str = (String)paramList1.get(i);
          Object localObject2 = paramList.get(i);
          if ((localObject2 != null) && (!TextUtils.isEmpty(str)))
          {
            if (localObject2.getClass() == localClass)
            {
              ((Map)localObject1).put(str, localObject2);
              i += 1;
            }
            else
            {
              throw new IllegalArgumentException("Object type is different from others.");
            }
          }
          else {
            throw new IllegalArgumentException("Object is null or id is null.");
          }
        }
        operateSp(new SpCache.2(this, paramList, paramList1));
        return;
      }
    }
    paramList = new IllegalArgumentException("Two lists have different sizes.");
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.SpCache
 * JD-Core Version:    0.7.0.1
 */
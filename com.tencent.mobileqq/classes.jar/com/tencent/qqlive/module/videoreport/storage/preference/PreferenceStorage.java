package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.IDataStorage;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PreferenceStorage
  implements IDataStorage
{
  private static volatile PreferenceStorage sInstance;
  private AnnotationProcessor mAnnotationProcessor;
  private SpCache mCache;
  
  private PreferenceStorage(Context paramContext)
  {
    this.mCache = SpCache.getInstance(paramContext);
    this.mAnnotationProcessor = AnnotationProcessor.getInstance();
  }
  
  public static PreferenceStorage getInstance(Context paramContext)
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new PreferenceStorage(paramContext);
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void clear()
  {
    this.mCache.clearSp();
  }
  
  public <T> boolean contains(Class<T> paramClass, String paramString)
  {
    return this.mCache.containsObject(paramClass, paramString);
  }
  
  public <T> boolean contains(T paramT)
  {
    String str = this.mAnnotationProcessor.getObjectId(paramT);
    return contains(paramT.getClass(), str);
  }
  
  public <T> void delete(Class<T> paramClass, Condition<T> paramCondition)
  {
    this.mCache.deleteObjects(paramClass, paramCondition);
  }
  
  public <T> void delete(Class<T> paramClass, String paramString)
  {
    this.mCache.deleteObject(paramClass, paramString);
  }
  
  public <T> void delete(Class<T> paramClass, List<String> paramList)
  {
    this.mCache.deleteObjects(paramClass, paramList);
  }
  
  public <T> void delete(T paramT)
  {
    String str = this.mAnnotationProcessor.getObjectId(paramT);
    this.mCache.deleteObject(paramT.getClass(), str);
  }
  
  public <T> void delete(List<T> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject = new ArrayList();
    Class localClass = paramList.get(0).getClass();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if ((paramList != null) && (paramList.getClass() == localClass))
      {
        ((List)localObject).add(this.mAnnotationProcessor.getObjectId(paramList));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Element ");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(" has the different type from others.");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    delete(localClass, (List)localObject);
  }
  
  public <T> void deleteAll(Class<T> paramClass)
  {
    this.mCache.deleteAllObjects(paramClass);
  }
  
  public <T> T load(Class<T> paramClass, String paramString)
  {
    return this.mCache.getObject(paramClass, paramString);
  }
  
  public <T> List<T> load(Class<T> paramClass, Condition<T> paramCondition)
  {
    paramCondition = this.mCache.getObjects(paramClass, paramCondition);
    paramClass = new ArrayList();
    paramCondition = paramCondition.iterator();
    while (paramCondition.hasNext()) {
      paramClass.add(((Pair)paramCondition.next()).second);
    }
    return paramClass;
  }
  
  public <T> List<T> load(Class<T> paramClass, List<String> paramList)
  {
    paramList = this.mCache.getObjects(paramClass, new PreferenceStorage.1(this, paramList));
    paramClass = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Pair)paramList.next()).second);
    }
    return paramClass;
  }
  
  public <T> List<T> loadAll(Class<T> paramClass)
  {
    Object localObject = this.mCache.getAllObjects(paramClass);
    paramClass = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramClass.add(((Pair)((Iterator)localObject).next()).second);
    }
    return paramClass;
  }
  
  public <T> void storeOrUpdate(T paramT)
  {
    storeOrUpdate(paramT, this.mAnnotationProcessor.getObjectId(paramT));
  }
  
  public <T> void storeOrUpdate(T paramT, String paramString)
  {
    this.mCache.insertObject(paramT, paramString);
  }
  
  public <T> void storeOrUpdate(List<T> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      String str = this.mAnnotationProcessor.getObjectId(localObject);
      if (str != null)
      {
        localArrayList.add(str);
      }
      else
      {
        paramList = new StringBuilder();
        paramList.append("Element ");
        paramList.append(localObject);
        paramList.append(" has not initialized its ID.");
        throw new IllegalArgumentException(paramList.toString());
      }
    }
    storeOrUpdate(paramList, localArrayList);
  }
  
  public <T> void storeOrUpdate(List<T> paramList, List<String> paramList1)
  {
    this.mCache.insertObjects(paramList, paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.PreferenceStorage
 * JD-Core Version:    0.7.0.1
 */
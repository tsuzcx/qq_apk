package com.tencent.mtt.hippy.modules.nativemodules.storage;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageKeyValue;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.ArrayList;

@HippyNativeModule(name="StorageModule")
public class StorageModule
  extends HippyNativeModuleBase
{
  private HippyStorageAdapter a;
  
  public StorageModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.a = paramHippyEngineContext.getGlobalConfigs().getStorageAdapter();
  }
  
  @HippyMethod(name="getAllKeys")
  public void getAllKeys(Promise paramPromise)
  {
    if (this.a == null)
    {
      paramPromise.reject("Database Null");
      return;
    }
    this.a.getAllKeys(new StorageModule.4(this, paramPromise));
  }
  
  @HippyMethod(name="multiGet")
  public void multiGet(HippyArray paramHippyArray, Promise paramPromise)
  {
    if ((paramHippyArray == null) || (paramHippyArray.size() <= 0))
    {
      paramPromise.reject("Invalid Key");
      return;
    }
    if (this.a == null)
    {
      paramPromise.reject("Database Null");
      return;
    }
    this.a.multiGet(paramHippyArray, new StorageModule.1(this, paramPromise));
  }
  
  @HippyMethod(name="multiRemove")
  public void multiRemove(HippyArray paramHippyArray, Promise paramPromise)
  {
    if ((paramHippyArray == null) || (paramHippyArray.size() == 0))
    {
      paramPromise.reject("Invalid key");
      return;
    }
    if (this.a == null)
    {
      paramPromise.reject("Database Null");
      return;
    }
    this.a.multiRemove(paramHippyArray, new StorageModule.3(this, paramPromise));
  }
  
  @HippyMethod(name="multiSet")
  public void multiSet(HippyArray paramHippyArray, Promise paramPromise)
  {
    int i = 0;
    if ((paramHippyArray == null) || (paramHippyArray.size() <= 0))
    {
      paramPromise.reject("Invalid Value");
      return;
    }
    if (this.a == null)
    {
      paramPromise.reject("Database Null");
      return;
    }
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        localArrayList = new ArrayList();
        if (i >= paramHippyArray.size()) {
          break;
        }
        localObject = paramHippyArray.getArray(i);
        if (localObject == null)
        {
          paramPromise.reject("Invalid Value");
          return;
        }
      }
      catch (Throwable paramHippyArray)
      {
        paramPromise.reject(paramHippyArray.getMessage());
        return;
      }
      if (((HippyArray)localObject).size() != 2)
      {
        paramPromise.reject("Invalid Value");
        return;
      }
      String str = ((HippyArray)localObject).getString(0);
      if (str == null)
      {
        paramPromise.reject("Invalid key");
        return;
      }
      Object localObject = ((HippyArray)localObject).getString(1);
      if (localObject == null)
      {
        paramPromise.reject("Invalid Value");
        return;
      }
      HippyStorageKeyValue localHippyStorageKeyValue = new HippyStorageKeyValue();
      localHippyStorageKeyValue.key = str;
      localHippyStorageKeyValue.value = ((String)localObject);
      localArrayList.add(localHippyStorageKeyValue);
      i += 1;
    }
    this.a.multiSet(localArrayList, new StorageModule.2(this, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule
 * JD-Core Version:    0.7.0.1
 */
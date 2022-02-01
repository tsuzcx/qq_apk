package com.tencent.mtt.hippy.modules.nativemodules.storage;

import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageKeyValue;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.Iterator;
import java.util.List;

class StorageModule$1
  implements HippyStorageAdapter.Callback<List<HippyStorageKeyValue>>
{
  StorageModule$1(StorageModule paramStorageModule, Promise paramPromise) {}
  
  public void a(List<HippyStorageKeyValue> paramList)
  {
    HippyArray localHippyArray1;
    Object localObject;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localHippyArray1 = new HippyArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (HippyStorageKeyValue)paramList.next();
        HippyArray localHippyArray2 = new HippyArray();
        localHippyArray2.pushString(((HippyStorageKeyValue)localObject).key);
        localHippyArray2.pushString(((HippyStorageKeyValue)localObject).value);
        localHippyArray1.pushArray(localHippyArray2);
      }
      localObject = this.a;
    }
    for (paramList = localHippyArray1;; paramList = null)
    {
      ((Promise)localObject).resolve(paramList);
      return;
      localObject = this.a;
    }
  }
  
  public void onError(String paramString)
  {
    this.a.reject(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.1
 * JD-Core Version:    0.7.0.1
 */
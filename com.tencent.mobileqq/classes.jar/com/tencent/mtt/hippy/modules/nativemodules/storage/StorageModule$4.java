package com.tencent.mtt.hippy.modules.nativemodules.storage;

import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

class StorageModule$4
  implements HippyStorageAdapter.Callback<HippyArray>
{
  StorageModule$4(StorageModule paramStorageModule, Promise paramPromise) {}
  
  public void a(HippyArray paramHippyArray)
  {
    this.a.resolve(paramHippyArray);
  }
  
  public void onError(String paramString)
  {
    this.a.reject(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.4
 * JD-Core Version:    0.7.0.1
 */
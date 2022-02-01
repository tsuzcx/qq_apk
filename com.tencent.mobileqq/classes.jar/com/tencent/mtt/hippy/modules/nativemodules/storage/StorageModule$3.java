package com.tencent.mtt.hippy.modules.nativemodules.storage;

import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback;
import com.tencent.mtt.hippy.modules.Promise;

class StorageModule$3
  implements HippyStorageAdapter.Callback<Void>
{
  StorageModule$3(StorageModule paramStorageModule, Promise paramPromise) {}
  
  public void a(Void paramVoid)
  {
    this.a.resolve("success");
  }
  
  public void onError(String paramString)
  {
    this.a.reject(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.3
 * JD-Core Version:    0.7.0.1
 */
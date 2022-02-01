package com.tencent.mtt.hippy.adapter.storage;

public abstract interface HippyStorageAdapter$Callback<T>
{
  public abstract void onError(String paramString);
  
  public abstract void onSuccess(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
 * JD-Core Version:    0.7.0.1
 */
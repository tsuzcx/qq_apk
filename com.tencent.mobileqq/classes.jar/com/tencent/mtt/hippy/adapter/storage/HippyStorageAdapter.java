package com.tencent.mtt.hippy.adapter.storage;

import com.tencent.mtt.hippy.common.HippyArray;
import java.util.List;

public abstract interface HippyStorageAdapter
{
  public abstract void destroyIfNeed();
  
  public abstract void getAllKeys(HippyStorageAdapter.Callback<HippyArray> paramCallback);
  
  public abstract void multiGet(HippyArray paramHippyArray, HippyStorageAdapter.Callback<List<HippyStorageKeyValue>> paramCallback);
  
  public abstract void multiRemove(HippyArray paramHippyArray, HippyStorageAdapter.Callback<Void> paramCallback);
  
  public abstract void multiSet(List<HippyStorageKeyValue> paramList, HippyStorageAdapter.Callback<Void> paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
 * JD-Core Version:    0.7.0.1
 */
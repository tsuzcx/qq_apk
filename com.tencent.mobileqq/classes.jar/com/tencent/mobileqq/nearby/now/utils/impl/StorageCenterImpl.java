package com.tencent.mobileqq.nearby.now.utils.impl;

import android.content.Context;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import com.tencent.mobileqq.nearby.now.utils.StorageCenter;

public class StorageCenterImpl
  implements IStorageCenter
{
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return StorageCenter.b(paramString, paramBoolean);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return StorageCenter.b(paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return StorageCenter.b(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return StorageCenter.b(paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return StorageCenter.b(paramString1, paramString2);
  }
  
  public void init(Context paramContext, String paramString)
  {
    StorageCenter.a(paramContext, paramString);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    StorageCenter.a(paramString, paramBoolean);
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    StorageCenter.a(paramString, paramFloat);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    StorageCenter.a(paramString, paramInt);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    StorageCenter.a(paramString, paramLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    StorageCenter.a(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    StorageCenter.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.StorageCenterImpl
 * JD-Core Version:    0.7.0.1
 */
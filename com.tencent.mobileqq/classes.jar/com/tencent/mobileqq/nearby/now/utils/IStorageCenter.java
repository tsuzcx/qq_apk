package com.tencent.mobileqq.nearby.now.utils;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStorageCenter
  extends QRouteApi
{
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract float getFloat(String paramString, float paramFloat);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract void init(Context paramContext, String paramString);
  
  public abstract void putBoolean(String paramString, boolean paramBoolean);
  
  public abstract void putFloat(String paramString, float paramFloat);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putLong(String paramString, long paramLong);
  
  public abstract void putString(String paramString1, String paramString2);
  
  public abstract void remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IStorageCenter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.plato.core;

import android.support.annotation.Nullable;
import org.json.JSONArray;

public abstract interface IReadableArray
{
  public abstract Object get(int paramInt);
  
  public abstract boolean getBoolean(int paramInt, boolean paramBoolean);
  
  public abstract double getDouble(int paramInt, double paramDouble);
  
  public abstract float getFloat(int paramInt, float paramFloat);
  
  @Nullable
  public abstract IFunction getFunction(int paramInt);
  
  public abstract int getInt(int paramInt1, int paramInt2);
  
  public abstract long getLong(int paramInt, long paramLong);
  
  public abstract IReadableArray getReadableArray(int paramInt);
  
  public abstract IReadableMap getReadableMap(int paramInt);
  
  public abstract String getString(int paramInt, String paramString);
  
  public abstract int length();
  
  public abstract JSONArray toJSONArray();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.IReadableArray
 * JD-Core Version:    0.7.0.1
 */
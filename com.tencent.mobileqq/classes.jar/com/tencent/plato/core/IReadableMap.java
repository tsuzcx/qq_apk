package com.tencent.plato.core;

import android.support.annotation.Nullable;
import java.util.List;
import org.json.JSONObject;

public abstract interface IReadableMap
{
  public abstract Object get(String paramString);
  
  public abstract boolean getBoolean(String paramString, boolean paramBoolean);
  
  public abstract double getDouble(String paramString, double paramDouble);
  
  public abstract float getFloat(String paramString, float paramFloat);
  
  @Nullable
  public abstract IFunction getFunction(String paramString);
  
  public abstract int getInt(String paramString, int paramInt);
  
  public abstract long getLong(String paramString, long paramLong);
  
  public abstract IReadableArray getReadableArray(String paramString);
  
  public abstract IReadableMap getReadableMap(String paramString);
  
  public abstract String getString(String paramString1, String paramString2);
  
  public abstract boolean has(String paramString);
  
  public abstract List<String> names();
  
  public abstract JSONObject toJSONObject();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.IReadableMap
 * JD-Core Version:    0.7.0.1
 */
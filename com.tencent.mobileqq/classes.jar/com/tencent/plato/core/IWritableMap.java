package com.tencent.plato.core;

public abstract interface IWritableMap
  extends IReadableMap
{
  public abstract IWritableMap put(String paramString, double paramDouble);
  
  public abstract IWritableMap put(String paramString, int paramInt);
  
  public abstract IWritableMap put(String paramString, IFunction paramIFunction);
  
  public abstract IWritableMap put(String paramString, IReadableArray paramIReadableArray);
  
  public abstract IWritableMap put(String paramString, IReadableMap paramIReadableMap);
  
  public abstract IWritableMap put(String paramString, Object paramObject);
  
  public abstract IWritableMap put(String paramString1, String paramString2);
  
  public abstract IWritableMap put(String paramString, boolean paramBoolean);
  
  public abstract void remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.IWritableMap
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.plato.core;

public abstract interface IWritableArray
  extends IReadableArray
{
  public abstract IWritableArray add(double paramDouble);
  
  public abstract IWritableArray add(int paramInt);
  
  public abstract IWritableArray add(IFunction paramIFunction);
  
  public abstract IWritableArray add(IReadableArray paramIReadableArray);
  
  public abstract IWritableArray add(IReadableMap paramIReadableMap);
  
  public abstract IWritableArray add(Object paramObject);
  
  public abstract IWritableArray add(String paramString);
  
  public abstract IWritableArray add(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.IWritableArray
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.superplayer.api;

public abstract interface ISuperPlayerPool
{
  public abstract ISuperPlayer get(String paramString);
  
  public abstract void put(ISuperPlayer paramISuperPlayer);
  
  public abstract boolean remove(ISuperPlayer paramISuperPlayer);
  
  public abstract int size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.ISuperPlayerPool
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.oskplayer.util;

public abstract class Singleton<T>
{
  private volatile T mInstance;
  
  protected abstract T createInstance();
  
  public final T getInstance()
  {
    if (this.mInstance == null) {}
    try
    {
      if (this.mInstance == null) {
        this.mInstance = createInstance();
      }
      return this.mInstance;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.oskplayer.util.Singleton
 * JD-Core Version:    0.7.0.1
 */
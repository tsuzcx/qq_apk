package com.tencent.qqmini.sdk.launcher.utils;

public abstract class Singleton<T>
{
  private T mInstance;
  
  protected abstract T create();
  
  public final T get()
  {
    try
    {
      if (this.mInstance == null) {
        this.mInstance = create();
      }
      Object localObject1 = this.mInstance;
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.Singleton
 * JD-Core Version:    0.7.0.1
 */
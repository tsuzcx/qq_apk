package com.tencent.weiyun.utils;

public abstract class Singleton<T, P>
{
  private volatile T mInstance;
  
  protected abstract T create(P paramP);
  
  public final T get(P paramP)
  {
    if (this.mInstance == null) {
      try
      {
        if (this.mInstance == null) {
          this.mInstance = create(paramP);
        }
      }
      finally {}
    }
    return this.mInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.Singleton
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.turingfd.sdk.xq;

public abstract class public<T>
{
  public volatile T a;
  
  public abstract T a();
  
  public final T b()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.a;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a();
          this.a = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.public
 * JD-Core Version:    0.7.0.1
 */
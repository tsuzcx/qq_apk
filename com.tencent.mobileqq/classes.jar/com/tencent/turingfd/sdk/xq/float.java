package com.tencent.turingfd.sdk.xq;

public abstract class float<T>
{
  public volatile T kf;
  
  public final T get()
  {
    Object localObject1 = this.kf;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.kf;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = (Banana)this;
          localObject1 = new Bergamot();
          this.kf = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.float
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tfd.sdk.wxa;

public abstract class float<T>
{
  public volatile T Sb;
  
  public final T get()
  {
    Object localObject1 = this.Sb;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.Sb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = (Chamaeleon)this;
          localObject1 = new Crux();
          this.Sb = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.float
 * JD-Core Version:    0.7.0.1
 */
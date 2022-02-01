package com.tencent.turingfd.sdk.ams.ga;

public abstract class float<T>
{
  public volatile T hc;
  
  public final T get()
  {
    Object localObject1 = this.hc;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.hc;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = (Chamaeleon)this;
          localObject1 = new Crux();
          this.hc = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.float
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.turingfd.sdk.xq;

public abstract class short<T>
{
  public volatile T sf;
  
  public abstract T create();
  
  public final T get()
  {
    Object localObject1 = this.sf;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.sf;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = create();
          this.sf = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.short
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.turingfd.sdk.xq;

public abstract class this<T>
{
  public volatile T kb;
  
  public abstract T create();
  
  public final T get()
  {
    Object localObject1 = this.kb;
    if (localObject1 == null) {
      try
      {
        Object localObject2 = this.kb;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = create();
          this.kb = localObject1;
        }
        return localObject1;
      }
      finally {}
    }
    return ?;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.this
 * JD-Core Version:    0.7.0.1
 */
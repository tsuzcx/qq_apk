package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class ArrayStream<R>
  extends Stream<R>
{
  public ArrayStream(R[] paramArrayOfR)
  {
    AssertUtils.checkNotNull(paramArrayOfR);
    attachDataSupplier(new ArrayDataPusher(paramArrayOfR));
  }
  
  private static class ArrayDataPusher<R>
    extends BaseDataPusher<R>
  {
    private final R[] mArray;
    
    public ArrayDataPusher(R[] paramArrayOfR)
    {
      AssertUtils.checkNotNull(paramArrayOfR);
      this.mArray = paramArrayOfR;
    }
    
    public void apply(Observer<R> paramObserver)
    {
      super.apply(paramObserver);
      Object[] arrayOfObject = this.mArray;
      int j = arrayOfObject.length;
      int i = 0;
      for (;;)
      {
        Object localObject;
        if (i < j)
        {
          localObject = arrayOfObject[i];
          if (!isCanceled()) {}
        }
        else
        {
          paramObserver.onComplete();
          return;
        }
        AssertUtils.checkNotNull(localObject);
        paramObserver.onNext(localObject);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.ArrayStream
 * JD-Core Version:    0.7.0.1
 */
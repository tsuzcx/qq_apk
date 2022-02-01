package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class ArrayStream$ArrayDataPusher<R>
  extends BaseDataPusher<R>
{
  private final R[] mArray;
  
  public ArrayStream$ArrayDataPusher(R[] paramArrayOfR)
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
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if (isCanceled()) {
        break;
      }
      AssertUtils.checkNotNull(localObject);
      paramObserver.onNext(localObject);
      i += 1;
    }
    paramObserver.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.reactive.ArrayStream.ArrayDataPusher
 * JD-Core Version:    0.7.0.1
 */
package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class ArrayStream<R>
  extends Stream<R>
{
  public ArrayStream(R[] paramArrayOfR)
  {
    AssertUtils.checkNotNull(paramArrayOfR);
    attachDataSupplier(new ArrayStream.ArrayDataPusher(paramArrayOfR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.reactive.ArrayStream
 * JD-Core Version:    0.7.0.1
 */
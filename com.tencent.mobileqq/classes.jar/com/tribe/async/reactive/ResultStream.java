package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class ResultStream<R>
  extends Stream<R>
{
  private R mResult;
  
  public ResultStream(R paramR)
  {
    AssertUtils.checkNotNull(paramR);
    this.mResult = paramR;
    attachDataSupplier(new ResultStream.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tribe.async.reactive.ResultStream
 * JD-Core Version:    0.7.0.1
 */
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
    attachDataSupplier(new BaseDataPusher()
    {
      public void apply(Observer<R> paramAnonymousObserver)
      {
        super.apply(paramAnonymousObserver);
        paramAnonymousObserver.onNext(ResultStream.this.mResult);
        paramAnonymousObserver.onComplete();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.reactive.ResultStream
 * JD-Core Version:    0.7.0.1
 */
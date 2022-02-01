package com.tribe.async.reactive;

class ResultStream$1
  extends BaseDataPusher<R>
{
  ResultStream$1(ResultStream paramResultStream) {}
  
  public void apply(Observer<R> paramObserver)
  {
    super.apply(paramObserver);
    paramObserver.onNext(ResultStream.access$000(this.this$0));
    paramObserver.onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.reactive.ResultStream.1
 * JD-Core Version:    0.7.0.1
 */
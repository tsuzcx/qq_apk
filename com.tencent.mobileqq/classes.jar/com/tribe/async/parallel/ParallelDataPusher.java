package com.tribe.async.parallel;

import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;

class ParallelDataPusher<IN, OUT>
  extends DataPusher
{
  private IN in;
  private StreamFunction<IN, OUT> mFunction = null;
  private DataPusher mUpDataPusher = null;
  
  public ParallelDataPusher(DataPusher paramDataPusher, StreamFunction<IN, OUT> paramStreamFunction, IN paramIN)
  {
    this.mUpDataPusher = paramDataPusher;
    this.mFunction = paramStreamFunction;
    this.in = paramIN;
    AssertUtils.checkNotNull(paramDataPusher);
    AssertUtils.checkNotNull(paramStreamFunction);
  }
  
  public ParallelDataPusher(StreamFunction<IN, OUT> paramStreamFunction, IN paramIN)
  {
    this.mFunction = paramStreamFunction;
    this.in = paramIN;
    AssertUtils.checkNotNull(paramStreamFunction);
  }
  
  public void apply(Observer paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    paramObserver.addObserverFunction(Integer.valueOf(this.mFunction.hashCode()));
    if (this.mUpDataPusher != null) {
      this.mUpDataPusher.apply(paramObserver);
    }
    this.mFunction.observe(new ParallelDataPusher.1(this, paramObserver));
    this.mFunction.apply(this.in);
  }
  
  public void cancel()
  {
    this.mFunction.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelDataPusher
 * JD-Core Version:    0.7.0.1
 */
package com.tribe.async.parallel;

import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.StreamFunction.StreamFunctionListener;
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
  
  public void apply(final Observer paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    paramObserver.addObserverFunction(Integer.valueOf(this.mFunction.hashCode()));
    if (this.mUpDataPusher != null) {
      this.mUpDataPusher.apply(paramObserver);
    }
    this.mFunction.observe(new StreamFunction.StreamFunctionListener()
    {
      public void onCancel()
      {
        paramObserver.onStreamCancel();
      }
      
      public void onError(Error paramAnonymousError)
      {
        paramObserver.onOneFunctionErr(Integer.valueOf(ParallelDataPusher.this.mFunction.hashCode()), paramAnonymousError);
      }
      
      public void onResult(OUT paramAnonymousOUT)
      {
        paramObserver.onOneFunctionSuc(Integer.valueOf(ParallelDataPusher.this.mFunction.hashCode()), paramAnonymousOUT);
      }
    });
    this.mFunction.apply(this.in);
  }
  
  public void cancel()
  {
    this.mFunction.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelDataPusher
 * JD-Core Version:    0.7.0.1
 */
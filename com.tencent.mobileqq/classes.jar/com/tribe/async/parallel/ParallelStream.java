package com.tribe.async.parallel;

import android.support.annotation.NonNull;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.utils.AssertUtils;

public class ParallelStream
{
  private DataPusher mDataPusher;
  
  public static <IN, OUT> ParallelStream of(StreamFunction<IN, OUT> paramStreamFunction, IN paramIN)
  {
    AssertUtils.checkNotNull(paramStreamFunction);
    ParallelStream localParallelStream = new ParallelStream();
    localParallelStream.attachDataSupplier(new ParallelDataPusher(paramStreamFunction, paramIN));
    return localParallelStream;
  }
  
  protected void attachDataSupplier(@NonNull DataPusher paramDataPusher)
  {
    this.mDataPusher = paramDataPusher;
  }
  
  public void cancel()
  {
    DataPusher localDataPusher = this.mDataPusher;
    if (localDataPusher != null)
    {
      localDataPusher.cancel();
      return;
    }
    throw new RuntimeException("Please call attachDataSupplier before cancel.");
  }
  
  public <IN, OUT> ParallelStream map(StreamFunction<IN, OUT> paramStreamFunction, IN paramIN)
  {
    AssertUtils.checkNotNull(paramStreamFunction);
    ParallelStream localParallelStream = new ParallelStream();
    localParallelStream.attachDataSupplier(new ParallelDataPusher(this.mDataPusher, paramStreamFunction, paramIN));
    return localParallelStream;
  }
  
  public void subscribe(Observer paramObserver)
  {
    AssertUtils.checkNotNull(paramObserver);
    DataPusher localDataPusher = this.mDataPusher;
    if (localDataPusher != null)
    {
      localDataPusher.apply(paramObserver);
      return;
    }
    throw new RuntimeException("Please call attachDataSupplier before subscribe.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.parallel.ParallelStream
 * JD-Core Version:    0.7.0.1
 */
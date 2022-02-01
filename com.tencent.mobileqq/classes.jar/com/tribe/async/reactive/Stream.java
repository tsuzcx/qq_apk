package com.tribe.async.reactive;

import android.support.annotation.NonNull;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;

public class Stream<Result>
{
  private DataPusher<Result> mDataPusher;
  
  public static <R> Stream<R> fromArray(R[] paramArrayOfR)
  {
    AssertUtils.checkNotNull(paramArrayOfR);
    return new ArrayStream(paramArrayOfR);
  }
  
  public static <R> Stream<R> fromDataPusher(@NonNull DataPusher<R> paramDataPusher)
  {
    AssertUtils.checkNotNull(paramDataPusher);
    Stream localStream = new Stream();
    localStream.attachDataSupplier(paramDataPusher);
    return localStream;
  }
  
  public static <R> Stream<R> fromIterator(Iterator<R> paramIterator)
  {
    AssertUtils.checkNotNull(paramIterator);
    return new IteratorStream(paramIterator);
  }
  
  public static <R> Stream<R> of(R paramR)
  {
    AssertUtils.checkNotNull(paramR);
    return new ResultStream(paramR);
  }
  
  protected void attachDataSupplier(@NonNull DataPusher<Result> paramDataPusher)
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
  
  public Stream<Result> filter(Predicate<Result> paramPredicate)
  {
    return lift(new OperatorFilter(paramPredicate));
  }
  
  public <R> Stream<R> lift(Operator<Result, R> paramOperator)
  {
    AssertUtils.checkNotNull(paramOperator);
    Stream localStream = new Stream();
    localStream.attachDataSupplier(new OperatorDataPusher(this.mDataPusher, paramOperator));
    return localStream;
  }
  
  public <R> Stream<R> map(StreamFunction<Result, R> paramStreamFunction)
  {
    AssertUtils.checkNotNull(paramStreamFunction);
    return lift(new OperatorMap(paramStreamFunction));
  }
  
  public void subscribe(Observer<Result> paramObserver)
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
 * Qualified Name:     com.tribe.async.reactive.Stream
 * JD-Core Version:    0.7.0.1
 */
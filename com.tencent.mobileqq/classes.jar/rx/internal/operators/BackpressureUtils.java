package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Subscriber;

public final class BackpressureUtils
{
  static final long COMPLETED_MASK = -9223372036854775808L;
  static final long REQUESTED_MASK = 9223372036854775807L;
  
  private BackpressureUtils()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long addCap(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = 9223372036854775807L;
    }
    return paramLong1;
  }
  
  public static long getAndAddRequest(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
    } while (!paramAtomicLong.compareAndSet(l, addCap(l, paramLong)));
    return l;
  }
  
  public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> paramAtomicLongFieldUpdater, T paramT, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLongFieldUpdater.get(paramT);
    } while (!paramAtomicLongFieldUpdater.compareAndSet(paramT, l, addCap(l, paramLong)));
    return l;
  }
  
  public static long multiplyCap(long paramLong1, long paramLong2)
  {
    long l2 = paramLong1 * paramLong2;
    long l1 = l2;
    if ((paramLong1 | paramLong2) >>> 31 != 0L)
    {
      l1 = l2;
      if (paramLong2 != 0L)
      {
        l1 = l2;
        if (l2 / paramLong2 != paramLong1) {
          l1 = 9223372036854775807L;
        }
      }
    }
    return l1;
  }
  
  public static <T> void postCompleteDone(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
      if ((l & 0x0) != 0L) {
        return;
      }
    } while (!paramAtomicLong.compareAndSet(l, 0x0 | l));
    if (l != 0L) {
      postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
    }
  }
  
  static <T> void postCompleteDrain(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l1 = paramAtomicLong.get();
    long l2;
    do
    {
      l2 = -9223372036854775808L;
      long l3;
      do
      {
        while (l2 != l1)
        {
          if (paramSubscriber.isUnsubscribed()) {
            return;
          }
          Object localObject = paramQueue.poll();
          if (localObject == null)
          {
            paramSubscriber.onCompleted();
            return;
          }
          paramSubscriber.onNext(localObject);
          l2 += 1L;
        }
        if (l2 == l1)
        {
          if (paramSubscriber.isUnsubscribed()) {
            return;
          }
          if (paramQueue.isEmpty())
          {
            paramSubscriber.onCompleted();
            return;
          }
        }
        l3 = paramAtomicLong.get();
        l1 = l3;
      } while (l3 != l2);
      l2 = paramAtomicLong.addAndGet(-(l2 & 0xFFFFFFFF));
      l1 = l2;
    } while (l2 != -9223372036854775808L);
  }
  
  public static <T> boolean postCompleteRequest(AtomicLong paramAtomicLong, long paramLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return (paramAtomicLong.get() & 0x0) == 0L;
      }
      for (;;)
      {
        long l1 = paramAtomicLong.get();
        long l2 = l1 & 0x0;
        if (paramAtomicLong.compareAndSet(l1, addCap(0xFFFFFFFF & l1, paramLong) | l2))
        {
          if (l1 == -9223372036854775808L)
          {
            postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
            return false;
          }
          return l2 == 0L;
        }
      }
    }
    paramAtomicLong = new StringBuilder();
    paramAtomicLong.append("n >= 0 required but it was ");
    paramAtomicLong.append(paramLong);
    paramAtomicLong = new IllegalArgumentException(paramAtomicLong.toString());
    for (;;)
    {
      throw paramAtomicLong;
    }
  }
  
  public static long produced(AtomicLong paramAtomicLong, long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = paramAtomicLong.get();
      if (l1 == 9223372036854775807L) {
        return 9223372036854775807L;
      }
      l2 = l1 - paramLong;
      if (l2 < 0L) {
        break;
      }
    } while (!paramAtomicLong.compareAndSet(l1, l2));
    return l2;
    paramAtomicLong = new StringBuilder();
    paramAtomicLong.append("More produced than requested: ");
    paramAtomicLong.append(l2);
    paramAtomicLong = new IllegalStateException(paramAtomicLong.toString());
    for (;;)
    {
      throw paramAtomicLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BackpressureUtils
 * JD-Core Version:    0.7.0.1
 */
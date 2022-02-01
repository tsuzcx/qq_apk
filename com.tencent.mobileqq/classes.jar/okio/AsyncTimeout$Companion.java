package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k=1, mv={1, 1, 16})
public final class AsyncTimeout$Companion
{
  private final boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    try
    {
      for (AsyncTimeout localAsyncTimeout = AsyncTimeout.access$getHead$cp(); localAsyncTimeout != null; localAsyncTimeout = AsyncTimeout.access$getNext$p(localAsyncTimeout)) {
        if (AsyncTimeout.access$getNext$p(localAsyncTimeout) == paramAsyncTimeout)
        {
          AsyncTimeout.access$setNext$p(localAsyncTimeout, AsyncTimeout.access$getNext$p(paramAsyncTimeout));
          AsyncTimeout.access$setNext$p(paramAsyncTimeout, (AsyncTimeout)null);
          return false;
        }
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramAsyncTimeout;
    }
  }
  
  private final void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (AsyncTimeout.access$getHead$cp() == null)
      {
        AsyncTimeout.access$setHead$cp(new AsyncTimeout());
        new AsyncTimeout.Watchdog().start();
      }
      long l = System.nanoTime();
      if ((paramLong != 0L) && (paramBoolean))
      {
        AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
      }
      else if (paramLong != 0L)
      {
        AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, paramLong + l);
      }
      else
      {
        if (!paramBoolean) {
          break label227;
        }
        AsyncTimeout.access$setTimeoutAt$p(paramAsyncTimeout, paramAsyncTimeout.deadlineNanoTime());
      }
      paramLong = AsyncTimeout.access$remainingNanos(paramAsyncTimeout, l);
      AsyncTimeout localAsyncTimeout2 = AsyncTimeout.access$getHead$cp();
      AsyncTimeout localAsyncTimeout1 = localAsyncTimeout2;
      if (localAsyncTimeout2 == null)
      {
        Intrinsics.throwNpe();
        localAsyncTimeout1 = localAsyncTimeout2;
      }
      while (AsyncTimeout.access$getNext$p(localAsyncTimeout1) != null)
      {
        localAsyncTimeout2 = AsyncTimeout.access$getNext$p(localAsyncTimeout1);
        if (localAsyncTimeout2 == null) {
          Intrinsics.throwNpe();
        }
        if (paramLong < AsyncTimeout.access$remainingNanos(localAsyncTimeout2, l)) {
          break;
        }
        localAsyncTimeout2 = AsyncTimeout.access$getNext$p(localAsyncTimeout1);
        localAsyncTimeout1 = localAsyncTimeout2;
        if (localAsyncTimeout2 == null)
        {
          Intrinsics.throwNpe();
          localAsyncTimeout1 = localAsyncTimeout2;
        }
      }
      AsyncTimeout.access$setNext$p(paramAsyncTimeout, AsyncTimeout.access$getNext$p(localAsyncTimeout1));
      AsyncTimeout.access$setNext$p(localAsyncTimeout1, paramAsyncTimeout);
      if (localAsyncTimeout1 == AsyncTimeout.access$getHead$cp()) {
        ((Object)AsyncTimeout.class).notify();
      }
      paramAsyncTimeout = Unit.INSTANCE;
      return;
      label227:
      throw ((Throwable)new AssertionError());
    }
    finally {}
    for (;;)
    {
      throw paramAsyncTimeout;
    }
  }
  
  @Nullable
  public final AsyncTimeout awaitTimeout$okio()
  {
    Object localObject = AsyncTimeout.access$getHead$cp();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = AsyncTimeout.access$getNext$p((AsyncTimeout)localObject);
    AsyncTimeout localAsyncTimeout1 = null;
    if (localObject == null)
    {
      l1 = System.nanoTime();
      ((Object)AsyncTimeout.class).wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
      AsyncTimeout localAsyncTimeout2 = AsyncTimeout.access$getHead$cp();
      if (localAsyncTimeout2 == null) {
        Intrinsics.throwNpe();
      }
      localObject = localAsyncTimeout1;
      if (AsyncTimeout.access$getNext$p(localAsyncTimeout2) == null)
      {
        localObject = localAsyncTimeout1;
        if (System.nanoTime() - l1 >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) {
          localObject = AsyncTimeout.access$getHead$cp();
        }
      }
      return localObject;
    }
    long l1 = AsyncTimeout.access$remainingNanos((AsyncTimeout)localObject, System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      ((Object)AsyncTimeout.class).wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    localAsyncTimeout1 = AsyncTimeout.access$getHead$cp();
    if (localAsyncTimeout1 == null) {
      Intrinsics.throwNpe();
    }
    AsyncTimeout.access$setNext$p(localAsyncTimeout1, AsyncTimeout.access$getNext$p((AsyncTimeout)localObject));
    AsyncTimeout.access$setNext$p((AsyncTimeout)localObject, (AsyncTimeout)null);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.AsyncTimeout.Companion
 * JD-Core Version:    0.7.0.1
 */
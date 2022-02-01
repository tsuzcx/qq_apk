package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.annotations.Experimental;

@Experimental
public final class BackpressureDrainManager
  extends AtomicLong
  implements Producer
{
  protected final BackpressureDrainManager.BackpressureQueueCallback actual;
  protected boolean emitting;
  protected Throwable exception;
  protected volatile boolean terminated;
  
  public BackpressureDrainManager(BackpressureDrainManager.BackpressureQueueCallback paramBackpressureQueueCallback)
  {
    this.actual = paramBackpressureQueueCallback;
  }
  
  public final void drain()
  {
    for (;;)
    {
      try
      {
        if (this.emitting) {
          return;
        }
        k = 1;
        m = 1;
        this.emitting = true;
        bool1 = this.terminated;
        l = get();
      }
      finally
      {
        int k;
        int m;
        boolean bool1;
        long l;
        BackpressureDrainManager.BackpressureQueueCallback localBackpressureQueueCallback;
        Object localObject7;
        label202:
        label233:
        continue;
        label267:
        throw localObject5;
        continue;
        i = 0;
        if (l > 0L) {
          continue;
        }
        if (!bool1) {
          continue;
        }
        continue;
        j = 0;
        continue;
        if ((!bool1) || (j != 0)) {
          continue;
        }
        continue;
      }
      try
      {
        localBackpressureQueueCallback = this.actual;
      }
      finally
      {
        i = 0;
        if (i != 0) {
          continue;
        }
        try
        {
          this.emitting = false;
        }
        finally {}
      }
    }
    if (bool1)
    {
      localObject7 = localBackpressureQueueCallback.peek();
      if (localObject7 == null)
      {
        i = m;
        try
        {
          localBackpressureQueueCallback.complete(this.exception);
          return;
        }
        finally
        {
          break label267;
        }
      }
      if (l == 0L) {}
    }
    else
    {
      localObject7 = localObject1.poll();
      if (localObject7 != null) {
        break label233;
      }
    }
    for (;;)
    {
      try
      {
        bool1 = this.terminated;
        if (localObject1.peek() == null) {
          continue;
        }
        j = 1;
        l = get();
        if (l == 9223372036854775807L) {
          if ((j == 0) && (!bool1)) {
            j = k;
          }
        }
      }
      finally
      {
        int j;
        boolean bool2;
        i = 0;
        continue;
      }
      try
      {
        this.emitting = false;
        j = k;
        return;
      }
      finally
      {
        i = j;
      }
    }
    l = 9223372036854775807L;
    break label202;
    l = -i;
    l = addAndGet(l);
    if (l != 0L)
    {
      if (j != 0) {
        break label340;
      }
      break label328;
      break label306;
      j = k;
      this.emitting = false;
      j = k;
      return;
      j = i;
      throw localObject1;
      bool2 = localObject2.accept(localObject7);
      if (bool2) {
        return;
      }
      l -= 1L;
      i += 1;
    }
  }
  
  public final boolean isTerminated()
  {
    return this.terminated;
  }
  
  public final void request(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    long l2;
    int i;
    long l1;
    do
    {
      l2 = get();
      if (l2 == 0L) {
        i = 1;
      } else {
        i = 0;
      }
      l1 = 9223372036854775807L;
      if (l2 == 9223372036854775807L) {
        break;
      }
      if (paramLong == 9223372036854775807L)
      {
        l1 = paramLong;
        i = 1;
      }
      else if (l2 <= 9223372036854775807L - paramLong)
      {
        l1 = l2 + paramLong;
      }
    } while (!compareAndSet(l2, l1));
    if (i != 0) {
      drain();
    }
  }
  
  public final void terminate()
  {
    this.terminated = true;
  }
  
  public final void terminate(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
    }
  }
  
  public final void terminateAndDrain()
  {
    this.terminated = true;
    drain();
  }
  
  public final void terminateAndDrain(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
      drain();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.BackpressureDrainManager
 * JD-Core Version:    0.7.0.1
 */
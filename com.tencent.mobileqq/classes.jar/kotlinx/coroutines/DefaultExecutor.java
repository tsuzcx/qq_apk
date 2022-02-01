package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "notifyStartup", "run", "shutdown", "timeout", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class DefaultExecutor
  extends EventLoopImplBase
  implements Runnable
{
  private static final int ACTIVE = 1;
  private static final long DEFAULT_KEEP_ALIVE = 1000L;
  private static final int FRESH = 0;
  public static final DefaultExecutor INSTANCE;
  private static final long KEEP_ALIVE_NANOS;
  private static final int SHUTDOWN_ACK = 3;
  private static final int SHUTDOWN_REQ = 2;
  @NotNull
  public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
  private static volatile Thread _thread;
  private static volatile int debugStatus;
  
  static
  {
    Object localObject = new DefaultExecutor();
    INSTANCE = (DefaultExecutor)localObject;
    EventLoop.incrementUseCount$default((EventLoop)localObject, false, 1, null);
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    try
    {
      localObject = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
    }
    catch (SecurityException localSecurityException)
    {
      label35:
      break label35;
    }
    localObject = Long.valueOf(1000L);
    KEEP_ALIVE_NANOS = localTimeUnit.toNanos(((Long)localObject).longValue());
  }
  
  private final void acknowledgeShutdownIfNeeded()
  {
    try
    {
      boolean bool = isShutdownRequested();
      if (!bool) {
        return;
      }
      debugStatus = 3;
      resetAll();
      ((Object)this).notifyAll();
      return;
    }
    finally {}
  }
  
  private final Thread createThreadSync()
  {
    try
    {
      Thread localThread = _thread;
      if (localThread == null)
      {
        localThread = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
        _thread = localThread;
        localThread.setDaemon(true);
        localThread.start();
      }
      return localThread;
    }
    finally {}
  }
  
  private final boolean isShutdownRequested()
  {
    int i = debugStatus;
    return (i == 2) || (i == 3);
  }
  
  private final boolean notifyStartup()
  {
    try
    {
      boolean bool = isShutdownRequested();
      if (bool) {
        return false;
      }
      debugStatus = 1;
      ((Object)this).notifyAll();
      return true;
    }
    finally {}
  }
  
  public final void ensureStarted$kotlinx_coroutines_core()
  {
    try
    {
      boolean bool = DebugKt.getASSERTIONS_ENABLED();
      j = 1;
      if (!bool) {
        break label34;
      }
      if (_thread != null) {
        break label112;
      }
      i = 1;
    }
    finally
    {
      for (;;)
      {
        int j;
        for (;;)
        {
          label34:
          throw localObject;
        }
        label112:
        int i = 0;
        if (i != 0)
        {
          continue;
          i = 0;
          label123:
          if (i == 0) {}
        }
      }
    }
    throw ((Throwable)new AssertionError());
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      i = j;
      if (debugStatus == 0) {
        break label123;
      }
      if (debugStatus == 3)
      {
        i = j;
        break label123;
        throw ((Throwable)new AssertionError());
      }
    }
    else
    {
      debugStatus = 0;
      createThreadSync();
      while (debugStatus == 0) {
        ((Object)this).wait();
      }
      return;
    }
  }
  
  @NotNull
  protected Thread getThread()
  {
    Thread localThread = _thread;
    if (localThread != null) {
      return localThread;
    }
    return createThreadSync();
  }
  
  @NotNull
  public DisposableHandle invokeOnTimeout(long paramLong, @NotNull Runnable paramRunnable)
  {
    return scheduleInvokeOnTimeout(paramLong, paramRunnable);
  }
  
  public void run()
  {
    ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core((EventLoop)this);
    TimeSource localTimeSource1 = TimeSourceKt.getTimeSource();
    if (localTimeSource1 != null) {
      localTimeSource1.registerTimeLoopThread();
    }
    try
    {
      boolean bool = notifyStartup();
      if (!bool)
      {
        _thread = (Thread)null;
        acknowledgeShutdownIfNeeded();
        localTimeSource1 = TimeSourceKt.getTimeSource();
        if (localTimeSource1 != null) {
          localTimeSource1.unregisterTimeLoopThread();
        }
        if (!isEmpty()) {
          getThread();
        }
        return;
      }
      long l1 = 9223372036854775807L;
      for (;;)
      {
        Thread.interrupted();
        long l4 = processNextEvent();
        long l3 = l1;
        long l2 = l4;
        if (l4 == 9223372036854775807L) {
          if (l1 == 9223372036854775807L)
          {
            localTimeSource1 = TimeSourceKt.getTimeSource();
            if (localTimeSource1 != null) {
              l3 = localTimeSource1.nanoTime();
            } else {
              l3 = System.nanoTime();
            }
            l2 = l1;
            if (l1 == 9223372036854775807L)
            {
              l1 = KEEP_ALIVE_NANOS;
              l2 = l1 + l3;
            }
            l1 = l2 - l3;
            if (l1 <= 0L)
            {
              _thread = (Thread)null;
              acknowledgeShutdownIfNeeded();
              localTimeSource1 = TimeSourceKt.getTimeSource();
              if (localTimeSource1 != null) {
                localTimeSource1.unregisterTimeLoopThread();
              }
              if (!isEmpty()) {
                getThread();
              }
              return;
            }
            l1 = RangesKt.coerceAtMost(l4, l1);
            l3 = l2;
            l2 = l1;
          }
          else
          {
            l2 = RangesKt.coerceAtMost(l4, KEEP_ALIVE_NANOS);
            l3 = l1;
          }
        }
        l1 = l3;
        if (l2 > 0L)
        {
          bool = isShutdownRequested();
          if (bool)
          {
            _thread = (Thread)null;
            acknowledgeShutdownIfNeeded();
            localTimeSource1 = TimeSourceKt.getTimeSource();
            if (localTimeSource1 != null) {
              localTimeSource1.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
              getThread();
            }
            return;
          }
          localTimeSource1 = TimeSourceKt.getTimeSource();
          if (localTimeSource1 != null)
          {
            localTimeSource1.parkNanos(this, l2);
            l1 = l3;
          }
          else
          {
            LockSupport.parkNanos(this, l2);
            l1 = l3;
          }
        }
      }
      TimeSource localTimeSource2;
      throw localObject;
    }
    finally
    {
      _thread = (Thread)null;
      acknowledgeShutdownIfNeeded();
      localTimeSource2 = TimeSourceKt.getTimeSource();
      if (localTimeSource2 != null) {
        localTimeSource2.unregisterTimeLoopThread();
      }
      if (!isEmpty()) {
        getThread();
      }
    }
    for (;;) {}
  }
  
  public final void shutdown(long paramLong)
  {
    try
    {
      long l = System.currentTimeMillis();
      if (!isShutdownRequested()) {
        debugStatus = 2;
      }
      while ((debugStatus != 3) && (_thread != null))
      {
        Thread localThread = _thread;
        if (localThread != null)
        {
          TimeSource localTimeSource = TimeSourceKt.getTimeSource();
          if (localTimeSource != null) {
            localTimeSource.unpark(localThread);
          } else {
            LockSupport.unpark(localThread);
          }
        }
        if (l + paramLong - System.currentTimeMillis() <= 0L) {
          break;
        }
        ((Object)this).wait(paramLong);
      }
      debugStatus = 0;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DefaultExecutor
 * JD-Core Version:    0.7.0.1
 */
package kotlinx.coroutines.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level=DeprecationLevel.WARNING, message="This API has been deprecated to integrate with Structured Concurrency.", replaceWith=@ReplaceWith(expression="TestCoroutineScope", imports={"kotlin.coroutines.test"}))
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/test/TestCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "name", "", "(Ljava/lang/String;)V", "counter", "", "ctxDispatcher", "Lkotlinx/coroutines/test/TestCoroutineContext$Dispatcher;", "ctxHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptions", "", "", "getExceptions", "()Ljava/util/List;", "queue", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/test/TimedRunnableObsolete;", "time", "uncaughtExceptions", "", "advanceTimeBy", "delayTime", "unit", "Ljava/util/concurrent/TimeUnit;", "advanceTimeTo", "", "targetTime", "assertAllUnhandledExceptions", "message", "predicate", "Lkotlin/Function1;", "", "assertAnyUnhandledException", "assertExceptions", "assertUnhandledException", "cancelAllActions", "enqueue", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "now", "postDelayed", "processNextEvent", "toString", "triggerActions", "Dispatcher", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class TestCoroutineContext
  implements CoroutineContext
{
  private long counter;
  private final TestCoroutineContext.Dispatcher ctxDispatcher;
  private final CoroutineExceptionHandler ctxHandler;
  private final String name;
  private final ThreadSafeHeap<TimedRunnableObsolete> queue;
  private long time;
  private final List<Throwable> uncaughtExceptions;
  
  public TestCoroutineContext()
  {
    this(null, 1, null);
  }
  
  public TestCoroutineContext(@Nullable String paramString)
  {
    this.name = paramString;
    this.uncaughtExceptions = ((List)new ArrayList());
    this.ctxDispatcher = new TestCoroutineContext.Dispatcher(this);
    this.ctxHandler = ((CoroutineExceptionHandler)new TestCoroutineContext..special..inlined.CoroutineExceptionHandler.1((CoroutineContext.Key)CoroutineExceptionHandler.Key, this));
    this.queue = new ThreadSafeHeap();
  }
  
  private final void enqueue(Runnable paramRunnable)
  {
    ThreadSafeHeap localThreadSafeHeap = this.queue;
    long l = this.counter;
    this.counter = (1L + l);
    localThreadSafeHeap.addLast((ThreadSafeHeapNode)new TimedRunnableObsolete(paramRunnable, l, 0L, 4, null));
  }
  
  private final TimedRunnableObsolete postDelayed(Runnable paramRunnable, long paramLong)
  {
    long l = this.counter;
    this.counter = (1L + l);
    paramRunnable = new TimedRunnableObsolete(paramRunnable, l, this.time + TimeUnit.MILLISECONDS.toNanos(paramLong));
    this.queue.addLast((ThreadSafeHeapNode)paramRunnable);
    return paramRunnable;
  }
  
  private final long processNextEvent()
  {
    TimedRunnableObsolete localTimedRunnableObsolete = (TimedRunnableObsolete)this.queue.peek();
    if (localTimedRunnableObsolete != null) {
      triggerActions(localTimedRunnableObsolete.time);
    }
    if (this.queue.isEmpty()) {
      return 9223372036854775807L;
    }
    return 0L;
  }
  
  private final void triggerActions(long paramLong)
  {
    int i;
    label124:
    synchronized (this.queue)
    {
      for (;;)
      {
        ThreadSafeHeapNode localThreadSafeHeapNode = ???.firstImpl();
        Object localObject3 = null;
        Object localObject1 = null;
        if (localThreadSafeHeapNode != null)
        {
          if (((TimedRunnableObsolete)localThreadSafeHeapNode).time > paramLong) {
            break label124;
          }
          i = 1;
          if (i != 0) {
            localObject1 = ???.removeAtImpl(0);
          }
        }
        else
        {
          localObject1 = localObject3;
        }
        localObject1 = (TimedRunnableObsolete)localObject1;
        if (localObject1 == null) {
          break;
        }
        if (((TimedRunnableObsolete)localObject1).time != 0L) {
          this.time = ((TimedRunnableObsolete)localObject1).time;
        }
        ((TimedRunnableObsolete)localObject1).run();
      }
      return;
    }
  }
  
  public final long advanceTimeBy(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    long l = this.time;
    advanceTimeTo(paramTimeUnit.toNanos(paramLong) + l, TimeUnit.NANOSECONDS);
    return paramTimeUnit.convert(this.time - l, TimeUnit.NANOSECONDS);
  }
  
  public final void advanceTimeTo(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    triggerActions(paramLong);
    if (paramLong > this.time) {
      this.time = paramLong;
    }
  }
  
  public final void assertAllUnhandledExceptions(@NotNull String paramString, @NotNull Function1<? super Throwable, Boolean> paramFunction1)
  {
    Object localObject = (Iterable)this.uncaughtExceptions;
    boolean bool = localObject instanceof Collection;
    int j = 1;
    int i;
    if ((bool) && (((Collection)localObject).isEmpty()))
    {
      i = j;
    }
    else
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Boolean)paramFunction1.invoke(((Iterator)localObject).next())).booleanValue());
      i = 0;
    }
    if (i != 0)
    {
      this.uncaughtExceptions.clear();
      return;
    }
    paramString = (Throwable)new AssertionError(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void assertAnyUnhandledException(@NotNull String paramString, @NotNull Function1<? super Throwable, Boolean> paramFunction1)
  {
    Object localObject = (Iterable)this.uncaughtExceptions;
    boolean bool = localObject instanceof Collection;
    int j = 0;
    int i;
    if ((bool) && (((Collection)localObject).isEmpty()))
    {
      i = j;
    }
    else
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((Boolean)paramFunction1.invoke(((Iterator)localObject).next())).booleanValue());
      i = 1;
    }
    if (i != 0)
    {
      this.uncaughtExceptions.clear();
      return;
    }
    paramString = (Throwable)new AssertionError(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void assertExceptions(@NotNull String paramString, @NotNull Function1<? super List<? extends Throwable>, Boolean> paramFunction1)
  {
    if (((Boolean)paramFunction1.invoke(this.uncaughtExceptions)).booleanValue())
    {
      this.uncaughtExceptions.clear();
      return;
    }
    throw ((Throwable)new AssertionError(paramString));
  }
  
  public final void assertUnhandledException(@NotNull String paramString, @NotNull Function1<? super Throwable, Boolean> paramFunction1)
  {
    if ((this.uncaughtExceptions.size() == 1) && (((Boolean)paramFunction1.invoke(this.uncaughtExceptions.get(0))).booleanValue()))
    {
      this.uncaughtExceptions.clear();
      return;
    }
    throw ((Throwable)new AssertionError(paramString));
  }
  
  public final void cancelAllActions()
  {
    if (!this.queue.isEmpty()) {
      this.queue.clear();
    }
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return paramFunction2.invoke(paramFunction2.invoke(paramR, this.ctxDispatcher), this.ctxHandler);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    if (paramKey == ContinuationInterceptor.Key)
    {
      paramKey = this.ctxDispatcher;
      if (paramKey != null) {
        return (CoroutineContext.Element)paramKey;
      }
      throw new TypeCastException("null cannot be cast to non-null type E");
    }
    if (paramKey == CoroutineExceptionHandler.Key)
    {
      paramKey = this.ctxHandler;
      if (paramKey != null) {
        return (CoroutineContext.Element)paramKey;
      }
      throw new TypeCastException("null cannot be cast to non-null type E");
    }
    return null;
  }
  
  @NotNull
  public final List<Throwable> getExceptions()
  {
    return this.uncaughtExceptions;
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    if (paramKey == ContinuationInterceptor.Key) {
      return (CoroutineContext)this.ctxHandler;
    }
    if (paramKey == CoroutineExceptionHandler.Key) {
      return (CoroutineContext)this.ctxDispatcher;
    }
    return (CoroutineContext)this;
  }
  
  public final long now(@NotNull TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.time, TimeUnit.NANOSECONDS);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    return CoroutineContext.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = this.name;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TestCoroutineContext@");
    ((StringBuilder)localObject).append(DebugStringsKt.getHexAddress(this));
    return ((StringBuilder)localObject).toString();
  }
  
  public final void triggerActions()
  {
    triggerActions(this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.test.TestCoroutineContext
 * JD-Core Version:    0.7.0.1
 */
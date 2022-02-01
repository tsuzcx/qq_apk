package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.Observer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.unsafe.UnsafeAccess;

public class RxRingBuffer
  implements Subscription
{
  public static final int SIZE;
  public static ObjectPool<Queue<Object>> SPMC_POOL;
  public static ObjectPool<Queue<Object>> SPSC_POOL;
  static int _size;
  private static final NotificationLite<Object> on = ;
  private final ObjectPool<Queue<Object>> pool;
  private Queue<Object> queue;
  private final int size;
  public volatile Object terminalState;
  
  static
  {
    _size = 128;
    if (PlatformDependent.isAndroid()) {
      _size = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      _size = Integer.parseInt(str);
      SIZE = _size;
      SPSC_POOL = new RxRingBuffer.1();
      SPMC_POOL = new RxRingBuffer.2();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.err.println("Failed to set 'rx.buffer.size' with value " + str + " => " + localException.getMessage());
      }
    }
  }
  
  RxRingBuffer()
  {
    this(new SynchronizedQueue(SIZE), SIZE);
  }
  
  private RxRingBuffer(Queue<Object> paramQueue, int paramInt)
  {
    this.queue = paramQueue;
    this.pool = null;
    this.size = paramInt;
  }
  
  private RxRingBuffer(ObjectPool<Queue<Object>> paramObjectPool, int paramInt)
  {
    this.pool = paramObjectPool;
    this.queue = ((Queue)paramObjectPool.borrowObject());
    this.size = paramInt;
  }
  
  public static RxRingBuffer getSpmcInstance()
  {
    if (UnsafeAccess.isUnsafeAvailable()) {
      return new RxRingBuffer(SPMC_POOL, SIZE);
    }
    return new RxRingBuffer();
  }
  
  public static RxRingBuffer getSpscInstance()
  {
    if (UnsafeAccess.isUnsafeAvailable()) {
      return new RxRingBuffer(SPSC_POOL, SIZE);
    }
    return new RxRingBuffer();
  }
  
  public boolean accept(Object paramObject, Observer paramObserver)
  {
    return on.accept(paramObserver, paramObject);
  }
  
  public Throwable asError(Object paramObject)
  {
    return on.getError(paramObject);
  }
  
  public int available()
  {
    return this.size - count();
  }
  
  public int capacity()
  {
    return this.size;
  }
  
  public int count()
  {
    Queue localQueue = this.queue;
    if (localQueue == null) {
      return 0;
    }
    return localQueue.size();
  }
  
  public Object getValue(Object paramObject)
  {
    return on.getValue(paramObject);
  }
  
  public boolean isCompleted(Object paramObject)
  {
    return on.isCompleted(paramObject);
  }
  
  public boolean isEmpty()
  {
    Queue localQueue = this.queue;
    if (localQueue == null) {
      return true;
    }
    return localQueue.isEmpty();
  }
  
  public boolean isError(Object paramObject)
  {
    return on.isError(paramObject);
  }
  
  public boolean isUnsubscribed()
  {
    return this.queue == null;
  }
  
  public void onCompleted()
  {
    if (this.terminalState == null) {
      this.terminalState = on.completed();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.terminalState == null) {
      this.terminalState = on.error(paramThrowable);
    }
  }
  
  public void onNext(Object paramObject)
  {
    int i = 1;
    int j = 0;
    try
    {
      Queue localQueue = this.queue;
      if (localQueue != null) {
        if (localQueue.offer(on.next(paramObject))) {}
      }
      for (;;)
      {
        if (j == 0) {
          break;
        }
        throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        i = 0;
        continue;
        j = 1;
        i = 0;
      }
      if (i == 0) {
        return;
      }
    }
    finally {}
    throw new MissingBackpressureException();
  }
  
  public Object peek()
  {
    for (;;)
    {
      try
      {
        Queue localQueue = this.queue;
        if (localQueue == null) {
          return null;
        }
        Object localObject1 = localQueue.peek();
        Object localObject3 = this.terminalState;
        if ((localObject1 == null) && (localObject3 != null) && (localQueue.peek() == null))
        {
          localObject1 = localObject3;
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public Object poll()
  {
    for (;;)
    {
      try
      {
        Queue localQueue = this.queue;
        if (localQueue == null) {
          return null;
        }
        Object localObject1 = localQueue.poll();
        Object localObject3 = this.terminalState;
        if ((localObject1 == null) && (localObject3 != null) && (localQueue.peek() == null))
        {
          this.terminalState = null;
          localObject1 = localObject3;
          return localObject1;
        }
      }
      finally {}
    }
  }
  
  public void release()
  {
    try
    {
      Queue localQueue = this.queue;
      ObjectPool localObjectPool = this.pool;
      if ((localObjectPool != null) && (localQueue != null))
      {
        localQueue.clear();
        this.queue = null;
        localObjectPool.returnObject(localQueue);
      }
      return;
    }
    finally {}
  }
  
  public void unsubscribe()
  {
    release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.util.RxRingBuffer
 * JD-Core Version:    0.7.0.1
 */
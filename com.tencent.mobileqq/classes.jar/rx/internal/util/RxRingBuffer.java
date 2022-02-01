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
  public static ObjectPool<Queue<Object>> SPMC_POOL = new RxRingBuffer.2();
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
    if (str != null) {
      try
      {
        _size = Integer.parseInt(str);
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to set 'rx.buffer.size' with value ");
        localStringBuilder.append(str);
        localStringBuilder.append(" => ");
        localStringBuilder.append(localException.getMessage());
        localPrintStream.println(localStringBuilder.toString());
      }
    }
    SIZE = _size;
    SPSC_POOL = new RxRingBuffer.1();
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
    for (;;)
    {
      try
      {
        Queue localQueue = this.queue;
        int i = 1;
        if (localQueue != null)
        {
          bool = localQueue.offer(on.next(paramObject)) ^ true;
          i = 0;
          if (i == 0)
          {
            if (!bool) {
              return;
            }
            throw new MissingBackpressureException();
          }
          throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public Object peek()
  {
    try
    {
      Queue localQueue = this.queue;
      if (localQueue == null) {
        return null;
      }
      Object localObject3 = localQueue.peek();
      Object localObject4 = this.terminalState;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (localQueue.peek() == null) {
            localObject1 = localObject4;
          }
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public Object poll()
  {
    try
    {
      Queue localQueue = this.queue;
      if (localQueue == null) {
        return null;
      }
      Object localObject3 = localQueue.poll();
      Object localObject4 = this.terminalState;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject1 = localObject3;
          if (localQueue.peek() == null)
          {
            this.terminalState = null;
            localObject1 = localObject4;
          }
        }
      }
      return localObject1;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.RxRingBuffer
 * JD-Core Version:    0.7.0.1
 */
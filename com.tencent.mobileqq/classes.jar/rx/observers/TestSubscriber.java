package rx.observers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;

public class TestSubscriber<T>
  extends Subscriber<T>
{
  private static final Observer<Object> INERT = new TestSubscriber.1();
  private volatile Thread lastSeenThread;
  private final CountDownLatch latch = new CountDownLatch(1);
  private final TestObserver<T> testObserver;
  
  public TestSubscriber()
  {
    this(-1L);
  }
  
  public TestSubscriber(long paramLong)
  {
    this(INERT, paramLong);
  }
  
  public TestSubscriber(Observer<T> paramObserver)
  {
    this(paramObserver, -1L);
  }
  
  public TestSubscriber(Observer<T> paramObserver, long paramLong)
  {
    if (paramObserver != null)
    {
      this.testObserver = new TestObserver(paramObserver);
      if (paramLong >= 0L) {
        request(paramLong);
      }
      return;
    }
    throw new NullPointerException();
  }
  
  public TestSubscriber(Subscriber<T> paramSubscriber)
  {
    this(paramSubscriber, -1L);
  }
  
  public static <T> TestSubscriber<T> create()
  {
    return new TestSubscriber();
  }
  
  public static <T> TestSubscriber<T> create(long paramLong)
  {
    return new TestSubscriber(paramLong);
  }
  
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver)
  {
    return new TestSubscriber(paramObserver);
  }
  
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver, long paramLong)
  {
    return new TestSubscriber(paramObserver, paramLong);
  }
  
  public static <T> TestSubscriber<T> create(Subscriber<T> paramSubscriber)
  {
    return new TestSubscriber(paramSubscriber);
  }
  
  public void assertCompleted()
  {
    int i = this.testObserver.getOnCompletedEvents().size();
    if (i != 0)
    {
      if (i <= 1) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Completed multiple times: ");
      localStringBuilder.append(i);
      throw new AssertionError(localStringBuilder.toString());
    }
    throw new AssertionError("Not completed!");
  }
  
  public void assertError(Class<? extends Throwable> paramClass)
  {
    List localList = this.testObserver.getOnErrorEvents();
    if (localList.size() != 0)
    {
      if (localList.size() <= 1)
      {
        if (paramClass.isInstance(localList.get(0))) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exceptions differ; expected: ");
        localStringBuilder.append(paramClass);
        localStringBuilder.append(", actual: ");
        localStringBuilder.append(localList.get(0));
        paramClass = new AssertionError(localStringBuilder.toString());
        paramClass.initCause((Throwable)localList.get(0));
        throw paramClass;
      }
      paramClass = new StringBuilder();
      paramClass.append("Multiple errors: ");
      paramClass.append(localList.size());
      paramClass = new AssertionError(paramClass.toString());
      paramClass.initCause(new CompositeException(localList));
      throw paramClass;
    }
    throw new AssertionError("No errors");
  }
  
  public void assertError(Throwable paramThrowable)
  {
    List localList = this.testObserver.getOnErrorEvents();
    if (localList.size() != 0)
    {
      if (localList.size() <= 1)
      {
        if (paramThrowable.equals(localList.get(0))) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exceptions differ; expected: ");
        localStringBuilder.append(paramThrowable);
        localStringBuilder.append(", actual: ");
        localStringBuilder.append(localList.get(0));
        paramThrowable = new AssertionError(localStringBuilder.toString());
        paramThrowable.initCause((Throwable)localList.get(0));
        throw paramThrowable;
      }
      paramThrowable = new StringBuilder();
      paramThrowable.append("Multiple errors: ");
      paramThrowable.append(localList.size());
      paramThrowable = new AssertionError(paramThrowable.toString());
      paramThrowable.initCause(new CompositeException(localList));
      throw paramThrowable;
    }
    throw new AssertionError("No errors");
  }
  
  public void assertNoErrors()
  {
    List localList = getOnErrorEvents();
    if (localList.size() > 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected onError events: ");
      ((StringBuilder)localObject).append(getOnErrorEvents().size());
      localObject = new AssertionError(((StringBuilder)localObject).toString());
      if (localList.size() == 1) {
        ((AssertionError)localObject).initCause((Throwable)getOnErrorEvents().get(0));
      } else {
        ((AssertionError)localObject).initCause(new CompositeException(localList));
      }
      throw ((Throwable)localObject);
    }
  }
  
  public void assertNoTerminalEvent()
  {
    List localList = this.testObserver.getOnErrorEvents();
    int i = this.testObserver.getOnCompletedEvents().size();
    if ((localList.size() <= 0) && (i <= 0)) {
      return;
    }
    if (!localList.isEmpty())
    {
      if (localList.size() == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Found ");
        ((StringBuilder)localObject).append(localList.size());
        ((StringBuilder)localObject).append(" errors and ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" completion events instead of none");
        localObject = new AssertionError(((StringBuilder)localObject).toString());
        ((AssertionError)localObject).initCause((Throwable)localList.get(0));
        throw ((Throwable)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Found ");
      ((StringBuilder)localObject).append(localList.size());
      ((StringBuilder)localObject).append(" errors and ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" completion events instead of none");
      localObject = new AssertionError(((StringBuilder)localObject).toString());
      ((AssertionError)localObject).initCause(new CompositeException(localList));
      throw ((Throwable)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Found ");
    ((StringBuilder)localObject).append(localList.size());
    ((StringBuilder)localObject).append(" errors and ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" completion events instead of none");
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  public void assertNoValues()
  {
    int i = this.testObserver.getOnNextEvents().size();
    if (i <= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No onNext events expected yet some received: ");
    localStringBuilder.append(i);
    throw new AssertionError(localStringBuilder.toString());
  }
  
  public void assertNotCompleted()
  {
    int i = this.testObserver.getOnCompletedEvents().size();
    if (i != 1)
    {
      if (i <= 1) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Completed multiple times: ");
      localStringBuilder.append(i);
      throw new AssertionError(localStringBuilder.toString());
    }
    throw new AssertionError("Completed!");
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    this.testObserver.assertReceivedOnNext(paramList);
  }
  
  public void assertTerminalEvent()
  {
    this.testObserver.assertTerminalEvent();
  }
  
  public void assertUnsubscribed()
  {
    if (isUnsubscribed()) {
      return;
    }
    throw new AssertionError("Not unsubscribed.");
  }
  
  public void assertValue(T paramT)
  {
    assertReceivedOnNext(Collections.singletonList(paramT));
  }
  
  public void assertValueCount(int paramInt)
  {
    int i = this.testObserver.getOnNextEvents().size();
    if (i == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Number of onNext events differ; expected: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", actual: ");
    localStringBuilder.append(i);
    throw new AssertionError(localStringBuilder.toString());
  }
  
  public void assertValues(T... paramVarArgs)
  {
    assertReceivedOnNext(Arrays.asList(paramVarArgs));
  }
  
  public void awaitTerminalEvent()
  {
    try
    {
      this.latch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException("Interrupted", localInterruptedException);
    }
  }
  
  public void awaitTerminalEvent(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      this.latch.await(paramLong, paramTimeUnit);
      return;
    }
    catch (InterruptedException paramTimeUnit)
    {
      throw new RuntimeException("Interrupted", paramTimeUnit);
    }
  }
  
  public void awaitTerminalEventAndUnsubscribeOnTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      if (this.latch.await(paramLong, paramTimeUnit)) {
        break label21;
      }
      unsubscribe();
      return;
    }
    catch (InterruptedException paramTimeUnit)
    {
      label17:
      label21:
      break label17;
    }
    unsubscribe();
  }
  
  public Thread getLastSeenThread()
  {
    return this.lastSeenThread;
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return this.testObserver.getOnCompletedEvents();
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return this.testObserver.getOnErrorEvents();
  }
  
  public List<T> getOnNextEvents()
  {
    return this.testObserver.getOnNextEvents();
  }
  
  public void onCompleted()
  {
    try
    {
      this.lastSeenThread = Thread.currentThread();
      this.testObserver.onCompleted();
      return;
    }
    finally
    {
      this.latch.countDown();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.lastSeenThread = Thread.currentThread();
      this.testObserver.onError(paramThrowable);
      return;
    }
    finally
    {
      this.latch.countDown();
    }
  }
  
  public void onNext(T paramT)
  {
    this.lastSeenThread = Thread.currentThread();
    this.testObserver.onNext(paramT);
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observers.TestSubscriber
 * JD-Core Version:    0.7.0.1
 */
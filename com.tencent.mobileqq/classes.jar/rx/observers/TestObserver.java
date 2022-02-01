package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;

public class TestObserver<T>
  implements Observer<T>
{
  private static Observer<Object> INERT = new TestObserver.1();
  private final Observer<T> delegate;
  private final ArrayList<Notification<T>> onCompletedEvents = new ArrayList();
  private final ArrayList<Throwable> onErrorEvents = new ArrayList();
  private final ArrayList<T> onNextEvents = new ArrayList();
  
  public TestObserver()
  {
    this.delegate = INERT;
  }
  
  public TestObserver(Observer<T> paramObserver)
  {
    this.delegate = paramObserver;
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    if (this.onNextEvents.size() == paramList.size())
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject2 = paramList.get(i);
        Object localObject1 = this.onNextEvents.get(i);
        if (localObject2 == null)
        {
          if (localObject1 != null)
          {
            paramList = new StringBuilder();
            paramList.append("Value at index: ");
            paramList.append(i);
            paramList.append(" expected to be [null] but was: [");
            paramList.append(localObject1);
            paramList.append("]");
            throw new AssertionError(paramList.toString());
          }
        }
        else if (!localObject2.equals(localObject1))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Value at index: ");
          localStringBuilder.append(i);
          localStringBuilder.append(" expected to be [");
          localStringBuilder.append(localObject2);
          localStringBuilder.append("] (");
          localStringBuilder.append(localObject2.getClass().getSimpleName());
          localStringBuilder.append(") but was: [");
          localStringBuilder.append(localObject1);
          localStringBuilder.append("] (");
          if (localObject1 != null) {
            paramList = localObject1.getClass().getSimpleName();
          } else {
            paramList = "null";
          }
          localStringBuilder.append(paramList);
          localStringBuilder.append(")");
          throw new AssertionError(localStringBuilder.toString());
        }
        i += 1;
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Number of items does not match. Provided: ");
    localStringBuilder.append(paramList.size());
    localStringBuilder.append("  Actual: ");
    localStringBuilder.append(this.onNextEvents.size());
    paramList = new AssertionError(localStringBuilder.toString());
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void assertTerminalEvent()
  {
    if (this.onErrorEvents.size() <= 1)
    {
      if (this.onCompletedEvents.size() <= 1)
      {
        if ((this.onCompletedEvents.size() == 1) && (this.onErrorEvents.size() == 1)) {
          throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
        }
        if (this.onCompletedEvents.size() == 0)
        {
          if (this.onErrorEvents.size() != 0) {
            return;
          }
          throw new AssertionError("No terminal events received.");
        }
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Too many onCompleted events: ");
      localStringBuilder.append(this.onCompletedEvents.size());
      throw new AssertionError(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Too many onError events: ");
    localStringBuilder.append(this.onErrorEvents.size());
    throw new AssertionError(localStringBuilder.toString());
  }
  
  public List<Object> getEvents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.onNextEvents);
    localArrayList.add(this.onErrorEvents);
    localArrayList.add(this.onCompletedEvents);
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return Collections.unmodifiableList(this.onCompletedEvents);
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return Collections.unmodifiableList(this.onErrorEvents);
  }
  
  public List<T> getOnNextEvents()
  {
    return Collections.unmodifiableList(this.onNextEvents);
  }
  
  public void onCompleted()
  {
    this.onCompletedEvents.add(Notification.createOnCompleted());
    this.delegate.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.onErrorEvents.add(paramThrowable);
    this.delegate.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.onNextEvents.add(paramT);
    this.delegate.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observers.TestObserver
 * JD-Core Version:    0.7.0.1
 */
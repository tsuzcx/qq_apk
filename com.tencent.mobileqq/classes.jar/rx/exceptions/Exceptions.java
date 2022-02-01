package rx.exceptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Observer;
import rx.SingleSubscriber;
import rx.annotations.Experimental;

public final class Exceptions
{
  private static final int MAX_DEPTH = 25;
  
  private Exceptions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static void addCause(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    Throwable localThrowable;
    for (;;)
    {
      localThrowable = paramThrowable1;
      if (paramThrowable1.getCause() == null) {
        break;
      }
      if (i >= 25) {
        return;
      }
      paramThrowable1 = paramThrowable1.getCause();
      if (localHashSet.contains(paramThrowable1.getCause()))
      {
        localThrowable = paramThrowable1;
        break;
      }
      localHashSet.add(paramThrowable1.getCause());
      i += 1;
    }
    try
    {
      localThrowable.initCause(paramThrowable2);
      return;
    }
    catch (Throwable paramThrowable1) {}
  }
  
  public static Throwable getFinalCause(Throwable paramThrowable)
  {
    int i = 0;
    while (paramThrowable.getCause() != null)
    {
      if (i >= 25) {
        return new RuntimeException("Stack too deep to get final cause");
      }
      paramThrowable = paramThrowable.getCause();
      i += 1;
    }
    return paramThrowable;
  }
  
  public static RuntimeException propagate(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof RuntimeException))
    {
      if ((paramThrowable instanceof Error)) {
        throw ((Error)paramThrowable);
      }
      throw new RuntimeException(paramThrowable);
    }
    throw ((RuntimeException)paramThrowable);
  }
  
  public static void throwIfAny(List<? extends Throwable> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() == 1)
      {
        paramList = (Throwable)paramList.get(0);
        if (!(paramList instanceof RuntimeException))
        {
          if ((paramList instanceof Error)) {
            throw ((Error)paramList);
          }
          throw new RuntimeException(paramList);
        }
        throw ((RuntimeException)paramList);
      }
      throw new CompositeException("Multiple exceptions", paramList);
    }
  }
  
  public static void throwIfFatal(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof OnErrorNotImplementedException))
    {
      if (!(paramThrowable instanceof OnErrorFailedException))
      {
        if (!(paramThrowable instanceof StackOverflowError))
        {
          if (!(paramThrowable instanceof VirtualMachineError))
          {
            if (!(paramThrowable instanceof ThreadDeath))
            {
              if (!(paramThrowable instanceof LinkageError)) {
                return;
              }
              throw ((LinkageError)paramThrowable);
            }
            throw ((ThreadDeath)paramThrowable);
          }
          throw ((VirtualMachineError)paramThrowable);
        }
        throw ((StackOverflowError)paramThrowable);
      }
      throw ((OnErrorFailedException)paramThrowable);
    }
    throw ((OnErrorNotImplementedException)paramThrowable);
  }
  
  @Experimental
  public static void throwOrReport(Throwable paramThrowable, Observer<?> paramObserver)
  {
    throwIfFatal(paramThrowable);
    paramObserver.onError(paramThrowable);
  }
  
  @Experimental
  public static void throwOrReport(Throwable paramThrowable, Observer<?> paramObserver, Object paramObject)
  {
    throwIfFatal(paramThrowable);
    paramObserver.onError(OnErrorThrowable.addValueAsLastCause(paramThrowable, paramObject));
  }
  
  @Experimental
  public static void throwOrReport(Throwable paramThrowable, SingleSubscriber<?> paramSingleSubscriber)
  {
    throwIfFatal(paramThrowable);
    paramSingleSubscriber.onError(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.exceptions.Exceptions
 * JD-Core Version:    0.7.0.1
 */
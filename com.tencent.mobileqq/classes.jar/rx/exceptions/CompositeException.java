package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import rx.annotations.Experimental;

public final class CompositeException
  extends RuntimeException
{
  private static final long serialVersionUID = 3026362227162912146L;
  private Throwable cause = null;
  private final List<Throwable> exceptions;
  private final String message;
  
  public CompositeException(String paramString, Collection<? extends Throwable> paramCollection)
  {
    paramString = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Throwable localThrowable = (Throwable)paramCollection.next();
        if ((localThrowable instanceof CompositeException)) {
          paramString.addAll(((CompositeException)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          paramString.add(localThrowable);
        } else {
          paramString.add(new NullPointerException());
        }
      }
    }
    paramString.add(new NullPointerException());
    localArrayList.addAll(paramString);
    this.exceptions = Collections.unmodifiableList(localArrayList);
    paramString = new StringBuilder();
    paramString.append(this.exceptions.size());
    paramString.append(" exceptions occurred. ");
    this.message = paramString.toString();
  }
  
  public CompositeException(Collection<? extends Throwable> paramCollection)
  {
    this(null, paramCollection);
  }
  
  @Experimental
  public CompositeException(Throwable... paramVarArgs)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Throwable localThrowable = paramVarArgs[i];
        if ((localThrowable instanceof CompositeException)) {
          localLinkedHashSet.addAll(((CompositeException)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          localLinkedHashSet.add(localThrowable);
        } else {
          localLinkedHashSet.add(new NullPointerException());
        }
        i += 1;
      }
    }
    localLinkedHashSet.add(new NullPointerException());
    localArrayList.addAll(localLinkedHashSet);
    this.exceptions = Collections.unmodifiableList(localArrayList);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(this.exceptions.size());
    paramVarArgs.append(" exceptions occurred. ");
    this.message = paramVarArgs.toString();
  }
  
  private void appendStackTrace(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(paramThrowable);
    paramStringBuilder.append("\n");
    paramString = paramThrowable.getStackTrace();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      paramStringBuilder.append("\t\tat ");
      paramStringBuilder.append(localObject);
      paramStringBuilder.append("\n");
      i += 1;
    }
    if (paramThrowable.getCause() != null)
    {
      paramStringBuilder.append("\tCaused by: ");
      appendStackTrace(paramStringBuilder, paramThrowable.getCause(), "");
    }
  }
  
  private List<Throwable> getListOfCauses(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    Throwable localThrowable = paramThrowable.getCause();
    paramThrowable = localThrowable;
    if (localThrowable == null) {
      return localArrayList;
    }
    for (;;)
    {
      localArrayList.add(paramThrowable);
      if (paramThrowable.getCause() == null) {
        return localArrayList;
      }
      paramThrowable = paramThrowable.getCause();
    }
  }
  
  private void printStackTrace(CompositeException.PrintStreamOrWriter paramPrintStreamOrWriter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append("\n");
    ??? = getStackTrace();
    int j = ???.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ???[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    ??? = this.exceptions.iterator();
    i = 1;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Throwable)((Iterator)???).next();
      localStringBuilder.append("  ComposedException ");
      localStringBuilder.append(i);
      localStringBuilder.append(" :");
      localStringBuilder.append("\n");
      appendStackTrace(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    synchronized (paramPrintStreamOrWriter.lock())
    {
      paramPrintStreamOrWriter.println(localStringBuilder.toString());
      return;
    }
    for (;;)
    {
      throw paramPrintStreamOrWriter;
    }
  }
  
  public Throwable getCause()
  {
    for (;;)
    {
      try
      {
        if (this.cause == null)
        {
          localCompositeExceptionCausalChain = new CompositeException.CompositeExceptionCausalChain();
          HashSet localHashSet = new HashSet();
          Iterator localIterator1 = this.exceptions.iterator();
          localObject1 = localCompositeExceptionCausalChain;
          if (localIterator1.hasNext())
          {
            localObject3 = (Throwable)localIterator1.next();
            if (localHashSet.contains(localObject3)) {
              continue;
            }
            localHashSet.add(localObject3);
            Iterator localIterator2 = getListOfCauses((Throwable)localObject3).iterator();
            if (localIterator2.hasNext())
            {
              Throwable localThrowable2 = (Throwable)localIterator2.next();
              if (localHashSet.contains(localThrowable2))
              {
                localObject3 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                continue;
              }
              localHashSet.add(localThrowable2);
              continue;
            }
          }
        }
      }
      finally
      {
        CompositeException.CompositeExceptionCausalChain localCompositeExceptionCausalChain;
        Object localObject1;
        Object localObject3;
        continue;
        throw localObject2;
        continue;
      }
      try
      {
        ((Throwable)localObject1).initCause((Throwable)localObject3);
        localObject1 = ((Throwable)localObject1).getCause();
      }
      catch (Throwable localThrowable1)
      {
        continue;
      }
      localObject1 = localObject3;
    }
    this.cause = localCompositeExceptionCausalChain;
    localObject1 = this.cause;
    return localObject1;
  }
  
  public List<Throwable> getExceptions()
  {
    return this.exceptions;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    printStackTrace(new CompositeException.WrappedPrintStream(paramPrintStream));
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    printStackTrace(new CompositeException.WrappedPrintWriter(paramPrintWriter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.exceptions.CompositeException
 * JD-Core Version:    0.7.0.1
 */
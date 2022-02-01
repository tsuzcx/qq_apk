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
    this.message = (this.exceptions.size() + " exceptions occurred. ");
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
      if (i < j)
      {
        Throwable localThrowable = paramVarArgs[i];
        if ((localThrowable instanceof CompositeException)) {
          localLinkedHashSet.addAll(((CompositeException)localThrowable).getExceptions());
        }
        for (;;)
        {
          i += 1;
          break;
          if (localThrowable != null) {
            localLinkedHashSet.add(localThrowable);
          } else {
            localLinkedHashSet.add(new NullPointerException());
          }
        }
      }
    }
    else
    {
      localLinkedHashSet.add(new NullPointerException());
    }
    localArrayList.addAll(localLinkedHashSet);
    this.exceptions = Collections.unmodifiableList(localArrayList);
    this.message = (this.exceptions.size() + " exceptions occurred. ");
  }
  
  private void appendStackTrace(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    paramStringBuilder.append(paramString).append(paramThrowable).append("\n");
    paramString = paramThrowable.getStackTrace();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      paramStringBuilder.append("\t\tat ").append(localObject).append("\n");
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
    do
    {
      paramThrowable = paramThrowable.getCause();
      localArrayList.add(paramThrowable);
    } while (paramThrowable.getCause() != null);
    return localArrayList;
  }
  
  private void printStackTrace(CompositeException.PrintStreamOrWriter paramPrintStreamOrWriter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this).append("\n");
    ??? = getStackTrace();
    int j = ???.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ???[i];
      localStringBuilder.append("\tat ").append(localObject2).append("\n");
      i += 1;
    }
    ??? = this.exceptions.iterator();
    i = 1;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Throwable)((Iterator)???).next();
      localStringBuilder.append("  ComposedException ").append(i).append(" :").append("\n");
      appendStackTrace(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    synchronized (paramPrintStreamOrWriter.lock())
    {
      paramPrintStreamOrWriter.println(localStringBuilder.toString());
      return;
    }
  }
  
  public Throwable getCause()
  {
    CompositeException.CompositeExceptionCausalChain localCompositeExceptionCausalChain;
    for (;;)
    {
      try
      {
        if (this.cause != null) {
          break label184;
        }
        localCompositeExceptionCausalChain = new CompositeException.CompositeExceptionCausalChain();
        HashSet localHashSet = new HashSet();
        Iterator localIterator1 = this.exceptions.iterator();
        localObject3 = localCompositeExceptionCausalChain;
        if (!localIterator1.hasNext()) {
          break label179;
        }
        Object localObject1 = (Throwable)localIterator1.next();
        if (localHashSet.contains(localObject1)) {
          continue;
        }
        localHashSet.add(localObject1);
        Iterator localIterator2 = getListOfCauses((Throwable)localObject1).iterator();
        if (!localIterator2.hasNext()) {
          break label157;
        }
        Throwable localThrowable3 = (Throwable)localIterator2.next();
        if (localHashSet.contains(localThrowable3))
        {
          localObject1 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
          continue;
        }
        localHashSet.add(localThrowable3);
      }
      finally {}
      continue;
      try
      {
        label157:
        ((Throwable)localObject3).initCause(localThrowable1);
        localObject3 = ((Throwable)localObject3).getCause();
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable2)
      {
        label170:
        break label170;
      }
      Object localObject3 = localObject2;
    }
    label179:
    this.cause = localCompositeExceptionCausalChain;
    label184:
    Object localObject2 = this.cause;
    return localObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.exceptions.CompositeException
 * JD-Core Version:    0.7.0.1
 */
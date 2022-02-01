package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate
  implements Serializable
{
  private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
  static Class class$org$apache$commons$lang$exception$Nestable;
  public static boolean matchSubclasses = true;
  private static final long serialVersionUID = 1L;
  public static boolean topDown = true;
  public static boolean trimStackFrames = true;
  private Throwable nestable = null;
  
  public NestableDelegate(Nestable paramNestable)
  {
    if ((paramNestable instanceof Throwable))
    {
      this.nestable = ((Throwable)paramNestable);
      return;
    }
    throw new IllegalArgumentException("The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable");
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  public String getMessage(int paramInt)
  {
    Throwable localThrowable = getThrowable(paramInt);
    Class localClass2 = class$org$apache$commons$lang$exception$Nestable;
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = class$("org.apache.commons.lang.exception.Nestable");
      class$org$apache$commons$lang$exception$Nestable = localClass1;
    }
    if (localClass1.isInstance(localThrowable)) {
      return ((Nestable)localThrowable).getMessage(0);
    }
    return localThrowable.getMessage();
  }
  
  public String getMessage(String paramString)
  {
    Throwable localThrowable = ExceptionUtils.getCause(this.nestable);
    String str;
    if (localThrowable == null) {
      str = null;
    } else {
      str = localThrowable.getMessage();
    }
    Object localObject = paramString;
    if (localThrowable != null)
    {
      if (str == null) {
        return paramString;
      }
      if (paramString == null) {
        return str;
      }
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(paramString);
      ((StringBuffer)localObject).append(": ");
      ((StringBuffer)localObject).append(str);
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public String[] getMessages()
  {
    Throwable[] arrayOfThrowable = getThrowables();
    String[] arrayOfString = new String[arrayOfThrowable.length];
    int i = 0;
    while (i < arrayOfThrowable.length)
    {
      Class localClass = class$org$apache$commons$lang$exception$Nestable;
      Object localObject = localClass;
      if (localClass == null)
      {
        localObject = class$("org.apache.commons.lang.exception.Nestable");
        class$org$apache$commons$lang$exception$Nestable = (Class)localObject;
      }
      if (((Class)localObject).isInstance(arrayOfThrowable[i])) {
        localObject = ((Nestable)arrayOfThrowable[i]).getMessage(0);
      } else {
        localObject = arrayOfThrowable[i].getMessage();
      }
      arrayOfString[i] = localObject;
      i += 1;
    }
    return arrayOfString;
  }
  
  protected String[] getStackFrames(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    if ((paramThrowable instanceof Nestable)) {
      ((Nestable)paramThrowable).printPartialStackTrace(localPrintWriter);
    } else {
      paramThrowable.printStackTrace(localPrintWriter);
    }
    return ExceptionUtils.getStackFrames(localStringWriter.getBuffer().toString());
  }
  
  public Throwable getThrowable(int paramInt)
  {
    if (paramInt == 0) {
      return this.nestable;
    }
    return getThrowables()[paramInt];
  }
  
  public int getThrowableCount()
  {
    return ExceptionUtils.getThrowableCount(this.nestable);
  }
  
  public Throwable[] getThrowables()
  {
    return ExceptionUtils.getThrowables(this.nestable);
  }
  
  public int indexOfThrowable(Class paramClass, int paramInt)
  {
    if (paramClass == null) {
      return -1;
    }
    if (paramInt >= 0)
    {
      Throwable[] arrayOfThrowable = ExceptionUtils.getThrowables(this.nestable);
      if (paramInt < arrayOfThrowable.length)
      {
        int i = paramInt;
        if (matchSubclasses) {
          while (paramInt < arrayOfThrowable.length)
          {
            if (paramClass.isAssignableFrom(arrayOfThrowable[paramInt].getClass())) {
              return paramInt;
            }
            paramInt += 1;
          }
        }
        while (i < arrayOfThrowable.length)
        {
          if (paramClass.equals(arrayOfThrowable[i].getClass())) {
            return i;
          }
          i += 1;
        }
        return -1;
      }
      paramClass = new StringBuffer();
      paramClass.append("The start index was out of bounds: ");
      paramClass.append(paramInt);
      paramClass.append(" >= ");
      paramClass.append(arrayOfThrowable.length);
      throw new IndexOutOfBoundsException(paramClass.toString());
    }
    paramClass = new StringBuffer();
    paramClass.append("The start index was out of bounds: ");
    paramClass.append(paramInt);
    paramClass = new IndexOutOfBoundsException(paramClass.toString());
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(paramPrintStream, false);
      printStackTrace(localPrintWriter);
      localPrintWriter.flush();
      return;
    }
    finally {}
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    Object localObject1 = this.nestable;
    if (ExceptionUtils.isThrowableNested())
    {
      if ((localObject1 instanceof Nestable))
      {
        ((Nestable)localObject1).printPartialStackTrace(paramPrintWriter);
        return;
      }
      ((Throwable)localObject1).printStackTrace(paramPrintWriter);
      return;
    }
    Object localObject3 = new ArrayList();
    while (localObject1 != null)
    {
      ((List)localObject3).add(getStackFrames((Throwable)localObject1));
      localObject1 = ExceptionUtils.getCause((Throwable)localObject1);
    }
    if (!topDown)
    {
      Collections.reverse((List)localObject3);
      localObject1 = "Rethrown as: ";
    }
    else
    {
      localObject1 = "Caused by: ";
    }
    if (trimStackFrames) {
      trimStackFrames((List)localObject3);
    }
    try
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String[] arrayOfString = (String[])((Iterator)localObject3).next();
        int i = 0;
        int j = arrayOfString.length;
        while (i < j)
        {
          paramPrintWriter.println(arrayOfString[i]);
          i += 1;
        }
        if (((Iterator)localObject3).hasNext()) {
          paramPrintWriter.print((String)localObject1);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected void trimStackFrames(List paramList)
  {
    int i = paramList.size() - 1;
    while (i > 0)
    {
      Object localObject = (String[])paramList.get(i);
      String[] arrayOfString = (String[])paramList.get(i - 1);
      ArrayList localArrayList = new ArrayList(Arrays.asList((Object[])localObject));
      ExceptionUtils.removeCommonFrames(localArrayList, new ArrayList(Arrays.asList(arrayOfString)));
      int j = localObject.length - localArrayList.size();
      if (j > 0)
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("\t... ");
        ((StringBuffer)localObject).append(j);
        ((StringBuffer)localObject).append(" more");
        localArrayList.add(((StringBuffer)localObject).toString());
        paramList.set(i, localArrayList.toArray(new String[localArrayList.size()]));
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.exception.NestableDelegate
 * JD-Core Version:    0.7.0.1
 */
package org.aspectj.runtime.internal;

import java.util.Stack;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.runtime.CFlow;
import org.aspectj.runtime.internal.cflowstack.ThreadStack;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;

public class CFlowStack
{
  private static ThreadStackFactory tsFactory;
  private ThreadStack stackProxy = tsFactory.getNewThreadStack();
  
  static {}
  
  private static String getSystemPropertyWithoutSecurityException(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = System.getProperty(paramString1, paramString2);
      return paramString1;
    }
    catch (SecurityException paramString1) {}
    return paramString2;
  }
  
  private static ThreadStackFactory getThreadLocalStackFactory()
  {
    return new ThreadStackFactoryImpl();
  }
  
  private static ThreadStackFactory getThreadLocalStackFactoryFor11()
  {
    return new ThreadStackFactoryImpl11();
  }
  
  private Stack getThreadStack()
  {
    return this.stackProxy.getThreadStack();
  }
  
  public static String getThreadStackFactoryClassName()
  {
    return tsFactory.getClass().getName();
  }
  
  private static void selectFactoryForVMVersion()
  {
    String str = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
    boolean bool = str.equals("unspecified");
    int i = 0;
    if (bool)
    {
      if (System.getProperty("java.class.version", "0.0").compareTo("46.0") < 0) {}
    }
    else {
      while ((str.equals("yes")) || (str.equals("true")))
      {
        i = 1;
        break;
      }
    }
    if (i != 0)
    {
      tsFactory = getThreadLocalStackFactory();
      return;
    }
    tsFactory = getThreadLocalStackFactoryFor11();
  }
  
  public Object get(int paramInt)
  {
    CFlow localCFlow = peekCFlow();
    if (localCFlow == null) {
      return null;
    }
    return localCFlow.get(paramInt);
  }
  
  public boolean isValid()
  {
    return getThreadStack().isEmpty() ^ true;
  }
  
  public Object peek()
  {
    Stack localStack = getThreadStack();
    if (!localStack.isEmpty()) {
      return localStack.peek();
    }
    throw new NoAspectBoundException();
  }
  
  public CFlow peekCFlow()
  {
    Stack localStack = getThreadStack();
    if (localStack.isEmpty()) {
      return null;
    }
    return (CFlow)localStack.peek();
  }
  
  public Object peekInstance()
  {
    CFlow localCFlow = peekCFlow();
    if (localCFlow != null) {
      return localCFlow.getAspect();
    }
    throw new NoAspectBoundException();
  }
  
  public CFlow peekTopCFlow()
  {
    Stack localStack = getThreadStack();
    if (localStack.isEmpty()) {
      return null;
    }
    return (CFlow)localStack.elementAt(0);
  }
  
  public void pop()
  {
    Stack localStack = getThreadStack();
    localStack.pop();
    if (localStack.isEmpty()) {
      this.stackProxy.removeThreadStack();
    }
  }
  
  public void push(Object paramObject)
  {
    getThreadStack().push(paramObject);
  }
  
  public void push(Object[] paramArrayOfObject)
  {
    getThreadStack().push(new CFlowPlusState(paramArrayOfObject));
  }
  
  public void pushInstance(Object paramObject)
  {
    getThreadStack().push(new CFlow(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.internal.CFlowStack
 * JD-Core Version:    0.7.0.1
 */
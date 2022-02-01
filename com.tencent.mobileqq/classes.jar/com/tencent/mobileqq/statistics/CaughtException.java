package com.tencent.mobileqq.statistics;

import amtj;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CaughtException
  extends Exception
{
  public static final String ADVICE = amtj.a(2131700614);
  private static HashSet<String> a = new CaughtException.1();
  
  public CaughtException(String paramString)
  {
    this(paramString, null);
  }
  
  public CaughtException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    a();
    b();
  }
  
  private void a()
  {
    StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
    ArrayList localArrayList = new ArrayList(arrayOfStackTraceElement.length);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!a(localStackTraceElement)) {
        localArrayList.add(localStackTraceElement);
      }
      i += 1;
    }
    setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[localArrayList.size()]));
  }
  
  private boolean a(StackTraceElement paramStackTraceElement)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramStackTraceElement.toString().contains(str)) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    String str = getMessage();
    try
    {
      Field localField = Throwable.class.getDeclaredField("detailMessage");
      localField.setAccessible(true);
      localField.set(this, ADVICE + str);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.CaughtException
 * JD-Core Version:    0.7.0.1
 */
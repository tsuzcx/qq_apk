package com.tencent.qqperf.monitor.crash.catchedexception;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CaughtException
  extends Exception
{
  private static HashSet<String> spareStackWords = new CaughtException.1();
  
  public CaughtException(String paramString)
  {
    this(paramString, null);
  }
  
  public CaughtException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    filterSpareStack();
    modifySelfMessage();
  }
  
  public CaughtException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  private void filterSpareStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
    ArrayList localArrayList = new ArrayList(arrayOfStackTraceElement.length);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!spareStack(localStackTraceElement)) {
        localArrayList.add(localStackTraceElement);
      }
      i += 1;
    }
    setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[localArrayList.size()]));
  }
  
  private void modifySelfMessage()
  {
    String str = getMessage();
    try
    {
      Field localField = Throwable.class.getDeclaredField("detailMessage");
      localField.setAccessible(true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("这不是异常");
      localStringBuilder.append(str);
      localField.set(this, localStringBuilder.toString());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }
  
  private boolean spareStack(StackTraceElement paramStackTraceElement)
  {
    Iterator localIterator = spareStackWords.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramStackTraceElement.toString().contains(str)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.catchedexception.CaughtException
 * JD-Core Version:    0.7.0.1
 */
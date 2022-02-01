package com.tencent.tmassistantbase.util.b;

import android.util.Log;
import java.util.Arrays;
import java.util.List;

class a
{
  private StringBuilder a = new StringBuilder();
  private boolean b = true;
  private StringBuilder c = new StringBuilder();
  private boolean d = true;
  private StringBuilder e = new StringBuilder();
  
  public static a a()
  {
    return new a();
  }
  
  public static String c(String paramString)
  {
    try
    {
      arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
      localObject2 = "<unknown>";
      i = 2;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        StackTraceElement[] arrayOfStackTraceElement;
        Object localObject2;
        int i;
        Object localObject1;
        label84:
        continue;
        i += 1;
      }
    }
    localObject1 = localObject2;
    if (i < arrayOfStackTraceElement.length)
    {
      if (!arrayOfStackTraceElement[i].getClass().equals(a.class))
      {
        localObject2 = arrayOfStackTraceElement[i].getClassName();
        localObject1 = localObject2;
      }
    }
    else
    {
      try
      {
        localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf('.') + 1);
        localObject1 = localObject2;
        localObject2 = ((String)localObject2).substring(((String)localObject2).lastIndexOf('$') + 1);
        localObject1 = localObject2;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        break label84;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".");
      ((StringBuilder)localObject2).append(arrayOfStackTraceElement[i].getMethodName());
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(arrayOfStackTraceElement[i].getLineNumber());
      ((StringBuilder)localObject2).append(")");
      localObject1 = ((StringBuilder)localObject2).toString();
      paramString = String.format("[%s:%d] %s: %s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), localObject1, paramString });
      return paramString;
      System.gc();
      return "";
    }
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.append("|");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append(this.e);
    localStringBuilder.append("^");
    return c(localStringBuilder.toString());
  }
  
  public a a(String paramString)
  {
    if (this.b)
    {
      this.b = false;
      this.a.append(paramString);
      return this;
    }
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    return this;
  }
  
  public void a(Throwable paramThrowable)
  {
    Log.e("LogBuilder", e(), paramThrowable);
  }
  
  public a b(String paramString)
  {
    if (this.d)
    {
      this.d = false;
      this.c.append(paramString);
      return this;
    }
    StringBuilder localStringBuilder = this.c;
    localStringBuilder.append("$");
    localStringBuilder.append(paramString);
    return this;
  }
  
  public void b()
  {
    Log.i("LogBuilder", e());
  }
  
  public void c()
  {
    Log.e("LogBuilder", e());
  }
  
  public a d()
  {
    Object localObject = new Throwable().fillInStackTrace().getStackTrace();
    int j = localObject.length;
    int i = 6;
    if (6 >= j) {
      i = localObject.length;
    }
    localObject = Arrays.asList((Object[])localObject).subList(2, i);
    this.e.append('[');
    i = 0;
    while (i < ((List)localObject).size())
    {
      StringBuilder localStringBuilder = this.e;
      localStringBuilder.append(((StackTraceElement)((List)localObject).get(i)).getFileName());
      localStringBuilder.append('-');
      localStringBuilder.append(((StackTraceElement)((List)localObject).get(i)).getLineNumber());
      localStringBuilder.append(':');
      localStringBuilder.append(((StackTraceElement)((List)localObject).get(i)).getMethodName());
      localStringBuilder.append(',');
      i += 1;
    }
    localObject = this.e;
    ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1).append(']');
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.b.a
 * JD-Core Version:    0.7.0.1
 */
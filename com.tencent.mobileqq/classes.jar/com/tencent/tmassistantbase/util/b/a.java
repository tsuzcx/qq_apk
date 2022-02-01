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
    int i = 2;
    for (;;)
    {
      try
      {
        arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
        str2 = "<unknown>";
        str1 = str2;
        if (i < arrayOfStackTraceElement.length)
        {
          if (arrayOfStackTraceElement[i].getClass().equals(a.class)) {
            continue;
          }
          str2 = arrayOfStackTraceElement[i].getClassName();
          str1 = str2;
        }
      }
      catch (Throwable paramString)
      {
        StackTraceElement[] arrayOfStackTraceElement;
        String str2;
        String str1;
        System.gc();
        return "";
      }
      try
      {
        str2 = str2.substring(str2.lastIndexOf('.') + 1);
        str1 = str2;
        str2 = str2.substring(str2.lastIndexOf('$') + 1);
        str1 = str2;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        continue;
      }
      str1 = str1 + "." + arrayOfStackTraceElement[i].getMethodName() + "(" + arrayOfStackTraceElement[i].getLineNumber() + ")";
      paramString = String.format("[%s:%d] %s: %s", new Object[] { Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), str1, paramString });
      return paramString;
      i += 1;
    }
  }
  
  private String e()
  {
    return c("|" + this.c + "|" + this.e + "^");
  }
  
  public a a(String paramString)
  {
    if (this.b)
    {
      this.b = false;
      this.a.append(paramString);
      return this;
    }
    this.a.append("$").append(paramString);
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
    this.c.append("$").append(paramString);
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
    int i = 6;
    Object localObject = new Throwable().fillInStackTrace().getStackTrace();
    if (6 < localObject.length) {}
    for (;;)
    {
      localObject = Arrays.asList((Object[])localObject).subList(2, i);
      this.e.append('[');
      i = 0;
      while (i < ((List)localObject).size())
      {
        this.e.append(((StackTraceElement)((List)localObject).get(i)).getFileName()).append('-').append(((StackTraceElement)((List)localObject).get(i)).getLineNumber()).append(':').append(((StackTraceElement)((List)localObject).get(i)).getMethodName()).append(',');
        i += 1;
      }
      i = localObject.length;
    }
    this.e.deleteCharAt(this.e.length() - 1).append(']');
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.b.a
 * JD-Core Version:    0.7.0.1
 */
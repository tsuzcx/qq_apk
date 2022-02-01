package com.tencent.qapmsdk.impl.instrumentation.b;

import java.util.EventObject;

public class c
  extends EventObject
{
  private static final long serialVersionUID = 1L;
  private final long a;
  private final Exception b;
  
  public c(Object paramObject, long paramLong)
  {
    this(paramObject, paramLong, (Exception)null);
  }
  
  public c(Object paramObject, long paramLong, Exception paramException)
  {
    super(paramObject);
    this.a = paramLong;
    this.b = paramException;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public Exception b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.b.c
 * JD-Core Version:    0.7.0.1
 */
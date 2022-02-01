package com.tencent.rmonitor.heapdump;

public class HeapDumpConfig
{
  private final boolean a;
  private final int b;
  private final String c;
  private IHeapDumpExceptionListener d;
  
  public HeapDumpConfig(boolean paramBoolean)
  {
    this(paramBoolean, 0);
  }
  
  public HeapDumpConfig(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, "");
  }
  
  public HeapDumpConfig(boolean paramBoolean, int paramInt, String paramString)
  {
    this.a = paramBoolean;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public void a(IHeapDumpExceptionListener paramIHeapDumpExceptionListener)
  {
    this.d = paramIHeapDumpExceptionListener;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public IHeapDumpExceptionListener c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.heapdump.HeapDumpConfig
 * JD-Core Version:    0.7.0.1
 */
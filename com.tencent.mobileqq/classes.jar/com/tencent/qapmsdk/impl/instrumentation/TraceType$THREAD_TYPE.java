package com.tencent.qapmsdk.impl.instrumentation;

public enum TraceType$THREAD_TYPE
{
  MAIN(1),  OTHER(2);
  
  private final int value;
  
  private TraceType$THREAD_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.TraceType.THREAD_TYPE
 * JD-Core Version:    0.7.0.1
 */
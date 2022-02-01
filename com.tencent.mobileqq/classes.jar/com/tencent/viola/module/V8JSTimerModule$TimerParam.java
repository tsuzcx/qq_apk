package com.tencent.viola.module;

import com.eclipsesource.v8.V8Function;

class V8JSTimerModule$TimerParam
{
  public int delay;
  public int timerId;
  public V8Function v8Function;
  
  public V8JSTimerModule$TimerParam(V8Function paramV8Function, int paramInt1, int paramInt2)
  {
    this.v8Function = paramV8Function;
    this.delay = paramInt1;
    this.timerId = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.V8JSTimerModule.TimerParam
 * JD-Core Version:    0.7.0.1
 */
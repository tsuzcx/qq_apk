package com.tencent.qqmini.v8rt.engine;

public abstract class ValueCallback
  implements Callback
{
  public Object value;
  
  public ValueCallback(Object paramObject)
  {
    this.value = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.ValueCallback
 * JD-Core Version:    0.7.0.1
 */
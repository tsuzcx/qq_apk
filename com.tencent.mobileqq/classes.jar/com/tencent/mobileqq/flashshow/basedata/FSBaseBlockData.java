package com.tencent.mobileqq.flashshow.basedata;

import java.util.HashMap;

public class FSBaseBlockData<T>
{
  protected HashMap<String, Object> a;
  protected T b;
  
  public FSBaseBlockData(T paramT)
  {
    this.b = paramT;
    this.a = new HashMap();
  }
  
  public T a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.basedata.FSBaseBlockData
 * JD-Core Version:    0.7.0.1
 */
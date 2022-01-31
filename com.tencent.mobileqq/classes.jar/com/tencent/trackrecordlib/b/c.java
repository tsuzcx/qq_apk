package com.tencent.trackrecordlib.b;

import org.json.JSONObject;

public class c
  extends a
{
  private int b = -1;
  
  public c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public JSONObject a()
  {
    try
    {
      this.a.put("duration", this.b);
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.trackrecordlib.b.c
 * JD-Core Version:    0.7.0.1
 */
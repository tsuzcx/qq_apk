package com.tencent.trackrecordlib.b;

import org.json.JSONObject;

public class e
  extends a
{
  private String b = "";
  private String c = "";
  private int d = -1;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  public JSONObject a()
  {
    try
    {
      this.a.put("p0", this.b);
      this.a.put("p1", this.c);
      this.a.put("duration", this.d);
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
 * Qualified Name:     com.tencent.trackrecordlib.b.e
 * JD-Core Version:    0.7.0.1
 */
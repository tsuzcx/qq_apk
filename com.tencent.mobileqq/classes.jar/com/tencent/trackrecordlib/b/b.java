package com.tencent.trackrecordlib.b;

import org.json.JSONObject;

public class b
  extends a
{
  private String b = "";
  private String c = "";
  
  public b(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public JSONObject a()
  {
    try
    {
      this.a.put("p0", this.b);
      this.a.put("p1", this.c);
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.trackrecordlib.b.b
 * JD-Core Version:    0.7.0.1
 */
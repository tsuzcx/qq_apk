package com.tencent.trackrecordlib.b;

import org.json.JSONObject;

public class i
  extends a
{
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
  }
  
  public JSONObject a()
  {
    try
    {
      this.a.put("p0", this.b);
      this.a.put("p1", this.c);
      this.a.put("p2", this.d);
      this.a.put("p3", this.e);
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
 * Qualified Name:     com.tencent.trackrecordlib.b.i
 * JD-Core Version:    0.7.0.1
 */
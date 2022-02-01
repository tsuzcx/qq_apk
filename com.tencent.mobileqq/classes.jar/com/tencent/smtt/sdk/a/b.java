package com.tencent.smtt.sdk.a;

import org.json.JSONObject;

public class b
{
  private int a;
  private int b;
  private String c;
  private long d;
  
  public static b a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      b localb = new b();
      localb.a = paramJSONObject.optInt("id", -1);
      localb.b = paramJSONObject.optInt("cmd_id", -1);
      localb.c = paramJSONObject.optString("ext_params", "");
      localb.d = (paramJSONObject.optLong("expiration", 0L) * 1000L);
      return localb;
    }
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return System.currentTimeMillis() > this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cmd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", extra='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", expiration=");
    localStringBuilder.append(a.a(this.d));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */
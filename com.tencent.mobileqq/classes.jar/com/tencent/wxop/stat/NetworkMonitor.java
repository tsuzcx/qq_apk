package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public class NetworkMonitor
{
  private long a = 0L;
  private int b = 0;
  private String c = "";
  private int d = 0;
  private String e = "";
  
  public String getDomain()
  {
    return this.c;
  }
  
  public long getMillisecondsConsume()
  {
    return this.a;
  }
  
  public int getPort()
  {
    return this.d;
  }
  
  public String getRemoteIp()
  {
    return this.e;
  }
  
  public int getStatusCode()
  {
    return this.b;
  }
  
  public void setDomain(String paramString)
  {
    this.c = paramString;
  }
  
  public void setMillisecondsConsume(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setPort(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setRemoteIp(String paramString)
  {
    this.e = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    this.b = paramInt;
  }
  
  public JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tm", this.a);
      localJSONObject.put("st", this.b);
      if (this.c != null) {
        localJSONObject.put("dm", this.c);
      }
      localJSONObject.put("pt", this.d);
      if (this.e != null) {
        localJSONObject.put("rip", this.e);
      }
      localJSONObject.put("ts", System.currentTimeMillis() / 1000L);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.NetworkMonitor
 * JD-Core Version:    0.7.0.1
 */
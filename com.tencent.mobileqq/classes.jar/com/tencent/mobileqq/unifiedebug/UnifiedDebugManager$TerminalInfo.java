package com.tencent.mobileqq.unifiedebug;

import org.json.JSONObject;

public class UnifiedDebugManager$TerminalInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public long g;
  public long h;
  public String i;
  public boolean j;
  public boolean k;
  public int l;
  
  public UnifiedDebugManager$TerminalInfo(UnifiedDebugManager paramUnifiedDebugManager) {}
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("mobile_mode", this.a);
    localJSONObject.put("os_version", this.b);
    localJSONObject.put("app_version", this.c);
    localJSONObject.put("net_type", this.d);
    localJSONObject.put("carrier_type", this.e);
    localJSONObject.put("cpu_num", this.f);
    localJSONObject.put("cpu_freq", this.g);
    localJSONObject.put("total_ram", this.h);
    localJSONObject.put("cpu_type", this.i);
    localJSONObject.put("is_proxy", this.j);
    localJSONObject.put("is_X5_support", this.k);
    localJSONObject.put("X5_version", this.l);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.TerminalInfo
 * JD-Core Version:    0.7.0.1
 */
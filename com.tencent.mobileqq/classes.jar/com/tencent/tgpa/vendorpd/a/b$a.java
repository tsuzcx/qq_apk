package com.tencent.tgpa.vendorpd.a;

import org.json.JSONObject;

public class b$a
{
  public int a;
  public String b;
  public long c;
  public int d;
  public String e;
  
  public b$a(b paramb) {}
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("index")) {}
    while ((!paramJSONObject.has("action")) || (!paramJSONObject.has("offset")) || (!paramJSONObject.has("size")) || (!paramJSONObject.has("content"))) {
      return false;
    }
    try
    {
      this.a = paramJSONObject.getInt("index");
      this.b = paramJSONObject.getString("action");
      this.c = paramJSONObject.getLong("offset");
      this.d = paramJSONObject.getInt("size");
      this.e = paramJSONObject.getString("content");
      return true;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b.a
 * JD-Core Version:    0.7.0.1
 */
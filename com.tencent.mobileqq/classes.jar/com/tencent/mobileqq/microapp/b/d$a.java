package com.tencent.mobileqq.microapp.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class d$a
{
  public static AtomicInteger a = new AtomicInteger();
  public String b;
  public String c;
  public Map d;
  public String e = "GET";
  public String f;
  public String g = "text";
  public b h;
  public int i;
  public int j = a.getAndIncrement();
  
  public d$a(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.b = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("data")) {
        this.c = paramJSONObject.optString("data");
      }
      if (paramJSONObject.has("method")) {
        this.e = paramJSONObject.optString("method");
      }
      if (paramJSONObject.has("dataType")) {
        this.f = paramJSONObject.optString("dataType");
      }
      if (paramJSONObject.has("responseType")) {
        this.g = paramJSONObject.optString("responseType");
      }
      if (paramJSONObject.has("header"))
      {
        paramJSONObject = paramJSONObject.optJSONObject("header");
        Iterator localIterator = paramJSONObject.keys();
        if (this.d == null) {
          this.d = new HashMap();
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.d.put(str, paramJSONObject.optString(str));
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((this.d != null) && (this.d.containsKey("content-type")))
    {
      String str = (String)this.d.get("content-type");
      if ((!TextUtils.isEmpty(str)) && ("application/json".equals(str))) {
        this.f = "json";
      }
    }
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.d.a
 * JD-Core Version:    0.7.0.1
 */
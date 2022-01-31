package com.tencent.mobileqq.microapp.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class a$a
{
  public String a;
  public Map b;
  
  public a$a(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("url")) {
        this.a = paramJSONObject.optString("url");
      }
      if (paramJSONObject.has("method")) {
        paramJSONObject.optString("method");
      }
      if (paramJSONObject.has("header"))
      {
        paramJSONObject = paramJSONObject.optJSONObject("header");
        Iterator localIterator = paramJSONObject.keys();
        if (this.b == null) {
          this.b = new HashMap();
        }
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.b.put(str, paramJSONObject.optString(str));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.d.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.trackrecordlib.c;

import com.tencent.trackrecordlib.enums.EventTopic;
import com.tencent.trackrecordlib.g.h;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public abstract class b
{
  protected JSONObject a;
  private String b = UUID.randomUUID().toString();
  private String c = h.a();
  private EventTopic d;
  private String e;
  private Map<String, Integer> f;
  private Map<String, String> g;
  
  public b(EventTopic paramEventTopic)
  {
    this.d = paramEventTopic;
    a();
  }
  
  private JSONObject c(Map paramMap)
  {
    if (paramMap == null) {
      return new JSONObject();
    }
    paramMap.remove(null);
    return new JSONObject(paramMap);
  }
  
  protected void a()
  {
    try
    {
      this.a = new JSONObject();
      this.a.put("id", this.b);
      this.a.put("time", this.c);
      this.a.put("topic", this.d.getSeq());
      this.a.put("extra", this.e);
      this.a.put("values", c(this.f));
      this.a.put("tags", c(this.g));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    this.c = h.a(new Date(paramLong));
    JSONObject localJSONObject = this.a;
    if (localJSONObject != null) {
      try
      {
        localJSONObject.put("time", this.c);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
    paramString = this.a;
    if (paramString != null) {
      try
      {
        paramString.put("extra", this.e);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    Map localMap = this.f;
    if (localMap != null) {
      localMap.putAll(paramMap);
    } else {
      this.f = paramMap;
    }
    paramMap = this.a;
    if (paramMap != null) {
      try
      {
        paramMap.put("values", c(this.f));
        return;
      }
      catch (Throwable paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  public Map<String, Integer> b()
  {
    return this.f;
  }
  
  public void b(Map<String, String> paramMap)
  {
    Map localMap = this.g;
    if (localMap != null) {
      localMap.putAll(paramMap);
    } else {
      this.g = paramMap;
    }
    paramMap = this.a;
    if (paramMap != null) {
      try
      {
        paramMap.put("tags", c(this.g));
        return;
      }
      catch (Throwable paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  public Map<String, String> c()
  {
    return this.g;
  }
  
  public EventTopic d()
  {
    return this.d;
  }
  
  public abstract JSONObject e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trackrecordlib.c.b
 * JD-Core Version:    0.7.0.1
 */
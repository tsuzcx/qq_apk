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
    if (this.a != null) {}
    try
    {
      this.a.put("time", this.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
    if (this.a != null) {}
    try
    {
      this.a.put("extra", this.e);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(Map<String, Integer> paramMap)
  {
    if (this.f != null) {
      this.f.putAll(paramMap);
    }
    for (;;)
    {
      if (this.a != null) {}
      try
      {
        this.a.put("values", c(this.f));
        return;
      }
      catch (Throwable paramMap)
      {
        paramMap.printStackTrace();
      }
      this.f = paramMap;
    }
  }
  
  public Map<String, Integer> b()
  {
    return this.f;
  }
  
  public void b(Map<String, String> paramMap)
  {
    if (this.g != null) {
      this.g.putAll(paramMap);
    }
    for (;;)
    {
      if (this.a != null) {}
      try
      {
        this.a.put("tags", c(this.g));
        return;
      }
      catch (Throwable paramMap)
      {
        paramMap.printStackTrace();
      }
      this.g = paramMap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.c.b
 * JD-Core Version:    0.7.0.1
 */
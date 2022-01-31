package com.tencent.trackrecordlib.c;

import com.tencent.trackrecordlib.enums.EventTopic;
import org.json.JSONObject;

public class c
  extends a
{
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  
  public c(c.a parama)
  {
    super(EventTopic.EVENT_PAGE_CHANGE);
    this.b = c.a.a(parama);
    this.c = c.a.b(parama);
    this.d = c.a.c(parama);
    this.e = c.a.d(parama);
    this.f = c.a.e(parama);
    this.g = c.a.f(parama);
    this.h = c.a.g(parama);
    a(c.a.h(parama));
  }
  
  public JSONObject e()
  {
    try
    {
      this.a.put("pre_page_id", this.b);
      this.a.put("pre_page", this.c);
      this.a.put("page_id", this.d);
      this.a.put("page", this.e);
      this.a.put("pre_page_start", this.f);
      this.a.put("pre_page_end", this.g);
      this.a.put("page_start", this.h);
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
 * Qualified Name:     com.tencent.trackrecordlib.c.c
 * JD-Core Version:    0.7.0.1
 */
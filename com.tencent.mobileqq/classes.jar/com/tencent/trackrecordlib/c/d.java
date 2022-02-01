package com.tencent.trackrecordlib.c;

import com.tencent.trackrecordlib.enums.EventTopic;
import com.tencent.trackrecordlib.enums.UiAction;
import org.json.JSONObject;

public class d
  extends a
{
  private final UiAction b;
  private final com.tencent.trackrecordlib.b.a c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  
  public d(d.a parama)
  {
    super(EventTopic.EVENT_UI_ACTION);
    this.b = d.a.a(parama);
    this.c = d.a.b(parama);
    this.d = d.a.c(parama);
    this.e = d.a.d(parama);
    this.f = d.a.e(parama);
    this.g = d.a.f(parama);
    this.h = d.a.g(parama);
    this.i = d.a.h(parama);
    this.j = d.a.i(parama);
    this.k = d.a.j(parama);
    a(d.a.k(parama));
  }
  
  public JSONObject e()
  {
    try
    {
      if (this.b != null) {
        this.a.put("op", this.b.getSeq());
      }
      if (this.c != null) {
        this.a.put("data", this.c.a());
      }
      this.a.put("view_type", this.d);
      this.a.put("view_tag", this.e);
      this.a.put("view_text", this.f);
      this.a.put("view_desc", this.g);
      this.a.put("view_pos", this.h);
      this.a.put("view_super", this.i);
      this.a.put("page", this.j);
      this.a.put("page_id", this.k);
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public UiAction f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.c.d
 * JD-Core Version:    0.7.0.1
 */
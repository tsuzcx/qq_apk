package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.sdk.a.e.a;
import com.tencent.smtt.sdk.a.g;
import java.util.ArrayList;

class c$1
  implements e.a
{
  c$1(c paramc, Context paramContext) {}
  
  public void a(String paramString)
  {
    paramString = d.a(paramString);
    if ((paramString != null) && (paramString.a() == 0))
    {
      g.a().a(this.a, "emergence_req_interval", paramString.b());
      paramString = paramString.c();
      if (paramString != null)
      {
        c.a(this.b, this.a, c.b(), paramString);
        return;
      }
      c.a(this.b, this.a, c.c(), new ArrayList());
      return;
    }
    c.a(this.b, this.a, c.d(), new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.1
 * JD-Core Version:    0.7.0.1
 */
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
    c localc;
    int i;
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.a() == 0))
    {
      g.a().a(this.a, "emergence_req_interval", paramString.b());
      paramString = paramString.c();
      if (paramString != null)
      {
        c.a(this.b, this.a, c.b(), paramString);
        return;
      }
      localc = this.b;
      paramString = this.a;
      i = c.c();
      localArrayList = new ArrayList();
    }
    else
    {
      localc = this.b;
      paramString = this.a;
      i = c.d();
      localArrayList = new ArrayList();
    }
    c.a(localc, paramString, i, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.1
 * JD-Core Version:    0.7.0.1
 */
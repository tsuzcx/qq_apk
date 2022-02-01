package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.a.e.a;
import com.tencent.smtt.sdk.a.g;
import java.util.ArrayList;

class d$1
  implements e.a
{
  d$1(d paramd, Context paramContext) {}
  
  public void a(String paramString)
  {
    paramString = com.tencent.smtt.sdk.a.d.a(paramString);
    d locald;
    int i;
    ArrayList localArrayList;
    if ((paramString != null) && (paramString.a() == 0))
    {
      g.a().a(this.a, "emergence_req_interval", paramString.b());
      paramString = paramString.c();
      if (paramString != null)
      {
        d.a(this.b, this.a, d.b(), paramString);
        return;
      }
      locald = this.b;
      paramString = this.a;
      i = d.c();
      localArrayList = new ArrayList();
    }
    else
    {
      locald = this.b;
      paramString = this.a;
      i = d.d();
      localArrayList = new ArrayList();
    }
    d.a(locald, paramString, i, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.d.1
 * JD-Core Version:    0.7.0.1
 */
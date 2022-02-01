package com.vivo.push.util;

import android.content.Context;
import java.util.HashMap;

public final class y
  implements d
{
  private static final HashMap<String, Integer> a = new HashMap();
  private static final HashMap<String, Long> b = new HashMap();
  private static final HashMap<String, String> c = new HashMap();
  private static y d;
  private Context e;
  private d f;
  private boolean g = false;
  
  private y(Context paramContext)
  {
    this.e = paramContext;
    this.g = a(paramContext);
    paramContext = new StringBuilder("init status is ");
    paramContext.append(this.g);
    paramContext.append(";  curCache is ");
    paramContext.append(this.f);
    o.d("SystemCache", paramContext.toString());
  }
  
  public static y b(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new y(paramContext.getApplicationContext());
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  public final String a(String paramString1, String paramString2)
  {
    String str = (String)c.get(paramString1);
    if (str == null)
    {
      d locald = this.f;
      if (locald == null) {
        return str;
      }
      return locald.a(paramString1, paramString2);
    }
    return str;
  }
  
  public final void a()
  {
    x localx = new x();
    if (!localx.a(this.e)) {
      return;
    }
    localx.a();
    o.d("SystemCache", "sp cache is cleared");
  }
  
  public final boolean a(Context paramContext)
  {
    this.f = new v();
    boolean bool2 = this.f.a(paramContext);
    boolean bool1 = bool2;
    if (!bool2)
    {
      this.f = new u();
      bool1 = this.f.a(paramContext);
    }
    bool2 = bool1;
    if (!bool1)
    {
      this.f = new x();
      bool2 = this.f.a(paramContext);
    }
    if (!bool2) {
      this.f = null;
    }
    return bool2;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    c.put(paramString1, paramString2);
    if (this.g)
    {
      d locald = this.f;
      if (locald == null) {
        return;
      }
      locald.b(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.y
 * JD-Core Version:    0.7.0.1
 */
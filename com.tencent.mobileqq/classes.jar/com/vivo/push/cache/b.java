package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.o;
import com.vivo.push.util.z;
import java.lang.reflect.Method;

public final class b
{
  private static volatile b a;
  private d b;
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public final d a(Context paramContext)
  {
    Object localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    for (;;)
    {
      try
      {
        if (z.a(paramContext))
        {
          localObject = "com.vivo.push.cache.ServerConfigManagerImpl";
          Method localMethod = Class.forName((String)localObject).getMethod("getInstance", new Class[] { Context.class });
          o.d("ConfigManagerFactory", "createConfig success is ".concat((String)localObject));
          this.b = ((d)localMethod.invoke(null, new Object[] { paramContext }));
          paramContext = this.b;
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        o.b("ConfigManagerFactory", "createConfig error", paramContext);
        return null;
      }
      localObject = "com.vivo.push.cache.ClientConfigManagerImpl";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.cache.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qmsp.sdk.g.e;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

public class d
{
  public static String a(Context paramContext)
  {
    c localc = c.a();
    return localc.a(paramContext.getApplicationContext(), localc.c);
  }
  
  public static final boolean a()
  {
    Context localContext;
    try
    {
      Object localObject = Class.forName("android.app.ActivityThread");
      localObject = ((Class)localObject).getMethod("currentApplication", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (Context)((Method)localObject).invoke(null, new Object[0]);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ActivityThread:currentApplication --> ");
      localStringBuilder.append(localException.toString());
      Log.e("OpenIdHelper", localStringBuilder.toString());
      localContext = null;
    }
    if (localContext == null) {
      return false;
    }
    return c.a().a(localContext, false);
  }
  
  public static String b(Context paramContext)
  {
    c localc = c.a();
    return localc.a(paramContext.getApplicationContext(), localc.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.e.d
 * JD-Core Version:    0.7.0.1
 */
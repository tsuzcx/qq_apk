package com.tencent.tmassistantbase.util.a;

import android.util.Log;
import com.tencent.tmassistantbase.util.ac;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class b
  implements InvocationHandler
{
  public b(a parama) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    j = 1;
    long l = System.currentTimeMillis();
    paramObject = new StringBuilder().append(this.a.a()).append(" >> method:").append(paramMethod.getName()).append(". args.size=");
    c localc;
    Object localObject;
    if (paramArrayOfObject != null)
    {
      i = paramArrayOfObject.length;
      Log.i("HookManager_AbstractHook", i);
      if (paramMethod.getName().equals("getRecordForAppLocked")) {
        Log.i("HookManager_AbstractHook", "getRecordForAppLocked()..");
      }
      localc = this.a.a(paramMethod.getName());
      localObject = null;
    }
    label243:
    do
    {
      try
      {
        paramMethod.setAccessible(true);
        if ((localc != null) && (localc.b()))
        {
          boolean bool = localc.a(this.a.a, paramMethod, paramArrayOfObject);
          if (bool) {
            break label243;
          }
        }
      }
      catch (Throwable paramObject)
      {
        i = 0;
      }
      try
      {
        paramObject = localc.b(this.a.a, paramMethod, paramArrayOfObject);
        localc.a(this.a.a, paramMethod, paramArrayOfObject, paramObject);
        ac.c("miles", "hook end, invoke time cost:" + (System.currentTimeMillis() - l));
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          i = j;
        }
      }
      i = 0;
      break;
      if (localc != null) {
        ac.c("miles", "hook method disabled, invoke time cost:" + (System.currentTimeMillis() - l));
      }
      paramObject = paramMethod.invoke(this.a.a, paramArrayOfObject);
      return paramObject;
      Log.e("HookManager_AbstractHook", this.a.a() + " invoke exception!" + paramObject.getMessage());
      ac.c("miles", "hook exception, invoke time cost:" + (System.currentTimeMillis() - l));
      paramObject = localObject;
    } while (i == 0);
    return paramMethod.invoke(this.a.a, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tmassistantbase.util.a;

import android.util.Log;
import com.tencent.tmassistantbase.util.r;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class b
  implements InvocationHandler
{
  public b(a parama) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    paramObject = new StringBuilder().append(this.a.a()).append(" >> method:").append(paramMethod.getName()).append(". args.size=");
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length;; i = 0)
    {
      Log.i("HookManager_AbstractHook", i);
      if (paramMethod.getName().equals("getRecordForAppLocked")) {
        Log.i("HookManager_AbstractHook", "getRecordForAppLocked()..");
      }
      paramObject = this.a.a(paramMethod.getName());
      try
      {
        paramMethod.setAccessible(true);
        if ((paramObject != null) && (paramObject.b()))
        {
          if (!paramObject.a(this.a.a, paramMethod, paramArrayOfObject))
          {
            Object localObject = paramObject.b(this.a.a, paramMethod, paramArrayOfObject);
            paramObject.a(this.a.a, paramMethod, paramArrayOfObject, localObject);
            r.c("miles", "hook end, invoke time cost:" + (System.currentTimeMillis() - l));
            return localObject;
          }
        }
        else if (paramObject != null) {
          r.c("miles", "hook method disabled, invoke time cost:" + (System.currentTimeMillis() - l));
        }
        paramObject = paramMethod.invoke(this.a.a, paramArrayOfObject);
        return paramObject;
      }
      catch (Throwable paramObject)
      {
        Log.e("HookManager_AbstractHook", this.a.a() + " invoke exception!");
        paramObject.printStackTrace();
        r.c("miles", "hook exception, invoke time cost:" + (System.currentTimeMillis() - l));
        return paramMethod.invoke(this.a.a, paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.b
 * JD-Core Version:    0.7.0.1
 */
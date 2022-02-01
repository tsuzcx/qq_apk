package com.tencent.tmassistantbase.util.a;

import android.util.Log;
import com.tencent.tmassistantbase.util.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class b
  implements InvocationHandler
{
  public b(a parama) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    long l = System.currentTimeMillis();
    paramObject = new StringBuilder();
    paramObject.append(this.a.a());
    paramObject.append(" >> method:");
    paramObject.append(paramMethod.getName());
    paramObject.append(". args.size=");
    int j = 0;
    int i;
    if (paramArrayOfObject != null) {
      i = paramArrayOfObject.length;
    } else {
      i = 0;
    }
    paramObject.append(i);
    Log.i("HookManager_AbstractHook", paramObject.toString());
    if (paramMethod.getName().equals("getRecordForAppLocked")) {
      Log.i("HookManager_AbstractHook", "getRecordForAppLocked()..");
    }
    Object localObject2 = this.a.a(paramMethod.getName());
    Object localObject1 = null;
    try
    {
      paramMethod.setAccessible(true);
      if ((localObject2 != null) && (((c)localObject2).b()))
      {
        boolean bool = ((c)localObject2).a(this.a.a, paramMethod, paramArrayOfObject);
        if (!bool) {
          try
          {
            paramObject = ((c)localObject2).b(this.a.a, paramMethod, paramArrayOfObject);
            ((c)localObject2).a(this.a.a, paramMethod, paramArrayOfObject, paramObject);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("hook end, invoke time cost:");
            ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
            ab.c("miles", ((StringBuilder)localObject2).toString());
            return paramObject;
          }
          catch (Throwable paramObject)
          {
            i = 1;
          }
        }
      }
      else if (localObject2 != null)
      {
        paramObject = new StringBuilder();
        paramObject.append("hook method disabled, invoke time cost:");
        paramObject.append(System.currentTimeMillis() - l);
        ab.c("miles", paramObject.toString());
      }
      paramObject = paramMethod.invoke(this.a.a, paramArrayOfObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      i = j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.a());
      ((StringBuilder)localObject2).append(" invoke exception!");
      ((StringBuilder)localObject2).append(paramObject.getMessage());
      Log.e("HookManager_AbstractHook", ((StringBuilder)localObject2).toString());
      paramObject = new StringBuilder();
      paramObject.append("hook exception, invoke time cost:");
      paramObject.append(System.currentTimeMillis() - l);
      ab.c("miles", paramObject.toString());
      paramObject = localObject1;
      if (i != 0) {
        paramObject = paramMethod.invoke(this.a.a, paramArrayOfObject);
      }
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.b
 * JD-Core Version:    0.7.0.1
 */
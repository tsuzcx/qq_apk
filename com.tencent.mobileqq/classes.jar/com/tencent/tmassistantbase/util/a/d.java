package com.tencent.tmassistantbase.util.a;

import android.content.Context;
import android.util.Log;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class d
  extends a
{
  private e d;
  private Context e;
  
  public d(Context paramContext)
  {
    this.e = paramContext;
    this.d = new e(this.e);
    a(this.d);
  }
  
  public static String d()
  {
    if (GlobalUtil.isVivo()) {
      return "com.bbk.appstore";
    }
    if (GlobalUtil.isOppo()) {
      return "com.oppo.market";
    }
    return "com.google.launcher";
  }
  
  public String a()
  {
    return "ActivityManagerHook";
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.a(paramBoolean);
    }
  }
  
  public void b()
  {
    try
    {
      Field localField1 = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
      localField1.setAccessible(true);
      Object localObject = localField1.get(null);
      Class localClass = Class.forName("android.util.Singleton");
      Method localMethod = localClass.getDeclaredMethod("get", new Class[0]);
      localMethod.setAccessible(true);
      Field localField2 = localClass.getDeclaredField("mInstance");
      localField2.setAccessible(true);
      if (localClass.isInstance(localObject)) {}
      for (this.a = localMethod.invoke(localObject, new Object[0]);; this.a = localObject)
      {
        this.b = a(this.a);
        if (!localClass.isInstance(localObject)) {
          break;
        }
        localField2.set(localObject, this.b);
        return;
      }
      localThrowable.set(localObject, this.b);
    }
    catch (Throwable localThrowable)
    {
      Log.e("HookManager_AMHook", "inject MActivityManagerService exception!");
      localThrowable.printStackTrace();
      return;
    }
  }
  
  public boolean c()
  {
    if (this.d != null) {
      return this.d.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.d
 * JD-Core Version:    0.7.0.1
 */
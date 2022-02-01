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
    e locale = this.d;
    if (locale != null) {
      locale.a(paramBoolean);
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
      if (localClass.isInstance(localObject)) {
        this.a = localMethod.invoke(localObject, new Object[0]);
      } else {
        this.a = localObject;
      }
      this.b = a(this.a);
      if (localClass.isInstance(localObject))
      {
        localField2.set(localObject, this.b);
        return;
      }
      localField1.set(localObject, this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("HookManager_AMHook", "inject MActivityManagerService exception!");
      localThrowable.printStackTrace();
    }
  }
  
  public boolean c()
  {
    e locale = this.d;
    if (locale != null) {
      return locale.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.d
 * JD-Core Version:    0.7.0.1
 */
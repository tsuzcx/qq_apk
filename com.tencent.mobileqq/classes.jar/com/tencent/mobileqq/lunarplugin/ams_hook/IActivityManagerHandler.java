package com.tencent.mobileqq.lunarplugin.ams_hook;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class IActivityManagerHandler
  implements InvocationHandler
{
  private Object a;
  
  private int a(Object[] paramArrayOfObject)
  {
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      if ((paramArrayOfObject[i] instanceof Intent)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Log.d("IActivityManagerHandler", "bizai  you are hooked!!");
    Log.d("IActivityManagerHandler", "method:" + paramMethod.getName() + " called with args:" + Arrays.toString(paramArrayOfObject));
    if ("startActivity".equals(paramMethod.getName()))
    {
      int i = a(paramArrayOfObject);
      paramObject = (Intent)paramArrayOfObject[i];
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName("com.tencent.mobileqq", QQStoryMainActivity.class.getName()));
      localIntent.putExtra("extra_target_intent", paramObject);
      paramArrayOfObject[i] = localIntent;
      Log.d("IActivityManagerHandler", "bizai hook success");
      return paramMethod.invoke(this.a, paramArrayOfObject);
    }
    return paramMethod.invoke(this.a, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lunarplugin.ams_hook.IActivityManagerHandler
 * JD-Core Version:    0.7.0.1
 */
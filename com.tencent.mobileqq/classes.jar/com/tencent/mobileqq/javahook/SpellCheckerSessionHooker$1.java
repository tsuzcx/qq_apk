package com.tencent.mobileqq.javahook;

import android.view.textservice.SpellCheckerSession;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

final class SpellCheckerSessionHooker$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (SpellCheckerSession)paramMethodHookParam.thisObject;
    try
    {
      if (SpellCheckerSessionHooker.a == null)
      {
        SpellCheckerSessionHooker.a = SpellCheckerSession.class.getDeclaredField("mSpellCheckerSessionListener");
        SpellCheckerSessionHooker.a.setAccessible(true);
      }
      SpellCheckerSessionHooker.a.set(paramMethodHookParam, null);
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      QLog.e("SpellCheckerSessionHooker", 2, "close error", paramMethodHookParam);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.SpellCheckerSessionHooker.1
 * JD-Core Version:    0.7.0.1
 */
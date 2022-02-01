package com.tencent.mobileqq.javahook;

import android.view.textservice.SpellCheckerSession;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

final class SpellCheckerSessionHooker$2
  implements ReplaceMethodCallback
{
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    SpellCheckerSession localSpellCheckerSession = (SpellCheckerSession)paramMethodHookParam.thisObject;
    try
    {
      if (SpellCheckerSessionHooker.a == null)
      {
        SpellCheckerSessionHooker.a = SpellCheckerSession.class.getDeclaredField("mSpellCheckerSessionListener");
        SpellCheckerSessionHooker.a.setAccessible(true);
      }
      if (SpellCheckerSessionHooker.a.get(localSpellCheckerSession) != null) {
        JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
      }
      return;
    }
    catch (Throwable paramMethodHookParam)
    {
      QLog.e("SpellCheckerSessionHooker", 2, "handleOnGetSuggestionsMultiple error", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.SpellCheckerSessionHooker.2
 * JD-Core Version:    0.7.0.1
 */
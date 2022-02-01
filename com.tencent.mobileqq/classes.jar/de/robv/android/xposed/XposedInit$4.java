package de.robv.android.xposed;

import java.util.HashSet;

final class XposedInit$4
  extends XC_MethodHook
{
  XposedInit$4(HashSet paramHashSet) {}
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = Thread.currentThread().getContextClassLoader();
    XposedHelpers.findAndHookMethod("com.android.server.SystemServer", paramMethodHookParam, "startBootstrapServices", new Object[] { new XposedInit.4.1(this, paramMethodHookParam) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.4
 * JD-Core Version:    0.7.0.1
 */
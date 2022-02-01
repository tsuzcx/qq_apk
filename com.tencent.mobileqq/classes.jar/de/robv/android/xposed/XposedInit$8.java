package de.robv.android.xposed;

final class XposedInit$8
  extends XC_MethodHook
{
  XposedInit$8(ThreadLocal paramThreadLocal) {}
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    this.val$latestResKey.set(paramMethodHookParam.thisObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.8
 * JD-Core Version:    0.7.0.1
 */
package de.robv.android.xposed;

import android.content.res.TypedArray;
import android.content.res.XResources;
import android.content.res.XResources.XTypedArray;

final class XposedInit$11
  extends XC_MethodHook
{
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (TypedArray)paramMethodHookParam.thisObject;
    if ((paramMethodHookParam.getResources() instanceof XResources)) {
      XposedBridge.setObjectClass(paramMethodHookParam, XResources.XTypedArray.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.11
 * JD-Core Version:    0.7.0.1
 */
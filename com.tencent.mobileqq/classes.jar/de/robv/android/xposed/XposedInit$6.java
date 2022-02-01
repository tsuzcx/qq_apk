package de.robv.android.xposed;

import android.content.pm.ApplicationInfo;
import android.content.res.XResources;
import android.os.Process;

final class XposedInit$6
  extends XC_MethodHook
{
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (ApplicationInfo)paramMethodHookParam.args[0];
    String str = paramMethodHookParam.packageName;
    if (paramMethodHookParam.uid == Process.myUid()) {}
    for (paramMethodHookParam = paramMethodHookParam.sourceDir;; paramMethodHookParam = paramMethodHookParam.publicSourceDir)
    {
      XResources.setPackageNameForResDir(str, paramMethodHookParam);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.6
 * JD-Core Version:    0.7.0.1
 */
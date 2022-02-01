package de.robv.android.xposed;

import android.app.AndroidAppHelper;
import android.app.LoadedApk;
import android.content.res.XResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import java.util.HashSet;

final class XposedInit$5
  extends XC_MethodHook
{
  XposedInit$5(HashSet paramHashSet) {}
  
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (LoadedApk)paramMethodHookParam.thisObject;
    String str = paramMethodHookParam.getPackageName();
    XResources.setPackageNameForResDir(str, paramMethodHookParam.getResDir());
    if ((str.equals("android")) || (!this.val$loadedPackagesInProcess.add(str))) {}
    while (!XposedHelpers.getBooleanField(paramMethodHookParam, "mIncludeCode")) {
      return;
    }
    XC_LoadPackage.LoadPackageParam localLoadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
    localLoadPackageParam.packageName = str;
    localLoadPackageParam.processName = AndroidAppHelper.currentProcessName();
    localLoadPackageParam.classLoader = paramMethodHookParam.getClassLoader();
    localLoadPackageParam.appInfo = paramMethodHookParam.getApplicationInfo();
    localLoadPackageParam.isFirstApplication = false;
    XC_LoadPackage.callAll(localLoadPackageParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.5
 * JD-Core Version:    0.7.0.1
 */
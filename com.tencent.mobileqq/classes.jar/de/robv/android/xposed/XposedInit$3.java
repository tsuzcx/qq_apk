package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import java.util.HashSet;

final class XposedInit$3
  extends XC_MethodHook
{
  XposedInit$3(HashSet paramHashSet) {}
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    SELinuxHelper.initForProcess("android");
    this.val$loadedPackagesInProcess.add("android");
    paramMethodHookParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
    paramMethodHookParam.packageName = "android";
    paramMethodHookParam.processName = "android";
    paramMethodHookParam.classLoader = XposedBridge.BOOTCLASSLOADER;
    paramMethodHookParam.appInfo = null;
    paramMethodHookParam.isFirstApplication = true;
    XC_LoadPackage.callAll(paramMethodHookParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.3
 * JD-Core Version:    0.7.0.1
 */
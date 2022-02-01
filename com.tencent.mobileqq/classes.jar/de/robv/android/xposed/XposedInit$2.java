package de.robv.android.xposed;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.XResources;
import android.util.Log;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.callbacks.XCallback.Param;
import java.util.HashSet;

final class XposedInit$2
  extends XC_MethodHook
{
  XposedInit$2(HashSet paramHashSet) {}
  
  protected void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    Object localObject1 = (ActivityThread)paramMethodHookParam.thisObject;
    ApplicationInfo localApplicationInfo = (ApplicationInfo)XposedHelpers.getObjectField(paramMethodHookParam.args[0], "appInfo");
    String str;
    if (localApplicationInfo.packageName.equals("android"))
    {
      str = "system";
      SELinuxHelper.initForProcess(str);
      if ((ComponentName)XposedHelpers.getObjectField(paramMethodHookParam.args[0], "instrumentationName") == null) {
        break label98;
      }
      Log.w("Xposed", "Instrumentation detected, disabling framework for " + str);
      XposedBridge.disableHooks = true;
    }
    label98:
    Object localObject2;
    do
    {
      do
      {
        return;
        str = localApplicationInfo.packageName;
        break;
        localObject2 = (CompatibilityInfo)XposedHelpers.getObjectField(paramMethodHookParam.args[0], "compatInfo");
      } while (localApplicationInfo.sourceDir == null);
      XposedHelpers.setObjectField(localObject1, "mBoundApplication", paramMethodHookParam.args[0]);
      this.val$loadedPackagesInProcess.add(str);
      localObject1 = ((ActivityThread)localObject1).getPackageInfoNoCheck(localApplicationInfo, (CompatibilityInfo)localObject2);
      XResources.setPackageNameForResDir(localApplicationInfo.packageName, ((LoadedApk)localObject1).getResDir());
      localObject2 = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
      ((XC_LoadPackage.LoadPackageParam)localObject2).packageName = str;
      ((XC_LoadPackage.LoadPackageParam)localObject2).processName = ((String)XposedHelpers.getObjectField(paramMethodHookParam.args[0], "processName"));
      ((XC_LoadPackage.LoadPackageParam)localObject2).classLoader = ((LoadedApk)localObject1).getClassLoader();
      ((XC_LoadPackage.LoadPackageParam)localObject2).appInfo = localApplicationInfo;
      ((XC_LoadPackage.LoadPackageParam)localObject2).isFirstApplication = true;
      XC_LoadPackage.callAll((XCallback.Param)localObject2);
    } while (!str.equals("de.robv.android.xposed.installer"));
    XposedInit.access$000(((XC_LoadPackage.LoadPackageParam)localObject2).classLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.2
 * JD-Core Version:    0.7.0.1
 */
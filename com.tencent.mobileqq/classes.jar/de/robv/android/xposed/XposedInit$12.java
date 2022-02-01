package de.robv.android.xposed;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

final class XposedInit$12
  extends XC_MethodHook
{
  protected void afterHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = (Application)paramMethodHookParam.thisObject;
    if (paramMethodHookParam.getResources().getIdentifier("installer_needs_update", "string", "de.robv.android.xposed.installer") == 0)
    {
      Log.e("XposedInstaller", "Xposed Installer is outdated (resource string \"installer_needs_update\" is missing)");
      Toast.makeText(paramMethodHookParam, "Please update Xposed Installer!", 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedInit.12
 * JD-Core Version:    0.7.0.1
 */
package me.ele.uetool.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.List;

public class SettingsCompat
{
  private static final String HUAWEI_PACKAGE = "com.huawei.systemmanager";
  private static final String TAG = "settings-compat";
  
  public static void manageDrawOverlays(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        localIntent.addFlags(268435456);
        localIntent.setData(Uri.parse("package:" + paramContext.getPackageName()));
        paramContext.startActivity(localIntent);
      }
      return;
    }
    catch (Exception localException)
    {
      while ((Build.VERSION.SDK_INT < 18) || (!manageDrawOverlaysForRom(paramContext))) {}
    }
  }
  
  private static boolean manageDrawOverlaysForEmui(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
      if (!startSafely(paramContext, localIntent)) {}
    }
    do
    {
      do
      {
        return true;
        localIntent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        localIntent.putExtra("showTabsNumber", 1);
      } while (startSafely(paramContext, localIntent));
      localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
    } while (startSafely(paramContext, localIntent));
    return false;
  }
  
  private static boolean manageDrawOverlaysForFlyme(Context paramContext)
  {
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    return startSafely(paramContext, localIntent);
  }
  
  private static boolean manageDrawOverlaysForMiui(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    if (startSafely(paramContext, localIntent)) {}
    do
    {
      return true;
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
    } while (startSafely(paramContext, localIntent));
    if (Build.VERSION.SDK_INT < 21)
    {
      localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
      return startSafely(paramContext, localIntent);
    }
    return false;
  }
  
  private static boolean manageDrawOverlaysForOppo(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.setAction("com.oppo.safe");
    localIntent.setClassName("com.oppo.safe", "com.oppo.safe.permission.floatwindow.FloatWindowListActivity");
    if (startSafely(paramContext, localIntent)) {}
    do
    {
      return true;
      localIntent.setAction("com.color.safecenter");
      localIntent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
    } while (startSafely(paramContext, localIntent));
    localIntent.setAction("com.coloros.safecenter");
    localIntent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
    return startSafely(paramContext, localIntent);
  }
  
  private static boolean manageDrawOverlaysForQihu(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
    if (startSafely(paramContext, localIntent)) {
      return true;
    }
    localIntent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
    return startSafely(paramContext, localIntent);
  }
  
  private static boolean manageDrawOverlaysForRom(Context paramContext)
  {
    if (RomUtil.isMiui()) {
      return manageDrawOverlaysForMiui(paramContext);
    }
    if (RomUtil.isEmui()) {
      return manageDrawOverlaysForEmui(paramContext);
    }
    if (RomUtil.isFlyme()) {
      return manageDrawOverlaysForFlyme(paramContext);
    }
    if (RomUtil.isOppo()) {
      return manageDrawOverlaysForOppo(paramContext);
    }
    if (RomUtil.isVivo()) {
      return manageDrawOverlaysForVivo(paramContext);
    }
    if (RomUtil.isQiku()) {
      return manageDrawOverlaysForQihu(paramContext);
    }
    if (RomUtil.isSmartisan()) {
      return manageDrawOverlaysForSmartisan(paramContext);
    }
    return false;
  }
  
  private static boolean manageDrawOverlaysForSmartisan(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localIntent = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS_NEW");
      localIntent.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
      localIntent.putExtra("index", 17);
      return startSafely(paramContext, localIntent);
    }
    Intent localIntent = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS");
    localIntent.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
    localIntent.putExtra("permission", new String[] { "android.permission.SYSTEM_ALERT_WINDOW" });
    return startSafely(paramContext, localIntent);
  }
  
  private static boolean manageDrawOverlaysForVivo(Context paramContext)
  {
    Intent localIntent = new Intent("com.iqoo.secure");
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
    return startSafely(paramContext, localIntent);
  }
  
  private static boolean startSafely(Context paramContext, Intent paramIntent)
  {
    if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0)
    {
      paramIntent.setFlags(268435456);
      paramContext.startActivity(paramIntent);
      return true;
    }
    Log.e("settings-compat", "Intent is not available! " + paramIntent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.util.SettingsCompat
 * JD-Core Version:    0.7.0.1
 */
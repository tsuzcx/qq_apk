package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class ShortcutUtils
{
  public static int a()
  {
    ToastUtil.a().a("已添加桌面快捷方式，如未成功，请在设置中打开【桌面快捷方式】权限并重新添加");
    return 0;
  }
  
  public static int a(Context paramContext)
  {
    String str = Build.MANUFACTURER.toLowerCase();
    int i = 3;
    if (str.contains("huawei")) {
      i = b(paramContext);
    }
    do
    {
      return i;
      if (str.contains("xiaomi")) {
        return d(paramContext);
      }
      if (str.contains("oppo")) {
        return e(paramContext);
      }
      if (str.contains("vivo")) {
        return c(paramContext);
      }
    } while ((!str.contains("samsung")) && (!str.contains("meizu")));
    return 0;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    paramBitmap.recycle();
    return localObject;
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = localPackageManager.getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.applicationInfo.loadLabel(localPackageManager).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  public static void a(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        i = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException3);
        i = 1;
        bool1 = false;
        continue;
      }
      int j = i;
      boolean bool2 = bool1;
      if (!bool1)
      {
        j = i;
        bool2 = bool1;
        if (a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        j = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException4);
        j = 2;
        bool2 = false;
        continue;
      }
      int i = j;
      boolean bool1 = bool2;
      if (!bool2)
      {
        i = j;
        bool1 = bool2;
        if (a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        bool1 = true;
      }
      catch (Exception localException5)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException5);
        bool1 = false;
        continue;
        i = 3;
        continue;
      }
      if (!bool1)
      {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
        try
        {
          paramActivity.getBaseContext().startActivity(localIntent);
          i = 3;
          bool1 = true;
        }
        catch (Exception localException6)
        {
          QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException6);
          i = 3;
          bool1 = false;
          continue;
        }
        bool2 = bool1;
        if (!bool1) {
          localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        }
        try
        {
          localIntent.setData(Uri.fromParts("package", (String)localObject, null));
          paramActivity.getBaseContext().startActivity(localIntent);
          i = 4;
          bool2 = true;
        }
        catch (Exception localException1)
        {
          QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException1);
          i = 4;
          bool2 = false;
          continue;
          bool1 = bool2;
          continue;
        }
        if ((!bool2) && (a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
        {
          localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
          try
          {
            paramActivity.getBaseContext().startActivity((Intent)localObject);
            i = 5;
            bool1 = true;
          }
          catch (Exception localException2)
          {
            QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException2);
            i = 5;
            bool1 = false;
            continue;
          }
          if (!bool1)
          {
            localObject = new Intent(paramActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("hide_left_button", false);
            ((Intent)localObject).putExtra("show_right_close_button", false);
            ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15", 524288L, (Intent)localObject, false, -1);
            i = 6;
          }
          QLog.w("Shortcut", 1, "请求权限, which[" + i + "], openSuccess[" + bool1 + "]");
          return;
        }
      }
      i = 0;
      bool1 = false;
    }
  }
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    a(paramActivity, paramMiniAppInfo, null);
  }
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    if ((paramActivity == null) || (paramMiniAppInfo == null)) {
      QLog.e("Shortcut", 1, "addShortcut params invalid!");
    }
    do
    {
      return;
      if (a(paramActivity) != 1) {
        break;
      }
      paramActivity = ShortcutUtils.PermissionDialog.a(paramActivity, HardCodeUtil.a(2131713955), HardCodeUtil.a(2131713968), HardCodeUtil.a(2131713970), new ShortcutUtils.1(paramActivity), new ShortcutUtils.2());
      paramActivity.a(false);
      paramActivity.show();
    } while (paramAddShortcutCallback == null);
    paramAddShortcutCallback.a(2, HardCodeUtil.a(2131713949));
    return;
    b(paramActivity, paramMiniAppInfo, paramAddShortcutCallback);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  @RequiresApi(api=25)
  public static boolean a(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int b(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnEMUI");
    Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    try
    {
      Class localClass = Class.forName("com.huawei.hsm.permission.PermissionManager");
      boolean bool = ((Boolean)localClass.getDeclaredMethod("canSendBroadcast", new Class[] { Context.class, Intent.class }).invoke(localClass, new Object[] { paramContext, localIntent })).booleanValue();
      QLog.i("Shortcut", 1, "EMUI check permission canSendBroadcast invoke result = " + bool);
      if (bool) {
        return 0;
      }
      return 1;
    }
    catch (Throwable paramContext)
    {
      QLog.i("Shortcut", 1, paramContext.getMessage(), paramContext);
    }
    return 3;
  }
  
  private static Intent b(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setClassName(paramActivity, JumpActivity.class.getName());
    localIntent.putExtra("CONFIG_APPID", paramMiniAppInfo.appId);
    localIntent.putExtra("CONFIG_APPNAME", paramMiniAppInfo.name);
    localIntent.putExtra("CONFIG_APPICON", paramMiniAppInfo.iconUrl);
    localIntent.putExtra("CONFIG_REPORTTYPE", paramMiniAppInfo.getReportType());
    localIntent.putExtra("CONFIG_ENGINETYPE", paramMiniAppInfo.getEngineType());
    localIntent.putExtra("MINI_CONFIG_SCENE", 1023);
    localIntent.putExtra("MINI_CONFIG_DEV_DESC", paramMiniAppInfo.developerDesc);
    localIntent.putExtra("CONFIG_VER_TYPE", paramMiniAppInfo.verType);
    return localIntent;
  }
  
  private static Bitmap b(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = ImageUtil.b(URLDrawable.getDrawable(URLDecoder.decode(paramMiniAppInfo.iconUrl), null));
    int i = (int)paramActivity.getResources().getDimension(17104896);
    int j = ((ActivityManager)paramActivity.getSystemService("activity")).getLauncherLargeIconSize();
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      return ImageUtil.a(a(paramMiniAppInfo, i, i), (int)(i * 0.15D));
    }
  }
  
  public static void b(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    ThreadManagerV2.executeOnSubThread(new ShortcutUtils.3(paramActivity, paramMiniAppInfo, paramAddShortcutCallback));
  }
  
  public static int c(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnVIVO");
    Object localObject1 = paramContext.getContentResolver();
    if (localObject1 == null)
    {
      QLog.i("Shortcut", 1, "contentResolver is null");
      return 3;
    }
    Object localObject3 = Uri.parse("content://com.bbk.launcher2.settings/favorites");
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramContext.checkSelfPermission("com.bbk.launcher2.permission.READ_SETTINGS") == 0) {}
      for (i = 1; i == 0; i = 0)
      {
        QLog.i("Shortcut", 1, "cannot get com.bbk.launcher2.permission.READ_SETTINGS permission");
        return a();
      }
    }
    try
    {
      localObject1 = ((ContentResolver)localObject1).query((Uri)localObject3, null, null, null, null);
      if (localObject1 == null)
      {
        QLog.i("Shortcut", 1, "cursor is null (Uri : content://com.bbk.launcher2.settings/favorites)");
        return 3;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Shortcut", 1, "shortcutUtils query error", localException);
        localObject2 = null;
      }
      try
      {
        while (localObject2.moveToNext())
        {
          localObject3 = localObject2.getString(localObject2.getColumnIndexOrThrow("title"));
          QLog.i("Shortcut", 1, "title by query is " + (String)localObject3);
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(a(paramContext))))
          {
            i = localObject2.getInt(localObject2.getColumnIndexOrThrow("shortcutPermission"));
            QLog.i("Shortcut", 1, "permission value is " + i);
            if ((i == 1) || (i == 17)) {
              return 1;
            }
            if (i == 16) {
              return 0;
            }
            if (i == 18) {
              return 2;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          QLog.i("Shortcut", 1, paramContext.getMessage(), paramContext);
          localObject2.close();
        }
      }
      finally
      {
        localObject2.close();
      }
      return 3;
    }
  }
  
  private static void c(Activity paramActivity)
  {
    AppBrandTask.runTaskOnUiThread(new ShortcutUtils.4(paramActivity));
  }
  
  public static int d(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnMIUI");
    if (Build.VERSION.SDK_INT < 19) {
      return 3;
    }
    try
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      String str = paramContext.getApplicationContext().getPackageName();
      int i = paramContext.getApplicationInfo().uid;
      paramContext = Class.forName(AppOpsManager.class.getName()).getDeclaredMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(10017), Integer.valueOf(i), str });
      if (paramContext == null)
      {
        QLog.i("Shortcut", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result is null");
        return 3;
      }
      paramContext = paramContext.toString();
      i = Integer.valueOf(paramContext).intValue();
      QLog.i("Shortcut", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result = " + paramContext);
      switch (i)
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        return 3;
      case 0: 
        return 0;
      case 1: 
        return 1;
      }
      return 2;
    }
    catch (Throwable paramContext)
    {
      QLog.i("Shortcut", 1, paramContext.getMessage(), paramContext);
    }
    return 3;
  }
  
  public static int e(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnOPPO");
    Object localObject = paramContext.getContentResolver();
    if (localObject == null)
    {
      QLog.i("Shortcut", 1, "contentResolver is null");
      return 3;
    }
    localObject = ((ContentResolver)localObject).query(Uri.parse("content://settings/secure/launcher_shortcut_permission_settings"), null, null, null, null);
    if (localObject == null)
    {
      QLog.i("Shortcut", 1, "cursor is null (Uri : content://settings/secure/launcher_shortcut_permission_settings)");
      return 3;
    }
    try
    {
      paramContext = paramContext.getApplicationContext().getPackageName();
      while (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("value"));
        QLog.i("Shortcut", 1, "permission value is " + str);
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = str.contains(paramContext + ", 1");
          if (bool) {
            return 0;
          }
          bool = str.contains(paramContext + ", 0");
          if (bool) {
            return 1;
          }
        }
      }
      return 3;
    }
    catch (Exception paramContext)
    {
      QLog.i("Shortcut", 1, paramContext.getMessage(), paramContext);
      return 3;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */
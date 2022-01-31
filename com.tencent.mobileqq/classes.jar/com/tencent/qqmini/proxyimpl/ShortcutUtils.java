package com.tencent.qqmini.proxyimpl;

import ajyc;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import bbdr;
import beki;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class ShortcutUtils
{
  public static final String ACTION_ANDROID = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
  public static final String ACTION_HUAWEI = "huawei.intent.action.NOTIFICATIONMANAGER";
  public static final String ACTION_MEIZU = "com.meizu.safe.security.SHOW_APPSEC";
  public static final String ACTION_MIUI = "miui.intent.action.APP_PERM_EDITOR";
  public static final String ACTION_VIVO = "permission.intent.action.softPermissionDetail";
  public static final String CLASS_HUAWEI = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity";
  public static final String CLASS_MEIZU = "com.meizu.safe.security.AppSecActivity";
  public static final String CLASS_MIUI = "com.miui.permcenter.permissions.AppPermissionsEditorActivity";
  public static final String EXTRA_MEIZU = "packageName";
  public static final String EXTRA_MIUI = "extra_pkgname";
  public static final String INTENT_ACTION_CREATE_MINI_SHORTCUT = "com.tencent.mini.CreateShortcutSucceedReceiver";
  public static final String PACKAGE_HUAWEI = "com.huawei.systemmanager";
  public static final String PACKAGE_MEIZU = "com.meizu.safe";
  public static final String PACKAGE_MIUI = "com.miui.securitycenter";
  public static final int RESULT_ADD_FAIL = 1;
  public static final int RESULT_ADD_FAIL_NO_PERMISSION = 2;
  public static final int RESULT_ADD_SUCC = 0;
  private static final String TAG = "Shortcut";
  
  public static void addShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    addShortcut(paramActivity, paramMiniAppInfo, null);
  }
  
  public static void addShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    if ((paramActivity == null) || (paramMiniAppInfo == null)) {
      QLog.e("Shortcut", 1, "addShortcut params invalid!");
    }
    do
    {
      return;
      if (hasRightsToShortCutInVIVO(paramActivity)) {
        break;
      }
      paramActivity = ShortcutUtils.PermissionDialog.createPermissionDialog(paramActivity, ajyc.a(2131714006), ajyc.a(2131714019), ajyc.a(2131714021), new ShortcutUtils.1(paramActivity), new ShortcutUtils.2());
      paramActivity.showCheckbox(false);
      paramActivity.show();
    } while (paramAddShortcutCallback == null);
    paramAddShortcutCallback.onAddResult(2, ajyc.a(2131714000));
    return;
    doAddShortcut(paramActivity, paramMiniAppInfo, paramAddShortcutCallback);
  }
  
  public static void doAddShortcut(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    ThreadManagerV2.executeOnSubThread(new ShortcutUtils.3(paramActivity, paramMiniAppInfo, paramAddShortcutCallback));
  }
  
  private static Bitmap getLaunchBitmap(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo = bbdr.b(URLDrawable.getDrawable(URLDecoder.decode(paramMiniAppInfo.iconUrl), null));
    int i = (int)paramActivity.getResources().getDimension(17104896);
    int j = ((ActivityManager)paramActivity.getSystemService("activity")).getLauncherLargeIconSize();
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      return bbdr.a(getResizedBitmap(paramMiniAppInfo, i, i), (int)(i * 0.15D));
    }
  }
  
  public static Bitmap getResizedBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
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
  
  /* Error */
  public static boolean hasRightsToShortCutInVIVO(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 229	android/os/Build:MODEL	Ljava/lang/String;
    //   3: invokevirtual 235	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   6: ldc 237
    //   8: invokevirtual 241	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +197 -> 208
    //   14: getstatic 246	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 27
    //   19: if_icmplt +189 -> 208
    //   22: aload_0
    //   23: invokevirtual 252	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: ldc 254
    //   28: invokestatic 260	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 262
    //   35: iconst_1
    //   36: anewarray 231	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc_w 264
    //   44: aastore
    //   45: aconst_null
    //   46: invokevirtual 270	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +147 -> 198
    //   54: aload_2
    //   55: astore_0
    //   56: aload_2
    //   57: invokeinterface 275 1 0
    //   62: ifle +136 -> 198
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: invokeinterface 279 1 0
    //   73: pop
    //   74: aload_2
    //   75: astore_0
    //   76: aload_2
    //   77: aload_2
    //   78: ldc_w 281
    //   81: invokeinterface 285 2 0
    //   86: invokeinterface 288 2 0
    //   91: astore_3
    //   92: aload_2
    //   93: astore_0
    //   94: aload_2
    //   95: aload_2
    //   96: ldc_w 290
    //   99: invokeinterface 285 2 0
    //   104: invokeinterface 294 2 0
    //   109: istore_1
    //   110: aload_2
    //   111: astore_0
    //   112: ldc 57
    //   114: iconst_1
    //   115: iconst_3
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: ldc_w 296
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: aload_3
    //   128: aastore
    //   129: dup
    //   130: iconst_2
    //   131: new 298	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 299	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 301
    //   141: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload_1
    //   145: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: aastore
    //   152: invokestatic 317	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   155: aload_2
    //   156: astore_0
    //   157: aload_2
    //   158: invokeinterface 320 1 0
    //   163: iload_1
    //   164: iconst_1
    //   165: if_icmpeq +9 -> 174
    //   168: iload_1
    //   169: bipush 17
    //   171: if_icmpne +15 -> 186
    //   174: aload_2
    //   175: ifnull +9 -> 184
    //   178: aload_2
    //   179: invokeinterface 320 1 0
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_2
    //   187: ifnull +9 -> 196
    //   190: aload_2
    //   191: invokeinterface 320 1 0
    //   196: iconst_1
    //   197: ireturn
    //   198: aload_2
    //   199: ifnull +9 -> 208
    //   202: aload_2
    //   203: invokeinterface 320 1 0
    //   208: iconst_1
    //   209: ireturn
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_2
    //   213: aload_2
    //   214: astore_0
    //   215: ldc 57
    //   217: iconst_1
    //   218: ldc_w 322
    //   221: aload_3
    //   222: invokestatic 325	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: ifnull -18 -> 208
    //   229: aload_2
    //   230: invokeinterface 320 1 0
    //   235: goto -27 -> 208
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_0
    //   241: aload_0
    //   242: ifnull +9 -> 251
    //   245: aload_0
    //   246: invokeinterface 320 1 0
    //   251: aload_2
    //   252: athrow
    //   253: astore_2
    //   254: goto -13 -> 241
    //   257: astore_3
    //   258: goto -45 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramContext	Context
    //   109	63	1	i	int
    //   49	181	2	localCursor	android.database.Cursor
    //   238	14	2	localObject1	Object
    //   253	1	2	localObject2	Object
    //   91	37	3	str	String
    //   210	12	3	localThrowable1	java.lang.Throwable
    //   257	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   22	50	210	java/lang/Throwable
    //   22	50	238	finally
    //   56	65	253	finally
    //   67	74	253	finally
    //   76	92	253	finally
    //   94	110	253	finally
    //   112	155	253	finally
    //   157	163	253	finally
    //   215	225	253	finally
    //   56	65	257	java/lang/Throwable
    //   67	74	257	java/lang/Throwable
    //   76	92	257	java/lang/Throwable
    //   94	110	257	java/lang/Throwable
    //   112	155	257	java/lang/Throwable
    //   157	163	257	java/lang/Throwable
  }
  
  public static boolean isIntentAvailable(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
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
  
  private static void jumpToAppDetailSetting(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (Build.VERSION.SDK_INT >= 9)
    {
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramActivity.getPackageName(), null));
    }
    for (;;)
    {
      paramActivity.startActivity(localIntent);
      return;
      if (Build.VERSION.SDK_INT <= 8)
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
        localIntent.putExtra("com.android.settings.ApplicationPkgName", paramActivity.getPackageName());
      }
    }
  }
  
  private static Intent obtainShortcutIntent(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
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
  
  private static void onCreateShortcutFailed(Activity paramActivity)
  {
    beki.a(new ShortcutUtils.4(paramActivity));
  }
  
  public static void openPermissionActivity(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (isIntentAvailable(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
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
        if (isIntentAvailable(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
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
        if (isIntentAvailable(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
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
        if ((!bool2) && (isIntentAvailable(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */
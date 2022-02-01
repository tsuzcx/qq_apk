package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
    if (str.contains("huawei")) {
      return b(paramContext);
    }
    if (str.contains("xiaomi")) {
      return d(paramContext);
    }
    if (str.contains("oppo")) {
      return e(paramContext);
    }
    if (str.contains("vivo")) {
      return c(paramContext);
    }
    if ((!str.contains("samsung")) && (!str.contains("meizu"))) {
      return 3;
    }
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
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label40:
      break label40;
    }
    return "";
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity = ShortcutUtils.PermissionDialog.a(paramActivity, HardCodeUtil.a(2131713886), HardCodeUtil.a(2131713899), HardCodeUtil.a(2131713901), new ShortcutUtils.1(paramActivity), new ShortcutUtils.2());
    paramActivity.a(false);
    paramActivity.show();
  }
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    a(paramActivity, paramMiniAppInfo, null);
  }
  
  public static void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    if ((paramActivity != null) && (paramMiniAppInfo != null))
    {
      if (a(paramActivity) == 1)
      {
        a(paramActivity);
        if (paramAddShortcutCallback != null) {
          paramAddShortcutCallback.a(2, HardCodeUtil.a(2131713880));
        }
        return;
      }
      b(paramActivity, paramMiniAppInfo, paramAddShortcutCallback);
      return;
    }
    QLog.e("Shortcut", 1, "addShortcut params invalid!");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  @RequiresApi(api=25)
  public static boolean a(String paramString, ShortcutManager paramShortcutManager)
  {
    boolean bool2 = false;
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      bool1 = bool2;
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    boolean bool1 = true;
    return bool1;
  }
  
  public static int b(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnEMUI");
    Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    try
    {
      Class localClass = Class.forName("com.huawei.hsm.permission.PermissionManager");
      boolean bool = ((Boolean)localClass.getDeclaredMethod("canSendBroadcast", new Class[] { Context.class, Intent.class }).invoke(localClass, new Object[] { paramContext, localIntent })).booleanValue();
      paramContext = new StringBuilder();
      paramContext.append("EMUI check permission canSendBroadcast invoke result = ");
      paramContext.append(bool);
      QLog.i("Shortcut", 1, paramContext.toString());
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
    paramActivity = a(paramMiniAppInfo, i, i);
    double d = i;
    Double.isNaN(d);
    return ImageUtil.a(paramActivity, (int)(d * 0.15D));
  }
  
  public static void b(Activity paramActivity)
  {
    String str = paramActivity.getPackageName();
    StringBuilder localStringBuilder;
    if (a(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      Intent localIntent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent3.putExtra("extra_pkgname", str);
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent3);
        bool1 = true;
      }
      catch (Exception localException3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("openPermissionActivity e = ");
        localStringBuilder.append(localException3);
        QLog.e("Shortcut", 1, localStringBuilder.toString());
        bool1 = false;
      }
      j = 1;
    }
    else
    {
      bool1 = false;
      j = 0;
    }
    boolean bool2 = bool1;
    int i = j;
    if (!bool1)
    {
      bool2 = bool1;
      i = j;
      if (a(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
      {
        i = 2;
        Intent localIntent4 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        localIntent4.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        localIntent4.putExtra("packageName", str);
        try
        {
          paramActivity.getBaseContext().startActivity(localIntent4);
          bool2 = true;
        }
        catch (Exception localException4)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("openPermissionActivity e = ");
          localStringBuilder.append(localException4);
          QLog.e("Shortcut", 1, localStringBuilder.toString());
          bool2 = false;
        }
      }
    }
    boolean bool1 = bool2;
    int j = i;
    if (!bool2)
    {
      bool1 = bool2;
      j = i;
      if (a(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
      {
        i = 3;
        Intent localIntent5 = new Intent();
        localIntent5.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        localIntent5.addFlags(268435456);
        try
        {
          paramActivity.getBaseContext().startActivity(localIntent5);
          bool2 = true;
        }
        catch (Exception localException5)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("openPermissionActivity e = ");
          localStringBuilder.append(localException5);
          QLog.e("Shortcut", 1, localStringBuilder.toString());
          bool2 = false;
        }
        bool1 = bool2;
        j = i;
        if (!bool2)
        {
          Intent localIntent6 = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
          try
          {
            paramActivity.getBaseContext().startActivity(localIntent6);
            bool1 = true;
            j = i;
          }
          catch (Exception localException6)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPermissionActivity e = ");
            localStringBuilder.append(localException6);
            QLog.e("Shortcut", 1, localStringBuilder.toString());
            bool1 = false;
            j = i;
          }
        }
      }
    }
    bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      j = 4;
      localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      try
      {
        ((Intent)localObject).setData(Uri.fromParts("package", str, null));
        paramActivity.getBaseContext().startActivity((Intent)localObject);
        bool2 = true;
      }
      catch (Exception localException1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openPermissionActivity e = ");
        ((StringBuilder)localObject).append(localException1);
        QLog.e("Shortcut", 1, ((StringBuilder)localObject).toString());
        bool2 = false;
      }
    }
    bool1 = bool2;
    i = j;
    if (!bool2)
    {
      bool1 = bool2;
      i = j;
      if (a(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION"))
      {
        i = 5;
        Intent localIntent1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        try
        {
          paramActivity.getBaseContext().startActivity(localIntent1);
          bool1 = true;
        }
        catch (Exception localException2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openPermissionActivity e = ");
          ((StringBuilder)localObject).append(localException2);
          QLog.e("Shortcut", 1, ((StringBuilder)localObject).toString());
          bool1 = false;
        }
      }
    }
    if (!bool1)
    {
      i = 6;
      Intent localIntent2 = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent2.putExtra("hide_left_button", false);
      localIntent2.putExtra("show_right_close_button", false);
      localIntent2.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.b(paramActivity, "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15", 524288L, localIntent2, false, -1);
    }
    paramActivity = new StringBuilder();
    paramActivity.append("请求权限, which[");
    paramActivity.append(i);
    paramActivity.append("], openSuccess[");
    paramActivity.append(bool1);
    paramActivity.append("]");
    QLog.w("Shortcut", 1, paramActivity.toString());
  }
  
  public static void b(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback)
  {
    ThreadManagerV2.executeOnSubThread(new ShortcutUtils.3(paramActivity, paramMiniAppInfo, paramAddShortcutCallback));
  }
  
  /* Error */
  public static int c(@NonNull Context paramContext)
  {
    // Byte code:
    //   0: ldc 177
    //   2: iconst_1
    //   3: ldc_w 523
    //   6: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 527	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +14 -> 29
    //   18: ldc 177
    //   20: iconst_1
    //   21: ldc_w 529
    //   24: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: iconst_3
    //   28: ireturn
    //   29: ldc_w 531
    //   32: invokestatic 535	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   35: astore 4
    //   37: getstatic 540	android/os/Build$VERSION:SDK_INT	I
    //   40: bipush 23
    //   42: if_icmplt +37 -> 79
    //   45: aload_0
    //   46: ldc_w 542
    //   49: invokevirtual 546	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: istore_1
    //   57: goto +5 -> 62
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: ifne +16 -> 79
    //   66: ldc 177
    //   68: iconst_1
    //   69: ldc_w 548
    //   72: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: invokestatic 550	com/tencent/qqmini/proxyimpl/ShortcutUtils:a	()I
    //   78: ireturn
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_3
    //   82: aload 4
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: invokevirtual 556	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore_3
    //   92: aload_3
    //   93: astore_2
    //   94: goto +14 -> 108
    //   97: astore_3
    //   98: ldc 177
    //   100: iconst_1
    //   101: ldc_w 558
    //   104: aload_3
    //   105: invokestatic 560	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_2
    //   109: ifnonnull +14 -> 123
    //   112: ldc 177
    //   114: iconst_1
    //   115: ldc_w 562
    //   118: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_3
    //   122: ireturn
    //   123: aload_2
    //   124: invokeinterface 567 1 0
    //   129: ifeq +171 -> 300
    //   132: aload_2
    //   133: aload_2
    //   134: ldc_w 569
    //   137: invokeinterface 572 2 0
    //   142: invokeinterface 575 2 0
    //   147: astore_3
    //   148: new 270	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   155: astore 4
    //   157: aload 4
    //   159: ldc_w 577
    //   162: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 4
    //   168: aload_3
    //   169: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 177
    //   175: iconst_1
    //   176: aload 4
    //   178: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_3
    //   185: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne -65 -> 123
    //   191: aload_3
    //   192: aload_0
    //   193: invokestatic 584	com/tencent/qqmini/proxyimpl/ShortcutUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   196: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq -76 -> 123
    //   202: aload_2
    //   203: aload_2
    //   204: ldc_w 586
    //   207: invokeinterface 572 2 0
    //   212: invokeinterface 590 2 0
    //   217: istore_1
    //   218: new 270	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   225: astore_3
    //   226: aload_3
    //   227: ldc_w 592
    //   230: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_3
    //   235: iload_1
    //   236: invokevirtual 504	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc 177
    //   242: iconst_1
    //   243: aload_3
    //   244: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: iload_1
    //   251: iconst_1
    //   252: if_icmpeq +40 -> 292
    //   255: iload_1
    //   256: bipush 17
    //   258: if_icmpne +6 -> 264
    //   261: goto +31 -> 292
    //   264: iload_1
    //   265: bipush 16
    //   267: if_icmpne +11 -> 278
    //   270: aload_2
    //   271: invokeinterface 595 1 0
    //   276: iconst_0
    //   277: ireturn
    //   278: iload_1
    //   279: bipush 18
    //   281: if_icmpne -158 -> 123
    //   284: aload_2
    //   285: invokeinterface 595 1 0
    //   290: iconst_2
    //   291: ireturn
    //   292: aload_2
    //   293: invokeinterface 595 1 0
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_2
    //   301: invokeinterface 595 1 0
    //   306: iconst_3
    //   307: ireturn
    //   308: astore_0
    //   309: goto +18 -> 327
    //   312: astore_0
    //   313: ldc 177
    //   315: iconst_1
    //   316: aload_0
    //   317: invokevirtual 596	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: aload_0
    //   321: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   324: goto -24 -> 300
    //   327: aload_2
    //   328: invokeinterface 595 1 0
    //   333: goto +5 -> 338
    //   336: aload_0
    //   337: athrow
    //   338: goto -2 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramContext	Context
    //   56	226	1	i	int
    //   80	248	2	localObject1	Object
    //   13	80	3	localObject2	Object
    //   97	8	3	localException	Exception
    //   147	97	3	localObject3	Object
    //   35	142	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	92	97	java/lang/Exception
    //   123	250	308	finally
    //   313	324	308	finally
    //   123	250	312	java/lang/Exception
  }
  
  public static int d(@NonNull Context paramContext)
  {
    QLog.i("Shortcut", 1, "checkOnMIUI");
    if (Build.VERSION.SDK_INT < 19) {
      return 3;
    }
    try
    {
      Object localObject = (AppOpsManager)paramContext.getSystemService("appops");
      String str = paramContext.getApplicationContext().getPackageName();
      int i = paramContext.getApplicationInfo().uid;
      paramContext = Class.forName(AppOpsManager.class.getName()).getDeclaredMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(10017), Integer.valueOf(i), str });
      if (paramContext == null)
      {
        QLog.i("Shortcut", 1, "MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result is null");
        return 3;
      }
      paramContext = paramContext.toString();
      i = Integer.valueOf(paramContext).intValue();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MIUI check permission checkOpNoThrowMethod(AppOpsManager) invoke result = ");
      ((StringBuilder)localObject).append(paramContext);
      QLog.i("Shortcut", 1, ((StringBuilder)localObject).toString());
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 5) {
            return 3;
          }
          return 2;
        }
        return 1;
      }
      return 0;
    }
    catch (Throwable paramContext)
    {
      QLog.i("Shortcut", 1, paramContext.getMessage(), paramContext);
    }
    return 3;
  }
  
  private static void d(Activity paramActivity)
  {
    AppBrandTask.runTaskOnUiThread(new ShortcutUtils.4(paramActivity));
  }
  
  /* Error */
  public static int e(@NonNull Context paramContext)
  {
    // Byte code:
    //   0: ldc 177
    //   2: iconst_1
    //   3: ldc_w 645
    //   6: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 527	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +14 -> 29
    //   18: ldc 177
    //   20: iconst_1
    //   21: ldc_w 529
    //   24: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: iconst_3
    //   28: ireturn
    //   29: aload_2
    //   30: ldc_w 647
    //   33: invokestatic 535	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 556	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull +14 -> 59
    //   48: ldc 177
    //   50: iconst_1
    //   51: ldc_w 649
    //   54: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_3
    //   58: ireturn
    //   59: aload_0
    //   60: invokevirtual 104	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   63: invokevirtual 107	android/content/Context:getPackageName	()Ljava/lang/String;
    //   66: astore_0
    //   67: aload_2
    //   68: invokeinterface 567 1 0
    //   73: ifeq +156 -> 229
    //   76: aload_2
    //   77: aload_2
    //   78: ldc_w 651
    //   81: invokeinterface 654 2 0
    //   86: invokeinterface 575 2 0
    //   91: astore_3
    //   92: new 270	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload 4
    //   103: ldc_w 592
    //   106: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc 177
    //   119: iconst_1
    //   120: aload 4
    //   122: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 241	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload_3
    //   129: invokestatic 582	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: ifne -65 -> 67
    //   135: new 270	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   142: astore 4
    //   144: aload 4
    //   146: aload_0
    //   147: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 4
    //   153: ldc_w 656
    //   156: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: aload 4
    //   163: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   169: istore_1
    //   170: iload_1
    //   171: ifeq +11 -> 182
    //   174: aload_2
    //   175: invokeinterface 595 1 0
    //   180: iconst_0
    //   181: ireturn
    //   182: new 270	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   189: astore 4
    //   191: aload 4
    //   193: aload_0
    //   194: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: ldc_w 658
    //   203: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: aload 4
    //   210: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   216: istore_1
    //   217: iload_1
    //   218: ifeq -151 -> 67
    //   221: aload_2
    //   222: invokeinterface 595 1 0
    //   227: iconst_1
    //   228: ireturn
    //   229: aload_2
    //   230: invokeinterface 595 1 0
    //   235: iconst_3
    //   236: ireturn
    //   237: astore_0
    //   238: goto +23 -> 261
    //   241: astore_0
    //   242: ldc 177
    //   244: iconst_1
    //   245: aload_0
    //   246: invokevirtual 596	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   249: aload_0
    //   250: invokestatic 287	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_2
    //   254: invokeinterface 595 1 0
    //   259: iconst_3
    //   260: ireturn
    //   261: aload_2
    //   262: invokeinterface 595 1 0
    //   267: goto +5 -> 272
    //   270: aload_0
    //   271: athrow
    //   272: goto -2 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramContext	Context
    //   169	49	1	bool	boolean
    //   13	249	2	localObject	Object
    //   91	117	3	str	String
    //   99	110	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	67	237	finally
    //   67	170	237	finally
    //   182	217	237	finally
    //   242	253	237	finally
    //   59	67	241	java/lang/Exception
    //   67	170	241	java/lang/Exception
    //   182	217	241	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class FloatingPermission
{
  public static boolean a()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("vivo");
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (a()) {
      return b(paramContext);
    }
    return c(paramContext);
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (paramIntent == null) {
        return false;
      }
      paramContext = paramIntent.resolveActivityInfo(paramContext.getPackageManager(), 65536);
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.exported) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public static boolean b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 6
    //   8: astore 5
    //   10: aload 7
    //   12: astore 4
    //   14: aload_0
    //   15: invokevirtual 60	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   18: astore 8
    //   20: aload 6
    //   22: astore 5
    //   24: aload 7
    //   26: astore 4
    //   28: ldc 62
    //   30: invokestatic 68	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   33: astore 9
    //   35: aload 6
    //   37: astore 5
    //   39: aload 7
    //   41: astore 4
    //   43: new 70	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   50: astore 10
    //   52: aload 6
    //   54: astore 5
    //   56: aload 7
    //   58: astore 4
    //   60: aload 10
    //   62: ldc 73
    //   64: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: astore 5
    //   72: aload 7
    //   74: astore 4
    //   76: aload 10
    //   78: aload_0
    //   79: invokevirtual 81	android/content/Context:getPackageName	()Ljava/lang/String;
    //   82: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: astore 5
    //   90: aload 7
    //   92: astore 4
    //   94: aload 10
    //   96: ldc 83
    //   98: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: astore 5
    //   106: aload 7
    //   108: astore 4
    //   110: aload 10
    //   112: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 10
    //   117: aload 6
    //   119: astore 5
    //   121: aload 7
    //   123: astore 4
    //   125: aload 8
    //   127: aload 9
    //   129: iconst_1
    //   130: anewarray 21	java/lang/String
    //   133: dup
    //   134: iconst_0
    //   135: ldc 88
    //   137: aastore
    //   138: aload 10
    //   140: aconst_null
    //   141: aconst_null
    //   142: invokevirtual 94	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   145: astore 6
    //   147: aload 6
    //   149: ifnull +92 -> 241
    //   152: aload 6
    //   154: astore 5
    //   156: aload 6
    //   158: astore 4
    //   160: aload 6
    //   162: invokeinterface 99 1 0
    //   167: ifeq +74 -> 241
    //   170: aload 6
    //   172: astore 5
    //   174: aload 6
    //   176: astore 4
    //   178: aload 6
    //   180: iconst_0
    //   181: invokeinterface 103 2 0
    //   186: istore_1
    //   187: iload_1
    //   188: ifne +187 -> 375
    //   191: iconst_1
    //   192: istore_2
    //   193: goto +3 -> 196
    //   196: aload 6
    //   198: astore 5
    //   200: aload 6
    //   202: astore 4
    //   204: ldc 105
    //   206: iconst_1
    //   207: iconst_4
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: ldc 107
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: iload_1
    //   219: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: ldc 115
    //   227: aastore
    //   228: dup
    //   229: iconst_3
    //   230: iload_2
    //   231: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   234: aastore
    //   235: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   238: goto +56 -> 294
    //   241: aload 6
    //   243: astore 5
    //   245: aload 6
    //   247: astore 4
    //   249: aload_0
    //   250: invokestatic 34	com/tencent/timi/game/utils/FloatingPermission:c	(Landroid/content/Context;)Z
    //   253: istore_2
    //   254: aload 6
    //   256: astore 5
    //   258: aload 6
    //   260: astore 4
    //   262: ldc 105
    //   264: iconst_1
    //   265: iconst_4
    //   266: anewarray 4	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: ldc 128
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: iload_2
    //   277: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: ldc 130
    //   285: aastore
    //   286: dup
    //   287: iconst_3
    //   288: aload 6
    //   290: aastore
    //   291: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   294: iload_2
    //   295: istore_3
    //   296: aload 6
    //   298: ifnull +55 -> 353
    //   301: aload 6
    //   303: astore 4
    //   305: aload 4
    //   307: invokeinterface 133 1 0
    //   312: iload_2
    //   313: ireturn
    //   314: astore_0
    //   315: goto +40 -> 355
    //   318: astore 6
    //   320: aload 4
    //   322: astore 5
    //   324: ldc 105
    //   326: iconst_1
    //   327: ldc 135
    //   329: aload 6
    //   331: invokestatic 139	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload 4
    //   336: astore 5
    //   338: aload_0
    //   339: invokestatic 34	com/tencent/timi/game/utils/FloatingPermission:c	(Landroid/content/Context;)Z
    //   342: istore_2
    //   343: iload_2
    //   344: istore_3
    //   345: aload 4
    //   347: ifnull +6 -> 353
    //   350: goto -45 -> 305
    //   353: iload_3
    //   354: ireturn
    //   355: aload 5
    //   357: ifnull +10 -> 367
    //   360: aload 5
    //   362: invokeinterface 133 1 0
    //   367: goto +5 -> 372
    //   370: aload_0
    //   371: athrow
    //   372: goto -2 -> 370
    //   375: iconst_0
    //   376: istore_2
    //   377: goto -181 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	Context
    //   186	33	1	i	int
    //   192	185	2	bool1	boolean
    //   295	59	3	bool2	boolean
    //   12	334	4	localObject1	Object
    //   8	353	5	localObject2	Object
    //   4	298	6	localCursor	android.database.Cursor
    //   318	12	6	localThrowable	java.lang.Throwable
    //   1	121	7	localObject3	Object
    //   18	108	8	localContentResolver	android.content.ContentResolver
    //   33	95	9	localUri	Uri
    //   50	89	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	20	314	finally
    //   28	35	314	finally
    //   43	52	314	finally
    //   60	68	314	finally
    //   76	86	314	finally
    //   94	102	314	finally
    //   110	117	314	finally
    //   125	147	314	finally
    //   160	170	314	finally
    //   178	187	314	finally
    //   204	238	314	finally
    //   249	254	314	finally
    //   262	294	314	finally
    //   324	334	314	finally
    //   338	343	314	finally
    //   14	20	318	java/lang/Throwable
    //   28	35	318	java/lang/Throwable
    //   43	52	318	java/lang/Throwable
    //   60	68	318	java/lang/Throwable
    //   76	86	318	java/lang/Throwable
    //   94	102	318	java/lang/Throwable
    //   110	117	318	java/lang/Throwable
    //   125	147	318	java/lang/Throwable
    //   160	170	318	java/lang/Throwable
    //   178	187	318	java/lang/Throwable
    //   204	238	318	java/lang/Throwable
    //   249	254	318	java/lang/Throwable
    //   262	294	318	java/lang/Throwable
  }
  
  public static boolean c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Settings.canDrawOverlays(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return e(paramContext);
    }
    return true;
  }
  
  public static boolean d(Context paramContext)
  {
    if (a())
    {
      bool2 = j(paramContext);
      bool1 = bool2;
      if (!bool2) {
        bool1 = k(paramContext);
      }
    }
    else
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        bool2 = f(paramContext);
      }
    }
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = l(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = m(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = n(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = i(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = g(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = h(paramContext);
    }
    return bool2;
  }
  
  @TargetApi(19)
  private static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    try
    {
      Object localObject = paramContext.getSystemService("appops");
      if (localObject == null) {
        return false;
      }
      Method localMethod = localObject.getClass().getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      if (localMethod == null) {
        return false;
      }
      paramContext = (Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), paramContext.getPackageName() });
      if (QLog.isColorLevel()) {
        QLog.d("FloatingScreenPermission", 2, new Object[] { "checkOps ", paramContext });
      }
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.intValue();
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  @RequiresApi(api=23)
  private static boolean f(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("package:");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).addFlags(268435456);
    if (a(paramContext, (Intent)localObject)) {
      try
      {
        paramContext.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean g(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean h(Context paramContext)
  {
    Intent localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean i(Context paramContext)
  {
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean j(Context paramContext)
  {
    Intent localIntent = new Intent("com.iqoo.secure");
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean k(Context paramContext)
  {
    Intent localIntent = new Intent("permission.intent.action.softPermissionDetail");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    localIntent.putExtra("packagename", paramContext.getPackageName());
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean l(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean n(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (a(paramContext, localIntent)) {
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.FloatingPermission
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.phonecontact;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PermissionPageUtil
{
  private static String c;
  private Context a;
  private String b;
  
  public PermissionPageUtil(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    ThreadManager.excute(new PermissionPageUtil.1(this), 16, null, true);
    a(String.format("PermissionPageUtil [%s]", new Object[] { paramString }));
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPageUtil", 2, paramString);
    }
  }
  
  private void b(String paramString)
  {
    String str = null;
    try
    {
      paramString = this.a.getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString == null)
    {
      d();
      return;
    }
    Object localObject = new Intent("android.intent.action.MAIN", null);
    ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject).setPackage(paramString.packageName);
    localObject = this.a.getPackageManager().queryIntentActivities((Intent)localObject, 0);
    paramString = str;
    if (localObject != null)
    {
      paramString = str;
      if (((List)localObject).size() > 0) {
        paramString = (ResolveInfo)((List)localObject).get(0);
      }
    }
    if (paramString != null)
    {
      str = paramString.activityInfo.packageName;
      paramString = paramString.activityInfo.name;
      localObject = new Intent("android.intent.action.MAIN");
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setComponent(new ComponentName(str, paramString));
      a((Intent)localObject);
      return;
    }
    d();
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnull +5 -> 10
    //   8: aload_0
    //   9: areturn
    //   10: aconst_null
    //   11: astore_2
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_1
    //   15: astore_0
    //   16: invokestatic 146	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   19: astore_3
    //   20: aload_1
    //   21: astore_0
    //   22: new 148	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   29: astore 4
    //   31: aload_1
    //   32: astore_0
    //   33: aload 4
    //   35: ldc 151
    //   37: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: astore_0
    //   43: aload 4
    //   45: ldc 157
    //   47: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: astore_0
    //   53: new 159	java/io/BufferedReader
    //   56: dup
    //   57: new 161	java/io/InputStreamReader
    //   60: dup
    //   61: aload_3
    //   62: aload 4
    //   64: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokevirtual 168	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   70: invokevirtual 174	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   73: invokespecial 177	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   76: sipush 1024
    //   79: invokespecial 180	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: putstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   90: aload_1
    //   91: invokevirtual 186	java/io/BufferedReader:close	()V
    //   94: aload_1
    //   95: invokevirtual 186	java/io/BufferedReader:close	()V
    //   98: goto +8 -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   106: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   109: ifnonnull +60 -> 169
    //   112: goto +52 -> 164
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: goto +71 -> 191
    //   123: astore_2
    //   124: goto +12 -> 136
    //   127: astore_1
    //   128: goto +63 -> 191
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: astore_2
    //   136: aload_1
    //   137: astore_0
    //   138: aload_2
    //   139: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   142: aload_1
    //   143: ifnull +15 -> 158
    //   146: aload_1
    //   147: invokevirtual 186	java/io/BufferedReader:close	()V
    //   150: goto +8 -> 158
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   158: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   161: ifnonnull +8 -> 169
    //   164: ldc 189
    //   166: putstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   169: ldc 191
    //   171: iconst_1
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   180: aastore
    //   181: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokestatic 42	com/tencent/mobileqq/phonecontact/PermissionPageUtil:a	(Ljava/lang/String;)V
    //   187: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   190: areturn
    //   191: aload_0
    //   192: ifnull +15 -> 207
    //   195: aload_0
    //   196: invokevirtual 186	java/io/BufferedReader:close	()V
    //   199: goto +8 -> 207
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 187	java/lang/Throwable:printStackTrace	()V
    //   207: getstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   210: ifnonnull +8 -> 218
    //   213: ldc 189
    //   215: putstatic 140	com/tencent/mobileqq/phonecontact/PermissionPageUtil:c	Ljava/lang/String;
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	50	0	localObject1	Object
    //   101	2	0	localThrowable1	Throwable
    //   117	1	0	localObject2	Object
    //   131	4	0	localThrowable2	Throwable
    //   137	1	0	localObject3	Object
    //   153	43	0	localThrowable3	Throwable
    //   202	2	0	localThrowable4	Throwable
    //   13	107	1	localObject4	Object
    //   127	1	1	localObject5	Object
    //   133	86	1	localThrowable5	Throwable
    //   11	1	2	localObject6	Object
    //   115	4	2	localObject7	Object
    //   123	10	2	localThrowable6	Throwable
    //   135	4	2	localThrowable7	Throwable
    //   19	43	3	localRuntime	java.lang.Runtime
    //   29	34	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	98	101	java/lang/Throwable
    //   83	94	115	finally
    //   83	94	123	java/lang/Throwable
    //   16	20	127	finally
    //   22	31	127	finally
    //   33	41	127	finally
    //   43	51	127	finally
    //   53	83	127	finally
    //   138	142	127	finally
    //   16	20	131	java/lang/Throwable
    //   22	31	131	java/lang/Throwable
    //   33	41	131	java/lang/Throwable
    //   43	51	131	java/lang/Throwable
    //   53	83	131	java/lang/Throwable
    //   146	150	153	java/lang/Throwable
    //   195	199	202	java/lang/Throwable
  }
  
  private void d()
  {
    a("goIntentSetting");
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
    Context localContext = this.a;
    if ((localContext instanceof Activity))
    {
      ((Activity)localContext).startActivityForResult(localIntent, 9999);
      return;
    }
    localContext.startActivity(localIntent);
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this.b);
    localIntent.setFlags(268435456);
    localIntent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
    a(localIntent);
  }
  
  private void f()
  {
    Object localObject = c();
    if ((!"V6".equals(localObject)) && (!"V7".equals(localObject)))
    {
      if ((!"V8".equals(localObject)) && (!"V9".equals(localObject)))
      {
        d();
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
      ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
      ((Intent)localObject).putExtra("extra_pkgname", this.b);
      a((Intent)localObject);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
    ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    ((Intent)localObject).putExtra("extra_pkgname", this.b);
    a((Intent)localObject);
  }
  
  public void a()
  {
    a(String.format("jumpPermissionPage [brand: %s, model: %s, manufacture: %s]", new Object[] { Build.BRAND, Build.MODEL, Build.MANUFACTURER }));
    String str = Build.MANUFACTURER;
    if ("HUAWEI".equals(str))
    {
      e();
      return;
    }
    if ("vivo".equals(str))
    {
      b("com.bairenkeji.icaller");
      return;
    }
    if ("OPPO".equals(str))
    {
      b("com.coloros.safecenter");
      return;
    }
    if ("Xiaomi".equals(str))
    {
      f();
      return;
    }
    d();
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      if ((this.a instanceof Activity))
      {
        ((Activity)this.a).startActivityForResult(paramIntent, 9999);
        return;
      }
      this.a.startActivity(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
      a(String.format("doStartApplicationWithPackageName [%s]", new Object[] { paramIntent.getMessage() }));
      d();
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "https://kf.qq.com/touch/faq/120307IVnEni150407eEv2IF.html?platform=14&_wv=0");
    Context localContext = this.a;
    if ((localContext instanceof Activity)) {
      ((Activity)localContext).startActivityForResult(localIntent, 9999);
    } else {
      localContext.startActivity(localIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPageUtil", 2, "openDefaultGuide");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.PermissionPageUtil
 * JD-Core Version:    0.7.0.1
 */
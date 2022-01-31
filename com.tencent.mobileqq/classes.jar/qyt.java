import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class qyt
{
  public static boolean a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return Settings.canDrawOverlays(paramContext);
    }
    if (i >= 19) {
      return a(paramContext, 24);
    }
    return true;
  }
  
  @RequiresApi(19)
  private static boolean a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      try
      {
        paramContext = (Integer)localAppOpsManager.getClass().getDeclaredMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), paramContext.getApplicationContext().getPackageName() });
        if (QLog.isColorLevel()) {
          QLog.d("FloatWindowOpUtils", 1, "0 invoke " + paramContext);
        }
        if (paramContext != null)
        {
          paramInt = paramContext.intValue();
          if (paramInt == 0) {
            return true;
          }
        }
        return false;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FloatWindowOpUtils", 1, "checkOp failed.", paramContext);
        }
      }
    }
    return true;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return false;
      paramContext = paramIntent.resolveActivityInfo(paramContext.getPackageManager(), 65536);
    } while ((paramContext == null) || (!paramContext.exported));
    return true;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    if (Build.VERSION.SDK_INT >= 23) {
      bool2 = c(paramContext);
    }
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = h(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = i(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = j(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = g(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = f(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = d(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = e(paramContext);
    }
    return bool1;
  }
  
  @RequiresApi(api=23)
  private static boolean c(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + paramContext.getPackageName()));
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean e(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean f(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean g(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("com.iqoo.secure");
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean h(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean i(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean j(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    if (a(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qyt
 * JD-Core Version:    0.7.0.1
 */
package cooperation.ilive.lite.floatwindow;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.falco.base.floatwindow.permission.FWPermission;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;

public class IliveFloatWindowHelper
{
  public static long a()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    long l2 = 24L;
    long l1 = l2;
    if (localIliveManagerCfgBean != null)
    {
      l1 = l2;
      if (localIliveManagerCfgBean.b() > 0L) {
        l1 = localIliveManagerCfgBean.b();
      }
    }
    return l1;
  }
  
  private static void a()
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ilive_float_window", 0).edit();
    localEditor.putLong("last_open_permission_time", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static boolean a()
  {
    IliveManagerCfgBean localIliveManagerCfgBean = IliveManagerConfProcessor.a();
    if (localIliveManagerCfgBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEnableFloatWindowShow config switch =  ");
      localStringBuilder.append(localIliveManagerCfgBean.e());
      QLog.e("IliveFloatWindowHelper", 1, localStringBuilder.toString());
      return localIliveManagerCfgBean.e();
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity, IliveFloatWindowHelper.IPermissionCallback paramIPermissionCallback)
  {
    try
    {
      if (!a())
      {
        QLog.e("IliveFloatWindowHelper", 1, "checkHasFloatWindowPermission switch = 0");
        return false;
      }
      boolean bool1 = FWPermission.hasPermission(paramActivity);
      boolean bool2 = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkHasFloatWindowPermission hasPermission = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" enableShow = ");
      localStringBuilder.append(bool2);
      QLog.e("IliveFloatWindowHelper", 1, localStringBuilder.toString());
      if ((!bool1) && (bool2))
      {
        DialogUtil.a(paramActivity, 230, HardCodeUtil.a(2131694539), HardCodeUtil.a(2131694538), HardCodeUtil.a(2131691602), HardCodeUtil.a(2131691603), new IliveFloatWindowHelper.1(paramActivity, paramIPermissionCallback), new IliveFloatWindowHelper.2(paramIPermissionCallback)).show();
        a();
        return true;
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
      QLog.e("IliveFloatWindowHelper", 1, "checkHasFloatWindowPermission exception", paramActivity);
    }
    return false;
  }
  
  private static boolean b()
  {
    long l1 = BaseApplication.getContext().getSharedPreferences("ilive_float_window", 0).getLong("last_open_permission_time", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFloatWindowShowInterval = ");
    localStringBuilder.append(l3);
    QLog.e("IliveFloatWindowHelper", 1, localStringBuilder.toString());
    return l2 - l1 >= l3 * 60L * 60L * 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper
 * JD-Core Version:    0.7.0.1
 */
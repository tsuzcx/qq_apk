package cooperation.qzone.util;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qzonehub.api.IQzoneMixApi;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class QZonePermission
{
  private static Activity getRealActivity(Activity paramActivity)
  {
    if (paramActivity == null) {
      return null;
    }
    Activity localActivity = paramActivity;
    if ((paramActivity instanceof BasePluginActivity)) {
      localActivity = ((BasePluginActivity)paramActivity).getOutActivity();
    }
    return localActivity;
  }
  
  public static boolean requestStoragePermission(Activity paramActivity)
  {
    return requestStoragePermission(paramActivity, new QZonePermission.1(paramActivity), 0);
  }
  
  public static boolean requestStoragePermission(Activity paramActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramActivity == null) {
      return false;
    }
    if ((paramActivity instanceof BasePluginActivity)) {
      return requestStoragePermission((BasePluginActivity)paramActivity, paramQQPermissionCallback, paramInt);
    }
    if ((paramActivity instanceof BaseActivity)) {
      return requestStoragePermissionForBaseActivity((BaseActivity)paramActivity, paramQQPermissionCallback, paramInt);
    }
    if ((paramActivity instanceof Activity)) {
      return requestStoragePermissionForActivity(paramActivity);
    }
    return ((IQzoneMixApi)QRoute.api(IQzoneMixApi.class)).requestStoragePermission(paramActivity, paramQQPermissionCallback, paramInt);
  }
  
  public static boolean requestStoragePermission(BasePluginActivity paramBasePluginActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramBasePluginActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramBasePluginActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramBasePluginActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      paramBasePluginActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return false;
    }
    return true;
  }
  
  private static boolean requestStoragePermissionForActivity(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      DialogUtil.a(getRealActivity(paramActivity));
      return false;
    }
    return true;
  }
  
  private static boolean requestStoragePermissionForBaseActivity(BaseActivity paramBaseActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramBaseActivity == null) {
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && ((paramBaseActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
    {
      paramBaseActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QZonePermission
 * JD-Core Version:    0.7.0.1
 */
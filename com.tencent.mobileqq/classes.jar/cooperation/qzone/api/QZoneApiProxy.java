package cooperation.qzone.api;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import mqq.app.AppRuntime;

public class QZoneApiProxy
{
  public static final String EXTEND_FRAGMENT_CLASS_NAME = "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment";
  public static final String FRIEND_FRAGMENT_CLASS_NAME = "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment";
  private static final String TAG = "QZoneApiProxy";
  
  @Nullable
  public static Fragment createLebaFragment(@NonNull Activity paramActivity, @NonNull AppRuntime paramAppRuntime, @NonNull String paramString)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).createLebaFragment(paramActivity, paramAppRuntime, paramString);
  }
  
  public static AppRuntime getLastRuntime()
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).getLastRuntime();
  }
  
  public static boolean initEnv(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).initEnv(paramContext, paramAppRuntime);
  }
  
  public static void initSchoolExtendListCreator()
  {
    ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).initSchoolExtendListCreator();
  }
  
  public static boolean initServlet(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).initServlet(paramContext, paramAppRuntime);
  }
  
  public static boolean isInQZoneEnvironment()
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).isInQZoneEnvironment();
  }
  
  public static boolean isQzoneInstalled()
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).isQzoneInstalled();
  }
  
  public static boolean isQzonePluginInstalledAndVersionRight(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).isQzonePluginInstalledAndVersionRight(paramQZoneLoadCallback);
  }
  
  public static boolean isRightAndroidVersionForStickyNote()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean needLoadQZoneEnv()
  {
    return needLoadQZoneEnv(null);
  }
  
  public static boolean needLoadQZoneEnv(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needLoadQZoneEnv(paramQZoneLoadCallback);
  }
  
  public static boolean needShowAioFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needShowAioFeedList(paramActivity, paramAppRuntime);
  }
  
  public static boolean needShowQzoneFrame(@Nullable Context paramContext, @Nullable AppRuntime paramAppRuntime)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(paramContext, paramAppRuntime);
  }
  
  public static boolean needShowSchoolExtendFeed(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    return ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).needShowSchoolExtendFeed(paramActivity, paramAppRuntime);
  }
  
  public static void onAccountChange(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    ((IQZoneApiProxy)QRoute.api(IQZoneApiProxy.class)).onAccountChange(paramContext, paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.QZoneApiProxy
 * JD-Core Version:    0.7.0.1
 */
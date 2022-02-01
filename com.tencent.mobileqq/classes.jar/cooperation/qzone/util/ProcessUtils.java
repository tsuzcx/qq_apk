package cooperation.qzone.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class ProcessUtils
{
  private static final String LOG_TAG = "ProcessUtils";
  private static List<String> homePackages;
  public static WeakReference<Activity> qzoneTopActivity;
  public static int qzoneTopActivityHashCode = 0;
  public static String qzoneTopActivityName = "";
  
  private static String getActivePackage()
  {
    Object localObject3 = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningAppProcesses();
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("processInfos.size()=");
      ((StringBuilder)localObject1).append(((List)localObject3).size());
      QLog.d("ProcessUtils", 4, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      QLog.w("ProcessUtils", 1, "NoSuchFieldException: processState", localNoSuchFieldException);
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (QLog.isDevelopLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("processInfo: processName=");
          ((StringBuilder)localObject3).append(localRunningAppProcessInfo.processName);
          ((StringBuilder)localObject3).append(" importance=");
          ((StringBuilder)localObject3).append(localRunningAppProcessInfo.importance);
          ((StringBuilder)localObject3).append(" importanceReasonCode=");
          ((StringBuilder)localObject3).append(localRunningAppProcessInfo.importanceReasonCode);
          QLog.d("ProcessUtils", 4, ((StringBuilder)localObject3).toString());
        }
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.importanceReasonCode == 0))
        {
          Object localObject4;
          try
          {
            localObject3 = Integer.valueOf(localObject2.getInt(localRunningAppProcessInfo));
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            QLog.w("ProcessUtils", 1, "IllegalAccessException", localIllegalAccessException);
            localObject4 = null;
          }
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("processInfo: state=");
            localStringBuilder.append(localObject4);
            QLog.d("ProcessUtils", 4, localStringBuilder.toString());
          }
          if ((localObject4 != null) && (localObject4.intValue() == 2))
          {
            localObject2 = localRunningAppProcessInfo;
            break label282;
          }
        }
      }
    }
    Object localObject2 = null;
    label282:
    if (QLog.isDevelopLevel()) {
      QLog.d("ProcessUtils", 4, "===============");
    }
    if (localObject2 == null) {
      return null;
    }
    return localObject2.processName;
  }
  
  public static String getActivePackageCompat()
  {
    Object localObject = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).get(0) != null) && (((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity != null))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((ComponentName)localObject).getPackageName());
      localStringBuilder.append("/");
      localStringBuilder.append(((ComponentName)localObject).getClassName());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getCurProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      QLog.e("ProcessUtils", 1, "getCurProcessName: processInfos is null.");
      return null;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  private static List<String> getHomes()
  {
    Object localObject1 = homePackages;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = new ArrayList();
    Object localObject2 = MobileQQ.getContext().getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localObject2 = ((PackageManager)localObject2).queryIntentActivities(localIntent, 65536).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((ResolveInfo)((Iterator)localObject2).next()).activityInfo.packageName);
    }
    homePackages = (List)localObject1;
    return localObject1;
  }
  
  public static String getRunningProcessPackageName()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return getActivePackage();
    }
    return getActivePackageCompat();
  }
  
  public static Activity getTopActivity()
  {
    return (Activity)qzoneTopActivity.get();
  }
  
  public static int getTopActivityHashCode()
  {
    return qzoneTopActivityHashCode;
  }
  
  public static String getTopActivityName()
  {
    return qzoneTopActivityName;
  }
  
  public static boolean isH5(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:tool".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramString)));
  }
  
  public static boolean isHome(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    List localList = getHomes();
    if (localList.contains(paramString)) {
      return true;
    }
    paramString = paramString.split("/");
    if (paramString.length < 2) {
      return false;
    }
    return localList.contains(paramString[0]);
  }
  
  public static boolean isPeak(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:peak".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.PhotoListActivity".equals(paramString)) || ("com.tencent.mobileqq/com.tencent.mobileqq.activity.photo.AlbumListActivity".equals(paramString)));
  }
  
  public static boolean isPicture(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:picture".equals(paramString)) || ("com.tencent.mobileqq/cooperation.qzone.QzonePicturePluginProxyActivity".equals(paramString)));
  }
  
  public static boolean isQQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ("com.tencent.mobileqq".equals(paramString)) {
      return true;
    }
    paramString = paramString.split("/");
    if (paramString.length < 2) {
      return false;
    }
    if ("com.tencent.mobileqq".equals(paramString[0])) {
      return !TextUtils.isEmpty(paramString[1]);
    }
    return false;
  }
  
  public static boolean isQzone(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ("com.tencent.mobileqq:qzone".equals(paramString)) {
      return true;
    }
    paramString = paramString.split("/");
    if (paramString.length < 2) {
      return false;
    }
    bool1 = bool2;
    if ("com.tencent.mobileqq".equals(paramString[0]))
    {
      if (TextUtils.isEmpty(paramString[1])) {
        return false;
      }
      paramString = paramString[1].toLowerCase().split("\\.");
      bool1 = bool2;
      if (paramString.length > 0)
      {
        bool1 = bool2;
        if (paramString[(paramString.length - 1)].startsWith("qzone"))
        {
          bool1 = bool2;
          if (paramString[(paramString.length - 1)].endsWith("proxyactivity")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isQzoneLive(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (("com.tencent.mobileqq:qzonelive".equals(paramString)) || ("com.tencent.mobileqq/cooperation.qzone.video.QzoneLiveVideoGpuProxyActivity".equals(paramString)));
  }
  
  public static void setTopActivity(Activity paramActivity, String paramString)
  {
    qzoneTopActivity = new WeakReference(paramActivity);
    qzoneTopActivityHashCode = qzoneTopActivity.hashCode();
    qzoneTopActivityName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */
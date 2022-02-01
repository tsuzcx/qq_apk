package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

@RoutePage(desc="扩列activity", path="/expand/activity")
public class ExpandPublicFragmentActivity
  extends QPublicFragmentActivity
{
  private static final long LAUNCH_FREQ_CTRL_INTERVAL = 1000L;
  private static final String TAG = "ExtendFriendPublicFragmentActivity";
  private static volatile long sLastLaunchTime;
  private ClassLoader mClassLoader = null;
  
  public static String getReportFromPage(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramInt);
                localStringBuilder.append("");
                return localStringBuilder.toString();
              }
              return "5";
            }
            return "6";
          }
          return "3";
        }
        return "2";
      }
      return "1";
    }
    return "7";
  }
  
  public static void launchExtendFriendNewFragment(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.d("ExtendFriendPublicFragmentActivity", 2, String.format("launchExtendFriendNewFragment context=%s source=%s freqCtrl=%s", new Object[] { paramContext, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - sLastLaunchTime < 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendPublicFragmentActivity", 2, "launchExtendFriendNewFragment launch too often.");
      }
      return;
    }
    sLastLaunchTime = l;
    paramContext = new Intent();
    paramContext.putExtra("extend_frient_from", paramInt);
    paramContext.putExtra("extend_frient_type_url", paramString);
    QPublicFragmentActivity.Launcher.a(paramContext, ExpandPublicFragmentActivity.class, ExpandNewFragment.class);
    reportExtendFriendEntry(paramInt);
  }
  
  private static void reportExtendFriendEntry(int paramInt)
  {
    Object localObject = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    String str = "";
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoLbsInfo)localObject).mLocation;
      if (!TextUtils.isEmpty(((SosoLocation)localObject).city)) {
        str = ((SosoLocation)localObject).city;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject).mLat02), Double.valueOf(((SosoLocation)localObject).mLon02) });
    }
    else
    {
      str = "";
      localObject = str;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AD99", "0X800AD99", paramInt, 0, "", "", str, (String)localObject);
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */
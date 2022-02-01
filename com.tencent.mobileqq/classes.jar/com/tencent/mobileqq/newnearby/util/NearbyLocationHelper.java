package com.tencent.mobileqq.newnearby.util;

import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NearbyLocationHelper
{
  private static SosoLbsInfo a;
  private static long b;
  
  public static void a(QBaseActivity paramQBaseActivity, Promise paramPromise)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.d("NearbyLocationImpl", 1, "ACCESS_FINE_LOCATION permission not granted!");
        b(paramQBaseActivity, paramPromise);
        return;
      }
      if (System.currentTimeMillis() - b > 300000L)
      {
        b(paramPromise);
        return;
      }
      SosoLbsInfo localSosoLbsInfo = a;
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        if ((paramQBaseActivity instanceof NearbyActivity)) {
          NearbyReportHelperImpl.reportRequestLocation((NearbyActivity)paramQBaseActivity, true, false);
        }
        NearbyHippyCallback.a(paramPromise, a);
        return;
      }
      localSosoLbsInfo = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyLastLocation(c().getCurrentAccountUin());
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null) && (localSosoLbsInfo.mLocation.nation != null) && (localSosoLbsInfo.mLocation.province != null) && (localSosoLbsInfo.mLocation.city != null))
      {
        a = localSosoLbsInfo;
        NearbyHippyCallback.a(paramPromise, a);
        if ((paramQBaseActivity instanceof NearbyActivity)) {
          NearbyReportHelperImpl.reportRequestLocation((NearbyActivity)paramQBaseActivity, true, false);
        }
        return;
      }
      QLog.d("NearbyLocationImpl", 2, "requestLBS: location info is null");
      b(paramPromise);
    }
  }
  
  private static void b(QBaseActivity paramQBaseActivity, Promise paramPromise)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (paramQBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      paramQBaseActivity.requestPermissions(new NearbyLocationHelper.1(paramPromise), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
  }
  
  private static void b(Promise paramPromise)
  {
    b = System.currentTimeMillis();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NearbyLocationHelper.2(3, true, false, 300000L, true, false, "NearbyNowliveTab", paramPromise));
  }
  
  private static AppInterface c()
  {
    AppRuntime localAppRuntime2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    AppRuntime localAppRuntime1 = localAppRuntime2;
    if (MobileQQ.sProcessId == 7)
    {
      localAppRuntime1 = localAppRuntime2;
      if (localAppRuntime2 != null) {
        localAppRuntime1 = localAppRuntime2.getAppRuntime("modular_web");
      }
    }
    if ((localAppRuntime1 instanceof AppInterface)) {
      return (AppInterface)localAppRuntime1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.NearbyLocationHelper
 * JD-Core Version:    0.7.0.1
 */
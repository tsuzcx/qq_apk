package com.tencent.mobileqq.nearby;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.INearbyVersionControl;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetMasterControlReq;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NearbyFakeActivityUtilsReal
{
  private static boolean a;
  
  @TargetApi(11)
  public static void a(Context paramContext, Intent paramIntent)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportQQNearbyTabClick((AppInterface)localObject);
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openNearbyActWithPreLoad, isNearbyProcessExist=");
      localStringBuilder.append(bool);
      QLog.i("NearbyFakeActivity", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      b(paramContext, paramIntent);
      return;
    }
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportEnterFakeNearby((AppInterface)localObject);
    localObject = new Intent(paramContext, NearbyFakeActivity.class);
    ((Intent)localObject).putExtra("intent", paramIntent);
    paramContext.startActivity((Intent)localObject);
    try
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_fake_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean a()
  {
    return PreloadProcHitSession.a("com.tencent.mobileqq:tool");
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    nearbyControl.GetMasterControlReq localGetMasterControlReq = new nearbyControl.GetMasterControlReq();
    localGetMasterControlReq.source.set("Android");
    List localList = Arrays.asList(new Integer[] { Integer.valueOf(101) });
    localGetMasterControlReq.req_flag.set(localList);
    ProtoUtils.a(c(), new NearbyFakeActivityUtilsReal.1(paramContext, paramIntent), localGetMasterControlReq.toByteArray(), "trpc.nearby.trpc_nearby_control.nearby_control.GetMasterControl");
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
  
  private static void e(Context paramContext, Intent paramIntent)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (a) {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportEnterNewNearby(localQQAppInterface);
    } else {
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportEnterOldNearby(localQQAppInterface);
    }
    paramIntent.putExtra("CLICK_ENTER_TIME", System.currentTimeMillis());
    paramIntent.putExtra("is_new", a);
    RouteUtils.a(paramContext, paramIntent, "/nearby/activity");
    try
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return;
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("enterNearby, error:");
      paramIntent.append(paramContext.getMessage());
      QLog.e("NearbyFakeActivityUtilsReal", 2, paramIntent.toString());
    }
  }
  
  private static void f(Context paramContext, Intent paramIntent)
  {
    a = false;
    QLog.d("NearbyFakeActivityUtilsReal", 2, "reqNearbyControl error");
    ((INearbyVersionControl)QRoute.api(INearbyVersionControl.class)).updateVersion(1);
    e(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivityUtilsReal
 * JD-Core Version:    0.7.0.1
 */
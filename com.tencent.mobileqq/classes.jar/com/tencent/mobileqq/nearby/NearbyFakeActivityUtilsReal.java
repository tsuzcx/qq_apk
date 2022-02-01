package com.tencent.mobileqq.nearby;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class NearbyFakeActivityUtilsReal
{
  @TargetApi(11)
  public static void a(Context paramContext, Intent paramIntent)
  {
    boolean bool = a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openNearbyActWithPreLoad, isNearbyProcessExist=");
      ((StringBuilder)localObject).append(bool);
      QLog.i("NearbyFakeActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      RouteUtils.a(paramContext, paramIntent, "/nearby/activity");
    }
    try
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return;
    }
    catch (Exception paramContext)
    {
      try
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_fake_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
        return;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      return;
    }
    Object localObject = new Intent(paramContext, NearbyFakeActivity.class);
    ((Intent)localObject).putExtra("intent", paramIntent);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static boolean a()
  {
    return PreloadProcHitSession.a("com.tencent.mobileqq:tool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivityUtilsReal
 * JD-Core Version:    0.7.0.1
 */
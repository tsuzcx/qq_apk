package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoySpEventReportUtil
{
  private static boolean a = false;
  private static final LbsManagerServiceOnLocationChangeListener b = new ReadInJoySpEventReportUtil.1("readinjoy_anti_cheating", false);
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "init, app launch time = ", Long.valueOf(l) });
    RIJSPUtils.a("readinjoy_sp_key_app_launch_time", Long.valueOf(l));
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    SosoLocation localSosoLocation = c();
    if (localSosoLocation != null) {
      try
      {
        paramJSONObject.put("longitude", localSosoLocation.mLon02);
        paramJSONObject.put("latitude", localSosoLocation.mLat02);
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "addLbsInfo e = ", localJSONException);
      }
    } else {
      b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySpEventReportUtil", 2, new Object[] { "json = ", paramJSONObject });
    }
  }
  
  private static void b()
  {
    if (d())
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(b);
      a = true;
      e();
    }
  }
  
  private static SosoLocation c()
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("readinjoy_anti_cheating");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      return localSosoLbsInfo.mLocation;
    }
    return null;
  }
  
  private static boolean d()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.b();
    if ((localObject != null) && (((QQAppInterface)localObject).isLogin()))
    {
      if (a)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, isRequestingLbs.");
        return false;
      }
      if (c() != null)
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, cache is valid, no need to request.");
        return false;
      }
      if (RIJAppSetting.f((QQAppInterface)localObject))
      {
        QLog.i("ReadInJoySpEventReportUtil", 1, "[isAbleToRequestLbs] NO, MUI and app in background.");
        return false;
      }
      localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && (((Context)localObject).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
      {
        QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, no location permission.");
        return false;
      }
      localObject = Aladdin.getConfig(165);
      if (localObject != null)
      {
        int i = ((AladdinConfig)localObject).getIntegerFromString("lbs_switch", 1);
        QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsSwitch = ", Integer.valueOf(i) });
        if (i != 1)
        {
          QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, switch is OFF, do not request.");
          return false;
        }
        i = ((AladdinConfig)localObject).getIntegerFromString("lbs_request_interval", 2);
        long l1 = ((Long)RIJSPUtils.b("readinjoy_sp_key_app_launch_time", Long.valueOf(System.currentTimeMillis()))).longValue();
        long l2 = (System.currentTimeMillis() - l1) / 1000L / 60L;
        QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "from app launch interval = ", Long.valueOf(l2), ", lbsRequestInterval = ", Integer.valueOf(i), ", appLaunchTime = ", Long.valueOf(l1) });
        if (l2 <= i)
        {
          QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, less than lbs request interval.");
          return false;
        }
        i = ((AladdinConfig)localObject).getIntegerFromString("lbs_day_limit", 1);
        int j = f();
        QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "lbsDayLimit = ", Integer.valueOf(i), ", todayRequestTime = ", Integer.valueOf(j) });
        if (j >= i)
        {
          QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, over lbs day limit.");
          return false;
        }
      }
      QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: YES !!!");
      return true;
    }
    QLog.d("ReadInJoySpEventReportUtil", 1, "isAbleToRequestLbs: NO, app is null or not login, do not request.");
    return false;
  }
  
  private static void e()
  {
    String str = g();
    Object localObject = (String)RIJSPUtils.b("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, today = ", str, ", lastRequestLbsDate = ", localObject });
    if (str.equals(localObject))
    {
      localObject = (Integer)RIJSPUtils.b("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0));
      QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "updateToadyRequestLbsTime, todayTime = ", localObject });
      RIJSPUtils.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(((Integer)localObject).intValue() + 1));
    }
    else
    {
      QLog.d("ReadInJoySpEventReportUtil", 1, "updateToadyRequestLbsTime, first time today.");
      RIJSPUtils.a("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(1));
    }
    RIJSPUtils.a("readinjoy_sp_key_last_request_lbs_date", str);
  }
  
  private static int f()
  {
    String str1 = g();
    String str2 = (String)RIJSPUtils.b("readinjoy_sp_key_last_request_lbs_date", "");
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "getToadyRequestLbsTime, today = ", str1, ", lastRequestLbsDate = ", str2 });
    if (str1.equals(str2)) {
      return ((Integer)RIJSPUtils.b("readinjoy_sp_key_toady_request_lbs_time", Integer.valueOf(0))).intValue();
    }
    return 0;
  }
  
  private static String g()
  {
    return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoySpEventReportUtil
 * JD-Core Version:    0.7.0.1
 */
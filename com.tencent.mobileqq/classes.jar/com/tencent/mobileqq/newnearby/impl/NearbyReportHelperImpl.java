package com.tencent.mobileqq.newnearby.impl;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.INearbyTabBuilder;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardReq;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyReportHelperImpl
  implements INearbyReportHelper
{
  private static final String TAG = "NearbyReportHelperImpl";
  
  public static void reportBeginLoadHippy(NearbyActivity paramNearbyActivity, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("opername", "now#nearby#discover");
        ((JSONObject)localObject).put("module", "hippy_page");
        ((JSONObject)localObject).put("action", "loadingstart");
        ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
        ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
        ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
        if (paramBoolean)
        {
          paramNearbyActivity = "1";
          ((JSONObject)localObject).put("d6", paramNearbyActivity);
          long l = System.currentTimeMillis() - NearbyActivity.enterNearbyTime;
          paramNearbyActivity = new StringBuilder();
          paramNearbyActivity.append("load hippy success, time cost: ");
          paramNearbyActivity.append(l);
          QLog.i("NearbyActivity-timecost", 1, paramNearbyActivity.toString());
          ((JSONObject)localObject).put("timelong", String.valueOf(l));
          ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
          return;
        }
      }
      catch (JSONException paramNearbyActivity)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportBeginLoadHippy JSONException:");
        ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
        QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
        return;
      }
      paramNearbyActivity = "0";
    }
  }
  
  public static void reportBeginLoadWebview(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#home");
      ((JSONObject)localObject).put("module", "h5_page");
      ((JSONObject)localObject).put("action", "loadingstart");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      long l = System.currentTimeMillis() - NearbyActivity.enterNearbyTime;
      paramNearbyActivity = new StringBuilder();
      paramNearbyActivity.append("load h5 success, time cost: ");
      paramNearbyActivity.append(l);
      QLog.i("NearbyActivity-timecost", 1, paramNearbyActivity.toString());
      ((JSONObject)localObject).put("timelong", String.valueOf(l));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportBeginLoadWebview JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void reportEnterNewNearbySuccess(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "view");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((JSONObject)localObject).put("timelong", String.valueOf(NearbyActivity.enterNearbyTimeCost));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEnterNewNearbySuccess JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void reportEnterOldNearbySuccess(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#home");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "view");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((JSONObject)localObject).put("timelong", String.valueOf(NearbyActivity.enterNearbyTimeCost));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEnterOldNearbySuccess JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void reportGroupTabClick(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "group_tab");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportGroupTabClick JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void reportHomeTabClick(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "discover_tab");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportHomeTabClick JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void reportLiveTabClick(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "live_tab");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportLiveTabClick JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void reportLoadHippyError(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "hippy_page");
      ((JSONObject)localObject).put("action", "loadingstart_fail");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportLoadHippyError JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void reportMatchTabClick(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "hongniang_tab");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportMatchTabClick JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void reportMsgTabClick(NearbyActivity paramNearbyActivity)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#discover");
      ((JSONObject)localObject).put("module", "news_tab");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramNearbyActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportMsgTabClick JSONException:");
      ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void reportRequestLocation(NearbyActivity paramNearbyActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#discover");
        localJSONObject.put("module", "lbs");
        localJSONObject.put("action", "get");
        localJSONObject.put("fromuin", paramNearbyActivity.app.getCurrentAccountUin());
        localJSONObject.put("appid", String.valueOf(paramNearbyActivity.app.getAppid()));
        localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
        localObject = "1";
        if (paramBoolean1) {
          paramNearbyActivity = "1";
        } else {
          paramNearbyActivity = "0";
        }
        localJSONObject.put("d5", paramNearbyActivity);
        if (paramBoolean2)
        {
          paramNearbyActivity = (NearbyActivity)localObject;
          localJSONObject.put("d6", paramNearbyActivity);
          ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
          return;
        }
      }
      catch (JSONException paramNearbyActivity)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportRequestLocation JSONException:");
        ((StringBuilder)localObject).append(paramNearbyActivity.getMessage());
        QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
        return;
      }
      paramNearbyActivity = "0";
    }
  }
  
  public static void reportTabClick(NearbyActivity paramNearbyActivity, int paramInt)
  {
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(0))
    {
      reportHomeTabClick(paramNearbyActivity);
      return;
    }
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(1))
    {
      reportLiveTabClick(paramNearbyActivity);
      return;
    }
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(2))
    {
      reportMatchTabClick(paramNearbyActivity);
      return;
    }
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(3))
    {
      reportGroupTabClick(paramNearbyActivity);
      return;
    }
    if (paramInt == ((INearbyTabBuilder)QRoute.api(INearbyTabBuilder.class)).getTabIdByTabType(4)) {
      reportMsgTabClick(paramNearbyActivity);
    }
  }
  
  public void reportEnterFakeNearby(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "enter");
      ((JSONObject)localObject).put("d6", "0");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEnterFakeNearby JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportEnterNewNearby(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "enter");
      ((JSONObject)localObject).put("d6", "2");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEnterNewNearby JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportEnterOldNearby(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "enter");
      ((JSONObject)localObject).put("d6", "1");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportEnterOldNearby JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportLiveTipListClick(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#news");
      ((JSONObject)localObject).put("module", "helper_column");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportLiveTipListClick JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportMomentListClick(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#news");
      ((JSONObject)localObject).put("module", "trend_column");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportMomentListClick JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportMsgListExp(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#news");
      ((JSONObject)localObject).put("module", "overall_page");
      ((JSONObject)localObject).put("action", "view");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportMsgListExp JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportMsgListItemClick(AppInterface paramAppInterface, String paramString)
  {
    NowSummaryCard.NearbyMiniCardReq localNearbyMiniCardReq = new NowSummaryCard.NearbyMiniCardReq();
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localNearbyMiniCardReq.target_id.set(localArrayList);
    localNearbyMiniCardReq.id_type.set(0);
    ProtoUtils.a(paramAppInterface, new NearbyReportHelperImpl.1(this, paramAppInterface, paramString), localNearbyMiniCardReq.toByteArray(), "NowSummaryCard.NearbyMiniCardReq");
  }
  
  public void reportMsgListItemExp(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#news");
      localJSONObject.put("module", "c2c_list");
      localJSONObject.put("action", "view");
      localJSONObject.put("d6", paramString1);
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString2);
      localJSONObject.put("appid", String.valueOf(paramAppInterface.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportMsgListItemExp JSONException:");
      paramString1.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString1.toString());
    }
  }
  
  public void reportNearbyAIOExp(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#news_c2c");
      localJSONObject.put("module", "overall_page");
      localJSONObject.put("action", "view");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString1);
      if (paramString2 == null) {
        localJSONObject.put("d1", "3");
      } else if (paramString2.equals("ProfileCard")) {
        localJSONObject.put("d1", "1");
      } else if (paramString2.equals("interestMatch")) {
        localJSONObject.put("d1", "2");
      }
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportNearbyAIOExp JSONException:");
      paramString1.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString1.toString());
    }
  }
  
  public void reportNearbyAIOSendMsg(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#news_c2c");
      localJSONObject.put("module", "c2c");
      localJSONObject.put("action", "send");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString1);
      localJSONObject.put("d6", paramString2);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportNearbyAIOSendMsg JSONException:");
      paramString1.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString1.toString());
    }
  }
  
  public void reportProfileInfoTabExp(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#datacard");
      localJSONObject.put("module", "profile_tab");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramString1);
      localJSONObject.put("touin", paramString2);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportProfileInfoTabExp JSONException:");
      paramString2.append(paramString1.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString2.toString());
    }
  }
  
  public void reportProfileTrendsTabExp(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#datacard");
      localJSONObject.put("module", "trend_tab");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramString1);
      localJSONObject.put("touin", paramString2);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("reportProfileTrendsTabExp JSONException:");
      paramString2.append(paramString1.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString2.toString());
    }
  }
  
  public void reportQQNearbyTabClick(AppInterface paramAppInterface)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("opername", "now#nearby#qqtrend");
      ((JSONObject)localObject).put("module", "nearby_column");
      ((JSONObject)localObject).put("action", "click");
      ((JSONObject)localObject).put("fromuin", paramAppInterface.getCurrentAccountUin());
      ((JSONObject)localObject).put("appid", String.valueOf(paramAppInterface.getAppid()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson((JSONObject)localObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportQQNearbyTabClick JSONException:");
      ((StringBuilder)localObject).append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void reportSayHelloMsgListItemClick(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#news");
      localJSONObject.put("module", "msg_column");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(paramAppInterface.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportSayHelloMsgListItemClick JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportSayHelloMsgListItemExp(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#news_msg");
      localJSONObject.put("module", "c2c_list");
      localJSONObject.put("action", "view");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(paramAppInterface.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportSayHelloMsgListItemExp JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportTrendDetailCommentClick(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#trenddetail");
      localJSONObject.put("module", "trenddetail_comment");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportTrendDetailCommentClick JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportTrendDetailExp(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#trenddetail");
      localJSONObject.put("module", "overall_page");
      localJSONObject.put("action", "view");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportTrendDetailExp JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportTrendDetailLikeClick(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#trenddetail");
      localJSONObject.put("module", "trenddetail_like");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportTrendDetailLikeClick JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportTrendDetailSafeReportClick(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#trenddetail");
      localJSONObject.put("module", "trenddetail_safereport");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportTrendDetailSafeReportClick JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
  
  public void reportTrendDetailShareClick(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#trenddetail");
      localJSONObject.put("module", "trenddetail_share");
      localJSONObject.put("action", "click");
      localJSONObject.put("fromuin", paramAppInterface.getCurrentAccountUin());
      localJSONObject.put("touin", paramString);
      localJSONObject.put("appid", String.valueOf(AppSetting.d()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException paramAppInterface)
    {
      paramString = new StringBuilder();
      paramString.append("reportTrendDetailShareClick JSONException:");
      paramString.append(paramAppInterface.getMessage());
      QLog.e("NearbyReportHelperImpl", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */
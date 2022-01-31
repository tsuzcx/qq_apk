package com.tencent.open.wadl;

import alri;
import alrj;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.wadl.GetGameCheckCode.GetGameCheckCodeReqBody;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlJsBridgeCall
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  protected final String a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  
  public WadlJsBridgeCall(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "WadlJsBridgeCall";
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, new Boolean(true));
    jdField_a_of_type_AndroidOsHandler.postDelayed(new alri(paramString), 2000L);
  }
  
  private void a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WadlJsBridgeDownloadInfo)paramList.next()).jdField_a_of_type_JavaLangString);
    }
    if (localArrayList.size() > 0) {
      WadlProxyServiceUtil.a().a(localArrayList);
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = (Boolean)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  private void b(WadlParams paramWadlParams)
  {
    WLog.a("WadlJsBridgeCall", 2, "dispatch wadlParams:" + paramWadlParams);
    switch (paramWadlParams.jdField_a_of_type_Int)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return;
    case 2: 
    case 12: 
      WadlProxyServiceUtil.a().a(paramWadlParams);
      a(paramWadlParams);
      return;
    case 3: 
    case 10: 
      WadlProxyServiceUtil.a().a(paramWadlParams.c, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    case 4: 
      WadlProxyServiceUtil.a().b(paramWadlParams.c, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    }
    WadlProxyServiceUtil.a().c(paramWadlParams);
  }
  
  public static void b(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, new Boolean(false));
  }
  
  private void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      WadlProxyServiceUtil.a().a(paramString);
    }
  }
  
  public int a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    WLog.b("WadlJsBridgeCall", "doDownloadAction params:" + paramString1 + ",fromWeb:" + paramBoolean + ",from:" + paramInt + ",weburl:" + paramString2);
    WadlParams localWadlParams = new WadlParams(paramString1);
    if (paramInt != 0)
    {
      localWadlParams.c = paramInt;
      localWadlParams.i = paramString2;
    }
    if ((paramInt == 1) || (paramInt == 2)) {
      localWadlParams.b(8);
    }
    paramString2 = localWadlParams.jdField_a_of_type_JavaLangString;
    paramInt = localWadlParams.jdField_a_of_type_Int;
    if (paramBoolean) {}
    try
    {
      if (localWadlParams.jdField_a_of_type_Boolean)
      {
        GameCenterUtils.c(paramString2, "DELAY_LIST");
        GameCenterUtils.a(paramString2, paramString1, "DELAY_APPID_DETAIL_");
        GameCenterBroadcastReceiver.a();
        return 0;
      }
      GameCenterUtils.b(paramString2, "DELAY_LIST");
      GameCenterUtils.d(paramString2, "DELAY_APPID_DETAIL_");
      if (a(paramString2))
      {
        WLog.b("WadlJsBridgeCall", "##@Operation for appid:" + paramString2 + " is not returned! The opertion of action: " + paramInt + " is ignored!");
        return 1;
      }
      a(paramString2);
      paramString1 = localWadlParams.jdField_b_of_type_JavaLangString;
      if ((TextUtils.isEmpty(paramString1)) || (!paramString1.endsWith(".apk")))
      {
        GameCenterUtils.a(null, "558", "202982", paramString2, "55801", "4", "430");
        WLog.b("WadlJsBridgeCall", "invalid url:" + localWadlParams);
        return -1;
      }
      b(localWadlParams);
      return 0;
    }
    catch (Exception paramString1)
    {
      WLog.a("WadlJsBridgeCall", "doDownloadAction:", paramString1);
    }
    return -1;
  }
  
  public void a()
  {
    WadlProxyServiceUtil.a().b();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    WadlProxyServiceUtil.a().c(paramInt, paramString1);
  }
  
  public void a(WadlParams paramWadlParams)
  {
    try
    {
      if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (!TextUtils.isEmpty(paramWadlParams.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramWadlParams.jdField_b_of_type_JavaLangString)))
      {
        Object localObject = paramWadlParams.jdField_a_of_type_JavaLangString;
        String str = String.valueOf(paramWadlParams.jdField_b_of_type_Int);
        WLog.b("WadlJsBridgeCall", "getWadlTaskSign start appId=" + (String)localObject + ",appVersion=" + str);
        GetGameCheckCode.GetGameCheckCodeReqBody localGetGameCheckCodeReqBody = new GetGameCheckCode.GetGameCheckCodeReqBody();
        localGetGameCheckCodeReqBody.appid.set((String)localObject);
        localGetGameCheckCodeReqBody.version.set(str);
        localGetGameCheckCodeReqBody.apk_url.set(paramWadlParams.jdField_b_of_type_JavaLangString);
        localObject = new NewIntent(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), WebSSOAgentServlet.class);
        ((NewIntent)localObject).putExtra("extra_cmd", "GameCenterProtoSvr.GetGameCheckCode");
        ((NewIntent)localObject).putExtra("extra_data", localGetGameCheckCodeReqBody.toByteArray());
        ((NewIntent)localObject).putExtra("extra_timeout", 5000L);
        ((NewIntent)localObject).setObserver(new alrj(this, paramWadlParams));
        this.jdField_a_of_type_MqqAppAppRuntime.startServlet((NewIntent)localObject);
        return;
      }
      WLog.a("WadlJsBridgeCall", "doDownload params error wadlParams:" + paramWadlParams.toString());
      return;
    }
    catch (Exception paramWadlParams)
    {
      WLog.a("WadlJsBridgeCall", "getWadlTaskSign exception:" + paramWadlParams.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString1.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.h = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.i = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.c = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.jdField_b_of_type_Int = localJSONObject.optInt("versionCode");
        paramString2.add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      WLog.a("WadlJsBridgeCall", "getQueryDownloadAction(String,String)>>>", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    WLog.b("WadlJsBridgeCall", "startDownload delay task" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (1 == paramInt) {
      a(paramString, false, 1, "YUYUE");
    }
    while (2 != paramInt) {
      return;
    }
    a(paramString, false, 2, "YANCHI");
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.h = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.i = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.c = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.jdField_b_of_type_Int = localJSONObject.optInt("versionCode");
        ((List)localObject).add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      a((List)localObject);
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridgeCall", "query getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("via");
      paramString.getString("guid");
      e(str);
      return;
    }
    catch (Exception paramString)
    {
      WLog.a("WadlJsBridgeCall", "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJsBridgeCall
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchMakerPlugin
  extends WebViewPlugin
{
  private static NearbyRedNum jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum;
  private static boolean jdField_a_of_type_Boolean = false;
  
  private NearbyProcManager a()
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof NearbyAppInterface)) {
      localObject = null;
    }
    NearbyProcManager localNearbyProcManager;
    do
    {
      return localObject;
      localNearbyProcManager = ((NearbyAppInterface)localObject).a();
      localObject = localNearbyProcManager;
    } while (localNearbyProcManager.a());
    return null;
  }
  
  private NearbyRedNum a()
  {
    NearbyProcManager localNearbyProcManager = a();
    if (localNearbyProcManager == null) {
      return null;
    }
    return localNearbyProcManager.b();
  }
  
  private String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", 0);
      if (jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum == null) {
        jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = a();
      }
      if ((jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum == null) || (TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum.a)))
      {
        localJSONObject.put("data", new JSONObject());
        return localJSONObject.toString();
      }
      localJSONObject.put("data", new JSONObject(jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum.a));
      jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = null;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("XiangQinPlugin", 2, "NearbyRedNum json parse err " + localJSONException.getMessage());
        }
      }
    }
    return localJSONObject.toString();
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = null;
  }
  
  public static void a(NearbyRedNum paramNearbyRedNum)
  {
    if ("setNearbyRedNum: nearbyRedNum  " + paramNearbyRedNum == null) {}
    for (String str = "is null";; str = "")
    {
      QLog.d("XiangQinPlugin", 2, str);
      jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = paramNearbyRedNum;
      return;
    }
  }
  
  private void a(String paramString)
  {
    String str = a();
    QLog.i("XiangQinPlugin", 2, "callback, json=" + str);
    new ODReportTask().b("nearby_hongniang").c("jsbridge_callback").i(str).a();
    callJs(paramString, new String[] { str });
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ("refresh".equals(paramString1)) {
      a(paramString2);
    }
    return true;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = true;
    QLog.d("XiangQinPlugin", 2, "handleJsRequest url " + paramString1 + " pkgName=" + paramString2 + " method=" + paramString3);
    jdField_a_of_type_Boolean = true;
    if (!"nearbyXiangqin".equals(paramString2)) {
      bool = false;
    }
    do
    {
      return bool;
      paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    } while (paramString2 == null);
    if (QLog.isColorLevel()) {
      QLog.d("XiangQinPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
      }
      else
      {
        int i = paramString1.indexOf("#");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          break label221;
        }
        paramJsBridgeListener = paramString1.substring(i + 1);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.i("XiangQinPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
      }
      paramJsBridgeListener = null;
    }
    while (paramJsBridgeListener != null) {
      return a(paramString3, paramJsBridgeListener);
    }
    return false;
    label221:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.MatchMakerPlugin
 * JD-Core Version:    0.7.0.1
 */
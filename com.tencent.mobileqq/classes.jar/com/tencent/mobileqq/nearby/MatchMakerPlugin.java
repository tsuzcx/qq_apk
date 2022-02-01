package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  private INearbyProcManager a()
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof INearbyAppInterface)) {
      return null;
    }
    localObject = ((INearbyAppInterface)localObject).getNearbyProcManager();
    if (((INearbyProcManager)localObject).a()) {
      return localObject;
    }
    return null;
  }
  
  private NearbyRedNum a()
  {
    INearbyProcManager localINearbyProcManager = a();
    if (localINearbyProcManager == null) {
      return null;
    }
    return localINearbyProcManager.b();
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
      Object localObject = jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum;
      if ((localObject != null) && (!TextUtils.isEmpty(jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum.a)))
      {
        localJSONObject.put("data", new JSONObject(jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum.a));
        jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = null;
      }
      else
      {
        localJSONObject.put("data", new JSONObject());
        localObject = localJSONObject.toString();
        return localObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NearbyRedNum json parse err ");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.e("XiangQinPlugin", 2, localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setNearbyRedNum: nearbyRedNum  ");
    ((StringBuilder)localObject).append(paramNearbyRedNum);
    if (((StringBuilder)localObject).toString() == null) {
      localObject = "is null";
    } else {
      localObject = "";
    }
    QLog.d("XiangQinPlugin", 2, (String)localObject);
    jdField_a_of_type_ComTencentMobileqqNearbyRedtouchNearbyRedNum = paramNearbyRedNum;
  }
  
  private void a(String paramString)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callback, json=");
    localStringBuilder.append(str);
    QLog.i("XiangQinPlugin", 2, localStringBuilder.toString());
    ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("jsbridge_callback").setRes1(str).report();
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("handleJsRequest url ");
    paramJsBridgeListener.append(paramString1);
    paramJsBridgeListener.append(" pkgName=");
    paramJsBridgeListener.append(paramString2);
    paramJsBridgeListener.append(" method=");
    paramJsBridgeListener.append(paramString3);
    QLog.d("XiangQinPlugin", 2, paramJsBridgeListener.toString());
    jdField_a_of_type_Boolean = true;
    if (!"nearbyXiangqin".equals(paramString2)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest JSON = ");
      paramJsBridgeListener.append(paramString2.toString());
      QLog.d("XiangQinPlugin", 2, paramJsBridgeListener.toString());
    }
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
        break label227;
      }
      int i = paramString1.indexOf("#");
      if (i != -1)
      {
        i += 1;
        if (i > paramString1.length() - 1) {
          return false;
        }
        paramJsBridgeListener = paramString1.substring(i);
        break label227;
      }
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      label188:
      label227:
      break label188;
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("Failed to parse callbackid,json=");
      paramJsBridgeListener.append(paramString2);
      QLog.i("XiangQinPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = null;
    if (paramJsBridgeListener == null) {
      return false;
    }
    return a(paramString3, paramJsBridgeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.MatchMakerPlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoCgiService
  implements BusinessObserver
{
  private static volatile WebSoCgiService jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, WebSoCgiService.WebSoCgiState> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private WebSoCgiService.WebSoCgiState a(String paramString)
  {
    WebSoCgiService.WebSoCgiState localWebSoCgiState = new WebSoCgiService.WebSoCgiState();
    localWebSoCgiState.jdField_a_of_type_JavaLangString = paramString;
    localWebSoCgiState.jdField_a_of_type_Int = 4;
    localWebSoCgiState.jdField_c_of_type_Int = 10006;
    return localWebSoCgiState;
  }
  
  public static WebSoCgiService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {
          jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService = new WebSoCgiService();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService;
  }
  
  private void a(Handler paramHandler, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = paramWebSoCgiState;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    if ((paramWebSoCgiState != null) && (paramWebSoCgiState.jdField_a_of_type_AndroidOsHandler != null))
    {
      Handler localHandler = paramWebSoCgiState.jdField_a_of_type_AndroidOsHandler;
      if (localHandler == null) {
        return;
      }
      a(localHandler, paramWebSoCgiState);
      HybridWebReporter.a().a(paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo);
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("key_uni_key");
    Object localObject = paramBundle.getString("url");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (TextUtils.isEmpty(str)) {
        return;
      }
      WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localWebSoCgiState == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get webso state fail, unikey=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",map size=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        QLog.e("WebSoCgiService", 1, ((StringBuilder)localObject).toString());
        a(paramBoolean, paramBundle, a(str));
        return;
      }
      localWebSoCgiState.jdField_a_of_type_Int = 2;
      localWebSoCgiState.jdField_c_of_type_Int = 0;
      a(paramBoolean, paramBundle, localWebSoCgiState);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      paramBundle = new StringBuilder();
      paramBundle.append("onGetHttpData success(");
      paramBundle.append(paramBoolean);
      paramBundle.append("), url:");
      paramBundle.append((String)localObject);
      paramBundle.append(" ,map size=");
      paramBundle.append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      QLog.i("WebSoCgiService", 1, paramBundle.toString());
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    if (paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo == null)
    {
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramWebSoCgiState.jdField_b_of_type_JavaLangString;
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    }
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.e = paramBundle.getString("key_user_ip");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.h = paramBundle.getString("key_dns_result");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.g = paramBundle.getString("key_server_port");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 0;
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_Int = 1;
      paramWebSoCgiState.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      paramWebSoCgiState.jdField_f_of_type_JavaLangString = paramBundle.getString("rsp_message");
      a(paramWebSoCgiState);
      paramBundle = new StringBuilder();
      paramBundle.append("state=");
      paramBundle.append(paramWebSoCgiState);
      QLog.w("WebSoCgiService", 1, paramBundle.toString());
      return;
    }
    paramBundle = (HttpRsp)paramBundle.getSerializable("rsp_data");
    if (paramBundle == null)
    {
      paramWebSoCgiState.jdField_c_of_type_Int = 10002;
      paramWebSoCgiState.jdField_f_of_type_JavaLangString = "rsp is null";
      a(paramWebSoCgiState);
      paramBundle = new StringBuilder();
      paramBundle.append("state=");
      paramBundle.append(paramWebSoCgiState);
      QLog.w("WebSoCgiService", 1, paramBundle.toString());
      return;
    }
    if (!a(paramWebSoCgiState, new HttpResponsePackage(paramBundle), paramBundle.rspinfo)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramWebSoCgiState.jdField_a_of_type_Long;
    paramBundle = new StringBuilder();
    paramBundle.append("wnscgi@ before send rsp msg,total cost ");
    paramBundle.append(l1 - l2);
    paramBundle.append(" ms");
    QLog.i("WebSoCgiService", 1, paramBundle.toString());
    a(paramWebSoCgiState);
  }
  
  private boolean a(WebSoCgiService.WebSoCgiState paramWebSoCgiState, HttpResponsePackage paramHttpResponsePackage, String paramString)
  {
    int i = paramString.indexOf("\r\n\r\n");
    paramHttpResponsePackage = paramHttpResponsePackage.d;
    if (i < 1) {
      return false;
    }
    paramString = paramString.substring(0, i - 1).split("\r\n");
    int j = paramString.length;
    if (j >= 1)
    {
      String[] arrayOfString1 = paramString[0].split(" ");
      if (arrayOfString1.length >= 2) {
        try
        {
          paramWebSoCgiState.jdField_b_of_type_Int = Integer.valueOf(arrayOfString1[1].trim()).intValue();
          paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.d = arrayOfString1[1].trim();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      JSONObject localJSONObject = new JSONObject();
      i = 1;
      while (i < j)
      {
        String[] arrayOfString2 = paramString[i].split(":");
        if (arrayOfString2.length > 1) {
          try
          {
            localJSONObject.put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        i += 1;
      }
      paramWebSoCgiState.jdField_c_of_type_JavaLangString = localJSONObject.toString();
    }
    paramWebSoCgiState.jdField_c_of_type_Int = 0;
    paramWebSoCgiState.d = paramHttpResponsePackage;
    return true;
  }
  
  public boolean a(WebSoCgiService.CgiReqInfo paramCgiReqInfo, Handler paramHandler)
  {
    return a(paramCgiReqInfo, paramHandler, VasUtil.a().websoGetCookie4WebSoOrSonic(paramCgiReqInfo.jdField_a_of_type_JavaLangString));
  }
  
  public boolean a(WebSoCgiService.CgiReqInfo paramCgiReqInfo, Handler paramHandler, String paramString)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((paramCgiReqInfo != null) && (!TextUtils.isEmpty(paramCgiReqInfo.jdField_a_of_type_JavaLangString)))
    {
      if (!NetworkUtil.isNetworkAvailable(localAppRuntime.getApplicationContext()))
      {
        paramHandler = new StringBuilder();
        paramHandler.append("startCgiRequest isNetworkAvailable false ,cgiInfo=");
        paramHandler.append(paramCgiReqInfo);
        QLog.w("WebSoCgiService", 2, paramHandler.toString());
        return false;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.valueOf(Math.random()));
      ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wnscgi@ startCgiRequest running cgiInfo=");
      ((StringBuilder)localObject2).append(paramCgiReqInfo);
      ((StringBuilder)localObject2).append(",uniKey=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("WebSoCgiService", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new WebSoCgiService.WebSoCgiState();
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_b_of_type_JavaLangString = paramCgiReqInfo.jdField_a_of_type_JavaLangString;
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_Boolean = paramCgiReqInfo.jdField_a_of_type_Boolean;
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_Int = 1;
      ((WebSoCgiService.WebSoCgiState)localObject2).e = paramCgiReqInfo.jdField_f_of_type_JavaLangString;
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_JavaLangObject = paramCgiReqInfo.jdField_a_of_type_JavaLangObject;
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramCgiReqInfo.jdField_a_of_type_JavaLangString;
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
      long l1 = WebSoUtils.a();
      String str = VasUtil.a().websoGetQUA();
      Object localObject3 = WebSoUtils.a();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("method", paramCgiReqInfo.jdField_b_of_type_JavaLangString.toUpperCase());
        localJSONObject.put("entity_body", paramCgiReqInfo.d);
        localJSONObject.put("if_None_Match", "");
        localJSONObject.put("content_type", paramCgiReqInfo.e);
        localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString);
        if (paramCgiReqInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
        {
          if (!TextUtils.isEmpty(paramCgiReqInfo.d)) {
            if (paramCgiReqInfo.jdField_a_of_type_JavaLangString.contains("?"))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramCgiReqInfo.jdField_a_of_type_JavaLangString);
              localStringBuilder.append("&");
              localStringBuilder.append(paramCgiReqInfo.d);
              localJSONObject.put("uri", localStringBuilder.toString());
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramCgiReqInfo.jdField_a_of_type_JavaLangString);
              localStringBuilder.append("?");
              localStringBuilder.append(paramCgiReqInfo.d);
              localJSONObject.put("uri", localStringBuilder.toString());
            }
          }
        }
        else if (!TextUtils.isEmpty(paramCgiReqInfo.d)) {
          localJSONObject.put("content_length", paramCgiReqInfo.d.length());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("; qua=");
        localStringBuilder.append(str);
        localStringBuilder.append("; ");
        localJSONObject.put("cookie", localStringBuilder.toString());
        localJSONObject.put("no_Chunked", "true");
        localJSONObject.put("accept_Encoding", "identity");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      paramString = new HttpRequestPackage((String)localObject3, localJSONObject);
      paramString.addHeader(paramCgiReqInfo.jdField_c_of_type_JavaLangString);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("e");
      ((StringBuilder)localObject3).append(paramString.method);
      paramString = new HttpReq(EnumHttpMethod.convert(((StringBuilder)localObject3).toString()).value(), paramString.getHeaderString(), paramString.getBodyString(), paramString.host);
      ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_AndroidOsHandler = paramHandler;
      paramHandler = new NewIntent(localAppRuntime.getApplicationContext(), WebSoServlet.class);
      WebSoServlet.a(paramHandler, l1, paramCgiReqInfo.jdField_a_of_type_JavaLangString, paramString, "", paramCgiReqInfo.jdField_a_of_type_Int, 1101, (String)localObject1, WebSoCgiService.class);
      if (!this.jdField_a_of_type_Boolean)
      {
        localAppRuntime.registObserver(this);
        this.jdField_a_of_type_Boolean = true;
      }
      localAppRuntime.startServlet(paramHandler);
      l1 = System.currentTimeMillis();
      long l2 = ((WebSoCgiService.WebSoCgiState)localObject2).jdField_a_of_type_Long;
      paramCgiReqInfo = new StringBuilder();
      paramCgiReqInfo.append("wnscgi@ after start servlet,total cost ");
      paramCgiReqInfo.append(l1 - l2);
      paramCgiReqInfo.append(" ms");
      QLog.i("WebSoCgiService", 1, paramCgiReqInfo.toString());
      return true;
    }
    paramHandler = new StringBuilder();
    paramHandler.append("startCgiRequest param invalid, cgiInfo=");
    paramHandler.append(paramCgiReqInfo);
    QLog.w("WebSoCgiService", 2, paramHandler.toString());
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1101) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
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
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
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
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService = new WebSoCgiService();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService;
    }
  }
  
  private void a(Handler paramHandler, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = paramWebSoCgiState;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    Handler localHandler;
    if ((paramWebSoCgiState != null) && (paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localHandler = (Handler)paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramWebSoCgiState);
    HybridWebReporter.a().a(paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("key_uni_key");
    String str2 = paramBundle.getString("url");
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if (localWebSoCgiState == null)
    {
      QLog.e("WebSoCgiService", 1, "get webso state fail, unikey=" + str1 + ",map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      a(paramBoolean, paramBundle, a(str1));
      return;
    }
    localWebSoCgiState.jdField_a_of_type_Int = 2;
    localWebSoCgiState.jdField_c_of_type_Int = 0;
    a(paramBoolean, paramBundle, localWebSoCgiState);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str1);
    QLog.i("WebSoCgiService", 1, "onGetHttpData success(" + paramBoolean + "), url:" + str2 + " ,map size=" + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    if (paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo == null)
    {
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramWebSoCgiState.jdField_b_of_type_JavaLangString;
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 1;
    }
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("key_user_ip");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.h = paramBundle.getString("key_dns_result");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.f = paramBundle.getString("key_server_ip");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.g = paramBundle.getString("key_server_port");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 0;
    paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.i = paramBundle.getString("key_detail_info");
    if (!paramBoolean)
    {
      paramWebSoCgiState.jdField_c_of_type_Int = paramBundle.getInt("rsp_code", 10002);
      paramWebSoCgiState.f = paramBundle.getString("rsp_message");
      a(paramWebSoCgiState);
      QLog.w("WebSoCgiService", 1, "state=" + paramWebSoCgiState);
      return;
    }
    Object localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    paramBundle = null;
    if (localObject1 != null) {
      paramBundle = new HttpResponsePackage((HttpRsp)localObject1);
    }
    if (localObject1 == null)
    {
      paramWebSoCgiState.jdField_c_of_type_Int = 10002;
      paramWebSoCgiState.f = "rsp is null";
      a(paramWebSoCgiState);
      QLog.w("WebSoCgiService", 1, "state=" + paramWebSoCgiState);
      return;
    }
    localObject1 = ((HttpRsp)localObject1).rspinfo;
    int i = ((String)localObject1).indexOf("\r\n\r\n");
    paramBundle = paramBundle.d;
    String[] arrayOfString1 = ((String)localObject1).substring(0, i - 1).split("\r\n");
    int j = arrayOfString1.length;
    if (j >= 1)
    {
      Object localObject2 = arrayOfString1[0].split(" ");
      if (localObject2.length >= 2) {}
      try
      {
        paramWebSoCgiState.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        paramWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.d = localObject2[1].trim();
        localObject2 = new JSONObject();
        i = 1;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split(":");
          if (arrayOfString2.length <= 1) {}
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            String[] arrayOfString2;
            ((JSONObject)localObject2).put(arrayOfString2[0].trim(), arrayOfString2[1].trim());
            i += 1;
          }
          localException = localException;
          localException.printStackTrace();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        paramWebSoCgiState.jdField_c_of_type_JavaLangString = localException.toString();
      }
    }
    paramWebSoCgiState.jdField_c_of_type_Int = 0;
    paramWebSoCgiState.d = paramBundle;
    long l1 = System.currentTimeMillis();
    long l2 = paramWebSoCgiState.jdField_a_of_type_Long;
    QLog.i("WebSoCgiService", 1, "wnscgi@ before send rsp msg,total cost " + (l1 - l2) + " ms");
    a(paramWebSoCgiState);
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.w("WebSoCgiService", 1, "html body empty, rspinfo is: " + (String)localObject1);
      return;
    }
    QLog.i("WebSoCgiService", 1, "succ htmlBody len=" + paramBundle.length());
  }
  
  public boolean a(WebSoCgiService.CgiReqInfo paramCgiReqInfo, Handler paramHandler)
  {
    if ((paramCgiReqInfo == null) || (TextUtils.isEmpty(paramCgiReqInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest param invalid, cgiInfo=" + paramCgiReqInfo);
      return false;
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      QLog.w("WebSoCgiService", 2, "startCgiRequest isNetworkAvailable false ,cgiInfo=" + paramCgiReqInfo);
      return false;
    }
    String str1 = String.valueOf(Math.random()) + String.valueOf(System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("WebSoCgiService", 2, "wnscgi@ startCgiRequest running cgiInfo=" + paramCgiReqInfo + ",uniKey=" + str1);
    }
    WebSoCgiService.WebSoCgiState localWebSoCgiState = new WebSoCgiService.WebSoCgiState();
    localWebSoCgiState.jdField_a_of_type_JavaLangString = str1;
    localWebSoCgiState.jdField_b_of_type_JavaLangString = paramCgiReqInfo.jdField_a_of_type_JavaLangString;
    localWebSoCgiState.jdField_a_of_type_Boolean = paramCgiReqInfo.jdField_a_of_type_Boolean;
    localWebSoCgiState.jdField_a_of_type_Int = 1;
    localWebSoCgiState.jdField_e_of_type_JavaLangString = paramCgiReqInfo.f;
    localWebSoCgiState.jdField_a_of_type_JavaLangObject = paramCgiReqInfo.jdField_a_of_type_JavaLangObject;
    localWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
    localWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramCgiReqInfo.jdField_a_of_type_JavaLangString;
    localWebSoCgiState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localWebSoCgiState);
    long l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str2 = QUA.a();
    Object localObject = WebSoUtils.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", paramCgiReqInfo.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", paramCgiReqInfo.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("accept_diff", "false");
      localJSONObject.put("content_type", paramCgiReqInfo.jdField_e_of_type_JavaLangString);
      localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString);
      if (paramCgiReqInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(paramCgiReqInfo.d))
        {
          if (!paramCgiReqInfo.jdField_a_of_type_JavaLangString.contains("?")) {
            break label738;
          }
          localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString + "&" + paramCgiReqInfo.d);
        }
        for (;;)
        {
          String str3 = SwiftBrowserCookieMonster.c(paramCgiReqInfo.jdField_a_of_type_JavaLangString);
          localJSONObject.put("cookie", str3 + "; qua=" + str2 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          localObject = new HttpRequestPackage((String)localObject, localJSONObject);
          ((HttpRequestPackage)localObject).addHeader(paramCgiReqInfo.jdField_c_of_type_JavaLangString);
          localObject = new HttpReq(EnumHttpMethod.convert("e" + ((HttpRequestPackage)localObject).method).value(), ((HttpRequestPackage)localObject).getHeaderString(), ((HttpRequestPackage)localObject).getBodyString(), ((HttpRequestPackage)localObject).host);
          localWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l1, paramCgiReqInfo.jdField_a_of_type_JavaLangString, (HttpReq)localObject, "", paramCgiReqInfo.jdField_a_of_type_Int, 1101, str1, WebSoCgiService.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          l1 = System.currentTimeMillis();
          long l2 = localWebSoCgiState.jdField_a_of_type_Long;
          QLog.i("WebSoCgiService", 1, "wnscgi@ after start servlet,total cost " + (l1 - l2) + " ms");
          return true;
          label738:
          localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString + "?" + paramCgiReqInfo.d);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(paramCgiReqInfo.d)) {
          localJSONObject.put("content_length", paramCgiReqInfo.d.length());
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1101) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoCgiService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.webso;

import akre;
import akrf;
import akrg;
import akrh;
import akri;
import akrj;
import akrk;
import akrl;
import akrm;
import akrn;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoService
  implements BusinessObserver
{
  private static volatile WebSoService jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new akre(this, 10);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static WebSoService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService = new WebSoService();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService;
    }
  }
  
  private String a(JSONObject paramJSONObject, WebSoService.WebSoState paramWebSoState)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSoService", 2, "updateHtml");
    }
    if ((paramWebSoState == null) || (paramWebSoState.jdField_c_of_type_JavaLangString == null) || (paramJSONObject == null))
    {
      if ((paramWebSoState != null) && (paramWebSoState.jdField_c_of_type_JavaLangString == null)) {
        QLog.w("WebSoService", 1, "template body is null!!!!");
      }
      if (paramJSONObject == null) {
        QLog.w("WebSoService", 1, "allJson is null, how possible!");
      }
      paramWebSoState = "";
    }
    String str;
    JSONObject localJSONObject;
    do
    {
      do
      {
        do
        {
          return paramWebSoState;
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "updateHtml data");
          }
          str = EncodingUtils.getString(paramWebSoState.jdField_c_of_type_JavaLangString.getBytes(), "UTF-8");
          paramWebSoState = str;
        } while (TextUtils.isEmpty(str));
        paramWebSoState = str;
      } while (!paramJSONObject.has("data"));
      localJSONObject = paramJSONObject.optJSONObject("data");
      paramWebSoState = str;
    } while (localJSONObject == null);
    Iterator localIterator = localJSONObject.keys();
    for (paramJSONObject = str;; paramJSONObject = paramJSONObject.replace(paramWebSoState, localJSONObject.optString(paramWebSoState)))
    {
      paramWebSoState = paramJSONObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramWebSoState = localIterator.next().toString();
    }
  }
  
  private void a(Uri paramUri, WebSoService.WebSoState paramWebSoState, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    if (paramWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) {}
    Object localObject;
    for (;;)
    {
      return;
      try
      {
        long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
        localObject = WebSoUtils.a(paramUri);
        if (!b().getString("templateTag_" + String.valueOf(l) + (String)localObject, "").equals(paramJSONObject.optString("template-tag")))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("WebSoService", 2, "template has changed, so it can't use local refresh!");
        }
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        paramWebSoState.jdField_e_of_type_JavaLangString = "";
        return;
      }
    }
    paramUri = FileUtils.b(new File(WebSoUtils.d(paramUri) + "_data.txt"));
    if (!TextUtils.isEmpty(paramUri)) {}
    for (paramUri = new JSONObject(paramUri);; paramUri = null)
    {
      if (paramJSONObject.has("data")) {
        localJSONObject = paramJSONObject.optJSONObject("data");
      }
      paramJSONObject = new JSONObject();
      if ((localJSONObject != null) && (paramUri != null))
      {
        localObject = localJSONObject.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = ((Iterator)localObject).next().toString();
          String str2 = localJSONObject.optString(str1);
          if (QLog.isColorLevel()) {
            QLog.i("WebSoService", 2, "local check key: " + str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            if (!paramUri.has(str1))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
            else if (!str2.equalsIgnoreCase(paramUri.optString(str1, "")))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoService", 2, "local refresh key: " + str1);
              }
              paramJSONObject.put(str1, str2);
            }
          }
        }
      }
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject.put("local_refresh_time", System.currentTimeMillis());
        paramWebSoState.jdField_e_of_type_JavaLangString = paramJSONObject.toString();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WebSoService", 2, "no local refresh data.");
      }
      paramWebSoState.jdField_e_of_type_JavaLangString = "";
      return;
    }
  }
  
  private void a(Uri paramUri, String paramString, File paramFile, WebSoService.WebSoState paramWebSoState, WebSoService.CallBack paramCallBack)
  {
    ThreadManager.getFileThreadHandler().post(new akrh(this, paramFile, paramString, paramCallBack, paramUri));
  }
  
  private void a(Handler paramHandler, WebSoService.WebSoState paramWebSoState)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_rsp_succeed", paramWebSoState.jdField_d_of_type_Boolean);
    localBundle.putString("url", paramWebSoState.jdField_a_of_type_JavaLangString);
    localBundle.putBoolean("need_force_refresh", paramWebSoState.jdField_a_of_type_Boolean);
    localBundle.putBoolean("need_local_refresh", paramWebSoState.g);
    localBundle.putString("key_html_changed_data", paramWebSoState.jdField_e_of_type_JavaLangString);
    localBundle.putBoolean("key_wns_cache_hit", paramWebSoState.jdField_c_of_type_Boolean);
    if ((paramWebSoState.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)))
    {
      paramWebSoState.jdField_b_of_type_JavaLangString = WebSoUtils.c(paramWebSoState.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)) {
        paramWebSoState.f = true;
      }
    }
    localBundle.putBoolean("is_local_data", paramWebSoState.f);
    localBundle.putString("wns_proxy_http_data", paramWebSoState.jdField_b_of_type_JavaLangString);
    localBundle.putInt("result_code", paramWebSoState.jdField_a_of_type_Int);
    localBundle.putString("error_message", paramWebSoState.jdField_d_of_type_JavaLangString);
    localBundle.putInt("req_state", paramWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    localBundle.putBoolean("is_silent_mode", paramWebSoState.jdField_e_of_type_Boolean);
    paramWebSoState = paramHandler.obtainMessage(203);
    paramWebSoState.obj = localBundle;
    paramHandler.sendMessage(paramWebSoState);
  }
  
  private void a(HttpResponsePackage paramHttpResponsePackage, String paramString, Uri paramUri, WebSoService.WebSoState paramWebSoState)
  {
    ThreadManager.getFileThreadHandler().post(new akrf(this, paramHttpResponsePackage, paramUri, paramString, paramWebSoState));
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.CallBack paramCallBack)
  {
    ThreadManager.getFileThreadHandler().post(new akrn(this, paramString1, paramString2, paramString3, paramUri, paramWebSoState, paramBoolean, paramCallBack));
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(str));
    localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    localWebSoState.jdField_a_of_type_Int = 0;
    HttpRsp localHttpRsp = (HttpRsp)paramBundle.getSerializable("rsp_data");
    Bundle localBundle = new Bundle();
    if ((localHttpRsp == null) || (!paramBoolean)) {
      localBundle.putBoolean("key_rsp_succeed", false);
    }
    for (;;)
    {
      a(paramBoolean, paramBundle, localWebSoState);
      QLog.i("WebSoService", 1, "onGetHttpData succed(" + paramBoolean + "), url:" + Util.c(str, new String[0]));
      return;
      localBundle.putBoolean("key_rsp_succeed", true);
      localBundle.putString("url", paramBundle.getString("url"));
    }
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, WebSoService.WebSoState paramWebSoState)
  {
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo == null)
    {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramWebSoState.jdField_a_of_type_JavaLangString;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 1;
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("key_user_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.h = paramBundle.getString("key_dns_result");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.f = paramBundle.getString("key_server_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.g = paramBundle.getString("key_server_port");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.b = paramBundle.getInt("rsp_code");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 2;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.i = paramBundle.getString("key_detail_info");
    paramWebSoState.jdField_e_of_type_Boolean = false;
    if (!paramBoolean)
    {
      paramWebSoState.jdField_a_of_type_Int = 10001;
      if (!TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)) {
        paramWebSoState.jdField_c_of_type_Boolean = true;
      }
      a(paramWebSoState);
      return;
    }
    Object localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    if (localObject1 != null) {}
    for (HttpResponsePackage localHttpResponsePackage = new HttpResponsePackage((HttpRsp)localObject1);; localHttpResponsePackage = null)
    {
      if (localObject1 == null)
      {
        paramWebSoState.jdField_a_of_type_Int = 10002;
        paramWebSoState.jdField_d_of_type_JavaLangString = "rsp is null";
        a(paramWebSoState);
        return;
      }
      localObject1 = ((HttpRsp)localObject1).rspinfo;
      int i = ((String)localObject1).indexOf("\r\n\r\n");
      String str2 = localHttpResponsePackage.jdField_d_of_type_JavaLangString;
      String[] arrayOfString = ((String)localObject1).substring(0, i - 1).split("\r\n");
      Uri localUri = Uri.parse(paramBundle.getString("url"));
      localObject1 = arrayOfString[0].split(" ");
      if (localObject1.length >= 2) {}
      try
      {
        paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_JavaLangString = localObject1[1].trim();
        if (arrayOfString[0].contains("304"))
        {
          QLog.i("WebSoService", 1, "now 304,so return! ");
          paramWebSoState.jdField_c_of_type_Boolean = true;
          paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
          a(paramWebSoState);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebSoState.jdField_c_of_type_Boolean = false;
        Object localObject2 = null;
        String str1 = null;
        int j = arrayOfString.length;
        Object localObject3 = null;
        i = 0;
        Object localObject4;
        if (i < j)
        {
          String str3 = arrayOfString[i].toLowerCase();
          Object localObject5;
          if (str3.contains("cache-offline"))
          {
            localObject4 = str3.split(":")[1].trim();
            localObject5 = localObject2;
          }
          for (;;)
          {
            i += 1;
            localObject3 = localObject4;
            localObject2 = localObject5;
            break;
            if (str3.contains("etag"))
            {
              localObject5 = str3.split(":")[1].trim();
              localObject4 = localObject3;
            }
            else
            {
              localObject4 = localObject3;
              localObject5 = localObject2;
              if (str3.contains("template-tag"))
              {
                str1 = str3.split(":")[1].trim();
                localObject4 = localObject3;
                localObject5 = localObject2;
              }
            }
          }
        }
        if ("http".equals(localObject3))
        {
          QLog.i("WebSoService", 1, "now 503, so start reLoadUrl");
          paramWebSoState.jdField_a_of_type_Int = 10503;
          paramWebSoState.jdField_c_of_type_Boolean = false;
          paramWebSoState.jdField_a_of_type_Boolean = true;
          WebSoUtils.b(localUri);
          a(paramWebSoState);
          return;
        }
        if ("true".equals(localObject3))
        {
          if (TextUtils.isEmpty(str1))
          {
            if (QLog.isDebugVersion()) {
              QLog.i("WebSoService", 1, "webso etag=" + localObject2 + ",url=" + paramBundle.getString("url"));
            }
            a(localHttpResponsePackage, localObject2, localUri, paramWebSoState);
            paramWebSoState.jdField_b_of_type_JavaLangString = str2;
            paramWebSoState.jdField_a_of_type_Boolean = true;
            paramWebSoState.f = false;
            a(paramWebSoState);
            return;
          }
          a(str2, localObject2, str1, localUri, paramWebSoState, true, new akrj(this, paramWebSoState, System.currentTimeMillis()));
          return;
        }
        if ("store".equals(localObject3))
        {
          if (a(paramWebSoState.jdField_a_of_type_JavaLangString))
          {
            paramWebSoState.jdField_e_of_type_Boolean = true;
            paramWebSoState.jdField_a_of_type_Boolean = false;
            paramWebSoState.f = false;
          }
          try
          {
            paramBundle = new JSONObject(str2).optJSONObject("data");
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("code", 1);
            ((JSONObject)localObject4).put("data", paramBundle);
            ((JSONObject)localObject4).put("type", localObject3);
            paramWebSoState.jdField_b_of_type_JavaLangString = ((JSONObject)localObject4).toString();
            a(paramWebSoState);
            if (TextUtils.isEmpty(str1))
            {
              a(localHttpResponsePackage, localObject2, localUri, paramWebSoState);
              paramWebSoState.jdField_e_of_type_Boolean = false;
              paramWebSoState.jdField_b_of_type_JavaLangString = str2;
              paramWebSoState.jdField_a_of_type_Boolean = false;
              paramWebSoState.f = false;
              a(paramWebSoState);
              return;
            }
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
            a(str2, localObject2, str1, localUri, paramWebSoState, true, new akrk(this, paramWebSoState, System.currentTimeMillis()));
            return;
          }
        }
        if ("silent".equals(localObject3))
        {
          paramWebSoState.jdField_e_of_type_Boolean = true;
          paramWebSoState.jdField_a_of_type_Boolean = false;
          paramWebSoState.f = false;
          try
          {
            paramBundle = new JSONObject(str2).optJSONObject("data");
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("code", 1);
            ((JSONObject)localObject4).put("data", paramBundle);
            ((JSONObject)localObject4).put("type", localObject3);
            paramBundle = ((JSONObject)localObject4).toString();
            paramWebSoState.jdField_b_of_type_JavaLangString = paramBundle;
            a(paramWebSoState);
            if (TextUtils.isEmpty(str1))
            {
              a(localHttpResponsePackage, localObject2, localUri, paramWebSoState);
              paramWebSoState.jdField_e_of_type_Boolean = false;
              return;
            }
          }
          catch (JSONException paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
              paramBundle = "{\"code\":-1,\"data\":null}";
            }
            System.currentTimeMillis();
            a(str2, localObject2, str1, localUri, paramWebSoState, true, new akrl(this, paramWebSoState));
            return;
          }
        }
        if ((localObject3 == null) || ("false".equals(localObject3)))
        {
          if (TextUtils.isEmpty(str1))
          {
            paramWebSoState.jdField_b_of_type_JavaLangString = str2;
            paramWebSoState.jdField_a_of_type_Boolean = true;
            paramWebSoState.f = false;
            paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Int = 0;
            paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 0;
            a(paramWebSoState);
          }
          for (;;)
          {
            WebSoUtils.a(localUri);
            return;
            a(str2, localObject2, str1, localUri, paramWebSoState, false, new akrm(this, paramWebSoState, System.currentTimeMillis()));
          }
        }
        WebSoUtils.a(localUri);
        paramWebSoState.jdField_b_of_type_JavaLangString = str2;
        paramWebSoState.jdField_a_of_type_Boolean = true;
        paramWebSoState.f = false;
        a(paramWebSoState);
        return;
      }
    }
  }
  
  private boolean a(JSONObject paramJSONObject, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean)
  {
    Object localObject2 = WebSoUtils.d(paramUri);
    bool2 = true;
    if ((paramJSONObject == null) || (TextUtils.isEmpty((CharSequence)localObject2)))
    {
      bool2 = false;
      return bool2;
    }
    bool1 = bool2;
    paramUri = paramWebSoState;
    String str;
    Object localObject1;
    if (paramJSONObject.has("template"))
    {
      str = paramJSONObject.optString("template", "");
      localObject1 = paramWebSoState;
      if (paramWebSoState == null) {
        localObject1 = new WebSoService.WebSoState();
      }
      if (TextUtils.isEmpty(str)) {
        break label640;
      }
      ((WebSoService.WebSoState)localObject1).jdField_c_of_type_JavaLangString = str;
      bool1 = bool2;
      paramUri = (Uri)localObject1;
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        WebSoUtils.a(str.getBytes(), (String)localObject2 + "_template.txt");
        paramUri = (Uri)localObject1;
        bool1 = bool2;
      }
      catch (OutOfMemoryError paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "html is too large, OutOfMemoryError");
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 3, 1, null);
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      catch (Exception paramUri)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "template is exception=" + paramUri.getMessage());
        bool1 = false;
        paramUri = (Uri)localObject1;
        continue;
      }
      bool2 = bool1;
      if (!paramJSONObject.has("diff")) {
        break;
      }
      paramJSONObject = paramJSONObject.optString("diff", "");
      bool2 = bool1;
      if (TextUtils.isEmpty(paramJSONObject)) {
        break;
      }
      WebSoUtils.a(Base64.a(paramJSONObject.getBytes()), (String)localObject2 + ".patch");
      paramWebSoState = new File((String)localObject2 + "_template.txt");
      bool2 = bool1;
      if (!paramWebSoState.exists()) {}
      try
      {
        paramWebSoState.createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject1 = new File((String)localObject2 + ".patch");
      bool1 = bool2;
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        bool1 = bool2;
      }
      catch (IOException paramJSONObject)
      {
        bool1 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      localObject2 = new File((String)localObject2 + "_compose.txt");
      bool2 = bool1;
      if (!((File)localObject2).exists()) {}
      try
      {
        ((File)localObject2).createNewFile();
        bool2 = bool1;
      }
      catch (IOException paramJSONObject)
      {
        long l;
        bool2 = false;
        paramJSONObject.printStackTrace();
        continue;
      }
      bool1 = bool2;
      if (bool2)
      {
        l = System.currentTimeMillis();
        bool1 = BspatchUtil.a(paramWebSoState.getAbsolutePath(), ((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath());
        if (QLog.isColorLevel()) {
          QLog.d("WebSoService", 2, "patch file cost=" + (System.currentTimeMillis() - l));
        }
        paramJSONObject = paramUri;
        if (paramUri == null) {
          paramJSONObject = new WebSoService.WebSoState();
        }
        bool2 = bool1;
        if (bool1)
        {
          paramWebSoState.delete();
          ((File)localObject2).renameTo(paramWebSoState.getAbsoluteFile());
        }
      }
      try
      {
        paramJSONObject.jdField_c_of_type_JavaLangString = FileUtils.b(paramWebSoState);
        bool2 = bool1;
      }
      catch (IOException paramUri)
      {
        paramUri.printStackTrace();
        bool2 = false;
        continue;
      }
      bool1 = bool2;
      if (!bool2)
      {
        paramWebSoState.delete();
        ((File)localObject1).delete();
        ((File)localObject2).delete();
        paramJSONObject.jdField_c_of_type_JavaLangString = null;
        bool1 = bool2;
      }
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      paramWebSoState.delete();
      return bool1;
      label640:
      bool1 = false;
      paramUri = (Uri)localObject1;
    }
  }
  
  private static SharedPreferences b()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public String a(String paramString, Handler paramHandler)
  {
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    if (!TextUtils.isEmpty(localWebSoState.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "QonzeWnsProxyService getProxyData命中缓存，reqState:" + localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      }
      if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) {
        a(paramHandler, localWebSoState);
      }
    }
    for (;;)
    {
      return localWebSoState.jdField_b_of_type_JavaLangString;
      if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
      {
        localWebSoState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
        if (localWebSoState.jdField_b_of_type_Boolean)
        {
          localWebSoState.f = true;
          a(paramHandler, localWebSoState);
        }
        else
        {
          ThreadManager.getFileThreadHandler().post(new akri(this, localWebSoState, paramString, paramHandler));
          return null;
        }
      }
      else
      {
        a(paramString, paramHandler);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("WnsProxyService", 2, "QonzeWnsProxyService getProxyData未命中缓存，reqState:" + localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        }
        a(paramString, paramHandler);
      }
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean)
  {
    String str6 = "";
    if (paramUri == null) {
      return "";
    }
    int i = 1;
    String str2 = "";
    String str3 = str2;
    String str4 = str2;
    String str5 = str2;
    String str1;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString1);
        str3 = str2;
        str4 = str2;
        str5 = str2;
        l = System.currentTimeMillis();
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!a(localJSONObject, paramUri, paramWebSoState, paramBoolean)) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (QLog.isColorLevel())
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          QLog.d("WebSoService", 2, "composeDiffFile cost=" + (System.currentTimeMillis() - l));
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramWebSoState.jdField_c_of_type_JavaLangString == null)
        {
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("template-tag"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = WebSoUtils.d(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramString1 = new File(paramString1 + "_template.txt");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = WebSoUtils.a(paramUri);
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str1 = b().getString("templateTag_" + String.valueOf(l) + str1, "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str6 = localJSONObject.optString("template-tag");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!str1.equals(str6)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!paramString1.exists()) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            QLog.w("WebSoService", 1, "html template is null, now read from " + paramString1.getPath());
            str3 = str2;
            str4 = str2;
            str5 = str2;
            paramWebSoState.jdField_c_of_type_JavaLangString = FileUtils.b(paramString1);
          }
        }
      }
      catch (JSONException paramString1)
      {
        JSONObject localJSONObject;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str3;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (paramString1.exists()) {
          continue;
        }
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, " template file is not exits!");
        continue;
      }
      catch (Exception paramString1)
      {
        long l;
        i = 0;
        str1 = "";
        paramString1.printStackTrace();
        paramString1 = str4;
        continue;
        int j = 0;
        continue;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.e("WebSoService", 1, "check html data fail cost=" + (System.currentTimeMillis() - l));
        i = 0;
        str1 = "";
        str3 = str2;
        str4 = str2;
        str5 = str2;
        WebSoUtils.a(paramUri);
        paramString1 = str2;
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("WebSoService", 2, "storeDiffData is OutOfMemoryError");
        paramString1.printStackTrace();
        VipUtils.a(null, "webview_report", "0X8006511", "0X8006511", 2, 1, null);
        paramString1 = str5;
        i = 0;
        str1 = "";
        continue;
        paramWebSoState.putString("eTag_" + str2 + paramUri, "");
        paramWebSoState.putString("templateTag_" + str2 + paramUri, "");
        paramWebSoState.putString("htmlSha1_" + str2 + paramUri, "");
        continue;
        paramWebSoState.apply();
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      l = System.currentTimeMillis();
      str3 = str2;
      str4 = str2;
      str5 = str2;
      paramString1 = a(localJSONObject, paramWebSoState);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (QLog.isColorLevel())
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.d("WebSoService", 2, "updateHtml cost=" + (System.currentTimeMillis() - l));
      }
      j = i;
      str6 = paramString1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (TextUtils.isEmpty(paramString1))
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        QLog.w("WebSoService", 1, "htmlContent is null! " + localJSONObject.toString());
        str6 = paramString1;
        j = i;
      }
      paramString1 = str2;
      i = j;
      str1 = str6;
      if (j != 0)
      {
        paramString1 = str2;
        i = j;
        str1 = str6;
        str3 = str2;
        str4 = str2;
        str5 = str2;
        if (!TextUtils.isEmpty(str6))
        {
          paramString1 = str2;
          i = j;
          str1 = str6;
          str3 = str2;
          str4 = str2;
          str5 = str2;
          if (localJSONObject.has("html-sha1"))
          {
            str3 = str2;
            str4 = str2;
            str5 = str2;
            str2 = localJSONObject.optString("html-sha1", "");
            str3 = str2;
            str4 = str2;
            str5 = str2;
            l = System.currentTimeMillis();
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (!SHA1Util.a(str6).equals(str2)) {
              continue;
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            if (QLog.isColorLevel())
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              QLog.d("WebSoService", 2, "check html data success cost=" + (System.currentTimeMillis() - l));
            }
            str3 = str2;
            str4 = str2;
            str5 = str2;
            a(paramUri, paramWebSoState, localJSONObject);
            paramString1 = str2;
            i = j;
            str1 = str6;
            if (paramBoolean)
            {
              str3 = str2;
              str4 = str2;
              str5 = str2;
              WebSoUtils.a(str6.getBytes(), WebSoUtils.b(paramUri));
              paramString1 = str2;
              i = j;
              str1 = str6;
              str3 = str2;
              str4 = str2;
              str5 = str2;
              if (paramWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
              {
                paramString1 = str2;
                i = j;
                str1 = str6;
                str3 = str2;
                str4 = str2;
                str5 = str2;
                if (localJSONObject.has("data"))
                {
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramString1 = localJSONObject.optJSONObject("data");
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  paramWebSoState = WebSoUtils.d(paramUri) + "_data.txt";
                  str3 = str2;
                  str4 = str2;
                  str5 = str2;
                  WebSoUtils.a(paramString1.toString().getBytes(), paramWebSoState);
                  str1 = str6;
                  i = j;
                  paramString1 = str2;
                }
              }
            }
          }
        }
      }
      paramWebSoState = b().edit();
      str2 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      paramUri = WebSoUtils.a(paramUri);
      if ((i == 0) || (!paramBoolean)) {
        continue;
      }
      paramWebSoState.putString("eTag_" + str2 + paramUri, paramString2);
      paramWebSoState.putString("templateTag_" + str2 + paramUri, paramString3);
      paramWebSoState.putString("htmlSha1_" + str2 + paramUri, paramString1);
      if (Build.VERSION.SDK_INT >= 9) {
        continue;
      }
      paramWebSoState.commit();
      return str1;
      str3 = str2;
      str4 = str2;
      str5 = str2;
      if (str1.equals(str6)) {
        continue;
      }
      str3 = str2;
      str4 = str2;
      str5 = str2;
      QLog.w("WebSoService", 1, "I have no idea how to handle this situation! " + str1 + " vs new tag: " + str6);
    }
    return str1;
  }
  
  public void a(WebSoService.WebSoState paramWebSoState)
  {
    Handler localHandler;
    if ((paramWebSoState != null) && (paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localHandler = (Handler)paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramWebSoState);
    paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference = null;
    HybridWebReporter.a().a(paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!WebSoUtils.a(Uri.parse(paramString))) {
      return;
    }
    a(paramString, paramHandler);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = Uri.parse(paramString);
    } while ((paramString == null) || (!new File(WebSoUtils.b(paramString)).exists()));
    return true;
  }
  
  public boolean a(String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "do not need startWebSoRequest, url=" + paramString);
      }
      return false;
    }
    a(paramString);
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    localWebSoState.jdField_a_of_type_JavaLangString = paramString;
    localWebSoState.f = false;
    localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    localWebSoState.jdField_a_of_type_Boolean = false;
    localWebSoState.jdField_c_of_type_Boolean = false;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramString;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    localWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Boolean = false;
    if (WebSoUtils.a(paramString))
    {
      localWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      localWebSoState.g = false;
      localWebSoState.jdField_e_of_type_JavaLangString = "";
    }
    while (WebSoUtils.e(paramString))
    {
      return false;
      localWebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    String str2 = QUA.a();
    String str1 = WebSoUtils.a();
    Object localObject2 = "";
    Object localObject1 = "";
    Object localObject3 = Uri.parse(paramString);
    if (localObject3 != null)
    {
      String str3 = String.valueOf(l);
      Object localObject4 = b();
      String str4 = WebSoUtils.a((Uri)localObject3);
      localObject2 = ((SharedPreferences)localObject4).getString("eTag_" + str3 + str4, "");
      localObject1 = ((SharedPreferences)localObject4).getString("templateTag_" + str3 + str4, "");
      str3 = ((SharedPreferences)localObject4).getString("htmlSha1_" + str3 + str4, "");
      localObject4 = new File(WebSoUtils.b((Uri)localObject3));
      if ((TextUtils.isEmpty(str3)) || (!((File)localObject4).exists())) {
        break label738;
      }
      a((Uri)localObject3, str3, (File)localObject4, localWebSoState, new akrg(this, System.currentTimeMillis(), localWebSoState, paramString));
    }
    for (;;)
    {
      localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("if_None_Match", localObject2);
        ((JSONObject)localObject3).put("accept_diff", "true");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((JSONObject)localObject3).put("template_tag", localObject1);
        }
        ((JSONObject)localObject3).put("uri", paramString);
        localObject1 = SwiftBrowserCookieMonster.c(paramString);
        ((JSONObject)localObject3).put("cookie", (String)localObject1 + "; qua=" + str2 + "; ");
        ((JSONObject)localObject3).put("no_Chunked", "true");
        ((JSONObject)localObject3).put("accept_Encoding", "identity");
        localObject1 = new HttpRequestPackage(str1, (JSONObject)localObject3);
        if (Build.VERSION.SDK_INT >= 17) {
          localObject2 = new JSONObject();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((JSONObject)localObject2).put("webso", "2.0");
          ((HttpRequestPackage)localObject1).addHeader(((JSONObject)localObject2).toString());
          localObject1 = new HttpReq(EnumHttpMethod.convert("e" + ((HttpRequestPackage)localObject1).method).value(), ((HttpRequestPackage)localObject1).getHeaderString(), ((HttpRequestPackage)localObject1).getBodyString(), ((HttpRequestPackage)localObject1).host);
          if (paramHandler != null) {
            localWebSoState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
          }
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l, paramString, (HttpReq)localObject1, "");
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.getApplication().getRuntime().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.getApplication().getRuntime().startServlet(paramHandler);
          return true;
          label738:
          if (QLog.isColorLevel()) {
            QLog.d("WebSoService", 2, "set eTag to get all data");
          }
          localObject2 = "";
          localObject1 = "";
          VipUtils.a(null, "webview_report", "0X8006566", "0X8006566", 0, 0, new String[] { paramString });
          continue;
          localException1 = localException1;
          localException1.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 100) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService
 * JD-Core Version:    0.7.0.1
 */
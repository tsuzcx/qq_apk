package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
  LruCache<String, WebSoService.WebSoState> jdField_a_of_type_AndroidSupportV4UtilLruCache = new WebSoService.1(this, 10);
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private Pair<String, String> a(String paramString, Handler paramHandler, WebSoService.WebSoState paramWebSoState, long paramLong)
  {
    Uri localUri = Uri.parse(paramString);
    paramString = "";
    if (localUri != null)
    {
      String str2 = String.valueOf(paramLong);
      Object localObject2 = b();
      String str3 = WebSoUtils.a(localUri);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("eTag_");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(str3);
      String str1 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject1).toString(), "");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pageVersion_");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(str3);
      localObject1 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject1).toString(), "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("htmlSha1_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      str2 = ((SharedPreferences)localObject2).getString(localStringBuilder.toString(), "");
      localObject2 = new File(WebSoUtils.b(localUri));
      if ((!TextUtils.isEmpty(str2)) && (((File)localObject2).exists()))
      {
        a(localUri, str2, (File)localObject2, paramWebSoState, new WebSoService.2(this, System.currentTimeMillis(), paramWebSoState, paramHandler));
        paramString = str1;
        paramHandler = (Handler)localObject1;
        break label260;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebSoService", 2, "set eTag to get all data");
      }
    }
    paramHandler = "";
    label260:
    return new Pair(paramString, paramHandler);
  }
  
  @Nullable
  private HttpResponsePackage a(WebSoService.WebSoState paramWebSoState, HttpRsp paramHttpRsp, HttpResponsePackage paramHttpResponsePackage)
  {
    if (paramHttpRsp != null) {
      paramHttpResponsePackage = new HttpResponsePackage(paramHttpRsp);
    }
    if (paramHttpRsp == null)
    {
      paramWebSoState.jdField_a_of_type_Int = 10002;
      paramWebSoState.jdField_d_of_type_JavaLangString = "rsp is null";
      a(paramWebSoState);
      return null;
    }
    return paramHttpResponsePackage;
  }
  
  public static WebSoService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService == null) {
          jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService = new WebSoService();
        }
      }
    }
    return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService;
  }
  
  @NotNull
  private String a(WebSoService.WebSoState paramWebSoState, String paramString)
  {
    paramString = paramString.split(":")[1].trim();
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int < 3) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 3;
    }
    return paramString;
  }
  
  private void a(Uri paramUri, String paramString, File paramFile, WebSoService.WebSoState paramWebSoState, WebSoService.CallBack paramCallBack)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.3(this, paramFile, paramString, paramCallBack, paramUri));
  }
  
  private void a(Bundle paramBundle, WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString, String[] paramArrayOfString, Uri paramUri)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    Object localObject5 = null;
    Object localObject1 = localObject5;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    while (i < j)
    {
      String str = paramArrayOfString[i].toLowerCase();
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      if (str.contains("cache-offline"))
      {
        localObject6 = str.split(":")[1].trim();
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
      }
      else if (str.contains("etag"))
      {
        localObject7 = str.split(":")[1].trim();
        localObject6 = localObject5;
        localObject8 = localObject2;
        localObject9 = localObject3;
      }
      else if (str.contains("template-tag"))
      {
        localObject8 = str.split(":")[1].trim();
        localObject6 = localObject5;
        localObject7 = localObject1;
        localObject9 = localObject3;
      }
      else if (str.contains("webso-page-version"))
      {
        localObject9 = b(paramWebSoState, str);
        localObject6 = localObject5;
        localObject7 = localObject1;
        localObject8 = localObject2;
      }
      else
      {
        localObject6 = localObject5;
        localObject7 = localObject1;
        localObject8 = localObject2;
        localObject9 = localObject3;
        if (str.contains("webso-content-type"))
        {
          localObject4 = a(paramWebSoState, str);
          localObject9 = localObject3;
          localObject8 = localObject2;
          localObject7 = localObject1;
          localObject6 = localObject5;
        }
      }
      i += 1;
      localObject5 = localObject6;
      localObject1 = localObject7;
      localObject2 = localObject8;
      localObject3 = localObject9;
    }
    a(paramBundle, paramWebSoState, paramHttpResponsePackage, paramString, paramArrayOfString, paramUri, localObject5, localObject1, localObject2, localObject3, (String)localObject4);
  }
  
  private void a(Bundle paramBundle, WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, String[] paramArrayOfString, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool = a(paramWebSoState, paramString1, paramArrayOfString, paramUri, paramString3, paramString5, paramString6);
    if (paramArrayOfString[0].contains("304"))
    {
      WebSoUtils.a("notifyState 304");
      a(paramWebSoState, paramArrayOfString, paramUri, paramString3, paramString5, bool);
      return;
    }
    if ("http".equals(paramString2))
    {
      WebSoUtils.a("notifyState now 503, so start reLoadUrl");
      a(paramWebSoState, paramUri);
      return;
    }
    if (TextUtils.isEmpty(paramString4))
    {
      if ("true".equals(paramString2))
      {
        WebSoUtils.a("notifyState true");
        a(paramWebSoState, paramHttpResponsePackage, paramString1, paramUri, paramString3, paramString5);
        return;
      }
      if (bool)
      {
        WebSoUtils.a("notifyState json");
        a(paramWebSoState, paramHttpResponsePackage, paramUri, paramString3, paramString5);
        return;
      }
      if ("store".equals(paramString2))
      {
        WebSoUtils.a("notifyState store");
        a(paramWebSoState, paramHttpResponsePackage, paramString1, paramUri, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      if ("silent".equals(paramString2))
      {
        WebSoUtils.a("notifyState silent");
        a(paramWebSoState, paramHttpResponsePackage, paramString1, paramUri, paramString2, paramString3, paramString5);
        return;
      }
      if ((paramString2 == null) || ("false".equals(paramString2)))
      {
        WebSoUtils.a("notifyState update");
        a(paramWebSoState, paramString1, paramUri, paramString3, paramString5);
        return;
      }
    }
    WebSoUtils.a("notifyState other");
    WebSoUtils.a(paramUri);
    paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    paramWebSoState.f = false;
    a(paramWebSoState);
  }
  
  private void a(Handler paramHandler, WebSoService.WebSoState paramWebSoState)
  {
    if (paramHandler != null)
    {
      if (paramWebSoState == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("key_rsp_succeed", paramWebSoState.jdField_d_of_type_Boolean);
      localBundle.putString("url", paramWebSoState.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("need_force_refresh", paramWebSoState.jdField_a_of_type_Boolean);
      localBundle.putBoolean("need_local_refresh", paramWebSoState.g);
      localBundle.putString("key_html_changed_data", paramWebSoState.jdField_e_of_type_JavaLangString);
      localBundle.putBoolean("key_wns_cache_hit", paramWebSoState.jdField_c_of_type_Boolean);
      if ((paramWebSoState.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)))
      {
        paramWebSoState.jdField_b_of_type_JavaLangString = WebSoUtils.d(paramWebSoState.jdField_a_of_type_JavaLangString);
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
      localBundle.putParcelable("key_webso_3", paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send webso3 ");
      localStringBuilder.append(paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.toString());
      WebSoUtils.a(localStringBuilder.toString());
      paramWebSoState = paramHandler.obtainMessage(203);
      paramWebSoState.obj = localBundle;
      paramHandler.sendMessage(paramWebSoState);
    }
  }
  
  private static void a(HttpResponsePackage paramHttpResponsePackage, String paramString1, String paramString2, Uri paramUri, WebSoService.WebSoState paramWebSoState)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.5(paramHttpResponsePackage, paramUri, paramString1, paramString2, paramWebSoState));
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, Uri paramUri)
  {
    paramWebSoState.jdField_a_of_type_Int = 10503;
    paramWebSoState.jdField_c_of_type_Boolean = false;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    WebSoUtils.b(paramUri);
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, Uri paramUri, String paramString1, String paramString2)
  {
    WebSoUtils.a("result = json");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_b_of_type_JavaLangString = paramString2;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.c = paramHttpResponsePackage.jdField_d_of_type_JavaLangString;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_d_of_type_JavaLangString = paramUri.toString();
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_e_of_type_JavaLangString = "webso-data-json";
    paramWebSoState.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.j = "json";
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    a(paramHttpResponsePackage, paramString2, paramString3, paramUri, paramWebSoState);
    paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    paramWebSoState.f = false;
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    paramWebSoState.jdField_e_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_Boolean = false;
    paramWebSoState.f = false;
    try
    {
      paramString1 = new JSONObject(paramString1).optJSONObject("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", 1);
      localJSONObject.put("data", paramString1);
      localJSONObject.put("type", paramString2);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = "{\"code\":-1,\"data\":null}";
    }
    paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
    a(paramWebSoState);
    a(paramHttpResponsePackage, paramString3, paramString4, paramUri, paramWebSoState);
    paramWebSoState.jdField_e_of_type_Boolean = false;
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, HttpResponsePackage paramHttpResponsePackage, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((a(paramWebSoState.jdField_a_of_type_JavaLangString)) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean != null) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean.length > 0) && (paramWebSoState.jdField_a_of_type_ArrayOfBoolean[0] != 0))
    {
      paramWebSoState.jdField_e_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_Boolean = false;
      paramWebSoState.f = false;
      try
      {
        paramString4 = new JSONObject(paramString1).optJSONObject("data");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", 1);
        localJSONObject.put("data", paramString4);
        localJSONObject.put("type", paramString2);
        paramWebSoState.jdField_b_of_type_JavaLangString = localJSONObject.toString();
        a(paramWebSoState);
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    a(paramHttpResponsePackage, paramString3, paramString5, paramUri, paramWebSoState);
    paramWebSoState.jdField_e_of_type_Boolean = false;
    paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_Boolean = false;
    paramWebSoState.f = false;
    a(paramWebSoState);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    paramWebSoState.jdField_b_of_type_JavaLangString = paramString1;
    paramWebSoState.jdField_a_of_type_Boolean = true;
    paramWebSoState.f = false;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Int = 0;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 0;
    a(paramWebSoState);
    WebSoUtils.a(paramUri);
    a(paramString1, paramString2, paramString3, paramUri);
  }
  
  private void a(WebSoService.WebSoState paramWebSoState, String[] paramArrayOfString, Uri paramUri, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WebSoUtils.a("result = 304");
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_a_of_type_JavaLangString = paramString1;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_b_of_type_JavaLangString = paramString2;
      paramString1 = paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3;
      paramString2 = new StringBuilder();
      paramString2.append("\"");
      paramString2.append(paramArrayOfString[0]);
      paramString2.append("\"");
      paramString1.c = paramString2.toString();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_d_of_type_JavaLangString = paramUri.toString();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.jdField_e_of_type_JavaLangString = "webso-304";
      paramWebSoState.jdField_c_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.j = "304";
      a(paramWebSoState);
      return;
    }
    QLog.i("WebSoService", 1, "now 304,so return! ");
    paramWebSoState.jdField_c_of_type_Boolean = true;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Boolean = true;
    a(paramWebSoState);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Uri paramUri)
  {
    ThreadManager.getFileThreadHandler().post(new WebSoService.6(paramString1, paramUri, paramString2, paramString3));
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("url");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onGetHttpData succed(");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append("), url:");
    ((StringBuilder)localObject2).append(Util.c((String)localObject1, new String[0]));
    WebSoUtils.a(((StringBuilder)localObject2).toString());
    localObject1 = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a((String)localObject1));
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_Int = 0;
    localObject2 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    Bundle localBundle = new Bundle();
    if ((localObject2 != null) && (paramBoolean))
    {
      localBundle.putBoolean("key_rsp_succeed", true);
      localBundle.putString("url", paramBundle.getString("url"));
    }
    else
    {
      localBundle.putBoolean("key_rsp_succeed", false);
    }
    a(paramBoolean, paramBundle, (WebSoService.WebSoState)localObject1);
  }
  
  private boolean a(WebSoService.WebSoState paramWebSoState, String paramString1, String[] paramArrayOfString, Uri paramUri, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = "json".equals(paramString4);
    if (!bool) {
      b(paramUri.toString());
    }
    paramUri = new StringBuilder();
    paramUri.append("receive header : ");
    paramUri.append(Arrays.toString(paramArrayOfString));
    WebSoUtils.a(paramUri.toString());
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("receive data : ");
    paramArrayOfString.append(paramString1);
    WebSoUtils.a(paramArrayOfString.toString());
    if (bool)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("receive contentType = ");
      paramArrayOfString.append(paramString4);
      paramArrayOfString.append("  pageVersion = ");
      paramArrayOfString.append(paramString3);
      paramArrayOfString.append(" etag = ");
      paramArrayOfString.append(paramString2);
      WebSoUtils.a(paramArrayOfString.toString());
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Long = paramString1.length();
    return bool;
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle, WebSoService.WebSoState paramWebSoState)
  {
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo == null)
    {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramWebSoState.jdField_a_of_type_JavaLangString;
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    }
    if (!paramBoolean) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_Int = 1;
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("key_user_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.h = paramBundle.getString("key_dns_result");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_f_of_type_JavaLangString = paramBundle.getString("key_server_ip");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.g = paramBundle.getString("key_server_port");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Int = paramBundle.getInt("key_time_cost");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Int = paramBundle.getInt("rsp_code");
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_c_of_type_Int = 2;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.i = paramBundle.getString("key_detail_info");
    paramWebSoState.jdField_e_of_type_Boolean = false;
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a();
    if (!paramBoolean)
    {
      paramWebSoState.jdField_a_of_type_Int = 10001;
      if (!TextUtils.isEmpty(paramWebSoState.jdField_b_of_type_JavaLangString)) {
        paramWebSoState.jdField_c_of_type_Boolean = true;
      }
      a(paramWebSoState);
      return true;
    }
    paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.a();
    return false;
  }
  
  private static SharedPreferences b()
  {
    return BaseApplication.getContext().getSharedPreferences("wns_html_etags", 0);
  }
  
  @NotNull
  private String b(WebSoService.WebSoState paramWebSoState, String paramString)
  {
    paramString = paramString.split(":")[1].trim();
    if (paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int < 3) {
      paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_e_of_type_Int = 3;
    }
    return paramString;
  }
  
  private static void b(String paramString)
  {
    FileUtils.delete(WebSoUtils.b(paramString), false);
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
    return a(paramString, paramHandler, null);
  }
  
  public String a(String paramString, Handler paramHandler, boolean[] paramArrayOfBoolean)
  {
    WebSoService.WebSoState localWebSoState = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(localWebSoState.jdField_a_of_type_JavaLangString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("命中缓存，reqState:");
      localStringBuilder.append(localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      WebSoUtils.a(localStringBuilder.toString());
      localWebSoState.jdField_a_of_type_ArrayOfBoolean = paramArrayOfBoolean;
      if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
      {
        a(paramHandler, localWebSoState);
      }
      else if (localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
      {
        localWebSoState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
        if (localWebSoState.jdField_b_of_type_Boolean)
        {
          localWebSoState.f = true;
          a(paramHandler, localWebSoState);
        }
        else
        {
          ThreadManager.getFileThreadHandler().post(new WebSoService.4(this, localWebSoState, paramString, paramHandler));
          return null;
        }
      }
      else
      {
        a(paramString, paramHandler);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("未命中缓存，reqState:");
      localStringBuilder.append(localWebSoState.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      WebSoUtils.a(localStringBuilder.toString());
      localWebSoState.jdField_a_of_type_ArrayOfBoolean = paramArrayOfBoolean;
      a(paramString, paramHandler);
    }
    return localWebSoState.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void a(WebSoService.WebSoState paramWebSoState)
  {
    if (paramWebSoState == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Webso", 2, "notifyMessage", new Throwable());
    }
    if ((paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      WebSoUtils.a("notifyMessage");
      Handler localHandler = (Handler)paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localHandler == null) {
        return;
      }
      a(localHandler, paramWebSoState);
      paramWebSoState.jdField_a_of_type_JavaLangRefWeakReference = null;
      HybridWebReporter.a().a(paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, Handler paramHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (WebSoUtils.a(Uri.parse(paramString))) {
      a(paramString, paramHandler);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, WebSoService.WebSoState paramWebSoState)
  {
    if (a(paramBoolean, paramBundle, paramWebSoState)) {
      return;
    }
    Object localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    HttpResponsePackage localHttpResponsePackage = a(paramWebSoState, (HttpRsp)localObject1, null);
    if (localHttpResponsePackage == null) {
      return;
    }
    Object localObject2 = ((HttpRsp)localObject1).rspinfo;
    int i = ((String)localObject2).indexOf("\r\n\r\n");
    localObject1 = localHttpResponsePackage.jdField_d_of_type_JavaLangString;
    if (i < 1) {
      return;
    }
    localObject2 = ((String)localObject2).substring(0, i - 1).split("\r\n");
    Uri localUri = Uri.parse(paramBundle.getString("url"));
    String[] arrayOfString = localObject2[0].split(" ");
    if (arrayOfString.length >= 2) {
      try
      {
        paramWebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_JavaLangString = arrayOfString[1].trim();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    paramWebSoState.jdField_c_of_type_Boolean = false;
    a(paramBundle, paramWebSoState, localHttpResponsePackage, (String)localObject1, (String[])localObject2, localUri);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString);
    return (paramString != null) && (new File(WebSoUtils.b(paramString)).exists());
  }
  
  public boolean a(String paramString, Handler paramHandler)
  {
    return a(paramString, paramHandler, false);
  }
  
  public boolean a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startWebSoRequest url=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" handler=");
    ((StringBuilder)localObject1).append(paramHandler);
    WebSoUtils.a(((StringBuilder)localObject1).toString());
    a(paramString);
    localObject1 = (WebSoService.WebSoState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(WebSoUtils.a(paramString));
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_JavaLangString = paramString;
    ((WebSoService.WebSoState)localObject1).f = false;
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_Boolean = false;
    ((WebSoService.WebSoState)localObject1).jdField_c_of_type_Boolean = false;
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo = new HybridWebReporter.HybridWebReportInfo();
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Long = WebSoUtils.a();
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_JavaLangString = paramString;
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_a_of_type_Boolean = true;
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_d_of_type_Boolean = false;
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.a();
    ((WebSoService.WebSoState)localObject1).jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState$WebSo3.a();
    if (WebSoUtils.a(paramString))
    {
      ((WebSoService.WebSoState)localObject1).jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ((WebSoService.WebSoState)localObject1).g = false;
      ((WebSoService.WebSoState)localObject1).jdField_e_of_type_JavaLangString = "";
    }
    else
    {
      ((WebSoService.WebSoState)localObject1).jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
    if (WebSoUtils.e(paramString)) {
      return false;
    }
    long l = WebSoUtils.a();
    String str1 = VasUtil.a().websoGetQUA();
    Object localObject2 = WebSoUtils.a();
    Object localObject4 = a(paramString, paramHandler, (WebSoService.WebSoState)localObject1, l);
    String str2 = (String)((Pair)localObject4).first;
    Object localObject5 = (String)((Pair)localObject4).second;
    localObject4 = new JSONObject();
    try
    {
      ((JSONObject)localObject4).put("if_None_Match", str2);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((JSONObject)localObject4).put("web_page_version", localObject5);
      }
      ((JSONObject)localObject4).put("uri", paramString);
      str2 = VasUtil.a().websoGetCookie4WebSoOrSonic(paramString);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(str2);
      ((StringBuilder)localObject5).append("; qua=");
      ((StringBuilder)localObject5).append(str1);
      ((StringBuilder)localObject5).append("; ");
      ((JSONObject)localObject4).put("cookie", ((StringBuilder)localObject5).toString());
      ((JSONObject)localObject4).put("no_Chunked", "true");
      ((JSONObject)localObject4).put("accept_Encoding", "identity");
      if (paramBoolean) {
        ((JSONObject)localObject4).put("x_wns_ispreload_request", "1");
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    localObject2 = new HttpRequestPackage((String)localObject2, (JSONObject)localObject4);
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("webso", "3.0");
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    ((HttpRequestPackage)localObject2).addHeader(((JSONObject)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("send header = ");
    ((StringBuilder)localObject3).append(((HttpRequestPackage)localObject2).getHeaderString());
    WebSoUtils.a(((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("e");
    ((StringBuilder)localObject3).append(((HttpRequestPackage)localObject2).method);
    localObject2 = new HttpReq(EnumHttpMethod.convert(((StringBuilder)localObject3).toString()).value(), ((HttpRequestPackage)localObject2).getHeaderString(), ((HttpRequestPackage)localObject2).getBodyString(), ((HttpRequestPackage)localObject2).host);
    if (paramHandler != null) {
      ((WebSoService.WebSoState)localObject1).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
    }
    paramHandler = new NewIntent(localAppRuntime.getApplicationContext(), WebSoServlet.class);
    WebSoServlet.a(paramHandler, l, paramString, (HttpReq)localObject2, "");
    if (!this.jdField_a_of_type_Boolean)
    {
      localAppRuntime.registObserver(this);
      this.jdField_a_of_type_Boolean = true;
    }
    localAppRuntime.startServlet(paramHandler);
    WebSoUtils.a("startServlet req");
    return true;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 100) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoCgiService;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QzoneWebViewOfflinePlugin
  extends WebViewPlugin
{
  private static final int CGI_CODE_ERROR = 101;
  private static final int CGI_CODE_SUCCESS = 0;
  private static final int CGI_STATUS_ERROR = 100;
  private static final int CGI_STATUS_OPEN = 1;
  private static final int CGI_STATUS_SEND = 2;
  private static final int CGI_STATUS_SUCCESS = 4;
  private static final String JS_FUNC_CHECK_OFFLINE = "offlineResourceIsCached";
  public static final String NAMESPACE = "QzoneData";
  public static final String STR_DEVIDER = "://";
  private static final String TAG = "QzoneWebViewOfflinePlugin";
  private String callback = "";
  private Handler cgiRequestHandler;
  private Handler preloadHandler = null;
  private String proxyUrl;
  
  public QzoneWebViewOfflinePlugin()
  {
    this.mPluginNameSpace = "QzoneData";
  }
  
  private String getCurrentUrl()
  {
    CustomWebView localCustomWebView;
    if (this.mRuntime != null) {
      localCustomWebView = this.mRuntime.a();
    } else {
      localCustomWebView = null;
    }
    if (localCustomWebView != null) {
      return localCustomWebView.getUrl();
    }
    return null;
  }
  
  private String getStringValue(String paramString)
  {
    try
    {
      Object localObject = this.mRuntime.d();
      if (localObject == null) {
        return null;
      }
      localObject = ((Activity)localObject).getIntent();
      if (localObject == null) {
        return null;
      }
      localObject = ((Intent)localObject).getExtras();
      if (localObject == null) {
        return null;
      }
      paramString = ((Bundle)localObject).getString(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private static long getUrlClickTime(WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    if (paramPluginRuntime == null) {
      return 0L;
    }
    try
    {
      long l = paramPluginRuntime.d().getIntent().getLongExtra("preAct_time", 0L);
      return l;
    }
    catch (Exception paramPluginRuntime)
    {
      QLog.w("QzoneWebViewOfflinePlugin", 2, "can not get click time", paramPluginRuntime);
    }
    return 0L;
  }
  
  public static String getUrlHost(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new URL(paramString).getHost().toLowerCase();
      return paramString;
    }
    catch (Throwable paramString)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  private void handleCheckOfflineCache(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject1).optString("url");
        localObject1 = ((JSONObject)localObject1).optString("callback");
        if ((paramVarArgs != null) && (paramVarArgs.length() != 0))
        {
          if ((localObject1 != null) && (((String)localObject1).length() != 0))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("QzoneData.offlineResourceIsCached url: ");
              ((StringBuilder)localObject2).append(paramVarArgs);
              ((StringBuilder)localObject2).append(",callback: ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.i("QzoneWebViewOfflinePlugin", 2, ((StringBuilder)localObject2).toString());
            }
            boolean bool = QzoneOfflineCacheHelper.checkFileIfExist(paramVarArgs);
            Object localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("url", paramVarArgs);
            if (!bool) {
              break label270;
            }
            i = 1;
            ((JSONObject)localObject2).put("hasData", i);
            callJs((String)localObject1, new String[] { ((JSONObject)localObject2).toString() });
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("QzoneData.offlineResourceIsCached callback :");
              paramVarArgs.append(((JSONObject)localObject2).toString());
              QLog.i("QzoneWebViewOfflinePlugin", 2, paramVarArgs.toString());
            }
          }
          else
          {
            QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached callback is empty");
          }
        }
        else
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached url is empty");
          return;
        }
      }
      catch (Throwable paramVarArgs)
      {
        QLog.e("QzoneWebViewOfflinePlugin", 1, paramVarArgs, new Object[0]);
      }
      return;
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached args is empty");
      return;
      label270:
      int i = 0;
    }
  }
  
  private void handlePreDownloadZip(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1)) {}
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        String str1 = paramVarArgs.optString("zipurl");
        String str2 = paramVarArgs.optString("business");
        if (QzoneZipCacheHelper.isDangerousLocalPath(str2))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "handlePreDownloadZip business 参数错误。");
          return;
        }
        String str3 = paramVarArgs.optString("dir");
        if (QzoneZipCacheHelper.isDangerousLocalPath(str3))
        {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "handlePreDownloadZip dir 参数错误。");
          return;
        }
        int i = paramVarArgs.getInt("count");
        String str4 = paramVarArgs.optString("callback");
        if ((str1 != null) && (str1.length() != 0))
        {
          if ((str4 != null) && (str4.length() != 0))
          {
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("QzoneData.ResourceIsCached url: ");
              paramVarArgs.append(str1);
              paramVarArgs.append(",dir ");
              paramVarArgs.append(str3);
              paramVarArgs.append(",callback: ");
              paramVarArgs.append(str4);
              QLog.i("QzoneWebViewOfflinePlugin", 2, paramVarArgs.toString());
            }
            if (this.mRuntime == null) {
              break label277;
            }
            paramVarArgs = this.mRuntime.b();
            if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(paramVarArgs, str1, str2, str3, i, new QzoneWebViewOfflinePlugin.2(this, str2, str3, str4))) {
              jsCallback(true, str2, str3, str4);
            }
          }
          else
          {
            QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.ResourceIsCached callback is empty");
          }
        }
        else {
          QLog.w("QzoneWebViewOfflinePlugin", 1, "QzoneData.ResourceIsCached url is empty");
        }
        return;
      }
      catch (Throwable paramVarArgs)
      {
        return;
      }
      QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.offlineResourceIsCached args is empty");
      return;
      label277:
      paramVarArgs = null;
    }
  }
  
  private void handleWnsCgi(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      WebSoCgiService.CgiReqInfo localCgiReqInfo = new WebSoCgiService.CgiReqInfo();
      try
      {
        localObject1 = new JSONObject(paramVarArgs[0]);
        localCgiReqInfo.f = ((JSONObject)localObject1).optString("callback");
        localCgiReqInfo.a = ((JSONObject)localObject1).optString("url");
        if (!TextUtils.isEmpty(localCgiReqInfo.a))
        {
          if (isUrlHostEqual(getCurrentUrl(), localCgiReqInfo.a))
          {
            localCgiReqInfo.b = ((JSONObject)localObject1).optString("method");
            if ((!"GET".equalsIgnoreCase(localCgiReqInfo.b)) && (!"POST".equalsIgnoreCase(localCgiReqInfo.b))) {
              throw new Exception("no such method support!!!");
            }
            localObject2 = ((JSONObject)localObject1).opt("body");
            boolean bool = localObject2 instanceof JSONObject;
            str = null;
            if (bool)
            {
              localCgiReqInfo.e = "application/x-www-form-urlencoded";
              localCgiReqInfo.d = json2UrlEncoded((JSONObject)localObject2);
            }
            else
            {
              localCgiReqInfo.e = null;
              localCgiReqInfo.d = localObject2.toString();
            }
            localObject2 = ((JSONObject)localObject1).opt("header");
            if ((localObject2 != null) && (!(localObject2 instanceof JSONObject))) {
              throw new Exception("header format error!!!");
            }
            if (localObject2 != null) {
              str = localObject2.toString();
            }
            localCgiReqInfo.c = str;
            localCgiReqInfo.g = ((JSONObject)localObject1).optBoolean("dataNeedBase64", false);
            localCgiReqInfo.h = ((int)(((JSONObject)localObject1).optDouble("timeout", 0.0D) * 1000.0D));
            localCgiReqInfo.i = ((JSONObject)localObject1).opt("userinfo");
            if (this.cgiRequestHandler == null) {
              this.cgiRequestHandler = new QzoneWebViewOfflinePlugin.3(this, Looper.getMainLooper());
            }
            if (!WebSoCgiService.a().a(localCgiReqInfo, this.cgiRequestHandler))
            {
              paramVarArgs = new WebSoCgiService.WebSoCgiState();
              paramVarArgs.b = localCgiReqInfo.a;
              paramVarArgs.e = 1;
              paramVarArgs.i = 101;
              paramVarArgs.j = "send req fail!";
              notifyCgiStatus(paramVarArgs, localCgiReqInfo.f);
            }
            return;
          }
          String str = getUrlHost(getCurrentUrl());
          localObject1 = getUrlHost(localCgiReqInfo.a);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("not support for cross-domain request!!! current host=");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(",req host=");
          ((StringBuilder)localObject2).append((String)localObject1);
          throw new Exception(((StringBuilder)localObject2).toString());
        }
        throw new Exception("url is empty!!!");
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("wnscgi error,args is ");
        ((StringBuilder)localObject1).append(paramVarArgs[0]);
        QLog.w("QzoneWebViewOfflinePlugin", 1, ((StringBuilder)localObject1).toString(), localException);
        paramVarArgs = new WebSoCgiService.WebSoCgiState();
        paramVarArgs.b = localCgiReqInfo.a;
        paramVarArgs.e = 3;
        paramVarArgs.i = 101;
        paramVarArgs.j = localException.getMessage();
        paramVarArgs.h = localCgiReqInfo.f;
        notifyCgiStatus(paramVarArgs, localCgiReqInfo.f);
        return;
      }
    }
    QLog.d("QzoneWebViewOfflinePlugin", 1, "QzoneData.handleWnsCgi args is empty");
  }
  
  public static boolean isUrlHostEqual(String paramString1, String paramString2)
  {
    return TextUtils.equals(getUrlHost(paramString1), getUrlHost(paramString2));
  }
  
  private void jsCallback(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean)
      {
        paramString1 = QzoneZipCacheHelper.getFolderFileNameList(paramString1, paramString2);
        paramString2 = new JSONArray();
        if (paramString1 != null)
        {
          int j = paramString1.length;
          int i = 0;
          while (i < j)
          {
            paramString2.put(paramString1[i]);
            i += 1;
          }
        }
        localJSONObject.put("imageNameList", paramString2);
      }
      callJs(paramString3, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("QzoneData.offlineResourceIsCached callback :");
        paramString1.append(localJSONObject.toString());
        QLog.i("QzoneWebViewOfflinePlugin", 2, paramString1.toString());
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static String json2UrlEncoded(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        localStringBuilder.append(URLEncoder.encode(str1, "UTF-8"));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
        localStringBuilder.append("&");
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      return localStringBuilder.toString();
    }
    catch (Exception paramJSONObject)
    {
      label106:
      break label106;
    }
    return null;
  }
  
  private void notifyCgiStatus(WebSoCgiService.WebSoCgiState paramWebSoCgiState, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramWebSoCgiState == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state is ");
    ((StringBuilder)localObject).append(paramWebSoCgiState);
    QLog.i("QzoneWebViewOfflinePlugin", 1, ((StringBuilder)localObject).toString());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = paramWebSoCgiState.e;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              localJSONObject.put("status", 100);
            }
          }
          else {
            localJSONObject.put("status", 1);
          }
        }
        else {
          localJSONObject.put("status", 4);
        }
      }
      else {
        localJSONObject.put("status", 2);
      }
      if (!TextUtils.isEmpty(paramWebSoCgiState.b)) {
        localJSONObject.put("url", paramWebSoCgiState.b);
      }
      localJSONObject.put("code", paramWebSoCgiState.i);
      if (!TextUtils.isEmpty(paramWebSoCgiState.j)) {
        localJSONObject.put("msg", paramWebSoCgiState.j);
      }
      localJSONObject.put("dataIsBase64", paramWebSoCgiState.g);
      boolean bool = TextUtils.isEmpty(paramWebSoCgiState.d);
      if (!bool)
      {
        if (paramWebSoCgiState.g) {
          localObject = Base64Util.encodeToString(paramWebSoCgiState.d.getBytes(), 0);
        } else {
          localObject = paramWebSoCgiState.d;
        }
        localJSONObject.put("data", localObject);
      }
      else
      {
        localJSONObject.put("data", "");
      }
      if (paramWebSoCgiState.f > 0) {
        localJSONObject.put("httpStatusCode", paramWebSoCgiState.f);
      }
      if (!TextUtils.isEmpty(paramWebSoCgiState.c)) {
        localJSONObject.put("header", new JSONObject(paramWebSoCgiState.c));
      }
      if (paramWebSoCgiState.k != null) {
        localJSONObject.put("userinfo", paramWebSoCgiState.k);
      }
      callJs(paramString, new String[] { localJSONObject.toString() });
      long l1 = System.currentTimeMillis();
      long l2 = paramWebSoCgiState.n;
      paramString = new StringBuilder();
      paramString.append("wnscgi@ status=");
      paramString.append(paramWebSoCgiState.e);
      paramString.append(",total cost ");
      paramString.append(l1 - l2);
      paramString.append(" ms");
      QLog.i("QzoneWebViewOfflinePlugin", 1, paramString.toString());
      return;
    }
    catch (Exception paramWebSoCgiState)
    {
      paramWebSoCgiState.printStackTrace();
    }
  }
  
  private Object shouldInterceptRequest(String paramString)
  {
    Object localObject = this.mRuntime;
    CustomWebView localCustomWebView = null;
    if (localObject != null) {
      localObject = this.mRuntime.d();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((Activity)localObject).getIntent();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("url");
    } else {
      localObject = null;
    }
    AppInterface localAppInterface;
    if (this.mRuntime != null) {
      localAppInterface = this.mRuntime.b();
    } else {
      localAppInterface = null;
    }
    if (this.mRuntime != null) {
      localCustomWebView = this.mRuntime.a();
    }
    return QzoneOfflinePluginJsForQQ.shouldInterceptRequest(localAppInterface, localCustomWebView, paramString, (String)localObject);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L)
    {
      if (this.mRuntime != null)
      {
        QzoneOfflinePluginJsForQQ.mWebView = new WeakReference(this.mRuntime.a());
        QzoneOfflinePluginJsForQQ.mActivity = new WeakReference(this.mRuntime.d());
      }
      return shouldInterceptRequest(paramString);
    }
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QzoneData".equals(paramString2)) {
      return false;
    }
    if ("offlineResourceIsCached".equalsIgnoreCase(paramString3))
    {
      handleCheckOfflineCache(paramVarArgs);
      return true;
    }
    if ("wnsCgi".equalsIgnoreCase(paramString3))
    {
      handleWnsCgi(paramVarArgs);
      return true;
    }
    if ("PreDownloadZip".equalsIgnoreCase(paramString3))
    {
      handlePreDownloadZip(paramVarArgs);
      return true;
    }
    if (("offlineHttpProxy".equals(paramString3)) && (paramVarArgs.length == 1))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ((paramJsBridgeListener.has("proxyUrl")) && (paramJsBridgeListener.has("isCheckCache")))
        {
          this.proxyUrl = paramJsBridgeListener.optString("proxyUrl");
          boolean bool = paramJsBridgeListener.getBoolean("isCheckCache");
          this.callback = paramJsBridgeListener.getString("callback");
          if ((bool) && (!TextUtils.isEmpty(WebSoUtils.h(this.proxyUrl))))
          {
            if (TextUtils.isEmpty(this.callback)) {
              break label291;
            }
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append(this.callback);
            paramJsBridgeListener.append("({\"code\":0});");
            callJs(paramJsBridgeListener.toString());
            return true;
          }
          if (this.preloadHandler == null) {
            this.preloadHandler = new QzoneWebViewOfflinePlugin.1(this, Looper.getMainLooper());
          }
          WebSoService.a().a(this.proxyUrl, this.preloadHandler);
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("exception =");
          paramString1.append(paramJsBridgeListener);
          QLog.d("QzoneWebViewOfflinePlugin", 2, paramString1.toString());
        }
      }
      return true;
    }
    else
    {
      return false;
    }
    label291:
    return true;
  }
  
  protected void onCgiRsp(WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    notifyCgiStatus(paramWebSoCgiState, paramWebSoCgiState.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class WebViewPlugin
{
  public static final String KEY_ERROR_CODE = "errorCode";
  public static final String KEY_PERFORMANCE = "performanceData";
  public static final String KEY_REQUEST = "requestData";
  public static final String KEY_RESPONSE = "responseData";
  public static final String KEY_TARGET = "target";
  public static final String KEY_URL = "url";
  public static final int RECODE_FAILED_FREQUENCY_LIMIT = 5;
  public static final int RECODE_FAILED_NATIVE_ERROR = -100;
  public static final int RECODE_FAILED_NO_SUCH_METHOD = 3;
  public static final int RECODE_FAILED_PARAMS_ERROR = 4;
  public static final int RECODE_FAILED_PERMISSION_DENIED = 1;
  public static final int RECODE_FAILED_TOKEN_VERIFY_TIME_OUT = 2;
  public static final int RECODE_SUCCESSED = 0;
  public static final int TARGET_LEFT_VIEW = 1;
  public static final int TARGET_NAV_BACK = 2;
  public static final int TARGET_SYS_BACK = 3;
  public final String TAG = getClass().getSimpleName();
  AtomicBoolean inited = new AtomicBoolean(false);
  public boolean isDestroy = false;
  public HashMap<String, JsBridgeListener> mOpenApiListeners;
  public String mPluginNameSpace = "";
  public WebViewPlugin.PluginRuntime mRuntime;
  public long pluginEventFlag = 0L;
  
  public static JSONObject getJsonFromJSBridge(String paramString)
  {
    try
    {
      int i = paramString.indexOf("=");
      if (i != -1)
      {
        i += 1;
        if (i <= paramString.length() - 1) {
          return new JSONObject(URLDecoder.decode(paramString.substring(i), "UTF-8"));
        }
      }
      throw new Exception("illegal json");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getJsonFromJSBridge error!");
      localStringBuilder.append(paramString);
      QLog.e("WebViewPlugin", 1, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  public static String toJsScript(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("window.mqq && mqq.execEventCallback && mqq.execEventCallback(");
    localStringBuilder.append(Util.a(paramString));
    localStringBuilder.append(",");
    localStringBuilder.append(String.valueOf(paramJSONObject1));
    localStringBuilder.append(",");
    localStringBuilder.append(String.valueOf(paramJSONObject2));
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public void addOpenApiListenerIfNeeded(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a))
    {
      if (this.mOpenApiListeners == null) {
        this.mOpenApiListeners = new HashMap();
      }
      this.mOpenApiListeners.put(paramString, paramJsBridgeListener);
    }
  }
  
  final void bindWebViewProvider(WebViewProvider paramWebViewProvider)
  {
    WebViewPlugin.PluginRuntime localPluginRuntime = this.mRuntime;
    if (localPluginRuntime != null)
    {
      localPluginRuntime.a(paramWebViewProvider);
      return;
    }
    throw new IllegalArgumentException("plugin runtime must be init");
  }
  
  @Deprecated
  public void callJs(String paramString)
  {
    if (this.isDestroy) {
      return;
    }
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((CustomWebView)localObject).callJs(paramString);
    }
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (this.isDestroy) {
      return;
    }
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((CustomWebView)localObject).callJs(paramString, paramVarArgs);
    }
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String paramString)
  {
    if (this.isDestroy) {
      return;
    }
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((CustomWebView)localObject).callJs4OpenApi(paramJsBridgeListener, paramInt, new String[] { paramString });
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString, int paramInt, Object paramObject)
  {
    Object localObject = this.mOpenApiListeners;
    boolean bool;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString), paramInt, JsBridgeListener.a(paramInt, paramObject, null));
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append(this.TAG);
      paramObject.append(".troop.openapi");
      paramObject = paramObject.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callJs4OpenApiIfNeeded, methodName:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("| callJs4OpenApi:");
      ((StringBuilder)localObject).append(bool);
      QLog.d(paramObject, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void callJs4OpenApiIfNeeded(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = this.mOpenApiListeners;
    boolean bool;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      callJs4OpenApi((JsBridgeListener)this.mOpenApiListeners.remove(paramString1), paramInt, JsBridgeListener.a(paramInt, null, paramString2));
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(this.TAG);
      paramString2.append(".troop.openapi");
      paramString2 = paramString2.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callJs4OpenApiIfNeeded, methodName:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("| callJs4OpenApi:");
      ((StringBuilder)localObject).append(bool);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void dispatchJsEvent(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    callJs(toJsScript(paramString, paramJSONObject1, paramJSONObject2));
  }
  
  public final <T> T getBrowserComponent(int paramInt)
  {
    Object localObject = this.mRuntime;
    if (localObject != null)
    {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
      if (localObject != null) {
        return ((WebViewProvider)localObject).getComponentProvider().a(paramInt);
      }
      if ((this.mRuntime.a() instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        return ((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)this.mRuntime.a()).getComponentProvider().a(paramInt);
      }
    }
    return null;
  }
  
  public int getRequestCode(byte paramByte)
  {
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a(((WebViewPlugin.PluginRuntime)localObject).a());
    } else {
      localObject = null;
    }
    if ((localObject instanceof WebViewPluginContainer)) {
      return ((WebViewPluginContainer)localObject).switchRequestCode(this, paramByte);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
    return -1;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 0L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 0L;
  }
  
  public int getWebViewSchemaListIndex()
  {
    return -1;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    return null;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return false;
  }
  
  final void initRuntime(Activity paramActivity, AppRuntime paramAppRuntime)
  {
    if (this.inited.compareAndSet(false, true)) {
      this.mRuntime = new WebViewPlugin.PluginRuntime(paramActivity, paramAppRuntime);
    }
  }
  
  protected void onActivityReady() {}
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void onAppRuntimeReady(AppRuntime paramAppRuntime) {}
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    this.isDestroy = true;
    HashMap localHashMap = this.mOpenApiListeners;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected void onPostPluginAsyncTask() {}
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView != null)
    {
      WebViewPlugin.PluginRuntime localPluginRuntime = this.mRuntime;
      if (localPluginRuntime != null) {
        localPluginRuntime.a = new WeakReference(paramCustomWebView);
      }
    }
  }
  
  public void postPluginAsyncTask(Runnable paramRunnable)
  {
    ThreadManager.post(paramRunnable, 5, new WebViewPlugin.1(this), false);
  }
  
  public WebViewPlugin setHandler(Handler paramHandler)
  {
    return this;
  }
  
  public void setWebUiInterface(WebUiBaseInterface paramWebUiBaseInterface)
  {
    if (paramWebUiBaseInterface != null) {
      this.mRuntime.a(paramWebUiBaseInterface);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    Object localObject = this.mRuntime;
    Activity localActivity = null;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a(((WebViewPlugin.PluginRuntime)localObject).a());
    } else {
      localObject = null;
    }
    WebViewPlugin.PluginRuntime localPluginRuntime = this.mRuntime;
    if (localPluginRuntime != null) {
      localActivity = localPluginRuntime.a();
    }
    if ((localObject instanceof WebViewPluginContainer))
    {
      ((WebViewPluginContainer)localObject).pluginStartActivityForResult(this, paramIntent, paramByte);
      return;
    }
    if ((localActivity instanceof WebViewPluginContainer))
    {
      ((WebViewPluginContainer)localActivity).pluginStartActivityForResult(this, paramIntent, paramByte);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.TAG, 4, "startActivityForResult not called, activity need implement Interface WebViewPluginContainer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPlugin
 * JD-Core Version:    0.7.0.1
 */
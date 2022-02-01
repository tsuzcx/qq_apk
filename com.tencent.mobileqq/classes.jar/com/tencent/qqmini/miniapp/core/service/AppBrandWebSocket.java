package com.tencent.qqmini.miniapp.core.service;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandWebSocket
  extends AppBrandBaseWebSocket
{
  public static final String TAG = "AppBrandRemoteService";
  public static AtomicInteger sWebSocketRequestId = new AtomicInteger();
  private AtomicInteger count = new AtomicInteger();
  private boolean hasEnterRoom = false;
  private boolean hasSetupContext = false;
  private boolean hasSetupContextResult = false;
  public Map<Long, ValueCallback> jsCallBackMap = new HashMap();
  private ApkgInfo mApkgInfo;
  private EmbeddedState mEmbeddedState = null;
  private ConcurrentLinkedQueue<AppBrandWebSocket.EvaluateData> mEvaluateDatas = new ConcurrentLinkedQueue();
  private AbsAppBrandService mJsRutime;
  private AppBrandRemoteService.OnLoadServiceWebvieJsListener mServiceInitFinishListener;
  protected Handler mThreadHandler;
  private AtomicInteger pingcount = new AtomicInteger();
  private AtomicInteger scriptId = new AtomicInteger();
  private ServiceEventListener serviceEventListener;
  private boolean startPing = false;
  
  public AppBrandWebSocket(IMiniAppContext paramIMiniAppContext, Handler paramHandler, AbsAppBrandService paramAbsAppBrandService)
  {
    this.mThreadHandler = paramHandler;
    this.mJsRutime = paramAbsAppBrandService;
    this.miniAppContext = paramIMiniAppContext;
    this.mTaskId = sWebSocketRequestId.getAndIncrement();
    this.mListener = new AppBrandWebSocket.1(this);
  }
  
  private void debugMessageCallInterface(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    ((JSONObject)localObject).getString("name");
    String str1 = ((JSONObject)localObject).getString("method");
    paramJSONObject = new JSONArray(((JSONObject)localObject).getString("args"));
    long l = ((JSONObject)localObject).getLong("call_id");
    if ("publishHandler".equals(str1))
    {
      str1 = paramJSONObject.getString(0);
      String str2 = paramJSONObject.getString(1);
      localObject = paramJSONObject.getString(2);
      paramJSONObject = (JSONObject)localObject;
      if ("[]".equals(localObject)) {
        paramJSONObject = "";
      }
      localObject = this.serviceEventListener;
      if (localObject != null)
      {
        ((ServiceEventListener)localObject).onServiceEvent(str1, str2, jsStringToJavaIntArray(paramJSONObject));
        sendCallInterfaceResultCmd(l, "");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("--- send callinterfaceResult   publishHandler: ");
        paramJSONObject.append(l);
        QMLog.d("AppBrandRemoteService", paramJSONObject.toString());
      }
    }
    else if ("invokeHandler".equals(str1))
    {
      localObject = paramJSONObject.getString(0);
      str1 = paramJSONObject.getString(1);
      int i = paramJSONObject.getInt(2);
      paramJSONObject = this.serviceEventListener;
      if (paramJSONObject != null)
      {
        sendCallInterfaceResultCmd(l, paramJSONObject.onServiceNativeRequest((String)localObject, str1, i));
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("--- send callinterfaceResult   invokeHandler: ");
        paramJSONObject.append(l);
        QMLog.d("AppBrandRemoteService", paramJSONObject.toString());
      }
    }
  }
  
  private void debugMessageDomOp(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).getString("params");
    int i = ((JSONObject)localObject).getInt("webview_id");
    localObject = this.serviceEventListener;
    if (localObject != null) {
      ((ServiceEventListener)localObject).onServiceEvent("remoteDebugCommand", paramJSONObject, new int[] { i });
    }
  }
  
  private void debugMessageEvaluateJavascriptResult(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).getString("ret");
    long l = ((JSONObject)localObject).getLong("evaluate_id");
    if (this.jsCallBackMap.containsKey(Long.valueOf(l)))
    {
      localObject = (ValueCallback)this.jsCallBackMap.get(Long.valueOf(l));
      if (localObject != null) {
        ((ValueCallback)localObject).onReceiveValue(paramJSONObject);
      }
      this.jsCallBackMap.remove(Long.valueOf(l));
    }
  }
  
  private void debugMessageSetupContextResult(JSONObject paramJSONObject)
  {
    this.hasSetupContextResult = true;
    while (!this.mEvaluateDatas.isEmpty())
    {
      paramJSONObject = (AppBrandWebSocket.EvaluateData)this.mEvaluateDatas.poll();
      if (paramJSONObject != null) {
        evaluateJsEx(paramJSONObject.js, paramJSONObject.valueCallback);
      }
    }
    paramJSONObject = this.mServiceInitFinishListener;
    if (paramJSONObject != null) {
      paramJSONObject.onLoadFinish();
    }
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label67:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label67;
      }
    }
  }
  
  private void processDebugMesage(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("debug_message");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
      sendArkCmd(localJSONObject.getLong("seq"));
      String str = localJSONObject.getString("category");
      if (str.equals("evaluateJavascriptResult")) {
        debugMessageEvaluateJavascriptResult(localJSONObject);
      } else if (str.equals("callInterface")) {
        debugMessageCallInterface(localJSONObject);
      } else if (str.equals("domOp")) {
        debugMessageDomOp(localJSONObject);
      } else if (str.equals("setupContextResult")) {
        debugMessageSetupContextResult(localJSONObject);
      } else if (str.equals("breakpoint")) {
        if (localJSONObject.getJSONObject("data").getInt("is_hit") == 0) {
          AppStateEvent.obtain(101).notifyRuntime(this.miniAppContext);
        } else {
          AppStateEvent.obtain(100).notifyRuntime(this.miniAppContext);
        }
      }
      i += 1;
    }
  }
  
  private void processSocketMessage(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("code");
    if ((!str.equals("0002")) && (!str.equals("0004")))
    {
      if (str.equals("1002"))
      {
        QMLog.d("AppBrandRemoteService", "enter room failed ");
        ProcessUtil.exitProcess(this.miniAppContext);
      }
    }
    else
    {
      paramJSONObject.getString("sessionId");
      this.hasEnterRoom = true;
      sendSetupContextCmd(this.mServiceInitFinishListener);
      evaluateJs("WeixinJSBridge.subscribeHandler('onWxConfigReady');", null);
    }
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    if (this.hasSetupContextResult)
    {
      while (!this.mEvaluateDatas.isEmpty())
      {
        AppBrandWebSocket.EvaluateData localEvaluateData = (AppBrandWebSocket.EvaluateData)this.mEvaluateDatas.poll();
        if (localEvaluateData != null) {
          evaluateJsEx(localEvaluateData.js, localEvaluateData.valueCallback);
        }
      }
      evaluateJsEx(paramString, paramValueCallback);
      return;
    }
    this.mEvaluateDatas.add(new AppBrandWebSocket.EvaluateData(this, paramString, paramValueCallback));
  }
  
  public void evaluateJsEx(String paramString, ValueCallback paramValueCallback)
  {
    long l = getScriptId();
    sendStringMessage(getSendCmdString("DebugMessageClient", "evaluateJavascript", getEvaluateSCriptData(paramString, l)));
    if (paramValueCallback != null) {
      this.jsCallBackMap.put(Long.valueOf(l), paramValueCallback);
    }
  }
  
  public JSONObject getCallInterfaceResultData(long paramLong, String paramString)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("call_id", paramLong);
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        ((JSONObject)localObject).put("ret", "{}");
        return localObject;
      }
      ((JSONObject)localObject).put("ret", paramString);
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCallInterfaceResultData error:");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("AppBrandRemoteService", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String getDefaultConfigScript()
  {
    try
    {
      Object localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("appId", this.mApkgInfo.appId);
      ((JSONObject)localObject3).put("icon", this.mApkgInfo.iconUrl);
      ((JSONObject)localObject3).put("nickname", this.mApkgInfo.apkgName);
      Object localObject4 = new JSONObject(this.mApkgInfo.mConfigStr);
      ((JSONObject)localObject4).put("appContactInfo", new JSONObject("{'operationInfo':{'jsonInfo':{'apiAvailable':{'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0}}}}"));
      ((JSONObject)localObject4).remove("preload");
      Object localObject2 = "release";
      Object localObject1 = localObject2;
      if (this.miniAppContext != null)
      {
        localObject1 = localObject2;
        if (this.miniAppContext.getMiniAppInfo() != null) {
          localObject1 = this.miniAppContext.getMiniAppInfo().getVerTypeStr();
        }
      }
      localObject2 = QUAUtil.getPlatformQUA();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s'); __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.envVersion='");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("';__qqConfig.QUA='");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("';var __wxIndexPage = 'page/index/index.html';");
      localObject2 = String.format(localStringBuilder.toString(), new Object[] { ((JSONObject)localObject4).toString(), ((JSONObject)localObject3).toString() });
      localObject3 = StorageUtil.getPreference();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.miniAppContext.getMiniAppInfo().appId);
      ((StringBuilder)localObject4).append("_debug");
      localObject1 = localObject2;
      if (Boolean.valueOf(((SharedPreferences)localObject3).getBoolean(((StringBuilder)localObject4).toString(), false)).booleanValue())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("__qqConfig.debug =true;");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.mEmbeddedState != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("__qqConfig.useXWebVideo=");
        ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedVideo());
        ((StringBuilder)localObject2).append(";");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("x5 service enableEmbeddedVideo : ");
        ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedVideo());
        QMLog.d("miniapp-embedded", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("__qqConfig.useXWebLive=");
        ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedLive());
        ((StringBuilder)localObject2).append(";");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("x5 service enableEmbeddedLive : ");
        ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedLive());
        QMLog.d("miniapp-embedded", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("__qqConfig.useXWebElement=");
        ((StringBuilder)localObject2).append(this.mEmbeddedState.isEnableEmbeddedElement());
        ((StringBuilder)localObject2).append(";");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("x5 service enableEmbeddedElement : ");
        ((StringBuilder)localObject1).append(this.mEmbeddedState.isEnableEmbeddedElement());
        QMLog.d("miniapp-embedded", ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};");
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public JSONObject getDeviceInfo()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("device_name", Build.DEVICE);
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.SDK_INT);
      localJSONObject.put("qq_version", "8.3.6");
      localJSONObject.put("pixel_ratio", "3");
      localJSONObject.put("screen_width", ViewUtils.getScreenWidth());
      localJSONObject.put("publib", this.miniAppContext.getBaseLibVersion());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QMLog.e("AppBrandRemoteService", "getDeviceInfo error:", localException);
    }
    return null;
  }
  
  public JSONObject getDomEventData(String paramString, int paramInt)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("params", paramString);
      ((JSONObject)localObject).put("webview_id", paramInt);
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDomEventData error:");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("AppBrandRemoteService", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public JSONObject getEvaluateSCriptData(String paramString, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("script", paramString);
      localJSONObject.put("evaluate_id", paramLong);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QMLog.e("AppBrandRemoteService", "getEvaluateSCriptData error:", paramString);
    }
    return null;
  }
  
  int getNetworkType()
  {
    int j = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
    if (j == 5) {
      return 1;
    }
    if (j == 1) {
      return 5;
    }
    int i = j;
    if (j != 2)
    {
      i = j;
      if (j != 3)
      {
        if (j == 4) {
          return j;
        }
        i = 0;
      }
    }
    return i;
  }
  
  public int getPingCount()
  {
    return this.pingcount.incrementAndGet();
  }
  
  public int getScriptId()
  {
    return this.scriptId.incrementAndGet();
  }
  
  public String getSendCmdString(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("seq", getSeq());
      localJSONObject.put("category", paramString2);
      localJSONObject.put("data", paramJSONObject);
      localJSONObject.put("compress_algo", 0);
      localJSONObject.put("original_size", 0);
      localJSONObject.put("delay", 0);
      paramString2 = new JSONArray();
      paramString2.put(localJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("debug_message", paramString2);
      paramString2 = new JSONObject();
      paramString2.put("cmd", paramString1);
      paramString2.put("data", paramJSONObject);
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("send Cmd error: ");
      paramString2.append(paramString1);
      QMLog.d("AppBrandRemoteService", paramString2.toString());
    }
    return "";
  }
  
  public int getSeq()
  {
    return this.count.incrementAndGet();
  }
  
  public JSONObject getSetupContexData()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("configure_js", getDefaultConfigScript());
      localJSONObject.put("device_info", getDeviceInfo());
      localJSONObject.put("support_compress_algo", 0);
      localJSONObject.put("publib_ver", this.miniAppContext.getBaseLibVersion());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSetupContexData error:");
      localStringBuilder.append(localException);
      QMLog.d("AppBrandRemoteService", localStringBuilder.toString());
    }
    return null;
  }
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState)
  {
    this.mEmbeddedState = paramEmbeddedState;
  }
  
  protected void processMessage(String paramString)
  {
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("cmd");
      localObject = ((JSONObject)localObject).getJSONObject("data");
      if (paramString.equals("DebugPing"))
      {
        sendPongCmd(((JSONObject)localObject).getLong("ping_id"));
        return;
      }
      if (paramString.equals("SocketMessage"))
      {
        processSocketMessage((JSONObject)localObject);
        return;
      }
      if (paramString.equals("DebugMessageMaster"))
      {
        processDebugMesage((JSONObject)localObject);
        return;
      }
      paramString.equals("DebugArkMaster");
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cmd error: ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.e("AppBrandRemoteService", ((StringBuilder)localObject).toString());
    }
  }
  
  public void sendArkCmd(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"cmd\":\"DebugArkClient\",\"data\":{\"ark_message\":[{\"ark\":");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("}]}}");
    sendStringMessage(localStringBuilder.toString());
  }
  
  public void sendCallInterfaceResultCmd(long paramLong, String paramString)
  {
    sendStringMessage(getSendCmdString("DebugMessageClient", "callInterfaceResult", getCallInterfaceResultData(paramLong, paramString)));
  }
  
  public void sendDomEvent(String paramString, int paramInt)
  {
    sendStringMessage(getSendCmdString("DebugMessageClient", "domEvent", getDomEventData(paramString, paramInt)));
  }
  
  public void sendPingCmd(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" }}");
    sendStringMessage(localStringBuilder.toString());
  }
  
  public void sendPongCmd(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",\"network_type\":");
    localStringBuilder.append(getNetworkType());
    localStringBuilder.append(" }}");
    sendStringMessage(localStringBuilder.toString());
  }
  
  public void sendSetupContextCmd(AppBrandRemoteService.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener)
  {
    if (this.hasEnterRoom)
    {
      if ((!this.hasSetupContext) && (this.mApkgInfo != null))
      {
        sendStringMessage(getSendCmdString("DebugMessageClient", "setupContext", getSetupContexData()));
        this.hasSetupContext = true;
      }
      if (paramOnLoadServiceWebvieJsListener != null)
      {
        this.mServiceInitFinishListener = paramOnLoadServiceWebvieJsListener;
        if (this.hasSetupContextResult)
        {
          paramOnLoadServiceWebvieJsListener = this.mServiceInitFinishListener;
          if (paramOnLoadServiceWebvieJsListener != null) {
            paramOnLoadServiceWebvieJsListener.onLoadFinish();
          }
        }
      }
    }
    else
    {
      this.mServiceInitFinishListener = paramOnLoadServiceWebvieJsListener;
    }
  }
  
  public void setApkgInfo(ApkgInfo paramApkgInfo)
  {
    this.mApkgInfo = paramApkgInfo;
  }
  
  public void setServiceEventListener(ServiceEventListener paramServiceEventListener)
  {
    this.serviceEventListener = paramServiceEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket
 * JD-Core Version:    0.7.0.1
 */
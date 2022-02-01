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
      if (this.serviceEventListener != null)
      {
        this.serviceEventListener.onServiceEvent(str1, str2, jsStringToJavaIntArray(paramJSONObject));
        sendCallInterfaceResultCmd(l, "");
        QMLog.d("AppBrandRemoteService", "--- send callinterfaceResult   publishHandler: " + l);
      }
    }
    int i;
    do
    {
      do
      {
        return;
      } while (!"invokeHandler".equals(str1));
      localObject = paramJSONObject.getString(0);
      str1 = paramJSONObject.getString(1);
      i = paramJSONObject.getInt(2);
    } while (this.serviceEventListener == null);
    sendCallInterfaceResultCmd(l, this.serviceEventListener.onServiceNativeRequest((String)localObject, str1, i));
    QMLog.d("AppBrandRemoteService", "--- send callinterfaceResult   invokeHandler: " + l);
  }
  
  private void debugMessageDomOp(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    String str = paramJSONObject.getString("params");
    int i = paramJSONObject.getInt("webview_id");
    if (this.serviceEventListener != null) {
      this.serviceEventListener.onServiceEvent("remoteDebugCommand", str, new int[] { i });
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
    if (this.mServiceInitFinishListener != null) {
      this.mServiceInitFinishListener.onLoadFinish();
    }
  }
  
  public static int[] jsStringToJavaIntArray(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
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
        label65:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label65;
      }
    }
  }
  
  private void processDebugMesage(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONArray("debug_message");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
      sendArkCmd(localJSONObject.getLong("seq"));
      String str = localJSONObject.getString("category");
      if (str.equals("evaluateJavascriptResult")) {
        debugMessageEvaluateJavascriptResult(localJSONObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.equals("callInterface")) {
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
      }
    }
  }
  
  private void processSocketMessage(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("code");
    if ((str.equals("0002")) || (str.equals("0004")))
    {
      paramJSONObject.getString("sessionId");
      this.hasEnterRoom = true;
      sendSetupContextCmd(this.mServiceInitFinishListener);
      evaluateJs("WeixinJSBridge.subscribeHandler('onWxConfigReady');", null);
    }
    while (!str.equals("1002")) {
      return;
    }
    QMLog.d("AppBrandRemoteService", "enter room failed ");
    ProcessUtil.exitProcess(this.miniAppContext);
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("call_id", paramLong);
      if (TextUtils.isEmpty(paramString))
      {
        localJSONObject.put("ret", "{}");
        return localJSONObject;
      }
      localJSONObject.put("ret", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QMLog.d("AppBrandRemoteService", "getCallInterfaceResultData error:" + paramString);
    }
    return null;
  }
  
  public String getDefaultConfigScript()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("appId", this.mApkgInfo.appId);
      localJSONObject1.put("icon", this.mApkgInfo.iconUrl);
      localJSONObject1.put("nickname", this.mApkgInfo.apkgName);
      JSONObject localJSONObject2 = new JSONObject(this.mApkgInfo.mConfigStr);
      localJSONObject2.put("appContactInfo", new JSONObject("{'operationInfo':{'jsonInfo':{'apiAvailable':{'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0}}}}"));
      localJSONObject2.remove("preload");
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
      localObject2 = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s'); __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.envVersion='" + (String)localObject1 + "';__qqConfig.QUA='" + (String)localObject2 + "';var __wxIndexPage = 'page/index/index.html';", new Object[] { localJSONObject2.toString(), localJSONObject1.toString() });
      localObject1 = localObject2;
      if (Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.miniAppContext.getMiniAppInfo().appId + "_debug", false)).booleanValue()) {
        localObject1 = (String)localObject2 + "__qqConfig.debug =true;";
      }
      localObject2 = localObject1;
      if (this.mEmbeddedState != null)
      {
        localObject1 = (String)localObject1 + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";";
        QMLog.d("miniapp-embedded", "x5 service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
        localObject1 = (String)localObject1 + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";";
        QMLog.d("miniapp-embedded", "x5 service enableEmbeddedLive : " + this.mEmbeddedState.isEnableEmbeddedLive());
        localObject2 = (String)localObject1 + "__qqConfig.useXWebElement=" + this.mEmbeddedState.isEnableEmbeddedElement() + ";";
        QMLog.d("miniapp-embedded", "x5 service enableEmbeddedElement : " + this.mEmbeddedState.isEnableEmbeddedElement());
      }
      localObject1 = (String)localObject2 + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
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
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("params", paramString);
      localJSONObject.put("webview_id", paramInt);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QMLog.d("AppBrandRemoteService", "getDomEventData error:" + paramString);
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
    int i = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
    if (i == 5) {
      return 1;
    }
    if (i == 1) {
      return 5;
    }
    if ((i == 2) || (i == 3) || (i == 4)) {
      return i;
    }
    return 0;
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
      QMLog.d("AppBrandRemoteService", "send Cmd error: " + paramString1);
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
      QMLog.d("AppBrandRemoteService", "getSetupContexData error:" + localException);
    }
    return null;
  }
  
  public void initEmbeddedState(EmbeddedState paramEmbeddedState)
  {
    this.mEmbeddedState = paramEmbeddedState;
  }
  
  protected void processMessage(String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.getString("cmd");
      localJSONObject = localJSONObject.getJSONObject("data");
      if (paramString.equals("DebugPing"))
      {
        sendPongCmd(localJSONObject.getLong("ping_id"));
        return;
      }
      if (paramString.equals("SocketMessage"))
      {
        processSocketMessage(localJSONObject);
        return;
      }
    }
    catch (Exception paramString)
    {
      QMLog.e("AppBrandRemoteService", "cmd error: " + paramString);
      return;
    }
    if (paramString.equals("DebugMessageMaster"))
    {
      processDebugMesage(localJSONObject);
      return;
    }
    boolean bool = paramString.equals("DebugArkMaster");
    if (bool) {}
  }
  
  public void sendArkCmd(long paramLong)
  {
    sendStringMessage("{\"cmd\":\"DebugArkClient\",\"data\":{\"ark_message\":[{\"ark\":" + paramLong + "}]}}");
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
    sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + paramLong + " }}");
  }
  
  public void sendPongCmd(long paramLong)
  {
    sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + paramLong + ",\"network_type\":" + getNetworkType() + " }}");
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
        if ((this.hasSetupContextResult) && (this.mServiceInitFinishListener != null)) {
          this.mServiceInitFinishListener.onLoadFinish();
        }
      }
      return;
    }
    this.mServiceInitFinishListener = paramOnLoadServiceWebvieJsListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.minigame.debug;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQDebugWebSocket
  extends DebugWebSocket
  implements InspectorAgent
{
  private static final String DISCONNECT_TIPS = "真机调试断开连接";
  private static final String DISCONNECT_TIPS_NOT_RECOVERY = "真机调试断开连接，请退出重试";
  private static final String RECONNECT_TIPS = "真机调试断线重连...";
  private AtomicInteger count = new AtomicInteger();
  private MiniAppInfo gameInfo;
  Runnable heartbeatRunnable = new QQDebugWebSocket.4(this);
  private boolean isQQDebugReady = false;
  private DebugWebSocket.DebuggerStateListener mDebugListener;
  private InspectorAgent.DebuggerMessageListener mDebuggerMessageListener;
  private IMiniAppContext miniAppContext;
  private DebugWebSocket.DebugSocketListener qqSocketListener = new QQDebugWebSocket.1(this);
  private String sessionId;
  
  public QQDebugWebSocket(IMiniAppContext paramIMiniAppContext, MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppContext = paramIMiniAppContext;
    this.gameInfo = paramMiniAppInfo;
    this.TAG = "[debugger].QQDebugWebSocket";
  }
  
  private String covertProfileToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + paramString + "}]}";
  }
  
  private String covertV8ToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"chromeDevtools\",\"data\":" + paramString + "}]}";
  }
  
  private void dealDebugMessageMaster(String paramString1, String paramString2)
  {
    try
    {
      QMLog.i(this.TAG, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
      paramString1 = new JSONObject(paramString2).getJSONArray("debug_message");
      if ((paramString1 == null) || (paramString1.getJSONObject(0) == null)) {
        return;
      }
      paramString1 = paramString1.getJSONObject(0);
      if (paramString1 == null) {
        return;
      }
      paramString2 = paramString1.getString("category");
      if (TextUtils.equals(paramString2, "chromeDevtools"))
      {
        doChromeDevTools(paramString1);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QMLog.e(this.TAG, "qq onSocketMessage", paramString1);
      return;
    }
    if (TextUtils.equals(paramString2, "performance")) {
      doPerformance(paramString1);
    }
  }
  
  private void dealDebugPing(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("ping_id");
      int i = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
      if (!this.isQQDebugReady)
      {
        sendQQDebugMethodMsg("DebugPong", "{\"ping_id\":" + paramString + ",\"network_type\":" + i + "}");
        this.isQQDebugReady = true;
        notifyIdeSetUp();
        checkDebuggerReady();
      }
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e(this.TAG, "qq onSocketMessage", paramString);
    }
  }
  
  private void dealSocketMessage(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.sessionId = paramString.getString("sessionId");
      if (TextUtils.equals(paramString.getString("code"), "0002")) {
        setCanSendMsg(true);
      }
      return;
    }
    catch (JSONException paramString)
    {
      QMLog.e(this.TAG, "qq onSocketMessage", paramString);
    }
  }
  
  private void dealWithQQMessage(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, "SocketMessage")) {
      dealSocketMessage(paramString2);
    }
    if (TextUtils.equals(paramString1, "DebugArkMaster")) {
      return;
    }
    if (TextUtils.equals(paramString1, "DebugPing"))
    {
      dealDebugPing(paramString2);
      return;
    }
    if (TextUtils.equals(paramString1, "DebugMessageMaster"))
    {
      dealDebugMessageMaster(paramString1, paramString2);
      return;
    }
    QMLog.i(this.TAG, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
  }
  
  private void doChromeDevTools(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("data");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      Object localObject = paramJSONObject.getString("method");
      if ((TextUtils.equals((CharSequence)localObject, "Runtime.evaluate")) || (TextUtils.equals((CharSequence)localObject, "Debugger.evaluateOnCallFrame")))
      {
        localObject = paramJSONObject.getJSONObject("params");
        if (localObject != null)
        {
          ((JSONObject)localObject).remove("timeout");
          paramJSONObject.put("params", localObject);
        }
      }
      this.mDebuggerMessageListener.sendMessageToEngine(paramJSONObject.toString());
    }
  }
  
  private void doPerformance(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getString("data");
    String str;
    int i;
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      str = paramJSONObject.getString("method");
      i = paramJSONObject.getInt("id");
      if (!TextUtils.equals(str, "profile.start")) {
        break label66;
      }
      AppStateEvent.obtain(2056, Integer.valueOf(i)).notifyRuntime(this.miniAppContext);
    }
    label66:
    while (!TextUtils.equals(str, "profile.end")) {
      return;
    }
    AppStateEvent.obtain(2057, Integer.valueOf(i)).notifyRuntime(this.miniAppContext);
  }
  
  private long getAccount()
  {
    String str = LoginManager.getInstance().getAccount();
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  private String getAppVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  private JSONObject getDeviceInfo()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("device_name", Build.DEVICE);
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.SDK_INT);
      localJSONObject.put("qq_version", getAppVersion());
      localJSONObject.put("pixel_ratio", "3");
      localJSONObject.put("screen_width", ViewUtils.getScreenWidth());
      localJSONObject.put("user_agent", "MiniGame");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "getSetupContexString error:" + localException);
    }
    return null;
  }
  
  private JSONObject getSetupContexData()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("configure_js", "");
      localJSONObject.put("device_info", getDeviceInfo());
      localJSONObject.put("support_compress_algo", 0);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "getSetupContexString error:" + localException);
    }
    return null;
  }
  
  private void onQQDebuggerFail(int paramInt)
  {
    setCanSendMsg(false);
    if (paramInt == 1000)
    {
      if (this.mDebugListener != null) {
        this.mDebugListener.onDebuggerDisconnect("真机调试断开连接");
      }
      return;
    }
    if (this.mDebugListener != null) {
      this.mDebugListener.onDebuggerReconnecting("真机调试断线重连...");
    }
    reconnectQQDebugSocket();
  }
  
  private void reconnectQQDebugSocket()
  {
    postDelayed(new QQDebugWebSocket.2(this), 2000L);
  }
  
  private void sendQQDeviceMsgInfo()
  {
    String str = getSendCmdString("DebugMessageClient", "setupContext", getSetupContexData());
    QMLog.i(this.TAG, "sendQQDeviceMsgInfo deviceInfoCmd:" + str);
    sendStringMessage(str);
  }
  
  private void startConnectIDE(DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean)
  {
    post(new QQDebugWebSocket.3(this, paramDebuggerStateListener, paramBoolean));
  }
  
  public void checkDebuggerReady()
  {
    if (this.isQQDebugReady)
    {
      if (this.mDebugListener != null) {
        this.mDebugListener.onDebuggerConnectedNormal();
      }
      sendHeartBeat();
    }
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
      Log.e(this.TAG, "send Cmd error:" + paramString1);
    }
    return "";
  }
  
  public int getSeq()
  {
    return this.count.incrementAndGet();
  }
  
  public void notifyIdeSetUp()
  {
    sendQQDebugMethodMsg("DebugMessageClient", "{\"debug_message\":[{}]}");
    sendQQDeviceMsgInfo();
  }
  
  public void sendHeartBeat()
  {
    sendQQDebugMethodMsg("HeartBeat", "{}");
    postDelayed(this.heartbeatRunnable, 10000L);
  }
  
  public void sendMessageToDebugger(@NonNull String paramString)
  {
    QMLog.i(this.TAG, "v8 onSocketMessage:" + paramString);
    DebugWebSocket.DebuggerStateListener localDebuggerStateListener = this.mDebugListener;
    if ((localDebuggerStateListener != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      String str = new JSONObject(paramString).optString("method");
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.equals(str, "Debugger.paused")) {
          break label93;
        }
        localDebuggerStateListener.onDebuggerBreakPointPaused();
      }
      for (;;)
      {
        sendQQDebugMethodMsg("DebugMessageClient", covertV8ToIdeData(paramString));
        return;
        label93:
        if (TextUtils.equals(str, "Debugger.resumed")) {
          localDebuggerStateListener.onDebuggerConnectedNormal();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e(this.TAG, "v8 onSocketMessage error", localJSONException);
      }
    }
  }
  
  public void sendQQDebugMethodMsg(String paramString1, String paramString2)
  {
    sendStringMessage("{\"cmd\":\"" + paramString1 + "\",\"data\":" + paramString2 + "}");
  }
  
  public void sendQuitDebugMsgInfo()
  {
    sendQQDebugMethodMsg("QuitRoom", "{}");
  }
  
  public void setOnDebuggerMessageListener(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener)
  {
    this.mDebuggerMessageListener = paramDebuggerMessageListener;
  }
  
  public void startConnectIDE(DebugWebSocket.DebuggerStateListener paramDebuggerStateListener)
  {
    startConnectIDE(paramDebuggerStateListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket
 * JD-Core Version:    0.7.0.1
 */
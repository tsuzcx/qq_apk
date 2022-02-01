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
    TAG = "[debugger].QQDebugWebSocket";
  }
  
  private String covertProfileToIdeData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}]}");
    return localStringBuilder.toString();
  }
  
  private String covertV8ToIdeData(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"debug_message\":[{\"seq\":1,\"category\":\"chromeDevtools\",\"data\":");
    localStringBuilder.append(paramString);
    localStringBuilder.append("}]}");
    return localStringBuilder.toString();
  }
  
  private void dealDebugMessageMaster(String paramString1, String paramString2)
  {
    try
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq onSocketMessage cmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",data:");
      localStringBuilder.append(paramString2);
      QMLog.i(str, localStringBuilder.toString());
      paramString1 = new JSONObject(paramString2).getJSONArray("debug_message");
      if ((paramString1 != null) && (paramString1.getJSONObject(0) != null))
      {
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
        if (TextUtils.equals(paramString2, "performance"))
        {
          doPerformance(paramString1);
          return;
        }
      }
    }
    catch (JSONException paramString1)
    {
      QMLog.e(TAG, "qq onSocketMessage", paramString1);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{\"ping_id\":");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",\"network_type\":");
        localStringBuilder.append(i);
        localStringBuilder.append("}");
        sendQQDebugMethodMsg("DebugPong", localStringBuilder.toString());
        this.isQQDebugReady = true;
        notifyIdeSetUp();
        checkDebuggerReady();
        return;
      }
    }
    catch (JSONException paramString)
    {
      QMLog.e(TAG, "qq onSocketMessage", paramString);
    }
  }
  
  private void dealSocketMessage(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.sessionId = paramString.getString("sessionId");
      if (TextUtils.equals(paramString.getString("code"), "0002"))
      {
        setCanSendMsg(true);
        return;
      }
    }
    catch (JSONException paramString)
    {
      QMLog.e(TAG, "qq onSocketMessage", paramString);
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
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq onSocketMessage cmd:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",data:");
    localStringBuilder.append(paramString2);
    QMLog.i(str, localStringBuilder.toString());
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
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      String str = paramJSONObject.getString("method");
      int i = paramJSONObject.getInt("id");
      if (TextUtils.equals(str, "profile.start"))
      {
        AppStateEvent.obtain(2056, Integer.valueOf(i)).notifyRuntime(this.miniAppContext);
        return;
      }
      if (TextUtils.equals(str, "profile.end")) {
        AppStateEvent.obtain(2057, Integer.valueOf(i)).notifyRuntime(this.miniAppContext);
      }
    }
  }
  
  private long getAccount()
  {
    String str = LoginManager.getInstance().getAccount();
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSetupContexString error:");
      localStringBuilder.append(localException);
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSetupContexString error:");
      localStringBuilder.append(localException);
      Log.e(str, localStringBuilder.toString());
    }
    return null;
  }
  
  private void onQQDebuggerFail(int paramInt)
  {
    setCanSendMsg(false);
    DebugWebSocket.DebuggerStateListener localDebuggerStateListener;
    if (paramInt == 1000)
    {
      localDebuggerStateListener = this.mDebugListener;
      if (localDebuggerStateListener != null) {
        localDebuggerStateListener.onDebuggerDisconnect("真机调试断开连接");
      }
    }
    else
    {
      localDebuggerStateListener = this.mDebugListener;
      if (localDebuggerStateListener != null) {
        localDebuggerStateListener.onDebuggerReconnecting("真机调试断线重连...");
      }
      reconnectQQDebugSocket();
    }
  }
  
  private void reconnectQQDebugSocket()
  {
    postDelayed(new QQDebugWebSocket.2(this), 2000L);
  }
  
  private void sendQQDeviceMsgInfo()
  {
    String str1 = getSendCmdString("DebugMessageClient", "setupContext", getSetupContexData());
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendQQDeviceMsgInfo deviceInfoCmd:");
    localStringBuilder.append(str1);
    QMLog.i(str2, localStringBuilder.toString());
    sendStringMessage(str1);
  }
  
  private void startConnectIDE(DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean)
  {
    post(new QQDebugWebSocket.3(this, paramDebuggerStateListener, paramBoolean));
  }
  
  public void checkDebuggerReady()
  {
    if (this.isQQDebugReady)
    {
      DebugWebSocket.DebuggerStateListener localDebuggerStateListener = this.mDebugListener;
      if (localDebuggerStateListener != null) {
        localDebuggerStateListener.onDebuggerConnectedNormal();
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
      paramString2 = TAG;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("send Cmd error:");
      paramJSONObject.append(paramString1);
      Log.e(paramString2, paramJSONObject.toString());
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
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("v8 onSocketMessage:");
    ((StringBuilder)localObject2).append(paramString);
    QMLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.mDebugListener;
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        localObject2 = new JSONObject(paramString).optString("method");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          if (TextUtils.equals((CharSequence)localObject2, "Debugger.paused")) {
            ((DebugWebSocket.DebuggerStateListener)localObject1).onDebuggerBreakPointPaused();
          } else if (TextUtils.equals((CharSequence)localObject2, "Debugger.resumed")) {
            ((DebugWebSocket.DebuggerStateListener)localObject1).onDebuggerConnectedNormal();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e(TAG, "v8 onSocketMessage error", localJSONException);
      }
    }
    sendQQDebugMethodMsg("DebugMessageClient", covertV8ToIdeData(paramString));
  }
  
  public void sendQQDebugMethodMsg(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"cmd\":\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",\"data\":");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("}");
    sendStringMessage(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket
 * JD-Core Version:    0.7.0.1
 */
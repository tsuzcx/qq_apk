package com.tencent.mobileqq.minigame.debug;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import anzj;
import bhtq;
import com.tencent.mobileqq.mini.apkg.DebugInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.InspectorAgent.DebuggerMessageListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQDebugWebSocket
  extends DebugWebSocket
  implements InspectorAgent
{
  private static final String DISCONNECT_TIPS = anzj.a(2131709085);
  private static final String DISCONNECT_TIPS_NOT_RECOVERY = anzj.a(2131709084);
  public static final int NETWORKTYPE_2G = 2;
  public static final int NETWORKTYPE_3G = 3;
  public static final int NETWORKTYPE_4G = 4;
  public static final int NETWORKTYPE_OFFLINE = 0;
  public static final int NETWORKTYPE_OTHER = 1;
  public static final int NETWORKTYPE_WIFI = 6;
  private static final String RECONNECT_TIPS = anzj.a(2131709086);
  private AtomicInteger count = new AtomicInteger();
  Runnable heartbeatRunnable = new QQDebugWebSocket.4(this);
  private boolean isQQDebugReady;
  public QQDebugWebSocket.ProfileJsPlugin jsPlugin;
  private final String mAppId;
  private final DebugInfo mDebugInfo;
  private DebugWebSocket.DebuggerStateListener mDebugListener;
  private InspectorAgent.DebuggerMessageListener mDebuggerMessageListener;
  private DebugWebSocket.DebugSocketListener qqSocketListener = new QQDebugWebSocket.1(this);
  private String sessionId;
  
  public QQDebugWebSocket(String paramString, DebugInfo paramDebugInfo)
  {
    this.mAppId = paramString;
    this.mDebugInfo = paramDebugInfo;
    this.TAG = "[debugger].QQDebugWebSocket";
    this.jsPlugin = new QQDebugWebSocket.ProfileJsPlugin(this);
  }
  
  private String covertProfileToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + paramString + "}]}";
  }
  
  private String covertV8ToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"chromeDevtools\",\"data\":" + paramString + "}]}";
  }
  
  private void dealWithQQMessage(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, "SocketMessage")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      this.sessionId = localJSONObject.getString("sessionId");
      if (TextUtils.equals(localJSONObject.getString("code"), "0002")) {
        setCanSendMsg(true);
      }
      if (TextUtils.equals(paramString1, "DebugArkMaster")) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          QLog.e(this.TAG, 1, "qq onSocketMessage", localJSONException);
          continue;
          if (TextUtils.equals(paramString1, "DebugPing"))
          {
            try
            {
              paramString1 = new JSONObject(paramString2).getString("ping_id");
              int i = getNetworkTypeForMini();
              if (this.isQQDebugReady) {
                continue;
              }
              sendQQDebugMethodMsg("DebugPong", "{\"ping_id\":" + paramString1 + ",\"network_type\":" + i + "}");
              this.isQQDebugReady = true;
              notifyIdeSetUp();
              checkDebuggerReady();
              return;
            }
            catch (JSONException paramString1)
            {
              QLog.e(this.TAG, 1, "qq onSocketMessage", paramString1);
              return;
            }
          }
          else
          {
            if (!TextUtils.equals(paramString1, "DebugMessageMaster")) {
              break label464;
            }
            try
            {
              QLog.i(this.TAG, 1, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
              paramString1 = new JSONObject(paramString2).getJSONArray("debug_message");
              if ((paramString1 != null) && (paramString1.getJSONObject(0) != null))
              {
                paramString1 = paramString1.getJSONObject(0);
                if (paramString1 != null)
                {
                  paramString2 = paramString1.getString("category");
                  if (TextUtils.equals(paramString2, "chromeDevtools"))
                  {
                    paramString1 = paramString1.getString("data");
                    if (TextUtils.isEmpty(paramString1)) {
                      continue;
                    }
                    paramString1 = new JSONObject(paramString1);
                    paramString2 = paramString1.getString("method");
                    if ((TextUtils.equals(paramString2, "Runtime.evaluate")) || (TextUtils.equals(paramString2, "Debugger.evaluateOnCallFrame")))
                    {
                      paramString2 = paramString1.getJSONObject("params");
                      if (paramString2 != null)
                      {
                        paramString2.remove("timeout");
                        paramString1.put("params", paramString2);
                      }
                    }
                    this.mDebuggerMessageListener.sendMessageToEngine(paramString1.toString());
                  }
                }
              }
            }
            catch (JSONException paramString1)
            {
              QLog.e(this.TAG, 1, "qq onSocketMessage", paramString1);
              return;
            }
          }
        }
      } while ((!TextUtils.equals(paramString2, "performance")) || ((this.jsPlugin.jsPluginEngine != null) && (this.jsPlugin.jsPluginEngine.appBrandRuntime != null) && (this.jsPlugin.jsPluginEngine.appBrandRuntime.activity != null) && (GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.jsPlugin.jsPluginEngine.appBrandRuntime.activity) != null)));
      QLog.e(this.TAG, 1, "qq onSocketMessage performance fail, no gameRuntime");
      return;
      label464:
      QLog.i(this.TAG, 1, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
    }
  }
  
  private JSONObject getDeviceInfo()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("device_name", Build.DEVICE);
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.SDK_INT);
      localJSONObject.put("qq_version", "8.4.5");
      localJSONObject.put("pixel_ratio", "3");
      localJSONObject.put("screen_width", bhtq.a());
      localJSONObject.put("user_agent", "MiniGame");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "getSetupContexString error:" + localException);
    }
    return null;
  }
  
  private int getNetworkTypeForMini()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 6;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
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
        this.mDebugListener.onDebuggerDisconnect(DISCONNECT_TIPS);
      }
      return;
    }
    if (this.mDebugListener != null) {
      this.mDebugListener.onDebuggerReconnecting(RECONNECT_TIPS);
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
    QLog.i(this.TAG, 1, "sendQQDeviceMsgInfo deviceInfoCmd:" + str);
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
    QLog.i(this.TAG, 1, "v8 onSocketMessage:" + paramString);
    DebugWebSocket.DebuggerStateListener localDebuggerStateListener = this.mDebugListener;
    if ((localDebuggerStateListener != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      String str = new JSONObject(paramString).optString("method");
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.equals(str, "Debugger.paused")) {
          break label94;
        }
        localDebuggerStateListener.onDebuggerBreakPointPaused();
      }
      for (;;)
      {
        sendQQDebugMethodMsg("DebugMessageClient", covertV8ToIdeData(paramString));
        return;
        label94:
        if (TextUtils.equals(str, "Debugger.resumed")) {
          localDebuggerStateListener.onDebuggerConnectedNormal();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(this.TAG, 1, "v8 onSocketMessage error", localJSONException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.QQDebugWebSocket
 * JD-Core Version:    0.7.0.1
 */
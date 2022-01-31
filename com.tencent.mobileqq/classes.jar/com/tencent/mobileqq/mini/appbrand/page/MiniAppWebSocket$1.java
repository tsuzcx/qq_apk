package com.tencent.mobileqq.mini.appbrand.page;

import android.os.Handler;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.JSUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

class MiniAppWebSocket$1
  extends WebSocketListener
{
  MiniAppWebSocket$1(MiniAppWebSocket paramMiniAppWebSocket) {}
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    QLog.e("ServiceRemoteRuntime", 2, "--onClose:  " + paramString);
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    QLog.e("ServiceRemoteRuntime", 2, "--onFailure: " + paramThrowable);
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    super.onMessage(paramWebSocket, paramString);
    QLog.e("ServiceRemoteRuntime", 2, "--onMessage: " + paramString);
    if (this.this$0.mThreadHandler != null) {
      this.this$0.mThreadHandler.post(new MiniAppWebSocket.1.1(this, paramString));
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    super.onMessage(paramWebSocket, paramByteString);
    QLog.e("ServiceRemoteRuntime", 2, "--onMessage: " + paramByteString.toString());
    if (this.this$0.mThreadHandler != null) {
      this.this$0.mThreadHandler.post(new MiniAppWebSocket.1.2(this, paramByteString));
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.this$0.mWebSocket = paramWebSocket;
  }
  
  protected void processMessage(String paramString)
  {
    Object localObject1;
    long l;
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("cmd");
      localObject1 = ((JSONObject)localObject1).getJSONObject("data");
      if (paramString.equals("DebugPing"))
      {
        l = ((JSONObject)localObject1).getLong("ping_id");
        this.this$0.sendPongCmd(l);
        return;
      }
      if (!paramString.equals("SocketMessage")) {
        break label179;
      }
      paramString = ((JSONObject)localObject1).getString("code");
      if (paramString.equals("0002"))
      {
        ((JSONObject)localObject1).getString("sessionId");
        MiniAppWebSocket.access$002(this.this$0, true);
        this.this$0.sendSetupContextCmd(MiniAppWebSocket.access$100(this.this$0));
        this.this$0.evaluateJs("WeixinJSBridge.subscribeHandler('onWxConfigReady');", null);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ServiceRemoteRuntime", 2, "cmd error: " + paramString);
      return;
    }
    label179:
    int i;
    if (paramString.equals("1002"))
    {
      QLog.e("ServiceRemoteRuntime", 2, "enter room failed ");
      AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().exitProcess();
      return;
      if (paramString.equals("DebugMessageMaster"))
      {
        paramString = ((JSONObject)localObject1).getJSONArray("debug_message");
        i = 0;
      }
    }
    for (;;)
    {
      if (i < paramString.length())
      {
        localObject1 = (JSONObject)paramString.get(i);
        l = ((JSONObject)localObject1).getLong("seq");
        this.this$0.sendArkCmd(l);
        Object localObject2 = ((JSONObject)localObject1).getString("category");
        if (((String)localObject2).equals("evaluateJavascriptResult"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject("data");
          localObject1 = ((JSONObject)localObject2).getString("ret");
          l = ((JSONObject)localObject2).getLong("evaluate_id");
          if (!this.this$0.jsCallBackMap.containsKey(Long.valueOf(l))) {
            break label988;
          }
          localObject2 = (ValueCallback)this.this$0.jsCallBackMap.get(Long.valueOf(l));
          if (localObject2 != null) {
            ((ValueCallback)localObject2).onReceiveValue(localObject1);
          }
          this.this$0.jsCallBackMap.remove(Long.valueOf(l));
          break label988;
        }
        int j;
        if (((String)localObject2).equals("callInterface"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          ((JSONObject)localObject1).getString("name");
          localObject2 = ((JSONObject)localObject1).getString("method");
          Object localObject3 = new JSONArray(((JSONObject)localObject1).getString("args"));
          l = ((JSONObject)localObject1).getLong("call_id");
          if ("publishHandler".equals(localObject2))
          {
            localObject1 = ((JSONArray)localObject3).getString(0);
            localObject2 = ((JSONArray)localObject3).getString(1);
            localObject3 = ((JSONArray)localObject3).getString(2);
            if ("[]".equals(localObject3))
            {
              paramString = AppBrandRuntimeContainer.g().getAppBrandRunTime(MiniAppWebSocket.access$200(this.this$0).appId, MiniAppWebSocket.access$200(this.this$0).appConfig.config.verType);
              if ((paramString != null) && (paramString.pageContainer != null))
              {
                paramString = paramString.pageContainer.pageLinkedList;
                if (paramString != null)
                {
                  paramString = paramString.iterator();
                  while (paramString.hasNext())
                  {
                    localObject3 = (AbsAppBrandPage)paramString.next();
                    if (localObject3 != null)
                    {
                      localObject3 = ((AbsAppBrandPage)localObject3).getCurrentPageWebview();
                      if (localObject3 != null) {
                        ((PageWebview)localObject3).evaluateSubcribeJSInService((String)localObject1, (String)localObject2, ((PageWebview)localObject3).getPageWebViewId());
                      }
                    }
                  }
                }
              }
            }
            else
            {
              if (MiniAppWebSocket.access$300(this.this$0) == null) {
                break label988;
              }
              MiniAppWebSocket.access$300(this.this$0).onServiceEvent((String)localObject1, (String)localObject2, JSUtil.jsStringToJavaIntArray((String)localObject3));
              this.this$0.sendCallInterfaceResultCmd(l, "");
              QLog.e("ServiceRemoteRuntime", 2, "--- send callinterfaceResult   publishHandler: " + l);
              break label988;
            }
          }
          else
          {
            if (!"invokeHandler".equals(localObject2)) {
              break label988;
            }
            localObject1 = ((JSONArray)localObject3).getString(0);
            localObject2 = ((JSONArray)localObject3).getString(1);
            j = ((JSONArray)localObject3).getInt(2);
            if (MiniAppWebSocket.access$300(this.this$0) == null) {
              break label988;
            }
            localObject1 = MiniAppWebSocket.access$300(this.this$0).onServiceNativeRequest((String)localObject1, (String)localObject2, j);
            this.this$0.sendCallInterfaceResultCmd(l, (String)localObject1);
            QLog.e("ServiceRemoteRuntime", 2, "--- send callinterfaceResult   invokeHandler: " + l);
            break label988;
          }
        }
        else
        {
          if (((String)localObject2).equals("domOp"))
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("data");
            localObject2 = ((JSONObject)localObject1).getString("params");
            j = ((JSONObject)localObject1).getInt("webview_id");
            if (MiniAppWebSocket.access$300(this.this$0) == null) {
              break label988;
            }
            MiniAppWebSocket.access$300(this.this$0).onServiceEvent("remoteDebugCommand", (String)localObject2, new int[] { j });
            break label988;
          }
          if (((String)localObject2).equals("setupContextResult"))
          {
            MiniAppWebSocket.access$402(this.this$0, true);
            while (!MiniAppWebSocket.access$500(this.this$0).isEmpty())
            {
              localObject1 = (MiniAppWebSocket.EvaluateData)MiniAppWebSocket.access$500(this.this$0).poll();
              if (localObject1 != null) {
                this.this$0.evaluateJsEx(((MiniAppWebSocket.EvaluateData)localObject1).js, ((MiniAppWebSocket.EvaluateData)localObject1).valueCallback);
              }
            }
            if (MiniAppWebSocket.access$100(this.this$0) == null) {
              break label988;
            }
            MiniAppWebSocket.access$100(this.this$0).onLoadFinish();
            break label988;
          }
          if (!((String)localObject2).equals("breakpoint")) {
            break label988;
          }
          if (((JSONObject)localObject1).getJSONObject("data").getInt("is_hit") == 0)
          {
            AppBrandRuntimeContainer.g().disableBreak();
            break label988;
          }
          AppBrandRuntimeContainer.g().enableBreak();
          break label988;
          boolean bool = paramString.equals("DebugArkMaster");
          if (!bool) {}
        }
      }
      return;
      label988:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.MiniAppWebSocket.1
 * JD-Core Version:    0.7.0.1
 */
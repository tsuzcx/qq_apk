package com.tencent.mobileqq.listentogether;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Locale;
import org.json.JSONObject;

public class ListenTogetherPlugin
  extends WebViewPlugin
  implements ListenTogetherIPCModuleWebClient.ListenTogetherClient2WebCallback
{
  protected String a;
  protected String b;
  private String c;
  private EIPCResultCallback d = new ListenTogetherPlugin.1(this);
  private EIPCResultCallback e = new ListenTogetherPlugin.2(this);
  
  public ListenTogetherPlugin()
  {
    this.mPluginNameSpace = "listenTogether";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("statusChanged isDestroy:");
      ((StringBuilder)localObject).append(this.isDestroy);
      ((StringBuilder)localObject).append(" data:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" mCheckJoinCallback:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" mJoinListenCallback:");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("ListenTogetherPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramJSONObject != null) && (TextUtils.equals(paramJSONObject.optString("type"), "checkJoin")))
    {
      if (!TextUtils.isEmpty(this.a))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("canJoin", paramJSONObject.optInt("canJoin"));
          ((JSONObject)localObject).put("isOpener", paramJSONObject.optInt("isOpener"));
          ((JSONObject)localObject).put("uinType", paramJSONObject.optInt("uinType"));
          callJs(this.a, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
        catch (Throwable paramJSONObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("statusChanged error:");
          ((StringBuilder)localObject).append(paramJSONObject.getMessage());
          QLog.e("ListenTogetherPlugin", 1, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    if ((paramJSONObject != null) && (TextUtils.equals(paramJSONObject.optString("type"), "joinListen")))
    {
      if (!TextUtils.isEmpty(this.b))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("retCode", paramJSONObject.optInt("retCode"));
          callJs(this.b, new String[] { ((JSONObject)localObject).toString() });
        }
        catch (Throwable paramJSONObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("statusChanged error:");
          ((StringBuilder)localObject).append(paramJSONObject.getMessage());
          QLog.e("ListenTogetherPlugin", 1, ((StringBuilder)localObject).toString());
        }
        this.b = null;
      }
      return;
    }
    dispatchJsEvent("musicStatusChange", paramJSONObject, null);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("ListenTogetherPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("listenTogether".equals(paramString2))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest JSON = ");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.d("ListenTogetherPlugin", 2, paramString1.toString());
      }
      this.c = paramJsBridgeListener.optString("callback");
      if ("awakePlugin".equals(paramString3)) {
        return true;
      }
      if ("statusChanged".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          ListenTogetherIPCModuleWebClient.a(paramJsBridgeListener);
          if ("checkJoin".equals(paramJsBridgeListener.opt("type")))
          {
            this.a = paramJsBridgeListener.optString("callback");
            return true;
          }
          if (!"joinListen".equals(paramJsBridgeListener.opt("type"))) {
            break label330;
          }
          this.b = paramJsBridgeListener.optString("callback");
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.e("ListenTogetherPlugin", 1, "METHOD_STATUS_CHANGED exception e = ", paramJsBridgeListener);
          return true;
        }
      }
      if ("isOpener".equals(paramString3))
      {
        if (TextUtils.isEmpty(this.c)) {
          return true;
        }
        ListenTogetherIPCModuleWebClient.a(paramJsBridgeListener, "isOpener", this.e);
        return true;
      }
      if ("isShowAtmosphere".equals(paramString3))
      {
        if (TextUtils.isEmpty(this.c)) {
          return true;
        }
        ListenTogetherIPCModuleWebClient.a(paramJsBridgeListener, "isShowAtmosphere", this.d);
        return true;
      }
      if ("setPlayerId".equals(paramString3))
      {
        ListenTogetherIPCModuleWebClient.a(paramJsBridgeListener, "setPlayerId", null);
        return true;
      }
      if ("setThemeEnabled".equals(paramString3))
      {
        ListenTogetherIPCModuleWebClient.a(paramJsBridgeListener, "setThemeEnabled", null);
        return true;
      }
    }
    bool1 = false;
    label330:
    return bool1;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult requestCode=");
      paramIntent.append(paramByte);
      paramIntent.append("  resultCode=");
      paramIntent.append(paramInt);
      QLog.d("ListenTogetherPlugin", 2, paramIntent.toString());
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onCreate");
    }
    ListenTogetherIPCModuleWebClient.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onDestroy");
    }
    ListenTogetherIPCModuleWebClient.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherPlugin
 * JD-Core Version:    0.7.0.1
 */
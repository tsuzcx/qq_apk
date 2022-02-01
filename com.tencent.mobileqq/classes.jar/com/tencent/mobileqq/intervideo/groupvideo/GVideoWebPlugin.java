package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GVideoWebPlugin
  extends WebViewPlugin
{
  protected TroopMemberApiClient a = null;
  protected BroadcastReceiver b = new GVideoWebPlugin.2(this);
  private Context c;
  private QQProgressDialog d;
  
  public GVideoWebPlugin()
  {
    this.mPluginNameSpace = "groupVideo";
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934615L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("url:");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method:");
      paramJsBridgeListener.append(paramString3);
      paramJsBridgeListener.append(" args:");
      paramJsBridgeListener.append(paramVarArgs);
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((TextUtils.equals(paramString2, "groupVideo")) && (paramVarArgs != null))
    {
      if (paramVarArgs.length == 0) {
        return false;
      }
      int i;
      if (TextUtils.equals(paramString3, "closeGroupVideoAPI"))
      {
        try
        {
          paramJsBridgeListener = getJsonFromJSBridge(paramString1);
          if (paramJsBridgeListener != null)
          {
            i = paramJsBridgeListener.optInt("type");
            paramJsBridgeListener = new Intent("tencent.video.webjs.cmd");
            paramJsBridgeListener.putExtra("type", i);
            if ((i != 1) && (i != 2)) {
              return true;
            }
            this.c.sendBroadcast(paramJsBridgeListener);
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        return true;
      }
      if (TextUtils.equals(paramString3, "openRoom"))
      {
        try
        {
          Object localObject = getJsonFromJSBridge(paramString1);
          if (localObject != null)
          {
            paramJsBridgeListener = ((JSONObject)localObject).optString("roomCode");
            i = ((JSONObject)localObject).optInt("isGroupCode");
            paramString1 = ((JSONObject)localObject).optString("fromId");
            paramString2 = ((JSONObject)localObject).optString("backType");
            paramString3 = ((JSONObject)localObject).optString("action");
            paramVarArgs = ((JSONObject)localObject).optString("openType");
            localObject = ((JSONObject)localObject).optString("extra");
            this.a.a(paramJsBridgeListener, i, paramString3, paramString1, paramString2, paramVarArgs, (String)localObject);
            GroupVideoManager.a("group_video", new GVideoWebPlugin.1(this, paramString3));
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        return true;
      }
      if (TextUtils.equals(paramString3, "preload")) {
        try
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("preload url:");
          paramJsBridgeListener.append(paramString1);
          QLog.e("GroupVideoManager.GVideoWebPlugin", 2, paramJsBridgeListener.toString());
          this.a.e(null);
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.c = this.mRuntime.d().getApplicationContext();
    this.a = TroopMemberApiClient.a();
    this.a.e();
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "GVideoWebPlugin onCreate");
    }
    IntentFilter localIntentFilter = new IntentFilter(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction("com.tencent.od"));
    localIntentFilter.addAction(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction("com.tencent.od"));
    this.c.registerReceiver(this.b, localIntentFilter);
    this.d = new QQProgressDialog(this.mRuntime.d());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient localTroopMemberApiClient = this.a;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.f();
    }
    try
    {
      this.d.dismiss();
      this.c.unregisterReceiver(this.b);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin
 * JD-Core Version:    0.7.0.1
 */
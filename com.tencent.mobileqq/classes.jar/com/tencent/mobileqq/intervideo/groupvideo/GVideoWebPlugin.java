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
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected TroopMemberApiClient a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public GVideoWebPlugin()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GVideoWebPlugin.2(this);
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
            this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramJsBridgeListener);
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
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, i, paramString3, paramString1, paramString2, paramVarArgs, (String)localObject);
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
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.e(null);
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
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "GVideoWebPlugin onCreate");
    }
    IntentFilter localIntentFilter = new IntentFilter(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction("com.tencent.od"));
    localIntentFilter.addAction(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction("com.tencent.od"));
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.mRuntime.a());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.b();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin
 * JD-Core Version:    0.7.0.1
 */
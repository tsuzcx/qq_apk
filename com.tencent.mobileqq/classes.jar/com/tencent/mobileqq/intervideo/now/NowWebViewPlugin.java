package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.intervideo.now.webplugin.AudioRoomSettingHandler;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class NowWebViewPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  final ITroopMemberApiClientApi.Callback jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi$Callback = new NowWebViewPlugin.1(this);
  private int b;
  
  public NowWebViewPlugin()
  {
    this.mPluginNameSpace = "nowlive";
  }
  
  private Bundle a(String... paramVarArgs)
  {
    Bundle localBundle;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      localBundle = new Bundle();
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        Iterator localIterator = paramVarArgs.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, paramVarArgs.optString(str));
        }
        return localBundle;
      }
      catch (JSONException paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.w("NowWebViewPlugin", 2, "getFirstParam error: ", paramVarArgs);
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("progress", paramInt2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window.__WEBVIEW_GETPLUGININFO && window.__WEBVIEW_GETPLUGININFO(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      callJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errcode", paramInt);
      localJSONObject.put("desc", paramString);
      paramString = new StringBuilder();
      paramString.append("window.__WEBVIEW_INSTALL && window.__WEBVIEW_INSTALL(");
      paramString.append(localJSONObject.toString());
      paramString.append(");");
      callJs(paramString.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public TroopMemberApiClient a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(", pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(", methodName=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("NowWebViewPlugin", 2, paramJsBridgeListener.toString());
    }
    paramJsBridgeListener = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    boolean bool = false;
    if ((paramJsBridgeListener != null) && (paramString1 != null) && ("nowlive".equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      if ("getPluginInfo".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.h();
        a(this.jdField_a_of_type_Int, this.b);
        return true;
      }
      if ("openRoom".equals(paramString3))
      {
        if (paramVarArgs != null)
        {
          if (paramVarArgs.length == 0) {
            return false;
          }
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("handleJsRequest arg = ");
            paramJsBridgeListener.append(paramVarArgs[0]);
            QLog.d("NowWebViewPlugin", 2, paramJsBridgeListener.toString());
          }
          paramJsBridgeListener = paramVarArgs[0];
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            return false;
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(Long.valueOf(paramJsBridgeListener).longValue());
          return true;
        }
        return false;
      }
      if ("install".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("handleJsRequest install arg = ");
          paramJsBridgeListener.append(paramVarArgs[0]);
          QLog.d("NowWebViewPlugin", 2, paramJsBridgeListener.toString());
        }
        int i;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          paramJsBridgeListener = paramVarArgs[0];
          try
          {
            i = Integer.valueOf(paramJsBridgeListener).intValue();
          }
          catch (NumberFormatException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else
        {
          i = 0;
        }
        paramJsBridgeListener = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
        if (i == 1) {
          bool = true;
        }
        paramJsBridgeListener.b(bool);
        return true;
      }
      if ("preload".equals(paramString3))
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(a(paramVarArgs));
        return true;
      }
      if ("audioRoomSetting".equals(paramString3))
      {
        AudioRoomSettingHandler.a(this, paramVarArgs);
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("NOT support method ");
        paramJsBridgeListener.append(paramString3);
        paramJsBridgeListener.append(" yet!!");
        QLog.w("NowWebViewPlugin", 2, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.g(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopMemberApiClientApi$Callback);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localTroopMemberApiClient != null)
    {
      localTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */
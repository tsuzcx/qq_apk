package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcClient;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MedalApiPlugin
  extends WebViewPlugin
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  
  public MedalApiPlugin()
  {
    this.mPluginNameSpace = "medalwall";
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "clearRedPoint from web!");
    }
    CampusCircleIpcClient.a().a();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      c(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shareMsg error: ");
        localStringBuilder.append(paramString.toString());
        QLog.d("MedalApi", 2, localStringBuilder.toString());
      }
    }
  }
  
  private Context b()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      paramString = PrivacySettingUtil.a();
      PrivacySettingUtil.a((AppInterface)this.mRuntime.a(), this, paramString, (byte)100);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shareMsg error: ");
        localStringBuilder.append(paramString.toString());
        QLog.d("MedalApi", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void c(String paramString)
  {
    String str = this.mRuntime.a().getCurrentAccountUin();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("medal_wall_");
    localStringBuilder.append(str);
    boolean bool = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("medal_switch_disable", false);
    if (!TextUtils.isEmpty(paramString))
    {
      if (bool) {
        str = "{\"isOn\":0}";
      } else {
        str = "{\"isOn\":1}";
      }
      callJs(paramString, new String[] { str });
    }
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("medalwall".equals(paramString2))
    {
      if (paramJsBridgeListener != null) {
        boolean bool = paramJsBridgeListener.a;
      }
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if ("getMedalSwitch".equals(paramString3)) {
        a(paramVarArgs[0]);
      } else if ("jumpToMedalSettings".equals(paramString3)) {
        b(paramVarArgs[0]);
      } else if ("clearRedPoint".equals(paramString3)) {
        a();
      }
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 100) {
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MedalApiPlugin
 * JD-Core Version:    0.7.0.1
 */
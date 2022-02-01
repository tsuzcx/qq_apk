package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class StudyModePlugin
  extends WebViewPlugin
{
  Activity a;
  String b = null;
  protected AtomicBoolean c = new AtomicBoolean(false);
  
  public StudyModePlugin()
  {
    this.mPluginNameSpace = "studyMode";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(StudyModePlugin.Result paramResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uiUpdate ret:");
      localStringBuilder.append(paramResult.a);
      localStringBuilder.append(" errMsg:");
      localStringBuilder.append(paramResult.b);
      QLog.d("StudyModePlugin", 2, localStringBuilder.toString());
    }
    if (paramResult.a != 0) {
      return;
    }
    paramResult = (WebViewFragment)this.mRuntime.f();
    ThreadManager.getUIHandler().post(new StudyModePlugin.2(this, paramResult));
  }
  
  private void a(EIPCResult paramEIPCResult)
  {
    this.c.set(false);
    paramEIPCResult = b(paramEIPCResult);
    b(paramEIPCResult);
    a(paramEIPCResult);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("jumpType");
      paramString = new Intent();
      paramString.setAction("com.tencent.mobileqq.studymode.pwdverify.studyidentify");
      paramString.setPackage(MobileQQ.getContext().getPackageName());
      paramString.putExtra("jumpType", i);
      this.mRuntime.d().sendBroadcast(paramString);
      this.mRuntime.d().finish();
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("StudyModePlugin", 1, paramString, new Object[0]);
    }
  }
  
  private StudyModePlugin.Result b(EIPCResult paramEIPCResult)
  {
    StudyModePlugin.Result localResult = new StudyModePlugin.Result(this, -1, HardCodeUtil.a(2131897394));
    Bundle localBundle = paramEIPCResult.data;
    if (localBundle != null)
    {
      localResult.a = localBundle.getInt("ret", -1);
      if (localResult.a == 0) {
        paramEIPCResult = "";
      } else {
        paramEIPCResult = localResult.b;
      }
      localResult.b = localBundle.getString("errMsg", paramEIPCResult);
    }
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("parseEIPCResult ret:");
      paramEIPCResult.append(localResult.a);
      paramEIPCResult.append(" errMsg:");
      paramEIPCResult.append(localResult.b);
      QLog.d("StudyModePlugin", 2, paramEIPCResult.toString());
    }
    return localResult;
  }
  
  private void b(StudyModePlugin.Result paramResult)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("ret", paramResult.a);
        localJSONObject.put("errMsg", paramResult.b);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("native invoke web ret:");
          localStringBuilder.append(paramResult.a);
          localStringBuilder.append(" errMsg:");
          localStringBuilder.append(paramResult.b);
          QLog.d("StudyModePlugin", 2, localStringBuilder.toString());
        }
        callJs(this.b, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramResult)
      {
        QLog.e("StudyModePlugin", 1, paramResult, new Object[0]);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      long l = ((JSONObject)localObject).optLong("nonce");
      paramString = ((JSONObject)localObject).optString("idKey", "");
      this.b = ((JSONObject)localObject).optString("callback", "");
      QLog.e("StudyModePlugin", 1, new Object[] { "handleClearPassword, nonce : ", Long.valueOf(l), " idKey : ", paramString, " mCallback : ", this.b });
      if (this.c.get())
      {
        b(new StudyModePlugin.Result(this, 2, HardCodeUtil.a(2131897394)));
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putLong("nonce", l);
      ((Bundle)localObject).putString("idKey", paramString);
      this.c.set(true);
      a((Bundle)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("StudyModePlugin", 1, paramString, new Object[0]);
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    QIPCClientHelper.getInstance().callServer("StudyModeIpcServer_model", "clear_pwd", paramBundle, new StudyModePlugin.1(this));
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"studyMode".equals(paramString2))
    {
      QLog.e("StudyModePlugin", 1, new Object[] { "handleJsRequest, pkgName not match, pkgName : ", paramString2 });
      return false;
    }
    QLog.d("StudyModePlugin", 1, new Object[] { "handleJsRequest, method : ", paramString3 });
    if (("goToStudySetting".equalsIgnoreCase(paramString3)) && (paramVarArgs.length > 0))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if (("clearPassword".equalsIgnoreCase(paramString3)) && (paramVarArgs.length > 0)) {
      b(paramVarArgs[0]);
    }
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.StudyModePlugin
 * JD-Core Version:    0.7.0.1
 */
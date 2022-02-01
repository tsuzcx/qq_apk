package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AVGameShareJsApiPlugin
  extends WebViewPlugin
{
  public AVGameShareJsApiPlugin()
  {
    this.mPluginNameSpace = "avgame";
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call joinRoom, args:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject).toString());
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).optString("key");
        localObject = new Intent(this.mRuntime.a(), JumpActivity.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mqqapi://avgame/join_room?key=");
        localStringBuilder.append(paramVarArgs);
        ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
        this.mRuntime.a().startActivity((Intent)localObject);
        return;
      }
      catch (Exception paramVarArgs)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Call joinRoom fail: ");
        ((StringBuilder)localObject).append(paramVarArgs.getMessage());
        QLog.e("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail, args empty");
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call createRoom");
      localObject = new Intent(this.mRuntime.a(), JumpActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("mqqapi://avgame/create_room?gameType=");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("gameType")).intValue());
        if (paramVarArgs.has("fromType"))
        {
          localStringBuilder.append("&fromType=");
          localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("fromType")).intValue());
        }
      }
      ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
      this.mRuntime.a().startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call createRoom fail: ");
      ((StringBuilder)localObject).append(paramVarArgs.getMessage());
      QLog.e("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(String... paramVarArgs)
  {
    try
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "handlePKQQCJAction");
      localObject = new Intent(this.mRuntime.a(), JumpActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("mqqapi://avgame/pk_qqcj?");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        localStringBuilder.append("pkid=");
        localStringBuilder.append(Long.valueOf(paramVarArgs.optString("pkid")).longValue());
        localStringBuilder.append("&starttime=");
        localStringBuilder.append(Long.valueOf(paramVarArgs.optString("starttime")).longValue());
        localStringBuilder.append("&endtime=");
        localStringBuilder.append(Long.valueOf(paramVarArgs.optString("endtime")).longValue());
        localStringBuilder.append("&iscj=");
        localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("iscj")).intValue());
        if (paramVarArgs.has("fromtype"))
        {
          localStringBuilder.append("&fromtype=");
          localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("fromtype")).intValue());
        }
      }
      ((Intent)localObject).setData(Uri.parse(localStringBuilder.toString()));
      this.mRuntime.a().startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePKQQCJActionfail: ");
      ((StringBuilder)localObject).append(paramVarArgs.getMessage());
      QLog.e("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void d(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Call handleShareArk, args:");
      ((StringBuilder)localObject1).append(paramVarArgs);
      QLog.d("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject1).toString());
      try
      {
        Object localObject2 = this.mRuntime.a().getIntent();
        String str1 = ((Intent)localObject2).getStringExtra("avgame_share_link");
        localObject1 = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject1 = "https://www.qq.com";
        }
        str1 = ((Intent)localObject2).getStringExtra("avgame_share_name");
        Object localObject3 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject3).optString("awardTitle");
        localObject2 = ((JSONObject)localObject3).optString("awardDesc");
        localObject3 = ((JSONObject)localObject3).optString("awardIconUrl");
        String str2 = this.mRuntime.a().getCurrentAccountUin();
        ThreadManager.getUIHandler().postDelayed(new AVGameShareJsApiPlugin.1(this, str2, (String)localObject1, str1, paramVarArgs, (String)localObject2, (String)localObject3), 200L);
        return;
      }
      catch (Exception paramVarArgs)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Call handleShareArk fail: ");
        ((StringBuilder)localObject1).append(paramVarArgs.getMessage());
        QLog.e("AVGameShareJsApiPlugin", 1, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call handleShareArk fail, args empty");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, url is empty");
      return false;
    }
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("Call AVGameShareJsApiPlugin handleJsRequest, url");
    paramJsBridgeListener.append(paramString1);
    paramJsBridgeListener.append(" pkgName:");
    paramJsBridgeListener.append(paramString2);
    QLog.d("AVGameShareJsApiPlugin", 1, paramJsBridgeListener.toString());
    if ("avgame".equals(paramString2))
    {
      if ("joinRoom".equals(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
      if ("createRoom".equals(paramString3))
      {
        b(paramVarArgs);
        return true;
      }
      if ("shareAward".equals(paramString3))
      {
        d(paramVarArgs);
        return true;
      }
      if ("pk_qqcj".equals(paramString3))
      {
        c(paramVarArgs);
        return true;
      }
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, method not match");
      return false;
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, package not match");
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AVGameShareJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */
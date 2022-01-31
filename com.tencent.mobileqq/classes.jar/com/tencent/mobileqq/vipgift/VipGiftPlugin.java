package com.tencent.mobileqq.vipgift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class VipGiftPlugin
  extends VasWebviewJsPlugin
{
  public VipGiftPlugin()
  {
    this.mPluginNameSpace = "gift";
  }
  
  private void a()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void a(String paramString)
  {
    int i = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      if (this.mRuntime.a() != null) {
        try
        {
          Object localObject = new JSONObject(paramString);
          paramString = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optJSONObject("options");
          int j;
          if (localObject != null)
          {
            j = ((JSONObject)localObject).optInt("style");
            i = ((JSONObject)localObject).optInt("animation");
            label75:
            if (TextUtils.isEmpty(paramString)) {
              continue;
            }
            localObject = localActivity.getIntent().getExtras();
            ((Bundle)localObject).putString("leftViewText", "");
            switch (j)
            {
            }
          }
          for (;;)
          {
            Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
            localIntent.putExtras((Bundle)localObject);
            localIntent.putExtra("url", paramString);
            localIntent.setFlags(0);
            localActivity.startActivityForResult(localIntent, 100);
            switch (i)
            {
            case 0: 
            case 1: 
              localActivity.overridePendingTransition(0, 0);
              return;
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              continue;
              ((Bundle)localObject).putBoolean("hide_more_button", true);
              ((Bundle)localObject).putBoolean("hide_operation_bar", false);
              ((Bundle)localObject).putString("webStyle", "");
              break;
            case 2: 
              localActivity.overridePendingTransition(2131034380, 0);
              return;
              j = 0;
              break label75;
            }
          }
          return;
        }
        catch (JSONException paramString) {}
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipGiftPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934595L)
    {
      paramString = this.mRuntime.a();
      if (paramString != null) {
        break label22;
      }
    }
    label22:
    while (!paramString.getClass().getSimpleName().equals("VipGiftBrowserActivity")) {
      return false;
    }
    paramString.finish();
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("gift".equals(paramString2))
    {
      if (("openUrl".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        a(paramVarArgs[0]);
        a();
      }
      do
      {
        return true;
        if (("close".equals(paramString3)) && (paramVarArgs.length == 1)) {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.getString("callback");
            long l = paramString1.getLong("version");
            paramString1 = new Bundle();
            paramString1.putLong("version", l);
            sendRemoteReq(DataFactory.a("close_version", paramJsBridgeListener, this.mOnRemoteResp.key, paramString1), false, false);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            return true;
          }
        }
        if ("isFlowerVisible".equals(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            paramString1 = new Bundle();
            sendRemoteReq(DataFactory.a("getFlowerVisibility", paramJsBridgeListener, this.mOnRemoteResp.key, paramString1), false, false);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      } while (!"setFlowerVisibility".equals(paramString3));
      paramString1 = null;
      paramJsBridgeListener = paramString1;
      for (;;)
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1;
          paramString1 = paramString2.optString("callback");
          paramJsBridgeListener = paramString1;
          int i = paramString2.getInt("isVisible");
          paramJsBridgeListener = paramString1;
          paramString2 = new Bundle();
          if (i != 1) {
            break label322;
          }
          bool = true;
          paramJsBridgeListener = paramString1;
          paramString2.putBoolean("isVisible", bool);
          paramJsBridgeListener = paramString1;
          sendRemoteReq(DataFactory.a("setFlowerVisibility", paramString1, this.mOnRemoteResp.key, paramString2), false, false);
          return true;
        }
        catch (JSONException paramString1) {}
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break;
        }
        callJs(paramJsBridgeListener, new String[] { String.format("{\"result\": -2, \"message\":\"%s\"}", new Object[] { paramString1 }) });
        return true;
        label322:
        boolean bool = false;
      }
    }
    return false;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    JSONObject localJSONObject;
    String str2;
    String str1;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localJSONObject = new JSONObject();
      str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (str2 != null)
      {
        if (!"close_version".equals(str2)) {
          break label110;
        }
        i = paramBundle.getInt("result");
      }
    }
    label110:
    do
    {
      try
      {
        localJSONObject.put("result", i);
        a(str1, localJSONObject.toString());
        a();
        return;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      if ("getFlowerVisibility".equals(str2))
      {
        if (paramBundle.getBoolean("result")) {}
        for (i = 1;; i = 0)
        {
          callJs(str1, new String[] { String.format("{\"result\":0, \"data\":{\"isVisible\":%d}}", new Object[] { Integer.valueOf(i) }) });
          return;
        }
      }
    } while (!"setFlowerVisibility".equals(str2));
    int i = paramBundle.getInt("result");
    if (i == 0) {}
    for (paramBundle = "{\"result\":0}";; paramBundle = String.format("{\"result\": %d, \"message\":\"Unknown error\"}", new Object[] { Integer.valueOf(i) }))
    {
      callJs(str1, new String[] { paramBundle });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftPlugin
 * JD-Core Version:    0.7.0.1
 */
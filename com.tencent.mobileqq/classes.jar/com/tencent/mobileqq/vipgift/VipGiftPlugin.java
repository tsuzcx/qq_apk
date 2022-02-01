package com.tencent.mobileqq.vipgift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
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
    Activity localActivity = this.mRuntime.d();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  private void a(String paramString)
  {
    Activity localActivity = this.mRuntime.d();
    if (localActivity == null) {
      return;
    }
    if (this.mRuntime.a() == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("url");
        localObject = ((JSONObject)localObject).optJSONObject("options");
        if (localObject != null)
        {
          j = ((JSONObject)localObject).optInt("style");
          i = ((JSONObject)localObject).optInt("animation");
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = localActivity.getIntent().getExtras();
            ((Bundle)localObject).putString("leftViewText", "");
            if (j != 0)
            {
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j == 3)
                  {
                    ((Bundle)localObject).putBoolean("hide_more_button", true);
                    ((Bundle)localObject).putBoolean("hide_operation_bar", false);
                    ((Bundle)localObject).putString("webStyle", "");
                  }
                }
                else
                {
                  ((Bundle)localObject).putBoolean("hide_more_button", false);
                  ((Bundle)localObject).putBoolean("hide_operation_bar", false);
                  ((Bundle)localObject).putString("webStyle", "");
                }
              }
              else
              {
                ((Bundle)localObject).putBoolean("hide_more_button", true);
                ((Bundle)localObject).putBoolean("hide_operation_bar", true);
              }
            }
            else
            {
              ((Bundle)localObject).putBoolean("hide_more_button", false);
              ((Bundle)localObject).putBoolean("hide_operation_bar", true);
            }
            Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
            localIntent.putExtras((Bundle)localObject);
            localIntent.putExtra("url", paramString);
            localIntent.setFlags(0);
            localActivity.startActivityForResult(localIntent, 100);
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2) {
                  return;
                }
                localActivity.overridePendingTransition(2130772434, 0);
                return;
              }
              localActivity.overridePendingTransition(0, 0);
            }
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      int i = 0;
      int j = 0;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("method:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", json:");
      localStringBuilder.append(paramString2);
      QLog.i("VipGiftPlugin", 2, localStringBuilder.toString());
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934595L)
    {
      paramString = this.mRuntime.d();
      if (paramString == null) {
        return false;
      }
      if (paramString.getClass().getSimpleName().equals("VipGiftBrowserActivity")) {
        paramString.finish();
      }
    }
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
        return true;
      }
      if ((!"close".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
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
    if ("setFlowerVisibility".equals(paramString3))
    {
      paramString1 = null;
      paramJsBridgeListener = paramString1;
    }
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
          break label327;
        }
        bool = true;
        paramJsBridgeListener = paramString1;
        paramString2.putBoolean("isVisible", bool);
        paramJsBridgeListener = paramString1;
        sendRemoteReq(DataFactory.a("setFlowerVisibility", paramString1, this.mOnRemoteResp.key, paramString2), false, false);
        return true;
      }
      catch (JSONException paramString1)
      {
        if (!TextUtils.isEmpty(paramJsBridgeListener)) {
          callJs(paramJsBridgeListener, new String[] { String.format("{\"result\": -2, \"message\":\"%s\"}", new Object[] { paramString1 }) });
        }
      }
      return true;
      return false;
      label327:
      boolean bool = false;
    }
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftPlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import bguq;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class NativePageJsPlugin
  extends BaseJsPlugin
{
  private static final String CARD_TYPE_GROUP = "group";
  private static final String CARD_TYPE_PUBLIC = "public_account";
  private static final Set<String> S_EVENT_MAP = new NativePageJsPlugin.1();
  private static final String TAG = "NativePageJsPlugin";
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("NativePageJsPlugin", 2, "[handleNativeRequest] event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    if ("openNativePage".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString2);
        if (!((JSONObject)localObject1).has("api_name")) {
          continue;
        }
        paramString2 = getAppId();
        ((JSONObject)localObject1).optString("api_name");
        localObject2 = ((JSONObject)localObject1).optJSONObject("data");
        localObject1 = ((JSONObject)localObject2).optString("card_type");
        localObject2 = ((JSONObject)localObject2).optString("uin");
        if (!"group".equals(localObject1)) {
          continue;
        }
        i = 2;
      }
      catch (Exception paramString2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        QLog.e("NativePageJsPlugin", 1, paramString1 + " error.", paramString2);
        continue;
        int i = 0;
        continue;
      }
      MiniAppCmdUtil.getInstance().checkBindingState(paramString2, (String)localObject2, i, new NativePageJsPlugin.2(this, (String)localObject1, (String)localObject2, paramJsRuntime, paramString1, paramInt));
      return "";
      bool = "public_account".equals(localObject1);
      if (!bool) {
        continue;
      }
      i = 1;
    }
  }
  
  public void jumpToGroup(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() < 5)) {
      return;
    }
    paramString = TroopInfoActivity.a(paramString, 5);
    bguq.a(this.jsPluginEngine.appBrandRuntime.activity, paramString, 2);
  }
  
  public void jumpToPublic(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() < 5)) {
      return;
    }
    Intent localIntent = new Intent(this.jsPluginEngine.appBrandRuntime.activity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    this.jsPluginEngine.appBrandRuntime.activity.startActivity(localIntent);
  }
  
  @NonNull
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NativePageJsPlugin
 * JD-Core Version:    0.7.0.1
 */
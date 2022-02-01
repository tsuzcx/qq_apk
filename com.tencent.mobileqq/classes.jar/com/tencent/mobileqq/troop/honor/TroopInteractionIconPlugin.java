package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfig;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopInteractionIconPlugin
  extends WebViewPlugin
{
  private boolean a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("callback");
    String str2 = paramJSONObject.optString("grayType");
    paramJSONObject = paramJSONObject.optString("gc");
    if (!str2.equals("dragonPrivilege")) {
      return false;
    }
    TroopDragonKingAnimEntryConfig localTroopDragonKingAnimEntryConfig = (TroopDragonKingAnimEntryConfig)QConfigManager.a().a(609);
    int i;
    if ((localTroopDragonKingAnimEntryConfig != null) && (localTroopDragonKingAnimEntryConfig.a(paramJSONObject))) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("value");
      paramJSONObject.append(i);
      QLog.d("TroopInteractionIconPlugin", 2, paramJSONObject.toString());
    }
    try
    {
      paramJSONObject = new JSONObject();
      paramJSONObject.put(str2, i);
      callJs(str1, new String[] { paramJSONObject.toString() });
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("gc");
    paramJSONObject = paramJSONObject.optString("text");
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), new int[] { 2 });
    localIntent.addFlags(4194304);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("chat_inputBarContent", paramJSONObject);
    localActivity.startActivity(localIntent);
    localActivity.overridePendingTransition(2130772004, 2130772344);
    return true;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("gc");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("goToChat troopUin : ");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("TroopInteractionIconPlugin", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = this.mRuntime.a();
    Intent localIntent = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), new int[] { 2 });
    localIntent.addFlags(4194304);
    localIntent.putExtra("uin", paramJSONObject);
    localIntent.putExtra("uintype", 1);
    ((Activity)localObject).startActivity(localIntent);
    ((Activity)localObject).overridePendingTransition(2130772004, 2130772344);
    return true;
  }
  
  private boolean e(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("gc");
    if (TextUtils.isEmpty(paramJSONObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("goToSign troopUin : ");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("TroopInteractionIconPlugin", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("&state=1");
    paramJSONObject = ((StringBuilder)localObject).toString();
    localObject = new Intent(this.mRuntime.a(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramJSONObject);
    this.mRuntime.a().startActivity((Intent)localObject);
    return true;
  }
  
  private boolean f(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("gc");
    Object localObject;
    if (TextUtils.isEmpty(paramJSONObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("gotoClockIn troopUin : ");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("TroopInteractionIconPlugin", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    if (this.mRuntime != null)
    {
      localObject = this.mRuntime.a();
      if (localObject != null)
      {
        Intent localIntent = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), new int[] { 2 });
        localIntent.addFlags(4194304);
        localIntent.putExtra("uin", paramJSONObject);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("open_together_panel", true);
        ((Activity)localObject).startActivity(localIntent);
        ((Activity)localObject).overridePendingTransition(2130772004, 2130772344);
        return true;
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"groupInteractionIcon".equals(paramString2)) {
      return false;
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if (paramString3.equals("getGroupGrayFlag")) {
        return a(paramJsBridgeListener);
      }
      if (paramString3.equals("jumpToAIOAndFillText")) {
        return b(paramJsBridgeListener);
      }
      if (paramString3.equals("isQunLevelGray")) {
        return c(paramJsBridgeListener);
      }
      if (paramString3.equals("gotoChat")) {
        return d(paramJsBridgeListener);
      }
      if (paramString3.equals("gotoSign")) {
        return e(paramJsBridgeListener);
      }
      if (paramString3.equals("gotoYQHEntranceSign")) {
        return f(paramJsBridgeListener);
      }
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopInteractionIconPlugin
 * JD-Core Version:    0.7.0.1
 */
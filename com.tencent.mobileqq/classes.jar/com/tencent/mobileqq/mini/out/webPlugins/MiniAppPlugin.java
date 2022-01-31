package com.tencent.mobileqq.mini.out.webPlugins;

import ajjy;
import anad;
import anah;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import anfc;
import bbac;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MiniAppPlugin
  extends WebViewPlugin
{
  public static final String MINI_APP_HOST = "sou.qq.com";
  public static final String PLUGIN_NAMESPACE = "miniApp";
  public static final String SCHEME = "miniApp";
  public static final String TAG = "MiniAppPlugin";
  private static final String URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1 = "http://www.mqqapi.com//microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL = "http://mqqapi//microapp/open?";
  private static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  private anad remoteRespObserver = new MiniAppPlugin.3(this);
  
  public MiniAppPlugin()
  {
    this.mPluginNameSpace = "miniApp";
  }
  
  private static String getFakeUrlFromShareUrl(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = null;
      if (!paramString.startsWith("http://mqqapi//microapp/open?")) {
        break label30;
      }
      localObject = "http://mqqapi//microapp/open?";
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label45;
      }
    }
    label30:
    label45:
    Map.Entry localEntry;
    String str;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          return paramString;
          if (!paramString.startsWith("http://www.mqqapi.com//microapp/open?")) {
            break;
          }
          localObject = "http://www.mqqapi.com//microapp/open?";
          break;
          localObject = getUrlParam(paramString, (String)localObject);
        } while (localObject == null);
        localObject = ((HashMap)localObject).entrySet().iterator();
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
      str = (String)localEntry.getKey();
    } while ((TextUtils.isEmpty(str)) || (!str.equals("fakeUrl")));
    return (String)localEntry.getValue();
  }
  
  private static HashMap<String, String> getUrlParam(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      paramString1 = paramString1.substring(paramString2.length()).split("&");
      if (paramString1 != null)
      {
        int i = 0;
        while (i < paramString1.length)
        {
          paramString2 = paramString1[i].split("=");
          if ((paramString2 != null) && (paramString2.length == 2)) {
            localHashMap.put(paramString2[0], paramString2[1]);
          }
          i += 1;
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  private void handleJumpOrLaunchFail(String paramString)
  {
    this.mRuntime.a().runOnUiThread(new MiniAppPlugin.2(this));
    QLog.e("MiniAppPlugin", 1, "handleSchemaRequest: launch failed with url " + paramString);
  }
  
  private static boolean isMiniAppShareUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("http://mqqapi//microapp/open?"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("http://www.mqqapi.com//microapp/open?")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isUrlBelongToMiniAppShare(String paramString)
  {
    return MiniAppLauncher.isMiniAppUrl(paramString);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("miniApp")) || (paramString3 == null)) {
      return false;
    }
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return false;
    }
    if (paramString3.equals("openApp")) {}
    label387:
    label392:
    for (;;)
    {
      try
      {
        paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramString1 != null) {
          break label392;
        }
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (!paramString1.has("appid")) {
          break label387;
        }
        paramJsBridgeListener = paramString1.optString("appid");
        if (!paramString1.has("apptype")) {
          break label382;
        }
        paramString2 = paramString1.optString("apptype");
        if (!paramString1.has("via")) {
          break label376;
        }
        paramString3 = paramString1.optString("via");
        if (!paramString1.has("callback")) {
          break label371;
        }
        paramString1 = paramString1.optString("callback");
        if (canOpenApp != 1)
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("ret", -1);
          paramJsBridgeListener.put("msg", "canOpenApp false.");
          callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("MiniAppPlugin", 1, "openApp error.", paramJsBridgeListener);
        return true;
      }
      paramVarArgs = new Bundle();
      paramVarArgs.putString("miniapp_appid", paramJsBridgeListener);
      paramVarArgs.putString("miniapp_type", paramString2);
      paramVarArgs.putString("miniapp_via", paramString3);
      sendRemoteReq(anah.a("ipc_start_miniapp", paramString1, this.remoteRespObserver.key, paramVarArgs), false, false);
      return true;
      if (paramString3.equals("canOpenApp")) {
        try
        {
          paramString1 = new JSONObject();
          if (canOpenApp == 1) {
            bool = true;
          }
          paramString1.put("canOpenApp", bool);
          paramJsBridgeListener.a(paramString1);
          return true;
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "canOpenApp error.", paramJsBridgeListener);
          return true;
        }
      }
      return false;
      label371:
      paramString1 = null;
      continue;
      label376:
      paramString3 = null;
      continue;
      label382:
      paramString2 = null;
      continue;
      paramJsBridgeListener = null;
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = getFakeUrlFromShareUrl(paramString1);
      if (((MiniAppLauncher.isMiniAppUrl(str)) || (isMiniAppShareUrl(paramString1))) && (this.mRuntime.a() != null))
      {
        if (!MiniAppLauncher.startMiniApp(this.mRuntime.a(), str, 2014, null))
        {
          handleJumpOrLaunchFail(str);
          return false;
        }
        this.mRuntime.a().finish();
        return true;
      }
    }
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  public void onCreate()
  {
    super.onCreate();
    anfc.a().a(this.remoteRespObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    anfc.a().b(this.remoteRespObserver);
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!anfc.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), ajjy.a(2131641044), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      anfc.a().b(paramBundle);
      return;
    }
    anfc.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */
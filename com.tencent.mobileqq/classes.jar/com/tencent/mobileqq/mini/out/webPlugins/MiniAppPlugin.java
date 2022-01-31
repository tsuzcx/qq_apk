package com.tencent.mobileqq.mini.out.webPlugins;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import apmh;
import apml;
import aprh;
import begz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MiniAppPlugin
  extends WebViewPlugin
{
  public static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
  public static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
  public static final String MINI_APP_HOST = "sou.qq.com";
  public static final String PLUGIN_NAMESPACE = "miniApp";
  public static final String SCHEME = "miniApp";
  public static final String TAG = "MiniAppPlugin";
  private static final String URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1 = "http://www.mqqapi.com//microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL = "http://mqqapi//microapp/open?";
  private static final String URL_PREFIX_MINIGAME_PAY_BY_H5 = "https://h5.qzone.qq.com/miniapp/act/midasPay";
  private static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  private apmh remoteRespObserver = new MiniAppPlugin.3(this);
  
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
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) && (paramMap != null) && (paramLong == 8589934612L) && (paramMap.containsKey("errorCode")))
      {
        int i = ((Integer)paramMap.get("errorCode")).intValue();
        QLog.i("MiniAppPlugin", 1, "paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:" + i);
        paramString = paramMap.get("requestData");
        if ((paramString instanceof WebResourceRequest))
        {
          paramString = (WebResourceRequest)paramString;
          if (paramString != null)
          {
            paramString = paramString.getUrl();
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              QLog.i("MiniAppPlugin", 1, "paybyh5 handleEvent realUrlStr:" + paramString);
              if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay"))) {
                break;
              }
              paramString = new Intent();
              paramString.putExtra("errCode", -3);
              paramString.putExtra("errMsg", "EVENT_RECEIVER_HTTP_ERROR：" + i);
              paramString.putExtra("errType", 8589934612L);
              if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
                break;
              }
              this.mRuntime.a().setResult(-1, paramString);
              this.mRuntime.a().finish();
              break;
            }
          }
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppPlugin", 1, "handleEvent error.", paramString);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool1 = false;
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("miniApp")) || (paramString3 == null))
    {
      bool1 = false;
      return bool1;
    }
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return false;
    }
    if (paramString3.equals("openApp")) {}
    label730:
    label735:
    label741:
    label746:
    label751:
    for (;;)
    {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener != null) {
          break label751;
        }
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (!paramJsBridgeListener.has("appid")) {
          break label746;
        }
        paramString1 = paramJsBridgeListener.optString("appid");
        if (!paramJsBridgeListener.has("apptype")) {
          break label741;
        }
        paramString2 = paramJsBridgeListener.optString("apptype");
        if (!paramJsBridgeListener.has("via")) {
          break label735;
        }
        paramString3 = paramJsBridgeListener.optString("via");
        paramVarArgs = localObject;
        if (paramJsBridgeListener.has("callback")) {
          paramVarArgs = paramJsBridgeListener.optString("callback");
        }
        if (canOpenApp != 1)
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("ret", -1);
          paramJsBridgeListener.put("msg", "canOpenApp false.");
          callJs(paramVarArgs, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("MiniAppPlugin", 1, "openApp error.", paramJsBridgeListener);
        return true;
      }
      paramJsBridgeListener = new Bundle();
      paramJsBridgeListener.putString("miniapp_appid", paramString1);
      paramJsBridgeListener.putString("miniapp_type", paramString2);
      paramJsBridgeListener.putString("miniapp_via", paramString3);
      sendRemoteReq(apml.a("ipc_start_miniapp", paramVarArgs, this.remoteRespObserver.key, paramJsBridgeListener), false, false);
      return true;
      if (paramString3.equals("canOpenApp")) {
        try
        {
          paramString1 = new JSONObject();
          if (canOpenApp == 1) {
            bool1 = true;
          }
          paramString1.put("canOpenApp", bool1);
          paramJsBridgeListener.a(paramString1);
          return true;
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "canOpenApp error.", paramJsBridgeListener);
          return true;
        }
      }
      if (paramString3.equals("chooseAddress"))
      {
        bool1 = bool2;
        if (paramVarArgs == null) {
          break;
        }
        bool1 = bool2;
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (paramVarArgs.length <= 0) {
              break;
            }
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            if (!paramJsBridgeListener.has("callback")) {
              break label730;
            }
            paramJsBridgeListener = paramJsBridgeListener.optString("callback");
            if (paramVarArgs[0] != null)
            {
              if (QLog.isColorLevel()) {
                QLog.e("MiniAppPlugin", 1, "address_info" + paramVarArgs[0]);
              }
              paramString1 = new Intent("action_return_address_to_miniapp");
              paramString1.putExtra("key_miniapp_address_info", paramVarArgs[0]);
              BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
            }
            paramString1 = new JSONObject();
            paramString1.put("ret", 0);
            paramString1.put("msg", "get addressResult suc.");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return true;
          }
          catch (Throwable paramJsBridgeListener)
          {
            QLog.e("MiniAppPlugin", 1, "chooseAddress error.", paramJsBridgeListener);
            return true;
          }
          if (paramString3.equals("payCallback")) {
            try
            {
              paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
              QLog.i("MiniAppPlugin", 1, "payCallback" + paramJsBridgeListener.toString());
              paramString1 = new Intent();
              paramString1.putExtra("errCode", paramJsBridgeListener.optInt("errCode"));
              paramString1.putExtra("errMsg", paramJsBridgeListener.optString("errMsg"));
              bool1 = bool2;
              if (this.mRuntime == null) {
                break;
              }
              bool1 = bool2;
              if (this.mRuntime.a() == null) {
                break;
              }
              this.mRuntime.a().setResult(-1, paramString1);
              this.mRuntime.a().finish();
              return true;
            }
            catch (Throwable paramJsBridgeListener)
            {
              QLog.e("MiniAppPlugin", 1, "payCallback error.", paramJsBridgeListener);
              return true;
            }
          }
        }
        return false;
        paramJsBridgeListener = null;
      }
      paramString3 = null;
      continue;
      paramString2 = null;
      continue;
      paramString1 = null;
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
    aprh.a().a(this.remoteRespObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aprh.a().b(this.remoteRespObserver);
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!aprh.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), alud.a(2131707224), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      aprh.a().b(paramBundle);
      return;
    }
    aprh.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */
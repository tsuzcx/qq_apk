package com.tencent.mobileqq.mini.out.webPlugins;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.minigame.ui.PayForFriendView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MiniAppPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public static final String ACTION_RETURN_ADDRESS_TO_MINIAPP = "action_return_address_to_miniapp";
  public static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
  public static final String MINI_APP_HOST = "sou.qq.com";
  public static final String PLUGIN_NAMESPACE = "miniApp";
  public static final String SCHEME = "miniApp";
  public static final int SHARE_TARGET_QQ = 0;
  public static final String TAG = "MiniAppPlugin";
  private static final String URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1 = "https://www.mqqapi.com//microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL = "https://mqqapi//microapp/open?";
  private static final String URL_PREFIX_MINIGAME_PAY_BY_H5 = "https://h5.qzone.qq.com/miniapp/act/midasPay";
  private static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  private Client.OnRemoteRespObserver remoteRespObserver = new MiniAppPlugin.3(this);
  
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
      if (!paramString.startsWith("https://mqqapi//microapp/open?")) {
        break label30;
      }
      localObject = "https://mqqapi//microapp/open?";
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
          if (!paramString.startsWith("https://www.mqqapi.com//microapp/open?")) {
            break;
          }
          localObject = "https://www.mqqapi.com//microapp/open?";
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
      if (!paramString.startsWith("https://mqqapi//microapp/open?"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("https://www.mqqapi.com//microapp/open?")) {}
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
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
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
    label804:
    label1347:
    label1350:
    label1353:
    for (;;)
    {
      String str1;
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener != null) {
          break label1353;
        }
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = null;
        paramString2 = null;
        paramString3 = null;
        paramVarArgs = null;
        str1 = null;
        if (paramJsBridgeListener.has("appid")) {
          paramString1 = paramJsBridgeListener.optString("appid");
        }
        if (paramJsBridgeListener.has("apptype")) {
          paramString2 = paramJsBridgeListener.optString("apptype");
        }
        if (paramJsBridgeListener.has("via")) {
          paramString3 = paramJsBridgeListener.optString("via");
        }
        if (paramJsBridgeListener.has("callback")) {
          paramVarArgs = paramJsBridgeListener.optString("callback");
        }
        if (paramJsBridgeListener.has("path")) {
          str1 = paramJsBridgeListener.optString("path");
        }
        if (canOpenApp != 1)
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("ret", -1);
          paramJsBridgeListener.put("msg", "canOpenApp false.");
          callJs(paramVarArgs, new String[] { paramJsBridgeListener.toString() });
          return true;
        }
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putString("miniapp_appid", paramString1);
        paramJsBridgeListener.putString("miniapp_type", paramString2);
        paramJsBridgeListener.putString("miniapp_via", paramString3);
        paramJsBridgeListener.putString("miniapp_path", str1);
        sendRemoteReq(DataFactory.a("ipc_start_miniapp", paramVarArgs, this.remoteRespObserver.key, paramJsBridgeListener), false, false);
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("MiniAppPlugin", 1, "openApp error.", paramJsBridgeListener);
        continue;
      }
      return true;
      if (paramString3.equals("canOpenApp")) {
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject();
            if (canOpenApp != 1) {
              continue;
            }
            bool = true;
            paramString1.put("canOpenApp", bool);
            paramJsBridgeListener.a(paramString1);
          }
          catch (Throwable paramJsBridgeListener)
          {
            boolean bool;
            QLog.e("MiniAppPlugin", 1, "canOpenApp error.", paramJsBridgeListener);
            continue;
          }
          return true;
          bool = false;
        }
      }
      if (paramString3.equals("chooseAddress"))
      {
        if (paramVarArgs != null) {}
        try
        {
          if (paramVarArgs.length > 0)
          {
            paramJsBridgeListener = null;
            paramString1 = new JSONObject(paramVarArgs[0]);
            if (paramString1.has("callback")) {
              paramJsBridgeListener = paramString1.optString("callback");
            }
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
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          for (;;)
          {
            QLog.e("MiniAppPlugin", 1, "chooseAddress error.", paramJsBridgeListener);
          }
        }
        return true;
      }
      if (paramString3.equals("payCallback"))
      {
        try
        {
          paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if ("payCallback" + paramString1 != null) {}
          for (paramJsBridgeListener = paramString1.toString();; paramJsBridgeListener = "")
          {
            QLog.i("MiniAppPlugin", 1, paramJsBridgeListener);
            paramJsBridgeListener = new Intent();
            paramJsBridgeListener.putExtra("errCode", paramString1.optInt("errCode"));
            paramJsBridgeListener.putExtra("errMsg", paramString1.optString("errMsg"));
            if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
              break;
            }
            this.mRuntime.a().setResult(-1, paramJsBridgeListener);
            this.mRuntime.a().finish();
            break;
          }
          if (!paramString3.equals("closeFriendPaymentH5")) {
            break label804;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "payCallback error.", paramJsBridgeListener);
        }
      }
      else
      {
        if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
          this.mRuntime.a().setVisibility(8);
        }
        return true;
      }
      if (paramString3.equals("shareFriendPayment"))
      {
        paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramString1 == null) {
          return false;
        }
      }
      for (;;)
      {
        int i;
        try
        {
          paramString2 = paramString1.getString("prepayId");
          i = paramString1.optInt("setEnv", 0);
          paramJsBridgeListener = paramString1.optString("title");
          paramString1 = paramString1.optString("imageUrl");
          if (!TextUtils.isEmpty(paramJsBridgeListener)) {
            break label1350;
          }
          paramJsBridgeListener = GameWnsUtils.defaultPayShareTitle();
          if (!TextUtils.isEmpty(paramString1)) {
            break label1347;
          }
          paramString1 = GameWnsUtils.defaultPayShareImg();
          paramString3 = new COMM.StCommonExt();
          paramVarArgs = new COMM.Entry();
          paramVarArgs.key.set("prepay_id");
          paramVarArgs.value.set(paramString2);
          paramString3.mapInfo.get().add(paramVarArgs);
          paramString2 = new COMM.Entry();
          paramString2.key.set("set_env");
          paramString2.value.set(i + "");
          paramString3.mapInfo.get().add(paramString2);
          if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof PayForFriendView)))
          {
            paramString2 = (PayForFriendView)this.mRuntime.a();
            paramVarArgs = paramString2.getAppId();
            str1 = paramString2.getAppName();
            String str2 = paramString2.getAppIconUrl();
            String str3 = paramString2.getAppVersionId();
            i = paramString2.getAppVerType();
            MiniProgramShareUtils.shareAsArkMessage(this.mRuntime.a(), new MiniArkShareModelBuilder().setAppId(paramVarArgs).setTitle(str1).setDescription(paramJsBridgeListener).setShareScene(4).setShareTemplateType(1).setShareBusinessType(1).setPicUrl(paramString1).setVidUrl(null).setJumpUrl("").setIconUrl(str2).setVersionType(i).setVersionId(str3).setWebURL("").setTemplateId("").setTemplateData("").setEntryModel(null).setShareChatModel(null).setShareTarget(0).setRcvOpenId("").createMiniArkShareModel(), false, 13, paramString3, null);
          }
          return true;
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "shareFriendPayment error.", paramJsBridgeListener);
        }
        do
        {
          return false;
        } while (!paramString3.equals("closeWebview"));
        try
        {
          paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if ("closeWebview" + paramString1 != null) {}
          for (paramJsBridgeListener = paramString1.toString();; paramJsBridgeListener = "")
          {
            QLog.i("MiniAppPlugin", 1, paramJsBridgeListener);
            paramJsBridgeListener = new Intent();
            i = paramString1.optInt("allClose", -1);
            if (i == -1) {
              QLog.e("MiniAppPlugin", 1, "no allClose back from h5");
            }
            paramJsBridgeListener.putExtra("allCloseState", i);
            if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
              break;
            }
            this.mRuntime.a().setResult(-1, paramJsBridgeListener);
            this.mRuntime.a().finish();
            break;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "closeWebview error.", paramJsBridgeListener);
          break;
        }
      }
    }
    return true;
    return true;
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
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.contains("sou.qq.com")) || (isUrlBelongToMiniAppShare(paramString1));
  }
  
  public void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.remoteRespObserver);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.a().b(this.remoteRespObserver);
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!WebIPCOperator.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), HardCodeUtil.a(2131706843), 0).show();
      }
      return;
    }
    if (paramBoolean1)
    {
      WebIPCOperator.a().b(paramBundle);
      return;
    }
    WebIPCOperator.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */
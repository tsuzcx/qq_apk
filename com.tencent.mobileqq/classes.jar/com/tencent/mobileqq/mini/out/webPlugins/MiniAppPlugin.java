package com.tencent.mobileqq.mini.out.webPlugins;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.share.MiniArkShareModelBuilder;
import com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper;
import com.tencent.mobileqq.mini.widget.LaunchConfirmDialogWrapper.Builder;
import com.tencent.mobileqq.minigame.ui.PayForFriendView;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ShareQQArkHelper;
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
  private static final String KEY_AIO_MSG_TYPE = "curtype";
  private static final String KEY_FROM_AIO = "fromAio";
  private static final String KEY_FROM_QZONE = "fromQZone";
  public static final String KEY_MINIAPP_ADDRESS_INFO = "key_miniapp_address_info";
  private static final String KEY_URL = "url";
  public static final String MINI_APP_HOST = "sou.qq.com";
  public static final String PLUGIN_NAMESPACE = "miniApp";
  public static final String SCHEME = "miniApp";
  public static final int SHARE_TARGET_QQ = 0;
  public static final String TAG = "MiniAppPlugin";
  private static final String URL_PREFIX_HTTP_MINIAPP_HEAD_URL_1 = "https://www.mqqapi.com//microapp/open?";
  private static final String URL_PREFIX_HTTP_MINIAPP_REAL_HEAD_URL = "https://mqqapi//microapp/open?";
  private static final String URL_PREFIX_MINIGAME_PAY_BY_H5 = "https://h5.qzone.qq.com/miniapp/act/midasPay";
  private static final int canOpenApp = QzoneConfig.getInstance().getConfig("qqminiapp", "miniapp_able2show", 1);
  private OnRemoteRespObserver remoteRespObserver = new MiniAppPlugin.6(this);
  
  public MiniAppPlugin()
  {
    this.mPluginNameSpace = "miniApp";
  }
  
  private static MiniAppConfig buildMiniAppConfig(@NonNull Activity paramActivity, @NonNull MiniAppInfo paramMiniAppInfo)
  {
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(paramMiniAppInfo);
    LaunchParam localLaunchParam;
    if (localMiniAppConfig.launchParam != null) {
      localLaunchParam = localMiniAppConfig.launchParam;
    } else {
      localLaunchParam = new LaunchParam();
    }
    paramActivity = paramActivity.getIntent();
    int i;
    if (paramActivity.getBooleanExtra("fromAio", false))
    {
      if (paramActivity.getIntExtra("curtype", 0) == 0) {
        i = 1007;
      } else {
        i = 1008;
      }
    }
    else {
      i = 2009;
    }
    localLaunchParam.scene = i;
    localLaunchParam.miniAppId = paramMiniAppInfo.appId;
    localLaunchParam.reportData = paramMiniAppInfo.reportData;
    localMiniAppConfig.launchParam = localLaunchParam;
    return localMiniAppConfig;
  }
  
  private static String getFakeUrlFromShareUrl(String paramString)
  {
    Object localObject1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = null;
      if (paramString.startsWith("https://mqqapi//microapp/open?")) {
        localObject1 = "https://mqqapi//microapp/open?";
      } else if (paramString.startsWith("https://www.mqqapi.com//microapp/open?")) {
        localObject1 = "https://www.mqqapi.com//microapp/open?";
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return paramString;
      }
      Object localObject2 = getUrlParam(paramString, (String)localObject1);
      localObject1 = paramString;
      if (localObject2 != null)
      {
        localObject2 = ((HashMap)localObject2).entrySet().iterator();
        String str;
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)((Iterator)localObject2).next();
          str = (String)((Map.Entry)localObject1).getKey();
        } while ((TextUtils.isEmpty(str)) || (!str.equals("fakeUrl")));
        localObject1 = (String)((Map.Entry)localObject1).getValue();
      }
    }
    return localObject1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSchemaRequest: launch failed with url ");
    localStringBuilder.append(paramString);
    QLog.e("MiniAppPlugin", 1, localStringBuilder.toString());
  }
  
  private static boolean isMiniAppShareUrl(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
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
  
  private void queryMiniAppInfoIfNeeded()
  {
    if (this.mRuntime != null) {
      localObject = this.mRuntime.a();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    Object localObject = ((Activity)localObject).getIntent();
    if ((!((Intent)localObject).getBooleanExtra("fromAio", false)) && (!((Intent)localObject).getBooleanExtra("fromQZone", false))) {
      return;
    }
    localObject = ((Intent)localObject).getStringExtra("url");
    if (!URLUtil.isNetworkUrl((String)localObject)) {
      return;
    }
    if (!MiniAppLauncher.isMiniAppUrl(getFakeUrlFromShareUrl((String)localObject)))
    {
      if (isMiniAppShareUrl((String)localObject)) {
        return;
      }
      requestMiniAppInfoForNormalUrl((String)localObject);
    }
  }
  
  private void requestMiniAppInfoForNormalUrl(String paramString)
  {
    MiniAppCmdUtil.getInstance().getAppInfoByLink(paramString, 3, new MiniAppPlugin.3(this, paramString));
  }
  
  private void showOpenMiniAppDialog(String paramString, @NonNull MiniAppInfo paramMiniAppInfo)
  {
    Activity localActivity;
    if (this.mRuntime != null) {
      localActivity = this.mRuntime.a();
    } else {
      localActivity = null;
    }
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if ((Build.VERSION.SDK_INT >= 17) && (localActivity.isDestroyed())) {
        return;
      }
      MiniAppConfig localMiniAppConfig = buildMiniAppConfig(localActivity, paramMiniAppInfo);
      new LaunchConfirmDialogWrapper.Builder().setIconUrl(paramMiniAppInfo.iconUrl).setConfirmListener(new MiniAppPlugin.5(this, localActivity, localMiniAppConfig, paramString)).setCancelListener(new MiniAppPlugin.4(this, localMiniAppConfig, paramString)).build(localActivity).show();
    }
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) && (paramMap != null) && (paramLong == 8589934612L) && (paramMap.containsKey("errorCode")))
        {
          int i = ((Integer)paramMap.get("errorCode")).intValue();
          paramString = new StringBuilder();
          paramString.append("paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:");
          paramString.append(i);
          QLog.i("MiniAppPlugin", 1, paramString.toString());
          paramString = paramMap.get("requestData");
          if ((paramString instanceof WebResourceRequest))
          {
            paramString = (WebResourceRequest)paramString;
            if (paramString != null)
            {
              paramString = paramString.getUrl();
              if (paramString == null) {
                break label317;
              }
              paramString = paramString.toString();
              paramMap = new StringBuilder();
              paramMap.append("paybyh5 handleEvent realUrlStr:");
              paramMap.append(paramString);
              QLog.i("MiniAppPlugin", 1, paramMap.toString());
              if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")))
              {
                paramString = new Intent();
                paramString.putExtra("errCode", -3);
                paramMap = new StringBuilder();
                paramMap.append("EVENT_RECEIVER_HTTP_ERROR：");
                paramMap.append(i);
                paramString.putExtra("errMsg", paramMap.toString());
                paramString.putExtra("errType", 8589934612L);
                if ((this.mRuntime != null) && (this.mRuntime.a() != null))
                {
                  this.mRuntime.a().setResult(-1, paramString);
                  this.mRuntime.a().finish();
                }
              }
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("MiniAppPlugin", 1, "handleEvent error.", paramString);
      }
      return false;
      label317:
      paramString = "";
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleJsRequest, url=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", pkgName=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", methodName=");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("MiniAppPlugin", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("miniApp")))
    {
      if (paramString3 == null) {
        return false;
      }
      if (this.mRuntime != null)
      {
        if (this.mRuntime.a() == null) {
          return false;
        }
        boolean bool2 = paramString3.equals("openApp");
        paramString2 = null;
        localObject = null;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
        paramJsBridgeListener = paramString1;
        if (paramString1 == null) {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        }
        if (!paramJsBridgeListener.has("appid")) {
          break label1427;
        }
        paramString1 = paramJsBridgeListener.optString("appid");
        if (!paramJsBridgeListener.has("apptype")) {
          break label1432;
        }
        paramString2 = paramJsBridgeListener.optString("apptype");
        if (!paramJsBridgeListener.has("via")) {
          break label1437;
        }
        paramString3 = paramJsBridgeListener.optString("via");
        if (!paramJsBridgeListener.has("callback")) {
          break label1443;
        }
        paramVarArgs = paramJsBridgeListener.optString("callback");
        if (paramJsBridgeListener.has("path")) {
          localObject = paramJsBridgeListener.optString("path");
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
        paramJsBridgeListener.putString("miniapp_path", (String)localObject);
        sendRemoteReq(DataFactory.a("ipc_start_miniapp", paramVarArgs, this.remoteRespObserver.key, paramJsBridgeListener), false, false);
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("MiniAppPlugin", 1, "openApp error.", paramJsBridgeListener);
        return true;
      }
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
        if (paramVarArgs != null) {
          try
          {
            if (paramVarArgs.length > 0)
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramJsBridgeListener = paramString2;
              if (paramString1.has("callback")) {
                paramJsBridgeListener = paramString1.optString("callback");
              }
              if (paramVarArgs[0] != null)
              {
                if (QLog.isColorLevel())
                {
                  paramString1 = new StringBuilder();
                  paramString1.append("address_info");
                  paramString1.append(paramVarArgs[0]);
                  QLog.e("MiniAppPlugin", 1, paramString1.toString());
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
          }
          catch (Throwable paramJsBridgeListener)
          {
            QLog.e("MiniAppPlugin", 1, "chooseAddress error.", paramJsBridgeListener);
          }
        }
        return true;
      }
      bool1 = paramString3.equals("payCallback");
      paramJsBridgeListener = "";
      if (bool1)
      {
        try
        {
          paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          paramString2 = new StringBuilder();
          paramString2.append("payCallback");
          paramString2.append(paramString1);
          if (paramString2.toString() != null) {
            paramJsBridgeListener = paramString1.toString();
          }
          QLog.i("MiniAppPlugin", 1, paramJsBridgeListener);
          paramJsBridgeListener = new Intent();
          paramJsBridgeListener.putExtra("errCode", paramString1.optInt("errCode"));
          paramJsBridgeListener.putExtra("errMsg", paramString1.optString("errMsg"));
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            this.mRuntime.a().setResult(-1, paramJsBridgeListener);
            this.mRuntime.a().finish();
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "payCallback error.", paramJsBridgeListener);
        }
        return true;
      }
      if (paramString3.equals("closeFriendPaymentH5"))
      {
        if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
          this.mRuntime.a().setVisibility(8);
        }
        return true;
      }
      int i;
      if (paramString3.equals("shareFriendPayment"))
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return false;
        }
        try
        {
          paramString3 = paramJsBridgeListener.getString("prepayId");
          i = paramJsBridgeListener.optInt("setEnv", 0);
          paramString1 = paramJsBridgeListener.optString("title");
          paramString2 = paramJsBridgeListener.optString("imageUrl");
          paramJsBridgeListener = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramJsBridgeListener = GameWnsUtils.defaultPayShareTitle();
          }
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = GameWnsUtils.defaultPayShareImg();
          }
          paramString2 = new COMM.StCommonExt();
          paramVarArgs = new COMM.Entry();
          paramVarArgs.key.set("prepay_id");
          paramVarArgs.value.set(paramString3);
          paramString2.mapInfo.get().add(paramVarArgs);
          paramString3 = new COMM.Entry();
          paramString3.key.set("set_env");
          paramVarArgs = paramString3.value;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("");
          paramVarArgs.set(((StringBuilder)localObject).toString());
          paramString2.mapInfo.get().add(paramString3);
          if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof PayForFriendView)))
          {
            paramString3 = (PayForFriendView)this.mRuntime.a();
            paramVarArgs = paramString3.getAppId();
            localObject = paramString3.getAppName();
            String str1 = paramString3.getAppIconUrl();
            String str2 = paramString3.getAppVersionId();
            i = paramString3.getAppVerType();
            paramJsBridgeListener = new MiniArkShareModelBuilder().setAppId(paramVarArgs).setTitle((String)localObject).setDescription(paramJsBridgeListener).setShareScene(4).setShareTemplateType(1).setShareBusinessType(1).setPicUrl(paramString1).setVidUrl(null).setJumpUrl("").setIconUrl(str1).setVersionType(i).setVersionId(str2).setWebURL("").setTemplateId("").setTemplateData("").setEntryModel(null).setShareChatModel(null).setShareTarget(0).setRcvOpenId("").setWithShareTicket(false).setMiniAppShareFrom(13).setExtInfo(paramString2).createMiniArkShareModel();
            ShareQQArkHelper.a(this.mRuntime.a(), paramJsBridgeListener, null);
          }
          return true;
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "shareFriendPayment error.", paramJsBridgeListener);
          return false;
        }
      }
      if (paramString3.equals("closeWebview"))
      {
        try
        {
          paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          paramString2 = new StringBuilder();
          paramString2.append("closeWebview");
          paramString2.append(paramString1);
          if (paramString2.toString() != null) {
            paramJsBridgeListener = paramString1.toString();
          }
          QLog.i("MiniAppPlugin", 1, paramJsBridgeListener);
          paramJsBridgeListener = new Intent();
          i = paramString1.optInt("allClose", -1);
          if (i == -1) {
            QLog.e("MiniAppPlugin", 1, "no allClose back from h5");
          }
          paramJsBridgeListener.putExtra("allCloseState", i);
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            this.mRuntime.a().setResult(-1, paramJsBridgeListener);
            this.mRuntime.a().finish();
            return true;
          }
        }
        catch (Throwable paramJsBridgeListener)
        {
          QLog.e("MiniAppPlugin", 1, "closeWebview error.", paramJsBridgeListener);
        }
        return true;
      }
      return false;
      label1427:
      paramString1 = null;
      continue;
      label1432:
      paramString2 = null;
      continue;
      label1437:
      paramString3 = null;
      continue;
      label1443:
      paramVarArgs = null;
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
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
  
  protected void onActivityReady()
  {
    super.onActivityReady();
    queryMiniAppInfoIfNeeded();
  }
  
  protected void onCreate()
  {
    super.onCreate();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.remoteRespObserver);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.remoteRespObserver);
  }
  
  protected void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), HardCodeUtil.a(2131706865), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */
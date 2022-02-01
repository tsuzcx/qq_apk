package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.R.anim;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class InternalJSPlugin
  extends BaseJsPlugin
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "InternalJSPlugin";
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private void callbackOpenResult(InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback, boolean paramBoolean, String paramString)
  {
    if (paramOpenUrlCallback != null) {
      paramOpenUrlCallback.openResult(paramBoolean, paramString);
    }
  }
  
  private void confirmOpenAppDetailPage(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, RequestEvent paramRequestEvent)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.8(this, paramActivity, paramString3, paramString4, paramString1, paramString2, paramRequestEvent));
  }
  
  private void downloadApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, RequestEvent paramRequestEvent)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    int i;
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion())) {
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) == 1)
      {
        i = 1;
        j = i;
        if (i == 0) {
          AppBrandTask.runTaskOnUiThread(new InternalJSPlugin.6(this));
        }
      }
    }
    for (int j = i;; j = 1)
    {
      if ((paramInt != 1) && (j != 0))
      {
        confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramRequestEvent);
        return;
        i = 0;
        break;
      }
      QMLog.d("InternalJSPlugin", "only open");
      paramRequestEvent.fail(getLaunchAppRetJsonObject(3), "app not installed");
      return;
    }
  }
  
  @Nullable
  private Intent getIntent(String paramString1, PackageManager paramPackageManager, String paramString2)
  {
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      try
      {
        Object localObject1 = new JSONObject(paramString1);
        if ((((JSONObject)localObject1).has("path")) && (!TextUtils.isEmpty(((JSONObject)localObject1).optString("path")))) {
          return new Intent("android.intent.action.VIEW", Uri.parse(((JSONObject)localObject1).optString("path")));
        }
        Intent localIntent = paramPackageManager.getLaunchIntentForPackage(paramString2);
        localObject1 = localIntent;
        if (localIntent == null) {
          break label129;
        }
        localIntent.putExtra("appParameter", paramString1);
        return localIntent;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("InternalJSPlugin", "parameter error,", localThrowable);
        paramPackageManager = paramPackageManager.getLaunchIntentForPackage(paramString2);
        localObject2 = paramPackageManager;
        if (paramPackageManager == null) {
          break label129;
        }
      }
      paramPackageManager.putExtra("appParameter", paramString1);
      return paramPackageManager;
    }
    else
    {
      localObject2 = paramPackageManager.getLaunchIntentForPackage(paramString2);
    }
    label129:
    return localObject2;
  }
  
  @NotNull
  private JSONObject getLaunchAppRetJsonObject(int paramInt)
  {
    try
    {
      localJSONObject = new JSONObject();
      QMLog.e("InternalJSPlugin", "startExistedApp error, ", localJSONException1);
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localJSONObject.put("errCode", paramInt);
        return localJSONObject;
      }
      catch (JSONException localJSONException2)
      {
        JSONObject localJSONObject;
        break label21;
      }
      localJSONException1 = localJSONException1;
      localJSONObject = null;
    }
    label21:
    return localJSONObject;
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = WnsConfig.getConfig("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        QMLog.i("InternalJSPlugin", "getOpenUrlDomainWhiteList:" + str1);
        this.openUrlDomainWhiteList = new ArrayList();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!TextUtils.isEmpty(str2)) {
                this.openUrlDomainWhiteList.add(str2);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.privateOpenUrlDomainWhiteList = str1;
        }
      }
    }
  }
  
  private boolean isParamError(JSONObject paramJSONObject)
  {
    return (this.mMiniAppContext == null) || (this.mMiniAppContext.getAttachedActivity() == null) || (this.mMiniAppContext.getAttachedActivity().isFinishing()) || (paramJSONObject == null);
  }
  
  private void onOpenThirdApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, RequestEvent paramRequestEvent)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QMLog.d("InternalJSPlugin", "onOpenThridApp - appid : " + paramString1 + "; packageName : " + paramString2 + "; appName : " + paramString3);
      paramRequestEvent.fail("invalid parameter");
      return;
    }
    PackageManager localPackageManager = paramActivity.getPackageManager();
    try
    {
      if (localPackageManager.getPackageInfo(paramString2, 1) != null)
      {
        startExistedApp(paramActivity, paramString2, paramString3, paramString5, paramRequestEvent, localPackageManager);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString5)
    {
      downloadApp(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramRequestEvent);
      return;
      downloadApp(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramRequestEvent);
      return;
    }
    catch (Exception paramActivity)
    {
      QMLog.d("InternalJSPlugin", "open app err", paramActivity);
      paramRequestEvent.fail("open app err");
    }
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    while (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).downloadApp(paramContext, this.mMiniAppInfo, paramString1, paramString2, paramString3, paramString4)) {
      return;
    }
    MiniToast.makeText(paramContext, 0, "暂不支持在" + QUAUtil.getApplicationName(paramContext) + "中下载应用", 1);
  }
  
  private boolean openUrlForStyle(Bundle paramBundle, JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    if (paramJSONObject.has("style"))
    {
      int i = paramJSONObject.optInt("style");
      if ((i < 0) || (i > 2))
      {
        QMLog.e("InternalJSPlugin", "style error, return.");
        callbackOpenResult(paramOpenUrlCallback, false, "style error");
        return true;
      }
      switch (i)
      {
      default: 
        switch (paramJSONObject.optInt("navigationBarStyle"))
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
      return false;
      paramBundle.putBoolean("hide_more_button", false);
      paramBundle.putBoolean("hide_operation_bar", true);
      break;
      paramBundle.putBoolean("hide_more_button", true);
      paramBundle.putBoolean("hide_operation_bar", true);
      break;
      paramBundle.putBoolean("hide_more_button", false);
      paramBundle.putBoolean("hide_operation_bar", false);
      paramBundle.putString("webStyle", "");
      break;
      paramBundle.putBoolean("hide_more_button", true);
      paramBundle.putBoolean("hide_operation_bar", false);
      paramBundle.putString("webStyle", "");
      break;
      paramBundle.putBoolean("hide_left_button", true);
      paramBundle.putBoolean("show_right_close_button", true);
      break;
      paramBundle.putBoolean("isTransparentTitleAndClickable", true);
    }
  }
  
  private boolean openUrlForTarget(String paramString, JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    if (paramJSONObject.has("target"))
    {
      int i = paramJSONObject.optInt("target");
      if ((i < 0) || (i > 1))
      {
        callbackOpenResult(paramOpenUrlCallback, false, "target error");
        return true;
      }
      if (i == 1)
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("big_brother_source_key", "biz_src_miniapp");
        if (paramString.resolveActivity(this.mContext.getPackageManager()) != null)
        {
          QMLog.d("InternalJSPlugin", "openUrl by system webview.");
          this.mMiniAppContext.getAttachedActivity().startActivity(paramString);
          switch (paramJSONObject.optInt("animation"))
          {
          }
        }
        for (;;)
        {
          callbackOpenResult(paramOpenUrlCallback, true, null);
          return true;
          QMLog.d("InternalJSPlugin", "openUrl by system webview error.");
          break;
          this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
          continue;
          this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
        }
      }
    }
    return false;
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (paramString3 == null)) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new InternalJSPlugin.1(paramContext, paramString1, paramString2, paramString3));
  }
  
  private void startBrowserActivity(InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback, Intent paramIntent, MiniAppProxy paramMiniAppProxy, int paramInt)
  {
    paramMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), paramIntent);
    callbackOpenResult(paramOpenUrlCallback, true, null);
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
      return;
    }
    this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
  }
  
  private void startExistedApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent, PackageManager paramPackageManager)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.7(this, paramActivity, paramString2, paramString3, paramPackageManager, paramString1, paramRequestEvent));
  }
  
  @JsEvent({"getQua"})
  public void getQua(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", QUAUtil.getPlatformQUA());
      paramRequestEvent.ok(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("InternalJSPlugin", "getQua", localJSONException);
      }
    }
  }
  
  @JsEvent({"getStoreAppList"})
  public void getStoreAppList(RequestEvent paramRequestEvent)
  {
    if (TextUtils.isEmpty(""))
    {
      paramRequestEvent.fail("no dataCacheKey at app.json");
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new InternalJSPlugin.2(this, paramRequestEvent));
  }
  
  public void handleTuCaoUrl(RequestEvent paramRequestEvent, String paramString, MiniAppProxy paramMiniAppProxy)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        String str;
        QMLog.e("InternalJSPlugin", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
      paramRequestEvent.fail("url error");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      str = LoginManager.getInstance().getAccount();
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      localObject2 = paramString.replace("{openid}", (CharSequence)localObject2).replace("{clientVersion}", paramMiniAppProxy.getAppVersion()).replace("{platform}", "android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", NetworkUtil.getNetWorkTypeByStr(this.mContext)).replace("{avatar}", (CharSequence)localObject1);
      localObject1 = LoginManager.getInstance().getNickName();
      paramString = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString = "";
      }
      paramString = ((String)localObject2).replace("{nickname}", paramString);
      QMLog.d("InternalJSPlugin", "API_PRIVATE_OPENURL url : " + paramString);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("selfSet_leftViewText", "返回");
      ((Intent)localObject1).putExtra("hide_more_button", true);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("url", paramString);
      paramMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), (Intent)localObject1);
      paramRequestEvent.ok();
      if (paramString.startsWith("https://tucao.qq.com/qq_miniprogram"))
      {
        QMLog.d("InternalJSPlugin", "feedback, prepare to upload log ");
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.mMiniAppInfo.appId);
      }
      return;
    }
  }
  
  @JsEvent({"launchApplication"})
  public void launchApplication(RequestEvent paramRequestEvent)
  {
    QMLog.e("InternalJSPlugin", "openapp");
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("extInfo");
        String str1 = ((JSONObject)localObject).optString("appConnectId");
        String str2 = ((JSONObject)localObject).optString("appPackagename");
        localObject = ((JSONObject)localObject).optString("appParameter", "");
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getMiniAppInfo() == null) || (this.mMiniAppContext.getMiniAppInfo().launchParam == null)) {
          break label304;
        }
        j = this.mMiniAppContext.getMiniAppInfo().launchParam.scene;
        if (this.mMiniAppContext.canLaunchApp())
        {
          i = this.mMiniAppContext.getLaunchAppScene();
          QMLog.d("InternalJSPlugin", "API_LAUNCH_APP  realscene : " + j + "   scene:" + i);
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, str1, str2, i, new InternalJSPlugin.5(this, (String)localObject, paramRequestEvent, str1, str2));
            return;
          }
          QMLog.e("InternalJSPlugin", "launchApplication error, appBrandRuntime or getApkgInfo is null.");
          paramRequestEvent.fail(getLaunchAppRetJsonObject(-1), "appBrandRuntime or getApkgInfo is null.");
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("InternalJSPlugin", paramRequestEvent.event + " error,", localException);
        paramRequestEvent.fail(getLaunchAppRetJsonObject(-1), "exception");
        return;
      }
      int i = j;
      continue;
      label304:
      i = -1;
      int j = -1;
    }
  }
  
  @JsEvent({"notifyNative"})
  public void notifyNative(RequestEvent paramRequestEvent)
  {
    try
    {
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateEntryList(paramRequestEvent.jsonParams))
      {
        MiniToast.makeText(this.mMiniAppContext.getAttachedActivity(), 0, "暂不支持在" + QUAUtil.getApplicationName(this.mContext) + "中更新下拉列表", 1);
        paramRequestEvent.fail();
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("InternalJSPlugin", "notifyNative", localException);
      localException.printStackTrace();
      paramRequestEvent.fail();
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    getOpenUrlDomainWhiteList();
  }
  
  @JsEvent({"openUrl"})
  public void openUrl(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("url");
      if ((TextUtils.isEmpty(str)) || ("null".equals(str)))
      {
        paramRequestEvent.fail("url error");
        return;
      }
      openUrl(localJSONObject, new InternalJSPlugin.3(this, paramRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("InternalJSPlugin", paramRequestEvent.event + " error,", localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  public void openUrl(JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    for (;;)
    {
      String str;
      try
      {
        if (isParamError(paramJSONObject))
        {
          callbackOpenResult(paramOpenUrlCallback, false, "activity or json error.");
          QMLog.e("InternalJSPlugin", "openurl error, return.");
          return;
        }
        try
        {
          str = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty(str)) && (!"null".equals(str))) {
            break label97;
          }
          callbackOpenResult(paramOpenUrlCallback, false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          QMLog.e("InternalJSPlugin", "openUrl error; ", paramJSONObject);
          callbackOpenResult(paramOpenUrlCallback, false, "openUrl error");
        }
        continue;
        if (!AppBrandUtil.isOpenUrlFilter(str)) {
          break label117;
        }
      }
      finally {}
      label97:
      callbackOpenResult(paramOpenUrlCallback, false, "url is not support, hit filter");
      continue;
      label117:
      if (!openUrlForTarget(str, paramJSONObject, paramOpenUrlCallback))
      {
        Bundle localBundle = new Bundle();
        if (!openUrlForStyle(localBundle, paramJSONObject, paramOpenUrlCallback))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("articalChannelId", 0);
          if (!this.mMiniAppContext.getMiniAppInfo().isInternalApp()) {
            localIntent.setFlags(402653184);
          }
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
          localIntent.putExtras(localBundle);
          localIntent.putExtra("url", str);
          localIntent.putStringArrayListExtra("key_url_black_list", AppBrandUtil.getConfigFilter());
          int i = paramJSONObject.optInt("animation");
          if ((i < 0) || (i > 2))
          {
            QMLog.e("InternalJSPlugin", "animation error, return.");
            callbackOpenResult(paramOpenUrlCallback, false, "animation error");
          }
          else
          {
            startBrowserActivity(paramOpenUrlCallback, localIntent, (MiniAppProxy)ProxyManager.get(MiniAppProxy.class), i);
          }
        }
      }
    }
  }
  
  @JsEvent({"private_openUrl"})
  public void private_openUrl(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    String str;
    DomainConfig localDomainConfig;
    try
    {
      localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      QMLog.d("InternalJSPlugin", "API_PRIVATE_OPENURL " + localJSONObject);
      str = localJSONObject.optString("url");
      if (TextUtils.isEmpty(str))
      {
        paramRequestEvent.fail("url is empty");
        return;
      }
      boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
      localObject = str.toLowerCase();
      localDomainConfig = DomainConfig.getDomainConfig((String)localObject);
      if (bool) {
        break label154;
      }
      if (!this.mApkgInfo.isValidPrefix((String)localObject, false))
      {
        paramRequestEvent.fail("url is not https");
        return;
      }
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("InternalJSPlugin", "private_openUrl", paramRequestEvent);
      return;
    }
    if ((this.openUrlDomainWhiteList != null) && (!this.openUrlDomainWhiteList.contains(localDomainConfig.host)))
    {
      paramRequestEvent.fail("url domain not configured.");
      return;
    }
    label154:
    Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ("tucao.qq.com".equals(localDomainConfig.host))
    {
      handleTuCaoUrl(paramRequestEvent, str, (MiniAppProxy)localObject);
      return;
    }
    openUrl(localJSONObject, new InternalJSPlugin.4(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */
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
    int j;
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion()))
    {
      int i = 0;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_download_switch", 0) == 1) {
        i = 1;
      }
      j = i;
      if (i == 0)
      {
        AppBrandTask.runTaskOnUiThread(new InternalJSPlugin.6(this));
        j = i;
      }
    }
    else
    {
      j = 1;
    }
    if ((paramInt != 1) && (j != 0))
    {
      confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, paramRequestEvent);
      return;
    }
    QMLog.d("InternalJSPlugin", "only open");
    paramRequestEvent.fail(getLaunchAppRetJsonObject(3), "app not installed");
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
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errCode", paramInt);
        return localJSONObject;
      }
      catch (JSONException localJSONException1) {}
      QMLog.e("InternalJSPlugin", "startExistedApp error, ", localJSONException2);
    }
    catch (JSONException localJSONException2)
    {
      localJSONObject = null;
    }
    return localJSONObject;
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str = WnsConfig.getConfig("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str != null) && (!str.equals(this.privateOpenUrlDomainWhiteList)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getOpenUrlDomainWhiteList:");
        ((StringBuilder)localObject).append(str);
        QMLog.i("InternalJSPlugin", ((StringBuilder)localObject).toString());
        this.openUrlDomainWhiteList = new ArrayList();
        try
        {
          localObject = str.split(",");
          if (localObject != null)
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if (!TextUtils.isEmpty(localCharSequence)) {
                this.openUrlDomainWhiteList.add(localCharSequence);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.privateOpenUrlDomainWhiteList = str;
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
    PackageManager localPackageManager;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      localPackageManager = paramActivity.getPackageManager();
    }
    try
    {
      if (localPackageManager.getPackageInfo(paramString2, 1) != null)
      {
        startExistedApp(paramActivity, paramString2, paramString3, paramString5, paramRequestEvent, localPackageManager);
        return;
      }
      downloadApp(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramRequestEvent);
      return;
    }
    catch (Exception paramActivity)
    {
      QMLog.d("InternalJSPlugin", "open app err", paramActivity);
      paramRequestEvent.fail("open app err");
      return;
      downloadApp(paramActivity, paramString1, paramString2, paramString3, paramString4, paramInt, paramRequestEvent);
      return;
      paramActivity = new StringBuilder();
      paramActivity.append("onOpenThridApp - appid : ");
      paramActivity.append(paramString1);
      paramActivity.append("; packageName : ");
      paramActivity.append(paramString2);
      paramActivity.append("; appName : ");
      paramActivity.append(paramString3);
      QMLog.d("InternalJSPlugin", paramActivity.toString());
      paramRequestEvent.fail("invalid parameter");
      return;
    }
    catch (PackageManager.NameNotFoundException paramString5)
    {
      label92:
      break label92;
    }
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramContext == null) {
        return;
      }
      if (!((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).downloadApp(paramContext, this.mMiniAppInfo, paramString1, paramString2, paramString3, paramString4))
      {
        paramString1 = new StringBuilder();
        paramString1.append("暂不支持在");
        paramString1.append(QUAUtil.getApplicationName(paramContext));
        paramString1.append("中下载应用");
        MiniToast.makeText(paramContext, 0, paramString1.toString(), 1);
      }
    }
  }
  
  private boolean openUrlForStyle(Bundle paramBundle, JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    if (paramJSONObject.has("style"))
    {
      int i = paramJSONObject.optInt("style");
      if ((i >= 0) && (i <= 2))
      {
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4)
                {
                  paramBundle.putBoolean("hide_left_button", true);
                  paramBundle.putBoolean("show_right_close_button", true);
                }
              }
              else
              {
                paramBundle.putBoolean("hide_more_button", true);
                paramBundle.putBoolean("hide_operation_bar", false);
                paramBundle.putString("webStyle", "");
              }
            }
            else
            {
              paramBundle.putBoolean("hide_more_button", false);
              paramBundle.putBoolean("hide_operation_bar", false);
              paramBundle.putString("webStyle", "");
            }
          }
          else
          {
            paramBundle.putBoolean("hide_more_button", true);
            paramBundle.putBoolean("hide_operation_bar", true);
          }
        }
        else
        {
          paramBundle.putBoolean("hide_more_button", false);
          paramBundle.putBoolean("hide_operation_bar", true);
        }
        if (paramJSONObject.optInt("navigationBarStyle") == 1) {
          paramBundle.putBoolean("isTransparentTitleAndClickable", true);
        }
        paramBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
        return false;
      }
      QMLog.e("InternalJSPlugin", "style error, return.");
      callbackOpenResult(paramOpenUrlCallback, false, "style error");
      return true;
    }
    return false;
  }
  
  private boolean openUrlForTarget(String paramString, JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    if (paramJSONObject.has("target"))
    {
      int i = paramJSONObject.optInt("target");
      if ((i >= 0) && (i <= 1))
      {
        if (i == 1)
        {
          paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
          paramString.putExtra("big_brother_source_key", "biz_src_miniapp");
          if (paramString.resolveActivity(this.mContext.getPackageManager()) != null)
          {
            QMLog.d("InternalJSPlugin", "openUrl by system webview.");
            this.mMiniAppContext.getAttachedActivity().startActivity(paramString);
          }
          else
          {
            QMLog.d("InternalJSPlugin", "openUrl by system webview error.");
          }
          i = paramJSONObject.optInt("animation");
          if (i != 0) {
            if (i != 1)
            {
              if (i == 2) {
                this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
              }
            }
            else {
              this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
            }
          }
          callbackOpenResult(paramOpenUrlCallback, true, null);
          return true;
        }
      }
      else
      {
        callbackOpenResult(paramOpenUrlCallback, false, "target error");
        return true;
      }
    }
    return false;
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramContext != null))
    {
      if (paramString3 == null) {
        return;
      }
      ThreadManager.executeOnDiskIOThreadPool(new InternalJSPlugin.1(paramContext, paramString1, paramString2, paramString3));
    }
  }
  
  private void startBrowserActivity(InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback, Intent paramIntent, MiniAppProxy paramMiniAppProxy, int paramInt)
  {
    paramMiniAppProxy.startBrowserActivity(this.mMiniAppContext.getAttachedActivity(), paramIntent);
    callbackOpenResult(paramOpenUrlCallback, true, null);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.mMiniAppContext.getAttachedActivity().overridePendingTransition(R.anim.mini_sdk_slide_in_from_bottom, 0);
        return;
      }
      this.mMiniAppContext.getAttachedActivity().overridePendingTransition(0, 0);
    }
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
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("InternalJSPlugin", "getQua", localJSONException);
    }
    paramRequestEvent.ok(localJSONObject);
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
    String str2 = "";
    Object localObject2;
    Object localObject1;
    try
    {
      String str1 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startComplainAndCallback, url = ");
      ((StringBuilder)localObject2).append("");
      QMLog.e("InternalJSPlugin", ((StringBuilder)localObject2).toString());
      localUnsupportedEncodingException.printStackTrace();
      localObject1 = "";
    }
    if (!TextUtils.isEmpty(paramString))
    {
      String str3 = LoginManager.getInstance().getAccount();
      localObject2 = str3;
      if (str3 == null) {
        localObject2 = "";
      }
      localObject1 = paramString.replace("{openid}", (CharSequence)localObject2).replace("{clientVersion}", paramMiniAppProxy.getAppVersion()).replace("{platform}", "android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", NetworkUtil.getNetWorkTypeByStr(this.mContext)).replace("{avatar}", (CharSequence)localObject1);
      paramString = LoginManager.getInstance().getNickName();
      if (TextUtils.isEmpty(paramString)) {
        paramString = str2;
      }
      paramString = ((String)localObject1).replace("{nickname}", paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("API_PRIVATE_OPENURL url : ");
      ((StringBuilder)localObject1).append(paramString);
      QMLog.d("InternalJSPlugin", ((StringBuilder)localObject1).toString());
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
    }
    else
    {
      paramRequestEvent.fail("url error");
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
        Object localObject2 = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("extInfo");
        String str = ((JSONObject)localObject2).optString("appConnectId");
        localObject1 = ((JSONObject)localObject2).optString("appPackagename");
        localObject2 = ((JSONObject)localObject2).optString("appParameter", "");
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getMiniAppInfo() == null) || (this.mMiniAppContext.getMiniAppInfo().launchParam == null)) {
          break label333;
        }
        j = this.mMiniAppContext.getMiniAppInfo().launchParam.scene;
        if (this.mMiniAppContext.canLaunchApp())
        {
          i = this.mMiniAppContext.getLaunchAppScene();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("API_LAUNCH_APP  realscene : ");
          localStringBuilder.append(j);
          localStringBuilder.append("   scene:");
          localStringBuilder.append(i);
          QMLog.d("InternalJSPlugin", localStringBuilder.toString());
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getMiniAppInfo() != null))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.getMiniAppInfo().appId, str, (String)localObject1, i, new InternalJSPlugin.5(this, (String)localObject2, paramRequestEvent, str, (String)localObject1));
            return;
          }
          QMLog.e("InternalJSPlugin", "launchApplication error, appBrandRuntime or getApkgInfo is null.");
          paramRequestEvent.fail(getLaunchAppRetJsonObject(-1), "appBrandRuntime or getApkgInfo is null.");
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramRequestEvent.event);
        ((StringBuilder)localObject1).append(" error,");
        QMLog.e("InternalJSPlugin", ((StringBuilder)localObject1).toString(), localException);
        paramRequestEvent.fail(getLaunchAppRetJsonObject(-1), "exception");
        return;
      }
      int i = j;
      continue;
      label333:
      int j = -1;
      i = -1;
    }
  }
  
  @JsEvent({"notifyNative"})
  public void notifyNative(RequestEvent paramRequestEvent)
  {
    try
    {
      if (!((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateEntryList(paramRequestEvent.jsonParams))
      {
        Activity localActivity = this.mMiniAppContext.getAttachedActivity();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("暂不支持在");
        localStringBuilder.append(QUAUtil.getApplicationName(this.mContext));
        localStringBuilder.append("中更新下拉列表");
        MiniToast.makeText(localActivity, 0, localStringBuilder.toString(), 1);
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
      localObject = localJSONObject.optString("url");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject)))
      {
        openUrl(localJSONObject, new InternalJSPlugin.3(this, paramRequestEvent));
        return;
      }
      paramRequestEvent.fail("url error");
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramRequestEvent.event);
      ((StringBuilder)localObject).append(" error,");
      QMLog.e("InternalJSPlugin", ((StringBuilder)localObject).toString(), localJSONException);
      paramRequestEvent.fail();
    }
  }
  
  /* Error */
  public void openUrl(JSONObject paramJSONObject, InternalJSPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 644	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:isParamError	(Lorg/json/JSONObject;)Z
    //   7: ifeq +23 -> 30
    //   10: aload_0
    //   11: aload_2
    //   12: iconst_0
    //   13: ldc_w 646
    //   16: invokespecial 373	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:callbackOpenResult	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;ZLjava/lang/String;)V
    //   19: ldc 12
    //   21: ldc_w 648
    //   24: invokestatic 369	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_1
    //   31: ldc_w 533
    //   34: invokevirtual 169	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 5
    //   39: aload 5
    //   41: invokestatic 154	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne +240 -> 284
    //   47: ldc_w 636
    //   50: aload 5
    //   52: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +6 -> 61
    //   58: goto +226 -> 284
    //   61: aload 5
    //   63: invokestatic 653	com/tencent/qqmini/sdk/core/utils/AppBrandUtil:isOpenUrlFilter	(Ljava/lang/String;)Z
    //   66: ifeq +15 -> 81
    //   69: aload_0
    //   70: aload_2
    //   71: iconst_0
    //   72: ldc_w 655
    //   75: invokespecial 373	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:callbackOpenResult	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;ZLjava/lang/String;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: aload 5
    //   84: aload_1
    //   85: aload_2
    //   86: invokespecial 657	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:openUrlForTarget	(Ljava/lang/String;Lorg/json/JSONObject;Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;)Z
    //   89: istore 4
    //   91: iload 4
    //   93: ifeq +6 -> 99
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: new 336	android/os/Bundle
    //   102: dup
    //   103: invokespecial 658	android/os/Bundle:<init>	()V
    //   106: astore 6
    //   108: aload_0
    //   109: aload 6
    //   111: aload_1
    //   112: aload_2
    //   113: invokespecial 660	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:openUrlForStyle	(Landroid/os/Bundle;Lorg/json/JSONObject;Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;)Z
    //   116: istore 4
    //   118: iload 4
    //   120: ifeq +6 -> 126
    //   123: aload_0
    //   124: monitorexit
    //   125: return
    //   126: new 171	android/content/Intent
    //   129: dup
    //   130: invokespecial 524	android/content/Intent:<init>	()V
    //   133: astore 7
    //   135: aload 7
    //   137: ldc_w 662
    //   140: iconst_0
    //   141: invokevirtual 665	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   144: pop
    //   145: aload_0
    //   146: getfield 33	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   149: invokeinterface 574 1 0
    //   154: invokevirtual 668	com/tencent/qqmini/sdk/launcher/model/MiniAppInfo:isInternalApp	()Z
    //   157: ifne +12 -> 169
    //   160: aload 7
    //   162: ldc_w 669
    //   165: invokevirtual 673	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   168: pop
    //   169: aload 7
    //   171: ldc_w 675
    //   174: invokestatic 681	java/lang/System:currentTimeMillis	()J
    //   177: invokevirtual 684	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 379
    //   186: ldc_w 381
    //   189: invokevirtual 194	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   192: pop
    //   193: aload 7
    //   195: aload 6
    //   197: invokevirtual 688	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   200: pop
    //   201: aload 7
    //   203: ldc_w 533
    //   206: aload 5
    //   208: invokevirtual 194	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   211: pop
    //   212: aload 7
    //   214: ldc_w 690
    //   217: invokestatic 694	com/tencent/qqmini/sdk/core/utils/AppBrandUtil:getConfigFilter	()Ljava/util/ArrayList;
    //   220: invokevirtual 698	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   223: pop
    //   224: aload_1
    //   225: ldc_w 398
    //   228: invokevirtual 332	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   231: istore_3
    //   232: iload_3
    //   233: iflt +31 -> 264
    //   236: iload_3
    //   237: iconst_2
    //   238: if_icmple +6 -> 244
    //   241: goto +23 -> 264
    //   244: aload_0
    //   245: aload_2
    //   246: aload 7
    //   248: ldc_w 305
    //   251: invokestatic 103	com/tencent/qqmini/sdk/core/proxy/ProxyManager:get	(Ljava/lang/Class;)Ljava/lang/Object;
    //   254: checkcast 305	com/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy
    //   257: iload_3
    //   258: invokespecial 700	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:startBrowserActivity	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;Landroid/content/Intent;Lcom/tencent/qqmini/sdk/launcher/core/proxy/MiniAppProxy;I)V
    //   261: goto +54 -> 315
    //   264: ldc 12
    //   266: ldc_w 702
    //   269: invokestatic 369	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload_0
    //   273: aload_2
    //   274: iconst_0
    //   275: ldc_w 704
    //   278: invokespecial 373	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:callbackOpenResult	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;ZLjava/lang/String;)V
    //   281: aload_0
    //   282: monitorexit
    //   283: return
    //   284: aload_0
    //   285: aload_2
    //   286: iconst_0
    //   287: ldc_w 706
    //   290: invokespecial 373	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:callbackOpenResult	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;ZLjava/lang/String;)V
    //   293: aload_0
    //   294: monitorexit
    //   295: return
    //   296: astore_1
    //   297: ldc 12
    //   299: ldc_w 708
    //   302: aload_1
    //   303: invokestatic 200	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload_0
    //   307: aload_2
    //   308: iconst_0
    //   309: ldc_w 710
    //   312: invokespecial 373	com/tencent/qqmini/sdk/plugins/InternalJSPlugin:callbackOpenResult	(Lcom/tencent/qqmini/sdk/plugins/InternalJSPlugin$OpenUrlCallback;ZLjava/lang/String;)V
    //   315: aload_0
    //   316: monitorexit
    //   317: return
    //   318: astore_1
    //   319: aload_0
    //   320: monitorexit
    //   321: aload_1
    //   322: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	InternalJSPlugin
    //   0	323	1	paramJSONObject	JSONObject
    //   0	323	2	paramOpenUrlCallback	InternalJSPlugin.OpenUrlCallback
    //   231	27	3	i	int
    //   89	30	4	bool	boolean
    //   37	170	5	str	String
    //   106	90	6	localBundle	Bundle
    //   133	114	7	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   30	58	296	java/lang/Exception
    //   61	78	296	java/lang/Exception
    //   81	91	296	java/lang/Exception
    //   99	118	296	java/lang/Exception
    //   126	169	296	java/lang/Exception
    //   169	232	296	java/lang/Exception
    //   244	261	296	java/lang/Exception
    //   264	281	296	java/lang/Exception
    //   284	293	296	java/lang/Exception
    //   2	27	318	finally
    //   30	58	318	finally
    //   61	78	318	finally
    //   81	91	318	finally
    //   99	118	318	finally
    //   126	169	318	finally
    //   169	232	318	finally
    //   244	261	318	finally
    //   264	281	318	finally
    //   284	293	318	finally
    //   297	315	318	finally
  }
  
  @JsEvent({"private_openUrl"})
  public void private_openUrl(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("API_PRIVATE_OPENURL ");
      ((StringBuilder)localObject1).append(localJSONObject);
      QMLog.d("InternalJSPlugin", ((StringBuilder)localObject1).toString());
      localObject1 = localJSONObject.optString("url");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramRequestEvent.fail("url is empty");
        return;
      }
      boolean bool = localJSONObject.optBoolean("__skipDomainCheck__", false);
      Object localObject2 = ((String)localObject1).toLowerCase();
      DomainConfig localDomainConfig = DomainConfig.getDomainConfig((String)localObject2);
      if (!bool)
      {
        if (!this.mApkgInfo.isValidPrefix((String)localObject2, false))
        {
          paramRequestEvent.fail("url is not https");
          return;
        }
        if ((this.openUrlDomainWhiteList != null) && (!this.openUrlDomainWhiteList.contains(localDomainConfig.host)))
        {
          paramRequestEvent.fail("url domain not configured.");
          return;
        }
      }
      localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      if ("tucao.qq.com".equals(localDomainConfig.host))
      {
        handleTuCaoUrl(paramRequestEvent, (String)localObject1, (MiniAppProxy)localObject2);
        return;
      }
      openUrl(localJSONObject, new InternalJSPlugin.4(this, paramRequestEvent));
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("InternalJSPlugin", "private_openUrl", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import begz;
import beiw;
import bejy;
import beka;
import bekw;
import belj;
import bemw;
import beqy;
import besl;
import beuc;
import bfgt;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class InternalJSPlugin
  extends BaseJsPlugin
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "InternalJSPlugin";
  private ArrayList<String> openUrlDomainWhiteList;
  private String privateOpenUrlDomainWhiteList;
  
  private void confirmOpenAppDetailPage(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, beka parambeka)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.6(this, paramActivity, paramString3, paramString4, paramString1, paramString2, parambeka));
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = belj.a("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        besl.b("InternalJSPlugin", "getOpenUrlDomainWhiteList:" + str1);
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
  
  private void onOpenThirdApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, beka parambeka)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      besl.a("InternalJSPlugin", "onOpenThridApp - appid : " + paramString1 + "; packageName : " + paramString2 + "; appName : " + paramString3);
      parambeka.a("invalid parameter");
      return;
    }
    PackageManager localPackageManager = paramActivity.getPackageManager();
    try
    {
      if (localPackageManager.getPackageInfo(paramString2, 1) != null)
      {
        paramActivity.runOnUiThread(new InternalJSPlugin.5(this, paramActivity, paramString3, paramString5, localPackageManager, paramString2, parambeka));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString5)
    {
      if (paramInt == 1) {
        break label189;
      }
      confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, parambeka);
      return;
      if (paramInt != 1)
      {
        confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, paramString4, parambeka);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      besl.a("InternalJSPlugin", "open app err", paramActivity);
      parambeka.a("open app err");
      return;
    }
    besl.a("InternalJSPlugin", "only open");
    parambeka.a("app not installed");
    return;
    label189:
    besl.a("InternalJSPlugin", "only open");
    parambeka.a("app not installed");
  }
  
  private void openAppDetailPage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    while (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).downloadApp(paramContext, this.mMiniAppInfo, paramString1, paramString2, paramString3, paramString4)) {
      return;
    }
    bemw.a(paramContext, 0, "暂不支持在" + bfgt.a(paramContext) + "中下载应用", 1);
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (paramString3 == null)) {
      return;
    }
    beiw.b().post(new InternalJSPlugin.7(paramContext, paramString1, paramString2, paramString3));
  }
  
  public void getQua(beka parambeka)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", bfgt.b());
      parambeka.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        besl.d("InternalJSPlugin", "getQua", localJSONException);
      }
    }
  }
  
  public void getStoreAppList(beka parambeka)
  {
    if (TextUtils.isEmpty(""))
    {
      parambeka.a("no dataCacheKey at app.json");
      return;
    }
    beiw.b().post(new InternalJSPlugin.1(this, parambeka));
  }
  
  public void launchApplication(beka parambeka)
  {
    int i = -1;
    besl.d("InternalJSPlugin", "openapp");
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(parambeka.b).optJSONObject("extInfo");
        String str1 = ((JSONObject)localObject).optString("appConnectId");
        String str2 = ((JSONObject)localObject).optString("appPackagename");
        localObject = ((JSONObject)localObject).optString("appParameter", "");
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.a() == null) || (this.mMiniAppContext.a().launchParam == null)) {
          break label291;
        }
        j = this.mMiniAppContext.a().launchParam.a;
        if (this.mMiniAppContext.b())
        {
          i = this.mMiniAppContext.a();
          besl.a("InternalJSPlugin", "API_LAUNCH_APP  realscene : " + j + "   scene:" + i);
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.a().appId, str1, str2, i, new InternalJSPlugin.4(this, (String)localObject, parambeka, str1, str2));
            return;
          }
          besl.d("InternalJSPlugin", "launchApplication error, appBrandRuntime or getApkgInfo is null.");
          parambeka.a("appBrandRuntime or getApkgInfo is null.");
          return;
        }
      }
      catch (Exception localException)
      {
        besl.d("InternalJSPlugin", parambeka.a + " error,", localException);
        parambeka.b();
        return;
      }
      i = j;
      continue;
      label291:
      int j = -1;
    }
  }
  
  public void notifyNative(beka parambeka)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", parambeka.b);
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).callServer("MiniAppTransferModule", "update_entry_list", localBundle);
      parambeka.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        besl.d("InternalJSPlugin", "notifyNative", localException);
        localException.printStackTrace();
      }
    }
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    getOpenUrlDomainWhiteList();
  }
  
  public void openUrl(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      String str = localJSONObject.optString("url");
      if ((TextUtils.isEmpty(str)) || ("null".equals(str)))
      {
        parambeka.a("url error");
        return;
      }
      openUrl(localJSONObject, new InternalJSPlugin.2(this, parambeka));
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("InternalJSPlugin", parambeka.a + " error,", localJSONException);
      parambeka.b();
    }
  }
  
  public void openUrl(JSONObject paramJSONObject, InternalJSPlugin.openUrlCallback paramopenUrlCallback)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.a() == null) || (this.mMiniAppContext.a().isFinishing()) || (paramJSONObject == null))
        {
          if (paramopenUrlCallback != null) {
            paramopenUrlCallback.openResult(false, "activity or json error.");
          }
          besl.d("InternalJSPlugin", "openurl error, return.");
          return;
        }
        try
        {
          localObject = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
            break label142;
          }
          if (paramopenUrlCallback == null) {
            continue;
          }
          paramopenUrlCallback.openResult(false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          besl.d("InternalJSPlugin", "openUrl error; ", paramJSONObject);
        }
        if (paramopenUrlCallback == null) {
          continue;
        }
        paramopenUrlCallback.openResult(false, "openUrl error");
        continue;
        if (!paramJSONObject.has("target")) {
          break label354;
        }
      }
      finally {}
      label142:
      int i = paramJSONObject.optInt("target");
      if ((i < 0) || (i > 1))
      {
        if (paramopenUrlCallback != null) {
          paramopenUrlCallback.openResult(false, "target error");
        }
      }
      else
      {
        if (i == 1)
        {
          localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_miniapp");
          if (((Intent)localObject).resolveActivity(this.mContext.getPackageManager()) != null)
          {
            besl.a("InternalJSPlugin", "openUrl by system webview.");
            this.mMiniAppContext.a().startActivity((Intent)localObject);
          }
        }
        label257:
        label292:
        label352:
        label354:
        Bundle localBundle;
        switch (paramJSONObject.optInt("animation"))
        {
        case 0: 
        case 1: 
        case 2: 
          for (;;)
          {
            if (paramopenUrlCallback == null) {
              break label352;
            }
            paramopenUrlCallback.openResult(true, null);
            break;
            besl.a("InternalJSPlugin", "openUrl by system webview error.");
            break label257;
            this.mMiniAppContext.a().overridePendingTransition(0, 0);
            continue;
            this.mMiniAppContext.a().overridePendingTransition(2130772087, 0);
          }
          continue;
          localBundle = new Bundle();
          if (paramJSONObject.has("style"))
          {
            i = paramJSONObject.optInt("style");
            if ((i >= 0) && (i <= 2)) {
              break label797;
            }
            besl.d("InternalJSPlugin", "style error, return.");
            if (paramopenUrlCallback == null) {
              continue;
            }
            paramopenUrlCallback.openResult(false, "style error");
            continue;
            switch (paramJSONObject.optInt("navigationBarStyle"))
            {
            }
          }
        default: 
          for (;;)
          {
            label415:
            localBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
            MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            Intent localIntent = new Intent();
            localIntent.putExtra("articalChannelId", 0);
            if ((this.mMiniAppContext == null) || (!this.mMiniAppContext.a().isInternalApp())) {
              localIntent.setFlags(402653184);
            }
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtras(localBundle);
            localIntent.putExtra("url", (String)localObject);
            i = paramJSONObject.optInt("animation");
            if ((i < 0) || (i > 2))
            {
              besl.d("InternalJSPlugin", "animation error, return.");
              if (paramopenUrlCallback == null) {
                break;
              }
              paramopenUrlCallback.openResult(false, "animation error");
              break;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", true);
              break label415;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", true);
              break label415;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label415;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label415;
              localBundle.putBoolean("hide_left_button", true);
              localBundle.putBoolean("show_right_close_button", true);
              break label415;
              localBundle.putBoolean("isTransparentTitleAndClickable", true);
              continue;
            }
            localMiniAppProxy.startBrowserActivity(this.mMiniAppContext.a(), localIntent);
            if (paramopenUrlCallback == null) {
              break label838;
            }
            paramopenUrlCallback.openResult(true, null);
            break label838;
            this.mMiniAppContext.a().overridePendingTransition(0, 0);
            break;
            this.mMiniAppContext.a().overridePendingTransition(2130772087, 0);
            break;
            break label292;
            label797:
            switch (i)
            {
            }
            break label415;
          }
          label838:
          switch (i)
          {
          }
          break;
        }
      }
    }
  }
  
  public void private_openUrl(beka parambeka)
  {
    Object localObject1;
    String str2;
    String str1;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(parambeka.b);
      besl.a("InternalJSPlugin", "API_PRIVATE_OPENURL " + localObject1);
      str2 = ((JSONObject)localObject1).optString("url");
      if (TextUtils.isEmpty(str2))
      {
        parambeka.a("url is empty");
        return;
      }
      boolean bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
      str1 = str2.toLowerCase();
      localObject2 = beqy.a(str1);
      if (bool) {
        break label154;
      }
      if (!this.mApkgInfo.a(str1, false))
      {
        parambeka.a("url is not https");
        return;
      }
    }
    catch (Throwable parambeka)
    {
      besl.d("InternalJSPlugin", "private_openUrl", parambeka);
      return;
    }
    if ((this.openUrlDomainWhiteList != null) && (!this.openUrlDomainWhiteList.contains(((beqy)localObject2).a)))
    {
      parambeka.a("url domain not configured.");
      return;
    }
    label154:
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ("tucao.qq.com".equals(((beqy)localObject2).a))
    {
      localObject1 = "";
      try
      {
        localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          besl.d("InternalJSPlugin", "startComplainAndCallback, url = " + "");
          localUnsupportedEncodingException.printStackTrace();
        }
        parambeka.a("url error");
        return;
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = beuc.a().a();
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        str1 = str2.replace("{openid}", (CharSequence)localObject2).replace("{clientVersion}", localMiniAppProxy.getAppVersion()).replace("{platform}", "Android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", bekw.a(this.mContext)).replace("{avatar}", (CharSequence)localObject1);
        localObject2 = beuc.a().b();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject1 = str1.replace("{nickname}", (CharSequence)localObject1);
        besl.a("InternalJSPlugin", "API_PRIVATE_OPENURL url : " + (String)localObject1);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        localMiniAppProxy.startBrowserActivity(this.mMiniAppContext.a(), (Intent)localObject2);
        parambeka.a();
        if (!((String)localObject1).startsWith("https://tucao.qq.com/qq_miniprogram")) {
          return;
        }
        besl.a("InternalJSPlugin", "feedback, prepare to upload log ");
        parambeka = new Bundle();
        parambeka.putString("appid", this.mMiniAppInfo.appId);
        localMiniAppProxy.callServer("MiniAppTransferModule", "upload_user_log", parambeka);
        return;
      }
    }
    openUrl((JSONObject)localObject1, new InternalJSPlugin.3(this, parambeka));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */
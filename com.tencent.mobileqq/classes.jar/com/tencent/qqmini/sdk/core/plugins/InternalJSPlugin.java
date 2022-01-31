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
import bdcz;
import bdew;
import bdfx;
import bdfz;
import bdgt;
import bdhg;
import bdit;
import bdmp;
import bdnw;
import bdzd;
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
  
  private void confirmOpenAppDetailPage(Activity paramActivity, String paramString1, String paramString2, String paramString3, bdfz parambdfz)
  {
    paramActivity.runOnUiThread(new InternalJSPlugin.6(this, paramActivity, paramString3, paramString1, paramString2, parambdfz));
  }
  
  private void getOpenUrlDomainWhiteList()
  {
    if (this.openUrlDomainWhiteList == null)
    {
      String str1 = bdhg.a("qqminiapp", "domainWhiteList", "tucao.qq.com,mobile.qzone.qq.com");
      if ((str1 != null) && (!str1.equals(this.privateOpenUrlDomainWhiteList)))
      {
        bdnw.b("InternalJSPlugin", "getOpenUrlDomainWhiteList:" + str1);
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
  
  private void onOpenThirdApp(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, bdfz parambdfz)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      bdnw.a("InternalJSPlugin", "onOpenThridApp - appid : " + paramString1 + "; packageName : " + paramString2 + "; appName : " + paramString3);
      parambdfz.a("invalid parameter");
      return;
    }
    PackageManager localPackageManager = paramActivity.getPackageManager();
    try
    {
      if (localPackageManager.getPackageInfo(paramString2, 1) != null)
      {
        paramActivity.runOnUiThread(new InternalJSPlugin.5(this, paramActivity, paramString3, paramString4, localPackageManager, paramString2, parambdfz));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString4)
    {
      if (paramInt == 1) {
        break label185;
      }
      confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, parambdfz);
      return;
      if (paramInt != 1)
      {
        confirmOpenAppDetailPage(paramActivity, paramString1, paramString2, paramString3, parambdfz);
        return;
      }
    }
    catch (Exception paramActivity)
    {
      bdnw.a("InternalJSPlugin", "open app err", paramActivity);
      parambdfz.a("open app err");
      return;
    }
    bdnw.a("InternalJSPlugin", "only open");
    parambdfz.a("app not installed");
    return;
    label185:
    bdnw.a("InternalJSPlugin", "only open");
    parambdfz.a("app not installed");
  }
  
  private static void openAppDetailPage(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {}
    while (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openAppDetailPage(paramContext, paramString1, paramString2)) {
      return;
    }
    bdit.a(paramContext, 0, "暂不支持在" + bdzd.a(paramContext) + "中下载应用", 1);
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (paramString3 == null)) {
      return;
    }
    bdew.b().post(new InternalJSPlugin.7(paramContext, paramString1, paramString2, paramString3));
  }
  
  public void getQua(bdfz parambdfz)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("qua", bdzd.b());
      parambdfz.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bdnw.d("InternalJSPlugin", "getQua", localJSONException);
      }
    }
  }
  
  public void getStoreAppList(bdfz parambdfz)
  {
    if (TextUtils.isEmpty(""))
    {
      parambdfz.a("no dataCacheKey at app.json");
      return;
    }
    bdew.b().post(new InternalJSPlugin.1(this, parambdfz));
  }
  
  public void launchApplication(bdfz parambdfz)
  {
    int i = -1;
    bdnw.d("InternalJSPlugin", "openapp");
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(parambdfz.b).optJSONObject("extInfo");
        String str1 = ((JSONObject)localObject).optString("appConnectId");
        String str2 = ((JSONObject)localObject).optString("appPackagename");
        localObject = ((JSONObject)localObject).optString("appParameter", "");
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.a() == null) || (this.mMiniAppContext.a().launchParam == null)) {
          break label289;
        }
        j = this.mMiniAppContext.a().launchParam.a;
        if (this.mMiniAppContext.b())
        {
          i = this.mMiniAppContext.a();
          bdnw.a("InternalJSPlugin", "API_LAUNCH_APP  realscene : " + j + "   scene:" + i);
          if ((this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null))
          {
            ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getNativeAppInfoForJump(this.mMiniAppContext.a().appId, str1, str2, i, new InternalJSPlugin.4(this, (String)localObject, parambdfz, str1, str2));
            return;
          }
          bdnw.d("InternalJSPlugin", "launchApplication error, appBrandRuntime or getApkgInfo is null.");
          parambdfz.a("appBrandRuntime or getApkgInfo is null.");
          return;
        }
      }
      catch (Exception localException)
      {
        bdnw.d("InternalJSPlugin", parambdfz.a + " error,", localException);
        parambdfz.b();
        return;
      }
      i = j;
      continue;
      label289:
      int j = -1;
    }
  }
  
  public void notifyNative(bdfz parambdfz)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data", parambdfz.b);
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).callServer("MiniAppTransferModule", "update_entry_list", localBundle);
      parambdfz.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bdnw.d("InternalJSPlugin", "notifyNative", localException);
        localException.printStackTrace();
      }
    }
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    getOpenUrlDomainWhiteList();
  }
  
  public void openUrl(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      String str = localJSONObject.optString("url");
      if ((TextUtils.isEmpty(str)) || ("null".equals(str)))
      {
        parambdfz.a("url error");
        return;
      }
      openUrl(localJSONObject, new InternalJSPlugin.2(this, parambdfz));
      return;
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("InternalJSPlugin", parambdfz.a + " error,", localJSONException);
      parambdfz.b();
    }
  }
  
  public void openUrl(JSONObject paramJSONObject, InternalJSPlugin.openUrlCallback paramopenUrlCallback)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        if ((this.mMiniAppContext == null) || (this.mMiniAppContext.a() == null) || (this.mMiniAppContext.a().isFinishing()) || (paramJSONObject == null))
        {
          if (paramopenUrlCallback != null) {
            paramopenUrlCallback.openResult(false, "activity or json error.");
          }
          bdnw.d("InternalJSPlugin", "openurl error, return.");
          return;
        }
        try
        {
          localObject1 = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"null".equals(localObject1))) {
            break label142;
          }
          if (paramopenUrlCallback == null) {
            continue;
          }
          paramopenUrlCallback.openResult(false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          bdnw.d("InternalJSPlugin", "openUrl error; ", paramJSONObject);
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
          localObject1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_miniapp");
          if (((Intent)localObject1).resolveActivity(this.mContext.getPackageManager()) != null)
          {
            bdnw.a("InternalJSPlugin", "openUrl by system webview.");
            this.mMiniAppContext.a().startActivity((Intent)localObject1);
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
            bdnw.a("InternalJSPlugin", "openUrl by system webview error.");
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
              break label808;
            }
            bdnw.d("InternalJSPlugin", "style error, return.");
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
            Object localObject2 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            localObject2 = new Intent(this.mMiniAppContext.a(), ((MiniAppProxy)localObject2).getBrowserClass());
            ((Intent)localObject2).putExtra("articalChannelId", 0);
            if ((this.mMiniAppContext == null) || (!this.mMiniAppContext.a().isInternalApp())) {
              ((Intent)localObject2).setFlags(402653184);
            }
            ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject2).putExtras(localBundle);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            i = paramJSONObject.optInt("animation");
            if ((i < 0) || (i > 2))
            {
              bdnw.d("InternalJSPlugin", "animation error, return.");
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
            this.mMiniAppContext.a().startActivity((Intent)localObject2);
            if (paramopenUrlCallback == null) {
              break label850;
            }
            paramopenUrlCallback.openResult(true, null);
            break label850;
            this.mMiniAppContext.a().overridePendingTransition(0, 0);
            break;
            this.mMiniAppContext.a().overridePendingTransition(2130772087, 0);
            break;
            break label292;
            label808:
            switch (i)
            {
            }
            break label415;
          }
          label850:
          switch (i)
          {
          }
          break;
        }
      }
    }
  }
  
  public void private_openUrl(bdfz parambdfz)
  {
    Object localObject1;
    String str2;
    String str1;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(parambdfz.b);
      bdnw.a("InternalJSPlugin", "API_PRIVATE_OPENURL " + localObject1);
      str2 = ((JSONObject)localObject1).optString("url");
      if (TextUtils.isEmpty(str2))
      {
        parambdfz.a("url is empty");
        return;
      }
      boolean bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
      str1 = str2.toLowerCase();
      localObject2 = bdmp.a(str1);
      if (bool) {
        break label154;
      }
      if (!this.mApkgInfo.a(str1, false))
      {
        parambdfz.a("url is not https");
        return;
      }
    }
    catch (Throwable parambdfz)
    {
      bdnw.d("InternalJSPlugin", "private_openUrl", parambdfz);
      return;
    }
    if ((this.openUrlDomainWhiteList != null) && (!this.openUrlDomainWhiteList.contains(((bdmp)localObject2).a)))
    {
      parambdfz.a("url domain not configured.");
      return;
    }
    label154:
    MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ("tucao.qq.com".equals(((bdmp)localObject2).a))
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
          bdnw.d("InternalJSPlugin", "startComplainAndCallback, url = " + "");
          localUnsupportedEncodingException.printStackTrace();
        }
        parambdfz.a("url error");
        return;
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = localMiniAppProxy.getAccount();
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        str1 = str2.replace("{openid}", (CharSequence)localObject2).replace("{clientVersion}", localMiniAppProxy.getAppVersion()).replace("{platform}", "Android").replace("{osVersion}", String.valueOf(Build.VERSION.SDK_INT)).replace("{netType}", bdgt.a(this.mContext)).replace("{avatar}", (CharSequence)localObject1);
        localObject2 = localMiniAppProxy.getNickName();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject1 = str1.replace("{nickname}", (CharSequence)localObject1);
        bdnw.a("InternalJSPlugin", "API_PRIVATE_OPENURL url : " + (String)localObject1);
        localObject2 = new Intent(this.mMiniAppContext.a(), localMiniAppProxy.getBrowserClass());
        ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        this.mMiniAppContext.a().startActivity((Intent)localObject2);
        parambdfz.a();
        if (!((String)localObject1).startsWith("https://tucao.qq.com/qq_miniprogram")) {
          return;
        }
        bdnw.a("InternalJSPlugin", "feedback, prepare to upload log ");
        parambdfz = new Bundle();
        parambdfz.putString("appid", this.mMiniAppInfo.appId);
        localMiniAppProxy.callServer("MiniAppTransferModule", "upload_user_log", parambdfz);
        return;
      }
    }
    openUrl((JSONObject)localObject1, new InternalJSPlugin.3(this, parambdfz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin
 * JD-Core Version:    0.7.0.1
 */
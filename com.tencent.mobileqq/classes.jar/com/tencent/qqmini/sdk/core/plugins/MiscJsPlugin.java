package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import behq;
import bekr;
import betc;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class MiscJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "MiscJsPlugin";
  
  public static void openUrl(JSONObject paramJSONObject, behq parambehq, MiscJsPlugin.OpenUrlCallback paramOpenUrlCallback)
  {
    if (parambehq != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if ((parambehq.a() == null) || (parambehq.a().isFinishing()) || (paramJSONObject == null))
        {
          if (paramOpenUrlCallback != null) {
            paramOpenUrlCallback.openResult(false, "activity or json error.");
          }
          betc.d("MiscJsPlugin", "openurl error, return.");
          return;
        }
        try
        {
          localObject = paramJSONObject.optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
            break label148;
          }
          if (paramOpenUrlCallback == null) {
            continue;
          }
          paramOpenUrlCallback.openResult(false, "url is null.");
        }
        catch (Exception paramJSONObject)
        {
          betc.d("MiscJsPlugin", "openUrl error; " + Log.getStackTraceString(paramJSONObject));
        }
        if (paramOpenUrlCallback == null) {
          continue;
        }
        paramOpenUrlCallback.openResult(false, "openUrl error");
        continue;
        if (!paramJSONObject.has("target")) {
          break label342;
        }
      }
      finally {}
      label148:
      int i = paramJSONObject.optInt("target");
      if ((i < 0) || (i > 1))
      {
        if (paramOpenUrlCallback != null) {
          paramOpenUrlCallback.openResult(false, "target error");
        }
      }
      else
      {
        if (i == 1)
        {
          localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
          ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_miniapp");
          if (((Intent)localObject).resolveActivity(parambehq.a().getPackageManager()) != null)
          {
            betc.a("MiscJsPlugin", "openUrl by system webview.");
            parambehq.a().startActivity((Intent)localObject);
          }
        }
        label255:
        Bundle localBundle;
        switch (paramJSONObject.optInt("animation"))
        {
        case 0: 
        case 1: 
        case 2: 
          for (;;)
          {
            if (paramOpenUrlCallback == null) {
              break label340;
            }
            paramOpenUrlCallback.openResult(true, null);
            break;
            betc.a("MiscJsPlugin", "openUrl by system webview error.");
            break label255;
            parambehq.a().overridePendingTransition(0, 0);
            continue;
            parambehq.a().overridePendingTransition(2130772087, 0);
          }
          continue;
          localBundle = new Bundle();
          if (paramJSONObject.has("style"))
          {
            i = paramJSONObject.optInt("style");
            if ((i >= 0) && (i <= 2)) {
              break label739;
            }
            betc.d("MiscJsPlugin", "style error, return.");
            if (paramOpenUrlCallback == null) {
              continue;
            }
            paramOpenUrlCallback.openResult(false, "style error");
            continue;
            switch (paramJSONObject.optInt("navigationBarStyle"))
            {
            }
          }
        default: 
          for (;;)
          {
            label288:
            label340:
            label342:
            localBundle.putBoolean("hide_title_left_arrow", paramJSONObject.optBoolean("hideLeftArrow", false));
            label399:
            MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
            Intent localIntent = new Intent();
            if ((parambehq.a() != null) && (parambehq.a().isInternalApp())) {
              localIntent.setFlags(402653184);
            }
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            localIntent.putExtras(localBundle);
            localIntent.putExtra("url", (String)localObject);
            i = paramJSONObject.optInt("animation");
            if ((i < 0) || (i > 2))
            {
              betc.d("MiscJsPlugin", "animation error, return.");
              if (paramOpenUrlCallback == null) {
                break;
              }
              paramOpenUrlCallback.openResult(false, "animation error");
              break;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", true);
              break label399;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", true);
              break label399;
              localBundle.putBoolean("hide_more_button", false);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label399;
              localBundle.putBoolean("hide_more_button", true);
              localBundle.putBoolean("hide_operation_bar", false);
              localBundle.putString("webStyle", "");
              break label399;
              localBundle.putBoolean("hide_left_button", true);
              localBundle.putBoolean("show_right_close_button", true);
              break label399;
              localBundle.putBoolean("isTransparentTitleAndClickable", true);
              continue;
            }
            localMiniAppProxy.startBrowserActivity(parambehq.a(), localIntent);
            if (paramOpenUrlCallback == null) {
              break label782;
            }
            paramOpenUrlCallback.openResult(true, null);
            break label782;
            parambehq.a().overridePendingTransition(0, 0);
            break;
            parambehq.a().overridePendingTransition(2130772087, 0);
            break;
            break label288;
            label739:
            switch (i)
            {
            }
            break label399;
          }
          label782:
          switch (i)
          {
          }
          break;
        }
      }
    }
  }
  
  public void openUrl(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      String str = localJSONObject.optString("url");
      if ((TextUtils.isEmpty(str)) || ("null".equals(str))) {
        parambekr.a("url error");
      }
      openUrl(localJSONObject, this.mMiniAppContext, new MiscJsPlugin.2(this, parambekr));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("MiscJsPlugin", parambekr.a + " error,", localJSONException);
      parambekr.b();
    }
  }
  
  public void saveAppToDesktop(bekr parambekr)
  {
    try
    {
      if (this.mMiniAppInfo.appMode.j)
      {
        betc.d("MiscJsPlugin", "app is limited access");
        parambekr.b();
        return;
      }
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).addShortcut(this.mMiniAppContext.a(), this.mMiniAppInfo, new MiscJsPlugin.1(this, parambekr));
      return;
    }
    catch (Exception localException)
    {
      betc.d("MiscJsPlugin", localException.getMessage(), localException);
      parambekr.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.MiscJsPlugin
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import bglv;
import bgmk;
import bgok;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class LogJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
  public static final String TAG = "LogJsPlugin";
  private static final String TAG_MINI_LOG = "miniAppLog";
  
  public boolean onInterceptJsEvent(bgok parambgok)
  {
    if ((!this.mIsMiniGame) && ("setEnableDebug".equals(parambgok)))
    {
      this.mMiniAppContext.a(bgmk.a(parambgok, 3));
      return true;
    }
    return super.onInterceptJsEvent(parambgok);
  }
  
  public String setEnableDebug(bgok parambgok)
  {
    try
    {
      boolean bool = new JSONObject(parambgok.b).optBoolean("enableDebug");
      if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mMiniAppContext.a().appId + "_debug", false)).booleanValue()) {
        this.mMiniAppContext.a().runOnUiThread(new LogJsPlugin.1(this, bool));
      }
      for (;;)
      {
        return "";
        parambgok.a();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        parambgok.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */
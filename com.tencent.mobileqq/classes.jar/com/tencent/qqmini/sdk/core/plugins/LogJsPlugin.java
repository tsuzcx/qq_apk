package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import begz;
import bejs;
import beka;
import bfgv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class LogJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
  public static final String TAG = "LogJsPlugin";
  private static final String TAG_MINI_LOG = "miniAppLog";
  
  public boolean onInterceptJsEvent(beka parambeka)
  {
    if ((!this.mIsMiniGame) && ("setEnableDebug".equals(parambeka)))
    {
      this.mMiniAppContext.a(bejs.a(parambeka, 3));
      return true;
    }
    return super.onInterceptJsEvent(parambeka);
  }
  
  public String setEnableDebug(beka parambeka)
  {
    try
    {
      boolean bool = new JSONObject(parambeka.b).optBoolean("enableDebug");
      if (bool != Boolean.valueOf(bfgv.a().getBoolean(this.mMiniAppContext.a().appId + "_debug", false)).booleanValue()) {
        this.mMiniAppContext.a().runOnUiThread(new LogJsPlugin.1(this, bool));
      }
      for (;;)
      {
        return "";
        parambeka.a();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        parambeka.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */
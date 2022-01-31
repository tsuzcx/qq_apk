package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import bdcz;
import bdfs;
import bdfz;
import bdzf;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class LogJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_ENABLE_DEBUG = "setEnableDebug";
  public static final String TAG = "LogJsPlugin";
  private static final String TAG_MINI_LOG = "miniAppLog";
  
  public boolean onInterceptJsEvent(bdfz parambdfz)
  {
    if ((!this.mIsMiniGame) && ("setEnableDebug".equals(parambdfz)))
    {
      this.mMiniAppContext.a(bdfs.a(parambdfz, 3));
      return true;
    }
    return super.onInterceptJsEvent(parambdfz);
  }
  
  public String setEnableDebug(bdfz parambdfz)
  {
    try
    {
      boolean bool = new JSONObject(parambdfz.b).optBoolean("enableDebug");
      if (bool != Boolean.valueOf(bdzf.a().getBoolean(this.mMiniAppContext.a().appId + "_debug", false)).booleanValue()) {
        this.mMiniAppContext.a().runOnUiThread(new LogJsPlugin.1(this, bool));
      }
      for (;;)
      {
        return "";
        parambdfz.a();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        parambdfz.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */
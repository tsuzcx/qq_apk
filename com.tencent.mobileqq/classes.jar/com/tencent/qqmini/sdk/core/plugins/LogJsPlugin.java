package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.SharedPreferences;
import bgho;
import bgid;
import bgkd;
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
  
  public boolean onInterceptJsEvent(bgkd parambgkd)
  {
    if ((!this.mIsMiniGame) && ("setEnableDebug".equals(parambgkd)))
    {
      this.mMiniAppContext.a(bgid.a(parambgkd, 3));
      return true;
    }
    return super.onInterceptJsEvent(parambgkd);
  }
  
  public String setEnableDebug(bgkd parambgkd)
  {
    try
    {
      boolean bool = new JSONObject(parambgkd.b).optBoolean("enableDebug");
      if (bool != Boolean.valueOf(StorageUtil.getPreference().getBoolean(this.mMiniAppContext.a().appId + "_debug", false)).booleanValue()) {
        this.mMiniAppContext.a().runOnUiThread(new LogJsPlugin.1(this, bool));
      }
      for (;;)
      {
        return "";
        parambgkd.a();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        parambgkd.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.LogJsPlugin
 * JD-Core Version:    0.7.0.1
 */
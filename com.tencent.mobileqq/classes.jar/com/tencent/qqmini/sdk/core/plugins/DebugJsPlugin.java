package com.tencent.qqmini.sdk.core.plugins;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import bgho;
import bgjw;
import bgkd;
import org.json.JSONException;
import org.json.JSONObject;

public class DebugJsPlugin
  extends BaseJsPlugin
{
  private String mAppId;
  private SharedPreferences mSharedPref;
  
  public void onCreate(bgho parambgho)
  {
    super.onCreate(parambgho);
    this.mAppId = this.mApkgInfo.appId;
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
  }
  
  public void setEnableDebug(bgkd parambgkd)
  {
    try
    {
      boolean bool = new JSONObject(parambgkd.b).optBoolean("enableDebug");
      if (this.mAppId != null)
      {
        if (bool != Boolean.valueOf(this.mSharedPref.getBoolean(this.mAppId + "_debug", false)).booleanValue())
        {
          new AlertDialog.Builder(this.mContext).setTitle("重启后生效").setPositiveButton(17039370, new DebugJsPlugin.1(this, bool)).create().show();
          return;
        }
        parambgkd.a();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      parambgkd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DebugJsPlugin
 * JD-Core Version:    0.7.0.1
 */
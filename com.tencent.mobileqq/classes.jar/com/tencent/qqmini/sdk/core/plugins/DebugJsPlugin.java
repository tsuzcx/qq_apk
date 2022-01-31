package com.tencent.qqmini.sdk.core.plugins;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import begz;
import bejy;
import beka;
import org.json.JSONException;
import org.json.JSONObject;

public class DebugJsPlugin
  extends BaseJsPlugin
{
  private String mAppId;
  private SharedPreferences mSharedPref;
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    this.mAppId = this.mApkgInfo.d;
    this.mSharedPref = this.mContext.getSharedPreferences("miniapp", 4);
  }
  
  public void setEnableDebug(beka parambeka)
  {
    try
    {
      boolean bool = new JSONObject(parambeka.b).optBoolean("enableDebug");
      if (this.mAppId != null)
      {
        if (bool != Boolean.valueOf(this.mSharedPref.getBoolean(this.mAppId + "_debug", false)).booleanValue())
        {
          new AlertDialog.Builder(this.mContext).setTitle("重启后生效").setPositiveButton(17039370, new DebugJsPlugin.1(this, bool)).create().show();
          return;
        }
        parambeka.a();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      parambeka.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DebugJsPlugin
 * JD-Core Version:    0.7.0.1
 */
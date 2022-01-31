package com.tencent.qqmini.sdk.minigame.plugins;

import bgkd;
import bgkk;
import bgnf;
import bgnw;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGameUIJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_HIDE_LOADING = "hideLoading";
  public static final String EVENT_HIDE_TOAST = "hideToast";
  public static final String EVENT_SHOW_LOADING = "showLoading";
  public static final String EVENT_SHOW_TOAST = "showToast";
  private static final String TAG = "MiniGameUIJsPlugin";
  private bgnf toast;
  private bgnw toastView;
  
  public void hideToastOrLoading(bgkd parambgkd)
  {
    bgkk.a(new MiniGameUIJsPlugin.2(this, parambgkd));
  }
  
  public void showLoading(bgkd parambgkd)
  {
    bgkk.a(new MiniGameUIJsPlugin.3(this, parambgkd));
  }
  
  public void showToast(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      bgkk.a(new MiniGameUIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, parambgkd));
      return;
    }
    catch (JSONException parambgkd)
    {
      QMLog.e("MiniGameUIJsPlugin", parambgkd.getMessage(), parambgkd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
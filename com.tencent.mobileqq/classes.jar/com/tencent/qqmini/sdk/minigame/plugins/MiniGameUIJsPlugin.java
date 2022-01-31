package com.tencent.qqmini.sdk.minigame.plugins;

import bgok;
import bgor;
import bgrm;
import bgsd;
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
  private bgrm toast;
  private bgsd toastView;
  
  public void hideToastOrLoading(bgok parambgok)
  {
    bgor.a(new MiniGameUIJsPlugin.2(this, parambgok));
  }
  
  public void showLoading(bgok parambgok)
  {
    bgor.a(new MiniGameUIJsPlugin.3(this, parambgok));
  }
  
  public void showToast(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      bgor.a(new MiniGameUIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, parambgok));
      return;
    }
    catch (JSONException parambgok)
    {
      QMLog.e("MiniGameUIJsPlugin", parambgok.getMessage(), parambgok);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
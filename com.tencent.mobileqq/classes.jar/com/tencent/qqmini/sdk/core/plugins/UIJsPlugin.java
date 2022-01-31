package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import bdcz;
import bdfs;
import bdfz;
import bdgi;
import bdit;
import bdjb;
import bdnw;
import org.json.JSONException;
import org.json.JSONObject;

public class UIJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
  public static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
  public static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
  private static final String TAG = "UIJsPlugin";
  private bdit toast;
  private bdjb toastView;
  
  public void doInterceptJsEvent(bdfz parambdfz)
  {
    this.mMiniAppContext.a(bdfs.a(parambdfz, 2));
  }
  
  public void hideToastOrLoading(bdfz parambdfz)
  {
    bdgi.a(new UIJsPlugin.2(this, parambdfz));
  }
  
  public void showLoading(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.b);
      String str = ((JSONObject)localObject).optString("title", "");
      boolean bool = ((JSONObject)localObject).optBoolean("mask", false);
      localObject = this.mMiniAppContext.a();
      if (this.toastView == null) {
        this.toastView = new bdjb((Context)localObject, (ViewGroup)((Activity)localObject).findViewById(16908290));
      }
      for (;;)
      {
        this.toastView.a(1, "loading", null, str, -1, bool);
        parambdfz.a();
        return;
        this.toastView.a();
      }
      return;
    }
    catch (JSONException parambdfz)
    {
      Log.e("UIJsPlugin", parambdfz.getMessage(), parambdfz);
    }
  }
  
  public void showModal(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      String str1 = localJSONObject.optString("title", "");
      String str2 = localJSONObject.optString("content", "");
      boolean bool = localJSONObject.optBoolean("showCancel", true);
      String str3 = localJSONObject.optString("cancelText", "取消");
      String str4 = localJSONObject.optString("cancelColor", "#000000");
      bdgi.a(new UIJsPlugin.3(this, str1, str2, localJSONObject.optString("confirmText", "确定"), localJSONObject.optString("confirmColor", "#3CC51F"), parambdfz, bool, str3, str4));
      return;
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("UIJsPlugin", parambdfz.a + " error.", localJSONException);
    }
  }
  
  public void showToast(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      bdgi.a(new UIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, parambdfz));
      return;
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("UIJsPlugin", parambdfz.getMessage(), parambdfz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
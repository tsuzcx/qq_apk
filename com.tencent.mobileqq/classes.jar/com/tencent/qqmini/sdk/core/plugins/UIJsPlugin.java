package com.tencent.qqmini.sdk.core.plugins;

import begz;
import bejs;
import beka;
import beki;
import bemw;
import bene;
import besl;
import org.json.JSONException;
import org.json.JSONObject;

public class UIJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_MENU_BUTTON_RECT = "getMenuButtonBoundingClientRect";
  public static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
  public static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
  public static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
  private static final String TAG = "UIJsPlugin";
  private bemw toast;
  private bene toastView;
  
  public String doInterceptJsEvent(beka parambeka)
  {
    return (String)this.mMiniAppContext.a(bejs.a(parambeka, 2));
  }
  
  public void hideToastOrLoading(beka parambeka)
  {
    beki.a(new UIJsPlugin.2(this, parambeka));
  }
  
  public void showLoading(beka parambeka)
  {
    beki.a(new UIJsPlugin.3(this, parambeka));
  }
  
  public void showModal(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      String str1 = localJSONObject.optString("title", "");
      String str2 = localJSONObject.optString("content", "");
      boolean bool = localJSONObject.optBoolean("showCancel", true);
      String str3 = localJSONObject.optString("cancelText", "取消");
      String str4 = localJSONObject.optString("cancelColor", "#000000");
      beki.a(new UIJsPlugin.4(this, str1, str2, localJSONObject.optString("confirmText", "确定"), localJSONObject.optString("confirmColor", "#3CC51F"), parambeka, bool, str3, str4));
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("UIJsPlugin", parambeka.a + " error.", localJSONException);
    }
  }
  
  public void showToast(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      beki.a(new UIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, parambeka));
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("UIJsPlugin", parambeka.getMessage(), parambeka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
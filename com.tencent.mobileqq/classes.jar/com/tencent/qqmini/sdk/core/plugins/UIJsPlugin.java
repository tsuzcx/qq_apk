package com.tencent.qqmini.sdk.core.plugins;

import behq;
import bekj;
import bekr;
import bekz;
import benn;
import benv;
import betc;
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
  private benn toast;
  private benv toastView;
  
  public String doInterceptJsEvent(bekr parambekr)
  {
    return (String)this.mMiniAppContext.a(bekj.a(parambekr, 2));
  }
  
  public void hideToastOrLoading(bekr parambekr)
  {
    bekz.a(new UIJsPlugin.2(this, parambekr));
  }
  
  public void showLoading(bekr parambekr)
  {
    bekz.a(new UIJsPlugin.3(this, parambekr));
  }
  
  public void showModal(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      String str1 = localJSONObject.optString("title", "");
      String str2 = localJSONObject.optString("content", "");
      boolean bool = localJSONObject.optBoolean("showCancel", true);
      String str3 = localJSONObject.optString("cancelText", "取消");
      String str4 = localJSONObject.optString("cancelColor", "#000000");
      bekz.a(new UIJsPlugin.4(this, str1, str2, localJSONObject.optString("confirmText", "确定"), localJSONObject.optString("confirmColor", "#3CC51F"), parambekr, bool, str3, str4));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("UIJsPlugin", parambekr.a + " error.", localJSONException);
    }
  }
  
  public void showToast(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      bekz.a(new UIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, parambekr));
      return;
    }
    catch (JSONException parambekr)
    {
      betc.d("UIJsPlugin", parambekr.getMessage(), parambekr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
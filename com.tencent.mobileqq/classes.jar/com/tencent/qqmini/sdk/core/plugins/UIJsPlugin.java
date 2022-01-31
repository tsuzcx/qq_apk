package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgid;
import bgkd;
import bgkk;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class UIJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_MENU_BUTTON_RECT = "getMenuButtonBoundingClientRect";
  public static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
  public static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
  public static final String EVENT_SHOW_MODAL = "showModal";
  public static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
  private static final String TAG = "UIJsPlugin";
  
  public String doInterceptJsEvent(bgkd parambgkd)
  {
    return (String)this.mMiniAppContext.a(bgid.a(parambgkd, 2));
  }
  
  public void showModal(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      String str1 = localJSONObject.optString("title", "");
      String str2 = localJSONObject.optString("content", "");
      boolean bool = localJSONObject.optBoolean("showCancel", true);
      String str3 = localJSONObject.optString("cancelText", "取消");
      String str4 = localJSONObject.optString("cancelColor", "#000000");
      bgkk.a(new UIJsPlugin.1(this, str1, str2, localJSONObject.optString("confirmText", "确定"), localJSONObject.optString("confirmColor", "#3CC51F"), parambgkd, bool, str3, str4));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("UIJsPlugin", parambgkd.a + " error.", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
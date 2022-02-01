package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class UIJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_MENU_BUTTON_RECT = "getMenuButtonBoundingClientRect";
  public static final String EVENT_HIDE_HOME_BUTTON = "hideHomeButton";
  public static final String EVENT_HIDE_LOADING = "hideLoading";
  public static final String EVENT_HIDE_TOAST = "hideToast";
  public static final String EVENT_INSERT_TEXTAREA = "insertTextArea";
  public static final String EVENT_REMOVE_TEXTAREA = "removeTextArea";
  public static final String EVENT_SHOW_LOADING = "showLoading";
  public static final String EVENT_SHOW_MODAL = "showModal";
  public static final String EVENT_SHOW_TOAST = "showToast";
  public static final String EVENT_UPDATE_TEXTAREA = "updateTextArea";
  private static final String TAG = "UIJsPlugin";
  private ToastView loadingView;
  private String mLastPage;
  private ToastView toastView;
  
  private void hideLoadingView()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("UIJsPlugin", "hideLoadingView LoadingView=" + this.loadingView);
    }
    if ((this.loadingView != null) && (this.loadingView.shown()))
    {
      this.loadingView.hide();
      this.loadingView = null;
    }
  }
  
  private void hideToastView()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("UIJsPlugin", "hideToastView toastView=" + this.toastView);
    }
    if ((this.toastView != null) && (this.toastView.shown()))
    {
      this.toastView.hide();
      this.toastView = null;
    }
  }
  
  private boolean isLastPageValid(String paramString)
  {
    if (this.mIsMiniGame) {}
    while (paramString != null) {
      return true;
    }
    return false;
  }
  
  @JsEvent({"insertTextArea", "updateTextArea", "removeTextArea", "getMenuButtonBoundingClientRect"})
  public String doInterceptJsEvent(RequestEvent paramRequestEvent)
  {
    if ((!this.mIsMiniGame) && ("getMenuButtonBoundingClientRect".equals(paramRequestEvent.event))) {
      return (String)this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 3));
    }
    return (String)this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(paramRequestEvent, 2));
  }
  
  @JsEvent({"hideHomeButton"})
  public void hideHomeButton(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.6(this, paramRequestEvent));
  }
  
  @JsEvent({"hideLoading"})
  public void hideLoading(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.3(this, paramRequestEvent));
  }
  
  @JsEvent({"hideToast"})
  public void hideToast(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.2(this, paramRequestEvent));
  }
  
  @JsEvent({"showLoading"})
  public void showLoading(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new UIJsPlugin.4(this, paramRequestEvent));
  }
  
  @JsEvent({"showModal"})
  public void showModal(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str1 = localJSONObject.optString("title", "");
      String str2 = localJSONObject.optString("content", "");
      boolean bool = localJSONObject.optBoolean("showCancel", true);
      String str3 = localJSONObject.optString("cancelText", "取消");
      String str4 = localJSONObject.optString("cancelColor", "#000000");
      AppBrandTask.runTaskOnUiThread(new UIJsPlugin.5(this, str1, str2, localJSONObject.optString("confirmText", "确定"), localJSONObject.optString("confirmColor", "#3CC51F"), paramRequestEvent, bool, str3, str4));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("UIJsPlugin", paramRequestEvent.event + " error.", localJSONException);
    }
  }
  
  @JsEvent({"showToast"})
  public void showToast(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      String str = localJSONObject.optString("title", "");
      int i = localJSONObject.optInt("duration", 1500);
      boolean bool = localJSONObject.optBoolean("mask", false);
      AppBrandTask.runTaskOnUiThread(new UIJsPlugin.1(this, localJSONObject.optString("icon", "success"), localJSONObject.optString("image", ""), str, i, bool, paramRequestEvent));
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("UIJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UIJsPlugin
 * JD-Core Version:    0.7.0.1
 */
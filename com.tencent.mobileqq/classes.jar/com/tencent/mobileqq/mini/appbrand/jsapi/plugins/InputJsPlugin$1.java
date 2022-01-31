package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.MiniAppTextArea;
import org.json.JSONException;
import org.json.JSONObject;

class InputJsPlugin$1
  implements Runnable
{
  InputJsPlugin$1(InputJsPlugin paramInputJsPlugin, JsRuntime paramJsRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject2 = ((AppBrandPageContainer)this.this$0.jsPluginEngine.appBrandRuntime.getContainer()).getPageByWebViewId(this.val$webview.getPageWebViewId());
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AbsAppBrandPage)localObject2).getCurrentWebviewContainer();
    }
    if (localObject1 != null)
    {
      localObject2 = ((WebviewContainer)localObject1).getTextArea(this.val$inputId);
      if (localObject2 != null)
      {
        this.this$0.jsPluginEngine.setCurInputId(this.val$inputId);
        ((MiniAppTextArea)localObject2).setFocusable(true);
        ((MiniAppTextArea)localObject2).setFocusableInTouchMode(true);
        ((MiniAppTextArea)localObject2).requestFocus();
        localObject1 = (InputMethodManager)((WebviewContainer)localObject1).getContext().getSystemService("input_method");
        if (localObject1 != null) {
          ((InputMethodManager)localObject1).showSoftInput((View)localObject2, 0);
        }
      }
    }
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("inputId", this.val$inputId);
      localObject1 = ApiUtil.wrapCallbackOk("showKeyboard", (JSONObject)localObject1);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, ((JSONObject)localObject1).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InputJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.widget.input;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class WebInputHandler$KeyboardHiddenObserver
  implements Observer
{
  public WebInputHandler$KeyboardHiddenObserver(WebInputHandler paramWebInputHandler) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if (!(paramObject instanceof String)) {
        break label208;
      }
      if ("hideKeyboard".equals((String)paramObject))
      {
        if (WebInputHandler.access$300(this.this$0) == null) {
          return;
        }
        if (WebInputHandler.access$300(this.this$0).getContext() == null) {
          return;
        }
        if (WebInputHandler.access$400(this.this$0) != 0) {
          EditAreaAnimatorUtil.editAreaAnimator(WebInputHandler.access$300(this.this$0), WebInputHandler.access$400(this.this$0), 0.0F, 1.0F, 1.0F);
        }
        paramObservable = (InputMethodManager)WebInputHandler.access$300(this.this$0).getContext().getSystemService("input_method");
        if (paramObservable == null) {
          return;
        }
        paramObservable.hideSoftInputFromWindow(WebInputHandler.access$300(this.this$0).getWindowToken(), 0);
        WebInputHandler.access$402(this.this$0, 0);
        WebInputHandler.access$502(this.this$0, 0);
        return;
      }
    }
    catch (Exception paramObservable)
    {
      paramObservable.printStackTrace();
      return;
    }
    if ("hideInput".equals((String)paramObject))
    {
      if (WebInputHandler.access$400(this.this$0) != 0) {
        EditAreaAnimatorUtil.editAreaAnimator(WebInputHandler.access$300(this.this$0), WebInputHandler.access$400(this.this$0), 0.0F, 1.0F, 1.0F);
      }
      this.this$0.hideCurrentInput(true);
      WebInputHandler.access$402(this.this$0, 0);
      WebInputHandler.access$502(this.this$0, 0);
      return;
      label208:
      if (((paramObject instanceof Integer)) && (WebInputHandler.access$300(this.this$0) != null) && (WebInputHandler.access$300(this.this$0).getCurrentPageWebview() != null) && (WebInputHandler.access$300(this.this$0).getCurrentWebviewContainer().appBrandRuntime != null) && (WebInputHandler.access$300(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity != null))
      {
        WebInputHandler.access$602(this.this$0, (int)(Integer.valueOf(String.valueOf(paramObject)).intValue() * DisplayUtil.getDensity(WebInputHandler.access$300(this.this$0).getContext())));
        if ((DisplayUtil.hasNavBar(WebInputHandler.access$300(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity)) && (DisplayUtil.isNavigationBarExist(WebInputHandler.access$300(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity))) {
          WebInputHandler.access$602(this.this$0, WebInputHandler.access$600(this.this$0) + DisplayUtil.getNavigationBarHeight(WebInputHandler.access$300(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity));
        }
        WebInputHandler.access$200(this.this$0);
        paramObservable = new JSONObject();
        paramObservable.put("inputId", WebInputHandler.access$000(this.this$0));
        paramObservable.put("height", paramObject);
        WebInputHandler.access$300(this.this$0).getCurrentPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), WebInputHandler.access$300(this.this$0).getCurrentPageWebview().pageWebviewId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */
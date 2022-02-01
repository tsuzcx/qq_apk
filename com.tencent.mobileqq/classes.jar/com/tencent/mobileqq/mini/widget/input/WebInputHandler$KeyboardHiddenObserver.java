package com.tencent.mobileqq.mini.widget.input;

import android.content.Context;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.EditAreaAnimatorUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class WebInputHandler$KeyboardHiddenObserver
  implements Observer
{
  public WebInputHandler$KeyboardHiddenObserver(WebInputHandler paramWebInputHandler) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    boolean bool2 = true;
    try
    {
      if (!(paramObject instanceof String)) {
        break label229;
      }
      if ("hideKeyboard".equals((String)paramObject))
      {
        if (WebInputHandler.access$000(this.this$0) == null) {
          return;
        }
        if (WebInputHandler.access$000(this.this$0).getContext() == null) {
          return;
        }
        if (WebInputHandler.access$500(this.this$0) != 0) {
          EditAreaAnimatorUtil.editAreaAnimator(WebInputHandler.access$000(this.this$0), WebInputHandler.access$500(this.this$0), 0.0F, 1.0F, 1.0F);
        }
        paramObservable = (InputMethodManager)WebInputHandler.access$000(this.this$0).getContext().getSystemService("input_method");
        if (paramObservable == null) {
          return;
        }
        paramObservable.hideSoftInputFromWindow(WebInputHandler.access$000(this.this$0).getWindowToken(), 0);
        WebInputHandler.access$502(this.this$0, 0);
        WebInputHandler.access$602(this.this$0, 0);
        WebInputHandler.access$302(this.this$0, false);
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
      if (WebInputHandler.access$500(this.this$0) != 0) {
        EditAreaAnimatorUtil.editAreaAnimator(WebInputHandler.access$000(this.this$0), WebInputHandler.access$500(this.this$0), 0.0F, 1.0F, 1.0F);
      }
      this.this$0.hideCurrentInput(true);
      WebInputHandler.access$502(this.this$0, 0);
      WebInputHandler.access$602(this.this$0, 0);
      WebInputHandler.access$302(this.this$0, false);
      return;
      label229:
      if (((paramObject instanceof Integer)) && (WebInputHandler.access$000(this.this$0) != null) && (WebInputHandler.access$000(this.this$0).getCurrentPageWebview() != null) && (WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime != null) && (WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity != null))
      {
        WebInputHandler.access$302(this.this$0, true);
        WebInputHandler.access$402(this.this$0, (int)(Integer.valueOf(String.valueOf(paramObject)).intValue() * DisplayUtil.getDensity(WebInputHandler.access$000(this.this$0).getContext())));
        boolean bool1;
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
          bool1 = DisplayUtil.checkNavigationBarShow(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity);
        }
        for (;;)
        {
          QLog.d("WebInputHandler", 1, " hasNavBar : " + bool1);
          if (bool1) {
            WebInputHandler.access$402(this.this$0, WebInputHandler.access$400(this.this$0) + DisplayUtil.getNavigationBarHeight(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity));
          }
          paramObservable = new JSONObject();
          paramObservable.put("inputId", WebInputHandler.access$100(this.this$0));
          paramObservable.put("height", paramObject);
          QLog.d("WebInputHandler", 1, "onKeyboardShow : " + paramObservable.toString());
          WebInputHandler.access$000(this.this$0).getCurrentPageWebview().evaluateSubcribeJS("onKeyboardShow", paramObservable.toString(), WebInputHandler.access$000(this.this$0).getCurrentPageWebview().pageWebviewId);
          return;
          if (DisplayUtil.hasNavBar(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity))
          {
            bool1 = bool2;
            if (DisplayUtil.isNavigationBarExist(WebInputHandler.access$000(this.this$0).getCurrentWebviewContainer().appBrandRuntime.activity)) {}
          }
          else
          {
            boolean bool3 = DisplayUtil.isFlymeOS7NavBarShow();
            bool1 = bool2;
            if (!bool3) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.input.WebInputHandler.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.miniapp.core.page.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WebInputHandler$KeyboardHiddenObserver
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public WebInputHandler$KeyboardHiddenObserver(WebInputHandler paramWebInputHandler) {}
  
  public void onSoftKeyboardClosed()
  {
    WebInputHandler.access$102(this.this$0, false);
    QMLog.i("WebInputHandler", "onSoftKeyboardClosed");
    InputMethodManager localInputMethodManager = (InputMethodManager)WebInputHandler.access$200(this.this$0).getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(WebInputHandler.access$200(this.this$0).getWindowToken(), 0);
    if ((WebInputHandler.access$200(this.this$0) != null) && (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null)) {
      WebInputHandler.access$400(this.this$0, new float[] { WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getTranslationY(), 0.0F });
    }
    this.this$0.hideCurrentInput();
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        WebInputHandler.access$002(this.this$0, paramInt);
        WebInputHandler.access$102(this.this$0, true);
        if ((WebInputHandler.access$200(this.this$0) != null) && (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null))
        {
          Object localObject1 = WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getAttachActivity();
          boolean bool1;
          if (localObject1 != null)
          {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
              continue;
            }
            bool1 = DisplayUtil.checkNavigationBarShow((Context)localObject1);
            QMLog.d("WebInputHandler", " hasNavBar : " + bool1 + "; " + Build.BRAND);
            if (bool1) {
              WebInputHandler.access$002(this.this$0, WebInputHandler.access$000(this.this$0) + DisplayUtil.getNavigationBarHeight(WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getAttachActivity()));
            }
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("inputId", WebInputHandler.access$300(this.this$0));
          ((JSONObject)localObject1).put("height", (int)(paramInt / DisplayUtil.getDensity(WebInputHandler.access$200(this.this$0).getContext())));
          if ((WebInputHandler.access$200(this.this$0) != null) && (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null))
          {
            WebInputHandler.access$200(this.this$0).getPageWebviewContainer().evaluateSubscribeJS("onKeyboardShow", ((JSONObject)localObject1).toString());
            return;
            if (DisplayUtil.hasNavBar((Context)localObject1))
            {
              bool1 = bool2;
              if (DisplayUtil.isNavigationBarExist((Activity)localObject1)) {
                continue;
              }
            }
            boolean bool3 = DisplayUtil.isFlymeOS7NavBarShow();
            bool1 = bool2;
            if (bool3) {
              continue;
            }
            bool1 = false;
            continue;
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */
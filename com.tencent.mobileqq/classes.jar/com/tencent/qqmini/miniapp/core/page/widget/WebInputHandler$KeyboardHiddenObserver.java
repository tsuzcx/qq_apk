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
    Object localObject = (InputMethodManager)WebInputHandler.access$200(this.this$0).getContext().getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(WebInputHandler.access$200(this.this$0).getWindowToken(), 0);
    if ((WebInputHandler.access$200(this.this$0) != null) && (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() != null))
    {
      localObject = this.this$0;
      WebInputHandler.access$400((WebInputHandler)localObject, new float[] { WebInputHandler.access$200((WebInputHandler)localObject).getPageWebviewContainer().getTranslationY(), 0.0F });
    }
    this.this$0.hideCurrentInput();
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    for (;;)
    {
      try
      {
        WebInputHandler.access$002(this.this$0, paramInt);
        WebInputHandler.access$102(this.this$0, true);
        if ((WebInputHandler.access$200(this.this$0) == null) || (WebInputHandler.access$200(this.this$0).getPageWebviewContainer() == null)) {
          break label280;
        }
        Object localObject1 = WebInputHandler.access$200(this.this$0).getPageWebviewContainer().getAttachActivity();
        if (localObject1 != null)
        {
          if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))
          {
            bool = DisplayUtil.checkNavigationBarShow((Context)localObject1);
          }
          else
          {
            if ((DisplayUtil.hasNavBar((Context)localObject1)) && (DisplayUtil.isNavigationBarExist((Activity)localObject1))) {
              break label285;
            }
            if (!DisplayUtil.isFlymeOS7NavBarShow()) {
              break label290;
            }
            break label285;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" hasNavBar : ");
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append("; ");
          ((StringBuilder)localObject1).append(Build.BRAND);
          QMLog.d("WebInputHandler", ((StringBuilder)localObject1).toString());
          if (bool) {
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
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label280:
      Object localObject2 = null;
      continue;
      label285:
      boolean bool = true;
      continue;
      label290:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler.KeyboardHiddenObserver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppBrandPageContainer$2
  implements Runnable
{
  AppBrandPageContainer$2(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", 0);
      localJSONObject.put("inputId", this.this$0.getCurShowingInputId());
      if (this.this$0.mEventListener != null) {
        this.this$0.mEventListener.onWebViewEvent("onKeyboardHeightChange", localJSONObject.toString(), this.this$0.getShowingPageWebViewId());
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
    this.this$0.resetCurShowingInputId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.2
 * JD-Core Version:    0.7.0.1
 */
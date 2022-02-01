package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONObject;

class AppBrandPageContainer$3
  implements Runnable
{
  AppBrandPageContainer$3(AppBrandPageContainer paramAppBrandPageContainer, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("height", (int)(this.val$realKeyboardHeight / DisplayUtil.getDensity(AppBrandPageContainer.access$200(this.this$0).getContext())));
      localJSONObject.put("inputId", this.this$0.getCurShowingInputId());
      if (this.this$0.mEventListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onKeyboardHeightChange : ");
        localStringBuilder.append(localJSONObject.toString());
        QMLog.d("minisdk-start-AppBrandPageContainer", localStringBuilder.toString());
        this.this$0.mEventListener.onWebViewEvent("onKeyboardHeightChange", localJSONObject.toString(), this.this$0.getShowingPageWebViewId());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start-AppBrandPageContainer", "KeyboardObserver error, ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.3
 * JD-Core Version:    0.7.0.1
 */
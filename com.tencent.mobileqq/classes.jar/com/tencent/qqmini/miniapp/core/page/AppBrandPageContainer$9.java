package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

class AppBrandPageContainer$9
  implements Runnable
{
  AppBrandPageContainer$9(AppBrandPageContainer paramAppBrandPageContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    int i = -1;
    try
    {
      boolean bool = "light".equals(new JSONObject(this.val$req.jsonParams).optString("textStyle", "light"));
      if (!bool) {
        i = -16777216;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$req.event);
      localStringBuilder.append(" error.");
      QMLog.e("minisdk-start-AppBrandPageContainer", localStringBuilder.toString(), localException);
    }
    Iterator localIterator = AppBrandPageContainer.access$400(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((AppBrandPage)localIterator.next()).notifyChangePullDownRefreshStyle(i);
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.9
 * JD-Core Version:    0.7.0.1
 */
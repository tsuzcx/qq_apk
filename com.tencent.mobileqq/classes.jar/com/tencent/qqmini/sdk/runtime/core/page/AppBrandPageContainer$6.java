package com.tencent.qqmini.sdk.runtime.core.page;

import bgid;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.ColorUtils;
import org.json.JSONObject;

class AppBrandPageContainer$6
  implements Runnable
{
  AppBrandPageContainer$6(AppBrandPageContainer paramAppBrandPageContainer, bgid parambgid) {}
  
  public void run()
  {
    try
    {
      String str = new JSONObject(this.a.b).optString("backgroundColor", "#FFFFFF");
      this.this$0.setBackgroundColor(ColorUtils.parseColor(str));
      this.a.a();
      return;
    }
    catch (Exception localException)
    {
      this.a.b();
      QMLog.e("minisdk-start-AppBrandPageContainer", this.a.a + " error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.6
 * JD-Core Version:    0.7.0.1
 */
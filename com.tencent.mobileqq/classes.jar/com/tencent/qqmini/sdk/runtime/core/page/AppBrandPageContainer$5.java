package com.tencent.qqmini.sdk.runtime.core.page;

import bgid;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

class AppBrandPageContainer$5
  implements Runnable
{
  AppBrandPageContainer$5(AppBrandPageContainer paramAppBrandPageContainer, bgid parambgid) {}
  
  public void run()
  {
    for (int i = -1;; i = -16777216)
    {
      try
      {
        boolean bool = "light".equals(new JSONObject(this.a.b).optString("textStyle", "light"));
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Iterator localIterator;
          QMLog.e("minisdk-start-AppBrandPageContainer", this.a.a + " error.", localException);
          i = -1;
        }
        this.a.a();
      }
      localIterator = AppBrandPageContainer.a(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((AppBrandPage)localIterator.next()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer.5
 * JD-Core Version:    0.7.0.1
 */
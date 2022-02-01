package com.tencent.mobileqq.webprocess;

import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

class WebAccelerateHelper$1
  implements Runnable
{
  WebAccelerateHelper$1(WebAccelerateHelper paramWebAccelerateHelper, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.val$fisX5PreFetch)
    {
      localHashMap = new HashMap();
      localHashMap.put("User-Agent", ((IWebviewApi)QRoute.api(IWebviewApi.class)).getQUA("", "", false));
      WebAccelerator.prefetchResource(MobileQQ.getContext(), this.val$fUrl, localHashMap, true);
      QLog.i("WebAccelerateHelper", 1, "now prefetchResource " + Util.c(this.val$fUrl, new String[0]));
    }
    while (!this.val$fisX5PreConnect)
    {
      HashMap localHashMap;
      return;
    }
    WebAccelerator.preConnect(MobileQQ.getContext(), this.val$fUrl, 1, true);
    QLog.i("WebAccelerateHelper", 1, "now preconnect " + Util.c(this.val$fUrl, new String[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
 * JD-Core Version:    0.7.0.1
 */
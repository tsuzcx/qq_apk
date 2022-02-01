package com.tencent.mobileqq.webprocess;

import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
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
    Object localObject;
    if (this.val$fisX5PreFetch)
    {
      localObject = new HashMap();
      ((Map)localObject).put("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.c("x5prefetch_1.0"), "", false));
      WebAccelerator.prefetchResource(MobileQQ.getContext(), this.val$fUrl, (Map)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("now prefetchResource ");
      ((StringBuilder)localObject).append(Util.c(this.val$fUrl, new String[0]));
      QLog.i("WebAccelerateHelper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.val$fisX5PreConnect)
    {
      WebAccelerator.preConnect(MobileQQ.getContext(), this.val$fUrl, 1, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("now preconnect ");
      ((StringBuilder)localObject).append(Util.c(this.val$fUrl, new String[0]));
      QLog.i("WebAccelerateHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.swift.component;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IScreenShotImageUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserScreenShotHandler$3
  implements Runnable
{
  SwiftBrowserScreenShotHandler$3(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler, int paramInt) {}
  
  public void run()
  {
    this.this$0.i = ((IScreenShotImageUtil)QRoute.api(IScreenShotImageUtil.class)).saveBitmapToPublicAccountFileFolder(this.this$0.h, "ShotCache_");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDetectScreenshot->save file time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((SwiftBrowserScreenShotHandler)localObject).m = false;
    if (((SwiftBrowserScreenShotHandler)localObject).n)
    {
      localObject = this.this$0;
      ((SwiftBrowserScreenShotHandler)localObject).n = false;
      ((SwiftBrowserScreenShotHandler)localObject).q.sendEmptyMessage(3);
      return;
    }
    if (this.a == 2) {
      this.this$0.q.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3
 * JD-Core Version:    0.7.0.1
 */
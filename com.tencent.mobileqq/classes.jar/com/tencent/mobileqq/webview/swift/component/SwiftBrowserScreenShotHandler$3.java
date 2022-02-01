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
    this.this$0.jdField_a_of_type_JavaLangString = ((IScreenShotImageUtil)QRoute.api(IScreenShotImageUtil.class)).saveBitmapToPublicAccountFileFolder(this.this$0.jdField_a_of_type_AndroidGraphicsBitmap, "ShotCache_");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDetectScreenshot->save file time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    ((SwiftBrowserScreenShotHandler)localObject).jdField_a_of_type_Boolean = false;
    if (((SwiftBrowserScreenShotHandler)localObject).b)
    {
      localObject = this.this$0;
      ((SwiftBrowserScreenShotHandler)localObject).b = false;
      ((SwiftBrowserScreenShotHandler)localObject).jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    if (this.a == 2) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.swift.component;

import android.os.Handler;
import bgwr;
import com.tencent.qphone.base.util.QLog;
import sxa;

public class SwiftBrowserScreenShotHandler$3
  implements Runnable
{
  public SwiftBrowserScreenShotHandler$3(bgwr parambgwr, int paramInt) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaLangString = sxa.a(this.this$0.jdField_a_of_type_AndroidGraphicsBitmap, "ShotCache_");
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->save file time:" + System.currentTimeMillis());
    }
    this.this$0.jdField_a_of_type_Boolean = false;
    if (this.this$0.b)
    {
      this.this$0.b = false;
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    while (this.a != 2) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3
 * JD-Core Version:    0.7.0.1
 */
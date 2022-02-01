package com.tencent.mobileqq.flutter.container;

import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

class QFlutterContainerDelegate$1
  implements FlutterUiDisplayListener
{
  QFlutterContainerDelegate$1(QFlutterContainerDelegate paramQFlutterContainerDelegate) {}
  
  public void onFlutterUiDisplayed()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onFlutterUiDisplayed");
    QFlutterContainerDelegate.a(this.a);
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    QLog.d("QFlutterContainerDelegate", 1, "onFlutterUiNoLongerDisplayed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate.1
 * JD-Core Version:    0.7.0.1
 */
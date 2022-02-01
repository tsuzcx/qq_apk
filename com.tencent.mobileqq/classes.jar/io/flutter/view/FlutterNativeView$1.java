package io.flutter.view;

import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

class FlutterNativeView$1
  implements FlutterUiDisplayListener
{
  FlutterNativeView$1(FlutterNativeView paramFlutterNativeView) {}
  
  public void onFlutterUiDisplayed()
  {
    if (FlutterNativeView.access$000(this.this$0) == null) {
      return;
    }
    FlutterNativeView.access$000(this.this$0).onFirstFrame();
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView.1
 * JD-Core Version:    0.7.0.1
 */
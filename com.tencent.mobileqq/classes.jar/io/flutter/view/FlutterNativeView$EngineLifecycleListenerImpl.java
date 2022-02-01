package io.flutter.view;

import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener;

final class FlutterNativeView$EngineLifecycleListenerImpl
  implements FlutterEngine.EngineLifecycleListener
{
  private FlutterNativeView$EngineLifecycleListenerImpl(FlutterNativeView paramFlutterNativeView) {}
  
  public void onPreEngineRestart()
  {
    if (FlutterNativeView.access$000(this.this$0) != null) {
      FlutterNativeView.access$000(this.this$0).resetAccessibilityTree();
    }
    if (FlutterNativeView.access$200(this.this$0) == null) {
      return;
    }
    FlutterNativeView.access$200(this.this$0).onPreEngineRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView.EngineLifecycleListenerImpl
 * JD-Core Version:    0.7.0.1
 */
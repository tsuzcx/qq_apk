package io.flutter.embedding.android;

import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

class FlutterView$4
  implements FlutterUiDisplayListener
{
  FlutterView$4(FlutterView paramFlutterView, FlutterRenderer paramFlutterRenderer, Runnable paramRunnable) {}
  
  public void onFlutterUiDisplayed()
  {
    this.val$renderer.removeIsDisplayingFlutterUiListener(this);
    this.val$onDone.run();
    FlutterView.access$300(this.this$0).detachFromRenderer();
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.4
 * JD-Core Version:    0.7.0.1
 */
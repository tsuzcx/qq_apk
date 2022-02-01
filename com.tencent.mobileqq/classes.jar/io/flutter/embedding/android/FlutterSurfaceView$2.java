package io.flutter.embedding.android;

import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

class FlutterSurfaceView$2
  implements FlutterUiDisplayListener
{
  FlutterSurfaceView$2(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterUiDisplayed()
  {
    Log.v("FlutterSurfaceView", "onFlutterUiDisplayed()");
    this.this$0.setAlpha(1.0F);
    if (FlutterSurfaceView.access$500(this.this$0) != null) {
      FlutterSurfaceView.access$500(this.this$0).removeIsDisplayingFlutterUiListener(this);
    }
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */
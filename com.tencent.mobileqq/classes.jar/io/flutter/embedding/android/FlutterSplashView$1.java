package io.flutter.embedding.android;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;

class FlutterSplashView$1
  implements FlutterView.FlutterEngineAttachmentListener
{
  FlutterSplashView$1(FlutterSplashView paramFlutterSplashView) {}
  
  public void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine paramFlutterEngine)
  {
    FlutterSplashView.access$000(this.this$0).removeFlutterEngineAttachmentListener(this);
    this.this$0.displayFlutterViewWithSplash(FlutterSplashView.access$000(this.this$0), FlutterSplashView.access$100(this.this$0));
  }
  
  public void onFlutterEngineDetachedFromFlutterView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSplashView.1
 * JD-Core Version:    0.7.0.1
 */
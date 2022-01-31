package io.flutter.embedding.android;

import io.flutter.Log;

class FlutterActivityAndFragmentDelegate$2
  implements Runnable
{
  FlutterActivityAndFragmentDelegate$2(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate) {}
  
  public void run()
  {
    Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
    FlutterActivityAndFragmentDelegate.access$200(this.this$0).attachToFlutterEngine(FlutterActivityAndFragmentDelegate.access$100(this.this$0));
    FlutterActivityAndFragmentDelegate.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.2
 * JD-Core Version:    0.7.0.1
 */
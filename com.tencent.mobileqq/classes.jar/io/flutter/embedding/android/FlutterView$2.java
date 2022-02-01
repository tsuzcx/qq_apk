package io.flutter.embedding.android;

import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import java.util.Iterator;
import java.util.Set;

class FlutterView$2
  implements FlutterUiDisplayListener
{
  FlutterView$2(FlutterView paramFlutterView) {}
  
  public void onFlutterUiDisplayed()
  {
    FlutterView.access$102(this.this$0, true);
    Iterator localIterator = FlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
    }
  }
  
  public void onFlutterUiNoLongerDisplayed()
  {
    FlutterView.access$102(this.this$0, false);
    Iterator localIterator = FlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.2
 * JD-Core Version:    0.7.0.1
 */
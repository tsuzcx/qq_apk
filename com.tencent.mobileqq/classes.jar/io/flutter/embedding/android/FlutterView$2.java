package io.flutter.embedding.android;

import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.Iterator;
import java.util.Set;

class FlutterView$2
  implements OnFirstFrameRenderedListener
{
  FlutterView$2(FlutterView paramFlutterView) {}
  
  public void onFirstFrameRendered()
  {
    FlutterView.access$102(this.this$0, true);
    Iterator localIterator = FlutterView.access$200(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((OnFirstFrameRenderedListener)localIterator.next()).onFirstFrameRendered();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.2
 * JD-Core Version:    0.7.0.1
 */
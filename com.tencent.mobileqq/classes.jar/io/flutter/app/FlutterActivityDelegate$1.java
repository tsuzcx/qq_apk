package io.flutter.app;

import android.view.View;
import android.view.ViewPropertyAnimator;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.FirstFrameListener;

class FlutterActivityDelegate$1
  implements FlutterView.FirstFrameListener
{
  FlutterActivityDelegate$1(FlutterActivityDelegate paramFlutterActivityDelegate) {}
  
  public void onFirstFrame()
  {
    FlutterActivityDelegate.access$000(this.this$0).animate().alpha(0.0F).setListener(new FlutterActivityDelegate.1.1(this));
    FlutterActivityDelegate.access$100(this.this$0).removeFirstFrameListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.app.FlutterActivityDelegate.1
 * JD-Core Version:    0.7.0.1
 */
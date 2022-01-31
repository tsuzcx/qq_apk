package io.flutter.view;

import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;

class VsyncWaiter$1$1
  implements Choreographer.FrameCallback
{
  VsyncWaiter$1$1(VsyncWaiter.1 param1, long paramLong) {}
  
  public void doFrame(long paramLong)
  {
    double d = VsyncWaiter.access$000(this.this$1.this$0).getDefaultDisplay().getRefreshRate();
    Double.isNaN(d);
    FlutterJNI.nativeOnVsync(paramLong, paramLong + (1000000000.0D / d), this.val$cookie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.view.VsyncWaiter.1.1
 * JD-Core Version:    0.7.0.1
 */
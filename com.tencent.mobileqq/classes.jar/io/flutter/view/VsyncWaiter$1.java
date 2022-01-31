package io.flutter.view;

import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate;

class VsyncWaiter$1
  implements FlutterJNI.AsyncWaitForVsyncDelegate
{
  VsyncWaiter$1(VsyncWaiter paramVsyncWaiter) {}
  
  public void asyncWaitForVsync(long paramLong)
  {
    Choreographer.getInstance().postFrameCallback(new VsyncWaiter.1.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.view.VsyncWaiter.1
 * JD-Core Version:    0.7.0.1
 */
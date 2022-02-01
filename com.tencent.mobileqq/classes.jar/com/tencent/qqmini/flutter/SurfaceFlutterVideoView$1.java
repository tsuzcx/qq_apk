package com.tencent.qqmini.flutter;

import com.qflutter.video.IQflutterVideoView.StatusCallBack;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnCompletionListener;

class SurfaceFlutterVideoView$1
  implements ReliableVideoPlayer.OnCompletionListener
{
  SurfaceFlutterVideoView$1(SurfaceFlutterVideoView paramSurfaceFlutterVideoView) {}
  
  public void onCompletion(ReliableVideoPlayer paramReliableVideoPlayer)
  {
    if (SurfaceFlutterVideoView.access$000(this.this$0) != null) {
      SurfaceFlutterVideoView.access$000(this.this$0).on(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.SurfaceFlutterVideoView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.flutter;

import com.qflutter.video.IQflutterVideoView.StatusCallBack;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnPreparedListener;

class SurfaceFlutterVideoView$4
  implements ReliableVideoPlayer.OnPreparedListener
{
  SurfaceFlutterVideoView$4(SurfaceFlutterVideoView paramSurfaceFlutterVideoView) {}
  
  public void onPrepared(ReliableVideoPlayer paramReliableVideoPlayer)
  {
    if (SurfaceFlutterVideoView.access$000(this.this$0) != null) {
      SurfaceFlutterVideoView.access$000(this.this$0).on(12, null);
    }
    SurfaceFlutterVideoView.access$100(this.this$0).setLooping(true);
    if (SurfaceFlutterVideoView.access$200(this.this$0)) {}
    try
    {
      SurfaceFlutterVideoView.access$100(this.this$0).start();
      return;
    }
    catch (Throwable paramReliableVideoPlayer) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.SurfaceFlutterVideoView.4
 * JD-Core Version:    0.7.0.1
 */
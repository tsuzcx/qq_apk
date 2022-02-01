package com.tencent.qqmini.sdk.widget.media;

import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;

class MiniAppVideoPlayer$3
  implements VideoGestureRelativeLayout.VideoGestureListener
{
  MiniAppVideoPlayer$3(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoPlayer.access$1000(this.this$0, paramMotionEvent1, paramMotionEvent2);
  }
  
  public void onDoubleTapGesture(MotionEvent paramMotionEvent)
  {
    if (this.this$0.enablePlayGesture)
    {
      this.this$0.operate();
      MiniAppVideoPlayer.access$1500(this.this$0, MiniAppVideoPlayer.access$000(this.this$0).isPlaying());
      MiniAppVideoPlayer.access$1600(this.this$0);
    }
  }
  
  public void onDown(MotionEvent paramMotionEvent)
  {
    MiniAppVideoPlayer.access$1702(this.this$0, MiniAppVideoPlayer.access$1800(this.this$0));
    if (MiniAppVideoPlayer.access$1900(this.this$0) != null) {
      MiniAppVideoPlayer.access$2002(this.this$0, MiniAppVideoPlayer.access$1900(this.this$0).getStreamVolume(3));
    }
    if (MiniAppVideoPlayer.access$2100(this.this$0) != null) {
      MiniAppVideoPlayer.access$2202(this.this$0, MiniAppVideoPlayer.access$2100(this.this$0).screenBrightness);
    }
    if (MiniAppVideoPlayer.access$2200(this.this$0) == -1.0F) {
      MiniAppVideoPlayer.access$2202(this.this$0, MiniAppVideoPlayer.access$2300(this.this$0) / 255.0F);
    }
  }
  
  public void onEndFF_REW(MotionEvent paramMotionEvent) {}
  
  public void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoPlayer.access$1200(this.this$0, paramMotionEvent1, paramMotionEvent2);
  }
  
  public void onSingleTapGesture(MotionEvent paramMotionEvent)
  {
    if (MiniAppVideoPlayer.access$1300(this.this$0).getVisibility() == 4) {
      MiniAppVideoPlayer.access$900(this.this$0);
    }
    while (MiniAppVideoPlayer.access$1300(this.this$0).getVisibility() != 0) {
      return;
    }
    MiniAppVideoPlayer.access$1400(this.this$0);
  }
  
  public void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoPlayer.access$1100(this.this$0, paramMotionEvent1, paramMotionEvent2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */
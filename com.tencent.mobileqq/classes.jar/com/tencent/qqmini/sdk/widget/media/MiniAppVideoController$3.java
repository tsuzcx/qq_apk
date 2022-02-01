package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.media.AudioManager;
import android.provider.Settings.System;
import android.view.MotionEvent;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;

class MiniAppVideoController$3
  implements VideoGestureRelativeLayout.VideoGestureListener
{
  MiniAppVideoController$3(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoController.access$300(this.this$0).onBrightnessGesture(MiniAppVideoController.access$000(this.this$0), paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onDoubleTapGesture(MotionEvent paramMotionEvent)
  {
    if (MiniAppVideoController.access$000(this.this$0).enablePlayGesture)
    {
      this.this$0.operate();
      MiniAppVideoController.access$300(this.this$0).onDoubleTapGesture(MiniAppVideoController.access$000(this.this$0), MiniAppVideoController.access$200(this.this$0).isPlaying());
    }
  }
  
  public void onDown(MotionEvent paramMotionEvent)
  {
    int i = MiniAppVideoController.access$1100(this.this$0).getStreamVolume(3);
    int j = Settings.System.getInt(MiniAppVideoController.access$1200(this.this$0).getContentResolver(), "screen_brightness", 255);
    MiniAppVideoController.access$300(this.this$0).onDown(i, j);
  }
  
  public void onEndFF_REW(MotionEvent paramMotionEvent)
  {
    MiniAppVideoController.access$300(this.this$0).onEndFF_REW(paramMotionEvent);
  }
  
  public void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoController.access$300(this.this$0).onProgressGesture(MiniAppVideoController.access$000(this.this$0), paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (MiniAppVideoController.access$200(this.this$0) != null)
    {
      int i = (int)MiniAppVideoController.access$200(this.this$0).getDuration() * MiniAppVideoController.access$300(this.this$0).getGestureProgress() / 100;
      this.this$0.seekTo(i);
    }
  }
  
  public void onSingleTapGesture(MotionEvent paramMotionEvent)
  {
    MiniAppVideoController.access$300(this.this$0).onSingleTapGesture(MiniAppVideoController.access$000(this.this$0), paramMotionEvent);
  }
  
  public void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    MiniAppVideoController.access$300(this.this$0).onVolumeGesture(MiniAppVideoController.access$000(this.this$0), paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, MiniAppVideoController.access$1000(this.this$0), MiniAppVideoController.access$1100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.3
 * JD-Core Version:    0.7.0.1
 */
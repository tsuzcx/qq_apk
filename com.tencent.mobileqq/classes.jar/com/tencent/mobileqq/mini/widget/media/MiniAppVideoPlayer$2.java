package com.tencent.mobileqq.mini.widget.media;

import android.media.AudioManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class MiniAppVideoPlayer$2
  implements VideoGestureRelativeLayout.VideoGestureListener
{
  MiniAppVideoPlayer$2(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 0.0F;
    if (!this.this$0.pageGesture) {}
    while (this.this$0.isFullScreen) {
      return;
    }
    paramFloat2 = (paramMotionEvent1.getY() - paramMotionEvent2.getY()) / MiniAppVideoPlayer.access$000(this.this$0).getHeight() + MiniAppVideoPlayer.access$100(this.this$0);
    if (paramFloat2 < 0.0F) {}
    for (;;)
    {
      if ((MiniAppVideoPlayer.access$200(this.this$0) != null) && (MiniAppVideoPlayer.access$300(this.this$0) != null))
      {
        MiniAppVideoPlayer.access$300(this.this$0).screenBrightness = paramFloat1;
        MiniAppVideoPlayer.access$200(this.this$0).setAttributes(MiniAppVideoPlayer.access$300(this.this$0));
      }
      MiniAppVideoPlayer.access$400(this.this$0).setProgress((int)(paramFloat1 * 100.0F));
      MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840663);
      MiniAppVideoPlayer.access$400(this.this$0).show();
      return;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      } else {
        paramFloat1 = paramFloat2;
      }
    }
  }
  
  public void onDoubleTapGesture(MotionEvent paramMotionEvent)
  {
    if (this.this$0.enablePlayGesture)
    {
      this.this$0.operate();
      MiniAppVideoPlayer.access$1400(this.this$0, MiniAppVideoPlayer.access$800(this.this$0).isPlaying());
      if (MiniAppVideoPlayer.access$800(this.this$0).isPlaying()) {
        MiniAppVideoPlayer.access$1200(this.this$0);
      }
    }
    else
    {
      return;
    }
    MiniAppVideoPlayer.access$1500(this.this$0);
  }
  
  public void onDown(MotionEvent paramMotionEvent)
  {
    MiniAppVideoPlayer.access$1002(this.this$0, MiniAppVideoPlayer.access$900(this.this$0));
    if (MiniAppVideoPlayer.access$700(this.this$0) != null) {
      MiniAppVideoPlayer.access$602(this.this$0, MiniAppVideoPlayer.access$700(this.this$0).getStreamVolume(3));
    }
    if (MiniAppVideoPlayer.access$300(this.this$0) != null) {
      MiniAppVideoPlayer.access$102(this.this$0, MiniAppVideoPlayer.access$300(this.this$0).screenBrightness);
    }
    if (MiniAppVideoPlayer.access$100(this.this$0) == -1.0F) {
      MiniAppVideoPlayer.access$102(this.this$0, MiniAppVideoPlayer.access$1600(this.this$0) / 255.0F);
    }
  }
  
  public void onEndFF_REW(MotionEvent paramMotionEvent) {}
  
  public void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.this$0.enableProgressGesture) {}
    while (MiniAppVideoPlayer.access$800(this.this$0) == null) {
      return;
    }
    paramFloat1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    if (paramFloat1 > 0.0F)
    {
      MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840664);
      paramMotionEvent1 = this.this$0;
      paramFloat2 = MiniAppVideoPlayer.access$1000(this.this$0);
      MiniAppVideoPlayer.access$902(paramMotionEvent1, (int)(paramFloat1 / MiniAppVideoPlayer.access$000(this.this$0).getWidth() * 100.0F + paramFloat2));
      if (MiniAppVideoPlayer.access$900(this.this$0) > 100) {
        MiniAppVideoPlayer.access$902(this.this$0, 100);
      }
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$400(this.this$0).setProgress(MiniAppVideoPlayer.access$900(this.this$0));
      MiniAppVideoPlayer.access$400(this.this$0).show();
      int i = (int)MiniAppVideoPlayer.access$800(this.this$0).getDuration() * MiniAppVideoPlayer.access$900(this.this$0) / 100;
      MiniAppVideoPlayer.access$800(this.this$0).seekTo(i);
      return;
      MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840665);
      paramMotionEvent1 = this.this$0;
      paramFloat2 = MiniAppVideoPlayer.access$1000(this.this$0);
      MiniAppVideoPlayer.access$902(paramMotionEvent1, (int)(paramFloat1 / MiniAppVideoPlayer.access$000(this.this$0).getWidth() * 100.0F + paramFloat2));
      if (MiniAppVideoPlayer.access$900(this.this$0) < 0) {
        MiniAppVideoPlayer.access$902(this.this$0, 0);
      }
    }
  }
  
  public void onSingleTapGesture(MotionEvent paramMotionEvent)
  {
    if (MiniAppVideoPlayer.access$1100(this.this$0).getVisibility() != 8)
    {
      if (MiniAppVideoPlayer.access$1100(this.this$0).getVisibility() == 4) {
        MiniAppVideoPlayer.access$1200(this.this$0);
      }
    }
    else {
      return;
    }
    MiniAppVideoPlayer.access$1300(this.this$0);
  }
  
  public void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.this$0.pageGesture) {}
    while ((this.this$0.isFullScreen) || (MiniAppVideoPlayer.access$500(this.this$0) == 0)) {
      return;
    }
    int i = MiniAppVideoPlayer.access$000(this.this$0).getHeight() / MiniAppVideoPlayer.access$500(this.this$0);
    i = (int)((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / i + MiniAppVideoPlayer.access$600(this.this$0));
    if (MiniAppVideoPlayer.access$700(this.this$0) != null) {
      MiniAppVideoPlayer.access$700(this.this$0).setStreamVolume(3, i, 4);
    }
    i = (int)(i / Float.valueOf(MiniAppVideoPlayer.access$500(this.this$0)).floatValue() * 100.0F);
    if (i >= 50) {
      MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840667);
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$400(this.this$0).setProgress(i);
      MiniAppVideoPlayer.access$400(this.this$0).show();
      return;
      if (i > 0) {
        MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840668);
      } else {
        MiniAppVideoPlayer.access$400(this.this$0).setImageResource(2130840669);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */
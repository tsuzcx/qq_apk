package com.tencent.qqmini.sdk.launcher.widget;

import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class VideoGestureRelativeLayout$VideoPlayerOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private VideoGestureRelativeLayout videoGestureRelativeLayout;
  
  public VideoGestureRelativeLayout$VideoPlayerOnGestureListener(VideoGestureRelativeLayout paramVideoGestureRelativeLayout1, VideoGestureRelativeLayout paramVideoGestureRelativeLayout2)
  {
    this.videoGestureRelativeLayout = paramVideoGestureRelativeLayout2;
  }
  
  public boolean onContextClick(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onContextClick: ");
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDoubleTap: ");
    if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
      VideoGestureRelativeLayout.access$100(this.this$0).onDoubleTapGesture(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDoubleTapEvent: ");
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDown: ");
    VideoGestureRelativeLayout.access$002(this.this$0, false);
    VideoGestureRelativeLayout.access$302(this.this$0, 0);
    if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
      VideoGestureRelativeLayout.access$100(this.this$0).onDown(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Log.d("gesturetest", "onFling: ");
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onLongPress: ");
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Log.d("gesturetest", "onScroll: e1:" + paramMotionEvent1.getX() + "," + paramMotionEvent1.getY());
    Log.d("gesturetest", "onScroll: e2:" + paramMotionEvent2.getX() + "," + paramMotionEvent2.getY());
    Log.d("gesturetest", "onScroll: X:" + paramFloat1 + "  Y:" + paramFloat2);
    switch (VideoGestureRelativeLayout.access$300(this.this$0))
    {
    default: 
      return true;
    case 0: 
      Log.d("gesturetest", "NONE: ");
      if (Math.abs(paramFloat1) - Math.abs(paramFloat2) > VideoGestureRelativeLayout.access$400(this.this$0))
      {
        VideoGestureRelativeLayout.access$302(this.this$0, 3);
        return true;
      }
      if (paramMotionEvent1.getX() < this.this$0.getWidth() / 2)
      {
        VideoGestureRelativeLayout.access$302(this.this$0, 2);
        return true;
      }
      VideoGestureRelativeLayout.access$302(this.this$0, 1);
      return true;
    case 1: 
      if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
        VideoGestureRelativeLayout.access$100(this.this$0).onVolumeGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      Log.d("gesturetest", "VOLUME: ");
      return true;
    case 2: 
      if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
        VideoGestureRelativeLayout.access$100(this.this$0).onBrightnessGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      Log.d("gesturetest", "BRIGHTNESS: ");
      return true;
    }
    if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
      VideoGestureRelativeLayout.access$100(this.this$0).onProgressGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    VideoGestureRelativeLayout.access$002(this.this$0, true);
    Log.d("gesturetest", "FF_REW: ");
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onShowPress: ");
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onSingleTapConfirmed: ");
    if (VideoGestureRelativeLayout.access$100(this.this$0) != null) {
      VideoGestureRelativeLayout.access$100(this.this$0).onSingleTapGesture(paramMotionEvent);
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onSingleTapUp: ");
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoPlayerOnGestureListener
 * JD-Core Version:    0.7.0.1
 */
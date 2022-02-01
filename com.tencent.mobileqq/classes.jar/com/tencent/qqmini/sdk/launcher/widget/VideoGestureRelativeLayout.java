package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.FrameLayout;

public class VideoGestureRelativeLayout
  extends FrameLayout
{
  private static final int BRIGHTNESS = 2;
  private static final int FF_REW = 3;
  private static final int NONE = 0;
  private static final String TAG = "gesturetest";
  private static final int VOLUME = 1;
  private boolean enablePageGesture = false;
  private boolean enablePlayGesture = false;
  private boolean enableProgressGesture = true;
  private boolean hasFFREW = false;
  private GestureDetector mGestureDetector;
  private VideoGestureRelativeLayout.VideoPlayerOnGestureListener mOnGestureListener;
  private int mScrollMode = 0;
  private VideoGestureRelativeLayout.VideoGestureListener mVideoGestureListener;
  private int offsetX = 1;
  
  public VideoGestureRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoGestureRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mOnGestureListener = new VideoGestureRelativeLayout.VideoPlayerOnGestureListener(this, this);
    this.mGestureDetector = new GestureDetector(paramContext, this.mOnGestureListener);
    this.mGestureDetector.setIsLongpressEnabled(false);
    setOnTouchListener(new VideoGestureRelativeLayout.1(this));
  }
  
  public void setEnablePageGesture(boolean paramBoolean)
  {
    this.enablePageGesture = paramBoolean;
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    this.enablePlayGesture = paramBoolean;
  }
  
  public void setEnableProgressGesture(boolean paramBoolean)
  {
    this.enableProgressGesture = paramBoolean;
  }
  
  public void setVideoGestureListener(VideoGestureRelativeLayout.VideoGestureListener paramVideoGestureListener)
  {
    this.mVideoGestureListener = paramVideoGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
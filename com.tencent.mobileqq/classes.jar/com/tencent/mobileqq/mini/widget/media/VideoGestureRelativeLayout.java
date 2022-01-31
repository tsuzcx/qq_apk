package com.tencent.mobileqq.mini.widget.media;

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
  private boolean hasFF_REW;
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
  
  public void setVideoGestureListener(VideoGestureRelativeLayout.VideoGestureListener paramVideoGestureListener)
  {
    this.mVideoGestureListener = paramVideoGestureListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.VideoGestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
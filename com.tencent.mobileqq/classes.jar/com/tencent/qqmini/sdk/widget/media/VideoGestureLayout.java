package com.tencent.qqmini.sdk.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;

public class VideoGestureLayout
  extends RelativeLayout
{
  private static final String TAG = "VideoGestureLayout";
  private int duration = 1000;
  private ImageView ivCenter;
  private VideoGestureLayout.HideRunnable mHideRunnable;
  private ProgressBar pb;
  
  public VideoGestureLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_video_gesture_layout, this);
    this.ivCenter = ((ImageView)findViewById(R.id.iv_center));
    this.pb = ((ProgressBar)findViewById(R.id.pb));
    this.mHideRunnable = new VideoGestureLayout.HideRunnable(this, null);
    setVisibility(8);
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.ivCenter.setImageResource(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    this.pb.setProgress(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setProgress: ");
    localStringBuilder.append(paramInt);
    Log.d("VideoGestureLayout", localStringBuilder.toString());
  }
  
  public void show()
  {
    setVisibility(0);
    removeCallbacks(this.mHideRunnable);
    postDelayed(this.mHideRunnable, this.duration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.VideoGestureLayout
 * JD-Core Version:    0.7.0.1
 */
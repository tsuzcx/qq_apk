package com.tencent.qqmini.sdk.core.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class VideoGestureLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1000;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoGestureLayout.HideRunnable jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout$HideRunnable;
  
  public VideoGestureLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559312, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368520));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131371324));
    this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout$HideRunnable = new VideoGestureLayout.HideRunnable(this, null);
    setVisibility(8);
  }
  
  public void a()
  {
    setVisibility(0);
    removeCallbacks(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout$HideRunnable);
    postDelayed(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaVideoGestureLayout$HideRunnable, this.jdField_a_of_type_Int);
  }
  
  public void setDuration(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    Log.d("VideoGestureLayout", "setProgress: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.VideoGestureLayout
 * JD-Core Version:    0.7.0.1
 */
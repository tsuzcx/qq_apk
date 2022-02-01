package com.tencent.ttpic.videoshelf.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class VideoShelfView
  extends VideoView
{
  public VideoShelfView(Context paramContext)
  {
    super(getWrapperContext(paramContext));
  }
  
  public VideoShelfView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(getWrapperContext(paramContext), paramAttributeSet);
  }
  
  public VideoShelfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(getWrapperContext(paramContext), paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public VideoShelfView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(getWrapperContext(paramContext), paramAttributeSet, paramInt1, paramInt2);
  }
  
  private static Context getWrapperContext(Context paramContext)
  {
    return new VideoShelfView.1(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.VideoShelfView
 * JD-Core Version:    0.7.0.1
 */
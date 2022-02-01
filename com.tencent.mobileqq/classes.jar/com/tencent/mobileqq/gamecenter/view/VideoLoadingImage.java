package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class VideoLoadingImage
  extends ImageView
{
  private int a = 1;
  
  public VideoLoadingImage(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoLoadingImage(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(2131370383);
    if ((localFrameLayout != null) && (paramBoolean)) {
      localFrameLayout.setBackgroundColor(paramInt);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    int i = this.a;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      setImageDrawable(getResources().getDrawable(2130839404));
      setScaleType(ImageView.ScaleType.CENTER);
      a(true, -16777216);
      return;
    }
    setImageDrawable(new VideoLoadingImage.DefaultLoadingDrawable(getResources()));
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    a(false, 0);
  }
  
  public void setStyle(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (2 == this.a)
    {
      FrameLayout localFrameLayout = (FrameLayout)getRootView().findViewById(2131370383);
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage
 * JD-Core Version:    0.7.0.1
 */
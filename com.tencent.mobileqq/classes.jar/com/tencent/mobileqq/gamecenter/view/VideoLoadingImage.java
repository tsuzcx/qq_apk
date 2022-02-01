package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import avgc;

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
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setImageDrawable(new avgc(getResources()));
  }
  
  public void setStyle(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

public class ImageViewTouche
  extends ImageViewTouchBase
{
  private boolean mEnableTrackballScroll;
  private Bitmap region;
  private boolean showRegion;
  
  public ImageViewTouche(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageViewTouche(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void postTranslateCenter(float paramFloat1, float paramFloat2)
  {
    super.postTranslate(paramFloat1, paramFloat2);
    center(true, true);
  }
  
  public void setEnableTrackballScroll(boolean paramBoolean)
  {
    this.mEnableTrackballScroll = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageViewTouche
 * JD-Core Version:    0.7.0.1
 */
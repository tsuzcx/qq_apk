package com.tencent.viola.ui.dom.style;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

@TargetApi(21)
public class CornerViewOutlineProvider
  extends ViewOutlineProvider
{
  public static final int CLIP_CHILD_TYPE_ALL = 0;
  public static final int CLIP_CHILD_TYPE_BOTTOM = 2;
  public static final int CLIP_CHILD_TYPE_TOP = 1;
  private int mHeight;
  private float mRadius;
  private int mType;
  
  public CornerViewOutlineProvider(float paramFloat, int paramInt1, int paramInt2)
  {
    this.mRadius = paramFloat;
    this.mHeight = paramInt1;
    this.mType = paramInt2;
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    int j;
    int k;
    int i;
    if (this.mType == 2)
    {
      j = -25;
      k = paramView.getWidth();
      if (this.mType != 0) {
        break label58;
      }
      i = paramView.getHeight();
    }
    for (;;)
    {
      paramOutline.setRoundRect(new Rect(0, j, k, i), this.mRadius);
      return;
      j = 0;
      break;
      label58:
      if (paramView.getHeight() > this.mHeight) {
        i = paramView.getHeight() + 25;
      } else {
        i = this.mHeight + 25;
      }
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.CornerViewOutlineProvider
 * JD-Core Version:    0.7.0.1
 */
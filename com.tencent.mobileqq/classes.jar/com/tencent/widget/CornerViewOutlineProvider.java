package com.tencent.widget;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

@TargetApi(21)
public class CornerViewOutlineProvider
  extends ViewOutlineProvider
{
  private float a;
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(new Rect(0, 0, paramView.getWidth(), paramView.getHeight()), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.CornerViewOutlineProvider
 * JD-Core Version:    0.7.0.1
 */
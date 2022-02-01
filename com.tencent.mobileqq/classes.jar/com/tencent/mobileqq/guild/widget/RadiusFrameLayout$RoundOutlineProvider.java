package com.tencent.mobileqq.guild.widget;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

class RadiusFrameLayout$RoundOutlineProvider
  extends ViewOutlineProvider
{
  final RadiusFrameLayout.CornersHolder a;
  
  RadiusFrameLayout$RoundOutlineProvider(RadiusFrameLayout.CornersHolder paramCornersHolder)
  {
    this.a = paramCornersHolder;
  }
  
  static RoundOutlineProvider a(RadiusFrameLayout.CornersHolder paramCornersHolder)
  {
    return new RoundOutlineProvider(paramCornersHolder);
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramView = new RectF(0.0F, 0.0F, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
    Path localPath = new Path();
    float f1 = this.a.a;
    float f2 = this.a.a;
    float f3 = this.a.b;
    float f4 = this.a.b;
    float f5 = this.a.c;
    float f6 = this.a.c;
    float f7 = this.a.d;
    float f8 = this.a.d;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(paramView, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
    localPath.close();
    paramOutline.setConvexPath(localPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.RadiusFrameLayout.RoundOutlineProvider
 * JD-Core Version:    0.7.0.1
 */
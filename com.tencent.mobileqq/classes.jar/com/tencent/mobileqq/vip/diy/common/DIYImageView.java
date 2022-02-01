package com.tencent.mobileqq.vip.diy.common;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DIYImageView
  extends FrameLayout
{
  private ImageView a;
  
  public DIYImageView(Context paramContext)
  {
    super(paramContext);
    this.a = new ImageView(paramContext);
    addView(this.a);
  }
  
  public ImageView a()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYImageView
 * JD-Core Version:    0.7.0.1
 */
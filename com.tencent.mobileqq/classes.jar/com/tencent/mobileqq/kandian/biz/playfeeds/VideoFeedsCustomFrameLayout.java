package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class VideoFeedsCustomFrameLayout
  extends FrameLayout
{
  private boolean a = true;
  private float b;
  private float c;
  private boolean d = false;
  
  public VideoFeedsCustomFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.b = paramMotionEvent.getY();
      this.c = paramMotionEvent.getX();
    }
    else if ((paramMotionEvent.getAction() == 2) && (!this.a) && (paramMotionEvent.getY() - this.b > 300.0F) && (!this.d))
    {
      this.d = true;
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCustomFrameLayout
 * JD-Core Version:    0.7.0.1
 */
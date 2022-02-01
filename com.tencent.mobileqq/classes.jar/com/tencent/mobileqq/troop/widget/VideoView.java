package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.MotionEvent;

public class VideoView
  extends android.widget.VideoView
{
  public VideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.VideoView
 * JD-Core Version:    0.7.0.1
 */
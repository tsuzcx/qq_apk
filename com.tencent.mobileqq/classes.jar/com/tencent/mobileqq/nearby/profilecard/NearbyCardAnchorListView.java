package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.widget.HorizontalListView;

public class NearbyCardAnchorListView
  extends HorizontalListView
{
  private float a;
  private float b;
  
  public NearbyCardAnchorListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NearbyCardAnchorListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if (Math.abs(paramMotionEvent.getX() - this.a) > Math.abs(paramMotionEvent.getY() - this.b))
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyCardAnchorListView
 * JD-Core Version:    0.7.0.1
 */
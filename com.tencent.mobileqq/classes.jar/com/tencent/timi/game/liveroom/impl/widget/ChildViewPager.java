package com.tencent.timi.game.liveroom.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class ChildViewPager
  extends ViewPager
{
  public ChildViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ChildViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(boolean paramBoolean)
  {
    for (ViewParent localViewParent = getParent(); (!(localViewParent instanceof ViewPager2)) && (localViewParent != null); localViewParent = localViewParent.getParent()) {}
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        i = getCurrentItem();
        if ((i != getAdapter().getCount() - 1) && (i != 0)) {
          a(true);
        } else {
          a(false);
        }
      }
    }
    else {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.ChildViewPager
 * JD-Core Version:    0.7.0.1
 */
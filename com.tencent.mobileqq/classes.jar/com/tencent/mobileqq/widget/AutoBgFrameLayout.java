package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class AutoBgFrameLayout
  extends FrameLayout
{
  public static ColorFilter a = new PorterDuffColorFilter(419430400, PorterDuff.Mode.SRC_ATOP);
  
  public AutoBgFrameLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoBgFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoBgFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    Drawable localDrawable;
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        localDrawable = getBackground();
        if (localDrawable != null)
        {
          localDrawable.setColorFilter(null);
          localDrawable.invalidateSelf();
        }
      }
    }
    else
    {
      localDrawable = getBackground();
      if (localDrawable != null) {
        localDrawable.setColorFilter(a);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoBgFrameLayout
 * JD-Core Version:    0.7.0.1
 */
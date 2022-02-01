package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class LayerImageView
  extends ImageView
{
  public LayerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        getDrawable().clearColorFilter();
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    getDrawable().setColorFilter(855638016, PorterDuff.Mode.SRC_ATOP);
    super.dispatchTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LayerImageView
 * JD-Core Version:    0.7.0.1
 */
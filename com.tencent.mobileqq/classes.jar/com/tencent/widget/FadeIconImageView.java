package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;

public class FadeIconImageView
  extends ImageView
{
  public FadeIconImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FadeIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      int[] arrayOfInt = getDrawableState();
      if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {
        localDrawable.setAlpha(66);
      }
    }
    else
    {
      return;
    }
    localDrawable.setAlpha(255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.FadeIconImageView
 * JD-Core Version:    0.7.0.1
 */
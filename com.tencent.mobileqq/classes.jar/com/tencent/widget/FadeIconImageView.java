package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;
import bhxb;

public class FadeIconImageView
  extends ImageView
{
  private bhxb a;
  
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
  
  public void setVisibility(int paramInt)
  {
    if ((this.a == null) || (!this.a.a(paramInt))) {
      super.setVisibility(paramInt);
    }
  }
  
  public void setVisibilityHandler(bhxb parambhxb)
  {
    this.a = parambhxb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.FadeIconImageView
 * JD-Core Version:    0.7.0.1
 */
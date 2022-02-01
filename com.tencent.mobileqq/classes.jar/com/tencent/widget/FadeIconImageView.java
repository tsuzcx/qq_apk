package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageView;

public class FadeIconImageView
  extends ImageView
{
  private FadeIconImageView.ISetVisibilityHandler setVisibilityHandler = null;
  
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
      if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt))
      {
        localDrawable.setAlpha(66);
        return;
      }
      localDrawable.setAlpha(255);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    FadeIconImageView.ISetVisibilityHandler localISetVisibilityHandler = this.setVisibilityHandler;
    if ((localISetVisibilityHandler == null) || (!localISetVisibilityHandler.onSetVisibility(paramInt))) {
      super.setVisibility(paramInt);
    }
  }
  
  public void setVisibilityHandler(FadeIconImageView.ISetVisibilityHandler paramISetVisibilityHandler)
  {
    this.setVisibilityHandler = paramISetVisibilityHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FadeIconImageView
 * JD-Core Version:    0.7.0.1
 */
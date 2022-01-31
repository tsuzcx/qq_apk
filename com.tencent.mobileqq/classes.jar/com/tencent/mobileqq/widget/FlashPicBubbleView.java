package com.tencent.mobileqq.widget;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.RelativeLayout;

public class FlashPicBubbleView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public FlashPicBubbleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlashPicBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      invalidate();
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = getResources();
    Drawable localDrawable1 = ((Resources)localObject).getDrawable(2130846708);
    Drawable localDrawable2 = ((Resources)localObject).getDrawable(2130846709);
    localDrawable1.setBounds(0, 0, getWidth(), aekt.a(95.0F, (Resources)localObject));
    localDrawable2.setBounds(0, aekt.a(95.0F, (Resources)localObject), getWidth(), getHeight());
    LightingColorFilter localLightingColorFilter;
    if ((!this.c) && (!this.jdField_a_of_type_Boolean))
    {
      localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166288));
      localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165508));
    }
    for (;;)
    {
      localDrawable2.setColorFilter((ColorFilter)localObject);
      localDrawable2.setAlpha(255);
      localDrawable2.draw(paramCanvas);
      localDrawable1.setColorFilter(localLightingColorFilter);
      localDrawable1.setAlpha(255);
      if (this.b) {
        break;
      }
      localDrawable1.draw(paramCanvas);
      return;
      if ((!this.c) && (this.jdField_a_of_type_Boolean))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166289));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166285));
      }
      else if ((this.c) && (!this.jdField_a_of_type_Boolean))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166286));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165508));
      }
      else
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166287));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166285));
      }
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getWidth() / 2, getHeight() / 2);
    localDrawable1.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setBackground(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((this.b ^ paramBoolean1)) || ((this.c ^ paramBoolean2)))
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FlashPicBubbleView
 * JD-Core Version:    0.7.0.1
 */
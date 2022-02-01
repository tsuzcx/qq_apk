package com.tencent.mobileqq.widget;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class FlashPicBubbleView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
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
    if (StateSet.stateSetMatches(PRESSED_WINDOW_FOCUSED_STATE_SET, arrayOfInt)) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = getResources();
    Drawable localDrawable1 = ((Resources)localObject).getDrawable(2130847479);
    Drawable localDrawable2 = ((Resources)localObject).getDrawable(2130847480);
    localDrawable1.setBounds(0, 0, getWidth(), AIOUtils.b(95.0F, (Resources)localObject));
    localDrawable2.setBounds(0, AIOUtils.b(95.0F, (Resources)localObject), getWidth(), getHeight());
    LightingColorFilter localLightingColorFilter;
    if ((!this.c) && (!this.jdField_a_of_type_Boolean))
    {
      localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166407));
      localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165535));
    }
    for (;;)
    {
      break;
      if ((!this.c) && (this.jdField_a_of_type_Boolean))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166408));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166404));
      }
      else if ((this.c) && (!this.jdField_a_of_type_Boolean))
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166405));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131165535));
      }
      else
      {
        localLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166406));
        localObject = new LightingColorFilter(Color.argb(255, 0, 0, 0), ((Resources)localObject).getColor(2131166404));
      }
    }
    localDrawable2.setColorFilter((ColorFilter)localObject);
    localDrawable2.setAlpha(255);
    localDrawable2.draw(paramCanvas);
    localDrawable1.setColorFilter(localLightingColorFilter);
    localDrawable1.setAlpha(255);
    if (!this.b)
    {
      localDrawable1.draw(paramCanvas);
      return;
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
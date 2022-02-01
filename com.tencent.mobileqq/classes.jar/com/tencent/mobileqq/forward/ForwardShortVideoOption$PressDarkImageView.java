package com.tencent.mobileqq.forward;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;

class ForwardShortVideoOption$PressDarkImageView
  extends ImageView
{
  public static ColorFilter a = new PorterDuffColorFilter(167970842, PorterDuff.Mode.SRC_ATOP);
  ImageView b;
  
  public ForwardShortVideoOption$PressDarkImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ForwardShortVideoOption$PressDarkImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ForwardShortVideoOption$PressDarkImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject;
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(0.5F);
        localObject = this.b;
        if (localObject != null)
        {
          localObject = ((ImageView)localObject).getDrawable();
          if (localObject != null) {
            ((Drawable)localObject).setColorFilter(BaseBubbleBuilder.n);
          }
        }
      }
    }
    else if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(1.0F);
      localObject = this.b;
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getDrawable();
        if (localObject != null) {
          ((Drawable)localObject).setColorFilter(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.PressDarkImageView
 * JD-Core Version:    0.7.0.1
 */
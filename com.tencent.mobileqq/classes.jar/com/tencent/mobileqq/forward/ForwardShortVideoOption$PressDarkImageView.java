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
  public static ColorFilter a;
  ImageView a;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(167970842, PorterDuff.Mode.SRC_ATOP);
  }
  
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
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable;
    if (isPressed()) {
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(0.5F);
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
          if (localDrawable != null) {
            localDrawable.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (Build.VERSION.SDK_INT < 11);
        super.setAlpha(1.0F);
      } while (this.jdField_a_of_type_AndroidWidgetImageView == null);
      localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    } while (localDrawable == null);
    localDrawable.setColorFilter(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption.PressDarkImageView
 * JD-Core Version:    0.7.0.1
 */
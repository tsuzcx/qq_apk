package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class TransitionImageView
  extends FrameLayout
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  
  public TransitionImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    addView(this.jdField_b_of_type_ComTencentImageURLImageView, -1, -1);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(1500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label25;
      }
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    label25:
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransitionImageView
 * JD-Core Version:    0.7.0.1
 */
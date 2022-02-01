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
  private URLImageView a;
  private URLImageView b;
  private int c;
  private Animation d;
  private Animation e;
  
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
    this.a = new URLImageView(paramContext);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b = new URLImageView(paramContext);
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.a, -1, -1);
    addView(this.b, -1, -1);
    this.c = 0;
    this.d = new AlphaAnimation(0.0F, 1.0F);
    this.d.setDuration(1500L);
    this.d.setFillAfter(true);
    this.d.setAnimationListener(this);
    this.e = new AlphaAnimation(1.0F, 0.0F);
    this.e.setDuration(1500L);
    this.e.setFillAfter(true);
    this.e.setAnimationListener(this);
  }
  
  public Drawable getDrawable()
  {
    int i = this.c;
    Drawable localDrawable = null;
    if (i == 0) {
      return null;
    }
    if (i == 1) {
      return this.a.getDrawable();
    }
    if (i == 2) {
      localDrawable = this.b.getDrawable();
    }
    return localDrawable;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.e)
    {
      int i = this.c;
      if (i == 1)
      {
        this.b.setImageDrawable(null);
        return;
      }
      if (i == 2) {
        this.a.setImageDrawable(null);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.c = 0;
    this.a.clearAnimation();
    this.b.clearAnimation();
    this.d.reset();
    this.e.reset();
    this.a.setImageDrawable(paramDrawable);
    this.b.setImageDrawable(null);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransitionImageView
 * JD-Core Version:    0.7.0.1
 */
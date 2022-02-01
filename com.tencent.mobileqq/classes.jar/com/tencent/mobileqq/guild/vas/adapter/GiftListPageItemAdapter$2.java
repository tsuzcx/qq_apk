package com.tencent.mobileqq.guild.vas.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

class GiftListPageItemAdapter$2
  implements ValueAnimator.AnimatorUpdateListener
{
  GiftListPageItemAdapter$2(GiftListPageItemAdapter paramGiftListPageItemAdapter, RelativeLayout paramRelativeLayout1, ImageView paramImageView1, TextView paramTextView1, RelativeLayout paramRelativeLayout2, ImageView paramImageView2, TextView paramTextView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(paramValueAnimator.getAnimatedFraction());
    this.a.setScaleX(GiftListPageItemAdapter.d(this.g) + (1.0F - GiftListPageItemAdapter.d(this.g)) * paramValueAnimator.getAnimatedFraction());
    this.a.setScaleY(GiftListPageItemAdapter.d(this.g) + (1.0F - GiftListPageItemAdapter.d(this.g)) * paramValueAnimator.getAnimatedFraction());
    this.b.setScaleX((1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F) * paramValueAnimator.getAnimatedFraction() + 1.0F);
    this.b.setScaleY((1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F) * paramValueAnimator.getAnimatedFraction() + 1.0F);
    this.c.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
    Object localObject = this.b;
    ((ImageView)localObject).setTranslationY(((ImageView)localObject).getHeight() * (1.0F - this.b.getScaleY()) / 2.0F);
    localObject = this.d;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setScaleX(1.0F - (1.0F - GiftListPageItemAdapter.d(this.g)) * paramValueAnimator.getAnimatedFraction());
      this.d.setScaleY(1.0F - (1.0F - GiftListPageItemAdapter.d(this.g)) * paramValueAnimator.getAnimatedFraction());
      this.d.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ImageView)localObject).setScaleX(1.0F / GiftListPageItemAdapter.b(this.g) - (1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F) * paramValueAnimator.getAnimatedFraction());
      this.e.setScaleY(1.0F / GiftListPageItemAdapter.b(this.g) - (1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F) * paramValueAnimator.getAnimatedFraction());
      localObject = this.e;
      ((ImageView)localObject).setTranslationY(((ImageView)localObject).getHeight() * (1.0F - this.e.getScaleY()) / 2.0F);
    }
    localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setAlpha(paramValueAnimator.getAnimatedFraction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.2
 * JD-Core Version:    0.7.0.1
 */
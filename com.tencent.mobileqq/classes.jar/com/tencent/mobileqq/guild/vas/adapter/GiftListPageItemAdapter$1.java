package com.tencent.mobileqq.guild.vas.adapter;

import android.animation.Animator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GiftListPageItemAdapter$1
  extends D8SafeAnimatorListener
{
  GiftListPageItemAdapter$1(GiftListPageItemAdapter paramGiftListPageItemAdapter, RelativeLayout paramRelativeLayout1, ImageView paramImageView1, TextView paramTextView1, RelativeLayout paramRelativeLayout2, ImageView paramImageView2, TextView paramTextView2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
    this.a.setAlpha(1.0F);
    this.a.setVisibility(0);
    this.b.setScaleX(1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F + 1.0F);
    this.b.setScaleY(1.0F / GiftListPageItemAdapter.b(this.g) - 1.0F + 1.0F);
    this.c.setAlpha(0.0F);
    paramAnimator = this.b;
    paramAnimator.setTranslationY(paramAnimator.getHeight() * (1.0F - this.b.getScaleY()) / 2.0F);
    paramAnimator = this.d;
    if (paramAnimator != null)
    {
      paramAnimator.setScaleX(GiftListPageItemAdapter.d(this.g));
      this.d.setScaleY(GiftListPageItemAdapter.d(this.g));
      this.d.setVisibility(8);
      this.d.setAlpha(0.0F);
    }
    paramAnimator = this.e;
    if (paramAnimator != null)
    {
      paramAnimator.setScaleX(1.0F);
      this.e.setScaleY(1.0F);
      paramAnimator = this.e;
      paramAnimator.setTranslationY(paramAnimator.getHeight() * (1.0F - this.e.getScaleY()) / 2.0F);
    }
    paramAnimator = this.f;
    if (paramAnimator != null) {
      paramAnimator.setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.setScaleX(GiftListPageItemAdapter.d(this.g));
    this.a.setScaleY(GiftListPageItemAdapter.d(this.g));
    this.a.setVisibility(0);
    this.a.setAlpha(0.0F);
    this.b.setScaleX(1.0F);
    this.b.setScaleY(1.0F);
    this.c.setAlpha(1.0F);
    paramAnimator = this.b;
    paramAnimator.setTranslationY(paramAnimator.getHeight() * (1.0F - this.b.getScaleY()) / 2.0F);
    paramAnimator = this.d;
    if (paramAnimator != null)
    {
      paramAnimator.setScaleX(1.0F);
      this.d.setScaleY(1.0F);
      this.d.setVisibility(0);
      this.d.setAlpha(1.0F);
    }
    paramAnimator = this.e;
    if (paramAnimator != null)
    {
      paramAnimator.setScaleX(1.0F / GiftListPageItemAdapter.b(this.g));
      this.e.setScaleY(1.0F / GiftListPageItemAdapter.b(this.g));
      paramAnimator = this.e;
      paramAnimator.setTranslationY(paramAnimator.getHeight() * (1.0F - this.e.getScaleY()) / 2.0F);
    }
    paramAnimator = this.f;
    if (paramAnimator != null) {
      paramAnimator.setAlpha(0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.1
 * JD-Core Version:    0.7.0.1
 */
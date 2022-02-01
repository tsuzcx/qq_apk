package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import java.util.Random;

public class VideoFeedsLikeAnimate
{
  private ViewGroup a;
  private VideoFeedsLikeAnimate.LikeExplosionCenterView b;
  private VideoFeedsLikeAnimate.LikeExplosionView c;
  private float d;
  private float e;
  
  public VideoFeedsLikeAnimate(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, Random paramRandom)
  {
    this.a = paramViewGroup;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.b = new VideoFeedsLikeAnimate.LikeExplosionCenterView(this, this.a.getContext());
    this.b.setPivotX(this.d);
    this.b.setPivotY(this.e);
    this.b.setDrawableId(2130844187);
    this.c = new VideoFeedsLikeAnimate.LikeExplosionView(this, this.a.getContext(), paramRandom);
    this.c.setAlpha(0.0F);
    this.a.addView(this.c);
    this.a.addView(this.b);
  }
  
  public void a()
  {
    this.b.a();
    this.c.a();
  }
  
  public void a(int paramInt)
  {
    this.c.setExplosionEachDirection(paramInt);
  }
  
  public void a(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    this.c.setIconExplosionEachDirection(paramArrayOfDrawable, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate
 * JD-Core Version:    0.7.0.1
 */
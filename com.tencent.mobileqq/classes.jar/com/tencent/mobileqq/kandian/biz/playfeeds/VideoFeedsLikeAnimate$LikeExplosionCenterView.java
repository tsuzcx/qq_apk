package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;

public class VideoFeedsLikeAnimate$LikeExplosionCenterView
  extends View
{
  private Bitmap b;
  private Paint c = new Paint();
  
  public VideoFeedsLikeAnimate$LikeExplosionCenterView(VideoFeedsLikeAnimate paramVideoFeedsLikeAnimate, Context paramContext)
  {
    super(paramContext);
  }
  
  private void b()
  {
    setAlpha(0.0F);
    if (VideoFeedsLikeAnimate.a(this.a) != null) {
      VideoFeedsLikeAnimate.a(this.a).removeView(this);
    }
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.75F, 1.0F) }) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.4F), Keyframe.ofFloat(0.75F, 1.0F), Keyframe.ofFloat(1.0F, 1.28F) }) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(400L);
    localObjectAnimator1.addListener(new VideoFeedsLikeAnimate.LikeExplosionCenterView.1(this));
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.b, VideoFeedsLikeAnimate.b(this.a) - this.b.getWidth() / 2, VideoFeedsLikeAnimate.c(this.a) - this.b.getHeight() / 2, this.c);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }
  
  public void setDrawableId(int paramInt)
  {
    this.b = BitmapFactory.decodeResource(getResources(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionCenterView
 * JD-Core Version:    0.7.0.1
 */
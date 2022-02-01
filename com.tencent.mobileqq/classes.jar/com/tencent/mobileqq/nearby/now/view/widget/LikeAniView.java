package com.tencent.mobileqq.nearby.now.view.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Random;

public class LikeAniView
  extends FrameLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private int a = 180;
  private int b = 180;
  private ImageView c;
  private Interpolator d = new DecelerateInterpolator(1.5F);
  private Interpolator e = new LinearInterpolator();
  
  public LikeAniView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LikeAniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 90.0F));
    this.b = ((int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 90.0F));
    this.c = new ImageView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.a, this.b);
    addView(this.c, localLayoutParams);
    this.c.setImageResource(((IResourceUtil)QRoute.api(IResourceUtil.class)).getNearbyNowliveShortvideoLike());
    this.c.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = new Random().nextInt(40);
    this.c.setX(paramInt1 - this.a / 2);
    this.c.setY(paramInt2 - this.b / 2);
    this.c.setRotation(i - 20);
    Object localObject1 = ValueAnimator.ofFloat(new float[] { 1.3F, 0.85F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).addUpdateListener(this);
    Object localObject2 = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    ((ValueAnimator)localObject2).setDuration(150L);
    ((ValueAnimator)localObject2).addUpdateListener(this);
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.95F });
    localValueAnimator1.setDuration(150L);
    localValueAnimator1.addUpdateListener(this);
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.95F, 1.0F });
    localValueAnimator2.setDuration(150L);
    localValueAnimator2.addUpdateListener(this);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject1, localObject2, localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.addListener(this);
    localObject1 = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject1).setDuration(1500L);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether(new Animator[] { localAnimatorSet, localObject1 });
    ((AnimatorSet)localObject2).start();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.c.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.c.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.c.setVisibility(0);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.c.setScaleX(paramValueAnimator.floatValue());
    this.c.setScaleY(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.LikeAniView
 * JD-Core Version:    0.7.0.1
 */
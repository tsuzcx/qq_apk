package com.tencent.mobileqq.lightReply;

import aebr;
import aebs;
import aebt;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ImageExplodeLayout
  extends RelativeLayout
{
  private static PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF(0.0F, 0.0F);
  private static PointF jdField_b_of_type_AndroidGraphicsPointF = new PointF(350.0F, 250.0F);
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private PointF c = a(jdField_a_of_type_AndroidGraphicsPointF, jdField_b_of_type_AndroidGraphicsPointF);
  private PointF d = a(jdField_a_of_type_AndroidGraphicsPointF, jdField_b_of_type_AndroidGraphicsPointF);
  private PointF e = a(new PointF(-130.0F, -192.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF f = a(new PointF(-188.0F, -192.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF g = a(new PointF(-28.0F, -165.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF h = a(new PointF(-224.0F, -154.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF i = a(new PointF(-195.0F, -94.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF j = a(new PointF(-268.0F, -82.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF k = a(new PointF(-122.0F, -102.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF l = a(new PointF(-288.0F, -36.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF m = a(new PointF(-152.0F, 20.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF n = a(new PointF(-196.0F, 48.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF o = a(new PointF(-104.0F, -16.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF p = a(new PointF(-208.0F, 108.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF q = a(new PointF(160.0F, -24.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF r = a(new PointF(222.0F, -6.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF s = a(new PointF(102.0F, -40.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF t = a(new PointF(250.0F, 42.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF u = a(new PointF(84.0F, -148.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF v = a(new PointF(142.0F, -175.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF w = a(new PointF(26.0F, -124.0F), jdField_b_of_type_AndroidGraphicsPointF);
  private PointF x = a(new PointF(208.0F, -124.0F), jdField_b_of_type_AndroidGraphicsPointF);
  
  public ImageExplodeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageExplodeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImageExplodeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private AnimatorSet a(View paramView)
  {
    Object localObject1 = ObjectAnimator.ofFloat(paramView, View.SCALE_X, new float[] { 0.0F, 1.2F });
    Object localObject2 = ObjectAnimator.ofFloat(paramView, View.SCALE_Y, new float[] { 0.0F, 1.2F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
    localObject2 = ObjectAnimator.ofFloat(paramView, View.SCALE_X, new float[] { 1.2F, 1.0F });
    Object localObject3 = ObjectAnimator.ofFloat(paramView, View.SCALE_Y, new float[] { 1.2F, 1.0F });
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).setDuration(150L);
    ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObject3 });
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).setDuration(350L);
    localObject3 = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    paramView = new AnimatorSet();
    paramView.setDuration(200L);
    paramView.playTogether(new Animator[] { localObject3 });
    localObject3 = new AnimatorSet();
    ((AnimatorSet)localObject3).playSequentially(new Animator[] { localAnimatorSet, localObject1, localObject2, paramView });
    return localObject3;
  }
  
  private static AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, PointF paramPointF5)
  {
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, View.ROTATION, new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, View.ROTATION, new float[] { paramFloat2, paramFloat3 });
    paramPointF1 = a(paramView, paramPointF1, paramPointF2, paramPointF3);
    paramPointF3 = a(paramView, paramPointF2, paramPointF4, paramPointF5);
    paramPointF4 = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F });
    paramPointF4.setInterpolator(new aebt(null));
    paramPointF2 = new AnimatorSet();
    paramPointF2.playTogether(new Animator[] { localObjectAnimator2, paramPointF1 });
    paramPointF2.setTarget(paramView);
    paramPointF1 = new AnimatorSet();
    paramPointF1.playTogether(new Animator[] { localObjectAnimator1, paramPointF3, paramPointF4 });
    paramPointF1.setTarget(paramView);
    paramPointF3 = new AnimatorSet();
    paramPointF3.setInterpolator(new LinearInterpolator());
    paramPointF3.playSequentially(new Animator[] { paramPointF2, paramPointF1 });
    paramPointF3.setTarget(paramView);
    return paramPointF3;
  }
  
  private static ValueAnimator a(View paramView, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    paramPointF1 = ValueAnimator.ofObject(new ImageExplodeLayout.BezierEvaluatorOne(paramPointF3), new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.addUpdateListener(new aebs(paramView));
    paramPointF1.setTarget(paramView);
    paramPointF1.setDuration(400L);
    return paramPointF1;
  }
  
  public static PointF a(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF(paramPointF1.x + paramPointF2.x, paramPointF1.y + paramPointF2.y);
  }
  
  private void a(PointF paramPointF)
  {
    paramPointF.x = (paramPointF.x * this.jdField_b_of_type_Int / 300.0F - this.jdField_b_of_type_Int * 35 / 200);
    paramPointF.y = (paramPointF.y * this.jdField_a_of_type_Int / 300.0F - this.jdField_a_of_type_Int * 35 / 200);
  }
  
  public void a()
  {
    Object localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    Object localObject2 = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(this.c.x - this.jdField_b_of_type_Int / 2));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.c.y - this.jdField_a_of_type_Int / 2));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    addView((View)localObject1);
    localObject1 = a((View)localObject1);
    ((Animator)localObject1).addListener(new aebr(this));
    ((Animator)localObject1).start();
    int i1 = (int)(this.jdField_b_of_type_Int * 0.3D);
    int i2 = (int)(this.jdField_a_of_type_Int * 0.3D);
    localObject2 = new RelativeLayout.LayoutParams(i1, i2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.x - i1 / 2));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.y - i2 / 2));
    i1 = (int)(this.jdField_b_of_type_Int * 0.35D);
    i2 = (int)(this.jdField_a_of_type_Int * 0.35D);
    localObject1 = new RelativeLayout.LayoutParams(i1, i2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.x - i1 / 2));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.y - i2 / 2));
    i1 = (int)(this.jdField_b_of_type_Int * 0.25D);
    i2 = (int)(this.jdField_a_of_type_Int * 0.25D);
    Object localObject3 = new RelativeLayout.LayoutParams(i1, i2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.x - i1 / 2));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(jdField_b_of_type_AndroidGraphicsPointF.y - i2 / 2));
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    addView(localImageView);
    a(localImageView, 0.0F, -135.0F, -270.0F, this.d, this.e, this.g, this.h, this.f).start();
    localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView(localImageView);
    a(localImageView, 0.0F, -180.0F, -360.0F, this.d, this.i, this.k, this.l, this.j).start();
    localImageView = new ImageView(getContext());
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    addView(localImageView);
    a(localImageView, 0.0F, -135.0F, -270.0F, this.d, this.m, this.o, this.p, this.n).start();
    localObject3 = new ImageView(getContext());
    ((ImageView)localObject3).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    addView((View)localObject3);
    a((View)localObject3, 0.0F, 180.0F, 360.0F, this.d, this.q, this.s, this.t, this.r).start();
    localObject2 = new ImageView(getContext());
    ((ImageView)localObject2).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView((View)localObject2);
    a((View)localObject2, 0.0F, 135.0F, 270.0F, this.d, this.u, this.w, this.x, this.v).start();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setDrawble(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.c.x = (this.c.x * this.jdField_b_of_type_Int / 300.0F);
    this.c.y = (this.c.y * this.jdField_a_of_type_Int / 300.0F);
    a(this.d);
    a(this.e);
    a(this.f);
    a(this.g);
    a(this.h);
    a(this.i);
    a(this.j);
    a(this.k);
    a(this.l);
    a(this.m);
    a(this.n);
    a(this.o);
    a(this.p);
    a(this.q);
    a(this.r);
    a(this.s);
    a(this.t);
    a(this.u);
    a(this.v);
    a(this.w);
    a(this.x);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.ImageExplodeLayout
 * JD-Core Version:    0.7.0.1
 */
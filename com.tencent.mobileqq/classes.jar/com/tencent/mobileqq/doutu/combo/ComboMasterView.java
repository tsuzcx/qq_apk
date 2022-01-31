package com.tencent.mobileqq.doutu.combo;

import aepi;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import apki;
import apkj;
import apkk;
import apkl;
import apkm;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ComboMasterView
  extends LinearLayout
  implements Animator.AnimatorListener
{
  private int jdField_a_of_type_Int;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public apkj a;
  apkl jdField_a_of_type_Apkl;
  private apkm jdField_a_of_type_Apkm;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  boolean jdField_b_of_type_Boolean = true;
  private ImageView c;
  
  public ComboMasterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComboMasterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private PathMeasure a()
  {
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    try
    {
      f2 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      f1 = f2;
      if (QLog.isColorLevel())
      {
        QLog.d("ComboMasterView", 2, "get status_bar_height " + f2);
        f1 = f2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Path localPath;
        float f1 = (int)(getContext().getResources().getDisplayMetrics().density * 25.0F + 0.5D);
      }
    }
    f1 = f1 + aepi.a(54.0F, getContext().getResources()) + getContext().getResources().getDimension(2131298914);
    f2 = i - aepi.a(40.0F, getContext().getResources());
    f3 = i / 2.0F;
    f4 = j / 2.0F;
    f5 = f2 - f3;
    f6 = f1 - f4;
    f7 = (f5 - 0.0F) * 1.0F / 14.0F + 0.0F;
    f8 = (0.0F - f6) * 1.0F / 13.0F + f6;
    localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(f7, f8, f5, f6);
    if (QLog.isColorLevel()) {
      QLog.d("ComboMasterView", 2, "mCount " + this.jdField_a_of_type_Int + " startX: " + f3 + " startY:" + f4 + " toX:" + f2 + " toY: " + f1 + " middleX:" + f7 + " middleY: " + f8);
    }
    return new PathMeasure(localPath, false);
  }
  
  private Drawable a(View paramView, apkl paramapkl)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = paramapkl.jdField_a_of_type_Int;
    paramView.height = paramapkl.b;
    return paramapkl.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private boolean a(int paramInt)
  {
    apkl localapkl = apkk.c(paramInt);
    if (localapkl == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    this.jdField_a_of_type_Apkl = localapkl;
    return true;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    apkl localapkl = apkk.b(paramInt);
    if (localapkl == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, localapkl));
    return true;
  }
  
  public void a()
  {
    setBackgroundDrawable(a(this, this.jdField_a_of_type_Apkl));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 0.0F, 1.1F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 0.0F, 1.1F });
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator2.setDuration(200L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.1F, 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.1F, 1.0F });
    localObjectAnimator3.setDuration(200L);
    localObjectAnimator4.setDuration(200L);
    Object localObject = a();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, ((PathMeasure)localObject).getLength() });
    localValueAnimator.addUpdateListener(new apki(this, (PathMeasure)localObject, new float[2]));
    localValueAnimator.setDuration(400L);
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.27F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.27F });
    ((ValueAnimator)localObject).setDuration(400L);
    localObjectAnimator5.setDuration(400L);
    localObjectAnimator6.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).before(localObjectAnimator3);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator4);
    localValueAnimator.setStartDelay(600L);
    ((ValueAnimator)localObject).setStartDelay(600L);
    localObjectAnimator5.setStartDelay(600L);
    localObjectAnimator6.setStartDelay(600L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localValueAnimator);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play((Animator)localObject);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator5);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator6);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup.removeView(this);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  public void a(apkm paramapkm)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362260));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362261));
    this.c = ((ImageView)findViewById(2131362262));
    this.jdField_a_of_type_Apkm = paramapkm;
  }
  
  public boolean a(apkj paramapkj)
  {
    this.jdField_a_of_type_Apkj = paramapkj;
    int k = this.jdField_a_of_type_Apkj.jdField_a_of_type_Int;
    int j = k / 10;
    int i;
    if (j != 0)
    {
      i = j % 10;
      j /= 10;
    }
    for (;;)
    {
      if (j != 0) {
        j %= 100;
      }
      for (;;)
      {
        this.c.setVisibility(0);
        a(this.c, k % 10);
        if (j == 0) {
          if (i == 0)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            a(1);
          }
        }
        for (;;)
        {
          setPadding(aepi.a(162.0F / apkk.a, getContext().getResources()), 0, 0, 0);
          ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).setMargins(0, 0, 0 - aepi.a(20.0F / apkk.a, getContext().getResources()), 0);
          ((LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).setMargins(0, 0, 0 - aepi.a(20.0F / apkk.a, getContext().getResources()), 0);
          this.jdField_a_of_type_Int = k;
          return this.jdField_b_of_type_Boolean;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          a(this.jdField_b_of_type_AndroidWidgetImageView, i);
          a(2);
          continue;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          a(this.jdField_b_of_type_AndroidWidgetImageView, i);
          a(this.jdField_a_of_type_AndroidWidgetImageView, j);
          a(3);
        }
        j = 0;
      }
      i = 0;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Apkm != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null))
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Apkm.a(paramAnimator, this);
      }
      paramAnimator.removeAllListeners();
      this.jdField_a_of_type_Apkm = null;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboMasterView
 * JD-Core Version:    0.7.0.1
 */
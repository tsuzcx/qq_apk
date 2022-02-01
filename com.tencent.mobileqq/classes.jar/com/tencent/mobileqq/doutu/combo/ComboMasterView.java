package com.tencent.mobileqq.doutu.combo;

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
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

@TargetApi(14)
public class ComboMasterView
  extends LinearLayout
  implements Animator.AnimatorListener
{
  ComboObject a;
  AnimatorSet b;
  boolean c = false;
  boolean d = true;
  ComboResource.ImageObject e;
  private ComboUIManager f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private int j = 0;
  
  public ComboMasterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComboMasterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Drawable a(View paramView, ComboResource.ImageObject paramImageObject)
  {
    paramView = paramView.getLayoutParams();
    paramView.width = paramImageObject.a;
    paramView.height = paramImageObject.b;
    return paramImageObject.c;
  }
  
  private boolean a(int paramInt)
  {
    ComboResource.ImageObject localImageObject = ComboResource.c(paramInt, getContext());
    if (localImageObject == null)
    {
      this.d = false;
      return false;
    }
    this.e = localImageObject;
    return true;
  }
  
  private boolean a(ImageView paramImageView, int paramInt)
  {
    ComboResource.ImageObject localImageObject = ComboResource.b(paramInt, getContext());
    if (localImageObject == null)
    {
      this.d = false;
      return false;
    }
    paramImageView.setImageDrawable(a(paramImageView, localImageObject));
    return true;
  }
  
  private PathMeasure getPath()
  {
    int k = getContext().getResources().getDisplayMetrics().widthPixels;
    int m = getContext().getResources().getDisplayMetrics().heightPixels;
    try
    {
      f2 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      f1 = f2;
      if (!QLog.isColorLevel()) {
        break label133;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get status_bar_height ");
      ((StringBuilder)localObject).append(f2);
      QLog.d("ComboMasterView", 2, ((StringBuilder)localObject).toString());
      f1 = f2;
    }
    catch (Exception localException)
    {
      float f2;
      float f1;
      Object localObject;
      label102:
      double d1;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      float f8;
      StringBuilder localStringBuilder;
      break label102;
    }
    d1 = getContext().getResources().getDisplayMetrics().density * 25.0F;
    Double.isNaN(d1);
    f1 = (int)(d1 + 0.5D);
    label133:
    f1 = f1 + Utils.a(54.0F, getContext().getResources()) + getContext().getResources().getDimension(2131299920);
    f2 = k - Utils.a(40.0F, getContext().getResources());
    f3 = k / 2.0F;
    f4 = m / 2.0F;
    f5 = f2 - f3;
    f6 = f1 - f4;
    f7 = (f5 - 0.0F) * 1.0F / 14.0F + 0.0F;
    f8 = (0.0F - f6) * 1.0F / 13.0F + f6;
    localObject = new Path();
    ((Path)localObject).moveTo(0.0F, 0.0F);
    ((Path)localObject).quadTo(f7, f8, f5, f6);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mCount ");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" startX: ");
      localStringBuilder.append(f3);
      localStringBuilder.append(" startY:");
      localStringBuilder.append(f4);
      localStringBuilder.append(" toX:");
      localStringBuilder.append(f2);
      localStringBuilder.append(" toY: ");
      localStringBuilder.append(f1);
      localStringBuilder.append(" middleX:");
      localStringBuilder.append(f7);
      localStringBuilder.append(" middleY: ");
      localStringBuilder.append(f8);
      QLog.d("ComboMasterView", 2, localStringBuilder.toString());
    }
    return new PathMeasure((Path)localObject, false);
  }
  
  public void a()
  {
    setBackgroundDrawable(a(this, this.e));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 0.0F, 1.1F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 0.0F, 1.1F });
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator2.setDuration(200L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.1F, 1.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.1F, 1.0F });
    localObjectAnimator3.setDuration(200L);
    localObjectAnimator4.setDuration(200L);
    Object localObject = getPath();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, ((PathMeasure)localObject).getLength() });
    localValueAnimator.addUpdateListener(new ComboMasterView.1(this, (PathMeasure)localObject, new float[2]));
    localValueAnimator.setDuration(400L);
    localObject = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.27F });
    ObjectAnimator localObjectAnimator6 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.27F });
    ((ValueAnimator)localObject).setDuration(400L);
    localObjectAnimator5.setDuration(400L);
    localObjectAnimator6.setDuration(400L);
    this.b = new AnimatorSet();
    this.b.play(localObjectAnimator1).with(localObjectAnimator2).before(localObjectAnimator3);
    this.b.play(localObjectAnimator3).with(localObjectAnimator4);
    localValueAnimator.setStartDelay(600L);
    ((ValueAnimator)localObject).setStartDelay(600L);
    localObjectAnimator5.setStartDelay(600L);
    localObjectAnimator6.setStartDelay(600L);
    this.b.play(localValueAnimator);
    this.b.play((Animator)localObject);
    this.b.play(localObjectAnimator5);
    this.b.play(localObjectAnimator6);
    this.b.addListener(this);
    this.b.start();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup.removeView(this);
      this.c = true;
      this.b.cancel();
    }
  }
  
  public void a(ComboUIManager paramComboUIManager)
  {
    this.g = ((ImageView)findViewById(2131427942));
    this.h = ((ImageView)findViewById(2131427943));
    this.i = ((ImageView)findViewById(2131427944));
    this.f = paramComboUIManager;
  }
  
  public boolean a(ComboObject paramComboObject)
  {
    this.a = paramComboObject;
    int n = this.a.b;
    int m = n / 10;
    int k;
    if (m != 0)
    {
      k = m % 10;
      m /= 10;
    }
    else
    {
      k = 0;
    }
    if (m != 0) {
      m %= 100;
    } else {
      m = 0;
    }
    this.i.setVisibility(0);
    a(this.i, n % 10);
    if (m == 0)
    {
      if (k == 0)
      {
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        a(1);
      }
      else
      {
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        a(this.h, k);
        a(2);
      }
    }
    else
    {
      this.h.setVisibility(0);
      this.g.setVisibility(0);
      a(this.h, k);
      a(this.g, m);
      a(3);
    }
    setPadding(Utils.a(162.0F / ComboResource.e, getContext().getResources()), 0, 0, 0);
    ((LinearLayout.LayoutParams)this.g.getLayoutParams()).setMargins(0, 0, 0 - Utils.a(20.0F / ComboResource.e, getContext().getResources()), 0);
    ((LinearLayout.LayoutParams)this.h.getLayoutParams()).setMargins(0, 0, 0 - Utils.a(20.0F / ComboResource.e, getContext().getResources()), 0);
    this.j = n;
    return this.d;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ComboUIManager localComboUIManager = this.f;
    if ((localComboUIManager != null) && (this.b != null))
    {
      if (!this.c) {
        localComboUIManager.a(paramAnimator, this);
      }
      paramAnimator.removeAllListeners();
      this.f = null;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboMasterView
 * JD-Core Version:    0.7.0.1
 */
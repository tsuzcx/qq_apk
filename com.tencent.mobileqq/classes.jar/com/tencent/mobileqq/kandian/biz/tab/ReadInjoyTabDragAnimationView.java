package com.tencent.mobileqq.kandian.biz.tab;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

public class ReadInjoyTabDragAnimationView
  extends TabDragAnimationView
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean d;
  private int h = 0;
  private int i;
  private int j;
  
  public ReadInjoyTabDragAnimationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyTabDragAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private ReadInjoyTabDragAnimationView.DrawableBound a()
  {
    ReadInjoyTabDragAnimationView.DrawableBound localDrawableBound = new ReadInjoyTabDragAnimationView.DrawableBound(null);
    int n = getPaddingLeft();
    int m = getRight() - getLeft() - getPaddingRight();
    int i1 = getPaddingTop();
    int i2 = getBottom() - getTop() - getPaddingBottom();
    int k = this.jdField_b_of_type_Int;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            k = (n + m) / 2;
            i1 = (i1 + i2) / 2;
            n = k - this.c / 2;
            m = k + this.c / 2;
            i2 = i1 - this.jdField_d_of_type_Int / 2;
            i1 += this.jdField_d_of_type_Int / 2;
            break label303;
          }
          i1 = (i1 + i2) / 2;
          n = m - this.c / 2;
          k = i1 - this.jdField_d_of_type_Int / 2;
          i2 = this.jdField_d_of_type_Int / 2;
        }
        else
        {
          i1 = (i1 + i2) / 2;
          m = this.c + n;
          k = i1 - this.jdField_d_of_type_Int / 2;
          i2 = this.jdField_d_of_type_Int / 2;
        }
        i1 += i2;
        i2 = k;
        break label303;
      }
      k = (n + m) / 2;
      m = k - this.c / 2;
      k += this.c / 2;
      i1 = i2 - this.jdField_d_of_type_Int;
      n = i2;
    }
    else
    {
      k = (n + m) / 2;
      m = k - this.c / 2;
      k += this.c / 2;
      n = this.jdField_d_of_type_Int + i1;
    }
    i2 = i1;
    i1 = n;
    n = m;
    m = k;
    label303:
    localDrawableBound.a = n;
    localDrawableBound.c = i2;
    localDrawableBound.jdField_b_of_type_Int = m;
    localDrawableBound.jdField_d_of_type_Int = i1;
    return localDrawableBound;
  }
  
  private boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130849734);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeStyle  : ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ReadInjoyTabDragAnimationView", 4, ((StringBuilder)localObject).toString());
    this.h = paramInt;
    localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport.a = this.h;
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((a()) && (this.jdField_d_of_type_Boolean))
    {
      if (this.h != 1) {
        return;
      }
      if (!paramBoolean)
      {
        setPivotX(this.i);
        setPivotY(this.j);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
        ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
        localObjectAnimator4.setStartDelay(700L);
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator2).before(localObjectAnimator3);
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator3).with(localObjectAnimator4);
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ReadInjoyTabDragAnimationView.1(this));
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
        return;
      }
      setPivotX(this.i);
      setPivotY(this.j);
      setVisibility(0);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator2).with(localObjectAnimator1);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ReadInjoyTabDragAnimationView.2(this));
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ReadInjoyTabDragAnimationView.DrawableBound localDrawableBound;
    if ((a()) && (this.jdField_d_of_type_Boolean) && (this.h == 1))
    {
      localDrawableBound = a();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.i = ((localDrawableBound.a + localDrawableBound.jdField_b_of_type_Int) / 2);
        this.j = ((localDrawableBound.c + localDrawableBound.jdField_d_of_type_Int) / 2);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localDrawableBound.a, localDrawableBound.c, localDrawableBound.jdField_b_of_type_Int, localDrawableBound.jdField_d_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    else
    {
      if (this.i == 0)
      {
        localDrawableBound = a();
        this.i = ((localDrawableBound.a + localDrawableBound.jdField_b_of_type_Int) / 2);
        this.j = ((localDrawableBound.c + localDrawableBound.jdField_d_of_type_Int) / 2);
      }
      super.onDraw(paramCanvas);
    }
  }
  
  public void setIsSelect(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setIsSelect  : ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInjoyTabDragAnimationView", 4, ((StringBuilder)localObject).toString());
    this.jdField_d_of_type_Boolean = paramBoolean;
    localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInjoyTabDragAnimationView
 * JD-Core Version:    0.7.0.1
 */